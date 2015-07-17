package org.mandfer.mobile.automation.framework.commons.pageObject.pageElements;

import org.mandfer.mobile.automation.framework.commons.device.Device;

/**
 * @author marcandreuf
 */
public abstract class PageElement {

    protected final Device device;
    protected final String elemId;
    protected final String[] options;

    public PageElement(Device device, String elemId, String... options) {
        this.device = device;
        this.elemId = elemId;
        this.options = options;
    }

    public String getElemId() {
        return elemId;
    }

    public void click() {
        device.click(elemId, options);
    }

    public void click(String... options){
        device.click(elemId, options);
    }

    public boolean isVisible() {
        return device.isElementFound(elemId, options);
    }

    public boolean isEnabled() {
        String propValue = device.getElementProperty(elemId, "enabled", options);
        return Boolean.parseBoolean(propValue);
    }

    public void waitToAppear(int timeout) {
        device.waitToAppear(elemId, "{timeout:"+timeout+"}");
    }

    public void waitToVanish(int timeout) {
        device.waitToVanish(elemId, "{timeout:"+timeout+"}");
    }

    public void verify() {
        device.verify(elemId, options);
    }

    public String getText() {
        return device.getElementText(elemId, options);
    }

    public void drag(int xOffset, int yOffset) {
        device.drag(elemId, xOffset, yOffset, options);
    }

    public void swipe(String direction, int offset, int time) {
        device.swipeOnElement(elemId, direction, offset, time, options);
    }
}
