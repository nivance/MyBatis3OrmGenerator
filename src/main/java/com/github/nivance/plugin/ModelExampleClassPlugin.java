package com.github.nivance.plugin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class ModelExampleClassPlugin extends PluginAdapter {
    private final static Logger logger = LogManager.getLogger(ModelExampleClassPlugin.class);

    public ModelExampleClassPlugin() {
        super();
    }
    
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        logger.debug("------modelExampleClassGenerated------tablename[{}] classname[{}]", introspectedTable.getTableConfiguration().getTableName(), topLevelClass.getType().getFullyQualifiedName());
        Field field = new Field();
        field.setName("offset");
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setVisibility(JavaVisibility.PROTECTED);
        field.addJavaDocLine("/**");
        field.addJavaDocLine("* This method was generated by MyBatis Generator.");
        field.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        field.addJavaDocLine("*");
        DateFormat df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
        field.addJavaDocLine("* @generated " + df.format(new Date()));
        field.addJavaDocLine("*/");
        topLevelClass.addField(field);

        field = new Field();
        field.setName("limit");
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setVisibility(JavaVisibility.PROTECTED);
        field.addJavaDocLine("/**");
        field.addJavaDocLine("* This method was generated by MyBatis Generator.");
        field.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        field.addJavaDocLine("*");
        df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
        field.addJavaDocLine("* @generated " + df.format(new Date()));
        field.addJavaDocLine("*/");
        topLevelClass.addField(field);

        Method method = new Method();
        method.setName("setOffset");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "offset"));
        method.setReturnType(null);
        method.addBodyLine(" this.offset = offset;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*");
        df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
        method.addJavaDocLine("* @generated " + df.format(new Date()));
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        method = new Method();
        method.setName("getOffset");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.addBodyLine("  return offset;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*");
        df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
        method.addJavaDocLine("* @generated " + df.format(new Date()));
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        method = new Method();
        method.setName("setLimit");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "limit"));
        method.setReturnType(null);
        method.addBodyLine(" this.limit = limit;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*");
        df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
        method.addJavaDocLine("* @generated " + df.format(new Date()));
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        method = new Method();
        method.setName("getLimit");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.addBodyLine("  return limit;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*");
        df = new SimpleDateFormat("EEE MMM ww HH:mm:ss z yyyy", Locale.US);
        method.addJavaDocLine("* @generated " + df.format(new Date()));
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        field = new Field();
        field.setName("sumCol");
        field.setType(FullyQualifiedJavaType.getStringInstance());
        field.setVisibility(JavaVisibility.PROTECTED);
        field.addJavaDocLine("/**");
        field.addJavaDocLine("* This method was generated by MyBatis Generator.");
        field.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        field.addJavaDocLine("*/");
        topLevelClass.addField(field);

        method = new Method();
        method.setName("setSumCol");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "sumCol"));
        method.setReturnType(null);
        method.addBodyLine(" this.sumCol = sumCol;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        method = new Method();
        method.setName("getSumCol");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.addBodyLine("  return sumCol;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        field = new Field();
        field.setName("groupSelClause");
        field.setType(FullyQualifiedJavaType.getStringInstance());
        field.setVisibility(JavaVisibility.PROTECTED);
        field.addJavaDocLine("/**");
        field.addJavaDocLine("* This method was generated by MyBatis Generator.");
        field.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        field.addJavaDocLine("*/");
        topLevelClass.addField(field);

        method = new Method();
        method.setName("setGroupSelClause");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "groupSelClause"));
        method.setReturnType(null);
        method.addBodyLine(" this.groupSelClause = groupSelClause;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        method = new Method();
        method.setName("getGroupSelClause");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.addBodyLine("  return groupSelClause;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        field = new Field();
        field.setName("groupByClause");
        field.setType(FullyQualifiedJavaType.getStringInstance());
        field.setVisibility(JavaVisibility.PROTECTED);
        field.addJavaDocLine("/**");
        field.addJavaDocLine("* This method was generated by MyBatis Generator.");
        field.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        field.addJavaDocLine("*/");
        topLevelClass.addField(field);

        method = new Method();
        method.setName("setGroupByClause");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "groupByClause"));
        method.setReturnType(null);
        method.addBodyLine(" this.groupByClause = groupByClause;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        method = new Method();
        method.setName("getGroupByClause");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.addBodyLine("  return groupByClause;");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* This method was generated by MyBatis Generator.");
        method.addJavaDocLine("* This method corresponds to the database table "
                + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        method.addJavaDocLine("*/");
        topLevelClass.addMethod(method);

        List<Method> methods = topLevelClass.getMethods();
        for (Method mod : methods) {
            if (mod.getName().equals("clear")) {
                mod.addBodyLine("this.offset= 0;");
                mod.addBodyLine("this.limit= Integer.MAX_VALUE;");
                mod.addBodyLine("this.sumCol=null;");
                mod.addBodyLine("this.groupSelClause=null;");
                mod.addBodyLine("this.groupByClause=null;");
            }
            String examplename = introspectedTable.getExampleType().substring(
                introspectedTable.getExampleType().lastIndexOf(".") + 1);
            if (mod.getName().equals(examplename)) {
                mod.addBodyLine("offset = 0;");
                mod.addBodyLine("limit = Integer.MAX_VALUE;");
            }
        }
        return true;
    }
    
    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        logger.debug("------modelPrimaryKeyClassGenerated------tablename[{}] classname[{}]", introspectedTable.getTableConfiguration().getTableName(), topLevelClass.getType().getFullyQualifiedName());
        for (Field field : topLevelClass.getFields()) {
            field.addAnnotation("@NonNull");
        }
        topLevelClass.addImportedType("lombok.NonNull");
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        logger.debug("------modelBaseRecordClassGenerated------tablename[{}] classname[{}]", introspectedTable
                .getTableConfiguration().getTableName(), topLevelClass.getType().getFullyQualifiedName());
        StringBuffer sb = new StringBuffer();
        List<IntrospectedColumn> ics = introspectedTable.getAllColumns();
        for (IntrospectedColumn ic : ics) {
            String fieldName =
                    StringUtils.capitalize(tableField2JavaField(ic.getActualColumnName()));
            String getterName = "get" + fieldName;
            String andEqualTo = "and" + fieldName + "EqualTo";
            sb.append("\t\t\t\t").append("if(record." + getterName + "()!=null){").append("\n");
            sb.append("\t\t\t\t").append("criteria." + andEqualTo + "(record." + getterName + "());").append("\n");
            sb.append("\t\t\t\t").append("}").append("\n");
        }
        return true;
    }
    
    private String tableField2JavaField(String tableField) {
        StringBuilder sb = new StringBuilder();
        tableField = StringUtils.lowerCase(tableField);
        String[] ss = StringUtils.split(tableField, "_");
        sb.append(ss[0]);
        if (ss.length > 1) {
            for (int i = 1; i < ss.length; i++) {
                sb.append(StringUtils.capitalize(ss[i]));
            }
        }
        return sb.toString();
    }

    @Override
    public boolean validate(List<String> arg0) {
        logger.debug("-------------DaoExamplePlugin validate is ok.");
        return true;
    }

}
