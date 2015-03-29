package org.test.mobile.automation.framework.commons.driver;

/**
 * This is the main and only interface that operates with the physical device.
 *
 * @author marcandreuf
 */
public interface Driver {

    public static final int DEFAULT_CLICK = 1;
    public static final int DEFAULT_TIMEOUT = 5000;

    public void installApplication(String appIdentifier, String... options);
    public void unInstallApplication(String appIdentifier, String... options);

    public void launch(String appIdentifier, String... options);
    public void reLaunch(String deviceUrl, String activityIdentifier, String... options);
    public void closeApplication(String appIdentifier, String... options);


    public void click(String clickableItem, String... options);

    public void waitElemToAppear(String elemIdentifier, String... options);
    public void waitElemToVanish(String elemIdentifier, String... options);

    public String getElementText(String elemIdentifier, String... options);
    public String getElementHtmlContent(String elemIdentifier, String... options);
    public String getElementProperty(String elemIdentifier, String propertyIdentifier, String... options);

    public void verifyElementFound(String elemIdentifier, String... options);
    public void verifyElementNotFound(String elemIdentifier, String... options);
    public boolean isElementFound(String elemIdentifier, String... options);

    public void sendText(String text, String... options);
    public void sendTextTo(String elemIdentifier, String text, String... options);

    public void swipe(String direction, int offset, int time, String... options);
    public void swipeElement(String elemIdentifier, String direction, int offset, int time, String... options);
    public void dragElement(String elemIdentifier, int xOffset, int yOffset, String... options);

    public void runCommand(String command, String... options);

}
