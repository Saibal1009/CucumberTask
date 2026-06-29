package org.testkru.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testkru.pages.TextPage;
import org.testng.Assert;

public class TextPageStepDef {

    WebDriver driver;
    TextPage textPage;

    @Given("I am on the TestKru text fields page")
    public void i_am_on_the_test_kru_text_fields_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://testkru.com/Elements/TextFields");

        textPage = new TextPage(driver);

        Thread.sleep(3000);
        System.out.println("User is on TestKru Text Fields page");
    }

    @When("I enter first name as {string}")
    public void i_enter_first_name_as(String firstName) {
        textPage.enterFirstName(firstName);
        System.out.println("First name entered: " + firstName);
    }

    @When("I enter last name as {string}")
    public void i_enter_last_name_as(String lastName) {
        textPage.enterLastName(lastName);
        System.out.println("Last name entered: " + lastName);
    }

    @When("I enter text area value as {string}")
    public void i_enter_text_area_value_as(String textAreaValue) {
        textPage.enterTextAreaValue(textAreaValue);
        System.out.println("Textarea value entered: " + textAreaValue);
    }

    @Then("Uneditable field should contain value {string}")
    public void uneditable_field_should_contain_value(String expectedValue) {
        String actualValue = textPage.uneditableTextBox.getAttribute("value");

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Uneditable field value is incorrect"
        );

        System.out.println("Uneditable field is validated");
    }

    @Then("Disabled text field should be disabled")
    public void disabled_text_field_should_be_disabled() {
        Assert.assertFalse(
                textPage.disabledTextBox.isEnabled(),
                "Disabled text field is enabled"
        );

        System.out.println("Disabled text field is validated");
    }

    @Then("Invisible text field should not be displayed")
    public void invisible_text_field_should_not_be_displayed() {
        Assert.assertFalse(
                textPage.invisibleTextBox.isDisplayed(),
                "Invisible text field is displayed"
        );

        System.out.println("Invisible text field is validated");
    }

    @Then("Pre-filled text field should be displayed")
    public void pre_filled_text_field_should_be_displayed() {
        Assert.assertTrue(
                textPage.preFilledTextBox.isDisplayed(),
                "Pre-filled text field is not displayed"
        );

        System.out.println("Pre-filled text field is displayed");
    }

    @Then("Pre-filled text field should contain value {string}")
    public void pre_filled_text_field_should_contain_value(String expectedValue) {
        String actualValue = textPage.preFilledTextBox.getAttribute("value");

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Pre-filled text field value is incorrect"
        );

        System.out.println("Pre-filled text field value is validated");
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        driver.quit();
        System.out.println("Browser closed");
    }
}