package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegistrationPage {
	private static WebDriver driver;
	private static Properties locators;
	private WebDriverWait waiter;

	public RegistrationPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}
	
	//Enter ID
	public static WebElement getUserID() {
		return driver.findElement(By.xpath(locators.getProperty("user_id")));
	}

	public static void setUserID(String userId) {
		getUserID().clear();
		getUserID().sendKeys(userId);
	}
	
	//Enter password
	public static WebElement getNewPassword() {
		return driver.findElement(By.xpath(locators.getProperty("new_password")));
	}

	public static WebElement getRepeatPassword() {
		return driver.findElement(By.xpath(locators.getProperty("repeat_password")));
	}

	public static void setAllPass(String password) {
		getNewPassword().clear();
		getNewPassword().sendKeys(password);
		getRepeatPassword().clear();
		getRepeatPassword().sendKeys(password);
	}
	
	//Enter first name
	public static WebElement getFirstName() {
		return driver.findElement(By.xpath(locators.getProperty("first_name")));
	}

	public static void setFirstName(String firstName) {
		getFirstName().clear();
		getFirstName().sendKeys(firstName);
	}
	
	//Enter last name
	public static WebElement getLastName() {
		return driver.findElement(By.xpath(locators.getProperty("last_name")));
	}

	public static void setLastName(String lastName) {
		getLastName().clear();
		getLastName().sendKeys(lastName);
	}
	
	//Enter email

	public static WebElement getEmail() {
		return driver.findElement(By.xpath(locators.getProperty("email")));
	}

	public static void setEmail(String email) {
		getEmail().clear();
		getEmail().sendKeys(email);
	}

	//Enter phone
	public static WebElement getPhone() {
		return driver.findElement(By.xpath(locators.getProperty("phone")));
	}

	public static void setPhone(String phone) {
		getPhone().clear();
		getPhone().sendKeys(phone);
	}

	//Enter address1
	public static WebElement getAddress1() {
		return driver.findElement(By.xpath(locators.getProperty("address1")));
	}

	public static void setAddress1(String address1) {
		getAddress1().clear();
		getAddress1().sendKeys(address1);
	}

	//Enter address2
	public static WebElement getAddress2() {
		return driver.findElement(By.xpath(locators.getProperty("address2")));
	}

	public static void setAddress2(String address2) {
		getAddress2().clear();
		getAddress2().sendKeys(address2);
	}

	//Enter city
	public static WebElement getCity() {
		return driver.findElement(By.xpath(locators.getProperty("city")));
	}

	public static void setCity(String city) {
		getCity().clear();
		getCity().sendKeys(city);
	}
	
	//Enter state
	public static WebElement getState() {
		return driver.findElement(By.xpath(locators.getProperty("state")));
	}

	public static void setState(String state) {
		getState().clear();
		getState().sendKeys(state);
	}

	//Enter zip
	public static WebElement getZip() {
		return driver.findElement(By.xpath(locators.getProperty("zip")));
	}

	public static void setZip(String zip) {
		getZip().clear();
		getZip().sendKeys(zip);
	}

	//Enter Country
	public static WebElement getCountry() {
		return driver.findElement(By.xpath(locators.getProperty("country")));
	}

	public static void setCountry(String country) {
		getCountry().clear();
		getCountry().sendKeys(country);
	}

	//Select language
	public static WebElement getLanguage() {
		return driver.findElement(By.xpath(locators.getProperty("language_pereference")));
	}

	public static Select getSelectLanguage() {
		return new Select(getLanguage());
	}

	public static void selectLanguage(String language) {
		getSelectLanguage().selectByValue(language);
	}

	//Select category 
	public static WebElement getFavoriteCategory() {
		return driver.findElement(By.xpath(locators.getProperty("favorite_category")));
	}

	public static Select getSelectFavoriteCategory() {
		return new Select(getFavoriteCategory());
	}

	public static void selectFavoriteCategory(String category) {
		getSelectFavoriteCategory().selectByValue(category);
	}

	//Check my list
	public static WebElement enableMyList() {
		return driver.findElement(By.xpath(locators.getProperty("enable_my_list")));
	}

	public WebElement getEnableMyList() {
		return this.driver.findElement(By.xpath(locators.getProperty("enable_my_list")));
	}

	public static WebElement getSaveAccauntInformation() {
		return driver.findElement(By.xpath(locators.getProperty("save_accaunt_information")));
	}

	public static WebElement getLogoImg() {
		return driver.findElement(By.xpath(locators.getProperty("logo_img")));
	}

	public boolean checkRegistration() {
		boolean isSuccessful = false;
		if (RegistrationPage.getLogoImg().isDisplayed()) {
			isSuccessful = true;
		}
		return isSuccessful;
	}

}
