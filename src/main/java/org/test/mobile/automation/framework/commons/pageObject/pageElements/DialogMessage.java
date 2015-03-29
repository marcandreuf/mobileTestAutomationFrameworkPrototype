package org.test.mobile.automation.framework.commons.pageObject.pageElements;

import org.test.mobile.automation.framework.commons.device.Device;

/**
 * @author marcandreuf
 */
public class DialogMessage extends PageElement {

    protected Button btn_Ok;

    public DialogMessage(Device device, String elemId, String... options) {
        super(device, elemId, options);
    }

    public void clickOkButton() {
        btn_Ok.click();
    }
}
