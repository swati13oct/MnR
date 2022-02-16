package pages.acquisition.pharmacyLocator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import pages.acquisition.dceredesign.GetStartedPage;

public class PharmacySearchPageNew extends PharmaacySearchBaseNew {

    public int PharmacyCount;

    public PharmacySearchPageNew(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        CommonUtility.checkPageIsReadyNew(driver);
        if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
            checkModelPopup(driver, 10);
        // CommonUtility.waitForPageLoadNew(driver, pharmacysearchpageheader, 10);
        validate(pharmacysearchpageheader);
        validate(distanceDropDownField);
        validate(zipcodeField);
        validate(countyModal);
    }

    public void selectYearOption(String year) {
        try {
            if (year.equalsIgnoreCase("current")) {
                if (validate(CurrentYearLink))
                    CurrentYearLink.click();
            } else {
                if (validate(NextYearLink))
                    NextYearLink.click();
            }
            CommonUtility.checkPageIsReadyNew(driver);
        } catch (Exception e) {
            System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on Pharmacy Page : ");
            e.printStackTrace();
        }
    }

    public void validateHeaderSection() {
        CommonUtility.waitForPageLoad(driver, pharmacysearchpageheader, 5);
        Assertion.assertTrue("PROBLEM - unable to locate the header text element",
                pharmacyValidate(pharmacysearchpageheader));
        Assertion.assertTrue("PROBLEM - unable to locate the input instruction", pharmacyValidate(inputInstruction));

        Assertion.assertTrue("PROBLEM - unable to locate the distance dropdown element",
                pharmacyValidate(distanceDropDownField));
        Assertion.assertTrue("PROBLEM - number of options for distance dropdown is not as expected.  "
                + "Expected='6' | Actual='" + distanceOptions.size() + "'", distanceOptions.size() == 6);
        Select select = new Select(distanceDropDownField);
        String actualSelectedDistance = select.getFirstSelectedOption().getText();
        String expectedSelectedDistance = "15 Miles";
        Assertion.assertTrue(
                "PROBLEM - default selected distance option is not as expected. " + "Expected='"
                        + expectedSelectedDistance + "' | Actual='" + actualSelectedDistance + "'",
                expectedSelectedDistance.equals(actualSelectedDistance));
        Assertion.assertTrue("PROBLEM - unable to locate distance option '1 mile'",
                pharmacyValidate(distanceOption_1mile));
        Assertion.assertTrue("PROBLEM - unable to locate distance option '2 miles'",
                pharmacyValidate(distanceOption_2miles));
        Assertion.assertTrue("PROBLEM - unable to locate distance option '5 miles'",
                pharmacyValidate(distanceOption_5miles));
        Assertion.assertTrue("PROBLEM - unable to locate distance option '10 miles'",
                pharmacyValidate(distanceOption_10miles));
        Assertion.assertTrue("PROBLEM - unable to locate distance option '15 miles'",
                pharmacyValidate(distanceOption_15miles));
        Assertion.assertTrue("PROBLEM - unable to locate distance option '20 miles'",
                pharmacyValidate(distanceOption_25miles));
        Assertion.assertTrue("PROBLEM - unable to locate the zipcode input field element",
                pharmacyValidate(zipcodeField));
        Assertion.assertTrue("PROBLEM - unable to locate the Pharmacy Name - Optional input field element",
                pharmacyValidate(pharmacyNameOptionalTxt));
    }

    public PharmacySearchPageNew validatePharmacyErrormessages(String language, String inputZip) {
        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(regex);
        CommonUtility.checkPageIsReady(driver);
        if (inputZip == null || inputZip.equals("")) { // note: no zip value
            String exp_noZipTxt = "Please enter a valid ZIP Code";
            Assertion.assertTrue("PROBLEM - not seeing no zip error element", pharmacyValidate(noZipcode));
            if (language.equalsIgnoreCase("English")) {
                String act_noZipTxt = noZipcode.getText();
                Assertion.assertTrue("PROBLEM - no Zip error text is not as expected. " + "Expected='" + exp_noZipTxt
                        + "' | Actual='" + act_noZipTxt + "'", act_noZipTxt.contains(exp_noZipTxt));
            }
        } else {
            if (!pattern.matcher(inputZip).matches()) { // note: zip invalid format
                String exp_zipFormatErrTxt = "Please enter a valid ZIP Code";
                Assertion.assertTrue("PROBLEM - not seeing zip format error element", pharmacyValidate(invalidZip));
                if (language.equalsIgnoreCase("English")) {
                    String act_zipFormatErrTxt = invalidZip.getText();
                    Assertion.assertTrue(
                            "PROBLEM - Zip format error text is not as expected. " + "Expected='" + exp_zipFormatErrTxt
                                    + "' | Actual='" + act_zipFormatErrTxt + "'",
                            act_zipFormatErrTxt.contains(exp_zipFormatErrTxt));
                }
            } else { // note: if format is right then going to assume u r getting this error
			/*	String exp_noPlanForZipErrTxt = "There were no results found for the requested search. Broadening your search criteria";
				Assertion.assertTrue("PROBLEM - not seeing zip format error element", pharmacyValidate(modifyZipErr));
				if (language.equalsIgnoreCase("English")) {
					String act_noPlanForZipErrTxt = modifyZipErr.getText();
					Assertion.assertTrue(
							"PROBLEM - Zip format error text is not as expected. " + "Expected='"
									+ exp_noPlanForZipErrTxt + "' | Actual='" + act_noPlanForZipErrTxt + "'",
							act_noPlanForZipErrTxt.contains(exp_noPlanForZipErrTxt));
				}
				*/
            } // note: may need to code for a case when zip result in no result but don't know
            // of a zip that has that behavior yet
        }
        return new PharmacySearchPageNew(driver);
    }

//	public void validateMapSectionContent() {
//		CommonUtility.checkPageIsReadyNew(driver);
//		scrollToView(map_resultSection);
////		moveMouseToElement(map_resultSection);
//		Assertion.assertTrue("PROBLEM - unable to locate the map", pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", pharmacyValidate(map_showHideMapLnk));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link",
//				!pharmacyValidate(map_mapImg));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link",
//				pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", pharmacyValidate(map_mapBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map",
//				pharmacyValidate(map_satelliteBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map",
//				pharmacyValidate(map_fullScreenViewBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom in button on the map", pharmacyValidate(map_zoomIn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom out button on the map", pharmacyValidate(map_zoomOut));
//		Assertion.assertTrue("PROBLEM - unable to locate the open street view button on the map",
//				pharmacyValidate(map_openStreetView));
//
//	}

