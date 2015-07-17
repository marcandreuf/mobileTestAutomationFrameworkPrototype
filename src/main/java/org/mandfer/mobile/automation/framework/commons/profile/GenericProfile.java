package org.mandfer.mobile.automation.framework.commons.profile;

import java.util.Properties;

/**
 * @author marcandreuf
 */
public class GenericProfile implements Profile {
    public static final String NAME = "name";
    public static final String POSTCODE = "postCode";
    public static final String PASSWORD = "password";

    protected final Properties config;

    public GenericProfile(Properties configProfile){
        this.config = configProfile;
    }

    @Override
    public String getName() {
        return config.getProperty(NAME);
    }

    @Override
    public String getPostCode() {
        return config.getProperty(POSTCODE);
    }

    @Override
    public String getPassword()
    {
        return config.getProperty(PASSWORD);
    }
}
