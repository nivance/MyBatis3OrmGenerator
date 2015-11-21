package com.github.nivance.plugin;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class ModelProviderPlugin extends PluginAdapter {
    private final static Logger logger = LogManager.getLogger(ModelProviderPlugin.class);

    @Override
    public boolean providerGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // TODO providerGenerated
        // ----------------truncate provider---------------
        // String tableName = introspectedTable.getTableConfiguration().getTableName();
        // Method method = new Method();
        // method.setName("truncate");
        // method.setVisibility(JavaVisibility.PUBLIC);
        // method.setReturnType(null);
        // method.addBodyLine("return \"truncate "+tableName+"\";");
        // topLevelClass.addMethod(method);
        // ----------------truncate provider---------------
        return true;
    }

    @Override
    public boolean providerSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        String tablename = introspectedTable.getTableConfiguration().getTableName();
        String classname = topLevelClass.getType().getFullyQualifiedName();
        logger.debug("------providerSelectByExampleWithBLOBsMethodGenerated------tablename[{}] classname[{}]", tablename, classname);
        List<String> line = new ArrayList<String>();
        line.add("if(example != null){");
        line.add("return SQL().concat(\" limit \"+example.getOffset()+\",\"+example.getLimit());");
        line.add("}");
        int linesNumber = method.getBodyLines().size();
        method.addBodyLines(linesNumber - 1, line);
        logger.debug("------providerSelectByExampleWithBLOBsMethodGenerated------tablename[{}] classname[{}] bodylines[{}]", tablename, classname, method.getBodyLines());        
        return true;
    }

    @Override
    public boolean providerSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        String tablename = introspectedTable.getTableConfiguration().getTableName();
        String classname = topLevelClass.getType().getFullyQualifiedName();
        logger.debug("------providerSelectByExampleWithoutBLOBsMethodGenerated------tablename[{}] classname[{}]", tablename, classname);
        List<String> line = new ArrayList<String>();
        line.add("if(example != null){");
        line.add("return SQL().concat(\" limit \"+example.getOffset()+\",\"+example.getLimit());");
        line.add("}");
        int linesNumber = method.getBodyLines().size();
        method.addBodyLines(linesNumber - 1, line);
        logger.debug("------providerSelectByExampleWithoutBLOBsMethodGenerated------tablename[{}] classname[{}] bodylines[{}]", tablename, classname, method.getBodyLines());
        return true;
    }

    @Override
    public boolean validate(List<String> warnings) {
        logger.debug("-------------MySqlJavaPlugin validate is ok.");
        return true;
    }

}
