package pages.regression.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import acceptancetests.util.CommonUtility;

/**
 * Functionality : validations for Pharmacies & Prescriptions page
 */
public class PharmaciesAndPrescriptionsPage extends PharmaciesAndPrescriptionsBase{
	public PharmaciesAndPrescriptionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	public void validateHeaderSectionContent(String firstname, String lastName) {
		Assert.assertTrue("PROBLEM - unable to locate pnp page header element", 
				pnpValidate(pgHeader));
		String expTxt="Pharmacies & Prescriptions for "+firstname+" "+lastName;
		String actTxt=pgHeader.getText();
		Assert.assertTrue("PROBLEM - header text is not as expected. "
				+ "Expected='"+expTxt+"' | Actual='"+actTxt+"'", 
				expTxt.equals(actTxt));
	}

	public void validatePharmaciesText() {
		Assert.assertTrue("PROBLEM - unable to locate pnp page header element", 
				pnpValidate(pharmaciesText));
		Pattern expectedTxt1=Pattern.compile("Get the most out of your prescription drug benefits\\.");
		Pattern expectedTxt2=Pattern.compile("You can make sure your drugs are covered, estimate costs and find ways to save money\\. .*earch for national and local pharmacies in your plan.s network to fill your prescriptions\\.");
		String actualTxt=pharmaciesText.getText();
		Assert.assertTrue("PROBLEM - pharmacies text is not as expected. "
				+ "Expected to contain '"+expectedTxt1+"' AND '"+expectedTxt2+"' | Actual='"+actualTxt+"'", 
				expectedTxt1.matcher(actualTxt).find() && expectedTxt2.matcher(actualTxt).find());
	}

	public void validateTileContent(String exp_TileHeaderTxt, String exp_TileLinkTxt, 
			WebElement exp_pTile_Txt, WebElement exp_pTile_img, WebElement exp_pTile_Lnk) {
		Assert.assertTrue("PROBLEM - unable to locate '"+exp_TileHeaderTxt+"' tile header element", 
				pnpValidate(exp_pTile_Txt));
		Assert.assertTrue("PROBLEM - unable to locate '"+exp_TileHeaderTxt+"' tile image element", 
				pnpValidate(exp_pTile_img));
		Assert.assertTrue("PROBLEM - unable to locate '"+exp_TileHeaderTxt+"' tile link element", 
				pnpValidate(exp_pTile_Lnk));

		String act_TileHeaderTxt=exp_pTile_Txt.getText().trim();
		Assert.assertTrue("PROBLEM - '"+exp_TileHeaderTxt+"' tile text not as expected. "
				+ "Expected='"+exp_TileHeaderTxt+"' | Actual='"+act_TileHeaderTxt+"'", 
				exp_TileHeaderTxt.equals(act_TileHeaderTxt));

		String act_TileLnkTxt=exp_pTile_Lnk.getText().trim();
		Assert.assertTrue("PROBLEM - '"+exp_TileHeaderTxt+"' tile text not as expected. "
				+ "Expected='"+exp_TileLinkTxt+"' | Actual='"+act_TileLnkTxt+"'",
				exp_TileLinkTxt.equals(act_TileLnkTxt));

	}

	public void validateTileNotExist(String exp_TileHeaderTxt,  
			WebElement exp_pTile_Txt, WebElement exp_pTile_img, WebElement exp_pTile_Lnk) {
		Assert.assertTrue("PROBLEM - for PEEHIP member user should not see '"+exp_TileHeaderTxt+"' related elements", 
				!pnpValidate(exp_pTile_Txt)
				&& !pnpValidate(exp_pTile_img)
				&& !pnpValidate(exp_pTile_Lnk)
				);
	}

