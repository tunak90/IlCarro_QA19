package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillLoginForm(String email, String password) {

        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void fillLoginForm(User user) {

        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    public void fillRegistrationForm(User user) {

        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        checkBoxClick();

    }

    public void checkBoxClick() {
        //variant1
 //       click(By.cssSelector("label[for='terms-of-use']"));
        //variant2
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click()");
//        //variant3
//
        Rectangle rect = wd.findElement(By.cssSelector(".checkbox-container")).getRect();
        int x = rect.getX() + 5;
        int y = rect.getY() + rect.getHeight() / 4;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x,y).click().perform();
    }


    public void submitForm() {
        click(By.xpath("//button[@type='submit']"));

    }

        public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return (wd.findElement(By.cssSelector(".dialog-container")).getText().contains("success"));
    }
    public boolean isRegistered() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return (wd.findElement(By.cssSelector(".dialog-container")).getText().contains("Registered"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[.=' Logout ']"));
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();


    }
}


