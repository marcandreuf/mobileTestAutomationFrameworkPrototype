package org.mandfer.mobile.automation.framework.commons.app;

import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.factory.Factory;
import org.mandfer.mobile.automation.framework.commons.pageObject.PageObject;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 *
 * This is the main interpreter that performs all the operations of the Mobile Application.
 *
 * @author marcandreuf
 */
public class MobileApp implements App, InstalledApp {

    protected final Properties config;
    protected final Factory factory;
    protected final Device device;

    public MobileApp(Properties config, Device device, Factory factory) {
        this.config = config;
        this.device = device;
        this.factory = factory;
    }

    @Override
    public String getAppIdentifier() {
        return config.getProperty(PROP_KEY_APP_IDENTIFIER);
    }

    @Override
    public String getName() {
        return config.getProperty(PROP_KEY_APPLICATION_NAME);
    }

    @Override
    public String getAppFullPath() {
        return config.getProperty(PROP_KEY_PATH);
    }

    @Override
    public int getTimeout() {
        return Integer.valueOf(config.getProperty(PROP_KEY_TIMEOUT));
    }

    @Override
    public String getLiteral(String literalKey) {
        return config.getProperty(literalKey);
    }

    @Override
    public String getTestData(String testDataKey) {
        return config.getProperty(testDataKey);
    }

    @Override
    public List<String> getTestDataList(String testDataKey) {
        String[] arStrings = config.getProperty(testDataKey).split(",");
        return new ArrayList<>(Arrays.asList(arStrings));
    }

    @Override
    public String getReportPath() {
        return config.getProperty(PROP_KEY_REPORT_PATH);
    }

    @Override
    public <T extends PageObject> T launchTo(Class<T> pageObjectType) throws Exception {
        device.launch(this);
        return onPage(pageObjectType);
    }

    @Override
    public  <T extends PageObject> T onPage(Class<T> pageType) throws Exception {
        Constructor<T> constructor = pageType.getConstructor(Device.class, App.class);
        return constructor.newInstance(device, this);
    }

}
