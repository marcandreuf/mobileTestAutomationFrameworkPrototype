package org.mandfer.mobile.automation.framework.commons.driver;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;

import java.util.Map;
import java.util.Properties;

/**
 * @author marcandreuf
 */
public abstract class DriverWrapper implements Driver {

    public static final String PARAM_CLICKS = "clicks";
    public static final String PARAM_TIMEOUT = "timeout";
    
    protected int clicks = DEFAULT_CLICK;
    protected int timeout = DEFAULT_TIMEOUT;
    protected Properties config;


    public DriverWrapper(Properties config){
        this.config = config;
    }

    protected void mapDriverSettingsValuesToMemberAttributes(String[] driverSettings) {
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
        
        //TODO: dynamic loading using reflection ...
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

    
//    @Override
//    public void installApplication(String appIdentifier, String... driverSettings) {
//        mapDriverSettingsValuesToMemberAttributes(driverSettings);
//        thirdPartyDriver.install(appIdentifier, timeout);
//    }
//
//    @Override
//    public void click(String clickableItem, String... driverSettings) {
//        mapDriverSettingsValuesToMemberAttributes(driverSettings);
//        thirdPartyDriver.click(clickableItem, clicks);
//    }

}
