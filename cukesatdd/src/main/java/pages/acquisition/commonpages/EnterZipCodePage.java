package pages.acquisition.commonpages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PageTitleConstants;

public class EnterZipCodePage extends UhcDriver{
	
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
				Thread.sleep(20000);
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
				if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
					System.out.println("Expected : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
					assertTrue("Not redirected to VPP page",
						vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
				}
				else
				{
					System.out.println("Expected : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
					assertTrue("Not redirected to VPP page",
						vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
				}
				driver.navigate().back();
				zipCodeNumber++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void openAndValidate() {

	}

}
