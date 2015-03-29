package org.test.mobile.automation.framework.commons.dsl;

import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.device.Device;

/**
 * @author marcandreuf
 */
public class TestScript {

    //TODO It can ba a list of profiles;
    //protected final Profile mainProfile;
    
    protected final Device device;
    protected final App app;
    
    public TestScript(Device device, App app){
        this.device = device;
        this.app = app;
    }
    
    
    //TODO implement builder
    
    
    
}
