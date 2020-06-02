package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.PetStoreMenuPage;

public class PetStoreMenuPageTest {
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

	}

	@Test
	public void PetStoreMenuTest() throws InterruptedException {
		driver.navigate().to(this.locators.getProperty("catalog_url"));
		PetStoreMenuPage ollLinks = new PetStoreMenuPage(driver, locators, waiter);
		SoftAssert sa = new SoftAssert();
		ollLinks.getAllLinks();
		for (int i = 0; i < ollLinks.getAllLinks().size(); i++) {
			int status = verifyURLStatus(ollLinks.getAllLinks().get(i).getAttribute("href"));
			sa.assertTrue(status < 400);
		}
	}

	public int verifyURLStatus(String urlString) {
		int status = 404;
		try {
			URL link = new URL(urlString);
			HttpURLConnection hConn = null;
			hConn = (HttpURLConnection) link.openConnection();
			hConn.setRequestMethod("GET");
			hConn.connect();
			status = hConn.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Test
	public void goToCorrectURL() throws InterruptedException {
		driver.navigate().to(this.locators.getProperty("catalog_url"));
		SoftAssert sa = new SoftAssert();
		PetStoreMenuPage correctURL = new PetStoreMenuPage(driver, locators, waiter);

		

		correctURL.getFishImgLink(driver);
		correctURL.clickFishImgLink(driver);
		String currUrlFish = driver.getCurrentUrl();
		currUrlFish = currUrlFish.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlFish,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH");

		driver.navigate().back();

		correctURL.getDogsImgLink(driver);
		correctURL.clickDogsImgLink(driver);
		String currUrlDogs = driver.getCurrentUrl();
		currUrlDogs = currUrlDogs.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlDogs,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS");

		driver.navigate().back();

		correctURL.getBirdsBigImgLink(driver);
		correctURL.clickBirdsBigImgLink(driver);
		String currUrlBirds = driver.getCurrentUrl();
		currUrlBirds = currUrlBirds.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlBirds,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS");

		driver.navigate().back();

		correctURL.getBirdsImgLink(driver);
		correctURL.clickBirdsImgLink(driver);
		String currUrlBirds1 = driver.getCurrentUrl();
		currUrlBirds1 = currUrlBirds1.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlBirds1,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS");

		driver.navigate().back();

		correctURL.getCatsImgLink(driver);
		correctURL.clickCatsImgLink(driver);
		String currUrlCats = driver.getCurrentUrl();
		currUrlCats = currUrlCats.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlCats,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS");

		driver.navigate().back();

		correctURL.getReptilesImgLink(driver);
		correctURL.clickReptilesImgLink(driver);
		String currUrlReptiles = driver.getCurrentUrl();
		currUrlReptiles = currUrlReptiles.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlReptiles,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES");
		driver.navigate().back();
		

		correctURL.getFishLink(driver);
		correctURL.clickFishImgLink(driver);
		String currUrlFish2 = driver.getCurrentUrl();
		currUrlFish2 = currUrlFish2.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlFish2,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH");

		driver.navigate().back();

		correctURL.getDogsLink(driver);
		correctURL.clickDogsLink(driver);
		String currUrlDogs2 = driver.getCurrentUrl();
		currUrlDogs2 = currUrlDogs2.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlDogs2,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS");

		driver.navigate().back();

		correctURL.getBirdsLink(driver);
		correctURL.clickBirdsLink(driver);
		String currUrlBirds2 = driver.getCurrentUrl();
		currUrlBirds2 = currUrlBirds2.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlBirds2,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS");

		driver.navigate().back();

		correctURL.getCatsLink(driver);
		correctURL.clickCatsLink(driver);
		String currUrlCats2 = driver.getCurrentUrl();
		currUrlCats2 = currUrlCats2.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlCats2,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS");

		driver.navigate().back();

		correctURL.getReptilesLink(driver);
		correctURL.clickReptilesLink(driver);
		String currUrlReptiles2 = driver.getCurrentUrl();
		currUrlReptiles2 = currUrlReptiles2.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlReptiles2,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES");

		driver.navigate().back();

		// testing url links on top

		correctURL.getFishOnTop(driver);
		correctURL.clickFishOnTop(driver);
		String currUrlFish3 = driver.getCurrentUrl();
		currUrlFish3 = currUrlFish3.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlFish3,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH");

		driver.navigate().back();

		correctURL.getDogsOnTop(driver);
		correctURL.clickDogsOnTop(driver);
		String currUrlDogs3 = driver.getCurrentUrl();
		currUrlDogs3 = currUrlDogs3.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlDogs3,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS");

		driver.navigate().back();

		correctURL.getBirdsOnTop(driver);
		correctURL.clickBirdsOnTop(driver);
		String currUrlBirds3 = driver.getCurrentUrl();
		currUrlBirds3 = currUrlBirds3.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlBirds3,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS");

		driver.navigate().back();

		correctURL.getCatsOnTop(driver);
		correctURL.clickCatsOnTop(driver);
		String currUrlCats3 = driver.getCurrentUrl();
		currUrlCats3 = currUrlCats3.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlCats3,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS");

		driver.navigate().back();

		correctURL.getReptilesOnTop(driver);
		correctURL.clickReptilesOnTop(driver);
		String currUrlReptiles3 = driver.getCurrentUrl();
		currUrlReptiles3 = currUrlReptiles3.replaceAll(";jsessionid=[^?]*", "");
		Assert.assertEquals(currUrlReptiles3,
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES");

		driver.navigate().back();

	}

	@Test
	public void singInButton() throws InterruptedException {
		PetStoreMenuPage singInButton = new PetStoreMenuPage(driver, locators, waiter);
		driver.navigate().to(this.locators.getProperty("catalog_url"));
		singInButton.clickSingInLink(driver);
		Assert.assertTrue(singInButton.isInSignInPage());
	}
	

	@AfterClass
	public void afterClass() {
		this.driver.close();
	}
}
