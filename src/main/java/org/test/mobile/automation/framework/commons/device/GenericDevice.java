package org.test.mobile.automation.framework.commons.device;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.app.InstalledApp;
import org.test.mobile.automation.framework.commons.driver.Driver;
import org.test.mobile.automation.framework.commons.exceptions.DeviceException;


/**
 * This is the generic abstraction of any kind of device with all common functionality.
 *
 * @author marcandreuf
 *
 */
public abstract class GenericDevice implements Device {

    public static final String DEFAULT_CHARSET = "UTF-8";

    protected final Properties config;
    protected final Driver driver;

    public GenericDevice(Properties configDevice, Driver driver) {
        this.config = configDevice;
        this.driver = driver;
    }

    @Override
    public Driver getDriver(){
      return this.driver;
    }    
    
    @Override
    public String getName() {
        return getPropValue(PROP_KEY_NAME);
    }

    private String getPropValue(String propKey) {
        return this.config.getProperty(propKey);
    }

    @Override
    public PLATFORM getPlatform() {
        return PLATFORM.valueOf(getPropValue(PROP_KEY_PLATFORM).toUpperCase());
    }

    @Override
    public String getVersion() {
        return getPropValue(PROP_KEY_VERSION);
    }

    @Override
    public String getDeviceUrl() {
        return getPropValue(PROP_KEY_DEVICE_URL);
    }

    @Override
    public InstalledApp installApp(App app, String... options) {
        driver.installApplication(app.getAppIdentifier());
        return (InstalledApp) app;
    }

    @Override
    public Device launch(App app, String... options) {
        driver.launch(app.getAppIdentifier());
        return this;
    }

    @Override
    public Device close(App app, String... options) {
        driver.closeApplication(app.getAppIdentifier());
        return this;
    }

    @Override
    public String getContentFromUrl(String url, String identifier) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements result = doc.select(identifier);
        return result.text();
    }

    @Override
    public String getHtmlFromUrl(URL url) throws IOException {
        return IOUtils.toString(url, DEFAULT_CHARSET);
    }

    @Override
    public void sendHttpRequest(String url) throws IOException, DeviceException {
        try {
            Connection.Response response = Jsoup.connect(url).execute();
            if (response.statusCode() != HttpURLConnection.HTTP_OK) {
                throw new DeviceException( response.statusCode() + ": " + response.statusMessage());
            }
        }catch (Exception e){
            throw new DeviceException(e.getMessage());
        }
    }

    @Override
    public void click(String identifier, String... options) {
        driver.click(identifier, options);
    }

    @Override
    public void verify(String identifier, String... options) {
        driver.verifyElementFound(identifier, options);
    }

    @Override
    public void verifyNotFound(String identifier, String... options) {
        driver.verifyElementNotFound(identifier, options);
    }

    @Override
    public boolean isElementFound(String identifier, String... options) {
        return driver.isElementFound(identifier, options);
    }

    @Override
    public void sendText(String text, String... options) {
        driver.sendText(text, options);
    }

    @Override
    public void sendTextTo(String identifier, String text, String... options) {
        driver.sendTextTo(identifier, text, options);
    }

    @Override
    public void waitToAppear(String identifier, String... options) {
        driver.waitElemToAppear(identifier, options);
    }

    @Override
    public void waitToVanish(String identifier, String... options) {
        driver.waitElemToVanish(identifier, options);
    }

    @Override
    public String getElementText(String identifier, String... options) {
        return driver.getElementText(identifier, options);
    }

    @Override
    public String getElementProperty(String identifier, String propertyIdentifier, String... options) {
        return driver.getElementProperty(identifier, propertyIdentifier, options);
    }

    @Override
    public String getPageTextContent() {
        return driver.getElementHtmlContent("");
    }

    @Override
    public String getTestData(String key) {
        return config.getProperty(key);
    }

    @Override
    public void drag(String identifier, int xOffset, int yOffset, String... options) {
        driver.dragElement(identifier, xOffset, yOffset, options);
    }

    @Override
    public void swipe(String direction, int offset, int timeout, String... options) {
        driver.swipe(direction, offset, timeout, options);
    }

    @Override
    public void swipeOnElement(String identifier, String direction, int offset, int timeout, String... options) {
        driver.swipeElement(identifier, direction, offset, timeout, options);
    }
}
