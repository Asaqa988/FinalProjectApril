package AutomationFinalProject_april.AutomationFinalProject_april;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	String TheWebSiteUrl = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetup() {

		driver.get(TheWebSiteUrl);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		WebElement SettingButtonEn = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		// WebElement SettingButtonAr =
		// driver.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary;"));
		SettingButtonEn.click();
	}

	@Test(priority = 1)
	public void CheckWebSiteLanaguage() {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		String ExpectedLanguage = "en";
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2)
	public void CheckCurrency() {

		// xpath just to recap what we mean by xpath you dont have to use it use css for
		// example
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedCurrency = "SAR";

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 4)

	public void CheckContactNumber() {
		String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();
		String ExpectedContactNumber = "+966554400000";
		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
	}

	@Test(priority = 4)
	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));

		boolean ActualImageIsDisplay = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();

		Assert.assertEquals(ActualImageIsDisplay, true);
	}

	@AfterTest
	public void AfterMyTest() {

	}

}
