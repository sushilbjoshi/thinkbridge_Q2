package pageClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageJavatalks {

	@FindBy(id = "language")
	private WebElement dropdown;

	@FindBy(css = ".ui-select-choices-row-inner")
	private List<WebElement> dropdownValues;

	@FindBy(id = "name")
	private WebElement name;

	@FindBy(id = "orgName")
	private WebElement orgName;

	@FindBy(id = "singUpEmail")
	private WebElement singUpEmail;

	@FindBy(css = ".black-color.ng-binding")
	private WebElement checkbox;

	@FindBy(css = ".btn.btn-custom.btn-block.ng-binding")
	private WebElement button;

	@FindBy(xpath = "//span[contains(text(),'welcome email')]")
	private WebElement msg;

	WebDriver driver;

	public LandingPageJavatalks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver.get("https://jt-dev.azurewebsites.net/#/SignUp");

	}

	public String getStarted(String FullName, String email) {

		name.sendKeys(FullName);
		orgName.sendKeys(FullName);
		singUpEmail.sendKeys(email);
		checkbox.click();
		button.click();
		return msg.getText();

	}

	public ArrayList<String> getDropdownValues() {

		ArrayList<String> al = new ArrayList<String>();
		dropdown.click();
		Iterator<WebElement> it = dropdownValues.iterator();
		while (it.hasNext()) {
			al.add(it.next().getText());
		}

		return al;

	}

}
