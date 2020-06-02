package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelUtils;

public class CartPage {
	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;

	public CartPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}

	// Remove
	public WebElement getRemoveFromCart() {
		return this.driver.findElement(By.xpath(locators.getProperty("remove_from_cart")));
	}

	public void clickRemoveFromCart() {
		this.getRemoveFromCart().click();
	}

	// Update cart
	public WebElement getUpdateCart() {
		return this.driver.findElement(By.xpath(locators.getProperty("update_cart")));
	}

	public void clickUpdateCart() {
		this.getUpdateCart().click();
	}

	// Proceed to checkout
	public WebElement getProceedToCheckout() {
		return this.driver.findElement(By.xpath(locators.getProperty("proceed_to_checkout")));
	}

	public void clickProceedToCheckout() {
		this.getUpdateCart().click();
	}

	public boolean isAdded() {
		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
			boolean added = ExcelUtils.getDataAt(i, 0) != null;
			if (added) {
				System.out.println("Uspesno dodat artikal");
			} else {
				System.out.println("Neuspesno dodat artikal");
			}

		}
		return true;
	}

	public boolean cartIsEmpty() {
		try {
			this.driver.findElement(By.xpath(locators.getProperty("cart_is_empty")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
