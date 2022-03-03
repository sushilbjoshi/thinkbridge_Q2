package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import base.Base;
import pageClasses.LandingPageJavatalks;
import utilities.ReadExcel;

public class LandigPageTest extends Base {

	WebDriver driver;
	LandingPageJavatalks landingPage;

	@BeforeSuite
	public void launchBrowser() throws IOException {

		this.driver = getDriver();

	}

	@Test(priority = 1)
	public void dropdownTest() throws IOException {
		
		
		landingPage= new LandingPageJavatalks(driver);
		List<String> expected = Arrays.asList(ReadExcel.getData(0), ReadExcel.getData(1));
		ArrayList<String> actual = landingPage.getDropdownValues();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void emailTest() throws IOException {

		landingPage= new LandingPageJavatalks(driver);
		String msgText = landingPage.getStarted(ReadExcel.getData(2), ReadExcel.getData(4));
		Assert.assertEquals(msgText, ReadExcel.getData(5));

	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
