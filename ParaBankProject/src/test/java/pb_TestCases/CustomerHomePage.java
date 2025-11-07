package pb_TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class represents the Customer Home Page after successful registration.
 */
public class CustomerHomePage {
	
	protected WebDriver driver;
	
	public CustomerHomePage(WebDriver driver) {
		this.driver = driver;
		String actualTitle = driver.getTitle().trim().replaceAll("\\s+", " ");
		String expectedTitle = "ParaBank | Customer Created";

		if (!actualTitle.equals(expectedTitle)) {
			System.out.println("Title mismatch!");
			throw new IllegalStateException(
					"This is not Customer Home Page," + " current page is: " + driver.getTitle());
		}
	}
	
	public String confirmRegistration() throws InterruptedException {
//		String customerUname = userData.get("Username");
//		String customerPwd = userData.get("Password");
//		System.out.println("Registered Username: "+customerUname);
//		System.out.println("Password: "+customerPwd);
//		driver.findElement(CustomerUsername).sendKeys(customerUname);
//		driver.findElement(CustomerPassword).sendKeys(customerPwd);
//		driver.findElement(loginbtn).click();
		By Message = By.xpath("//div[@id='rightPanel']//p[text()='Your account was created successfully. You are now logged in.']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Message));
		String confirmationMessage = driver.findElement(Message).getText();
		return confirmationMessage;
		}

}
