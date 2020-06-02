package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;

	public SignInPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}

	// Username
	public WebElement getUserName() {
		return this.driver.findElement(By.xpath(locators.getProperty("username")));
	}

	public void setUserName(String username) {
		WebElement user = this.getUserName();
		user.clear();
		user.sendKeys(username);
	}

	// Password
	public WebElement getPassword() {
		return this.driver.findElement(By.xpath(locators.getProperty("password")));
	}

	public void setPassword(String password) {
		WebElement Password = this.getPassword();
		Password.clear();
		Password.sendKeys(password);
	}

	// Log in button
	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath(locators.getProperty("log_in_button")));
	}

	public void clickLoginButton() {
		this.getLoginButton().click();
	}

	// Register
	public WebElement getRegisterButton() {
		return this.driver.findElement(By.xpath(locators.getProperty("register_button")));
	}

	public void clickRegisterButton() {
		this.getRegisterButton().click();
	}

	// Sign in
	public void signIn(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
		this.clickLoginButton();
	}

	public WebElement getSignOut() {
		return this.driver.findElement(By.xpath(locators.getProperty("sign_out")));
	}

	// Success or not sign in
	public boolean signedIn() {
		try {
			this.driver.findElement(By.xpath(locators.getProperty("sign_out")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Sign out
	public void signOut() {
		this.getSignOut().click();
	}

}
