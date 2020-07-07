package pages.regression.providerSearch;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class ProviderSearchPage extends ProviderSearchBase {

	public ProviderSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	public WebDriver navigateToContactUsPage() {
		if (noWaitValidate(ContactUsLnk)) {
			ContactUsLnk.click();
		} else {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootFooter);
			try {
				WebElement footerContactUsShadowRootLnk = root1
						.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_FTR_HELP]"));
				footerContactUsShadowRootLnk.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Contact Us link in footer section", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToProviderSearchPg(String planType, String memberType) {
		checkModelPopup(driver, 1);
		if (noWaitValidate(dashboard_findProviderLnk)) {
			dashboard_findProviderLnk.click();
		} else {
			String envStr = "member.int.uhc.com";
			if (planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP"))
				envStr = "member.int.mymedicareaccount.uhc.com";
			if (MRScenario.environment.contains("offline")) {
				if (planType.equalsIgnoreCase("MA"))
					envStr = "connect.bluesteel.werally.in";
				else if (planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP"))
					envStr = "member.uat.mymedicareaccount.com";
				else
					envStr = "member.uat.uhc.com";
			} else if (MRScenario.environment.contains("prod")) {
				if (planType.equalsIgnoreCase("MA"))
					envStr = "connect.werally.com";
				else if (planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP"))
					envStr = "member.uhc.mymedicareaccount.com";
				else
					envStr = "member.uhc.com";
			}
			if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("MA")
					|| planType.equalsIgnoreCase("PDP")) {
				if ((planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("MA")
						|| planType.equalsIgnoreCase("PDP")) && memberType.toUpperCase().contains("IND")) {
					if ((MRScenario.environment.equalsIgnoreCase("offline")
							|| MRScenario.environment.equalsIgnoreCase("prod")) && planType.equalsIgnoreCase("MA")) {
						driver.get("https://" + envStr + "/medicalProvider/root?showBackButton=true");
					} else if (memberType.toUpperCase().contains("AARP")) {
						driver.get("https://" + envStr + "/aarp/find-care");
					} else if (memberType.toUpperCase().contains("UHC")) {
						driver.get("https://" + envStr + "/medicare/find-care");
					} else
						Assert.assertTrue("PROBLEM - please indicate AARP or UHC in your memberType input", false);
				} else if (memberType.toUpperCase().contains("GRP")) {
					driver.get("https://" + envStr + "/retiree/find-care");
				} else {
					Assert.assertTrue("PROBLEM - please indicate IND or GRP in your memberType input", false);
				}
			} else if (planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP")) {
				if (memberType.toUpperCase().contains("MEDICA"))
					driver.get("https://" + envStr + "/medica/find-care");
				else if (memberType.toUpperCase().contains("PCP"))
					driver.get("https://" + envStr + "/pcp/find-care");
			} else {
				Assert.assertTrue("PROBLEM - I haven't code this yet... planType='" + planType + "' | memberType='"
						+ memberType + "'", false);
			}
		}
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver, 1);
		if (memberType.toUpperCase().contains("IND")) {
			CommonUtility.waitForPageLoad(driver, uhcProviderSearchContBtn, 15);
			if (noWaitValidate(uhcProviderSearchContBtn)) {
				scrollElementToCenterScreen(uhcProviderSearchContBtn);
				uhcProviderSearchContBtn.click();
				CommonUtility.checkPageIsReady(driver);
			}
		}
		sleepBySec(1);
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
		checkModelPopup(driver, 1);
		if (noWaitValidate(acctProfileBtn_closed)) {
			scrollElementToCenterScreen(acctProfileBtn_closed);
			acctProfileBtn_closed.click();
			CommonUtility.waitForPageLoad(driver, acctSettingsLnk, 5);
			acctSettingsLnk.click();
		} else if (noWaitValidate(acctProfileBtn_expanded)) {
			scrollElementToCenterScreen(acctProfileBtn_expanded);
			acctSettingsLnk.click();
		} else if (noWaitValidate(uhcProviderSearchAcctProfBtn)) {
			scrollElementToCenterScreen(uhcProviderSearchAcctProfBtn);
			uhcProviderSearchAcctProfBtn.click();
			CommonUtility.waitForPageLoad(driver, uhcProviderSearchAcctSettingsOpt, 5);
			uhcProviderSearchAcctSettingsOpt.click();
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement acctSettingMenuShadowRootBtn = root1
						.findElement(By.cssSelector("button[id*=dropdown-toggle]"));
				acctSettingMenuShadowRootBtn.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu",
						false);
			}
			try {
				WebElement acctSettingLink = root1
						.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_ACCOUNT_SETTINGS]"));
				acctSettingLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Account Settings link on Account Profile dropdown",
						false);
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to navigate to Account Settings page", false);
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, acctSettingPgHeader, 10);
		Assert.assertTrue("PROBLEM - unable to locate header text for 'Account Setting' page",
				noWaitValidate(acctSettingPgHeader));
		return driver;
	}

	public WebDriver navigateToFindCarePage() {
		if (noWaitValidate(findCareTopMenuLnk)) {
			System.out.println("Find findCareTopMenuLnk, click it");
			findCareTopMenuLnk.click();
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("Find shadowRootHeader, expand it");
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement findCareTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-find-care]"));
				findCareTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate FindCare link on top menu", false);
			}
		}
		return driver;
	}

	public WebDriver navigateToClaimsPage() {
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver, 1);
		CommonUtility.waitForPageLoad(driver, claimsTopMenuLnk, 10);
		if (noWaitValidate(claimsTopMenuLnk)) {
			claimsTopMenuLnk.click();
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement claimsTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-claims]"));
				claimsTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Claims link on top menu", false);
			}
		} else if (noWaitValidate(uhcProviderSearchClaimsLnk)) {
			uhcProviderSearchClaimsLnk.click();
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, claimsPgHeader, 5);
		Assert.assertTrue("PROBLEM - unable to locate header text for 'Claims' page", noWaitValidate(claimsPgHeader));
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
		} else if (noWaitValidate(uhcProviderSearchBenefitsLnk)) {
			uhcProviderSearchBenefitsLnk.click();
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement claimsTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				claimsTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Benefits link on top menu", false);
			}
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, benefitsPgHeader, 10);
		Assert.assertTrue("PROBLEM - unable to locate header text for 'Coverage and Benefits' page",
				noWaitValidate(benefitsPgHeader));
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
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
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
		// note: take too long to navigate to plan doc page so this step will
		// have together w/ planDoc
		// note: assume you are already on planDoc
		Assert.assertTrue("PROBLEM - unable to locate My Documents link on Plan Documents and Resources page",
				noWaitValidate(myDocLnk));
		try {
			myDocLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} catch (UnhandledAlertException ae) {
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
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
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
		} else if (noWaitValidate(uhcProviderSearchPaymentsLnk)) {
			uhcProviderSearchPaymentsLnk.click();
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement paymentTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-premium-payments]"));
				paymentTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Payments link on top sub menu", false);
			}
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, paymentsPgHeader, 10);
		Assert.assertTrue("PROBLEM - unable to locate header text for 'Premium Payments' page",
				noWaitValidate(paymentsPgHeader));
		return driver;
	}

	public WebDriver navigateToPnpPage() {
		CommonUtility.waitForPageLoad(driver, pnpTopMenuLnk, 10);
		if (noWaitValidate(pnpTopMenuLnk)) {
			pnpTopMenuLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement pnpTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-pharmacies]"));
				pnpTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Pharmacies and Prescriptions link on top sub menu", false);
			}
		}
		CommonUtility.checkPageIsReady(driver);
		// note: comment out for now because D-Rex team is working on the page
		// so the page is unstable
		// CommonUtility.waitForPageLoad(driver, pnpPgHeader, 10);
		// Assert.assertTrue("PROBLEM - unable to locate header text for
		// 'Pharmacies and Prescriptions' page", noWaitValidate(pnpPgHeader));
		return driver;
	}

	public WebDriver navigateToHwPage() {
		if (noWaitValidate(hwTopMenuLnk)) {
			hwTopMenuLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else if (noWaitValidate(uhcProviderSearchHwLnk)) {
			uhcProviderSearchHwLnk.click();
			CommonUtility.checkPageIsReady(driver);
		} else if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement hwTopMenuShadowRootLink = root1
						.findElement(By.cssSelector("a[data-testid*=nav-link-health-wellness]"));
				hwTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Payments link on top sub menu", false);
			}
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, hwPgHeader, 120);
		Assert.assertTrue("PROBLEM - unable to locate header text for 'Health and Wellness' page",
				noWaitValidate(hwPgHeader));
		return driver;
	}

}