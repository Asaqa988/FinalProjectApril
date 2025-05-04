package AutomationFinalProject_april.AutomationFinalProject_april;

import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData {

	@BeforeTest
	public void mySetup() {
		Setup();

	}

	@Test(priority = 1, enabled = false)
	public void CheckWebSiteLanaguage(String ExpectedLanguage) {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2, enabled = false)
	public void CheckCurrency() {

		// xpath just to recap what we mean by xpath you dont have to use it use css for
		// example

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = false)

	public void CheckContactNumber() {
		String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();
		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
	}

	@Test(priority = 4, enabled = false)
	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));

		boolean ActualImageIsDisplay = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();

		Assert.assertEquals(ActualImageIsDisplay, true);
	}

	@Test(priority = 5, enabled = false)
	public void CheckHotelTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		String ActualValue = HotelTab.getDomAttribute("aria-selected");

		Assert.assertEquals(ActualValue, expectedCheckHotelTabIsNotSelected);

	}

	@Test(priority = 6, enabled = false)
	public void FLightDepatureDate() {
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualDepatureDate = dates.get(0).getText();
		Assert.assertEquals(ActualDepatureDate, tomorrowAsFormatedValue);
	}

	@Test(priority = 7, enabled = false)
	public void FlightReturnDate() {
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = dates.get(1).getText();
		String DayAftertomorrowAsFormatedValue = String.format("%02d", dayAfterTomrrow);
		Assert.assertEquals(ActualReturnDate, DayAftertomorrowAsFormatedValue);
	}

	@Test(priority = 8, enabled = true)
	public void ChangeTheWebsiteLanaguage() {
		driver.get(webistes[randomIndex]);

		if (driver.getCurrentUrl().contains("en")) {
			CheckWebSiteLanaguage("en");
		} else {
			CheckWebSiteLanaguage("ar");

		}

	}

	@Test(priority = 9, enabled = true)
	public void RandomlySelectCity() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		WebElement SearchInputField = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input "));

		if (driver.getCurrentUrl().contains("en")) {
			SearchInputField.sendKeys(englishCities[randomEnglishCity]);

		} else {
			SearchInputField.sendKeys(arbicCities[randomArabicCity]);

		}

		WebElement SelectVistorNumber = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Select mySelector = new Select(SelectVistorNumber);

		mySelector.selectByValue(values[randomValue]);

		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();

	}

	@Test(priority = 10)
	public void CheckTheResultsIsretrived() throws InterruptedException {
		Thread.sleep(10000);

		String Results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();

		if (driver.getCurrentUrl().contains("en")) {
			Assert.assertEquals(Results.contains("found"), true);

		} else {
			Assert.assertEquals(Results.contains("مكان إقامة"), true);

		}

	}

	@AfterTest
	public void AfterMyTest() {

	}

}
