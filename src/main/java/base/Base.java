package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ReadProperties;

public class Base {

	public WebDriver driver;

	public WebDriver getDriver() throws IOException {
		this.driver=initDriver(ReadProperties.getPropValue("browser"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver initDriver(String browserName) throws IOException {

		if ("chrome".equalsIgnoreCase(browserName)) {
			
			String chromedriverpath = System.getProperty("user.dir") + ReadProperties.getPropValue("chromedriverpath");
			System.setProperty("webdriver.chrome.driver",chromedriverpath);
			return driver = new ChromeDriver();

		}
		if ("firefox".equalsIgnoreCase(browserName)) {

			String geckodriverpath = System.getProperty("user.dir") + ReadProperties.getPropValue("geckodriverpath");
			System.setProperty("webdriver.gecko.driver",geckodriverpath );
			return driver = new FirefoxDriver();

		} else {
			
			String path = System.getProperty("user.dir") + ReadProperties.getPropValue("chromedriverpath");
			System.setProperty("webdriver.chrome.driver",path);
			return driver = new ChromeDriver();
		}
		

	}

}
