package pages.regression.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.pharmaciesandprescriptions.PharmaciesAndPrescriptionsCommonConstants;
import acceptancetests.util.CommonUtility;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;

/**
 * Functionality : validations for Pharmacies & Prescriptions page
 */
public class PharmaciesAndPrescriptionsPage extends PharmaciesAndPrescriptionsBase {
	public PharmaciesAndPrescriptionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	public void validateHeaderSectionContent(String firstname, String lastName) {
		Assert.assertTrue("PROBLEM - unable to locate pnp page header element", pnpValidate(pgHeader));
		String expTxt = "Pharmacies & Prescriptions for " + firstname + " " + lastName;
		String actTxt = pgHeader.getText();
		Assert.assertTrue(
				"PROBLEM - header text is not as expected. " + "Expected='" + expTxt + "' | Actual='" + actTxt + "'",
				expTxt.equals(actTxt));
	}

	public void validatePharmaciesText() {
		Assert.assertTrue("PROBLEM - unable to locate pnp page header element", pnpValidate(pharmaciesText));
		Pattern expectedTxt1 = Pattern.compile("Get the most out of your prescription drug benefits\\.");
		Pattern expectedTxt2 = Pattern.compile(
				"You can make sure your drugs are covered, estimate costs and find ways to save money\\. .*earch for national and local pharmacies in your plan.s network to fill your prescriptions\\.");
		String actualTxt = pharmaciesText.getText();
		Assert.assertTrue(
				"PROBLEM - pharmacies text is not as expected. " + "Expected to contain '" + expectedTxt1 + "' AND '"
						+ expectedTxt2 + "' | Actual='" + actualTxt + "'",
				expectedTxt1.matcher(actualTxt).find() && expectedTxt2.matcher(actualTxt).find());
	}

	public void validateTileContent(String exp_TileHeaderTxt, String exp_TileLinkTxt, WebElement exp_pTile_Txt,
			WebElement exp_pTile_img, WebElement exp_pTile_Lnk) {
		Assert.assertTrue("PROBLEM - unable to locate '" + exp_TileHeaderTxt + "' tile header element",
				pnpValidate(exp_pTile_Txt));
		Assert.assertTrue("PROBLEM - unable to locate '" + exp_TileHeaderTxt + "' tile image element",
				pnpValidate(exp_pTile_img));
		Assert.assertTrue("PROBLEM - unable to locate '" + exp_TileHeaderTxt + "' tile link element",
				pnpValidate(exp_pTile_Lnk));

		String act_TileHeaderTxt = exp_pTile_Txt.getText().trim();
		Assert.assertTrue("PROBLEM - '" + exp_TileHeaderTxt + "' tile text not as expected. " + "Expected='"
				+ exp_TileHeaderTxt + "' | Actual='" + act_TileHeaderTxt + "'",
				exp_TileHeaderTxt.equals(act_TileHeaderTxt));

		String act_TileLnkTxt = exp_pTile_Lnk.getText().trim();
		Assert.assertTrue("PROBLEM - '" + exp_TileHeaderTxt + "' tile text not as expected. " + "Expected='"
				+ exp_TileLinkTxt + "' | Actual='" + act_TileLnkTxt + "'", exp_TileLinkTxt.equals(act_TileLnkTxt));

	}

	public void validateTileNotExist(String exp_TileHeaderTxt, WebElement exp_pTile_Txt, WebElement exp_pTile_img,
			WebElement exp_pTile_Lnk) {
		Assert.assertTrue(
				"PROBLEM - for PEEHIP member user should not see '" + exp_TileHeaderTxt + "' related elements",
				!pnpValidate(exp_pTile_Txt) && !pnpValidate(exp_pTile_img) && !pnpValidate(exp_pTile_Lnk));
	}

