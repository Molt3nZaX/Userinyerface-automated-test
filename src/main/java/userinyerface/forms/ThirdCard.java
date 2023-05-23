package userinyerface.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ThirdCard extends Form {
    public ThirdCard() {
        super(By.xpath("//div[@class='slider']"), "Third card form");
    }
}