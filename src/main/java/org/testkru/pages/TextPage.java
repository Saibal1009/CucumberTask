package org.testkru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class TextPage {

    private WebDriver driver;

    public TextPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='pt-1 pb-1 pr-2 pl-2']")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastNameWithPlaceholder")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//textarea[@class='pt-1 pb-1 pr-2 pl-2']")
    public WebElement textArea;

    @FindBy(id = "uneditable")
    public WebElement uneditableTextBox;

    @FindBy(id = "disabledField")
    public WebElement disabledTextBox;

    @FindBy(id = "invisibleField")
    public WebElement invisibleTextBox;

    @FindBy(id = "preFilledTextField")
    public WebElement preFilledTextBox;

    public void openTextFieldsPage() {
        driver.get("https://testkru.com/Elements/TextFields");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void enterFirstName(String firstName) {
        firstNameTextBox.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameTextBox.sendKeys(lastName);
    }

    public void enterTextAreaValue(String value) {
        textArea.sendKeys(value);
    }

    public void validateUneditableTextBox() {
        String text = uneditableTextBox.getAttribute("value");

        if (text.equalsIgnoreCase("Codekru")) {
            System.out.println("The uneditable field is validated");
        } else {
            System.out.println("The field is not validated");
        }
    }

    public void validateDisabledTextBox() {
        if (!disabledTextBox.isEnabled()) {
            System.out.println("Disabled textbox is validated");
        } else {
            System.out.println("Disabled textbox is not validated");
        }
    }

    public void validateInvisibleTextBox() {
        if (!invisibleTextBox.isDisplayed()) {
            System.out.println("Invisible text box is validated");
        } else {
            System.out.println("Invisible text box is visible - not validated");
        }
    }

    public void validatePreFilledTextBoxDisplayed() {
        if (preFilledTextBox.isDisplayed()) {
            System.out.println("Pre-filled text field is displayed");
        } else {
            System.out.println("Pre-filled text field is not displayed");
        }
    }

    public void validatePreFilledDefaultValue() {
        String value = preFilledTextBox.getAttribute("value");

        if (value.equals("Codekru")) {
            System.out.println("Default value is validated");
        } else {
            System.out.println("Default value is not validated");
        }
    }
}