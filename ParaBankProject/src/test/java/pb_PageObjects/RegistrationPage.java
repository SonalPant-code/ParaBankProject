package pb_PageObjects;

import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	protected WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		String actualTitle = driver.getTitle().trim().replaceAll("\\s+", " ");
		String expectedTitle = "ParaBank | Register for Free Online Account Access";
		
		if(!actualTitle.equals(expectedTitle))
		{
			System.out.println("Title mismatch!");
			throw new IllegalStateException("This is not Registration Page," + " current page is: " +driver.getTitle());
		}
	}

	public String isRegistrationPageDisplayed() {
		return driver.getTitle();
	}
	
	
}
