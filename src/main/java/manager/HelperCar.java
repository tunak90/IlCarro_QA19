package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase {

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(5000);
        click(By.id("1"));
    }

    public boolean isCarFormPresent() {
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(
                                wd.findElement(By.cssSelector("h1")), "Let the car work"
                        ));

    }

    public void fillCarForm(Car car) {
        if (isCarFormPresent() == false) return;
        typeLocation(car.getLocation());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
        // type(By.id("serialNumber"), car.getCarRegNumber());
        inputCarRegNumber(car);
        type(By.id("price"), car.getPrice());


    }

    private void inputCarRegNumber(Car car) {
        Rectangle rect = wd.findElement(By.xpath("//input[@id='serialNumber']")).getRect();
       int x = rect.getX() + (rect.getWidth() - rect.getWidth() / 6);
//        int x = rect.getX() + 350;
        int y = rect.getY() +( rect.getHeight() - rect.getHeight() / 6);
 //       int y = rect.getY() + rect.getHeight() /3;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x, y).click().sendKeys(car.getCarRegNumber()).perform();
    }

    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
    }

    public void select(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);
    }


    public void submit() {
        click(By.xpath("//*[text()='submit']"));
    }
}
