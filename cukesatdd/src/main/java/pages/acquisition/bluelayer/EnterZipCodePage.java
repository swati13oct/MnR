package pages.acquisition.bluelayer;

import static org.junit.Assert.assertTrue;

/*@author pagarwa5*/

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath = "//li[@class='expandable'][1]")
	WebElement shopForaPlanLink;

	@FindBy(xpath = "//input[@class='zip-field']")
	WebElement shopMenuZipEntry;

	@FindBy(xpath = "(//button[@class='zip-button'])[1]")
	WebElement shopMenuZipButton;


	public EnterZipCodePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void validateZipComp(String zipCode) {
		try {
			int zipCodeNumber = 1;
			System.out.println("Total " + zipForm.size() + " Zip code component[s] display on page");

			while (zipCodeNumber <= zipForm.size()) {
				Thread.sleep(3000);
				ZipCodeText.get(zipCodeNumber - 1).clear();
				ZipCodeText.get(zipCodeNumber - 1).sendKeys(zipCode);
				ZipcodeButton.get(zipCodeNumber - 1).click();
				System.out.println("Clicked on " + zipCodeNumber + " Zip Code Component");
				System.out.println("Validating VPP page for Zip code " + zipCode);
				Thread.sleep(3000);
				String vppPageTitle = driver.getTitle();
				if (driver.getWindowHandles().size() > 1) {
					String currentPage = driver.getWindowHandle();
					Set<String> newWindow = driver.getWindowHandles();
					for (String tabs : newWindow) {
						if (!tabs.equalsIgnoreCase(currentPage))
							vppPageTitle = driver.switchTo().window(tabs).getTitle();
					}
				}

				System.out.println("Actual : " + vppPageTitle);
				System.out.println("Expected : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
				assertTrue("Not redirected to VPP page",
						vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
				driver.navigate().back();
				zipCodeNumber++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void shopMenuZipComp(String zipCode) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(shopForaPlanLink).click(shopMenuZipEntry).sendKeys(zipCode).click(shopMenuZipButton).build().perform();

		
		Thread.sleep(3000);
		String vppPageTitle = driver.getTitle();
		if (driver.getWindowHandles().size() > 1) {
			String currentPage = driver.getWindowHandle();
			Set<String> newWindow = driver.getWindowHandles();
			for (String tabs : newWindow) {
				if (!tabs.equalsIgnoreCase(currentPage))
					vppPageTitle = driver.switchTo().window(tabs).getTitle();
			}
		}

		System.out.println("Actual : " + vppPageTitle);
		System.out.println("Expected : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
		assertTrue("Not redirected to VPP page",
				vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
		driver.navigate().back();

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
