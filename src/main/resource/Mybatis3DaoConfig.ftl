<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
						http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd
						http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
						http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-4.0.xsd">

	<#list clazzinfos as clazzinfo>
	<bean id="${clazzinfo.domainObject}Mapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
		<property name="mapperInterface" value="${clazzinfo.packageName}.mapper.${clazzinfo.domainClass}Mapper" />
		<property name="sqlSessionFactory" ref="sqlSessionFactory" />
	</bean>
	</#list>
	
</beans>
