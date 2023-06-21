package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
    }

    public void fillLoginForm(String email, String password) {

        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void fillLoginForm(User user) {

        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));

    }

    //    public boolean isLoggedSuccess() {
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.partialLinkText("success"))));
//        return (wd.findElement(By.partialLinkText("success")).getText().contains("success"));
//    }
    public void clickOkButton(){
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public void logout(){
        click(By.xpath("//a[.=' Logout ']"));
    }
}


