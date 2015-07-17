package org.mandfer.mobile.automation.framework.commons.pageObject.pageElements;

import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.exceptions.PageObjectException;
import org.mandfer.mobile.automation.framework.commons.pageObject.pageElements.PageElement;

/**
 * @author marcandreuf
 */
public class DigitsKeyPad extends PageElement {

    public DigitsKeyPad(Device device, String elemId, String... options) {
        super(device, elemId, options);
    }

    public enum KEYPAD_DIGIT {
        ZERO(10), ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), NINE(8), DELETE(11);

        private final int index;

        KEYPAD_DIGIT(int index) {
            this.index = index;
        }

        public int getIndex(){return this.index;}

        public static KEYPAD_DIGIT getKeyByChar(String charDigit) throws PageObjectException {
            switch (charDigit){
                case "0": return ZERO;
                case "1": return ONE;
                case "2": return TWO;
                case "3": return THREE;
                case "4": return FOUR;
                case "5": return FIVE;
                case "6": return SIX;
                case "7": return SEVEN;
                case "8": return EIGHT;
                case "9": return NINE;
                case "D": return DELETE;
                default: throw new PageObjectException(charDigit+" is not a matching digit character.");
            }
        }
    }


    public void clickDeleteKey(){
        device.click(elemId, "delteKeyIdentifier");
    }

    public void clickDigitKey(KEYPAD_DIGIT key){
        device.waitToAppear(elemId, "digit identifier");
        device.click(elemId, "digit identifier");
    }

    public KEYPAD_DIGIT getDigit(String strDigit) throws PageObjectException {
        return KEYPAD_DIGIT.getKeyByChar(strDigit);
    }

    public void clickDigitKey(String key) throws PageObjectException {
        clickDigitKey(getDigit(key));
    }
}