	/**
	 * to validate the pharmacies tiles section, determine what tiles should show up
	 * or not
	 * 
	 * @param tileDrug
	 * @param tilePharmacy
	 * @param tilePrescription
	 * @param tileDelivery
	 * @param tileBenefit
	 */
	public void validatePharmaciesTilesSection(boolean tileDrug, boolean tilePharmacy, boolean tilePrescription,
			boolean tileDelivery, boolean tileBenefit) {
		String exp_TileHeaderTxt = "Look up covered drugs and estimate costs";
		String exp_TileLinkTxt = "LOOK UP DRUGS";
		WebElement exp_tileHeaderElement = pTile_compDrugPricingHeaderTxt;
		WebElement exp_tileImg = pTile_compDrugPricingImg;
		WebElement exp_tileLnk = pTile_compDrugPricingLnk;
		if (tileDrug)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt = "Find a network pharmacy";
		exp_TileLinkTxt = "FIND A PHARMACY";
		exp_tileHeaderElement = pTile_findNtkPharmacyHeaderTxt;
		exp_tileImg = pTile_findNtkPharmacyImg;
		exp_tileLnk = pTile_findNtkPharmacyLnk;
		if (tilePharmacy)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt = "Refill home delivery prescriptions";
		exp_TileLinkTxt = "ORDER PRESCRIPTIONS";
		exp_tileHeaderElement = pTile_orderPresRefillsHeaderTxt;
		exp_tileImg = pTile_orderPresRefillsImg;
		exp_tileLnk = pTile_orderPresRefillsLnk;
		if (tilePrescription)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt = "Check home delivery order status";
		exp_TileLinkTxt = "CHECK DELIVERY STATUS";
		exp_tileHeaderElement = pTile_chkHomeDeliOrderStatusHeaderTxt;
		exp_tileImg = pTile_chkHomeDeliOrderStatusImg;
		exp_tileLnk = pTile_chkHomeDeliOrderStatusLnk;
		if (tileDelivery)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt = "View your drug spending to date";
		exp_TileLinkTxt = "DRUG COST SUMMARY";
		exp_tileHeaderElement = pTile_presBenfitInfoHeaderTxt;
		exp_tileImg = pTile_presBenfitInfoImg;
		exp_tileLnk = pTile_presBenfitInfoLnk;
		if (tileBenefit)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
	}

	public void validateTileLnkDestination(String planType, String memberType, String tile, boolean runOnTeamEnv)
			throws InterruptedException {
		String planCategoryId = "0";
		validateTileLnkDestination(planType, memberType, tile, planCategoryId, runOnTeamEnv);
	}

