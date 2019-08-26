package pages.regression.pharmaciesandprescriptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.member_deprecated.bluelayer.AccountHomePage;

/**
 * Functionality : validations for claims summary page
 */
public class PharmaciesAndPrescriptionsPage extends UhcDriver{
	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;

	public PharmaciesAndPrescriptionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}


	/**
	 * Validate Need Help section content
	 * @param planType
	 * @param memberType
	 * @return
	 * @throws InterruptedException 
	 */
	public String validateNeedHelpSection(String planType, String memberType) 
			throws InterruptedException {
		handleComboTabIfComboUser(planType, memberType);
		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, 
					needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, 
					needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,
					needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, 
					needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, 
					needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,
					needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, 
					needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, 
					needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,
					needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",
					validate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",
					validate(needHelp_contactUsLink));
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			handleComboTabIfComboUser(planType, memberType);
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+"| New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. "
					+ "Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", 
					driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. "
					+ "Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", 
					driver.getTitle().contains(expContactUsTitle));
			goBackToPriorPnPpgViaBack(planType, memberType);
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, 
					needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, 
					needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, 
					needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, 
					needHelp_PlanSupport_wkDayHrs, null);
		}
		System.out.println("Main window = "+driver.getTitle());
		return driver.getCurrentUrl();
	}
	
	/**
	 * Helper method for validating Need Help section
	 * @param section
	 * @param SectionElement
	 * @param imgElement
	 * @param phoneElement
	 * @param ttyElement
	 * @param hrsOperationElement1
	 * @param hrsOperationElement2
	 */
	public void validateNeedHelpSectionContent(String section, WebElement SectionElement, WebElement imgElement, 
			WebElement phoneElement, WebElement ttyElement, WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",
				validate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",
				validate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",
				validate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",
				validate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
				validate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
					validate(hrsOperationElement2));
		}
	}

	/**
	 * Helper method to click on the target test plan on combo tab
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException 
	 */
	public void handleComboTabIfComboUser(String planType, String memberType) 
			throws InterruptedException {
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTabOnOrderPlanPage(planType);
		}
	}
	
	/**
	 * Helper method to go back to prior page via browser back, 
	 * also handles the case if combo tab is involved
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 * @throws InterruptedException 
	 */
	public void goBackToPriorPnPpgViaBack(String planType, String memberType) 
			throws InterruptedException {
			driver.navigate().back();
			CommonUtility.checkPageIsReady(driver);
			String expUrl="/member/pharmacy/overview.html";
			String actUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - unable to go back to PnP page. "
					+ "Expect URL contain '"+expUrl+"' | Actual URL='"+actUrl+"'", 
					actUrl.contains(expUrl));
			handleComboTabIfComboUser(planType, memberType);
	}
	
	/**
	 * Helper method to go to a specific combo tab based on given planType on PnP page
	 * @param planType
	 * @throws InterruptedException 
	 */
	public void goToSpecificComboTabOnOrderPlanPage(String planType) 
			throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		WebElement targetTab=null;
		if (planType.equalsIgnoreCase("MAPD")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", 
					validate(comboTab_MAPD));
			targetTab=comboTab_MAPD;
		} else if (planType.equalsIgnoreCase("SHIP") 
				|| planType.equalsIgnoreCase("MEDSUPP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", 
					validate(comboTab_SHIP));
			targetTab=comboTab_SHIP;
		} else if (planType.equalsIgnoreCase("PDP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", 
					validate(comboTab_PDP));
			targetTab=comboTab_PDP;
		} else if (planType.equalsIgnoreCase("SSUP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", 
					validate(comboTab_SSUP));
			targetTab=comboTab_SSUP;
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover "
					+ "planType '"+planType+"' for combo testing", false);
		}
		targetTab.click();
		targetTab.click();
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(1000); //note: keep to give it a sec to stable
	}
	
	@FindBy(xpath="//h1[contains(text(),'Pharmacies & Prescriptions for')]")
	protected WebElement pgHeader;
	
	@FindBy(xpath="//div[@class='pharmaciesText']/p")
	protected WebElement pharmaciesText;
	
	//note: Compare drug pricing
	@FindBy(xpath="//div[contains(@class,'DRUGPRICINGTILE')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_compDrugPricingHeaderTxt;
	
	@FindBy(xpath="//div[contains(@class,'DRUGPRICINGTILE')]//img")
	protected WebElement pTile_compDrugPricingImg;
	
	@FindBy(xpath="//div[contains(@class,'DRUGPRICINGTILE')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_compDrugPricingLnk;
	
	//note: Find a network pharmacy
	@FindBy(xpath="//div[contains(@id,'idName2')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_findNtkPharmacyHeaderTxt;

	@FindBy(xpath="//div[contains(@id,'idName2')]//img")
	protected WebElement pTile_findNtkPharmacyImg;

	@FindBy(xpath="//div[contains(@id,'idName2')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_findNtkPharmacyLnk;
	
	//note: Order prescription refills
	@FindBy(xpath="//div[contains(@class,'MEDICINE_CABINET_TILE')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_orderPresRefillsHeaderTxt;

	@FindBy(xpath="//div[contains(@class,'MEDICINE_CABINET_TILE')]//img")
	protected WebElement pTile_orderPresRefillsImg;

	@FindBy(xpath="//div[contains(@class,'MEDICINE_CABINET_TILE')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_orderPresRefillsLnk;
	
	//note: Check home delivery order status
	@FindBy(xpath="//div[contains(@class,'ORDER_STATUS_TILE')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_chkHomeDeliOrderStatusHeaderTxt;

	@FindBy(xpath="//div[contains(@class,'ORDER_STATUS_TILE')]//img")
	protected WebElement pTile_chkHomeDeliOrderStatusImg;

	@FindBy(xpath="//div[contains(@class,'ORDER_STATUS_TILE')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_chkHomeDeliOrderStatusLnk;
	
	//note: Prescription Benefits Information
	@FindBy(xpath="//div[contains(@class,'BENEFITS_INFORMATION')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_presBenfitInfoHeaderTxt;

	@FindBy(xpath="//div[contains(@class,'BENEFITS_INFORMATION')]//img")
	protected WebElement pTile_presBenfitInfoImg;

	@FindBy(xpath="//div[contains(@class,'BENEFITS_INFORMATION')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_presBenfitInfoLnk;
	
	@FindBy(xpath="//div[contains(@class,'planmaterials')]//img")
	protected WebElement viewPlanMaterialsImg;

	@FindBy(xpath="//div[contains(@class,'planmaterials')]//a")
	protected WebElement viewPlanMaterialsLnk;

	public void validateHeaderSectionContent() {
		Assert.assertTrue("PROBLEM - unable to locate pnp page header element", 
				validate(pgHeader));
	}
	
	public void validatePharmaciesText() {
		Assert.assertTrue("PROBLEM - unable to locate pnp page header element", 
				validate(pharmaciesText));
		String expectedTxt="UnitedHealthcare partners with OptumRx to provide your pharmacy services.  OptumRx helps make it easy to order prescription refills, get drug cost estimates, and find ways to save on your medications.";
		String actualTxt=pharmaciesText.getText();
		Assert.assertTrue("PROBLEM - pharmacies text is not as expected. "
				+ "Expected='"+expectedTxt+"' | Actual='"+actualTxt+"'", 
				expectedTxt.equals(actualTxt));
	}
	
	public void validateTileContent(String exp_TileHeaderTxt, String exp_TileLinkTxt, 
			WebElement exp_pTile_Txt, WebElement exp_pTile_img, WebElement exp_pTile_Lnk) {
		Assert.assertTrue("PROBLEM - unable to locate '"+exp_TileHeaderTxt+"' tile header element", 
				validate(exp_pTile_Txt));
		Assert.assertTrue("PROBLEM - unable to locate '"+exp_TileHeaderTxt+"' tile image element", 
				validate(exp_pTile_img));
		Assert.assertTrue("PROBLEM - unable to locate '"+exp_TileHeaderTxt+"' tile link element", 
				validate(exp_pTile_Lnk));

		String act_TileHeaderTxt=exp_pTile_Txt.getText();
		Assert.assertTrue("PROBLEM - '"+exp_TileHeaderTxt+"' tile text not as expected. "
				+ "Expected='"+exp_TileHeaderTxt+"' | Actual='"+act_TileHeaderTxt+"'", 
				exp_TileHeaderTxt.equals(act_TileHeaderTxt));

		String act_TileLnkTxt=exp_pTile_Lnk.getText();
		Assert.assertTrue("PROBLEM - '"+exp_TileHeaderTxt+"' tile text not as expected. "
				+ "Expected='"+exp_TileLinkTxt+"' | Actual='"+act_TileLnkTxt+"'",
				exp_TileLinkTxt.equals(act_TileLnkTxt));

	}
	
	public void validatePharmaciesTilesSection() {
		String exp_TileHeaderTxt="Compare drug pricing";
		String exp_TileLinkTxt="DRUG PRICING";
		WebElement exp_tileHeaderElement=pTile_compDrugPricingHeaderTxt;
		WebElement exp_tileImg=pTile_compDrugPricingImg;
		WebElement exp_tileLnk=pTile_compDrugPricingLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		
		exp_TileHeaderTxt="Find a network pharmacy";
		exp_TileLinkTxt="FIND A PHARMACY";
		exp_tileHeaderElement=pTile_findNtkPharmacyHeaderTxt;
		exp_tileImg=pTile_findNtkPharmacyImg;
		exp_tileLnk=pTile_findNtkPharmacyLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt="Order prescription refills";
		exp_TileLinkTxt="ORDER PRESCRIPTIONS";
		exp_tileHeaderElement=pTile_orderPresRefillsHeaderTxt;
		exp_tileImg=pTile_orderPresRefillsImg;
		exp_tileLnk=pTile_orderPresRefillsLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt="Check home delivery order status";
		exp_TileLinkTxt="CHECK DELIVERY STATUS";
		exp_tileHeaderElement=pTile_chkHomeDeliOrderStatusHeaderTxt;
		exp_tileImg=pTile_chkHomeDeliOrderStatusImg;
		exp_tileLnk=pTile_chkHomeDeliOrderStatusLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		
		exp_TileHeaderTxt="Prescription Benefits Information";
		exp_TileLinkTxt="BENEFITS INFORMATION";
		exp_tileHeaderElement=pTile_presBenfitInfoHeaderTxt;
		exp_tileImg=pTile_presBenfitInfoImg;
		exp_tileLnk=pTile_presBenfitInfoLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
	}
	
	public void validatePharmaciesLimitedTilesSection() {
		String exp_TileHeaderTxt="Compare drug pricing";
		String exp_TileLinkTxt="DRUG PRICING";
		WebElement exp_tileHeaderElement=pTile_compDrugPricingHeaderTxt;
		WebElement exp_tileImg=pTile_compDrugPricingImg;
		WebElement exp_tileLnk=pTile_compDrugPricingLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		
		exp_TileHeaderTxt="Find a network pharmacy";
		exp_TileLinkTxt="FIND A PHARMACY";
		exp_tileHeaderElement=pTile_findNtkPharmacyHeaderTxt;
		exp_tileImg=pTile_findNtkPharmacyImg;
		exp_tileLnk=pTile_findNtkPharmacyLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);

		exp_TileHeaderTxt="Order prescription refills";
		exp_tileHeaderElement=pTile_orderPresRefillsHeaderTxt;
		exp_tileImg=pTile_orderPresRefillsImg;
		exp_tileLnk=pTile_orderPresRefillsLnk;
		Assert.assertTrue("PROBLEM - for PEEHIP member user should not see '"+exp_TileHeaderTxt+"' related elements", 
				!pnpValidate(pTile_orderPresRefillsHeaderTxt, 3)
				&& !pnpValidate(pTile_orderPresRefillsImg, 3)
				&& !pnpValidate(pTile_orderPresRefillsLnk, 3)
				);
	
		exp_TileHeaderTxt="Check home delivery order status";
		exp_tileHeaderElement=pTile_chkHomeDeliOrderStatusHeaderTxt;
		exp_tileImg=pTile_chkHomeDeliOrderStatusImg;
		exp_tileLnk=pTile_chkHomeDeliOrderStatusLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		Assert.assertTrue("PROBLEM - for PEEHIP member user should not see '"+exp_TileHeaderTxt+"' related elements", 
				!pnpValidate(pTile_chkHomeDeliOrderStatusHeaderTxt, 3)
				&& !pnpValidate(pTile_chkHomeDeliOrderStatusImg, 3)
				&& !pnpValidate(pTile_chkHomeDeliOrderStatusLnk, 3)
				);
		
		exp_TileHeaderTxt="Prescription Benefits Information";
		exp_TileLinkTxt="BENEFITS INFORMATION";
		exp_tileHeaderElement=pTile_presBenfitInfoHeaderTxt;
		exp_tileImg=pTile_presBenfitInfoImg;
		exp_tileLnk=pTile_presBenfitInfoLnk;
		validateTileContent(exp_TileHeaderTxt, exp_TileLinkTxt, 
				exp_tileHeaderElement, exp_tileImg, exp_tileLnk);
		
		
	}
	
	public void validateTileLnkDestination(String planType, String memberType, String tile) 
			throws InterruptedException { //note: if arrives here, already validated link existent
		WebElement linkElement=null;
		String expUrl="";
		if (tile.equals("Compare drug pricing")) {
			linkElement=pTile_compDrugPricingLnk;
			expUrl="/member/drug-lookup/overview.html#/drug-cost-estimator";
		} else if (tile.equals("Find a network pharmacy")) {
			linkElement=pTile_findNtkPharmacyLnk;
			expUrl="/member/pharmacy-locator/overview.html#/Pharmacy-Search-English";
		} else if (tile.equals("Order prescription refills")) {
			linkElement=pTile_orderPresRefillsLnk;
			expUrl="/sso";
		} else if (tile.equals("Check home delivery order status")) {
			linkElement=pTile_chkHomeDeliOrderStatusLnk;
			expUrl="/sso";
		} else if (tile.equals("Prescription Benefits Information")) {
			linkElement=pTile_presBenfitInfoLnk;
			expUrl="/sso/outbound?outboundTo=optumrx&amp;deepLink=benefitsinformation";
		}		
		Assert.assertTrue("PROBLEM - need to code to support '"+tile+"' tile content validation", 
				linkElement !=null);
		
		linkElement.click();
		CommonUtility.checkPageIsReady(driver);
		String actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+tile+"' tile link destination URL is not as expected. "
				+ "Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
		goBackToPriorPnPpgViaBack(planType, memberType);
		 
	}
	
	public void validatePlanMaterialsLink() { //note: FnR page takes long time to load, only validate URL is correct
		Assert.assertTrue("PROBLEM - unable to locate Plan Materials icon element", 
				validate(viewPlanMaterialsImg));
		Assert.assertTrue("PROBLEM - unable to locate Plan Materials link element",
				validate(viewPlanMaterialsLnk));
		String exp_lnk="/member/documents/overview.html";
		String act_lnk=viewPlanMaterialsLnk.getAttribute("href");
		Assert.assertTrue("PROBLEM - 'PLAN MATERIALS' link url is not as expected. "
				+ "Expect='"+exp_lnk+"' | Actual='"+act_lnk+"'", 
				act_lnk.contains(exp_lnk));
	}
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean pnpValidate(WebElement element, int timeoutInSec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible. Exception message - "+e.getMessage());

		}
		return false;
	}

}
