package pb_PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterNewUser {

	protected WebDriver driver;

	private By firtsnametxtbox = By.id("customer.firstName");
	private By lastnametxtbox = By.id("customer.lastName");
	private By addresstxtbox = By.id("customer.address.street");
	private By citytxtbox = By.id("customer.address.city");
	private By statetxtbox = By.id("customer.address.state");
	private By zipcodetxtbox = By.id("customer.address.zipCode");
	private By phonetxtbox = By.id("customer.phoneNumber");
	private By emailtxtbox = By.id("customer.ssn");
	private By usernametxtbox = By.id("customer.username");
	private By passwordtxtbox = By.id("customer.password");
	private By confirmpasswordtxtbox = By.id("repeatedPassword");
	private By registerbtn = By.xpath("//input[@value='Register']");
	private By CustomerUsername = By.xpath("//input[@name='username']");
	private By CustomerPassword = By.xpath("//input[@name='password']");
	private By loginbtn = By.xpath("//input[@value='Log In']");
	HashMap<String, String> userData;

	public RegisterNewUser(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> registerNewUser(String firstname, String lastname, String address, String city, String state,
			String zipcode, String phone, String ssn, String username, String password, String confirmpassword) throws InterruptedException {
		userData = new HashMap<>();
		
		driver.findElement(firtsnametxtbox).sendKeys(firstname);
		userData.put("FirstName", firstname);
		driver.findElement(lastnametxtbox).sendKeys(lastname);
		userData.put("LastName", lastname);
		driver.findElement(addresstxtbox).sendKeys(address);
		userData.put("Address", address);
		driver.findElement(citytxtbox).sendKeys(city);
		userData.put("City", city);
		driver.findElement(statetxtbox).sendKeys(state);
		userData.put("State", state);
		driver.findElement(zipcodetxtbox).sendKeys(zipcode);
		userData.put("ZipCode", zipcode);
		driver.findElement(phonetxtbox).sendKeys(phone);
		userData.put("Phone", phone);
		driver.findElement(emailtxtbox).sendKeys(ssn);
		userData.put("SSN", ssn);
		driver.findElement(usernametxtbox).sendKeys(username);
		userData.put("Username", username);
		driver.findElement(passwordtxtbox).sendKeys(password);
		userData.put("Password", password);
		driver.findElement(confirmpasswordtxtbox).sendKeys(confirmpassword);
		userData.put("ConfirmPassword", confirmpassword);
		Thread.sleep(5000); // Adding a brief pause to ensure all fields are populated before submission
		driver.findElement(registerbtn).submit();
		
		return userData;
	}

	public void confirmRegistration() throws InterruptedException {
		String customerUname = userData.get("Username");
		String customerPwd = userData.get("Password");
		System.out.println("Registered Username: "+customerUname);
		System.out.println("Password: "+customerPwd);
		driver.findElement(CustomerUsername).sendKeys(customerUname);
		driver.findElement(CustomerPassword).sendKeys(customerPwd);
		driver.findElement(loginbtn).click();
	//	String confirmationMessage = driver.findElement(By.xpath("//div[@id='rightPanel']//p[text()='Your account was created successfully. You are now logged in.']")).getText();
		Thread.sleep(2000);
		//return confirmationMessage;
		}
	
}
