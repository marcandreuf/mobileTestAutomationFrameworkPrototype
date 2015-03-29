package org.test.mobile.automation.framework.commons.device;

import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.app.InstalledApp;
import org.test.mobile.automation.framework.commons.driver.Driver;
import org.test.mobile.automation.framework.commons.exceptions.DeviceException;

import java.io.IOException;
import java.net.URL;

/**
 * Top interface for any kind of device.
 *
 * @author marcandreuf
 */
public interface Device {

    public static enum PLATFORM {ANDROID, IOS}

    public static final String PROP_KEY_NAME = "name";
    public static final String PROP_KEY_PLATFORM = "platform";
    public static final String PROP_KEY_VERSION = "version";
    public static final String PROP_KEY_DEVICE_URL = "deviceUrl";

    public String getName();
    public PLATFORM getPlatform();
    public String getVersion();
    public String getDeviceUrl();

    public String getContentFromUrl(String url, String identifier) throws IOException;
    public String getHtmlFromUrl(URL testUrl) throws IOException;
    public void sendHttpRequest(String url) throws IOException, DeviceException;

    public InstalledApp installApp(App app, String... options);
    public Device launch(App app, String... options);
    public Device close(App app, String... options);

    public void click(String elemIdentifier, String... options);

    public void verify(String elemIdentifier, String... options);
    public void verifyNotFound(String elemIdentifier, String... options);
    public boolean isElementFound(String elemIdentifier, String... options);

    public void sendText(String text, String... options);
    public void sendTextTo(String elemIdentifier, String text, String... options);

    public void waitToAppear(String elemIdentifier, String... options);
    public void waitToVanish(String elemIdentifier, String... options);

    public String getElementText(String elemIdentifier, String... options);
    public String getElementProperty(String elemIdentifier, String propertyIdentifier, String... options);

    public String getPageTextContent();
    public String getTestData(String key);

    public void drag(String elemIdentifier, int xOffset, int yOffset, String... options);
    public void swipe(String direction, int offset, int timeout, String... options);
    public void swipeOnElement(String elemIdentifier, String direction, int offset, int timeout, String... options);


    /**
     * Use this method only for fast prove of concepts.!!
     */
    public Driver getDriver();
}
