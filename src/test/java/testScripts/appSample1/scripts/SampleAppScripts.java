package testScripts.appSample1.scripts;

import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.dsl.TestScript;

/**
 *
 * @author marcandreuf
 */
public class SampleAppScripts {    
    
   class SampleTest1 extends TestScript implements Runnable{        
            
        public SampleTest1(Device device, App app){
            super(device, app);           
        }

        @Override
        public void run() {
            
//            device
//              .installApp(app)
//              .launchTo(LoginPage.class)
//              .typeUser(profile.getUserName())
//              .typePass(profile.getPassword())
//              .clickLoginButton();
//            
//            onPage(AppPage1.class)
//              .waitWhileLoading()
//              .verifyPage()
//              .click(SampleApp.MainMenu.Option1)
//              .verify(Popup.SampleMessage1);
              
            
        }
        
    }
    
}
