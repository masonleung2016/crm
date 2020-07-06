package com.ufostudio.crm.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderSupport;

import java.io.IOException;
import java.util.*;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:56
 * @Package: com.ufostudio.crm.common.utils
 */

public class ApplicationPropertiesFactoryBean extends PropertiesLoaderSupport
        implements FactoryBean<Properties>, InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(ApplicationPropertiesFactoryBean.class);
    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    private String propertiesListLocation = "classpath:/properties.lst";
    private Properties properties;

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws IOException {
        // 判断加载哪些properties
        this.readProperties();
        // 默认设置找不到资源也不会报错
        this.setIgnoreResourceNotFound(true);
        // 加载properties
        this.properties = mergeProperties();
    }

    @Override
    public Properties getObject() throws IOException {
        return properties;
    }

    @Override
    public Class<Properties> getObjectType() {
        return Properties.class;
    }

    protected void readProperties() throws IOException {
        Resource propertiesListResource = resourceLoader.getResource(propertiesListLocation);
        List<Resource> resources = new ArrayList<Resource>();

        if (!propertiesListResource.exists()) {
            logger.info("use default properties");
            resources.add(resourceLoader.getResource("classpath:/application.properties"));
            resources.add(resourceLoader.getResource("classpath:/application.local.properties"));
            resources.add(resourceLoader.getResource("classpath:/application.server.properties"));
        } else {
            String text = IoUtils.readString(propertiesListResource);

            for (String str : text.split("\n")) {
                str = str.trim();

                if (str.length() == 0) {
                    continue;
                }

                resources.add(resourceLoader.getResource(str));
            }
        }

        setLocations(resources.toArray(new Resource[0]));
    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        for (String key : properties.stringPropertyNames()) {
            map.put(key, properties.get(key));
        }

        return map;
    }

    public String getPropertiesListLocation() {
        return propertiesListLocation;
    }

    public void setPropertiesListLocation(String propertiesListLocation) {
        this.propertiesListLocation = propertiesListLocation;
    }
}
