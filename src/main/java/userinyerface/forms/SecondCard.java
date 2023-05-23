package userinyerface.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.actions.JsActions;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import userinyerface.utils.ParameterizedXpathUtils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static userinyerface.utils.RandomTestDataUtils.ThreeRandomIndexForCheckbox;

public class SecondCard extends Form {
    private List<Integer> randomList = ThreeRandomIndexForCheckbox();
    private ICheckBox unselectAll = getElementFactory().getCheckBox(ParameterizedXpathUtils.getXpathForCheckbox(21), "Unselect All Checkbox");
    private ICheckBox firstRand = getElementFactory().getCheckBox(ParameterizedXpathUtils.getXpathForCheckbox(randomList.get(0)), "First random checkbox");
    private ICheckBox secondRand = getElementFactory().getCheckBox(ParameterizedXpathUtils.getXpathForCheckbox(randomList.get(1)), "Second random checkbox");
    private ICheckBox thirdRand = getElementFactory().getCheckBox(ParameterizedXpathUtils.getXpathForCheckbox(randomList.get(2)), "Third random checkbox");
    private IButton uploadButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'upload')]"), "Upload button");
    private IButton nextButton = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "Next button");

    public SecondCard() {
        super(By.xpath("//a[contains(@class,'upload')]"), "Second card form");
    }

    public void clickOnUploadButton() {
        uploadButton.click();
    }

    public void clickOnThreeCheckbox() {
        unselectAll.toggle();
        firstRand.toggle();
        secondRand.toggle();
        thirdRand.toggle();
    }

    public void clickOnNextButton() {
        JsActions jsActions = new JsActions(nextButton, "scrolling");
        jsActions.scrollToTheCenter();
        nextButton.clickAndWait();
    }

    public void SendPicture() {
        AqualityServices.getLogger().info("Upload picture on the site");
        File file = new File("src/test/resources/Koshi.jpg");
        StringSelection filePath = new StringSelection(file.getAbsolutePath());
        try {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.delay(500);
        } catch (AWTException e) {
            getLogger().error("Can't press buttons with Robot class");
            throw new RuntimeException(e);
        }
    }
}