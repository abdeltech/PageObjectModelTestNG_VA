package test_Scenatios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Facebookpage;
import objects.GoogleSearchpage;

public class TestMethods_GoogleSearch {
	WebDriver driver;
	GoogleSearchpage objectrepo;
	Facebookpage Objectrepo2;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.get("https://www.google.com");	
	}
	
	@Test(priority=0)
	public void SearchOperation() throws InterruptedException {
		GoogleSearchpage page= new GoogleSearchpage(driver);
		page.searchgoogle("facebook");
		//Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void VerifyandAccessFacebook() {
		objectrepo=new GoogleSearchpage(driver);
		objectrepo.ClickFacebook();
		
	}
	
	@Test(priority=2)
	public void VerifyLogin() {
		Objectrepo2=new Facebookpage(driver);
		Objectrepo2.EnterUsername();
		Objectrepo2.EnterPassword();
		Objectrepo2.VerifyLogin();
	}
	
	
	@AfterTest
	public void aftertest() {
		driver.quit();
		
	}
	
	
	
}