    public PharmacySearchPageNew ValidateFrontMatterPdfResults(String testPlanName) throws InterruptedException {
        CommonUtility.checkPageIsReady(driver);
        CommonUtility.waitForPageLoad(driver, viewFrontMatterPdf, 20);
        Assertion.assertTrue("PROBLEM - View Front Matter PDF link is NOT DISPLAYED", pharmacyValidate(viewFrontMatterPdf));
        String winHandleBefore = driver.getWindowHandle();
        ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//		viewsearchpdf.click();
        jsClickNew(viewFrontMatterPdf);
        Thread.sleep(5000); // note: keep this for the page to load
        ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
        int i = 0;
        while (i < 3) {
            if (beforeClicked_tabs.size() == afterClicked_tabs.size()) {
                System.out.println(i + " give it extra 3 seconds for pdf to load");
                Thread.sleep(3000); // note: keep this for the page to load
                afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
                i = i++;
                i = i++;
            } else
                break;
        }
        afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
        i = i++;
        int afterClicked_numTabs = afterClicked_tabs.size();
        System.out.println("TEST - afterClicked_numTabs=" + afterClicked_numTabs);
        // note: no point to continue if tab for pdf didn't show
        Assertion.assertTrue("PROBLEM - expect more browser tabs after clicking pdf. " + "Before="
                        + beforeClicked_tabs.size() + " | After=" + afterClicked_numTabs,
                beforeClicked_tabs.size() < afterClicked_numTabs);
        String tab = null;
        for (int j = 0; j < afterClicked_numTabs; j++) {
            if (j == afterClicked_numTabs - 1) {
                tab = afterClicked_tabs.get(j);
                driver.switchTo().window(tab);
                break;
            }
        }
        /*
         * for (String tab : afterClicked_tabs) { if (!tab.equals(winHandleBefore)) {
         * driver.switchTo().window(tab); break; } }
         */
//		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
        System.out.println("New window = " + driver.getTitle());
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is : " + currentURL);


        String expectedURL = "member/pharmacy-locator";
        Assertion.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, " + "URL should not contain '"
                + expectedURL + "' | Actual URL='" + currentURL + "'", !currentURL.contains(expectedURL));
        //driver.close();
        driver.switchTo().window(winHandleBefore);
        CommonUtility.checkPageIsReadyNew(driver);
        System.out.println("TEST - driver.getTitle()=" + driver.getTitle());
        if (driver.getTitle().toLowerCase().contains("locate a pharmacy"))
            return new PharmacySearchPageNew(driver);
        return null;
    }

    public void validatePlanNameInResultsSection(String testPlanName) {
        WebElement PlanNameText = driver.findElement(By.xpath("//h3[contains(text(), '" + testPlanName + "')]"));
        if (validateNew(PlanNameText)) {
            System.out.println("Ecpected Plan Name displayed in Pharmacy Results section : " + PlanNameText.getText());
        } else
            Assertion.fail("Plan Name is NOT Displayed in Pharmacy Results Section");
    }

    /**
     * Validate show on map link appearance for search results
     */
    public PharmacySearchPageNew validateShowOnMapLinks() {
        CommonUtility.checkPageIsReady(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-100)", "");
        int showonmapCount = showonmap.size();
        int PharmacyCount = PharmacyResultList.size();
        System.out.println(" No of SHOW ON MAP Links displayed : " + showonmapCount);
        System.out.println(" No of Pharmacy Results displayed : " + PharmacyCount);
        if (showonmapCount == PharmacyCount) {
            System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
            return new PharmacySearchPageNew(driver);
        }
        return null;
    }

    public void validateMapSectionContent() {
        CommonUtility.checkPageIsReadyNew(driver);
        pageloadcomplete();
        CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath("//*[@id='map']/div/div"), 5);
        scrollToView(mapCollapse);
