package com.ufostudio.crm.common.config;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:31
 * @Package: com.ufostudio.crm.common.config
 */

public class MyBatisGen {

    public static void main(String[] args) throws Exception {
        
        String fileName = "generatorConfig.xml";
        
        File configFile = new File(fileName);
        
        List<String> warnings = new ArrayList<String>();
        
        boolean overwrite = true;
        
        ConfigurationParser cp = new ConfigurationParser(warnings);
        
        Configuration config = cp.parseConfiguration(configFile);
        
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        
        myBatisGenerator.generate(null);
    }
}
