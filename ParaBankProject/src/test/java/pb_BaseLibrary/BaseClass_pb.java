package pb_BaseLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass_pb {
	
	protected WebDriver driver;
	protected Properties prop = new Properties();
	
	@BeforeClass
	public void launchBrowser() throws Exception
	{
		readPropertiesFile("pb_global.properties");
		// Add browser launch logic here based on prop values
		String browserType = prop.getProperty("browsertype").toLowerCase();
		String environment = prop.getProperty("environment").toLowerCase();
		
		//Launch environment specific properties
		switch (environment) {
		case "qa":
			readPropertiesFile("pb_qa.properties");
			break;	
		case "dev":
			readPropertiesFile("pb_dev.properties");
			break;
		
		default: new IllegalArgumentException("Unsupported environment: "+environment);
		}
	
		//Launch Browser based on browser type.
		switch(browserType) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			 driver = new FirefoxDriver();
			break;		
		default: new IllegalArgumentException("Unsupported browser: "+browserType);
		}
		
		LaunchApplication(prop.getProperty("url"));
	}
	
	public void readPropertiesFile(String filename) throws Exception
    {
        String filepath = System.getProperty("user.dir") +"/config/" + filename;
        File file = new File(filepath);
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
    }

	public void LaunchApplication(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
}
	
//	@SuppressWarnings("deprecation")
//	@AfterClass
//	public void tearDown() throws Exception
//	{
//		driver.close();
//		Runtime.getRuntime().exec("taskkill /F /IM chromeDriver.exe");
//		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
//	}
}
