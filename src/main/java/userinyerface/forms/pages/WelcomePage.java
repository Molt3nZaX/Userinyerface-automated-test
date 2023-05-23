package userinyerface.forms.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {
    private ILink hereLink = getElementFactory().getLink(By.xpath("//a[contains(@href,'game')]"), "\"HERE\" link");

    public WelcomePage() {
        super(By.xpath("//button[contains(@class,'start')]"), "Welcome Page");
    }

    public void clickOnHereLink() {
        hereLink.click();
    }
}