//		moveMouseToElement(map_resultSection);
//		Assertion.assertTrue("PROBLEM - unable to locate the map", pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", pharmacyValidate(map_showHideMapLnk));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link",
//				!pharmacyValidate(map_mapImg));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link",
//				pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", pharmacyValidate(map_mapBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map",
//				pharmacyValidate(map_satelliteBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map",
//				pharmacyValidate(map_fullScreenViewBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom in button on the map", pharmacyValidate(map_zoomIn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom out button on the map", pharmacyValidate(map_zoomOut));
//		Assertion.assertTrue("PROBLEM - unable to locate the open street view button on the map",
//				pharmacyValidate(map_openStreetView));

    }

    public PharmacySearchPageNew ValidateSearchPdfResults(String testPlanName) throws InterruptedException {
        CommonUtility.checkPageIsReady(driver);
        CommonUtility.waitForPageLoad(driver, viewsearchpdf, 20);
        Assertion.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", pharmacyValidate(viewsearchpdf));
        String winHandleBefore = driver.getWindowHandle();
        ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//		//viewsearchpdf.click();
        jsClickNew(viewsearchpdf);
        Thread.sleep(5000); // note: keep this for the page to load
        ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
        int i = 0;
        while (i < 3) {
            if (beforeClicked_tabs.size() == afterClicked_tabs.size()) {
                System.out.println(i + " give it extra 3 seconds for pdf to load");
                Thread.sleep(3000); // note: keep this for the page to load
                afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
                i = i++;
                i = i++;
            } else
                break;
        }
        afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
        i = i++;
        int afterClicked_numTabs = afterClicked_tabs.size();
        System.out.println("TEST - afterClicked_numTabs=" + afterClicked_numTabs);
        // note: no point to continue if tab for pdf didn't show
        Assertion.assertTrue("PROBLEM - expect more browser tabs after clicking pdf. " + "Before="
                        + beforeClicked_tabs.size() + " | After=" + afterClicked_numTabs,
                beforeClicked_tabs.size() < afterClicked_numTabs);
        String tab = null;
        for (int j = 0; j < afterClicked_numTabs; j++) {
            if (j == afterClicked_numTabs - 1) {
                tab = afterClicked_tabs.get(j);
                driver.switchTo().window(tab);
                break;
            }
        }
        System.out.println("New window = " + driver.getTitle());
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is : " + currentURL);


        String expectedURL = "member/pharmacy-locator";
        Assertion.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, " + "URL should not contain '"
                + expectedURL + "' | Actual URL='" + currentURL + "'", !currentURL.contains(expectedURL));
        driver.switchTo().window(winHandleBefore);
        CommonUtility.checkPageIsReadyNew(driver);
        System.out.println("TEST - driver.getTitle()=" + driver.getTitle());
        if (driver.getTitle().toLowerCase().contains("locate a pharmacy"))
            return new PharmacySearchPageNew(driver);
        return null;
    }

    /**
     * Validate More info section
     */
    public void validateMoreInfoContent() {
        CommonUtility.checkPageIsReady(driver);
        CommonUtility.waitForPageLoad(driver, moreInfoLink, 5);
//		moreInfoLink.click();
        jsClickNew(moreInfoLink);
        Assertion.assertTrue("PROBLEM - text is not displaying after clicking 'More Info' link",
                pharmacyValidate(moreInfoText_show));
//		moreInfoLink.click();
        jsClickNew(moreInfoLink);
        Assertion.assertTrue("PROBLEM - text should NOT displaying after collapsing 'More Info' link again",
                !pharmacyValidate(moreInfoText_show));
    }

    public void validateBreadCrumb(String breadcrumb) {
        validateNew(breadCrumbLink);
        Assertion.assertTrue("Expected breadcrumb" + breadcrumb + "not displayed",
                breadcrumb.equals(breadCrumbLink.getText()));
    }

    public void clickBreadCrumb() {
        //breadCrumbLink.click();
        jsClickNew(breadCrumbLink);
        waitForPageLoadSafari();
    }

    @FindBy(xpath = "//a[text()='Estimate your drug costs at a preferred retail pharmacy']")
    private WebElement DCELink;

    @FindBy(xpath = "//button[contains(@dtmname,'add my drugs')]")
    public WebElement AddMyDrugsBtn;

    public GetStartedPage navigateToDCE() {
        scrollToView(DCELink);
        validateNew(DCELink);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", DCELink);
        DCELink.click();
        CommonUtility.checkPageIsReadyNew(driver);
        if (validateNew(AddMyDrugsBtn))
            return new GetStartedPage(driver);
        return null;
    }

    /**
     * Validate Widgets From copy deck: Preferred Retail Pharmacy Network Only
     * display the Preferred Retail Pharmacy Network tile for plans that have a
     * Preferred Retail Pharmacy benefit. Do not display for the AARP MedicareRx
     * Walgreens plan Walgreens ? Preferred Retail Pharmacy Only display the
     * Walgreens tile for AARP MedicareRx Walgreens plan members Preferred Mail
     * Service Pharmacy Only display the Preferred Mail Service Pharmacy tile for
     * plans that have a Preferred Mail Service Pharmacy benefit. Do not display for
     * AL PEEHIP BYPASS KNOWN ISSUE -ticket INC12081940 - Walgreens widget on
     * doesn't show up for Chinese and Spanish page
     *
     * @param //planType
     * @throws InterruptedException
     */
    public void validatePharmacyWidgets(boolean expectPrefRetailPharmacyPlan, boolean expectWalgreensPlan,
                                        boolean expectPrefMailServPlan, HashMap<String, String> inputMap, String testSiteUrl)
            throws InterruptedException {
        String testPlanName = inputMap.get("planName");
        String language = inputMap.get("language");
        String testWidget = "";
        String expUrl = "";
        boolean hasWalgreensPlan = false;
        if (testPlanName.contains("AARP MedicareRx Walgreens"))
            hasWalgreensPlan = true;
        Assertion.assertTrue("PROBLEM - test input expects no walgreens plan but user has walgreens plan",
                expectWalgreensPlan == hasWalgreensPlan);

        testWidget = "Preferred Mail Service Pharmacy";
        if (expectPrefMailServPlan) {
            Assertion.assertTrue("PROBLEM - user should see '" + testWidget + "' widget",
                    pharmacyValidate(widget_preferredMailServicePharmacy));
            expUrl = "resources/mail-order-pharmacy.html";
            validateWidget("LearnMore", testWidget, widget_prefMailServPhar_learnMore, expUrl, inputMap, testSiteUrl);
        } else {
            Assertion.assertTrue("PROBLEM - user should see '" + testWidget + "' widget",
                    pharmacyValidate(widget_preferredMailServicePharmacy));
        }

        testWidget = "Preferred Retail Pharmacy Network";
        if (expectPrefRetailPharmacyPlan) { // note: with this plan should see widget BUT if plan is walgreen then won't
            if (hasWalgreensPlan) {
                Assertion.assertTrue("PROBLEM - PDP user has Walgreens plan should not see '" + testWidget + "' widget",
                        !pharmacyValidate(widget_preferredRetailPharmacyNetwork));
            } else {
                Assertion.assertTrue("PROBLEM - PDP user should see '" + testWidget + "' widget",
                        pharmacyValidate(widget_preferredRetailPharmacyNetwork));
                Assertion.assertTrue("PROBLEM - PDP user should not see 'Walgreens - Preferred Retail Pharmacy' widget",
                        !pharmacyValidate(widget_walgreens));
                expUrl = "health-plans/estimate-drug-costs.html";
//				expUrl = "health-plans/estimate-drug-costs.html#/getstarted";
                validateWidget("DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts, expUrl, inputMap, testSiteUrl);
            }
        } else {
            Assertion.assertTrue("PROBLEM - user input does not expect to see '" + testWidget + "' widget",
                    !pharmacyValidate(widget_preferredRetailPharmacyNetwork));
        }
        testWidget = "Walgreens - Preferred Retail Pharmacy";
        if (expectWalgreensPlan) {
            if (hasWalgreensPlan) {
                if (language.equalsIgnoreCase("English")) {
                    Assertion.assertTrue("PROBLEM - user has Walgreens plan should see '" + testWidget + "' widget",
                            pharmacyValidate(widget_walgreens));
//					expUrl = "health-plans/estimate-drug-costs.html#/getstarted";
                    expUrl = "health-plans/estimate-drug-costs.html";
                    validateWidget("DCE", testWidget, widget_walgreens_estYurDrugCosts, expUrl, inputMap, testSiteUrl);
                } else {
                    System.out.println(
                            "INC12081940 - bypassed the Walgreens widget issue for Spanish and Chinese for the time being");
                }
            }
        } else {
            Assertion.assertTrue("PROBLEM - test input not expect to see '" + testWidget + "' widget",
                    !pharmacyValidate(widget_walgreens));
        }
    }

    @FindBy(xpath = "//span[text()='Servicio de salud ind�gena, tribal o ind�gena urbano']")
    protected WebElement indian_tribal_label_filter_text;

    public boolean validateNoPharmaciesErrorMessage() {
        jsClickNew(Filter);
        String indian_tribal_text = "";
        try {
            indian_tribal_text = indian_tribal_label_filter_text.getText();
        } catch (Exception ex) {
        }
        if (indian_tribal_text.equalsIgnoreCase("Servicio de salud ind�gena, tribal o ind�gena urbano")) {
            indian_tribal_label_filter = driver.findElement(By.xpath("//span[text()='Servicio de salud ind�gena, tribal o ind�gena urbano']/.."));
        }

        CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter, 60);
        jsClickNew(indian_tribal_label_filter);
        jsClickNew(FilterApplyBtn);
        sleepBySec(10);
        CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 60);
        if (!noPharmaciesErrorMessage.isDisplayed()) {
            CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter, 60);
            jsClickNew(indian_tribal_label_filter);
        }
        sleepBySec(5);
        CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 60);
        Assertion.assertTrue("PROBLEM - unable to locate No Pharmacy Error message",
                pharmacyValidate(noPharmaciesErrorMessage));
        return true;
    }

    public void validateQuestionsWidget() {
        CommonUtility.waitForPageLoad(driver, callUnitedHealthCareText, 5);
        Assertion.assertTrue("PROBLEM -Question Widget is not displayed", pharmacyValidate(questionsRightRailWidget));
        Assertion.assertTrue("PROBLEM -Call us icon is not displayed", pharmacyValidate(callUsIcon));
        Assertion.assertTrue("PROBLEM -Call United Health care is not displayed",
                pharmacyValidate(callUnitedHealthCareText));
    }

    public void validateWidget(String linkType, String widgetName, WebElement learnMoreElement, String expUrl,
                               HashMap<String, String> inputMap, String testSiteUrl) throws InterruptedException {
        String planName = inputMap.get("planName");
        String planYear = inputMap.get("planYear");
        String zipcode = inputMap.get("zipcode");
        String distance = inputMap.get("distance");
        String county = inputMap.get("county");
        Assertion.assertTrue("PROBLEM - '" + linkType + "' link should show for '" + widgetName + "' widget",
                pharmacyValidate(learnMoreElement));
        CommonUtility.waitForPageLoadNewForClick(driver, learnMoreElement, 60);
//		learnMoreElement.click();
        //jsClickNew(learnMoreElement);
        sleepBySec(12);
        pageloadcomplete();
        CommonUtility.checkPageIsReady(driver);
        String actUrl = driver.getCurrentUrl();
//		Assertion.assertTrue(
//				"PROBLEM - '" + linkType + "' link on '" + widgetName + "' widget is not opening expected page.  "
//						+ "Expected url contains '" + expUrl + "' Actual URL='" + actUrl + "'",
//				actUrl.contains(expUrl));
//		driver.navigate().back(); //note: use driver back to go back to pharmacy locator page
        //tbd Thread.sleep(2000); //note: keep for timing issue
        //driver.navigate().refresh(); //note: added refresh since Safari has issues locating elements after navigate back
        sleepBySec(2);
        CommonUtility.checkPageIsReady(driver);
        expUrl = "health-plans/aarp-pharmacy.html";
        actUrl = driver.getCurrentUrl();
        Assertion.assertTrue(
                "PROBLEM - Unable to get back to pharmacy locator page for further validation. "
                        + "Expected url contains '" + expUrl + "' Actual URL='" + actUrl + "'",
                actUrl.contains(expUrl));
        enterZipDistanceDetails(zipcode, distance, county);
//		if (isPlanYear()) {
//			selectsPlanYear(planYear);
//		}
        selectsPlanName(planName, testSiteUrl);
        CommonUtility.checkPageIsReady(driver);
    }

    /**
     * Verify page load in chinese language
     */
    public PharmacySearchPageNew clickChinese() {
        CommonUtility.checkPageIsReady(driver);
        CommonUtility.waitForPageLoad(driver, chineseLanguage, 5);
        chineseLanguage.click();
        CommonUtility.checkPageIsReady(driver);
        System.out.println("Chinese language selected");
        return new PharmacySearchPageNew(driver);
    }

    public void validateLanguageChanges(String language) {
        CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 15);
        if (("English").equalsIgnoreCase(language)) {
            Assertion.assertTrue("PROBLEM - page should be in English after selecting English",
                    pharmacyValidate(pgInEnglish));
        } else if (("Chinese").equalsIgnoreCase(language)) {
            Assertion.assertTrue("PROBLEM - page should be in Chinese after selecting Chinese",
                    pharmacyValidate(pgInEnglish));
        } else if (("Spanish").equalsIgnoreCase(language)) {
            Assertion.assertTrue("PROBLEM - page should be in Spanish after selecting Spanish",
                    pharmacyValidate(pgInEnglish));
        } else {
            Assertion.assertTrue("PROBLEM - language '" + language + "' is not supported, check test input", false);
        }
    }

    public int getPharmacyCnt() {
        pageloadcomplete();
        String PharmacyCountText = PharmacyFoundCount.getText();
        String[] Text = PharmacyCountText.split("Matching");
        PharmacyCount = Integer.parseInt(Text[0].trim());
        System.out.println("Displayed Pharmacy Count - " + PharmacyCount);
        return PharmacyCount;
    }

    /**
     * Changing of pharmacyType filter
     */
    public void validatePlanTypeFilter(String pharmacyType, String language) {
        //CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
        int totalBefore = getPharmacyCnt();
        System.out.println("Pharmacy Count Displayed : " + totalBefore);
        String labelId = "";
        validateNew(Filter);
        jsClickNew(Filter);
        validateNew(FilterApplyBtn);
        if (pharmacyType.equalsIgnoreCase("E-Prescribing")) {
            labelId = "(//div[@id='filtercontainer']//label)[7]";
        } else if (pharmacyType.equalsIgnoreCase("Home Infusion and Specialty")) {
            labelId = "(//div[@id='filtercontainer']//label)[3]";
        } else if (pharmacyType.equalsIgnoreCase("Indian/Tribal/Urban")) {
            labelId = "(//div[@id='filtercontainer']//label)[4]";
        } else if (pharmacyType.equalsIgnoreCase("Long-term care")) {
            labelId = "(//div[@id='filtercontainer']//label)[5]";
        } else if (pharmacyType.equalsIgnoreCase("Mail Order Pharmacy")) {
            labelId = "(//div[@id='filtercontainer']//label)[9]";
        } else if (pharmacyType.equalsIgnoreCase("Open 24 hours")) {
            labelId = "(//div[@id='filtercontainer']//label)[8]";
        } else if (pharmacyType.equalsIgnoreCase("Retail Pharmacy")) {
            labelId = "(//div[@id='filtercontainer']//label)[6]";
        } else {
            Assertion.assertTrue("PROBLEM - haven't code to handle filter '" + pharmacyType + "' yet", false);
        }
//		WebElement label = driver.findElement(By.xpath("//label[@id='" + labelId + "']"));
        WebElement label = driver.findElement(By.xpath(labelId));

        validateNew(label);
        jsClickNew(label);

        validateNew(FilterApplyBtn);
        jsClickNew(FilterApplyBtn);
        pageloadcomplete();
//		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
        CommonUtility.checkPageIsReady(driver);
        CommonUtility.waitForPageLoad(driver, pagination, 10);
        int PharmacyCount = 0;
        if (!pharmacyValidate(noResultMsg))
            PharmacyCount = PharmacyResultList.size();
        if (PharmacyCount > 0) {

            int totalAfter = getPharmacyCnt();
            Assertion.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
                    + "Expect='" + totalBefore + "' | Actual='" + totalAfter + "'", totalBefore >= totalAfter);
            Assertion.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element",
                    pharmacyValidate(pharmaciesAvailable));
            if (totalAfter > 10) {
                WebElement contactUsLink = contactUnitedHealthCare;
                if (!pharmacyValidate(contactUnitedHealthCare))
                    contactUsLink = contactUnitedHealthCare_ol;
                scrollToView(contactUsLink);

//				moveMouseToElement(contactUsLink);
                jsMouseOver(contactUsLink);

                sleepBySec(3);
                Assertion.assertTrue("PROBLEM - unable to locate the pagination element", pharmacyValidate(pagination));
                sleepBySec(3);
                Assertion.assertTrue("PROBLEM - unable to locate the left arrow element", pharmacyValidate(leftArrow));
                sleepBySec(3);
                Assertion.assertTrue("PROBLEM - unable to locate the right arrow element", pharmacyValidate(rightArrow));
                try {
                    sleepBySec(2);
                    CommonUtility.waitForPageLoadNewForClick(driver, rightArrow, 60);
//					rightArrow.click();
                    jsClickNew(rightArrow);
                    CommonUtility.checkPageIsReady(driver);
                    CommonUtility.waitForPageLoadNewForClick(driver, leftArrow, 60);
//					leftArrow.click();
                    jsClickNew(leftArrow);
                    sleepBySec(5);
                    CommonUtility.checkPageIsReady(driver);
                } catch (Exception e) {
                    Assertion.assertTrue("PROBLEM - something wrong with the arrow", false);
                }
                sleepBySec(8);
                if (language.equalsIgnoreCase("English")) {
//					String expTxt1 = "Change the range of your search - increase the miles for more results, decrease the miles for fewer results.";
//					String expTxt2 = "Change the pharmacy type you selected.";
//					String actualTxtXpath1 = "//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[1]";
//					String actualTxt1 = driver.findElement(By.xpath(actualTxtXpath1)).getText();
//					String actualTxtXpath2 = "//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[2]";
//					String actualTxt2 = driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
//					Assertion.assertTrue(
//							"PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
//									+ "Expected='" + expTxt1 + "' | " + "Actual-'" + actualTxt1 + "'",
//							expTxt1.equals(actualTxt1));
//					Assertion.assertTrue(
//							"PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
//									+ "Expected='" + expTxt2 + "' | " + "Actual-'" + actualTxt2 + "'",
//							expTxt2.equals(actualTxt2));
                }
//				scrollToView(moveAwayFromTooltip);
//				moveMouseToElement(moveAwayFromTooltip); //note: move away from tooltip for it to disappear

            } else {
                Assertion.assertTrue("PROBLEM - total < 10, should not find the pagination element",
                        !pharmacyValidate(pagination));
                Assertion.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
                        !pharmacyValidate(leftArrow));
                Assertion.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
                        !pharmacyValidate(rightArrow));
            }
        }
    }

    @FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(),'Return')]")
    public WebElement returntoPharmacySearch;


    public void clickReturnToPharamcySearch() {
        validateNew(returntoPharmacySearch);
        returntoPharmacySearch.click();
        waitForPageLoadSafari();
    }

    public void clickResetFilter() {
        //breadCrumbLink.click();
        jsClickNew(resetfilterlink);
        waitForPageLoadSafari();
        validateNew(pharmacyList);
    }

    @FindBy(xpath = "//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]")
    private WebElement samChatIcon;

    public void validateSamChatIcon() throws InterruptedException {
        boolean present;
        try {
            threadsleep(10);
            FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(35))
                    .pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
                    .ignoring(TimeoutException.class);
            fwait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver
                            .findElement(By.xpath("//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]"));
                }
            });
            validateNew(samChatIcon);
            present = true;
        } catch (Exception e) {
            present = false;
            if (driver.getCurrentUrl().contains("welcome"))
                ;
            driver.navigate().refresh();
            present = validateNew(samChatIcon);
        }
        if (present) {
            System.out.println("@@@@@@@@@ Able to see Chat Icon @@@@@@@@@");

        } else
            System.out.println("@@@@@@@@@ Chat Icon not available @@@@@@@@@");

    }

    @FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
    private WebElement CallSamTFN;

    @FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'timezone')]")
    private WebElement CallSamTFNtimezone;

    @FindBy(xpath = "//div[@id='sam-call-modal']//p[contains(text(),'Already a member')]")
    private WebElement CallSamTFNMember;

    @FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
    private WebElement CallSamTFNClose;

    public void validateCallpopuponapage(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {
        // driver.navigate().refresh();
        CommonUtility.checkPageIsReady(driver);
        threadsleep(3);
        WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
        validateNew(ActualTFNelement);
        validate(ActualTFNelement);
        String ActualCallSAMTFN = ActualTFNelement.getText();
        System.out.println("TFN No displayed on the Page" + ActualCallSAMTFN);
        jsClickNew(ActualTFNelement);
        System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
        driver.switchTo().activeElement();
        validate(CallSamTFN);
        String ExpectedCallSAMTFN = CallSamTFN.getText();
        System.out.println("TFN No displayed on the Page" + ExpectedCallSAMTFN);
		/*if (ExpectedCallSAMTFN.contains(ActualCallSAMTFN)) {
			System.out
					.println("****************TFN number was  found macthing with the SAM call Popup  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("*****************TFN number was  not found macthing with the SAM call Popup ***************"
					+ ExpectedCallSAMTFN);
		}*/
        String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. ï¿½ 8 p.m., 7 days a week.*\n*Alaska and Hawaii: 8 a.m. ï¿½ 8 p.m. Monday ï¿½ Friday, 8 a.m. ï¿½ 5 p.m. Saturday and Sunday.";
        validate(CallSamTFNtimezone);
        String ActualCallSamTFNtimezone = CallSamTFNtimezone.getText();
        System.out.println(ExpectedCallSamTFNtimezone);
        System.out.println(ActualCallSamTFNtimezone);
        if (ExpectedCallSamTFNtimezone.replace(" ", "").replace("\n", "")
                .equalsIgnoreCase(ActualCallSamTFNtimezone.replace(" ", "").replace("\n", ""))) {
            System.out.println(
                    "****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");

        } else {
            System.out.println(
                    "****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");
        }
        String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
        // ActualCallSamTFNMember.replace("", " ");
        // WebElement strCallSamTFNMember=
        // driver.findElement(By.xpath("//p[contains(text(),'Already a member?')]"));
        validate(CallSamTFNMember);
        String ActualCallSamTFNMember = CallSamTFNMember.getText();
        System.out.println(ExpectedCallSamTFNMember);
        if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
            System.out.println(
                    "****************TFN Member Content was  found macthing with the SAM call Popup  ***************");
            Assertion.assertTrue(true);
        } else {
            Assertion.fail(
                    "*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
                            + ActualCallSamTFNMember);
        }
        validate(CallSamTFNClose);
        jsClickNew(CallSamTFNClose);

    }


    String sheetName = "";
    int rowIndex;

    public HashMap<String, String> collectInfoPharmacyPage(String planName, String zipcode, String countyName, String planYear, String sheetName, int rowIndex) {
        HashMap<String, String> result = null;
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Input : " + zipcode + "; " + countyName + "; " + planName);
                zipcodeField.clear();

                zipcodeField.sendKeys(zipcode);

                selectFromDropDownByText(driver, distanceDropownID, "25 Miles");
                sleepBySec(3);
                jsClickNew(countyDrpDwn);
                sleepBySec(1);
                if(!zipcode.equalsIgnoreCase("70821")){
                    countyName = countyName + " County";
                }
                selectFromDropDownByText(driver, countyDrpDwn, countyName);
                sleepBySec(3);

                jsClickNew(seletPlandropdown);
                sleepBySec(1);
                selectFromDropDownByText(driver, seletPlandropdown, planName);
                sleepBySec(2);
                jsClickNew(searchbtn);

                sleepBySec(5);

                this.sheetName = sheetName;
                this.rowIndex = rowIndex;

                result = new HashMap<String, String>();
                String key = "";
                String value = "";

                key = "Days supply";
                value = getDaysSupply();
                result.put(key, value);

                key = "WalgreensWidget";
                value = (validate(widget_walgreens)) ? "YES" : "NO";
                result.put(key, value);

                key = "PreferredWidget";
                value = (validate(widget_preferredRetailPharmacyNetwork)) ? "YES" : "NO";
                result.put(key, value);

                key = "PreferredMail";
                value = (validate(widget_preferredMailServicePharmacy)) ? "YES" : "NO";
                result.put(key, value);

                key = "PreferredRetail";
                value = getPreferredPlan();
                result.put(key, value);
            }
            catch (Exception ex){
                driver.navigate().refresh();
                System.out.println(sheetName + "_" + rowIndex + " - Attempt - " + (i + 1) + ", Page Refreshed after Exception");
                continue;
            }
        }
        return result;
    }

    private String getPreferredPlan() {
        String PreferredRetail = "";
        jsClickNew(Filter);
        WebElement PreferredPharmacyFilter = driver.findElement(By.xpath("//div[@id='filtercontainer']//fieldset//*[contains(text(), 'Preferred Network')]"));
        PreferredRetail = (validate(PreferredPharmacyFilter))? "YES":"NO";
        jsClickNew(Filter);
        sleepBySec(2);
        System.out.println("Preferred Retails Pharmacy Type Filter is displayed YES/NO - "+PreferredRetail);
        WebElement PreferredBalloon = driver.findElement(By.xpath("//img[contains(@class, 'pharmacypin')]//parent::p[contains(text(), 'Preferred Retail')]"));

        PreferredRetail = (PreferredRetail.equalsIgnoreCase("YES") && validate(PreferredBalloon))? "YES":"NO";
        System.out.println("Preferred Retail Balloon icon is Displayed YES/NO - "+PreferredRetail);
        return PreferredRetail;

    }

    private String getDaysSupply() {
        String DaySupply = "";
        jsClickNew(Filter);
        WebElement RetailPharmacyFilter = driver.findElement(By.xpath("(//div[@id='filtercontainer']//label)[6]"));
        String filterdaysupply = RetailPharmacyFilter.getText().trim();

        jsClickNew(Filter);
        WebElement ResultsDaysSupplyDisplayed = driver.findElement(By.xpath("(//div[@class='mt-10']//*[contains(@class,'row')]//*[contains(@class,'list-item')]//li[contains(text(), 'Retail Pharmacy (')])[1]"));
        String Resultsdaysupply = ResultsDaysSupplyDisplayed.getText().trim();
        if (filterdaysupply.contentEquals(Resultsdaysupply)) {
            filterdaysupply = Resultsdaysupply.split("\\(")[1].split("\\)")[0];
            DaySupply = filterdaysupply;
            System.out.println("Days Supply match for Filter and results : "+DaySupply);
        } else {
            DaySupply = "Filter : "+filterdaysupply+"; and results : "+Resultsdaysupply+" days supply don't match";
            System.out.println("Days Supply text does not match Filter and Results : "+DaySupply);
        }

        return DaySupply;
    }


    public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
        boolean flag = true;
        int counter = 0;
        String tmpUIString1 = "", tmpUIString2 = "", benefitValueUI = "", headerPremiumString = "";
        HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
        headerPremiumString = benefitsMap.get("header premium"); //gets the value for the header premium that was stored from the UI
        benefitValue = benefitValue.replaceAll("\\s+", "");
        if (headerPremiumString != null) //the header monthly premium value is not there for PDP plans so in case of PDP plans this value will be null
            headerPremiumString = headerPremiumString.replace("\n", "").replaceAll("\\s+", ""); //removing spaces and next lines if any

        for (String key : benefitsMap.keySet()) {
            benefitValueUI = benefitsMap.get(key).replaceAll("\\s+", "");

            tmpUIString1 = benefitValueUI;
            key = key.toLowerCase().trim();
            //key = key.replace(",", "");
            columnName = columnName.toLowerCase().trim();
            if (key.contains("%"))
                key = key.replaceAll("\\s+", "");
            if (columnName.contains("%"))
                columnName = columnName.replaceAll("\\s+", "");
            if ((benefitValue.contains("NA") || benefitValue.contains("N/A"))) {
                counter++;
                 if (key.equalsIgnoreCase(columnName)) {
                    flag = false;
                    tmpUIString2 = tmpUIString1;
                    break;
                }


            }else if (key.contains(columnName)) {

                counter++;
                benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "");
                benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", "");

                //the following code is used to remove the footnote values from the benefit value string.

                benefitValue = benefitValue.trim();
                benefitValueUI = benefitValueUI.trim();

                if (benefitValueUI.contains(benefitValue) || benefitValueUI.equalsIgnoreCase(benefitValue)) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                    System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:3 " + columnName + " Excel: " + benefitValue + " | UI: " + benefitValueUI);
                    tmpUIString2 = tmpUIString1;
                    break;
                }

            } else if (columnName.contains(key)) {
                counter++;
                benefitValueUI = benefitValueUI.replaceAll("\\s+", "");
                benefitValue = benefitValue.replaceAll("\\s+", "");
                if (benefitValueUI.equalsIgnoreCase(benefitValue)) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                    System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:4 " + columnName + " Excel: " + benefitValue + " | UI: " + benefitValueUI);
                    tmpUIString2 = tmpUIString1;
                    break;
                }

            }
        }

        if (counter == 0) {
            flag = false;
            System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:5 " + columnName + " Excel: " + benefitValue + " | UI: BENEFIT NOT FOUND");
            tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
        }

        comparedResult.put(flag, tmpUIString2);
        return comparedResult;

    }
}
