package org.mandfer.mobile.automation.framework.commons.pageObject.pageElements;

import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.pageObject.pageElements.PageElement;

/**
 * @author marcandreuf
 */
public class InputField extends PageElement {
    public InputField(Device device, String elemId, String... options) {
        super(device, elemId, options);
    }

    public void sendTextTo(String text) {
        device.sendTextTo(elemId, text, options);
    }
}
