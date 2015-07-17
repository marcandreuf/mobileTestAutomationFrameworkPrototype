package org.mandfer.mobile.automation.applications.sampleApp.pageObjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mandfer.mobile.automation.framework.commons.app.App;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.exceptions.PageObjectException;
import org.mandfer.mobile.automation.framework.commons.pageObject.PageObject;
import org.mandfer.mobile.automation.framework.commons.pageObject.pageElements.Button;
import org.mandfer.mobile.automation.framework.commons.pageObject.pageElements.DigitsKeyPad;
import org.mandfer.mobile.automation.framework.commons.pageObject.pageElements.InputField;
import org.mandfer.mobile.automation.framework.commons.pageObject.pageElements.Spinner;

/**
 * @author marcandreuf
 *
 * Example how to implement a page object. Other page objects of the application under test
 * could extend this template and add more page elements and page methods.
 */
public class PageObjectTemplate extends PageObject {

    protected Spinner spinner;
    protected Button btn_sampleButton;
    protected DigitsKeyPad com_keyPad;
    protected Logger logger = LoggerFactory.getLogger(PageObjectTemplate.class);

    public PageObjectTemplate(Device device, App app) {
        super(device, app);

        spinner = new Spinner(device, "id=spinner");
        btn_sampleButton = new Button(device, "id=sampleButton");
        com_keyPad = new DigitsKeyPad(device, "id=digitKeyPad");
    }

    @Override
    public boolean isActive() {
        try{
            verifyPageElements();
            return true;
        }catch (Throwable t){
            return false;
        }
    }

    @Override
    public PageObjectTemplate waitUntilLoaded() {
        logger.debug("Wait while spinner is on ...");
        spinner.waitToVanish(app.getTimeout());
        return this;
    }

    @Override
    public PageObjectTemplate verifyPageElements() {
        btn_sampleButton.verify();
        return this;
    }

    @Override
    public PageObjectTemplate getStubPage() {
        return new PageObjectTemplate(device, app){
            @Override
            public boolean isActive() {
                return false;
            }

            @Override
            public PageObjectTemplate waitUntilLoaded() {
                return null;
            }

            @Override
            public PageObjectTemplate verifyPageElements() {
                return null;
            }

            @Override
            public PageObjectTemplate getStubPage() {
                return null;
            }
        };
    }


    public void typeDigitsInto(InputField inputField, String text) throws PageObjectException {
        inputField.click();
        char[] digits = text.toCharArray();
        for(char c : digits) {
            com_keyPad.clickDigitKey(String.valueOf(c));
        }
    }
}
