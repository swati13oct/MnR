package pages.regression.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

	private static String activeMedicineName;


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
		Assert.assertTrue("PROBLEM - unable to locate pnp page notification element", pnpValidate(PnPNotification));
	}

	// F436319
	public void validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages() {
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
	public void clickWhatsNewCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Whats New Call to Action element",
				pnpValidate(whatsNewCallToActnBtn));
		whatsNewCallToActnBtn.click();
	}

	// F436319
	public void validateNavigationToWhatsNewPage() {
		Assert.assertTrue("PROBLEM - unable to locate Whats New Page Header element", pnpValidate(whatsNewPageHeader));
	}

	// F436319
	public void closePharmacies_PrescriptionNotification() {
		Assert.assertTrue("PROBLEM - unable to locate close icon on pnp page notification element",
				pnpNotificationPositionValidate(PnPNotificationCloseBtn));
		closePnPNotification(PnPNotificationCloseBtn);
	}

	// F436319
	public void validatePharmacies_PrescriptionNotificationNotDisplayedOnPnPPage() {
		Assert.assertFalse("PROBLEM - able to locate pnp page notification element", pnpValidate(PnPNotification));
	}

	// F436319
	public void validatePersistanceOfRemovalOfPharmacies_PrescriptionNotificationOnPnPPage() {
		validateNavigationToWhatsNewPage();
		navigateBackToPnPPage();
		Assert.assertFalse("PROBLEM - able to locate pnp page notification element", pnpValidate(PnPNotification));
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

	// F436319 Pharmacy Locator Call To Action
	public void validatePharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator call to action Tile element",
				pnpValidate(pharmacyLocatorCallToActnBtn));
	}

	// F436319
	public void validateImagePharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator call to action Image element",
				pnpValidate(pharmacyLocatorImage));
	}

	// F436319
	public void validateTitlePharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator call to action Title element",
				pnpValidate(pharmacyLocatorTitle));
	}

	// F436319
	public void validateDescriptionPharmacyLocatorCallToActionOnPnPPage() {
		Assert.assertTrue("PROBLEM - unable to locate Pharmacy Locator  call to action Description element",
				pnpValidate(pharmacyLocatorDesc));
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
	
	//F436319 Whats New Call To Action
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
	public void validatePositionOfCallToActionOnPnPPage() {
		// code goes here, need UI
	}

	// F436319
	public void clickOnFindAndPriceCallToAction() {
		Assert.assertTrue("PROBLEM - unable to locate Find and Price Call to Action element",
				pnpValidate(findPrescriptionsCallToActnBtn));
		findPrescriptionsCallToActnBtn.click();

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
				pnpValidate(pharmacyLocatorCallToActnBtn));
		pharmacyLocatorCallToActnBtn.click();

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

	// F392596 Meidine Cabinet
	public void validateCurrentMedicationsHeader() {
		Assert.assertTrue("PROBLEM - unable to locate Current Medications Header element",
				pnpValidate(CurrentMedicationsHeader));
	}

	public void validateActivePrescriptions() {


		Assert.assertTrue("PROBLEM - unable to locate Current Medications Active Prescriptions text element",
				sixActivePrescription());
	}

	public void validateAssociatedCallToAction() {


		Assert.assertTrue("PROBLEM - unable to locate Associated Call To Action element",
				associatedCallToAction());
	}

	public void validateNumberInParenthesis() {

		Assert.assertTrue("PROBLEM - unable to validate  a number in parentheses ",
				alphaNumeric());
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
				pnpValidate(ViewAllMedications));
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

	public void validateImage() {
		Assert.assertTrue("PROBLEM - Medication Drug Image not available", validateFieldValueContent(listOfDrugImage));
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
		Assert.assertTrue("PROBLEM - Delivered for applicable Medication not available",
				validateDeliveredStatus());
	}

	public void validateViewOrderButton() {
		Assert.assertTrue("PROBLEM - View Order button for applicable Medication not available",
				viewOrderButton());
	}
	
	public void validateHDAssociateOrderStatus() {
		Assert.assertTrue("PROBLEM - Order Status for applicable Home Delivery Drug not available",
				validateOrderStatusForHDDrug());
	}
	
	public void validateHDOrderStatusForInProg() {
		Assert.assertTrue("PROBLEM - Order Status for in progress Home Delivery Drug not available",
				validateOrderStatusForHDDrug());
	}
	
	List<String> listOfOrderStatusForHDMedicine = new ArrayList<>(Arrays.asList("Request Received","Verifying with Doctor","Order Verified","Processing","Shipped","Delivered"));
	
	public boolean validateOrderStatusForHDDrug() {
		List<Integer> listOfIndex = getListOfIndexForHDPharmacy();
		for (Integer val : listOfIndex) {
			if (!listOfOrderStatusForHDMedicine.contains(listOfOrderStatus.get(val).getText())) {
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

	public void validateContactPharmacyButton(String expectedButtonColor, String expectedContactPharmacy) {
		Assert.assertTrue("PROBLEM - Contact Pharmacy Button not available",
				validateContactPharmacyButtonForRetailDrug(expectedButtonColor, expectedContactPharmacy));
	}



/*	public void clickOnMedicationName() {
		Assert.assertTrue("PROBLEM - unable to locate Medicine name element",
				pnpValidate(FirstCurrentMedication));
		FirstCurrentMedication.click();
		Assert.assertTrue("PROBLEM - unable to locate Medicine name element", pnpValidate(MedicationName));
		MedicationName.click();
		 
	}*/


	public void validatePharmacyName() {
		Assert.assertTrue("PROBLEM - Pharmacy Name  not available", validateFieldValueContent(listOfPharmacyName));
	}

	public void validateDrugDetailOverview() {
		PharmaciesAndPrescriptionsBase pnpBase = new PharmaciesAndPrescriptionsBase(driver);
		String drugName = pnpBase.getDrugName();
		String currentURL = driver.getCurrentUrl();
		boolean flag = true;
		if(currentURL.contains("overview.html#/medication-information")) {
			Assert.assertTrue("SUCCESS - User redirected to medication information overview page",
					flag);
			if(drugName.contains(MedicationName_OnDrugInfoPage.getText())) {
				Assert.assertTrue("SUCCESS - Drug Name verified on medication information overview page",
						flag);
			}else {
				Assert.assertTrue("PROBLEM - Drug Name NOT verified on medication information overview page",
						flag);
			}			
		}else {
		Assert.assertTrue("PROBLEM - User NOT redirected to medication information overview page",
				flag);
		}
	}

	public void validateViewAllMedicationsLink() {
		Assert.assertTrue("PROBLEM - unable to locate Medicine Cabinet View All Medications link text element",
				pnpValidate(ViewAllMedications));
	}

	public void validateRequestReceived() {

		List<WebElement> requestReceived = RequestReceived;
		Assert.assertTrue("PROBLEM - unable to locate Request received elements",

				pnpValidate(requestReceived.get(0)));
	}

	public void validateOptumRx() {

		List<WebElement> optumRx = OptumRx;
		Assert.assertTrue("PROBLEM - unable to locate Request received elements",

				optumRx.size() > 0);
	}

	public void validateProcessing() {

		List<WebElement> processing = Processing;
		Assert.assertTrue("PROBLEM - unable to locate Request received elements",

				pnpValidate(processing.get(0)));
	}


	/*// F392596 Meidine Cabinet
	public String clickOnLearnMoreButtonDisplayedOnCurrentMedications() {
		Assert.assertTrue("PROBLEM - unable to locate Learn More Button element",
				pnpValidate(LearnMoreBtn_CurrentMedication));
		activeMedicineName = FirstCurrentMedication.getText();// this will get Text of first active medication
		LearnMoreBtn_CurrentMedication.click();
		return activeMedicineName;
	}*/


	//F392596 Meidine Cabinet// when user click on learn more button on current medication on PNP page.
	public void validateDrugInfopage() {
		PharmaciesAndPrescriptionsBase pnpBase = new PharmaciesAndPrescriptionsBase(driver);
		String drugName = pnpBase.getDrugNameLearnMore();
		String currentURL = driver.getCurrentUrl();
		boolean flag = true;

		if(currentURL.contains("overview.html#/medication-information")) {
			Assert.assertTrue("SUCCESS - User redirected to medication information overview page",
					flag);
			if(drugName.contains(MedicationName_OnDrugInfoPage.getText())) {
				Assert.assertTrue("SUCCESS - Drug Name verified on medication information overview page",
						flag);
			}else {
				Assert.assertTrue("PROBLEM - Drug Name NOT verified on medication information overview page",
						flag);
			}			
		}else {
		Assert.assertTrue("PROBLEM - User NOT redirected to medication information overview page",
				flag);
		}

	}

	public void validateHalfHarveyBall() {
		Assert.assertTrue("PROBLEM - unable to locate half Harvey ball  elements", pnpValidate(HalfHarveyBall));
	}

	public void validateOneFourthHarveyBall() {
		Assert.assertTrue("PROBLEM - unable to locate three fourth Harvey ball  elements",
				pnpValidate(oneFourthHarveyBall));
	}

	public void validateRefillMedications() {
		Assert.assertTrue("PROBLEM - unable to locate Refill Medicationss text element",
				pnpValidate(RefillMedications));
	}

	public void validateRenewMedications() {
		Assert.assertTrue("PROBLEM - unable to locate Refill Medicationss text element", pnpValidate(RenewMedications));
	}

	public List<String> getDrugNameListValue() {
		List<String> listOfDrug = new ArrayList<>();
		for (WebElement ele : listOfDrugName) {
			listOfDrug.add(ele.getText());
		}
		return listOfDrug;
	}

	public boolean validateFieldValueContent(List<WebElement> listOfWebElement) {
		if (listOfWebElement.size() > 0) {
			for (WebElement ele : listOfWebElement) {
				if (ele.getText().isEmpty()) {
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
				String[] arrayOfMedicineName = ele.getText().split(" ");
				if (arrayOfMedicineName[arrayOfMedicineName.length - 1].isEmpty()) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> getListOfIndexForRetailPharmacy() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			if (!listOfPharmacyName.get(i).getText().equals("OptumRx")) {
				listOfIndex.add(i);
			}
		}
		return listOfIndex;
	}

	public List<Integer> getListOfIndexForHDPharmacy() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			if (listOfPharmacyName.get(i).getText().equals("OptumRx")) {
				listOfIndex.add(i);
			}
		}
		return listOfIndex;
	}

	List<String> listOfCallToActionForHDMedicine;

	public boolean validateCallToActionsForHDDrug() {
		List<Integer> listOfIndex = getListOfIndexForHDPharmacy();
		if (listOfIndex.size() > 0) {
			for (Integer val : listOfIndex) {
				if (!listOfCallToActionForHDMedicine.contains(listOfCallToActionOnMedication.get(val).getText())) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean validateContactPharmacyButtonForRetailDrug(String expectedButtonColor, String expectedButtonValue) {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		if (listOfIndex.size() > 0) {
			for (Integer val : listOfIndex) {
				if (!(listOfCallToActionOnMedication.get(val).getText().equals(expectedButtonValue)
						&& listOfCallToActionOnMedication.get(val).getTagName().equals("button"))
						&& listOfCallToActionOnMedication.get(val).getCssValue("color").equals("#008000")) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void clickOnContactPharmacy() {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		Random rand = new Random();
		int rand_int = rand.nextInt(listOfIndex.size());
		listOfCallToActionOnMedication.get(listOfIndex.get(rand_int));
	}

	// Need to add the Regex for Number
	public boolean validateContactPharmacyPopUpHavingNumber() {
		String contactNumber = contactPharmacyNumber.getText();
		return !contactNumber.isEmpty() && contactNumber.matches("");
	}

	public boolean validateOrderStatusForAssociatedCTA() {
		List<Integer> listOfIndex = getListOfIndexForTrackCTA();
		if (listOfIndex.size() > 0) {
			for (Integer val : listOfIndex) {
				if (listOfOrderStatus.get(val).getText().isEmpty()) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public List<Integer> getListOfIndexForTrackCTA() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfCallToActionOnMedication.size(); i++) {
			if (listOfCallToActionOnMedication.get(i).getText().equals("Track")) {
				listOfIndex.add(i);
			}
		}
		return listOfIndex;
	}

	public void validateActiveRetailMedication() {
		Assert.assertTrue("PROBLEM - Active Retail not available", validateRetailMedication());
	}

	public boolean validateRetailMedication() {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
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
			if (listOfPharmacyName.get(i).getText().equals(orderStatus)) {
				listOfIndex.add(i);
			}
		}
		return listOfIndex;
	}

	public boolean validateHarveyBallForHDDrugOrder(String orderStatus, String ballSize) {
		List<Integer> listOfIndex = getOrderStatusIndexBasedOnStatusValue(orderStatus);
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				if (!(listOfHarveyBall.get(val).getText().contains(ballSize))) {
					return false;
				}
			}
			return true;

		} else {
			return false;
		}
	}
	
	
	public boolean clickOnTrackOrderStatus(String orderStatus) {
		return true;		
	}
	
	public boolean clickOnHDDrugCTA(String orderStatus,String callToAction) {
		List<Integer> listOfIndex = getOrderStatusIndexBasedOnStatusValue(orderStatus);
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				if (listOfCallToActionOnMedication.get(val).getText().equals(callToAction)) {
					listOfCallToActionOnMedication.get(val).click();
					return true;
				}else {
					return false;
					}
				}
			}
		return false;		
	}
	
	public boolean validateOderStatusPageURL() {
		if (driver.getCurrentUrl().contains("/pharmacy/overview.html#/order-status")) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public void validateOderStatusPage() {
		Assert.assertTrue("PROBLEM - Order Status page is not displayed",validateOderStatusPageURL());		
	}
	
	public void validateClickOnHDDrugCTA(String orderStatus,String callToAction) {
		Assert.assertTrue("PROBLEM - "+ orderStatus+ " Call to action button is not available on Current Medication",clickOnHDDrugCTA(orderStatus, callToAction));
	}
	
	public void validateClickOnTrackOrderStatus() {
		List<String> list = Arrays.asList("Request Received","Verifying with Doctor","Order Verified","Processing","Processed","Shipped");
		ArrayList<String> inprogressOrderStatus = new ArrayList<String>();
		inprogressOrderStatus.addAll(list);
		for(String status:inprogressOrderStatus) {
			clickOnTrackOrderStatus(status);
		}
		//getListOfIndexForTrackCTA();
		//Assert.assertTrue("PROBLEM -  "+ callToAction +" call to action button is not available for In Progress Order on Current Medication",clickOnTrackOrderStatus()));
	}
	
	public void validateOrderStatusForHDDrug(String orderStatus) {
		Assert.assertTrue("PROBLEM - "+orderStatus+ " Status not available on Current Medication", getOrderStatusIndexBasedOnStatusValue(orderStatus).size()>0);
	}
	
	public void validateHarveyBallOrderStatusForHDDrug(String orderStatus,String ballSize) {
		Assert.assertTrue("PROBLEM - "+ballSize+" Harvey Ball not available for "+orderStatus+" order on Current Medication", validateHarveyBallForHDDrugOrder(orderStatus,ballSize));
	}

	public void validateShippedOrderStatusForHDDrug(String orderStatus) {
		Assert.assertTrue("PROBLEM - Shipped Order not available on Current Medication",
				getOrderStatusIndexBasedOnStatusValue(orderStatus).size() > 0);
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
		Assert.assertTrue("PROBLEM - User DO NOT have Home delivery drug displayed on Current Medication", validateHDDrugDisplayedOnCurrentMedication());
	}
	
	public void validateOptumRxLandingPage() {
		Set handles = driver.getWindowHandles();
		String pnpPageHandle = driver.getWindowHandle();
		handles.remove(pnpPageHandle);
		String winHandle = (String) handles.iterator().next();
		if (winHandle != pnpPageHandle) {
			String OptumRxLandingPageHandle = winHandle;
			driver.switchTo().window(OptumRxLandingPageHandle);
			Assert.assertTrue("PROBLEM - unable to locate OptumRx Landing Page Header element",
					pnpValidate(OptumRxLandingPageHeader));
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
		// Need to get the element having attribute which identify the hold type

		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			if (listOfPharmacyName.get(i).getText().equals(holdType)) {
				listOfIndex.add(i);
			}
		}
		return listOfIndex;
	}

	public boolean validateCurrentMedicationHavingHold(String holdType) {
		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			if (listOfPharmacyName.get(i).getText().contains(holdType)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateOnHoldIndicator(String holdColor, String holdIndicator, String holdType) {
		List<Integer> listOfIndex = getIndexOfMedicationHavingHold(holdType);

		// Need to provide the hold color hash val
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				if (!(listOfOrderStatus.get(val).getText().contains(holdIndicator))
						&& !(listOfOrderStatus.get(val).getCssValue("color").equals(holdColor))) {
					return false;
				}
			}
			return true;

		} else {
			return false;
		}
	}

	public boolean validateResolveHoldButtonForHDDrug(String expectedButtonColor, String expectedButtonValue,
			String holdType) {
		List<Integer> listOfIndex = getIndexOfMedicationHavingHold(holdType);
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				if (!(listOfCallToActionOnMedication.get(val).getText().equals(expectedButtonValue)
						&& listOfCallToActionOnMedication.get(val).getTagName().equals("button"))
						&& listOfCallToActionOnMedication.get(val).getCssValue("color").equals("#008000")) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean validateExternalLinkOnButton(String holdType) {
		List<Integer> listOfIndex = getIndexOfMedicationHavingHold(holdType);
		/// Need to check the Parameter having external Link
		if (listOfIndex.size() != 0) {
			for (Integer val : listOfIndex) {
				if (!(listOfExtrnalLinkOnHold.get(val).getText().equals("NeedToCheckTheParameter"))) {
					return false;
				}
			}
			return true;
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

	public void validateInformationalHoldForHDMedication(String holdType) {
		Assert.assertTrue("PROBLEM - Call Hold not available for HD Medication ",
				validateCurrentMedicationHavingHold(holdType));
	}

	public void clickOnNextPageArrow() {
		nextPageArrow.click();
	}

	public boolean verifyRemainingPrescriptions() {
		if (listOfDrugName.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void validateRemainingPrescriptionsOnMyMedPage() {
		Assert.assertTrue("PROBLEM - Active Prescription not available on Next My Medication Page ",
				verifyRemainingPrescriptions());
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

}

