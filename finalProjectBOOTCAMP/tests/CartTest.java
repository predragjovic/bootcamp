package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartPage;
import pages.StoreItemPage;
import utils.ExcelUtils;

public class CartTest {

	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;

	@BeforeClass
	public void setup() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.locators = new Properties();
		locators.load(new FileInputStream("config/jpetstore.properties"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SoftAssert sa = new SoftAssert();
		ExcelUtils.setExcell("data/pet-store-data.xlsx");
		ExcelUtils.setWorkSheet(0);
	}

	@Test
	public void CartTestin() throws InterruptedException {

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
			driver.navigate().to(ExcelUtils.getDataAt(i, 1));
			StoreItemPage addItem = new StoreItemPage(driver, locators, waiter);
			addItem.clickAddToCart();

		}

		CartPage isAdded = new CartPage(driver, locators, waiter);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(isAdded.isAdded());
		driver.navigate().to(this.locators.getProperty("cart_url"));
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		ExcelUtils.closeExcell();
	}

	@Test
	public void CartEmptyTestin() throws InterruptedException {
		CartPage isEmpty = new CartPage(driver, locators, waiter);
		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
			driver.navigate().to(ExcelUtils.getDataAt(i, 1));
			StoreItemPage addItem1 = new StoreItemPage(driver, locators, waiter);
			addItem1.clickAddToCart();

		}

		driver.navigate().to(this.locators.getProperty("cart_url"));
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(isEmpty.cartIsEmpty());
		ExcelUtils.closeExcell();

	}

	@AfterClass
	public void afterClass() {
		this.driver.close();
	}

}
