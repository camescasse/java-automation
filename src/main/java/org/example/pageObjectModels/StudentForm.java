package org.example.pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class StudentForm extends PageObject {

    private final String url;

    @FindBy(id = "firstName")
    private WebElement inputFirstName;

    @FindBy(id = "lastName")
    private WebElement inputLastName;

    @FindBy(id = "userNumber")
    private WebElement inputMobile;

    @FindBy(id = "submit")
    private WebElement buttonSubmit;

    public StudentForm(WebDriver driver) {
        super(driver);
        this.url = host + "/automation-practice-form";
    }

    public StudentForm open() {
        driver.get(url);

        return this;
    }

    public StudentForm setName(String firstName, String lastName) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);

        return this;
    }

    public StudentForm setGender(String gender) {
        var radioGender = driver.findElement(By.xpath("//label[text()=\"" + gender + "\"]/.."));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioGender);
        radioGender.click();

        return this;
    }

    public StudentForm setMobile(String mobile) {
        inputMobile.sendKeys(mobile);

        return this;
    }

    public void submit() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        buttonSubmit.click();
    }

}
