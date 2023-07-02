package tests;

import manager.NgListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgListener.class)

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) app.getUser().logout();
    }

    @Test
    public void loginPositive() {
        String email = "d5otffg@gmail.com", password = "gh7899$!A2fgSrg";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitForm();
        app.getUser().pause(5000);
      //  Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[text()='Logged in']")));
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @Test
    public void loginPositiveUser() {
        User user = new User().withEmail("d5otffg@gmail.com").withPassword("gh7899$!A2fgSrg");
//        user.setName("John");
//        user.setLastName("Silver");

        app.getUser().openLoginForm();
     //    app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
        app.getUser().pause(5000);
      //  Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[text()='Logged in']")));
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }


    @Test
    public void loginNegativeWrongEmailUser() {
        User user = new User().withEmail("d5otffggmail.com").withPassword("gh7899$!A2fgSrg");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
 //       app.getUser().pause(7000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[.=\"It'snot look like email\"]")));


    }   @Test
    public void loginNegativeWrongPasswordUser() {
        User user = new User().withEmail("d5otffg@gmail.com").withPassword("gh7899A2fgSrg");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
       app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Login failed']")));

    }

//    @AfterMethod
//    public void postCondition() {
//        app.getUser().clickOkButton();
//    }
}
