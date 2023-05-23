package userinyerface.forms;

import aquality.selenium.elements.actions.JsActions;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import userinyerface.utils.RandomTestDataUtils;

public class FirstCard extends Form {
    private IButton dropDownOpenerButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'opener')]"), "Drop-down opener button");
    private IButton dotComButton = getElementFactory().getButton(By.xpath("//div[contains(text(),'.com')]"), "\".com\" button from Drop-down list");
    private IButton nextButton = getElementFactory().getButton(By.xpath("//a[text()='Next']"), "Next button");
    private ITextBox passwordTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "Password form");
    private ITextBox emailTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email form");
    private ITextBox domainTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain form");
    private ICheckBox termsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox')]"), "Terms & Conditions checkbox");

    public FirstCard() {
        super(By.xpath("//span[contains(@class, 'terms')]"), "First card form");
    }

    public void clickOnDropDownOpenerButton() {
        dropDownOpenerButton.click();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void fillForm() {
        deleteDataFromField(passwordTextBox);
        passwordTextBox.sendKeys(RandomTestDataUtils.generateRandomValidPassword());
        deleteDataFromField(emailTextBox);
        emailTextBox.sendKeys(RandomTestDataUtils.generateRandomEmail(5));
        deleteDataFromField(domainTextBox);
        domainTextBox.sendKeys(RandomTestDataUtils.generateRandomDomain(5));
    }

    public void scrollToDotComButtonAndClick() {
        JsActions actions = new JsActions(dotComButton, "scrolling");
        actions.scrollToTheCenter();
        dotComButton.click();
    }

    public void checkTermCheckbox() {
        termsCheckBox.check();
    }

    private void deleteDataFromField(IElement textBox) {
        textBox.sendKeys(Keys.CONTROL + "A");
        textBox.sendKeys(Keys.DELETE);
    }
}