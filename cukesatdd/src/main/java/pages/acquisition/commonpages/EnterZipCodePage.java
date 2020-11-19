package pages.acquisition.commonpages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PageTitleConstants;

public class EnterZipCodePage extends UhcDriver {

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
				jsClickNew(ZipcodeButton.get(zipCodeNumber - 1));
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
				if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
					if (vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE))
						System.out.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
					else if (vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE))
						System.out
								.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
					else
						assertTrue("Not redirected to VPP page",
								vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
				} else {
					if (vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE))
						System.out.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
					else if (vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE))
						System.out
								.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
					else
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

	public void shopMenuZipComp(String zipCode) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(shopForaPlanLink).click(shopMenuZipEntry).sendKeys(zipCode).click(shopMenuZipButton).build().perform();

		
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
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			if (vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE))
				System.out.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
			else if (vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE))
				System.out
						.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
			else
				assertTrue("Not redirected to VPP page",
						vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
		} else {
			if (vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE))
				System.out.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
			else if (vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE))
				System.out
						.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
			else
				assertTrue("Not redirected to VPP page",
						vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
		}
		driver.navigate().back();

	}

	@Override
	public void openAndValidate() {

	}

}
