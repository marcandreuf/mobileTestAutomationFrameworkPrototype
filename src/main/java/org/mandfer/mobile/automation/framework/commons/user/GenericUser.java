package org.mandfer.mobile.automation.framework.commons.user;

import java.util.Properties;

/**
 * 
 * @author marcandreuf
 */
public class GenericUser implements User {

    protected final Properties config;

    public GenericUser(Properties configProfile) {
        this.config = configProfile;
    }

    @Override
    public String getUserName() {
        return config.getProperty("username");
    }

    @Override
    public String getPass() {
        return config.getProperty("password");
    }
    
    @Override
    public String getTestData(String key) {
        return config.getProperty(key);
    }


}
