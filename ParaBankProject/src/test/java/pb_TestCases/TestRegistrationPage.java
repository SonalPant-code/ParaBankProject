package pb_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pb_BaseLibrary.BaseClass_pb;
import pb_PageObjects.HomePage;
import pb_PageObjects.RegistrationPage;

@Test
public class TestRegistrationPage extends BaseClass_pb {
	
	public void verifyRegistrationPageNavigation() {
	HomePage homePage = new HomePage(driver);
	homePage.navigateToRegistrationPage();
	RegistrationPage regisPage = new RegistrationPage(driver);
	String actualTitle= regisPage.isRegistrationPageDisplayed();
	String expectedTitle= "ParaBank | Register for Free Online Account Access";
	Assert.assertEquals(actualTitle, expectedTitle, "Navigation to Registration Page failed.");
	}
	

}
