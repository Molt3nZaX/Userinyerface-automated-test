package userinyerface.utils;

import org.openqa.selenium.By;

public class ParameterizedXpathUtils {
    public static By getXpathForCheckbox(Integer index) {
        return By.xpath("//div[contains(@class,'list')][" + index.toString() + "]//span[contains(@class,'checkbox_')]");
    }
}