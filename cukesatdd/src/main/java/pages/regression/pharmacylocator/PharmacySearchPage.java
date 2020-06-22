package pages.regression.pharmacylocator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;

public class PharmacySearchPage extends PharmacySearchBase {

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);
		pharmacyCheckModelPopup(driver);
		/* tbd 
		try {
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().defaultContent();
			CommonUtility.checkPageIsReady(driver);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		} */
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		pharmacyValidate(zipcodeField);
		pharmacyValidate(distanceDropDownField);
		pharmacyValidate(continueField);
	}

	public void validateHeaderSection(String memberType) {
		Assert.assertTrue("PROBLEM - unable to locate the header text element", pharmacyValidate(PharmacyLocatorPageHeader));
		Assert.assertTrue("PROBLEM - unable to locate the input section", pharmacyValidate(inputSection));
		Assert.assertTrue("PROBLEM - unable to locate the input instruction", pharmacyValidate(inputInstruction));

		Assert.assertTrue("PROBLEM - unable to locate the distance dropdown element", pharmacyValidate(distanceDropDownField));
		Assert.assertTrue("PROBLEM - number of options for distance dropdown is not as expected.  "
				+ "Expected='6' | Actual='"+distanceOptions.size()+"'", 
				distanceOptions.size()==6);
		Select select = new Select(distanceDropDownField);           
		String actualSelectedDistance = select.getFirstSelectedOption().getText();
		String expectedSelectedDistance="15 miles";
		Assert.assertTrue("PROBLEM - default selected distance option is not as expected. "
				+ "Expected='"+expectedSelectedDistance+"' | Actual='"+actualSelectedDistance+"'", 
				expectedSelectedDistance.equals(actualSelectedDistance));
		Assert.assertTrue("PROBLEM - unable to locate distance option '1 mile'", pharmacyValidate(distanceOption_1mile));
		Assert.assertTrue("PROBLEM - unable to locate distance option '2 miles'", pharmacyValidate(distanceOption_2miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '5 miles'", pharmacyValidate(distanceOption_5miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '10 miles'", pharmacyValidate(distanceOption_10miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '15 miles'", pharmacyValidate(distanceOption_15miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '20 miles'", pharmacyValidate(distanceOption_25miles));
		if (!memberType.toUpperCase().contains("MEDICA")) { //note: medica sometimes shows plan name sometimes don't depending on user data
			Assert.assertTrue("PROBLEM - unable to locate the plan name dropdown element", 
					validateNew(PlanNameDropDown));
			select = new Select(PlanNameDropDown);           
			String actualSelectedPlan = select.getFirstSelectedOption().getText();
			Assert.assertTrue("PROBLEM - default selected plan name should not be null. "
					+ "Actual='"+actualSelectedPlan+"'", 
					!actualSelectedPlan.contains("null"));
			Assert.assertTrue("PROBLEM - number of options for plans dropdown is not as expected.  "
					+ "Expected: Actual>=1 | Actual='"+planListOptions.size()+"'", 
					planListOptions.size()>=1);
		}
		Assert.assertTrue("PROBLEM - unable to locate the zipcode input field element", pharmacyValidate(zipcodeField));
		Assert.assertTrue("PROBLEM - unable to locate the search button", pharmacyValidate(searchbtn));

		//note: plan year dropdown only shows during AEP time frame - Sept - Dec (server time)
		//note: only validate field if plan year label is showing
		if (pharmacyValidate(planYearLabel)) {
			select = new Select(planYearDropDown);           
			List <WebElement> yearList = select.getOptions();
			Assert.assertTrue("PROBLEM - list of years should be >0.  Actual='"+yearList.size()+"'",
					yearList.size()>0);
			String expectedYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			boolean containCurrentYr=false;
			for(int i =0; i<yearList.size() ; i++){
				String planName = yearList.get(i).getText();
				if (planName.contains(expectedYear)) {
					containCurrentYr=true;
					break;
				}
			}
			Assert.assertTrue("PROBLEM - list of year options should contain current year as option.",
					containCurrentYr);
		}
	}

	/**
	 * Validate Widgets
	 *   From copy deck:
	 *   Preferred Retail Pharmacy Network
	 *     Only display the Preferred Retail Pharmacy Network tile for plans that have a Preferred Retail Pharmacy benefit. 
	 *     Do not display for the AARP MedicareRx Walgreens plan
	 *   Walgreens â€“ Preferred Retail Pharmacy
	 *     Only display the Walgreens tile for AARP MedicareRx Walgreens plan members
	 *   Preferred Mail Service Pharmacy
	 *     Only display the Preferred Mail Service Pharmacy tile for plans that have a Preferred Mail Service Pharmacy benefit. 
	 *     Do not display for AL PEEHIP  
	 * @param planType
	 */
	public void validatePharmacyWidgets(String language, String planType, String memberType, 
			boolean expectPrefRetailPharmacyPlan, boolean expectWalgreensPlan, boolean expectPrefMailServPlan) { 
		String testWidget="";
		String expUrl="";
		boolean hasWalgreensPlan=false;
		/* below code is if you want to use plan dropdown to determine if walgreens widget should show up 
		Select select = new Select(PlanNameDropDown);  
		String planName= select.getFirstSelectedOption().getText();
		List <WebElement> planList = select.getOptions();
		for(int i =0; i<planList.size() ; i++){
			String planName = planList.get(i).getText();
			if (planName.contains("AARP MedicareRx Walgreens")) {
				hasWalgreensPlan=true;
				break;
			}
		}
		if (planName.contains("AARP MedicareRx Walgreens")) {
			hasWalgreensPlan=true;
		}
		Assert.assertTrue("PROBLEM - test input expects no walgreens plan but user has walgreens plan", 
				expectWalgreensPlan==hasWalgreensPlan);
		*/
		//note: use user input from feature file to determine what widget(s) to expect
		testWidget="Preferred Retail Pharmacy Network";
		if (expectPrefRetailPharmacyPlan) { //note: with this plan should see widget BUT if plan is walgreen then won't
			if (expectWalgreensPlan) {
				Assert.assertTrue("PROBLEM - PDP user has Walgreens plan should not see '"+testWidget+"' widget", 
						!pharmacyValidate(widget_preferredRetailPharmacyNetwork));
			} else {
				Assert.assertTrue("PROBLEM - PDP user should see '"+testWidget+"' widget", 
						pharmacyValidate(widget_preferredRetailPharmacyNetwork));
				Assert.assertTrue("PROBLEM - PDP user should not see 'Walgreens - Preferred Retail Pharmacy' widget", 
						!pharmacyValidate(widget_walgreens));
				expUrl="/member/drug-lookup/overview.html#/drug-cost-estimator";
				if (memberType.toUpperCase().contains("GROUP")) 
					validateWidget(language, "DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts_grp, expUrl);
				else
					validateWidget(language, "DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts_ind, expUrl);
			}
		} else {
			Assert.assertTrue("PROBLEM - user input does not expect to see '"+testWidget+"' widget", 
					!pharmacyValidate(widget_preferredRetailPharmacyNetwork));
		}

		testWidget="Walgreens - Preferred Retail Pharmacy";
		if (expectWalgreensPlan) {	
			if (hasWalgreensPlan) {
				Assert.assertTrue("PROBLEM - user has Walgreens plan should see '"+testWidget+"' widget", 
						pharmacyValidate(widget_walgreens));
				expUrl="/member/drug-lookup/overview.html#/drug-cost-estimator";
				if (memberType.toUpperCase().contains("GROUP")) 
					validateWidget(language, "DCE", testWidget, widget_walgreens_estYurDrugCosts_grp, expUrl);
				else
					validateWidget(language, "DCE", testWidget, widget_walgreens_estYurDrugCosts_ind, expUrl);
			}
		} else {
			Assert.assertTrue("PROBLEM - user input does not expect to see '"+testWidget+"' widget", 
					!pharmacyValidate(widget_walgreens));
		}

		testWidget="Preferred Mail Service Pharmacy";
		if (expectPrefMailServPlan) {
			Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", 
					pharmacyValidate(widget_preferredMailServicePharmacy));

			if (planType.equalsIgnoreCase("PDP") ) {
				expUrl="/member/documents/mail-benefit-pdp.html";
				validateWidget(language, "LearnMore", testWidget, widget_prefMailServPhar_learnMore_pdp, expUrl);
			} else {  //note: may need to tweak, assume if not pdp then will be mapd for now
				expUrl="/member/documents/mail-benefit-mapd.html";
				validateWidget(language, "LearnMore", testWidget, widget_prefMailServPhar_learnMore_mapd, expUrl);
			}
		} else {
			Assert.assertTrue("PROBLEM - user input does not expect to see '"+testWidget+"' widget", 
					!pharmacyValidate(widget_preferredMailServicePharmacy));
		}
	}

	/**
	 * Validate widget content
	 *   existing issue INC12081977 - walgreen widget DCE link point to different links (page not found) for Chinese and Spanish; works fine for English
	 * @param language
	 * @param linkType
	 * @param widgetName
	 * @param learnMoreElement
	 * @param expUrl
	 */
	public void validateWidget(String language, String linkType, String widgetName, WebElement learnMoreElement, String expUrl) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.waitForPageLoad(driver, learnMoreElement, 5);
		moveMouseToElement(needHelpHeader); //note: move to 'Need Help' so 'More Info' element is in view
		Assert.assertTrue("PROBLEM - '"+linkType+"' link should show for '"+widgetName+"' widget", 
				pharmacyValidate(learnMoreElement));
		CommonUtility.checkPageIsReady(driver);
		learnMoreElement.click();
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actUrl=driver.getCurrentUrl();
		if (language.equalsIgnoreCase("English")) {
			Assert.assertTrue("PROBLEM - '"+linkType+"' link on '"+widgetName+"' widget is not opening expected page.  "
					+ "Expected url contains '"+expUrl+"' | Actual URL='"+actUrl+"'", 
					actUrl.contains(expUrl));
		} else {
			System.out.println("BYPASS for now - known issue INC12081977 - Walgreen widget DCE link is not pointing to correct place for Chinese and Spanish");
		}
		if (linkType.equalsIgnoreCase("LearnMore")) {
			Assert.assertTrue("PROBLEM - unable to locate the 'Return to previous page' link to go back to previous page", pharmacyValidate(widget_learnMore_previousPage));
			widget_learnMore_previousPage.click(); //note: click link to go back to pharmacy locator page
		} else 
			driver.navigate().back(); //note: use driver back to go back to pharmacy locator page
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		expUrl="/member/pharmacy-locator/overview.html#/Pharmacy-Search-";
		actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - Unable to get back to pharmacy locator page for further validation. "
				+ "Expected url contains '"+expUrl+"' | Actual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
	}

	public void validateAllTooltips(String memberType, String language, boolean hasPrefRetailPharmacyWidget) {
		//note: need this to shift things into view for validation
		if (pharmacyValidate(noResultMsg)) {
			moveMouseToElement(noResultMsg);
		} else if (pharmacyValidate(noResultMsgTopPink)) {
			moveMouseToElement(noResultMsgTopPink);
		} else {
			moveMouseToElement(map_showHideMapLnk);
		}
		
		String targetTooltipName="Standard Network Pharmacy";
		String testXpath="//input[@id='pharmacy-standard']/../span";
		//tbd String expTxt1="Standard Network Pharmacy";
		//tbd String expTxt2="A pharmacy where you get the prescription drug benefits provided by your plan.";
		//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		String expTxt="Standard Network Pharmacy A pharmacy where you get the prescription drug benefits provided by your plan.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		if (hasPrefRetailPharmacyWidget) {
			targetTooltipName="Preferred Retail Pharmacy";
			testXpath="//input[@id='pharmacy-preffered']/../span";
			//tbd expTxt1="Preferred Retail Pharmacy:";
			//tbd expTxt2="Preferred retail pharmacies may help you save money on your prescription copays.";
			//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
			expTxt="Preferred Retail Pharmacy: Preferred retail pharmacies may help you save money on your prescription copays.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
		}
		targetTooltipName="E-prescribing";
		testXpath="//input[@id='ePrescribing']/../span";
		//tbd expTxt1="E-prescribing";
		//tbd expTxt2="Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor's office.";
		//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		//note: actual text should be "... doctor's office..." but jenkins job has trouble comparing ' so use pattern match instead so string becomes "...doctor.s office" as regex
		expTxt="E-prescribing Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor.s office.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Open 24 Hours";
		testXpath="//input[@id='24-hours']/../span";
		//tbd expTxt1="Open 24 Hours";
		//tbd expTxt2="This store is open to serve your pharmacy needs 24 hours a day, 7 days a week.";
		//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		expTxt="Open 24 Hours This store is open to serve your pharmacy needs 24 hours a day, 7 days a week.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Home Infusion and Specialty";
		testXpath="//input[@id='home-specialty']/../span";
		//tbd expTxt1="Home Infusion and Specialty";
		//tbd expTxt2="Medication therapies and services used to treat complex health conditions can be purchased at this location.";
		//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		expTxt="Home Infusion and Specialty Medication therapies and services used to treat complex health conditions can be purchased at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		if (!memberType.toUpperCase().contains("TEXAS")) {
			targetTooltipName="Retail Pharmacy (90-day)";
			testXpath="//input[@id='StandardNightyDays']/../span";
			//tbd expTxt1="Retail Pharmacy (90-day)";
			//tbd expTxt2="You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
			//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
			expTxt="Retail Pharmacy \\(90-day\\) You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
		}

		targetTooltipName="Indian/Tribal/Urban";
		testXpath="//input[@id='indian-tribal']/../span";
		//tbd expTxt1="Indian/Tribal/Urban (I/T/U)";
		//tbd expTxt2="This location is an Indian health service, Tribal or Urban Indian health program pharmacy.";
		//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		expTxt="Indian/Tribal/Urban \\(I/T/U\\) This location is an Indian health service, Tribal or Urban Indian health program pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Long-term care";
		testXpath="//input[@id='long-term']/../span";
		//tbd expTxt1="Long-term care";
		//tbd expTxt2="Products and services for long-term care facilities are available at this location.";
		//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		expTxt="Long-term care Products and services for long-term care facilities are available at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		if (!memberType.toUpperCase().contains("PEEHIP")) {
			targetTooltipName="Mail Order Pharmacy";
			testXpath="//input[@id='mail-order']/../span";
			//tbd expTxt1="Mail Order Pharmacy:";
			//tbd expTxt2="You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
			//tbd validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
			expTxt="Mail Order Pharmacy: You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
		}
	}

	public void validateOneTooltip(String language, String targetTooltipName, String testXpath, String expTxt) {
	//tbd public void validateOneTooltip(String language, String targetTooltipName, String testXpath, String expTxt1, String expTxt2) {
		moveMouseToElement(distanceDropDownField);//note: move filters into view
		WebElement testTooltip=driver.findElement(By.xpath(testXpath));
		Assert.assertTrue("PROBLEM - unable to locate "+targetTooltipName+" tooltip element", 
				pharmacyValidate(testTooltip));
		System.out.println("Proceed to mouse over '"+targetTooltipName+"' element...");
		moveMouseToElement(testTooltip);  //note: move mouse over to target element
		
		Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", 
				pharmacyValidate(tooltip));
		if (language.equalsIgnoreCase("English")) { //note: only validate the text for english case
			/* tbd 
			String actualTxtXpath1=testXpath+"/span/p[1]";
			String actualTxt1=driver.findElement(By.xpath(actualTxtXpath1)).getText();
			String actualTxtXpath2=testXpath+"/span/p[2]";
			String actualTxt2=driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
			Assert.assertTrue("PROBLEM - not getting expected tooltip text for "+targetTooltipName+" element.  "
					+ "Expected='"+expTxt1+"' | "
					+ "Actual-'"+actualTxt1+"'", expTxt1.equals(actualTxt1));
			Assert.assertTrue("PROBLEM - not getting expected tooltip text for "+targetTooltipName+" element.  "
					+ "Expected='"+expTxt2+"' | "
					+ "Actual-'"+actualTxt2+"'", expTxt2.equals(actualTxt2));
			*/
			Pattern expectedTxt=Pattern.compile(expTxt);
			String actualTxtXpath="//div[@id='tooltip' and contains(text(),'"+targetTooltipName+"')]";
			String actualTxt=driver.findElement(By.xpath(actualTxtXpath)).getText();
			Assert.assertTrue("PROBLEM - pharmacies text is not as expected. "
					+ "Expected to contain '"+expectedTxt+"' | Actual='"+actualTxt+"'", 
					expectedTxt.matcher(actualTxt).find());
		}
		moveMouseToElement(moveAwayFromTooltip);//note: move away
	}

	/** Verify error messages in pharmacy page */
	public PharmacySearchPage validateErrorMessages(String inputZip,String language) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		CommonUtility.checkPageIsReady(driver);
		if (inputZip==null || inputZip.equals("")) { //note: no zip value
           		
             Assert.assertTrue("PROBLEM - not seeing no zip error element",pharmacyValidate(noZipcode));
		
			if(language.equalsIgnoreCase("English")){
						String exp_noZipTxt="ZIP Code � Please enter a ZIP code";
				  	String act_noZipTxt=noZipcode.getText();
						Assert.assertTrue("PROBLEM - no Zip error text is not as expected. "
								+ "Expected='"+exp_noZipTxt+"' | Actual='"+act_noZipTxt+"'",
								act_noZipTxt.contains(exp_noZipTxt));
				}
		} else {
			if (!pattern.matcher(inputZip).matches()) { //note: zip invalid format
				
				Assert.assertTrue("PROBLEM - not seeing zip format error element",
						pharmacyValidate(invalidZip));
				if(language.equalsIgnoreCase("English")){
					
				  String exp_zipFormatErrTxt="Please enter your ZIP code as 5 numbers like this";
					String act_zipFormatErrTxt=invalidZip.getText();
					Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
							+ "Expected='"+exp_zipFormatErrTxt+"' | Actual='"+act_zipFormatErrTxt+"'",
							act_zipFormatErrTxt.contains(exp_zipFormatErrTxt));
				}
			} else { //note: if format is right then going to assume u r getting this error
					Assert.assertTrue("PROBLEM - not seeing zip format error element",
						pharmacyValidate(modifyZipErr));
				
				if(language.equalsIgnoreCase("English")){
				String exp_noPlanForZipErrTxt="There were no results found for the requested search. Broadening your search criteria";
			
				String act_noPlanForZipErrTxt=modifyZipErr.getText();
				Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
						+ "Expected='"+exp_noPlanForZipErrTxt+"' | Actual='"+act_noPlanForZipErrTxt+"'",
						act_noPlanForZipErrTxt.contains(exp_noPlanForZipErrTxt));
					}
			} //note: may need to code for a case when zip result in no result but don't know of a zip that has that behavior yet
		}
		return new PharmacySearchPage(driver);
	}

	public PharmacySearchPage validateGetDirectionLinks() {
		CommonUtility.checkPageIsReady(driver);
		int getDirectionCount = getDirectionLnk.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of GetDirection Links displayed : "+getDirectionCount);
		System.out.println(" No of Pharmacy Results displayed : "+PharmacyCount);
		if(getDirectionCount==PharmacyCount){
			System.out.println("Get Direction Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPage(driver);
		}
		return null;
	}	

	/** Verify PDF results 
	 * @throws InterruptedException */
	public PharmacySearchPage validateSearchPdfResult() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 10);
		moveMouseToElement(map_showHideMapLnk); //note: scroll so pdf link will be in view
		Assert.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", pharmacyValidate(viewsearchpdf));
		String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		viewsearchpdf.click();
		Thread.sleep(5000); //note: keep this for the page to load
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int i=0;
		while (i<3) {
			if (beforeClicked_tabs.size()==afterClicked_tabs.size()) {
				System.out.println(i+" give it extra 3 seconds for pdf to load");
				Thread.sleep(3000); //note: keep this for the page to load
				afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());				//tbd i=i++;
				i=i++;
			} else 
				break;
		}
		afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());				//tbd i=i++;
		int afterClicked_numTabs=afterClicked_tabs.size();
		System.out.println("TEST - afterClicked_numTabs="+afterClicked_numTabs);
		//note: no point to continue if tab for pdf didn't show
		Assert.assertTrue("PROBLEM - expect more browser tabs after clicking pdf. "
				+ "Before="+beforeClicked_tabs.size()+" | After="+afterClicked_numTabs,
				beforeClicked_tabs.size()<afterClicked_numTabs);
		
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		Thread.sleep(2000); //note: keep this for the page to load
		System.out.println("New window = "+driver.getTitle());
		String currentURL=driver.getCurrentUrl();
		String expectedURL="member/pharmacy-locator";
		Assert.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, URL should not contain '"+expectedURL
				+"' | Actual URL='"+currentURL+"'", !currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().contains("Locate a Pharmacy")) 
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Validate More info section */
	public void validateMoreInfoContent() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, moreInfoLink, 5);
		moreInfoLink.click();
		Assert.assertTrue("PROBLEM - text is not displaying after clicking 'More Info' link", 
				pharmacyValidate(moreInfoText_show));
		moreInfoLink.click();
		Assert.assertTrue("PROBLEM - text should NOT displaying after collapsing 'More Info' link again", 
				!pharmacyValidate(moreInfoText_show));
	}

	public void validateMapSectionContent(boolean hasPrefRetailPharmacy) {
		CommonUtility.waitForPageLoad(driver, map_mapBtn, 5);
		moveMouseToElement(map_resultSection);
		Assert.assertTrue("PROBLEM - unable to locate the map", 
				pharmacyValidate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", 
				pharmacyValidate(map_mapBtn));
		Assert.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map", 
				pharmacyValidate(map_satelliteBtn));
		Assert.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map", 
				pharmacyValidate(map_fullScreenViewBtn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom in button on the map", 
				pharmacyValidate(map_zoomIn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom out button on the map", 
				pharmacyValidate(map_zoomOut));
		Assert.assertTrue("PROBLEM - unable to locate the open street view button on the map", 
				pharmacyValidate(map_openStreetView));

		Assert.assertTrue("PROBLEM - unable to locate 'Standard Network Pharmacy' legend img element", 
				pharmacyValidate(map_legendStdNetImg));
		Assert.assertTrue("PROBLEM - unable to locate 'Standard Network Pharmacy' legend text element", 
				pharmacyValidate(map_legendStdNetTxt));

		if (hasPrefRetailPharmacy) {
			Assert.assertTrue("PROBLEM - unable to locate 'Preferred Network Pharmacy' legend img element", 
					pharmacyValidate(map_legendPrefNetImg));
			Assert.assertTrue("PROBLEM - unable to locate 'Preferred Network Pharmacy' legend text element", 
					pharmacyValidate(map_legendPrefNetTxt));
		} else {
			Assert.assertTrue("PROBLEM - should not see 'Preferred Network Pharmacy' legend img element", 
					!pharmacyValidate(map_legendPrefNetImg));
			Assert.assertTrue("PROBLEM - should not see 'Preferred Network Pharmacy' legend text element", 
					!pharmacyValidate(map_legendPrefNetTxt));
		}
		int bannderHight = 0;
		if (pharmacyValidate(offlineEnvPinkBanner)) {
			bannderHight = offlineEnvPinkBanner.getSize().getHeight(); 
			bannderHight=bannderHight+5;
		}
		Point map_showHideMapLnk_coor = map_showHideMapLnk.getLocation();
		int posY=map_showHideMapLnk_coor.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+(posY-bannderHight)+")");
	//	moveMouseToElement(mailOrderFilter); //note: in case running on offline - scroll to this so show/hide map will be visible 
		Assert.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", 
				pharmacyValidate(map_showHideMapLnk));
		scrollElementToCenterScreen(map_showHideMapLnk);
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link", 
				!pharmacyValidate(map_mapImg));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link", 
				pharmacyValidate(map_mapImg));
	}

	/** Validate show on map link appearance for search results */
	public PharmacySearchPage validateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of SHOW ON MAP Links displayed : "+showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : "+PharmacyCount);
		if(showonmapCount==PharmacyCount){
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
	public void validateSegmentId(String planType, String memberType, String expectedSegmentId) {
		String lookForPlanCategory="";
		boolean isComboUser=false;
		if (memberType.toUpperCase().contains("COMBO"))
			isComboUser=true;
		if (planType.equalsIgnoreCase("SHIP"))
			lookForPlanCategory="MEDICARE SUPPLEMENT";
		else if (planType.equalsIgnoreCase("SSUP")) 
			lookForPlanCategory="SSP";
		else if (planType.equalsIgnoreCase("PCP") || planType.equalsIgnoreCase("MEDICA")) 
			lookForPlanCategory="MAPD";
		else 
			lookForPlanCategory=planType;

		String consumerDetails=getConsumerDetailsFromlocalStorage();
		System.out.println("consumerDetails="+consumerDetails);
		String actualSegmentId=getSegmentIdInConsumerDetails(isComboUser, lookForPlanCategory, consumerDetails);
		Assert.assertTrue("PROBLEM - not getting expected SegmentId for plan '"+planType+"'. "
				+ "Expected='"+expectedSegmentId+"' | Actual='"+actualSegmentId+"'", 
				expectedSegmentId.equals(actualSegmentId));
	}
	
	public String getConsumerDetailsFromlocalStorage() {
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver) ;
		Assert.assertTrue("PROBLEM - unable to obtain LocalStorage info", webStorage!=null);
		LocalStorage localStorage = webStorage.getLocalStorage();
		String consumerDetails=localStorage.getItem("consumerDetails");
		Assert.assertTrue("PROBLEM - unable to obtain consumerDetails from LocalStorage", consumerDetails!=null);
		return consumerDetails;
	}
	
	public String getSegmentIdInConsumerDetails(boolean isComboUser, String lookForPlanCategory, String consumerDetails) {
		String actualSegmentId=null;
		try {
			JSONObject jsonObj = new JSONObject(consumerDetails);
			JSONArray arr =jsonObj.getJSONArray("planProfiles");
			if (isComboUser) 
				Assert.assertTrue("PROBLEM - test data expect this user to be a combo user "
						+ "but the localStorage.consumerDetails has only one planProfiles.  "
						+ "Please double check and correct test data", arr.length()>1);
			for (int i = 0; i < arr.length(); i++) {
				String actualPlanCategory = arr.getJSONObject(i).getString("planCategory");
				System.out.println("i="+i+" | actualPlanCategory="+actualPlanCategory+" | looking lookForPlanCategory="+lookForPlanCategory);
				//note: need to locate the right plan for segmentId validation
				if (lookForPlanCategory.equals(actualPlanCategory)) {
					actualSegmentId = arr.getJSONObject(i).getString("segmentId");
				}
			}
			Assert.assertTrue("PROBLEM - unable to locate segmentId from localStorage.consumerDetails. Please double check planType from input match the actual user data", 
					actualSegmentId!=null);
		} catch (JSONException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		return actualSegmentId;
	}

	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
		                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
		                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); */
	}

}



