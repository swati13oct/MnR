package pages.mobile.acquisition.commonpages;

import static atdd.framework.Assertion.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PageTitleConstants;

public class EnterZipCodePageMobile extends UhcDriver{
	
	@FindBy(xpath = "//form[contains(@class,'zipForm')]")
	List<WebElement> zipForm;
	
	@FindBy(xpath = "(//form[contains(@class,'zipForm')]//input[contains(@class,'zip-input')])")
	List<WebElement> ZipCodeText;
	
	@FindBy(xpath = "(//form[contains(@class,'zipForm')]//button[contains(@class,'uhc-zip-button')])")
	List<WebElement> ZipcodeButton;
	
	public EnterZipCodePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	/*public void validateZipComp(String zipCode) {
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
	}*/
	public void validateZipComp(String zipCode) {
		try {
			int zipCodeNumber = 1;
			System.out.println("Total " + zipForm.size() + " Zip code component[s] display on page");

			while (zipCodeNumber <= zipForm.size()) {
				Thread.sleep(5000);
				sendkeysMobile(ZipCodeText.get(zipCodeNumber - 1), zipCode);
				waitForPageLoadSafari();
				Thread.sleep(3000);
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
					if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains(
							(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE).replaceAll("[^A-Za-z0-9:.]", "")))
						System.out.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
					else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
							.contains((PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE)
									.replaceAll("[^A-Za-z0-9:.]", "")))
						System.out
								.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
					else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
							.contains((PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE_MEDIGAP)
									.replaceAll("[^A-Za-z0-9:.]", "")))
						System.out.println(
								"Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE_MEDIGAP);
					else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains(
							(PageTitleConstants.ULAYER_PRESCRIPTION_DRUG_DPLANS).replaceAll("[^A-Za-z0-9:.]", "")))
						System.out.println("Page Title : " + PageTitleConstants.ULAYER_PRESCRIPTION_DRUG_DPLANS);
					else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains(
							(PageTitleConstants.ULAYER_PRESCRIPTION_DRUG_SNPPLANS).replaceAll("[^A-Za-z0-9:.]", "")))
						System.out.println("Page Title : " + PageTitleConstants.ULAYER_PRESCRIPTION_DRUG_SNPPLANS);
					
					else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains(
							(PageTitleConstants.ULAYER_SHOP_ALL_PLANS).replaceAll("[^A-Za-z0-9:.]", "")))
						System.out.println("Page Title : " + PageTitleConstants.ULAYER_SHOP_ALL_PLANS);
					
					else
						assertTrue("Not redirected to VPP page",
								vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
										.contains((PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE)
												.replaceAll("[^A-Za-z0-9:.]", "")));
				} else {
					if (driver.getCurrentUrl().contains("uhcmedicaresolutions")) {
						if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
								.contains((PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE)
										.replaceAll("[^A-Za-z0-9:.]", "")))
							System.out.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
						else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
								.contains((PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE)
										.replaceAll("[^A-Za-z0-9:.]", "")))
							System.out.println(
									"Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
						else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
								.contains((PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE_MEDIGAP)
										.replaceAll("[^A-Za-z0-9:.]", "")))
							System.out.println("Page Title : "
									+ PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE_MEDIGAP);
						else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains(
								(PageTitleConstants.BLAYER_PRESCRIPTION_DRUG_DPLANS).replaceAll("[^A-Za-z0-9:.]", "")))
							System.out.println("Page Title : " + PageTitleConstants.BLAYER_PRESCRIPTION_DRUG_DPLANS);
						else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
								.contains((PageTitleConstants.BLAYER_PRESCRIPTION_DRUG_SNPPLANS)
										.replaceAll("[^A-Za-z0-9:.]", "")))
							System.out.println("Page Title : " + PageTitleConstants.BLAYER_PRESCRIPTION_DRUG_SNPPLANS);
						else
							assertTrue("Not redirected to VPP page",
									vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "")
											.contains((PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE)
													.replaceAll("[^A-Za-z0-9:.]", "")));
					}
				}

				if (driver.getWindowHandles().size() > 1) {
					String currentPage = driver.getWindowHandle();
					Set<String> newWindow = driver.getWindowHandles();
					for (String parentWindow : newWindow) {
						if (!parentWindow.equalsIgnoreCase(currentPage)) {
							driver.switchTo().window(currentPage).close();
							vppPageTitle = driver.switchTo().window(parentWindow).getTitle();
							break;
						}
					}
				} else {
					driver.navigate().back();
					threadsleep(20000);
				}
				zipCodeNumber++;
				/*
				 * driver.navigate().refresh(); //Adding refresh since element are not located
				 * in Safari browser after using navigate back threadsleep(2000);
				 */
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void openAndValidate() {

	}

}
