package pages.acquisition.bluelayer;

import static org.junit.Assert.assertTrue;

/*@author pagarwa5*/

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

public class EnterZipCodePage extends UhcDriver {

	@FindBy(name = "zipcode")
	WebElement zipCodeField;

	@FindBy(name = "fipsName")
	List<WebElement> counties;

	@FindBy(linkText = "Continue")
	WebElement continueButton;

	@FindBy(xpath = "//div[@id='counties']//span[.='Continue']")
	WebElement countyContinueButton;

	@FindBy(xpath = "//form[contains(@class,'zipForm')]")
	List<WebElement> zipForm;

	@FindBy(xpath = "(//form[contains(@class,'zipForm')]//input[contains(@class,'zip-input')])")
	List<WebElement> ZipCodeText;

	@FindBy(xpath = "(//form[contains(@class,'zipForm')]//button[contains(@class,'uhc-zip-button')])")
	List<WebElement> ZipcodeButton;

	public EnterZipCodePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void validateZipComp() {
		try {
			String zipCode = PageTitleConstants.ULAYER_ENTER_Zip_Code;
			int zipCodeNumber = 1;
			// List<WebElement> allZipComp1 =
			// driver.findElements(By.xpath("//form[contains(@class,'zipForm')]"));
			System.out.println("Total " + zipForm.size() + " Zip code component[s] display on page");

			while (zipCodeNumber <= zipForm.size()) {
				ZipCodeText.get(zipCodeNumber - 1).clear();
				ZipCodeText.get(zipCodeNumber - 1).sendKeys(zipCode);
				ZipcodeButton.get(zipCodeNumber - 1).click();
				System.out.println("Clicked on " + zipCodeNumber + " Zip Code Component");
				System.out.println("Validating VPP page for Zip code " + zipCode);
			
				String vppPageTitle = driver.getTitle();
				if (driver.getWindowHandles().size() > 1) {
					String currentPage = driver.getWindowHandle();
					Set<String> newWindow = driver.getWindowHandles();
					for (String tabs : newWindow) {
						if (!tabs.equalsIgnoreCase(currentPage))
							vppPageTitle=driver.switchTo().window(tabs).getTitle();
					}
				}
				
				assertTrue("Not redirected to VPP page",
						vppPageTitle.contains(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE));
				driver.navigate().back();
				zipCodeNumber++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public AddDrugPage getZipCodeCounty(String zipCode, String county, String planYear) {
		zipCodeField.click();
		zipCodeField.clear();
		zipCodeField.sendKeys(zipCode);
		if (null != planYear) {
			String planYearXpath = "//div[@class='marginBottom25']//span[.='" + planYear + "']";
			driver.findElement(By.xpath(planYearXpath)).click();
			System.out.println("year");
		}
		continueButton.click();

		if (counties.size() > 1) {
			for (WebElement countyElement : counties) {
				String elementId = countyElement.getAttribute("id");
				if (elementId.contains(county)) {
					countyElement.click();
					System.out.println("county clicked");
				}

			}

			countyContinueButton.click();

		}

		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}

	}

	@Override
	public void openAndValidate() {

	}

}