	/**
	 * to validate the pharmacies tiles section, determine what tiles should show up or not
	 * @param tileDrug
	 * @param tilePharmacy
	 * @param tilePrescription
	 * @param tileDelivery
	 * @param tileBenefit
	 */
	public void validatePharmaciesTilesSection(boolean tileDrug, boolean tilePharmacy,	
			boolean tilePrescription, boolean tileDelivery, boolean tileBenefit) {
		String exp_TileHeaderTxt="Look up covered drugs and estimate costs";
		String exp_TileLinkTxt="LOOK UP DRUGS";
		WebElement exp_tileHeaderElement=pTile_compDrugPricingHeaderTxt;
		WebElement exp_tileImg=pTile_compDrugPricingImg;
		WebElement exp_tileLnk=pTile_compDrugPricingLnk;
		if (tileDrug)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt="Find a network pharmacy";
		exp_TileLinkTxt="FIND A PHARMACY";
		exp_tileHeaderElement=pTile_findNtkPharmacyHeaderTxt;
		exp_tileImg=pTile_findNtkPharmacyImg;
		exp_tileLnk=pTile_findNtkPharmacyLnk;
		if (tilePharmacy)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt="Refill home delivery prescriptions";
		exp_TileLinkTxt="ORDER PRESCRIPTIONS";
		exp_tileHeaderElement=pTile_orderPresRefillsHeaderTxt;
		exp_tileImg=pTile_orderPresRefillsImg;
		exp_tileLnk=pTile_orderPresRefillsLnk;
		if (tilePrescription)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt="Check home delivery order status";
		exp_TileLinkTxt="CHECK DELIVERY STATUS";
		exp_tileHeaderElement=pTile_chkHomeDeliOrderStatusHeaderTxt;
		exp_tileImg=pTile_chkHomeDeliOrderStatusImg;
		exp_tileLnk=pTile_chkHomeDeliOrderStatusLnk;
		if (tileDelivery)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt="View your drug spending to date";
		exp_TileLinkTxt="DRUG COST SUMMARY";
		exp_tileHeaderElement=pTile_presBenfitInfoHeaderTxt;
		exp_tileImg=pTile_presBenfitInfoImg;
		exp_tileLnk=pTile_presBenfitInfoLnk;
		if (tileBenefit)
			validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		else
			validateTileNotExist(exp_TileHeaderTxt, exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
	}


	public void validateTileLnkDestination(String planType, String memberType, String tile, boolean runOnTeamEnv) throws InterruptedException {
		String planCategoryId="0";
		validateTileLnkDestination(planType, memberType, tile, planCategoryId, runOnTeamEnv);
	}

	/**
	 * to validate individual tile content
	 * @param planType
	 * @param memberType
	 * @param tile
	 * @throws InterruptedException
	 */
	public void validateTileLnkDestination(String planType, String memberType, String tile, String planCategoryId, boolean runOnTeamEnv) 
			throws InterruptedException { //note: if arrives here, already validated link existent
		System.out.println("Proceed to validate tile='"+tile+"'...");
		if (tile.equals("Prescription Benefits Information") && !planCategoryId.equals("0")) {
			//note: prior step validation would have been done already to get to this point, so just print msg
			System.out.println("Prescription Benefits Information link will not exist if LIS=0, skip this validation");
			return;
		} else if (memberType.toUpperCase().contains("PEEHIP") &&
				(tile.equals("Check home delivery order status") || tile.equals("Order prescription refills"))) {
			System.out.println("Order prescription refills and Check home delivery order status tile will not exist for PEEHIP group user, skip this validation");
			return;
		}
		boolean switchTab=false;
		WebElement linkElement=null;
		String expUrl="";
		if (tile.equals("Compare drug pricing")) {
			linkElement=pTile_compDrugPricingLnk;
			if (memberType.toUpperCase().contains("GROUP")) {
				expUrl="https://chp-stage.optumrx.com/public/sso-landing";
				switchTab=true;
			} else
				expUrl="/member/drug-lookup/overview.html#/drug-cost-estimator";
		} else if (tile.equals("Find a network pharmacy")) {
			linkElement=pTile_findNtkPharmacyLnk;
			expUrl="/member/pharmacy-locator/overview.html#/Pharmacy-Search-English";
		} else if (tile.equals("Order prescription refills")) {
			linkElement=pTile_orderPresRefillsLnk;
			expUrl="https://chp-stage.optumrx.com/public/sso-landing";
			switchTab=true;
		} else if (tile.equals("Check home delivery order status")) {
			linkElement=pTile_chkHomeDeliOrderStatusLnk;
			expUrl="/sso";
			switchTab=true;
		} else if (tile.equals("Prescription Benefits Information")) {
			linkElement=pTile_presBenfitInfoLnk;
			expUrl="https://chp-stage.optumrx.com/public/sso-landing";
			switchTab=true;
		}		
		Assert.assertTrue("PROBLEM - need to code to support '"+tile+"' tile content validation", 
				linkElement !=null);

		if (switchTab) {
			String winHandleBefore = driver.getWindowHandle();
			CommonUtility.waitForPageLoad(driver, linkElement, 5);
			linkElement.click();
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();					
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			CommonUtility.checkPageIsReady(driver);
				String actUrl=driver.getCurrentUrl();
				if (expUrl.contains("sso")) {
					if (!runOnTeamEnv) {
					String expUrlAlternative="https://hsid11-st1.optum.com/register/personalInfo";
					String expUrlAlternative2="https://chp-stage.optumrx.com/secure/my-medicine-cabinet";
					Assert.assertTrue("PROBLEM - '"+tile+"' tile link destination URL is not as expected. "
							+ "Expect to contain '"+expUrl+"' or '"+expUrlAlternative+"' or '"+expUrlAlternative2+" | Actual URL='"+actUrl+"'", 
							actUrl.contains(expUrl) || actUrl.contains(expUrlAlternative) || actUrl.contains(expUrlAlternative2));
					} else {
						System.out.println("Test run on team env, sso is not supported, skip expected URL validation");
					}
				} else {
					Assert.assertTrue("PROBLEM - '"+tile+"' tile link destination URL is not as expected. "
						+ "Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
				}
				driver.close();
				driver.switchTo().window(winHandleBefore);
		} else {
			linkElement.click();
			CommonUtility.checkPageIsReady(driver);
			String actUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - '"+tile+"' tile link destination URL is not as expected. "
					+ "Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
			goBackToPriorPnPpgViaBack(planType, memberType);
		}
	}

	/**
	 * to validate the plan material link. FnR page takes long time to load, only validate URL is correct
	 */
	public void validatePlanMaterialsLink() { 
		Assert.assertTrue("PROBLEM - unable to locate Plan Materials icon element", pnpValidate(viewPlanMaterialsImg));
		Assert.assertTrue("PROBLEM - unable to locate Plan Materials link element", pnpValidate(viewPlanMaterialsLnk));
		String exp_lnk="/member/documents/overview.html";
		String act_lnk=viewPlanMaterialsLnk.getAttribute("href");
		Assert.assertTrue("PROBLEM - 'PLAN MATERIALS' link url is not as expected. "
				+ "Expect='"+exp_lnk+"' | Actual='"+act_lnk+"'", act_lnk.contains(exp_lnk));
	}


}
