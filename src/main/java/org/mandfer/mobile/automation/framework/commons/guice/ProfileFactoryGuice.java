package org.mandfer.mobile.automation.framework.commons.guice;

import com.google.inject.Inject;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoader;
import org.mandfer.mobile.automation.framework.commons.exceptions.ProfileFactoryException;
import org.mandfer.mobile.automation.framework.commons.profile.GenericProfile;
import org.mandfer.mobile.automation.framework.commons.profile.Profile;

import java.io.IOException;
import java.util.Properties;

/**
 * @author marcandreuf
 */
public class ProfileFactoryGuice implements ProfileFactory {

    private final ConfigLoader configLoader;

    @Inject
    public ProfileFactoryGuice(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    @Override
    public Profile create(String configFileName) throws ProfileFactoryException {
        try {
            Properties config = configLoader.loadConfig(configFileName);
            return new GenericProfile(config);
        } catch (IOException e) {
            throw new ProfileFactoryException("Unable to load "+configFileName
                    +". "+e.getMessage(), e);
        }
    }
}
