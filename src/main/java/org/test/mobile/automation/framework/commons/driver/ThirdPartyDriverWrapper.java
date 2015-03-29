package org.test.mobile.automation.framework.commons.driver;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;

import java.util.Map;
import java.util.Properties;

/**
 * @author marcandreuf
 */
public class ThirdPartyDriverWrapper implements Driver {

    private final Properties config;
    //TODO: Replace the ThirdPartyDriver for an actual driver.
	private final SampleThirdPartyDriver thirdPartyDriver;

    public static final String PARAM_CLICKS = "clicks";
    public static final String PARAM_TIMEOUT = "timeout";
    private int clicks = DEFAULT_CLICK;
    private int timeout = DEFAULT_TIMEOUT;

    
    @Inject
    public ThirdPartyDriverWrapper(Properties config){
        this.config = config;
        // TODO: Create a driver 
        this.thirdPartyDriver = null;
    }
    
    
    public ThirdPartyDriverWrapper(Properties config, SampleThirdPartyDriver thirdPartyDriver){
        this.config = config;
        this.thirdPartyDriver = thirdPartyDriver;
    }


    private void mapDriverSettingsValuesToMemberAttributes(String[] driverSettings) {
        JsonObject jsonOption;
        resetDefaultValues();
        for(String option : driverSettings){
            jsonOption = getJsonObject(option);
            loadEveryKeyValueOption(jsonOption);
        }
    }

    private void loadEveryKeyValueOption(JsonObject jsonOption) {
        String key;
        JsonElement value;
        for (Map.Entry<String, JsonElement> entry : jsonOption.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            setOptionValue(key, value);
        }
    }

    private void setOptionValue(String key, JsonElement value) {
        switch (key){
            case PARAM_CLICKS: clicks = value.getAsInt(); break;
            case PARAM_TIMEOUT: timeout = value.getAsInt(); break;
        }
    }


    private JsonObject getJsonObject(String jsonString) {
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }

    private void resetDefaultValues() {
        clicks = DEFAULT_CLICK;
        timeout = DEFAULT_TIMEOUT;
    }


    
    @Override
    public void installApplication(String appIdentifier, String... driverSettings) {
        mapDriverSettingsValuesToMemberAttributes(driverSettings);
        thirdPartyDriver.install(appIdentifier, timeout);
    }

    @Override
    public void click(String clickableItem, String... driverSettings) {
        mapDriverSettingsValuesToMemberAttributes(driverSettings);
        thirdPartyDriver.click(clickableItem, clicks);
    }

    @Override
    public void launch(String appIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void unInstallApplication(String appIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void closeApplication(String appIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void reLaunch(String deviceUrl, String activityIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void waitElemToAppear(String elemIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void waitElemToVanish(String elemIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public String getElementText(String elemIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
        return null;
    }

    @Override
    public String getElementHtmlContent(String elemIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
        return null;
    }

    @Override
    public String getElementProperty(String elemIdentifier, String propertyIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
        return null;
    }

    @Override
    public void verifyElementFound(String elemIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void verifyElementNotFound(String elemIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public boolean isElementFound(String elemIdentifier, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
        return false;
    }

    @Override
    public void sendText(String text, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void sendTextTo(String elemIdentifier, String text, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void swipe(String direction, int offset, int time, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void swipeElement(String elemIdentifier, String direction, int offset, int time, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void dragElement(String elemIdentifier, int xOffset, int yOffset, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }

    @Override
    public void runCommand(String command, String... driverSettings) {
        //TODO: Implement regarding the actual third party driver requirements.
    }
}
