package pages.regression.healthRecord;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;

public class HealthRecordPage  extends HealthRecordBase {

	public HealthRecordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}
	public WebDriver navigateToContactUsPage() {
		if (noWaitValidate(ContactUsLnk)) {
			ContactUsLnk.click();
		} else {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootFooter);
			try {
				WebElement footerContactUsShadowRootLnk = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_FTR_HELP]"));
				footerContactUsShadowRootLnk.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Contact Us link in footer section", false);
			}
		} 
		return driver;
	}

	public WebDriver navigateToPharmacyLocatorPage() {
		if (noWaitValidate(testharnessTblPharmacyLocatorLnk)) {
			testharnessTblPharmacyLocatorLnk.click();
		} else if (noWaitValidate(pharmacySearchLink)) {
			pharmacySearchLink.click();
		} else if (noWaitValidate(section_pharmacySearchLink)) {
			scrollElementToCenterScreen(section_pharmacySearchLink);
			moveMouseToElement(section_pharmacySearchLink);
			section_pharmacySearchLink.click();
		} else {
			Assert.assertTrue("PROBLEM - unable to navigator to Pharmacy Locator page", false);
		}
		return driver;
	}


	public WebDriver navigateToDcePage() {
		if (noWaitValidate(testharnessTblDceLnk)) {
			testharnessTblDceLnk.click();
		} else if (noWaitValidate(drugLookup)) {
			drugLookup.click();
		} else if (noWaitValidate(section_pharmacySearchLink)) {
			section_pharmacySearchLink.click();
		} else {
			Assert.assertTrue("PROBLEM - unable to navigator to DCE page", false);
		}
		return driver;
	}

	public WebDriver navigateToAccountSettings() {
		checkModelPopup(driver,1);
		if (noWaitValidate(acctProfileBtn_closed)) {
			acctProfileBtn_closed.click();
			CommonUtility.waitForPageLoad(driver, acctSettingsLnk, 5);
			acctSettingsLnk.click();
		} else if (noWaitValidate(acctProfileBtn_expanded)) {
			acctSettingsLnk.click();
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("button[id*=dropdown-toggle]"));
				acctSettingMenuShadowRootBtn.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", false);
			}
			try {
				WebElement acctSettingLink = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_ACCOUNT_SETTINGS]"));
				acctSettingLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Account Settings link on Account Profile dropdown", false);
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to navigate to Account Settings page", false);
		}
		return driver;
	}


	public WebDriver navigateToFindCarePage() {
		if (noWaitValidate(findCareTopMenuLnk)) {
			System.out.println("Find findCareTopMenuLnk, click it");
			findCareTopMenuLnk.click();
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("Find shadowRootHeader, expand it");
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement findCareTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-find-care]"));
				findCareTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Benefits link on top menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToClaimsPage() {
		if (noWaitValidate(claimsTopMenuLnk)) {
			claimsTopMenuLnk.click();
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement claimsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-claims]"));
				claimsTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Claims link on top menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToEobPage() {
		navigateToClaimsPage();
		CommonUtility.waitForPageLoad(driver, eobTopSubMenuLnk, 5);
		Assert.assertTrue("PROBLEM - unable to locate EOB link on top menu", noWaitValidate(eobTopSubMenuLnk));
		eobTopSubMenuLnk.click();
		return driver;
	}

	public WebDriver navigateToEobPageViaTestharnessTbl() {
		if (noWaitValidate(testharnessTblEobLnk)) {
			testharnessTblEobLnk.click();
		} else {
			Assert.assertTrue("PROBLEM - unable to locate EOB link on Testharness table", false);
		}
		return driver;
	}

	public WebDriver navigateToBenefitsPage() {
		if (noWaitValidate(benefitsTopMenuLnk)) {
			benefitsTopMenuLnk.click();
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement claimsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				claimsTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Benefits link on top menu", false);
			}
		}
		return driver;
	}
	
	public WebDriver navigateToPlanDocPage_preEff() {
		navigateToBenefitsPage();
		if (noWaitValidate(preeff_goToPlanDocBtn)) {
			preeff_goToPlanDocBtn.click();
			CommonUtility.checkPageIsReady(driver);
		} 
		return driver;
	}

	public WebDriver navigateToPlanDocPage() {
		navigateToBenefitsPage();
		if (noWaitValidate(planDocTopMenuLnk)) {
			planDocTopMenuLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				benefitsTopMenuShadowRootLink.click();
				CommonUtility.waitForPageLoad(driver, planDocTopMenuLnk, 5);
				planDocTopMenuLnk.click();
				CommonUtility.checkPageIsReady(driver);
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Plan Documents and Resouces link on top sub menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToMyDocPage() {
		//note: take too long to navigate to plan doc page so this step will have together w/ planDoc
		//note: assume you are already on planDoc
		Assert.assertTrue("PROBLEM - unable to locate My Documents link on Plan Documents and Resources page", noWaitValidate(myDocLnk));
		try {
			myDocLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} catch(UnhandledAlertException ae) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Detected Alert popup, accept it and move on...");
		}
		return driver;
	}

	public WebDriver navigateToOrderPage() {
		navigateToBenefitsPage();
		if (noWaitValidate(orderTopMenuLnk)) {
			orderTopMenuLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				benefitsTopMenuShadowRootLink.click();
				CommonUtility.waitForPageLoad(driver, orderTopMenuLnk, 5);
				orderTopMenuLnk.click();
				CommonUtility.checkPageIsReady(driver);
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Order Plan Materials link on top sub menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToPaymentsPage() {
		if (noWaitValidate(paymentTopMenuLnk)) {
			paymentTopMenuLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement paymentTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-premium-payments]"));
				paymentTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Payments link on top sub menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToPnpPage() {
		if (noWaitValidate(pnpTopMenuLnk)) {
			pnpTopMenuLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement pnpTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-pharmacies]"));
				pnpTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Payments link on top sub menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToHwPage() {
		if (noWaitValidate(hwTopMenuLnk)) {
			hwTopMenuLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement hwTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-health-wellness]"));
				hwTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Payments link on top sub menu", false);
			}
		}
		return driver;
	}

	public boolean isHeathRecordLnkOnAcctProfDropdownOption(String planType, String memberType, boolean expComboTab, String targetPage) {
		//tbd String stageUrl="https://ihr.int.werally.in";
		String stageUrl="ihr.int.werally.in";
		checkModelPopup(driver,1);
		if (expComboTab) {
			if (targetPage.equalsIgnoreCase("payments"))
				handlePaymentComboTabIfComboUser(planType, memberType);
			else
				handleComboTabIfComboUser(planType, memberType);
		}
		checkModelPopup(driver,1);
		CommonUtility.waitForPageLoad(driver, shadowRootHeader, 5);
		sleepBySec(2);
		if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("button[id*=dropdown-toggle]"));
				//WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("#dropdown-toggle-2"));
				acctSettingMenuShadowRootBtn.click();
			} catch (Exception e) {
				if (noWaitValidate(sorryError)) {
					//note: try one more time before giving up
					System.out.println("try one more time before giving up");
					driver.navigate().back();
					CommonUtility.checkForVariable(driver);
					checkModelPopup(driver,1);
					try {
						WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("button[id*=dropdown-toggle]"));
						acctSettingMenuShadowRootBtn.click();
					} catch (Exception e1) {
						if (noWaitValidate(sorryError)) 
							Assert.assertTrue("PROBLEM - got 'Sorry. It's not you. It's us' error, unable to locate Account Profile button on Rally Dashboard top menu", false);
						else 
							Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", false);
					}
				} else
					Assert.assertTrue("PROBLEM - unable to locate Account Profile button on top menu", false);
			}
			try {
				WebElement healthRecordLink = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_HEALTH_RECORD]"));
				if (noWaitValidate(healthRecordLink)) {
					String expUrl=stageUrl;
					String actUrl=healthRecordLink.getAttribute("href");
					Assert.assertTrue("PROBLEM - Health Record link href value not as expected.  Expect to contains: '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
					return true;
				} else 
					return false;
			} catch (Exception e) {
				System.out.println("unable to locate Account Profile link on Rally Dashboard top menu");
				return false;
			}
		} else if (noWaitValidate(testHarn_AcctProfBtn)) {
			checkModelPopup(driver,1);
			Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", noWaitValidate(testHarn_AcctProfBtn));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,50)", "");
			scrollToView(testHarn_AcctProfBtn);
			jsClickNew(testHarn_AcctProfBtn);

			//note: don't know why .click() doesn't work
			//testHarn_AcctProfBtn.click();
			checkModelPopup(driver,1);
			if (noWaitValidate(testHarn_desktop_AcctProf_IHRLnk)) {
				String expUrl=stageUrl;
				String actUrl=testHarn_desktop_AcctProf_IHRLnk.getAttribute("href");
				Assert.assertTrue("PROBLEM - Health Record link href value not as expected.  Expect to contains: '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
				return true;
			} else 
				return false;
		} else {
			System.out.println("unable to locate Account Profile from top menu");
			return false;
		}
	}




	public void navigateFromDashboardToHeathRecordPageAndThenCloseTab() {
		checkModelPopup(driver,1);
		if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("#dropdown-toggle-2"));
				acctSettingMenuShadowRootBtn.click();
			} catch (Exception e) {
				e.printStackTrace();
				//tbd Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", false);
			}
			try {
				WebElement healthRecordLink = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_HEALTH_RECORD]"));

				/* tbd 
				String winHandleBefore = driver.getWindowHandle();
				ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int beforeClicked_numTabs=beforeClicked_tabs.size();	
				*/
				
				healthRecordLink.click();
				CommonUtility.checkPageIsReady(driver);
				checkModelPopup(driver,1);

				/* tbd 
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();
				Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking 'Health Record' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				CommonUtility.checkPageIsReady(driver);

				driver.close();
				driver.switchTo().window(winHandleBefore);
				*/

			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Account Profile link on Rally Dashboard top menu", false);
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to locate Rally Dashboard top menu", false);
		}
	}

	public void navigateFromTestHarnessToHeathRecordPageAndThenCloseTab() {
		checkModelPopup(driver,1);
		if (!noWaitValidate(testHarn_desktop_AcctProf_IHRLnk)) {
			Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", noWaitValidate(testHarn_AcctProfBtn));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,50)", "");
			scrollToView(testHarn_AcctProfBtn);
			jsClickNew(testHarn_AcctProfBtn);
		}

		//testHarn_AcctProfBtn.click();
		Assert.assertTrue("PROBLEM - unable to locate Heath Record link on Account Profile button dropdown options", noWaitValidate(testHarn_desktop_AcctProf_IHRLnk));

		/* tbd
		String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int beforeClicked_numTabs=beforeClicked_tabs.size();	
		*/
		testHarn_desktop_AcctProf_IHRLnk.click();
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,1);
		/* tbd 
		CommonUtility.waitForPageLoad(driver, siteLeavingPopup, 5);
		System.out.println("Proceed to validate the leaving site popup after clicking 'Health Record' link");
		Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup after clicking the 'Health Record' link", noWaitValidate(siteLeavingPopup));
		Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup PROCEED button after clicking the 'Health Record' link", noWaitValidate(siteLeavingPopup_proceedBtn));
		Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup CANCEL button after clicking the 'Health Record' link", noWaitValidate(siteLeavingPopup_cancelBtn));

		System.out.println("Proceed to validate the Cancel button on leaving site popup after clicking 'Health Record' link");
		siteLeavingPopup_cancelBtn.click();
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue("PROBLEM - should not locate the site-leaving popup after clicking CANCEL button", !noWaitValidate(siteLeavingPopup));

		CommonUtility.waitForPageLoad(driver, testHarn_AcctProfBtn, 5);
		testHarn_AcctProfBtn.click();
		testHarn_desktop_AcctProf_IHRLnk.click();
		CommonUtility.waitForPageLoad(driver, siteLeavingPopup, 5);
		System.out.println("Proceed to validate the Proceed button on leaving site popup after clicking 'Health Record' link");
		siteLeavingPopup_proceedBtn.click();
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue("PROBLEM - should not locate the site-leaving popup after clicking PROCEED button", !noWaitValidate(siteLeavingPopup));
		checkModelPopup(driver,1);
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();
		Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking 'Health Record' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		CommonUtility.checkPageIsReady(driver);

		driver.close();
		driver.switchTo().window(winHandleBefore);
		*/
	}			



}