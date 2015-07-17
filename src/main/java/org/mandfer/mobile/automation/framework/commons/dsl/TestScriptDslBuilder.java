package org.mandfer.mobile.automation.framework.commons.dsl;

import java.io.IOException;
import org.mandfer.mobile.automation.framework.commons.app.InstalledApp;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoaderProperties;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.exceptions.AppLaunchException;
import org.mandfer.mobile.automation.framework.commons.exceptions.DeviceFactoryException;
import org.mandfer.mobile.automation.framework.commons.factory.FactoryTestSupport;
import org.mandfer.mobile.automation.framework.commons.user.User;

/**
 * @author marcandreuf
 */
public class TestScriptDslBuilder {

    private final Device device;

    private TestScriptDslBuilder(Device device) {
        this.device = device;
    }

    public static TestScriptDslBuilder on(Device device) {
        return new TestScriptDslBuilder(device);
    }

    public static Device device(String deviceConfigFileName) throws DeviceFactoryException {
        FactoryTestSupport factory = getFactoryBean();
        return factory.instantiateDeviceByClassName(deviceConfigFileName);
    }
    
    private static FactoryTestSupport getFactoryBean(){
        //TODO: Inject by DI
        return new FactoryTestSupport(new ConfigLoaderProperties());
    }

    public InstalledApp installApp(String applicationConfigFileName) throws AppLaunchException, Exception {
        FactoryTestSupport factory = getFactoryBean();
        return (InstalledApp) factory.instantiateApplicationByClassName(applicationConfigFileName, device);
    }
    
    public static User user(String userConfigFileName) throws IOException{
        FactoryTestSupport factory = getFactoryBean();
        return factory.getUser(userConfigFileName);
    }

}
