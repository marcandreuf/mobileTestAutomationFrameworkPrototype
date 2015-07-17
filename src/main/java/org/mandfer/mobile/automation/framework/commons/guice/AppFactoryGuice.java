package org.mandfer.mobile.automation.framework.commons.guice;

import com.google.inject.Inject;
import org.mandfer.mobile.automation.framework.commons.app.App;
import org.mandfer.mobile.automation.framework.commons.app.MobileApp;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoader;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.exceptions.AppFactoryException;
import org.mandfer.mobile.automation.framework.commons.factory.Factory;
import org.mandfer.mobile.automation.framework.commons.factory.FactoryTestSupport;

import java.io.IOException;
import java.util.Properties;

/**
 * @author marcandreuf
 */
public class AppFactoryGuice implements AppFactory {

    private final ConfigLoader configLoader;
    private final Factory factory;

    @Inject
    public AppFactoryGuice(ConfigLoader configLoader, Factory factory) {
        this.configLoader = configLoader;
        this.factory = factory;
    }

    @Override
    public App create(String configFileName, Device device) throws AppFactoryException {
        try {
            Properties config = configLoader.loadConfig(configFileName);
            return new MobileApp(config, device, factory);
        } catch (IOException e) {
            throw new AppFactoryException("Unable to load "+configFileName
                    +". "+e.getMessage(), e);
        }
    }
}
