package pb_TestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import pb_BaseLibrary.BaseClass_pb;
import pb_PageObjects.HomePage;
import pb_PageObjects.RegisterNewUser;
import pb_Utils.RandomDataUtils;

@Test
public class TestRegisterNewUser extends BaseClass_pb {

	public void verifyRegisterNewUser() throws InterruptedException {

	
			HomePage homePage = new HomePage(driver);
			homePage.navigateToRegistrationPage();
		RegisterNewUser regisNewUser = new RegisterNewUser(driver);
		String fname = RandomDataUtils.randomAlphabets(7);
		String lname = RandomDataUtils.randomAlphabets(7);
		String address = RandomDataUtils.randomAlphabets(5);
		String city = RandomDataUtils.randomAlphabets(4);
		String state = RandomDataUtils.randomAlphabets(5);
		String zipcode = RandomDataUtils.randomNumbers(5);
		String phone = RandomDataUtils.randomAlphabets(10);
		String ssn = RandomDataUtils.randomAlphabets(5);
		String uname = RandomDataUtils.randomAlphabets(6);
		String password = RandomDataUtils.randomAlphabets(6);
		String confirmPassword = password;
		HashMap<String, String> expectedData = regisNewUser.registerNewUser(fname, lname, address, city, state, zipcode, phone, ssn, uname,password, confirmPassword);
		System.out.println("User Registered Successfully with username: " + expectedData.get("Username"));	
		System.out.println("Password: " + expectedData.get("Password"));
        Thread.sleep(3000);
		 regisNewUser.confirmRegistration();
//	    Assert.assertEquals(confirmationMsg, "Your account was created successfully. You are now logged in.", "Registration Failed: Confirmation message mismatch.");
	    								
	}
}
