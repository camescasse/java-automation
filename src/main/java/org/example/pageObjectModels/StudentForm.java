package org.example.pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StudentForm extends PageObject {

    public StudentForm(WebDriver driver) {
        super(driver);
    }

    public StudentForm open() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(500);

        return this;
    }

    public StudentForm setName(String firstName, String lastName) {
        var inputFirstName = driver.findElement(By.id("firstName"));
        inputFirstName.sendKeys(firstName);

        var inputLastName = driver.findElement(By.id("lastName"));
        inputLastName.sendKeys(lastName);

        return this;
    }

    public StudentForm setGender(String gender) {
        var radioGender = driver.findElement(By.xpath("//label[text()=\"" + gender + "\"]/.."));
        radioGender.click();

        return this;
    }

    public StudentForm setMobile(String mobile) {
        var inputMobile = driver.findElement(By.id("userNumber"));
        inputMobile.sendKeys(mobile);

        return this;
    }

    public void submit() {
        var buttonSubmit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        buttonSubmit.click();
    }

}
