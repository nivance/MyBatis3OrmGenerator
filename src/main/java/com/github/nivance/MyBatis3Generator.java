package com.github.nivance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.github.nivance.plugin.ClassInfo;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class MyBatis3Generator {
    private final static Logger logger = LogManager.getLogger(MyBatis3Generator.class);
    public static String basePackage = "com.baidu";
    public static String sourcePath = "src/main/resource";
    public static String targetPath = "src/gens/java";

    public static void main(String[] args) throws Exception {
        logger.debug("--------------------start to generate MyBatis3 files--------------------");
        String xmlName = "generator-config.xml";
        generateMyBatis(xmlName, sourcePath, basePackage);
        logger.debug("--------------------end generate MyBatis3 files--------------------");
    }

    public static void generateMyBatis(String xmlName, String sourcePath, String basePackage) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(MyBatis3Generator.class.getClassLoader().getResourceAsStream(xmlName));
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            myBatisGenerator.generate(null);
            List<Context> configs = config.getContexts();
            List<ClassInfo> clazzinfos = new ArrayList<ClassInfo>();
            for (Context context : configs) {
                String targetProject = context.getJavaModelGeneratorConfiguration().getTargetProject(); 
                targetPath = StringUtils.isNotBlank(targetProject) ? targetProject : targetPath;
                logger.debug("targetPath [{}] basePackage [{}] sourcePath [{}]", targetPath, basePackage, sourcePath);
                collectClassInfo(context, clazzinfos);
            }
            genDaoSpringConfig(clazzinfos, sourcePath, "Mybatis3DaoConfig.ftl", new File(targetPath));
        } catch (InvalidConfigurationException e) {
            logger.error("", e);
            throw e;
        }
    }

    private static void collectClassInfo(Context config, List<ClassInfo> clazzinfos) {
        String daoTargetSource = config.getJavaClientGeneratorConfiguration().getTargetPackage();
        List<TableConfiguration> list = config.getTableConfigurations();
        for (TableConfiguration table : list) {
            ClassInfo classinfo = new ClassInfo();
            classinfo.setDomainClass(table.getDomainObjectName());
            classinfo.setDomainObject(StringUtils.uncapitalize(table.getDomainObjectName()));
            classinfo.setPackageName(StringUtils.substringBeforeLast(daoTargetSource, "."));
            classinfo.setTablename(table.getTableName().toUpperCase());
            clazzinfos.add(classinfo);
        }
    }

    public static void genDaoSpringConfig(List<ClassInfo> clazzinfos, String sourcePath, String tmplname, File daoDir) {
        try {
            freemarker.template.Configuration cfg = new freemarker.template.Configuration();
            cfg.setDirectoryForTemplateLoading(new File(sourcePath));
            DefaultObjectWrapper ow = new DefaultObjectWrapper();
            cfg.setObjectWrapper(ow);
            Template temp = cfg.getTemplate(tmplname);
            /* Create a data-model */
            Map<String, Object> root = new HashMap<String, Object>();
            root.put("clazzinfos", clazzinfos);
            File dst = new File(daoDir, "application-dao.xml");
            logger.debug("-------dao filepath[{}]", dst.getAbsolutePath());
            dst.getParentFile().mkdirs();
            FileOutputStream fout = new FileOutputStream(dst);
            Writer out = new OutputStreamWriter(fout);
            temp.process(root, out);
            out.flush();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
