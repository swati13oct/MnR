package pages.regression.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.memberredesign.pharmaciesandprescriptions.RefillCheckoutSummaryStepDefinition;
import acceptancetests.util.CommonUtility;
import pages.regression.testharness.TestHarness;

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
	 * 
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
			TestHarness.checkForIPerceptionModel(driver);
			LookUpDrugsButton.click();
			System.out.println("Look Up Drugs Button has been clicked");
		}

		if (linktobetested.equalsIgnoreCase("orderPrescriptionsButton")) {
			System.out.println("Clicking on order Prescriptions Button Button");
			TestHarness.checkForIPerceptionModel(driver);
			orderPrescriptionsButton.click();
			System.out.println("order Prescriptions Button has been clicked");
		}

		if (linktobetested.equalsIgnoreCase("checkDelieryStatusButton")) {
			System.out.println("Clicking on check Delivery Status Button");
			TestHarness.checkForIPerceptionModel(driver);
			checkDelieryStatusButton.click();
			System.out.println("check Delivery Status Button has been clicked");
		}

		if (linktobetested.equalsIgnoreCase("drugCostSummaryButton")) {
			System.out.println("Clicking on drug Cost Summary Button");
			TestHarness.checkForIPerceptionModel(driver);
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
			CommonUtility.waitForPageLoad(driver, BenefitsInformationHeaderOptumRx, 40);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = BenefitsInformationHeaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl().contains("optumrx.com/secure/benefits-and-claims/benefits-information")
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
			CommonUtility.waitForPageLoad(driver, searchForADrugHeaderOptumRx, 40);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = searchForADrugHeaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl().contains("optumrx.com/secure/member-tools/drug-search")
					&& searchForADrugHeaderOptumRx.getText().contains("Search for a drug")) {
				System.out.println("Search for a drug Header was displayed on page and OptumRx SSO URL was correct");

			} else {
				System.out.println(
						"OptumRx SSO URL was incorrect or Search for a drug  header was not displayed, failing test script");

				Assert.fail(
						"Meesage: OptumRx SSO URL was incorrect or Search for a drug  header was not displayed, failing test script");

			}

		}

		if (linktobetested.equalsIgnoreCase("orderPrescriptionsButton"))

		{
			System.out.println("Now waiting for My Prescriptions in header to show up");
			CommonUtility.waitForPageLoad(driver, welcometextinheaderOptumRx, 40);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = welcometextinheaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl().contains("optumrx.com/secure/my-prescriptions")
					&& welcometextinheaderOptumRx.getText().contains("My Prescriptions"))

			{
				System.out.println(
						"My Prescriptions text in Header was displayed on page and OptumRx SSO URL was correct");

			} else

			{
				System.out.println(
						"OptumRx SSO URL was incorrect or My Prescriptions text in header was not displayed, failing test script");

				Assert.fail();

			}

		}

		if (linktobetested.equalsIgnoreCase("checkDelieryStatusButton")) {
			System.out.println("Now waiting for Order Status in header to show up");
			CommonUtility.waitForPageLoad(driver, orderStatusTextInHeaderOptumRx, 40);
			System.out.println("URL opened in new window is:   " + driver.getCurrentUrl());
			System.out.println("Page title is:   " + driver.getTitle());
			String getHeaderText = orderStatusTextInHeaderOptumRx.getText();
			System.out.println("Header text of page is  " + getHeaderText);
			if (driver.getCurrentUrl().contains("optumrx.com/secure/order-status")
					&& orderStatusTextInHeaderOptumRx.getText().contains("Order status")) {
				System.out.println("Order status text in Header was displayed on page and OptumRx SSO URL was correct");

			} else

			{
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
		int size = countOfNewWindowTab();
		if (size == 1) {
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
	public void validateImageANOCCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate ANOC to action Image element", pnpValidate(ANOCCTAImg));
	}

	// F436319
	public void validateTitleDrugCostSummaryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Cost Summary to action  Title element",
				pnpValidate(DrugCostSummaryCTATitle));
	}

	public void validateTitleANOCCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate ANOC to action  Title element", pnpValidate(ANOCCTATitle));
	}

	// F436319
	public void validateDescriptionDrugCostSummaryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Drug Cost Summary to action Description element",
				pnpValidate(DrugCostSummaryCTADescription));
	}

	// F436319
	public void validateFirstPositionOfFindAndPriceCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Find And Price Call to Action at First Position",
				FindAndPriceCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateSecondPositionOfPharmacyLocatorCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator Call to Action at Second Position",
				PharmacyLocatorCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateThirdPositionOfOrderPrescriptionCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator Call to Action at Third Position",
				OrderPrescriptionCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateFourthPositionOfANOCCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate ANOC Call to Action at Fourth Position",
				ANOCCallToActnBtn.getAttribute("data-cta-position").equals(position));
	}

	public void validateThirdPositionOfANOCCallToActionOnPnPPage(String position) {
		Assert.assertTrue("PROBLEM - unable to locate ANOC Call to Action at Third Position",
				ANOCCallToActnBtn.getAttribute("data-cta-position").equals(position));
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
		int size = countOfNewWindowTab();
		if (size == 1) {
			Assert.assertTrue("PROBLEM - Pharmacy Locator Tool Page is displayed in same browser window", true);
			Assert.assertTrue("PROBLEM - Pharmacy Locator Tool Page header is displayed successfully",
					pnpValidate(HeaderOnPharmacyLocatorPageByRally, 30));
		} else {
			Assert.assertTrue("PROBLEM - Pharmacy Locator Tool Page is not displayed in same browser window", false);
		}
	}

	public void validateLegacyPharmacyLocatortoolInSameBrowserWindow() {
		int size = countOfNewWindowTab();
		if (size == 1) {
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

	// F436319 Find and Price
	public void validateFindAndPriceCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price call to action Tile element",
				pnpValidate(findPrescriptionsCallToActnBtn));
	}

	// F436319
	public void validateImageFindAndPriceCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price call to action Image element",
				pnpValidate(findPrescriotionImage));
	}

	// F436319
	public void validateTitleFindAndPriceCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price call to action Title element",
				pnpValidate(findPrescriptionTitle));
	}

	// F436319
	public void validateDescriptionFindAndPriceCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price call to action Description element",
				pnpValidate(findPrescriptionDesc));
	}

	// F436319 Refill Home Delivery Call To Action
	public void validateRefillHomeDeliveryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Refill Home Delivery call to action Tile element",
				pnpValidate(managePrescriptionCallToActnBtn));
	}

	// F436319
	public void validateImageRefillHomeDeliveryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Refill Home Delivery call to action Image element",
				pnpValidate(managePresciptionImage));
	}

	// F436319
	public void validateTitleRefillHomeDeliveryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Refill Home Delivery call to action Title element",
				pnpValidate(managePrescriptionTitle));
	}

	// F436319
	public void validateDescriptionRefillHomeDeliveryCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Refill Home Delivery  call to action Description  element",
				pnpValidate(managePrescriptionDesc));
	}

	// F436319 Whats New Call To Action
	public void validateWhatsNewCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate whats new call to action Tile element",
				pnpValidate(whatsNewCallToActnBtn));
	}

	// F436319 Whats New Call To Action
	public void validateWhatsNewCallToActionNOTDisplayedOnPnPPage() {
		Assert.assertFalse("PROBLEM - able to locate whats new call to action element",
				pnpValidate(whatsNewCallToActnBtn));
	}

	// F436319
	public void validateImageWhatsNewCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate whats new call to action Image element",
				pnpValidate(whatsNewImage));
	}

	// F436319
	public void validateTitleWhatsNewCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate whats new call to action  Title element",
				pnpValidate(whatsNewTitle));
	}

	// F436319
	public void validateDescriptionWhatsNewCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate whats new call to action Description element",
				pnpValidate(whatsNewDesc));
	}

	// F436319
	public void clickOnFindAndPriceCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price Call to Action element",
				pnpValidate(findPrescriptionsCallToActnBtn));
		findPrescriptionsCallToActnBtn.click();

	}

	// F436319
	public void validateNavigationToPharmacyLocatorToolPage() {
		/*
		 * Set handles = driver.getWindowHandles(); String pnpPageHandle =
		 * driver.getWindowHandle(); handles.remove(pnpPageHandle); String winHandle=
		 * (String) handles.iterator().next(); if (winHandle!=pnpPageHandle){ String
		 * OptumRxDrugPricePageHandle=winHandle;
		 * driver.switchTo().window(OptumRxDrugPricePageHandle); }
		 */
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator Tool Header element",
				pnpValidate(PharmacyLocatorToolHeader));
		/*
		 * driver.close(); driver.switchTo().window(pnpPageHandle);
		 */

	}

	// F436319
	public void clickOnRefillHomeDeliveryCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Refill Home Delivery call to Action element",
				pnpValidate(managePrescriptionCallToActnBtn));
		managePrescriptionCallToActnBtn.click();

	}

	// F392596 Meidine Cabinet
	public void validateCurrentMedicationsHeader() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", CurrentMedicationsHeader);
		Assert.assertTrue("PROBLEM - unable to locate Current Medications Header element",
				pnpValidate(CurrentMedicationsHeader));
	}

	public void validateOrderStatusHeader() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", orderStatusPageHeader);
		Assert.assertTrue("PROBLEM - unable to locate Order status Header element", pnpValidate(orderStatusPageHeader));
	}

	public void validateMyMedicationsHeader() {

		Assert.assertTrue("PROBLEM - unable to locate My Medications Header element", pnpValidate(myMedicationsHeader));
	}

	public void validateSixActivePrescriptions() {

		Assert.assertTrue("PROBLEM - unable to locate Current Medications Active Prescriptions text element",
				tenActivePrescription());
	}

	public void validateMoreThenTenActivePrescriptions() {

		Assert.assertTrue("PROBLEM - unable to locate more than 10 Active Prescriptions  element",
				moreThanTenActivePrescription());
	}

	public void validateExternalLink() {

		Assert.assertTrue("PROBLEM - unable to locate external link element", externalLink());
	}

	public void validateAssociatedCallToAction() {

		Assert.assertTrue("PROBLEM - unable to locate Associated Call To Action element", associatedCallToAction());
	}

	public void validateNumberInParenthesis() {

		Assert.assertTrue("PROBLEM - unable to validate  a number in parentheses ", alphaNumeric());
	}

	public void validateCorrespondingNumberInParenthesis() {

		Assert.assertTrue(
				"PROBLEM - unable to validate that number will correspond to the total number of active medications I have ",
				corredpondingMedicationsNumbers());

	}

	public void validateDisclaimer() {
		Assert.assertTrue("PROBLEM - unable to locate the disclaimer Medication appearance subject to change  element",
				disclaimer());
	}

	// F392596
	public void clickOnViewAllMedicationsLink() {
		Assert.assertTrue("PROBLEM - unable to locate Medicine Cabinet View All Medications link text element",
				validate(ViewAllMedications, 50));
		ViewAllMedications.click();

	}

	// F392596
	public void validateMyMedicationsPage() {
		Assert.assertTrue("PROBLEM - unable to locate My Medications Page Header element",
				pnpValidate(MyMedicationsPageHeader));
	}

	public void validateMedicationName() {
		Assert.assertTrue("PROBLEM -  Medication Name Value not available", validateFieldValueContent(listOfDrugName));
	}

	public void validateImage() throws Exception {
		Assert.assertTrue("PROBLEM - Medication Drug Image not available", validateDrugImage(listOfDrugImage));
	}

	public void validateStrength() {
		Assert.assertTrue("PROBLEM - Strength of the medicine Strength not available",
				validateMedicineStrengthFieldValue());
	}

	public void validatePriceMemberPaid() {
		Assert.assertTrue("PROBLEM - You Paid Amount not available", validateFieldValueContent(listOfYouPaid));
	}

	public void validateRefillsLeft() {
		Assert.assertTrue("PROBLEM - Refills Left not available", validateFieldValueContent(listOfRefillsLeft));
	}

	public void validateRefillsLeftWalgreens() {
		Assert.assertTrue("PROBLEM - Refills Left amount not available",
				validateRefillLeftAmount(walgreensRefillsLeft));
	}

	public void validateNeedHelpSectionPhoneNumbers() {

		Assert.assertTrue("PROBLEM - Need Help section phone numbers not available",
				validateNeedHelpsPhoneNumbers());

	}

	public void validateNeedHelpSectionHours() {

		Assert.assertTrue("PROBLEM - Need Help section hours of operations not available",
				validateNeedHelpsHoursOfOperations());
	}

	public void validateDayOfSupply() {
		Assert.assertTrue("PROBLEM - Days Of Supply not available", validateFieldValueContent(listOfDaysSupply));
	}

	public void validateOrderStatus() {
		Assert.assertTrue("PROBLEM - Order Status for applicable Medication not available",
				validateOrderStatusForAssociatedCTA());
	}

	public void validateTrackStatusButton() {
		Assert.assertTrue("PROBLEM - Track Status button for applicable Medication not available",
				validateTrackStatusBtn());
	}

	public void validateDelivered() {
		Assert.assertTrue("PROBLEM - Delivered for applicable Medication not available", validateDeliveredStatus());
	}

	public void validateViewOrderButton() {
		Assert.assertTrue("PROBLEM - View Order button for applicable Medication not available", viewOrderButton());
	}

	public void validateHDAssociateOrderStatus() {
		Assert.assertTrue("PROBLEM - Track Order Status for applicable Home Delivery Drug not available",
				validateOrderStatusForTrackHDDrug());
	}

	public void validateHDOrderStatusForInProg() {
		Assert.assertTrue("PROBLEM - Order Status for in progress Home Delivery Drug not available",
				validateOrderStatusForTrackHDDrug());
	}

	List<String> listOfOrderStatusForTrackHDMedicine = new ArrayList<>(Arrays.asList("Request Received",
			"Verifying With Doctor", "Order Verified", "Order Processing", "Shipped", "Delivered"));

	public boolean validateOrderStatusForTrackHDDrug() {
		List<Integer> listOfIndex = getListOfIndexForHDPharmacy();
		for (Integer val : listOfIndex) {
			if (!listOfOrderStatusForTrackHDMedicine.contains(listOfOrderStatus.get(val).getText())) {
				return false;
			}
		}
		return true;
	}

	public void validateRelevantCallToAction() {
		Assert.assertTrue("PROBLEM - Relevant calls to action not available", validateCallToActionsForHDDrug());
	}

	public void validateInfoOnRemainingRefills() {
		Assert.assertTrue("PROBLEM - Information On Remaining Refills not available",
				validateFieldValueContent(listOfRefillsLeft));
	}

	public void validateContactPharmacyButton(String expectedContactPharmacy) {
		Assert.assertTrue("PROBLEM - Contact Pharmacy Button not available",
				validateContactPharmacyButtonForRetailDrug(expectedContactPharmacy));
	}

	/*
	 * public void clickOnMedicationName() {
	 * Assert.assertTrue("PROBLEM - unable to locate Medicine name element",
	 * pnpValidate(FirstCurrentMedication)); FirstCurrentMedication.click();
	 * Assert.assertTrue("PROBLEM - unable to locate Medicine name element",
	 * pnpValidate(MedicationName)); MedicationName.click();
	 * 
	 * }
	 */

	public void validatePharmacyName() {
		Assert.assertTrue("PROBLEM - Pharmacy Name  not available", validateFieldValueContent(listOfPharmacyName));
	}

	public void validateDrugDetailOverview() {
		PharmaciesAndPrescriptionsBase pnpBase = new PharmaciesAndPrescriptionsBase(driver);
		String drugName = pnpBase.getDrugName();
		String currentURL = driver.getCurrentUrl();
		boolean flag = true;
		if (currentURL.contains("overview.html#/medication-information")) {
			Assert.assertTrue("SUCCESS - User redirected to medication information overview page", flag);
			if (drugName.contains(MedicationName_OnDrugInfoPage.getText())) {
				Assert.assertTrue("SUCCESS - Drug Name verified on medication information overview page", flag);
			} else {
				Assert.assertTrue("PROBLEM - Drug Name NOT verified on medication information overview page", flag);
			}
		} else {
			Assert.assertTrue("PROBLEM - User NOT redirected to medication information overview page", flag);
		}
	}

	public void validateViewAllMedicationsLink() {
		Assert.assertTrue("PROBLEM - unable to locate Medicine Cabinet View All Medications link text element",
				pnpValidate(ViewAllMedications));
	}

	public void validateRequestReceived() {

		Assert.assertTrue("PROBLEM - unable to locate Request received elements",

				isRequestReceived());
	}

	public void validateOptumRx() {

		Assert.assertTrue("PROBLEM - unable to locate Request received elements", isOptumRX());
	}

	public void validateProcessing() {

		Assert.assertTrue("PROBLEM - unable to locate Request received elements",

				isOrderProcessing());
	}

	// F392596 Meidine Cabinet// when user click on learn more button on current
	// medication on PNP page.

	public void validateDrugInfopage() {
		PharmaciesAndPrescriptionsBase pnpBase = new PharmaciesAndPrescriptionsBase(driver);
		String drugName = pnpBase.getDrugNameLearnMore();
		String currentURL = driver.getCurrentUrl();
		boolean flag = true;

		if (currentURL.contains("overview.html#/medication-information")) {
			Assert.assertTrue("SUCCESS - User redirected to medication information overview page", flag);
			if (drugName.contains(MedicationName_OnDrugInfoPage.getText())) {
				Assert.assertTrue("SUCCESS - Drug Name verified on medication information overview page", flag);
			} else {
				Assert.assertTrue("PROBLEM - Drug Name NOT verified on medication information overview page", flag);
			}
		} else {
			Assert.assertTrue("PROBLEM - User NOT redirected to medication information overview page", flag);
		}

	}

	public void validateWalgreensSubmitRequestBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", submitRequestBtn);
		Assert.assertTrue("PROBLEM - unable to locate Walgreens website Submit request button element",
				pnpValidate(submitRequestBtn));
	}

	public void validateHalfHarveyBall() {
		Assert.assertTrue("PROBLEM - unable to locate half Harvey ball  elements", isHalfHarveyBall());
	}

	public void validateOneFourthHarveyBall() {
		Assert.assertTrue("PROBLEM - unable to locate three fourth Harvey ball  elements", isOneFourthHarveyBall());
	}

	public void validateWalgreensDrug() {
		Assert.assertTrue("PROBLEM - unable to locate Walgreens Drug", validateWalgreens());
		// pnpValidate(RefillMedications));
	}

	public void validateRefillMedications() {
		Assert.assertTrue("PROBLEM - unable to locate HD Drug Eligible For Refill", validateHDDrugEligibleForRefill());
		// pnpValidate(RefillMedications));
	}

	public void validateRenewMedications() {
		Assert.assertTrue("PROBLEM - unable to locate Renewal Medicationss text element",
				validateHDDrugEligibleForRenew());
		// pnpValidate(RenewMedications));
	}

	public void validateMedicationsOnActionableHold() {
		Assert.assertTrue("PROBLEM - unable to locate Renewal Medicationss text element",
				validateHDDrugEligibleForRenew());
		// pnpValidate(RenewMedications));
	}

	public List<String> getDrugNameListValue() {
		List<String> listOfDrug = new ArrayList<>();
		int size = listOfDrugName.size();
		int expectedSize = 6;
		try {
			waitforElementVisibilityInTime(NumberInParenthesis, 20);
			String numberTXT = NumberInParenthesis.getText();
			int number = Integer.parseInt(numberTXT.replaceAll("[^0-9]", ""));
			if (number < 6) {
				expectedSize = number;
			}
		} catch (Exception e) {
			System.out.println("Got exception ");
			String numberTXT = drugsAvailableOnMyMedication.getText();
			expectedSize = Integer.parseInt(numberTXT);
		}
		System.out.println("Expected Drug Name Size" + expectedSize);
		while (size != expectedSize) {
			size = listOfDrugName.size();
		}
		for (WebElement ele : listOfDrugName) {
			waitforElementVisibilityInTime(ele, 50);
			System.out.println("Value of Drug Name :" + ele.getText());
			listOfDrug.add(ele.getText());
		}
		return listOfDrug;
	}

	public boolean validateFieldValueContent(List<WebElement> listOfWebElement) {
		if (listOfWebElement.size() > 0) {
			for (WebElement ele : listOfWebElement) {
				waitforElementVisibilityInTime(ele, 50);
				System.out.println("Value of Element :" + ele.getText());
				if (ele.getText().isEmpty()) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean validateRefillLeftAmount(WebElement refillLeft) {

		int refill = Integer.parseInt(refillLeft.getText());
		if (refill > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateDrugImage(List<WebElement> listOfWebElement) throws Exception {
		int size = listOfWebElement.size();
		int expectedSize = 6;
		String numberTXT = NumberInParenthesis.getText();
		int number = Integer.parseInt(numberTXT.replaceAll("[^0-9]", ""));
		if (number < 6) {
			expectedSize = number;
		}
		System.out.println("Expected Drug Img Size : " + expectedSize);
		int count = 60;
		while (size != expectedSize) {
			size = listOfWebElement.size();
			count--;
			if (count == 0) {
				throw new Exception("Drug Image not available");
			}
		}
		if (listOfWebElement.size() > 0) {
			for (WebElement ele : listOfWebElement) {
				if (ele.getAttribute("src").isEmpty()) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean validateMedicineStrengthFieldValue() {
		if (listOfDrugName.size() > 0) {
			for (WebElement ele : listOfDrugName) {
				if (ele.getText().isEmpty()) {
					return false;
				}

				/*
				 * String[] arrayOfMedicineName = ele.getText().split(" "); if
				 * (arrayOfMedicineName[arrayOfMedicineName.length - 1].isEmpty()) { return
				 * false; }
				 */
			}
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> getListOfIndexForRetailPharmacy() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			scrollToView(listOfPharmacyName.get(i));
			String text = listOfPharmacyName.get(i).getText();
			for (WebElement child : listOfPharmacyName.get(i).findElements(By.xpath("./*"))) {
				text = text.replaceFirst(child.getText(), "");
			}

			/*
			 * if (listOfPharmacyName.get(i).getText().equals("OptumRx")) {
			 * listOfIndex.add(i); }
			 */

			if (!text.trim().equals("OptumRx")) {
				listOfIndex.add(i);
			}
		}
		System.out.println("List of Retail Pharmacy :" + listOfIndex);
		return listOfIndex;
	}

	public List<Integer> getListOfIndexForHDPharmacy() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			String text = listOfPharmacyName.get(i).getText();
			for (WebElement child : listOfPharmacyName.get(i).findElements(By.xpath("./*"))) {
				text = text.replaceFirst(child.getText(), "");
			}

			/*
			 * if (listOfPharmacyName.get(i).getText().equals("OptumRx")) {
			 * listOfIndex.add(i); }
			 */
			System.out.println("HD Pharmacy " + text.trim());
			if (text.trim().equals("OptumRx")) {
				listOfIndex.add(i);
			}

		}
		return listOfIndex;
	}

	String[] listOfCallToActionForHDMed = { "TRACK STATUS", "RESOLVE HOLD", "REFILL MEDICATION", "RENEW MEDICATION",
			"VIEW ORDER" };

	public boolean validateCallToActionsForHDDrug() {
		List<Integer> listOfIndex = getListOfIndexForHDPharmacy();
		System.out.println("Size of HD Pharmacy :" + listOfIndex.size());
		List<String> listOfCallToActionForHDMedicine = Arrays.asList(listOfCallToActionForHDMed);
		if (listOfIndex.size() > 0) {
			for (Integer val : listOfIndex) {
				if (!listOfCallToActionForHDMedicine.contains(listOfCallToActnForActiveMedication.get(val).getText())) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean validateContactPharmacyButtonForRetailDrug(String expectedButtonValue) {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		if (listOfIndex.size() > 0) {
			int count = 0;
			for (Integer val : listOfIndex) {
				if (listOfCTAWithoutSpanTag.get(val).getText().equalsIgnoreCase(expectedButtonValue)
						&& listOfCTAWithoutSpanTag.get(val).getTagName().equals("button") && listOfCTAWithoutSpanTag
								.get(val).getCssValue("background-color").equals("rgba(13, 136, 11, 1)")) {
					count = count + 1;
				}
			}
			return count == listOfIndex.size();
		} else {
			return false;
		}
	}

	public void clickOnContactPharmacy() {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		Random rand = new Random();
		int rand_int = rand.nextInt(listOfIndex.size());
		System.out.println(listOfIndex.get(rand_int));
		listOfCTAWithoutSpanTag.get(listOfIndex.get(rand_int)).click();
	}

	public boolean validateContactPharmacyPopUpHavingNumber() {
		boolean flag = false;
		if (validate(contactPharmacyPopUp, 30)) {
			String contactNumber = contactPharmacyNumber.getText();
			String[] arrayval = contactNumber.split(" ");
			String pattern = "(?:\\d{3}-){2}\\d{4}";
			if (!arrayval[1].trim().isEmpty() && arrayval[1].matches(pattern)
					&& (arrayval[2] + " " + arrayval[3]).equals("(TTY 711)")) {
				flag = true;
			}
		} else {
			Assert.assertTrue("PROBLEM - Contact Pharmacy PopUp not available", flag);
		}
		return flag;
	}

	public boolean validateOrderStatusForAssociatedCTA() {
		List<Integer> listOfIndex = getListOfIndexForTrackAndViewOrderCTA();
		try {
			if (listOfIndex.size() > 0) {
				if (listOfIndex.size() == listOfOrderStatus.size()) {
					for (int i = 0; i < listOfOrderStatus.size(); i++) {
						if (listOfOrderStatus.get(i).getText().isEmpty()) {
							return false;
						}
					}
				} else {
					return false;
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public List<Integer> getListOfIndexForTrackCTA() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfCallToActnForActiveMedication.size(); i++) {
			System.out.println(listOfCallToActnForActiveMedication.get(i).getText());
			if (listOfCallToActnForActiveMedication.get(i).getText().equalsIgnoreCase("Track Status")) {
				listOfIndex.add(i);
			}
		}
		System.out.println("List of Index For Track Status " + listOfIndex);
		return listOfIndex;
	}

	public List<Integer> getListOfIndexForTrackAndViewOrderCTA() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfCallToActnForActiveMedication.size(); i++) {
			String status = listOfCallToActnForActiveMedication.get(i).getText();
			System.out.println(status);
			if (status.equalsIgnoreCase("Track Status") || status.equalsIgnoreCase("View Order")) {
				listOfIndex.add(i);
			}
		}
		System.out.println("List of Index For Track Status " + listOfIndex);
		return listOfIndex;
	}

	public void validateActiveRetailMedication() {
		Assert.assertTrue("PROBLEM - Active Retail not available", validateRetailMedication());
	}

	public boolean validateRetailMedication() {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				System.out.println("Retail Pharmacy Name :" + listOfPharmacyName.get(val).getText());
				if (listOfPharmacyName.get(val).getText().equals("OptumRx")) {
					return false;
				}
			}
			return true;

		} else {
			return false;
		}
	}

	public void validatePhoneNumberOnPopUp() {
		Assert.assertTrue("PROBLEM - Phone Number not available on PopUp", validateContactPharmacyPopUpHavingNumber());
	}

	public List<Integer> getOrderStatusIndexBasedOnStatusValue(String orderStatus) {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfOrderStatus.size(); i++) {
			if (listOfOrderStatus.get(i).getText().trim().equalsIgnoreCase(orderStatus)) {
				scrollToView(listOfOrderStatus.get(i));
				listOfIndex.add(i);
			}
		}
		System.out.println("Order Status size :" + listOfIndex.size());
		return listOfIndex;
	}

	public boolean validateHarveyBallForHDDrugOrder(String orderStatus, String ballSize) {
		List<Integer> listOfIndex = getOrderStatusIndexBasedOnStatusValue(orderStatus);
		if (listOfIndex.size() != 0) {
			int count = 0;
			for (Integer val : listOfIndex) {
				scrollToView(listOfHarveyBall.get(val));
				if (orderStatus.equalsIgnoreCase("Completed")
						&& listOfHarveyBall.get(val).getAttribute("data-testid").contains(ballSize)
						&& validate(listOfCheckMarkOnFullHarveyBall.get(val), 30)) {
					scrollToView(listOfCheckMarkOnFullHarveyBall.get(val));
					count = count + 1;
				} else if (listOfHarveyBall.get(val).getAttribute("data-testid").contains(ballSize)) {
					count = count + 1;
				}
			}
			return count == listOfIndex.size();
		} else {
			return false;
		}
	}

	public boolean clickOnTrackOrderStatus(String orderStatus) {
		return true;
	}

	public boolean clickOnHDDrugCTA(String orderStatus, String callToAction) {
		List<Integer> listOfIndex = getOrderStatusIndexBasedOnStatusValue(orderStatus);
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				if (listOfCallToActionOnMedication.get(val).getText().equals(callToAction)) {
					listOfCallToActionOnMedication.get(val).click();
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public boolean validateOderStatusPageURL() {
		if (driver.getCurrentUrl().contains("/pharmacy/overview.html#/order-status")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validatePAndPPageURL() {
		if (driver.getCurrentUrl().contains("/pharmacy/overview.html#/")) {
			return true;
		} else {
			return false;
		}
	}

	public void validateOderStatusPage() {
		Assert.assertTrue("PROBLEM - Order Status page is not displayed", validateOderStatusPageURL());
	}

	public void validatePAndPPage() {
		Assert.assertTrue("PROBLEM - P and P page is not displayed", validatePAndPPageURL());
	}

	public void validateClickOnHDDrugCTA(String orderStatus, String callToAction) {
		Assert.assertTrue("PROBLEM - " + orderStatus + " Call to action button is not available on Current Medication",
				clickOnHDDrugCTA(orderStatus, callToAction));
	}

	public void validateClickOnTrackOrderStatus() {
		List<String> list = Arrays.asList("Request Received", "Verifying with Doctor", "Order Verified",
				"Order Processing", "Order Processed", "Order Shipped");
		ArrayList<String> trackOrderStatus = new ArrayList<String>();
		trackOrderStatus.addAll(list);
		for (String status : trackOrderStatus) {
			clickOnTrackOrderStatus(status);
		}
	}

	public void validateOrderStatusForHDDrug(String orderStatus) {
		Assert.assertTrue("PROBLEM - " + orderStatus + " Status not available on Current Medication",
				getOrderStatusIndexBasedOnStatusValue(orderStatus).size() >= 0);
	}

	public void validateHarveyBallOrderStatusForHDDrug(String orderStatus, String ballSize) {
		Assert.assertTrue("PROBLEM - " + ballSize + " Harvey Ball not available for " + orderStatus
				+ " order on Current Medication", validateHarveyBallForHDDrugOrder(orderStatus, ballSize));
	}

	public void validateShippedOrderStatusForHDDrug(String orderStatus) {
		Assert.assertTrue("PROBLEM - Shipped Order not available on Current Medication",
				getOrderStatusIndexBasedOnStatusValue(orderStatus).size() > 0);
	}

	public void validateProperUseTab() {

		Assert.assertTrue("PROBLEM - unable to locate Proper Use tab element", properUseTab());
	}

	public void validateCanceledOrderStatusForHDDrug(String orderStatus) {
		Assert.assertTrue("PROBLEM - Request Canceled not available on Current Medication",
				getOrderStatusIndexBasedOnStatusValue(orderStatus).size() >= 0);
	}

	public boolean validateHDDrugDisplayedOnCurrentMedication() {
		List<Integer> listOfIndex = getListOfIndexForHDPharmacy();
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				if (listOfPharmacyName.get(val).getText().equals("OptumRx")) {
					return true;
				}
			}
			return false;

		} else {
			return true;
		}
	}

	public void validateHDDrug() {
		Assert.assertTrue("PROBLEM - User DO NOT have Home delivery drug displayed on Current Medication",
				validateHDDrugDisplayedOnCurrentMedication());
	}

	public void validateOptumRxLandingPage(String page) {
		Set<String> handles = driver.getWindowHandles();
		String pnpPageHandle = driver.getWindowHandle();
		handles.remove(pnpPageHandle);
		String winHandle = (String) handles.iterator().next();
		if (winHandle != pnpPageHandle) {
			String OptumRxLandingPageHandle = winHandle;
			driver.switchTo().window(OptumRxLandingPageHandle);
			if (page.equals("My Prescriptions"))
				Assert.assertTrue("PROBLEM - unable to locate OptumRx Landing Page Header element",
						validate(OptumRxMyPrescriptionHeader));
			{
				Assert.assertTrue("PROBLEM - unable to locate OptumRx Landing Page Header element",
						validate(OptumRxOrderStatusHeader));
			}
		}
		driver.close();
		driver.switchTo().window(pnpPageHandle);
	}

	public void validateDeliveredOrderStatusForHDDrug(String orderStatus, String ballSize) {
		Assert.assertTrue("PROBLEM - " + ballSize + "Harvey Ball not available for " + orderStatus
				+ " order on Current Medication", validateHarveyBallForHDDrugOrder(orderStatus, ballSize));
	}

	public List<Integer> getIndexOfMedicationHavingHold(String holdType) {
		List<Integer> listOfIndex = new ArrayList<>();

		for (int i = 0; i < listOfResolveHoldBtn.size(); i++) {
			if (listOfResolveHoldBtn.get(i).getAttribute("data-test-hold-type").equalsIgnoreCase(holdType)) {
				listOfIndex.add(i);
			}
		}

		/*
		 * for (int i = 0; i < listOfPharmacyName.size(); i++) { if
		 * (listOfPharmacyName.get(i).getText().equals(holdType)) { listOfIndex.add(i);
		 * } }
		 */
		return listOfIndex;
	}

	public boolean validateCurrentMedicationHavingHold(String holdType) {
		System.out.println("Size of Resolve data :" + listOfResolveHoldBtn.size());
		for (int i = 0; i < listOfResolveHoldBtn.size(); i++) {
			System.out.println(listOfResolveHoldBtn.get(i).getAttribute("data-test-hold-type"));
			if (listOfResolveHoldBtn.get(i).getAttribute("data-test-hold-type").contains(holdType)) {
				scrollToView(listOfResolveHoldBtn.get(i));
				return true;
			}
		}
		return false;
	}

	public boolean validateOnHoldIndicator(String holdColor, String holdIndicator, String holdType) {
		List<Integer> listOfIndex = getIndexOfMedicationHavingHold(holdType);
		if (listOfIndex.size() != 0) {
			int count = 0;
			for (Integer val : listOfIndex) {
				scrollToView(listOfOnHoldMsg.get(val));
				if (validate(listOfOnHoldMsg.get(val), 30)
						&& listOfOnHoldMsg.get(val).getCssValue("color").equals("rgba(172, 43, 0, 1)")
						&& validate(listOfHoldWarningSymbol.get(val), 30)) {
					count = count + 1;
				}
			}
			return count == listOfIndex.size();

		} else {
			return false;
		}
	}

	public boolean validateResolveHoldButtonForHDDrug(String expectedButtonColor, String expectedButtonValue,
			String holdType) {
		List<Integer> listOfIndex = getIndexOfMedicationHavingHold(holdType);
		if (listOfIndex.size() != 0) {
			int count = 0;
			for (Integer val : listOfIndex) {
				System.out.println("Button Value :"
						+ listForResolveHoldCallToActn.get(val).findElement(By.xpath(".//span")).getText());
				scrollToView(listForResolveHoldCallToActn.get(val));
				if (listForResolveHoldCallToActn.get(val).findElement(By.xpath(".//span")).getText().equalsIgnoreCase(
						expectedButtonValue) && listForResolveHoldCallToActn.get(val).getTagName().equals("button")
						&& listForResolveHoldCallToActn.get(val).getCssValue("background-color")
								.equals("rgba(13, 136, 11, 1)")) {
					count = count + 1;
				}
			}
			return count == listOfIndex.size();
		} else {
			return false;
		}
	}

	public boolean validateExternalLinkOnButton(String holdType) {
		List<Integer> listOfIndex = getIndexOfMedicationHavingHold(holdType);
		if (listOfIndex.size() != 0) {
			int count = 0;
			for (Integer val : listOfIndex) {
				scrollToView(listOfExternalLinkOnResolveHldBtn.get(val));
				if (validate(listOfExternalLinkOnResolveHldBtn.get(val), 30)) {
					count = count + 1;
				}
			}
			return count == listOfIndex.size();
		} else {
			return false;
		}
	}

	public void validatePaymentHoldForHDMedication(String holdType) {
		Assert.assertTrue("PROBLEM - Payment Hold not available for HD Medication ",
				validateCurrentMedicationHavingHold(holdType));
	}

	public void validateOnHoldIndicatorForHDDrug(String holdColor, String holdIndicator, String holdType) {
		Assert.assertTrue("PROBLEM - On Hold Indicator not available for HD Medication ",
				validateOnHoldIndicator(holdColor, holdIndicator, holdType));

	}

	public void validateOnResolveHoldBtnForHDDrug(String holdColor, String buttonValue, String holdType) {
		Assert.assertTrue("PROBLEM - On Resolve Hold Button not available for HD Medication ",
				validateResolveHoldButtonForHDDrug(holdColor, buttonValue, holdType));
	}

	public void validateExternalLnkOnButtonForHDDrug(String holdType) {
		Assert.assertTrue("PROBLEM - External Link not available on Button for HD Medication ",
				validateExternalLinkOnButton(holdType));
	}

	public void validateAddressHoldForHDMedication(String holdType) {
		Assert.assertTrue("PROBLEM - Address Hold not available for HD Medication ",
				validateCurrentMedicationHavingHold(holdType));
	}

	public void validatePriceAdjsutmentHoldForHDMedication(String holdType) {
		Assert.assertTrue("PROBLEM - Price Adjustment Hold not available for HD Medication ",
				validateCurrentMedicationHavingHold(holdType));

	}

	public void validateCallHoldForHDMedication(String holdType) {
		Assert.assertTrue("PROBLEM - Call Hold not available for HD Medication ",
				validateCurrentMedicationHavingHold(holdType));
	}

	public void validateInformationalHoldForHDMedication() {
		Assert.assertTrue("PROBLEM - Informational Hold not available for HD Medication ",
				getMedicationNameHavingInfoHld().size() > 0);
	}

	public void clickOnNextPageArrow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextPageArrow);
		nextPageArrow.click();
	}

	public boolean verifyRemainingPrescriptions(String totalMedication) {
		boolean flag = false;
		int medicationOnPageTwo = Integer.parseInt(drugsAvailableOnMyMedication.getText());
		int totalMedicationAvailable = Integer.parseInt(totalMedication);
		int medicationRemainingOnPageTwo = totalMedicationAvailable - 10;

		if (!(medicationRemainingOnPageTwo > 10)) {
			int size = listOfDrugName.size();
			String numberTXT = drugsAvailableOnMyMedication.getText();
			int expectedSize = Integer.parseInt(numberTXT);
			System.out.println("Expected Drug Name Size" + expectedSize);
			while (size != expectedSize) {
				size = listOfDrugName.size();
			}
			flag = medicationOnPageTwo == size;
		}
		/*
		 * else { int size=listOfDrugName.size(); String numberTXT =
		 * drugsAvailableOnMyMedication.getText(); int expectedSize =
		 * Integer.parseInt(numberTXT);
		 * System.out.println("Expected Drug Name Size"+expectedSize);
		 * while(size!=expectedSize) { size=listOfDrugName.size(); }
		 * 
		 * }
		 */
		return flag;
	}

	public void validateRemainingPrescriptionsOnMyMedPage(String medicationOnPageOne) {
		Assert.assertTrue("PROBLEM - Active Prescription not available on Next My Medication Page ",
				verifyRemainingPrescriptions(medicationOnPageOne));
	}

	// F436319
	public void validatePositionOfCallToActionOnPnPPage(int position, String callToActionTitle) {
		List<WebElement> callToActions = driver.findElements(By.xpath("//div[@class='sc-LzLMQ ejtotn']//button//h2"));
		WebElement element = callToActions.get(position);
		position = position + 1;
		if (element.getText().equalsIgnoreCase(callToActionTitle)) {
			Assert.assertEquals("SUCCESS - " + callToActionTitle + "Is placed on position :: " + position, true,
					pnpValidate(element));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate expected position of call to action for " + callToActionTitle,
					false);
		}
	}

	public List<String> getDrugNameListValueOnMyMedication() {
		List<String> listOfDrug = new ArrayList<>();
		int size = listOfDrugName.size();
		// int expectedSize=6;
		String numberTXT = drugsAvailableOnMyMedication.getText();
		int expectedSize = Integer.parseInt(numberTXT);
		/*
		 * if(number<6) { expectedSize=number; }
		 */
		System.out.println("Expected Drug Name Size" + expectedSize);
		while (size != expectedSize) {
			size = listOfDrugName.size();
		}
		for (WebElement ele : listOfDrugName) {
			waitforElementVisibilityInTime(ele, 50);
			System.out.println("Value of Drug Name :" + ele.getText());
			listOfDrug.add(ele.getText());
		}
		return listOfDrug;
	}
	/*
	 * public boolean validateHarveyBallCheckMark(String orderStatus) {
	 * List<Integer> listOfIndex =
	 * getOrderStatusIndexBasedOnStatusValue(orderStatus); if (listOfIndex.size() !=
	 * 0) { int count = 0; for (Integer val : listOfIndex) {
	 * scrollToView(listOf.get(val)); if
	 * (listOfHarveyBall.get(val).getAttribute("data-testid").contains(ballSize)) {
	 * count = count + 1; } } return count == listOfIndex.size();
	 * 
	 * } else { return false; } }
	 */

	public String countOfTotalMedication() {
		return NumberInParenthesis.getText().replaceAll("[^0-9]", "");
	}

	public boolean validateMedicationHavingInformationalHold(List<String> listOfMedName) {
		List<Integer> listOfInd = getMedIndexBasedOnMedicationName(listOfMedName);
		if (listOfInd.size() > 0) {
			for (Integer val : listOfIndex) {
				if (listOfCallToActnForActiveMedication.get(val).getText().contains("Hold")) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}

	}

	public void validateEmptyHarveyBall() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", emptyHarveyBall);
		Assert.assertTrue("PROBLEM - unable to locate empty harvey ball icon element", pnpValidate(emptyHarveyBall));
	}

	public List<Integer> getMedIndexBasedOnMedicationName(List<String> listOfMedName) {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfDrugName.size(); i++) {
			for (String str : listOfMedName) {
				if (str.equalsIgnoreCase(listOfDrugName.get(i).getText())) {
					listOfIndex.add(i);
					break;
				}
			}
		}
		return listOfIndex;
	}

	public List<String> getMedicationNameHavingInfoHld() {
		List<String> listOfVal = new ArrayList<>();
		for (WebElement ele : listOfmedicationHavingInformationalHold) {
			listOfVal.add(ele.getText());
		}
		return listOfVal;
	}

	public boolean validateWalgreens() {
		if (walgreens.size() >= 0) {
			for (int i = 0; i < walgreens.size(); i++) {
				String text = walgreens.get(i).getText();
				for (WebElement child : walgreens.get(i).findElements(By.xpath("./*"))) {
					text = text.replaceFirst(child.getText(), "");
				}
				if (!text.trim().equals("Walgreens")) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean validateHDDrugEligibleForRefill() {
		if (listOfPharmacyEligibleFrRefill.size() > 0) {
			for (int i = 0; i < listOfPharmacyEligibleFrRefill.size(); i++) {
				String text = listOfPharmacyEligibleFrRefill.get(i).getText();
				for (WebElement child : listOfPharmacyEligibleFrRefill.get(i).findElements(By.xpath("./*"))) {
					text = text.replaceFirst(child.getText(), "");
				}
				if (!text.trim().equals("OptumRx")) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean validateHDDrugEligibleForRenew() {
		if (listOfPharmacyEligibleFrRenew.size() > 0) {
			/*
			 * for(WebElement ele:listOfPharmacyEligibleFrRenew) {
			 * if(!ele.getText().equals("OptumRx")) { return false; } }
			 */

			for (int i = 0; i < listOfPharmacyEligibleFrRenew.size(); i++) {
				String text = listOfPharmacyEligibleFrRenew.get(i).getText();
				for (WebElement child : listOfPharmacyEligibleFrRenew.get(i).findElements(By.xpath("./*"))) {
					text = text.replaceFirst(child.getText(), "");
				}
				if (!text.trim().equals("OptumRx")) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean validateHDDrugEligibleForActionableHold() {
		if (listOfHDMedicationHavingHold.size() > 0) {
			/*
			 * for(WebElement ele:listOfHDMedicationHavingHold) {
			 * if(!ele.getText().equals("OptumRx")) { return false; } }
			 */

			for (int i = 0; i < listOfHDMedicationHavingHold.size(); i++) {
				String text = listOfHDMedicationHavingHold.get(i).getText();
				for (WebElement child : listOfHDMedicationHavingHold.get(i).findElements(By.xpath("./*"))) {
					text = text.replaceFirst(child.getText(), "");
				}
				if (!text.trim().equals("OptumRx")) {
					return false;
				}
			}

			return true;
		}
		return false;
	}

	public void validateRefillRemainingFieldOnCurrentMed(String expectedVal) {
		Assert.assertTrue("PROBLEM - Refill Remaining Field not available for HD Medication on Current Medication",
				verifyRefillRemainingFieldForHDMedication(expectedVal));
	}

	public boolean verifyRefillRemainingFieldForHDMedication(String expectedVal) {
		for (WebElement ele : listofHDMedicationHavingRefillLeftField) {
			if (!(ele.getText().equalsIgnoreCase(expectedVal))) {
				return false;
			}
		}
		return true;
	}

	public void validateRefillRemainingValueOnCurrentMed() {
		Assert.assertTrue("PROBLEM - Refill Remaining Val not available for HD Medication on Current Medication",
				verifyRefillRemainingValueForHDMedication());
	}

	public boolean verifyRefillRemainingValueForHDMedication() {
		for (WebElement ele : listofHDMedicationHavingRefillLeftVal) {
			if (!(ele.getText().isEmpty())) {
				return false;
			}
		}
		return true;
	}

	public CheckOutSummaryPage navigateToCheckOutSummaryPage() {
		CommonUtility.waitForPageLoad(driver, LookUpDrugsButton, 40);
		CommonUtility.checkPageIsReady(driver);
		if (driver.getCurrentUrl().contains("pharmacy/overview.html")) {
			CommonUtility.checkPageIsReady(driver);
			return new CheckOutSummaryPage(driver);
		}
		return null;
	}

	public List<Object> fetchesMedicationInformationFrRefill() {
		List<Object> listOfVal = new ArrayList<>();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfRefillMedication.size());

		String text = listOfMedicationEligibleFrRefill.get(rand_int).getText();
		for (WebElement child : listOfMedicationEligibleFrRefill.get(rand_int).findElements(By.xpath("./*"))) {
			text = text.replaceFirst(child.getText(), "");
		}
		listOfVal.add(text);
		// listOfVal.add(listOfMedicationEligibleFrRefill.get(rand_int).getText());
		listOfVal.add(listOfRefillLeftEligibleFrRefill.get(rand_int).getText());
		listOfVal.add(listOfDaySupplyEligibleFrRefill.get(rand_int).getText());
		listOfVal.add(listOfAmntPaidEligibleFrRefill.get(rand_int).getText());
		listOfVal.add(rand_int);
		return listOfVal;
	}

	public void clickOnRefillMedicationCTABasedOnIndex(int index) {
		listOfRefillMedication.get(rand_int).click();
	}

	public void refreshPnPPage() {
		driver.navigate().refresh();
		validateCurrentMedicationsHeader();
	}

	public void validateOrderStatusAndCTAUpdatedForRefillTransaction() {
		//
		clickOnViewAllMedicationsLink();
		validateFieldValueContent(listOfDrugName);

	}

	public void clickTryAgainCurrentmedication() {
		int count = 0;
		do {
			if (tryAgainMedCabTimeOut.isDisplayed()) {
				tryAgainMedCabTimeOut.click();
			}
			count++;
		} while (count != 2);
	}

}
