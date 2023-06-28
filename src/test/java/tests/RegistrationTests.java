package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
   @Test
   public void registrationPositive(){
      int i = (int)(System.currentTimeMillis()/1800)%3600;

      User user = new User()
              .withName("John")
              .withLastName("Snow")
              .withEmail("john"+i+"@gmail.com")
              .withPassword("SAfdghk@l123");

      app.getUser().openRegistrationForm();
      app.getUser().fillRegistrationForm(user);
      app.getUser().submitForm();
      logger.info("Registration test starts with data : " + user.getEmail()
              + " & " + user.getPassword());
      Assert.assertTrue(app.getUser().isRegistered());
   }
   @Test
   public void registrationNegativeWrongPassword(){
      int i = (int)(System.currentTimeMillis()/1800)%3600;

      User user = new User()
              .withName("John")
              .withLastName("Snow")
              .withEmail("john"+i+"@gmail.com")
              .withPassword("fdghkl123");

      app.getUser().openRegistrationForm();
      app.getUser().fillRegistrationForm(user);
      app.getUser().submitForm();

   }

}
