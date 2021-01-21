package pages.regression.healthRecord;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class HealthRecordPage  extends HealthRecordBase {

	public HealthRecordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}
	public WebDriver navigateToContactUsPage() {
		checkModelPopup(driver,1);
		if (noWaitValidate(ContactUsLnk)) {
			ContactUsLnk.click();
		} else {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootFooter);
			try {
				WebElement footerContactUsShadowRootLnk = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_FTR_HELP]"));
				scrollElementToCenterScreen(footerContactUsShadowRootLnk);
				footerContactUsShadowRootLnk.click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				Assert.assertTrue("PROBLEM - unable to locate Contact Us link in footer section", false);
			}
		} 
		return driver;
	}

	public WebDriver navigateToPharmacyLocatorPage(String memberType) {
		checkModelPopup(driver,1);
		//tbd if (noWaitValidate(testharnessTblPharmacyLocatorLnk)) {
		//tbd 	testharnessTblPharmacyLocatorLnk.click();
		//tbd } else 
		if (noWaitValidate(pharmacySearchLink)) {
			pharmacySearchLink.click();
		} else if (noWaitValidate(section_pharmacySearchLink)) {
			scrollElementToCenterScreen(section_pharmacySearchLink);
			moveMouseToElement(section_pharmacySearchLink);
			section_pharmacySearchLink.click();
		} else {
			//note: fix up the URL to get to the page...
			//tbd navigateToBenefitsPage(memberType);
			//tbd CommonUtility.checkPageIsReadyNew(driver);
			//tbd CommonUtility.waitForPageLoad(driver, benefitsPgLocatePharmacyLnk, 5);
			//tbd benefitsPgLocatePharmacyLnk.click();
			//tbd String[] tmp=driver.getCurrentUrl().split(".com/");
			//tbd String plUrl=tmp[0]+".com/content/medicare/member/pharmacy-locator/overview.html#/Pharmacy-Search-English";
			//tbd System.out.println("pharmacy locator pg URL="+plUrl);
			//tbd driver.get(plUrl);
			if (MRScenario.environment.contains("team-a")
					|| (MRScenario.environment.contains("stage") && MRScenario.isTestHarness.equalsIgnoreCase("Yes"))) {
				System.out.println("SKIP validation - Pharmacy locator link is Raly page, will not work on team or stage-testharness env");
				return driver;
			} else if (MRScenario.environment.contains("stage") && !MRScenario.isTestHarness.equalsIgnoreCase("Yes")) {
				//note: rally page will only work on stage if login via dashboard access
				String rallyUrl="https://member.int.uhc.com/pharmacy-uhc/pharmacies";
				driver.get(rallyUrl);
				CommonUtility.checkPageIsReadyNew(driver);
				if (validate(stagePharmacyLocatorCloseBtn,0)) {
					stagePharmacyLocatorCloseBtn.click();
					CommonUtility.checkPageIsReadyNew(driver);
					checkModelPopup(driver,1);
				}
			} else if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod")) {
				String rallyUrl="https://member.uhc.com/pharmacy-uhc/pharmacies";
				driver.get(rallyUrl);
				CommonUtility.checkPageIsReadyNew(driver);
				checkModelPopup(driver,1);
			}
		}
		//tbd CommonUtility.waitForPageLoad(driver, pharmacySearchPgZipcodeField, 10);
		//tbd Assert.assertTrue("PROBLEM - unable to navigator to Pharmacy Locator page", noWaitValidate(pharmacySearchPgZipcodeField) || noWaitValidate(pharmacySearchPgZipcodeField_newRally));
		CommonUtility.waitForPageLoad(driver, pharmacySearchPgZipcodeField_newRally, 10);
		Assert.assertTrue("PROBLEM - unable to navigator to (Rally) Pharmacy Locator page", noWaitValidate(pharmacySearchPgZipcodeField_newRally));
		return driver;
	}


	public WebDriver navigateToDcePage(String memberType) {
		checkModelPopup(driver,1);
		if (noWaitValidate(testharnessTblDceLnk)) {
			testharnessTblDceLnk.click();
		} else if (noWaitValidate(drugLookup)) {
			drugLookup.click();
		//TODO: when benefits Drug Look Up points to new DCE page, need to update the navigation
		//TODO: navigation will got to Benefits then click DRUG LOOK UP link
		//TODO: new DCE page will be rally page
		//tbd } else if (noWaitValidate(section_drugLocator)) {
		//tbd 	section_drugLocator.click();
		} else {
			//note: fix up the URL to get to the page...
			navigateToBenefitsPage(memberType);
			CommonUtility.checkPageIsReadyNew(driver);
			String[] tmp=driver.getCurrentUrl().split(".com/");
			String plUrl=tmp[0]+".com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
			System.out.println("pharmacy locator pg URL="+plUrl);
			driver.get(plUrl);
			CommonUtility.checkPageIsReadyNew(driver);
		}
		CommonUtility.waitForPageLoad(driver, dcePgHeaderTxt, 10);
		Assert.assertTrue("PROBLEM - unable to navigator to DCE page", noWaitValidate(dcePgHeaderTxt));
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
		checkModelPopup(driver,1);
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
				Assert.assertTrue("PROBLEM - unable to locate FindCare link on top menu", false);
			}
		}
		sleepBySec(2);
		return driver;
	}

	public WebDriver navigateToClaimsPage() {
		checkModelPopup(driver,1);
		CommonUtility.waitForPageLoad(driver, claimsTopMenuLnk, 5);
		if (noWaitValidate(claimsTopMenuLnk)) {
			claimsTopMenuLnk.click();
			CommonUtility.waitForPageLoad(driver, claimsSysTestPg, 10); //note: Rally claims sometimes lands on systest3 sign-in page, wait n c if this is the case
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				checkModelPopup(driver,1);
				WebElement claimsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-claims]"));
				claimsTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Claims link on top menu", false);
			}
		}
		CommonUtility.checkPageIsReady(driver);
		return driver;
	}

	public WebDriver navigateToEobPage() {
		navigateToClaimsPage();
		CommonUtility.waitForPageLoad(driver, eobTopSubMenuLnk, 5);
		Assert.assertTrue("PROBLEM - unable to locate EOB link on top menu", noWaitValidate(eobTopSubMenuLnk));
		checkModelPopup(driver,1);
		eobTopSubMenuLnk.click();
		return driver;
	}

	public WebDriver navigateToEobPageViaTestharnessTbl() {
		checkModelPopup(driver,1);
		if (noWaitValidate(testharnessTblEobLnk)) {
			testharnessTblEobLnk.click();
		} else {
			Assert.assertTrue("PROBLEM - unable to locate EOB link on Testharness table", false);
		}
		return driver;
	}

	public WebDriver navigateToBenefitsPage(String memberType) {
		checkModelPopup(driver,1);
		if (noWaitValidate(benefitsTopMenuLnk)) {
			try {
				checkModelPopup(driver,1);
				benefitsTopMenuLnk.click();
			} catch (TimeoutException te) {
				if (memberType.toUpperCase().contains("PREEFF") || memberType.toUpperCase().contains("TERM")) {
					System.out.println("memberType '"+memberType+"' will land on PlanDoc page when clicking benefits, need to wait longer for the page to be done");
					sleepBySec(30);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to locate Benefits link on top menu", false);
			}
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benfitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				benfitsTopMenuShadowRootLink.click();
			} catch (TimeoutException te) {
				if (memberType.toUpperCase().contains("PREEFF") || memberType.toUpperCase().contains("TERM")) {
					System.out.println("memberType '"+memberType+"' will land on PlanDoc page when clicking benefits, need to wait longer for the page to be done");
					sleepBySec(30);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to locate Benefits link on top menu", false);
			}
		}
		CommonUtility.waitForPageLoad(driver, benefitsPgHeader, 5);
		return driver;
	}

	public WebDriver navigateToPlanDocPage_preEff(String memberType) {
		navigateToBenefitsPage(memberType);
		checkModelPopup(driver,1);
		if (noWaitValidate(planDocHeaderTxt)) {
			System.out.println("Already on PlanDoc page, no need to go any further");
		} else {
			Assert.assertTrue("PROBLEM - this user is expected to be Pre-effective.  Unable to locate the 'VIEW PLAN DOCUMENTS' button on Benefits page.", noWaitValidate(preeff_goToPlanDocBtn));
			if (noWaitValidate(preeff_goToPlanDocBtn)) {
				preeff_goToPlanDocBtn.click();
				CommonUtility.checkPageIsReadyNew(driver);
			} 
		}
		return driver;
	}

	public WebDriver navigateToPlanDocPage(String memberType) {
		navigateToBenefitsPage(memberType);
		System.out.println("Finished navigating to benefits page");
		if (noWaitValidate(planDocHeaderTxt)) {
			System.out.println("Already on PlanDoc page, no need to go any further");
		} else {
			if (noWaitValidate(planDocTopMenuLnk)) {
				checkModelPopup(driver,1);
				planDocTopMenuLnk.click();
				CommonUtility.checkPageIsReadyNew(driver);
			} else 	if (noWaitValidate(shadowRootHeader)) {
				System.out.println("located shadow-root element, attempt to process further...");
				WebElement root1 = expandRootElement(shadowRootHeader);
				try {
					WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
					planDocTopMenuLnk.click();
					benefitsTopMenuShadowRootLink.click();
					CommonUtility.waitForPageLoad(driver, planDocTopMenuLnk, 5);
					planDocTopMenuLnk.click();
					CommonUtility.checkPageIsReadyNew(driver);
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - unable to locate Plan Documents and Resouces link on top sub menu", false);
				}
			}
		}
		return driver;
	}

	public WebDriver navigateToMyDocPage() {
		checkModelPopup(driver,1);
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

	public WebDriver navigateToOrderPage(String memberType) {
		navigateToBenefitsPage(memberType);
		checkModelPopup(driver,1);
		if (noWaitValidate(orderTopMenuLnk)) {
			checkModelPopup(driver,1);
			orderTopMenuLnk.click();
			CommonUtility.checkPageIsReadyNew(driver);
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				benefitsTopMenuShadowRootLink.click();
				CommonUtility.waitForPageLoad(driver, orderTopMenuLnk, 5);
				orderTopMenuLnk.click();
				CommonUtility.checkPageIsReadyNew(driver);
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Order Plan Materials link on top sub menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToPaymentsPage() {
		checkModelPopup(driver,1);
		if (noWaitValidate(paymentTopMenuLnk)) {
			paymentTopMenuLnk.click();
			CommonUtility.checkPageIsReadyNew(driver);
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
		checkModelPopup(driver,1);
		if (noWaitValidate(pnpTopMenuLnk)) {
			pnpTopMenuLnk.click();
			CommonUtility.checkPageIsReadyNew(driver);
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement pnpTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-pharmacies]"));
				pnpTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Pharmacies and Prescriptions link on top sub menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToHwPage() {
		checkModelPopup(driver,1);
		if (noWaitValidate(hwTopMenuLnk)) {
			hwTopMenuLnk.click();
			CommonUtility.checkPageIsReadyNew(driver);
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

	public boolean isHeathRecordLnkOnAcctProfDropdownOption(String planType, String memberType, boolean expComboTab, String targetPage, boolean expectIhrLnk) {
		System.out.println("Proceed to validate if IHR link is included in the dropdown...");
		String stageUrl="ihr.int.werally.in";
		String prodUrl="internal-redirect?deepLink=https%3A%2F%2Fihr.werally.com";
		//note: bluesteel is the link for offline-prod but env can only point at one url at a time
		//note: to avoid update link for every offline-prod deployment, keeping offline-prod link as prod link for secondary pages
		String offprodUrl=prodUrl;
		if (targetPage.equals("Initial landing page after login") || targetPage.equals("Find Care") || targetPage.equals("Claims")) {
			offprodUrl="internal-redirect?deepLink=https%3A%2F%2Fihr.bluesteel.werally.in";
		}
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
		scrollToTopOfPg();
		if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("button[id*=dropdown-toggle]"));
				//WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("#dropdown-toggle-2"));
				checkModelPopup(driver,1);
				acctSettingMenuShadowRootBtn.click();
				checkModelPopup(driver,1);
				if (expectIhrLnk) {
					WebElement firstLink=root1.findElement(By.cssSelector("#dropdown-options-2 > a:nth-child(1)"));
					Assert.assertTrue("PROBLEM - 'Health Record' link should be the first link on the dropdown.  First link text='"+firstLink.getText()+"'", firstLink.getText().toLowerCase().contains("health record"));
				}
			} catch (Exception e) {
				e.printStackTrace();
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
				} 
			}
			try {
				WebElement healthRecordLink = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_HEALTH_RECORD]"));
				if (noWaitValidate(healthRecordLink)) {
					String expUrl=stageUrl;
					if (MRScenario.environment.equalsIgnoreCase("offline"))
						expUrl=offprodUrl;
					else if (MRScenario.environment.equalsIgnoreCase("prod")) 
						expUrl=prodUrl;
					String actUrl=healthRecordLink.getAttribute("href");
					Assert.assertTrue("PROBLEM - Health Record link href value not as expected.  Expect to contains: '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				System.out.println("unable to locate Account Profile link on Rally Dashboard top menu");
				return false;
			}
		} else if (noWaitValidate(testHarn_AcctProfBtn)) {
			System.out.println("TEST - no shadowroot...");
			scrollToTopOfPg();
			checkModelPopup(driver,1);
			Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", noWaitValidate(testHarn_AcctProfBtn));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,50)", "");
			scrollToView(testHarn_AcctProfBtn);
			jsClickNew(testHarn_AcctProfBtn);

			//note: don't know why .click() doesn't work
			checkModelPopup(driver,1);
			WebElement ihrLnk=null;
			List<WebElement> acctProfOptLst=null;
			if (driver.getCurrentUrl().contains("claims") && noWaitValidate(testHarn_desktop_AcctProf_IHRLnk_claims)) {
				System.out.println("TEST - This is on claims page");
				ihrLnk=testHarn_desktop_AcctProf_IHRLnk_claims;
				acctProfOptLst=testHarn_AcctProfDropdown_claims;
			} else if (noWaitValidate(testHarn_desktop_AcctProf_IHRLnk)) {
				System.out.println("TEST - This has the usual desktop stuf");
				ihrLnk=testHarn_desktop_AcctProf_IHRLnk;
				acctProfOptLst=testHarn_AcctProfDropdown;
			} else if (noWaitValidate(testHarn_desktop_AcctProf_IHRLnk_react)) { //note: rally pages starting to use react
				System.out.println("TEST - This has react stuff");
				ihrLnk=testHarn_desktop_AcctProf_IHRLnk_react;
				acctProfOptLst=testHarn_AcctProfDropdown_react;
			} else if (noWaitValidate(testHarn_IHRLnk)) {
				System.out.println("TEST - This has another desktop IHR xpath");
				ihrLnk=testHarn_IHRLnk;
				acctProfOptLst=testHarn_AcctProfDropdown;
			} else {
				System.out.println("TEST - Can't match anything");
				return false;
			}
			Assert.assertTrue("PROBLEM - 'Health Record' should be the first link in the dropdown.   first link on the list has text='"+ acctProfOptLst.get(0).getText()+"'", acctProfOptLst.get(0).getText().toLowerCase().contains("health record"));

			String expUrl=stageUrl;
			if (MRScenario.environment.equalsIgnoreCase("offline"))
				expUrl=offprodUrl;
			else if (MRScenario.environment.equalsIgnoreCase("prod")) 
				expUrl=prodUrl;
			String actUrl=ihrLnk.getAttribute("href");
			Assert.assertTrue("PROBLEM - Health Record link href value not as expected.  Expect to contains: '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
			return true;
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
			} 
			try {
				WebElement healthRecordLink = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_HEALTH_RECORD]"));

				healthRecordLink.click();
				CommonUtility.checkPageIsReadyNew(driver);
				checkModelPopup(driver,1);

			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Health Record link on Rally Dashboard top menu", false);
			}
		} else if (noWaitValidate(testHarn_desktop_AcctProf_IHRLnk_react)) {
			testHarn_desktop_AcctProf_IHRLnk_react.click();
			CommonUtility.checkPageIsReadyNew(driver);
			checkModelPopup(driver,1);
		} else {
			Assert.assertTrue("PROBLEM - unable to locate Rally Dashboard top menu", false);
		}
	}

	public void navigateFromTestHarnessToHeathRecordPage() {
		checkModelPopup(driver,1);
		WebElement ihrLnk=testHarn_desktop_AcctProf_IHRLnk;
		if (noWaitValidate(testHarn_desktop_AcctProf_IHRLnk_pharmacyLocator))
			ihrLnk=testHarn_desktop_AcctProf_IHRLnk_pharmacyLocator;
		
		if (!noWaitValidate(ihrLnk)) {
			Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", noWaitValidate(ihrLnk));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,50)", "");
			scrollToView(testHarn_AcctProfBtn);
			jsClickNew(testHarn_AcctProfBtn);
		}

		Assert.assertTrue("PROBLEM - unable to locate Heath Record link on Account Profile button dropdown options", noWaitValidate(ihrLnk));

		ihrLnk.click();
		CommonUtility.checkPageIsReadyNew(driver);
		checkModelPopup(driver,1);
	}		

	public boolean hasSorryError() {
		return noWaitValidate(sorryError);
	}
	
	public boolean hasPaymentTabOnPage() {
		return noWaitValidate(paymentTopMenuLnk);
	}

}