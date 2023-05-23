package userinyerface.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

public class MainPage extends Form {
    private IButton hideHelpFormButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'send')]"), "Hide help form button");
    private IButton acceptCookiesButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'transparent')]"), "Accept cookies button");
    private IButton upperHelpFormButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'close')]"), "Upper help form button");
    private ILabel timer = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"), "Timer");

    public MainPage() {
        super(By.xpath("//span[contains(@class,'terms')]"), "Main page");
    }

    public void clickOnHideHelpFormButton() {
        hideHelpFormButton.click();
    }

    public boolean acceptCookiesButtonIsDisplayed() {
        return acceptCookiesButton.state().isDisplayed();
    }

    public boolean upperHelpFormButtonIsNotDisplayed() {
        return upperHelpFormButton.state().waitForNotDisplayed(Duration.ofSeconds(15));
    }

    public void clickOnAcceptCookiesButton() {
        acceptCookiesButton.state().waitForClickable();
        acceptCookiesButton.click();
    }

    public String getTimerValue() {
        return timer.getText().substring(0, 5);
    }
}