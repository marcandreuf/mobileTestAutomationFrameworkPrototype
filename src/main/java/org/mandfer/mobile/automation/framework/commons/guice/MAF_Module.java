package org.mandfer.mobile.automation.framework.commons.guice;

import com.google.inject.AbstractModule;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoader;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoaderProperties;
import org.mandfer.mobile.automation.framework.commons.factory.Factory;
import org.mandfer.mobile.automation.framework.commons.factory.FactoryTestSupport;

/**
 * @author marcandreuf
 */
public class MAF_Module extends AbstractModule {


    @Override
    protected void configure() {

        bind(ConfigLoader.class).to(ConfigLoaderProperties.class);

        bind(DriverFactory.class).to(DriverFactoryGuice.class);

        bind(DeviceFactory.class).to(DeviceFactoryGuice.class);

        bind(AppFactory.class).to(AppFactoryGuice.class);

        bind(ProfileFactory.class).to(ProfileFactoryGuice.class);

        bind(Factory.class).to(FactoryTestSupport.class);

        //TODO: Application

    }

}