	/**
	 * to validate individual tile content
	 * 
	 * @param planType
	 * @param memberType
	 * @param tile
	 * @throws InterruptedException
	 */
	public void validateTileLnkDestination(String planType, String memberType, String tile, String planCategoryId,
			boolean runOnTeamEnv) throws InterruptedException { // note: if arrives here, already validated link
																// existent
		System.out.println("Proceed to validate tile='" + tile + "'...");
		if (tile.equals("Prescription Benefits Information") && !planCategoryId.equals("0")) {
			// note: prior step validation would have been done already to get to this
			// point, so just print msg
			System.out.println("Prescription Benefits Information link will not exist if LIS=0, skip this validation");
			return;
		} else if (memberType.toUpperCase().contains("PEEHIP")
				&& (tile.equals("Check home delivery order status") || tile.equals("Order prescription refills"))) {
			System.out.println(
					"Order prescription refills and Check home delivery order status tile will not exist for PEEHIP group user, skip this validation");
			return;
		}
		boolean switchTab = false;
		WebElement linkElement = null;
		String expUrl = "";
		if (tile.equals("Compare drug pricing")) {
			linkElement = pTile_compDrugPricingLnk;
			if (memberType.toUpperCase().contains("GROUP")) {
				expUrl = "https://chp-stage.optumrx.com/public/sso-landing";
				switchTab = true;
			} else
				expUrl = "/member/drug-lookup/overview.html#/drug-cost-estimator";
		} else if (tile.equals("Find a network pharmacy")) {
			linkElement = pTile_findNtkPharmacyLnk;
			expUrl = "/member/pharmacy-locator/overview.html#/Pharmacy-Search-English";
		} else if (tile.equals("Order prescription refills")) {
			linkElement = pTile_orderPresRefillsLnk;
			expUrl = "https://chp-stage.optumrx.com/public/sso-landing";
			switchTab = true;
		} else if (tile.equals("Check home delivery order status")) {
			linkElement = pTile_chkHomeDeliOrderStatusLnk;
			expUrl = "/sso";
			switchTab = true;
		} else if (tile.equals("Prescription Benefits Information")) {
			linkElement = pTile_presBenfitInfoLnk;
			expUrl = "https://chp-stage.optumrx.com/public/sso-landing";
			switchTab = true;
		}
		Assert.assertTrue("PROBLEM - need to code to support '" + tile + "' tile content validation",
				linkElement != null);

		if (switchTab) {
			String winHandleBefore = driver.getWindowHandle();
			CommonUtility.waitForPageLoad(driver, linkElement, 5);
			linkElement.click();
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs = afterClicked_tabs.size();
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs - 1));
			CommonUtility.checkPageIsReady(driver);
			String actUrl = driver.getCurrentUrl();
			if (expUrl.contains("sso")) {
				if (!runOnTeamEnv) {
					String expUrlAlternative = "https://hsid11-st1.optum.com/register/personalInfo";
					String expUrlAlternative2 = "https://chp-stage.optumrx.com/secure/my-medicine-cabinet";
					Assert.assertTrue(
							"PROBLEM - '" + tile + "' tile link destination URL is not as expected. "
									+ "Expect to contain '" + expUrl + "' or '" + expUrlAlternative + "' or '"
									+ expUrlAlternative2 + " | Actual URL='" + actUrl + "'",
							actUrl.contains(expUrl) || actUrl.contains(expUrlAlternative)
									|| actUrl.contains(expUrlAlternative2));
				} else {
					System.out.println("Test run on team env, sso is not supported, skip expected URL validation");
				}
			} else {
				Assert.assertTrue(
						"PROBLEM - '" + tile + "' tile link destination URL is not as expected. "
								+ "Expect to contain '" + expUrl + "' | Actual URL='" + actUrl + "'",
						actUrl.contains(expUrl));
			}
			driver.close();
			driver.switchTo().window(winHandleBefore);
		} else {
			linkElement.click();
			CommonUtility.checkPageIsReady(driver);
			String actUrl = driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - '" + tile + "' tile link destination URL is not as expected. "
					+ "Expect to contain '" + expUrl + "' | Actual URL='" + actUrl + "'", actUrl.contains(expUrl));
			goBackToPriorPnPpgViaBack(planType, memberType);
		}
	}

	/**
	 * to validate the plan material link. FnR page takes long time to load, only
	 * validate URL is correct
	 */
	public void validatePlanMaterialsLink() {
		Assert.assertTrue("PROBLEM - unable to locate Plan Materials icon element", pnpValidate(viewPlanMaterialsImg));
		Assert.assertTrue("PROBLEM - unable to locate Plan Materials link element", pnpValidate(viewPlanMaterialsLnk));
		String exp_lnk = "/member/documents/overview.html";
		String act_lnk = viewPlanMaterialsLnk.getAttribute("href");
		Assert.assertTrue("PROBLEM - 'PLAN MATERIALS' link url is not as expected. " + "Expect='" + exp_lnk
				+ "' | Actual='" + act_lnk + "'", act_lnk.contains(exp_lnk));
	}

	public void scrollToOptumRxSSOLink(String optumrxssolink) {
		// TODO Auto-generated method stub
		String linktobetested = optumrxssolink;
		if (linktobetested.equalsIgnoreCase("LookUpDrugsButton")) {
			System.out.println("Scrolling to LookUpDrugsButton");
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("arguments[0].scrollIntoView()", LookUpDrugsButton);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (linktobetested.equalsIgnoreCase("orderPrescriptionsButton")) {
				System.out.println("Scrolling to order Prescriptions Button");
				JavascriptExecutor jse3 = (JavascriptExecutor) driver;
				jse3.executeScript("arguments[0].scrollIntoView()", orderPrescriptionsButton);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		if (linktobetested.equalsIgnoreCase("checkDelieryStatusButton")) {
			System.out.println("Scrolling to check Deliery Status Button");
			JavascriptExecutor jse4 = (JavascriptExecutor) driver;
			jse4.executeScript("arguments[0].scrollIntoView()", checkDelieryStatusButton);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (linktobetested.equalsIgnoreCase("drugCostSummaryButton")) {
			System.out.println("Scrolling to drug Cost Summary Button");
			JavascriptExecutor jse4 = (JavascriptExecutor) driver;
			jse4.executeScript("arguments[0].scrollIntoView()", drugCostSummaryButton);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void clicksToOptumRxSSOLink(String optumrxssolink) {
		// TODO Auto-generated method stub

		String linktobetested = optumrxssolink;
		if (linktobetested.equalsIgnoreCase("LookUpDrugsButton")) {
			System.out.println("Clicking on Look Up Drugs Button");
			LookUpDrugsButton.click();
			System.out.println("Look Up Drugs Button has been clicked");
		}

		if (linktobetested.equalsIgnoreCase("orderPrescriptionsButton")) {
			System.out.println("Clicking on order Prescriptions Button Button");
			orderPrescriptionsButton.click();
			System.out.println("order Prescriptions Button has been clicked");
		}

		if (linktobetested.equalsIgnoreCase("checkDelieryStatusButton")) {
			System.out.println("Clicking on check Deliery Status Button");
			checkDelieryStatusButton.click();
			System.out.println("check Deliery Status Button has been clicked");
		}

		if (linktobetested.equalsIgnoreCase("drugCostSummaryButton")) {
			System.out.println("Clicking on drug Cost Summary Button");
			drugCostSummaryButton.click();
			System.out.println("drug Cost Summary Button has been clicked");
		}

		try {
			System.out.println("Now waiting for 4 seconds");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("switching to OptumRx  window");
		String mainwindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		try {
			System.out.println("Now waiting for 20 seconds");
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (linktobetested.equalsIgnoreCase("drugCostSummaryButton")) {
			System.out.println("Now waiting for Benefits Information header to show up");
			CommonUtility.waitForPageLoad(driver, BenefitsInformationHeaderOptumRx, 20);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = BenefitsInformationHeaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl()
					.contains("https://chp-stage.optumrx.com/secure/benefits-and-claims/benefits-information")
					&& BenefitsInformationHeaderOptumRx.getText().contains("Benefits Information")) {
				System.out.println("Benefit Information Header was displayed on page and OptumRx SSO URL was correct");
			} else {
				System.out.println(
						"OptumRx SSO URL was incorrect or Benefit Information header was not displayed, failing test script");
				Assert.fail();
			}
		}

		if (linktobetested.equalsIgnoreCase("LookUpDrugsButton")) {
			System.out.println("Now waiting for Search for a drug header to show up");
			CommonUtility.waitForPageLoad(driver, searchForADrugHeaderOptumRx, 20);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = searchForADrugHeaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl().contains("https://chp-stage.optumrx.com/secure/member-tools/drug-pricing")
					&& BenefitsInformationHeaderOptumRx.getText().contains("Drug pricing")) {
				System.out.println("Drug pricing Header was displayed on page and OptumRx SSO URL was correct");
			} else {
				System.out.println(
						"OptumRx SSO URL was incorrect or Drug pricing header was not displayed, failing test script");
				Assert.fail();
			}
		}

		if (linktobetested.equalsIgnoreCase("orderPrescriptionsButton")) {
			System.out.println("Now waiting for Welcome, in header to show up");
			CommonUtility.waitForPageLoad(driver, welcometextinheaderOptumRx, 20);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = welcometextinheaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl().contains("https://chp-stage.optumrx.com/secure/my-medicine-cabinet")
					&& welcometextinheaderOptumRx.getText().contains("Welcome,")) {
				System.out.println("Welcome, text in Header was displayed on page and OptumRx SSO URL was correct");
			} else {
				System.out.println(
						"OptumRx SSO URL was incorrect or Welcome, text in header was not displayed, failing test script");
				Assert.fail();
			}
		}

		if (linktobetested.equalsIgnoreCase("checkDelieryStatusButton")) {
			System.out.println("Now waiting for Order Status in header to show up");
			CommonUtility.waitForPageLoad(driver, orderStatusTextInHeaderOptumRx, 20);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = orderStatusTextInHeaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl().contains("https://chp-stage.optumrx.com/secure/order-status")
					&& orderStatusTextInHeaderOptumRx.getText().contains("Order status")) {
				System.out.println("Order status text in Header was displayed on page and OptumRx SSO URL was correct");
			} else {
				System.out.println(
						"OptumRx SSO URL was incorrect or Order status text in header was not displayed, failing test script");
				Assert.fail();
			}
		}

	}

	// F436319
	public void validatePharmacies_PrescriptionNotification() {

		Assert.assertTrue("PROBLEM - unable to locate pnp page notification element", validate(PnPNotification, 30));
	}

	// F436319
	public void validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages() {
		pageloadcomplete();
		Assert.assertFalse("PROBLEM - able to locate pnp page notification element", pnpValidate(PnPNotification));
	}

	// F436319
	public void validatePharmacies_PrescriptionNotificationPosition() {
		Assert.assertTrue("PROBLEM - unable to locate pnp page notification position element",
				pnpNotificationPositionValidate(PnPNotification));
	}

	// F436319
	public void navigateBackToPnPPage() {
		driver.navigate().back();
	}

	// F436319
	public void clickDrugCostSummaryCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Cost Summary to Action element",
				pnpValidate(DrugCostSummaryCallToActnBtn));
		DrugCostSummaryCallToActnBtn.click();
	}

	public void validateFindAndPriceExternalLinkIconNotDisplayed() {
		Assert.assertTrue("PROBLEM - Find and Price a Medication External Link Icon is displayed",
				pnpValidate(FindAndPriceExternalIcon));
	}

	public void validateDrugEstimatorToolPageOpensInSameWindow() {
		int size = countNoOfNewWindowTab();
		if (size == 0) {
			Assert.assertTrue("PROBLEM - Drug Estimator Tool Page is displayed in same browser window", true);
			Assert.assertTrue("PROBLEM - Drug Estimator Tool Page header is displayed successfully",
					pnpValidate(DrugEstimatorToolPageHeader, 30));
		} else {
			Assert.assertTrue("PROBLEM - Drug Estimator Tool Page is not displayed in same browser window", false);
		}
	}

	// F436319
	public void closePharmacies_PrescriptionNotification() {
		closePnPNotification(PnPNotificationCloseBtn);
	}

	// F436319
	public void validatePharmacies_PrescriptionNotificationNotDisplayedOnPnPPage() {
		Assert.assertFalse("PROBLEM - able to locate pnp page notification element", pnpValidate(PnPNotification));
	}

	// F436319
	public void validatePersistanceOfRemovalOfPharmacies_PrescriptionNotificationOnPnPPage() {
		Assert.assertFalse("PROBLEM - able to locate pnp page notification element", pnpValidate(PnPNotification));
	}

	// F436319 Drug Lookup
	public void validateDrugLookupCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Lookup call to action Tile element",
				validate(DrugLookupCallToActnBtn, 30));
	}

	public void validateFindAndPriceAMedicationCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price a Medication call to action Tile element",
				validate(FindAndPriceCallToActnBtn, 30));
	}

	public void clickFindAndPriceAMedicationCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price a Medication call to action Tile element",
				validate(FindAndPriceCallToActnBtn, 30));
		FindAndPriceCallToActnBtn.click();
	}

	public void validateANOCCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate ANOC call to action Button element",
				validate(ANOCCallToActnBtn, 30));
	}

	public void clickANOCCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate ANOC call to action Button element",
				validate(ANOCCallToActnBtn, 30));
		ANOCCallToActnBtn.click();
	}

	public void validateANOCPageHeader() {
		Assert.assertTrue("PROBLEM - unable to locate ANOC Page Header element", validate(ANOCCallToActnBtn, 30));
	}

	// F436319
	public void validateImageDrugLookupCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Lookup call to action Image element",
				pnpValidate(DrugLookupCTAImg));
	}

	// F436319
	public void validateTitleDrugLookupCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Lookup call to action Title element",
				pnpValidate(DrugLookupCTATitle));
	}

	// F436319
	public void validateDescriptionDrugLookupCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Lookup call to action Description element",
				pnpValidate(DrugLookupCTADescription));
	}

	// F436319 Pharmacy Locator Call To Action
	public void validatePharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator call to action Tile element",
				pnpValidate(PharmacyLocatorCallToActnBtn));
	}

	// F436319
	public void validateImagePharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator call to action Image element",
				pnpValidate(PharmacyLocatorCTAImg));
	}

	// F436319
	public void validateTitlePharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator call to action Title element",
				pnpValidate(PharmacyLocatorCTATitle));
	}

	// F436319
	public void validateDescriptionPharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator  call to action Description element",
				pnpValidate(PharmacyLocatorCTADescription));
	}

	// F436319 Refill Home Delivery Call To Action
	public void validateOrderPrescriptionCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Order Prescription call to action Tile element",
				pnpValidate(OrderPrescriptionCallToActnBtn));
	}

	// F436319
	public void validateImageOrderPrescriptionCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Order Prescription call to action Image element",
				pnpValidate(OrderPrescriptionCTAImg));
	}

	// F436319
	public void validateTitleOrderPrescriptionCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Order Prescription call to action Title element",
				pnpValidate(OrderPrescriptionCTATitle));
	}

	// F436319
	public void validateDescriptionOrderPrescriptionCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Order Prescription call to action Description  element",
				pnpValidate(OrderPrescriptionCTADescription));
	}

	// F436319 Drug Cost Summary To Action
	public void validateDrugCostSummaryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Cost Summary to action Tile element",
				pnpValidate(DrugCostSummaryCallToActnBtn));
	}

	// F436319 Drug Cost Summary To Action
	public void validateOrderPrescriptonCallToActionNOTDisplayedOnPnPPage() {
		boolean isOrderPrescriptionCTA_NotDisplayed = pnpValidate(OrderPrescriptionCallToActnBtn);
		Assert.assertFalse("PROBLEM - able to locate Order Prescription Call to action element",
				pnpValidate(OrderPrescriptionCallToActnBtn));
	}

	public void validateDrugCostSummaryCallToActionNOTDisplayedOnPnPPage() {
		boolean isDrugCostSummaryCTA_NotDisplayed = pnpValidate(DrugCostSummaryCallToActnBtn);
		Assert.assertFalse("PROBLEM - able to locate Drug Cost Summary Call to action element",
				pnpValidate(DrugCostSummaryCallToActnBtn));
	}

	// F436319
	public void validateImageDrugCostSummaryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Cost Summary to action Image element",
				pnpValidate(DrugCostSummaryCTAImg));
	}

	// F436319
	public void validateTitleDrugCostSummaryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Cost Summary to action  Title element",
				pnpValidate(DrugCostSummaryCTATitle));
	}

	// F436319
	public void validateDescriptionDrugCostSummaryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Cost Summary to action Description element",
				pnpValidate(DrugCostSummaryCTADescription));
	}

	// F436319
	public void validateFirstPositionOfDrugLookupCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Drug Lookup Call to Action at First Position",
				DrugLookupCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateSecondPositionOfPharmacyLocatorCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator Call to Action at Second Position",
				PharmacyLocatorCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateThirdPositionOfOrderPrescriptionCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator Call to Action at Third Position",
				OrderPrescriptionCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateFourthPositionOfDrugCostSummaryCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator Call to Action at Fourth Position",
				DrugCostSummaryCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateThirdPositionOfDrugCostSummaryCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator Call to Action at Third Position",
				DrugCostSummaryCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	// F436319
	public void clickOnFindAndPriceAMedicationCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price a Medication Call to Action element",
				pnpValidate(FindAndPriceCallToActnBtn));
		FindAndPriceCallToActnBtn.click();
	}

	// F436319
	public void validateNavigationToOptumRxDrugPricingPageOnNewTab() {
		Set handles = driver.getWindowHandles();
		String pnpPageHandle = driver.getWindowHandle();
		handles.remove(pnpPageHandle);
		String winHandle = (String) handles.iterator().next();
		if (winHandle != pnpPageHandle) {
			String OptumRxDrugPricePageHandle = winHandle;
			driver.switchTo().window(OptumRxDrugPricePageHandle);
			Assert.assertTrue("PROBLEM - unable to locate OptumRx Drug Price Page Header element",
					pnpValidate(OptumRxDrugPricePageHeader));
		}
		driver.close();
		driver.switchTo().window(pnpPageHandle);

	}

	// F436319
	public void clickOnPharmacyLocatorCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator call to Action element",
				pnpValidate(PharmacyLocatorCallToActnBtn));
		PharmacyLocatorCallToActnBtn.click();
	}

	// F436319
	public void validateNavigationToChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate Choose a plan year page Header element",
				pnpValidate(HeaderOnChoosePlanYearPage));

	}

	// F436319
	public void clickOnOrderPrescriptionCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Order Prescription call to Action element",
				pnpValidate(OrderPrescriptionCallToActnBtn));
		OrderPrescriptionCallToActnBtn.click();

	}

	// F436319
	public void validateNavigationToOptumRxMedicineCabinetOnNewTab() {

		Set handles = driver.getWindowHandles();
		String pnpPageHandle = driver.getWindowHandle();
		handles.remove(pnpPageHandle);
		String winHandle = (String) handles.iterator().next();
		if (winHandle != pnpPageHandle) {
			String OptumRxMedicineCabinetPageHandle = winHandle;
			driver.switchTo().window(OptumRxMedicineCabinetPageHandle);
			Assert.assertTrue("PROBLEM - unable to locate OptumRx Medicine Cabinet Page Header element",
					pnpValidate(OptumRxMedicineCabinetHeader));
		}
		driver.close();
		driver.switchTo().window(pnpPageHandle);

	}

	public void validateNavigationToOptumRxManagePrescriptionOnNewTab() {

		Set handles = driver.getWindowHandles();
		String pnpPageHandle = driver.getWindowHandle();
		handles.remove(pnpPageHandle);
		String winHandle = (String) handles.iterator().next();
		if (winHandle != pnpPageHandle) {
			String OptumRxMedicineCabinetPageHandle = winHandle;
			driver.switchTo().window(OptumRxMedicineCabinetPageHandle);
			Assert.assertTrue("PROBLEM - unable to locate OptumRx Manage Prescription Page Header element",
					pnpValidate(OptumRxManagePrescriptionHeader, 30));
		}
		driver.close();
		driver.switchTo().window(pnpPageHandle);

	}

	public void validateNavigationToOptumRxBenefitsInformationOnNewTab() {

		Set handles = driver.getWindowHandles();
		String pnpPageHandle = driver.getWindowHandle();
		handles.remove(pnpPageHandle);
		String winHandle = (String) handles.iterator().next();
		if (winHandle != pnpPageHandle) {
			String OptumRxMedicineCabinetPageHandle = winHandle;
			driver.switchTo().window(OptumRxMedicineCabinetPageHandle);
			Assert.assertTrue("PROBLEM - unable to locate OptumRx Benefits Information Page Header element",
					pnpValidate(OptumRxBenefitsInformationHeader, 30));
		}
		driver.close();
		driver.switchTo().window(pnpPageHandle);

	}

	public void validateBackButtonOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate Back Button element on Choose a plan year page",
				pnpValidate(BackButtonOnChoosePlanYearPage));
	}

	public void validateHeaderOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate Header element on Choose a plan year page",
				pnpValidate(HeaderOnChoosePlanYearPage));
	}

	public void validateDescriptiveContentOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate Descriptive Content element on Choose a plan year page",
				pnpValidate(DescriptiveContentOnChoosePlanYearPage));
	}

	public void validateTwentyTwentyCTAOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2020 CTA element on Choose a plan year page",
				pnpValidate(PharmacyLocator2020CTA));
	}

	public void clickTwentyTwentyCTAOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2020 CTA element on Choose a plan year page",
				pnpValidate(PharmacyLocator2020CTA));
		PharmacyLocator2020CTA.click();
	}

	public void validateTwentyTwentyOneCTAOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2021 CTA element on Choose a plan year page",
				pnpValidate(PharmacyLocator2021CTA));
	}

	public void clickTwentyTwentyOneCTAOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2021 CTA element on Choose a plan year page",
				pnpValidate(PharmacyLocator2021CTA));
		PharmacyLocator2021CTA.click();
	}

	public void validateExternalIconNotDisplayedForTwentyTwentyCTAOnChoosePlanYearPage() {
		Assert.assertFalse("PROBLEM - able to locate External Icon for 2020 CTA element on Choose a plan year page",
				pnpValidate(PharmacyLocator2020CTAExternalIcon));
	}

	public void validatePharmacyLocatortoolbuiltbyRallyInSameBrowserWindow() {
		int size = countNoOfNewWindowTab();
		if (size == 0) {
			Assert.assertTrue("PROBLEM - Pharmacy Locator Tool Page is displayed in same browser window", true);
			Assert.assertTrue("PROBLEM - Pharmacy Locator Tool Page header is displayed successfully",
					pnpValidate(HeaderOnPharmacyLocatorPageByRally, 30));
		} else {
			Assert.assertTrue("PROBLEM - Pharmacy Locator Tool Page is not displayed in same browser window", false);
		}
	}

	public void validateLegacyPharmacyLocatortoolInSameBrowserWindow() {
		int size = countNoOfNewWindowTab();
		if (size == 0) {
			Assert.assertTrue("PROBLEM - Legacy Pharmacy Locator Tool Page is displayed in same browser window", true);
			Assert.assertTrue("PROBLEM - Legacy Pharmacy Locator Tool Page header is displayed successfully",
					pnpValidate(HeaderLegacyPharmacyLocatorPage, 30));
		} else {
			Assert.assertTrue("PROBLEM - Legacy Pharmacy Locator Tool Page is not displayed in same browser window",
					false);
		}
	}

	public void clickBackButtonOnPharmacyLocatortoolbuiltbyRally() {
		Assert.assertFalse("PROBLEM - unable to locate Back Button On Pharmacy Locator Page By Rally ",
				pnpValidate(BackButtonOnPharmacyLocatorPageByRally));
		BackButtonOnPharmacyLocatorPageByRally.click();
	}

	public void validateFAQSectionOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2021 CTA element on Choose a plan year page",
				pnpValidate(FAQSectionOnChoosePlanYearPage));
	}

	public void validateNeedHelpSectionOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2021 CTA element on Choose a plan year page",
				pnpValidate(NeedHelpSectionOnChoosePlanYearPage));
	}

	public void validateMoreInfoSectionOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2021 CTA element on Choose a plan year page",
				pnpValidate(MoreInformationSectionOnChoosePlanYearPage));
	}

	public void validateGlobalFooterOnChoosePlanYearPage() {
		Assert.assertTrue("PROBLEM - unable to locate 2021 CTA element on Choose a plan year page",
				pnpValidate(GlobalFooterSectionOnChoosePlanYearPage));
	}

}
