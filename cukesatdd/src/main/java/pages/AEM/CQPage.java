/**
 *
 */
package pages.AEM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import org.testng.Assert;


/**
 * @author saduri
 *
 */
public class CQPage extends UhcDriver {


    //@FindBy(id="globalnav-start-home-collection")
    @FindBy(xpath = "//coral-shell-homeanchor-label[contains(text(),'Adobe Experience Manager')]")
    private WebElement globalNavHome;

    @FindBy(xpath = ".//*[contains(@id,'ole-common-form')]")
    private WebElement oleForm;

    @FindBy(xpath = ".//*[contains(@id,'ole-cancel-confirm')]")
    private WebElement cancelForm;

    @FindBy(xpath = ".//*[contains(@class,'tooltipParsys parsys cq-element-tooltipParsys')]")
    private WebElement oleToolTips;

    @FindBy(xpath = "//*[contains(text(),'Please Provide Your Medicare Insurance Info')]")
    private WebElement masterListPage;

    @FindBy(xpath = "//*[contains(@class,'vpp base_common_tools')]")
    private WebElement vppContent;

    @FindBy(xpath = "//*[contains(@ng-app,'commontoolsAngularApp')]")
    private WebElement cnsPlansContent;

    @FindBy(xpath = "//*[contains(@class,'tooltipConfiguration')]")
    private WebElement vppToolTip;

    @FindBy(xpath = "//header[contains(@class,'header fixed')]")
    private WebElement acqHeader;

    @FindBy(xpath = "//*[contains(@class,'globalFooter')]//footer")
    private WebElement acqFooter;

    @FindBy(xpath = "//*[contains(@id,'globalContentIdForSkipLink')]")
    private WebElement acqPageBodyContent;

    @FindBy(xpath = "//*[contains(@class,'header preauth')]")
    private WebElement memberHeaderPreSignIn;

    @FindBy(xpath = "//*[contains(@class,'footer')]//footer")
    private WebElement memberFooterPreSignIn;

    @FindBy(xpath = "//*[contains(@data-ng-controller,'uhcMnRCustomSegmentationCtl')]")
    private WebElement memberBodyContentPreSignIn;

    @FindBy(xpath = "//header[contains(@class,'navbar')]")
    private WebElement memberHeader;

    @FindBy(xpath = "//*[contains(@class,'footerParsys iparsys parsys')]//*[contains(@class,'iparys_inherited')]")
    private WebElement memberFooter;

    @FindBy(xpath = "//*[contains(@id,'globalContentIdForSkipLink')]")
    private WebElement memberBodyContent;

    @FindBy(xpath = "//coral-tab-label[contains(text(),'Static Pages')]")
    private WebElement tab_static;

    @FindBy(xpath = "//input[contains(@is,'coral-textfield') and contains(@role,'combobox')]")
    private WebElement pathInputField;

    @FindBy(xpath = "//coral-select[@id='activeElementType']")
    private WebElement activeElementDropdown;


    @FindBy(xpath = "//coral-select[@id='activeElementType']//coral-selectlist-item[contains(@role,'option')]")
    List<WebElement> activeElementsOptions;

    @FindBy(xpath = "//button[@id='showUsage']")
    private WebElement btnShowUsage;

    @FindBy(xpath = "//div[@id='result']")
    private WebElement result;

    @FindBy(xpath = "//div[contains(@id,'esult')]//table//tbody//tr")
    private List<WebElement> resultList;

    @FindBy(xpath = "//coral-tab-label[contains(text(),'Dynamic Apps')]")
    private WebElement tab_Dynamic;

    @FindBy(xpath = "//coral-select[@id='dynamic_app']")
    private WebElement selectAppDropdown;

    @FindBy(xpath = "//coral-select[@id='dynamic_app']//coral-selectlist-item[contains(@role,'option')]")
    private List<WebElement> selectAppOptions;

    //@FindBy(xpath="//coral-select[@id='dynamic_app_views']")
    @FindBy(xpath = "//*[contains(@class,'dynamic_app_view')]")
    private WebElement selectViewDropDown;

    @FindBy(xpath = "//coral-select[@id='dynamic_app_views']//coral-selectlist-item[contains(@role,'option')]")
    private List<WebElement> selectViewOptions;

    //@FindBy(xpath="//coral-select[@id='dynamic_app_subviews']")
    @FindBy(xpath = "//*[contains(@class,'dynamic_app_subview')]")
    private WebElement selectSubViewDropDown;

    @FindBy(xpath = "//coral-select[@id='dynamic_app_subviews']//coral-selectlist-item[contains(@role,'option')]")
    private List<WebElement> selectSubViewOptions;

    @FindBy(xpath = "//div[contains(@id,'esult')]//table//tbody//tr//td//button")
    private List<WebElement> editButtons;


    @FindBy(xpath = "//div[@id='myModal']")
    WebElement editAssetModalPopUp;

    @FindBy(xpath = "//div[contains(@class,'Modal-header')]")
    WebElement modalHeader;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxAnalytics;

    @FindBy(xpath = "//label[contains(text(),'Asset Name')]")
    WebElement assetName;

    @FindBy(xpath = "//input[@id='dl-asset-name']")
    WebElement inputAssetName;

    @FindBy(xpath = "//label[@id='label-aligned-inputgroup-other-keys']")
    WebElement otherKeyValuePairs;

    @FindBy(xpath = "//textarea[@id='dl-other-keys']")
    WebElement inputOtherKeyValuePairs;

    @FindBy(xpath = "//button[@id='closeModal']")
    WebElement btnClose;

    @FindBy(xpath = "//button[@id='saveData']")
    WebElement btnSavePublish;


    public CQPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        validateNew(globalNavHome);
    }

    public void validatePage() {


    }

    public void validateOLEPages() {

        //AARP pages
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/welcome.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/oleReviewSubmission.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/oleSubmitConfirmation.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/modalpopup.html");
        validateNew(cancelForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/ole-tooltip-library.html");
        validateNew(oleToolTips);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/masterlistquestions.html");
        validateNew(masterListPage);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/questionlayout.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/ole-righrail.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/medicareInsuranceInformation.html");
        validateNew(oleForm);

        //UHC pages
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/welcome.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/oleReviewSubmission.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/oleSubmitConfirmation.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/modalpopup.html");
        validateNew(cancelForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/ole-tooltip-library.html");
        validateNew(oleToolTips);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/masterlistquestions.html");
        validateNew(masterListPage);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/questionlayout.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/ole-righrail.html");
        validateNew(oleForm);
        driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/medicareInsuranceInformation.html");
        validateNew(oleForm);


    }

    public void validateVPPPages() {

        //AARP pages
        driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=summary");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=detail#/zipcode");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=portfolio");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=compare");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/mapdmarketing.html");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/planmarketing.html");
        validateNew(vppContent);

        driver.get("http://apvrt73396:8080/content/commontools/vpp/tool-tip-configuration.html");
        validateNew(vppToolTip);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/CnSPlans.html");
        validateNew(cnsPlansContent);

        //UHC pages
        driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=summary");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=detail#/zipcode");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=portfolio");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=compare");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/mapdmarketing.html");
        validateNew(vppContent);
        driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/planmarketing.html");
        validateNew(vppContent);

    }

    public void validateAcqPages() {

        //home page
        driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en.html");
        validateAcqContent();

        //shop for a plan pages
        driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/health-plans/shop/medicare-advantage-plans.html");
        validateAcqContent();

        driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/health-plans/shop/prescription-drug-plans.html");
        validateAcqContent();

        //Understanding medicare pages
        driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/medicare-education/medicare-eligibility.html");
        validateAcqContent();

        driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/medicare-education/medicare-costs.html");
        validateAcqContent();

        //footer links pages
        driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/contact-us.html");
        validateAcqContent();

        driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/terms-of-use.html");
        validateAcqContent();

    }

    public void validateAcqContent() {
        if (!validate(acqHeader))
            Assertion.fail("header not found on this page: " + driver.getCurrentUrl());
        if (!validate(acqFooter))
            Assertion.fail("footer not found on this page: " + driver.getCurrentUrl());
        if (!validate(acqPageBodyContent))
            Assertion.fail("page content not found on this page: " + driver.getCurrentUrl());
    }

    public void validateMemberPages() {

        //login page
        driver.get("http://apvrt73396:8080/content/medicare/login.html");
        validateMemberPreSingInContent();

        //secondary pages
        driver.get("http://apvrt73396:8080/content/medicare/member/order-materials.html");
        validateMemberContent();
        driver.get("http://apvrt73396:8080/content/medicare/member/benefits.html");
        validateMemberContent();
        driver.get("http://apvrt73396:8080/content/medicare/member/payments.html");
        validateMemberContent();
        driver.get("http://apvrt73396:8080/content/medicare/member/claims.html");
        validateMemberContent();
        driver.get("http://apvrt73396:8080/content/medicare/member/health-and-wellness.html");
        validateMemberContent();
        driver.get("http://apvrt73396:8080/content/medicare/member/eob.html");
        validateMemberContent();

    }

    private void validateMemberContent() {
        if (!validate(memberHeader))
            Assertion.fail("header not found on this page: " + driver.getCurrentUrl());
        if (!validate(memberFooter))
            Assertion.fail("footer not found on this page: " + driver.getCurrentUrl());
        if (!validate(memberBodyContent))
            Assertion.fail("page content not found on this page: " + driver.getCurrentUrl());

    }

    private void validateMemberPreSingInContent() {
        // TODO Auto-generated method stub
        if (!validate(memberHeaderPreSignIn))
            Assertion.fail("header not found on this page: " + driver.getCurrentUrl());
        if (!validate(memberFooterPreSignIn))
            Assertion.fail("footer not found on this page: " + driver.getCurrentUrl());
        if (!validate(memberBodyContentPreSignIn))
            Assertion.fail("page content not found on this page: " + driver.getCurrentUrl());
    }

    public void navigateToDataLayerUrl() {
        String datalayerurl = "https://apvrd83493.uhc.com:8443/etc/analytics-tools/analytics-data-updater.html";
        driver.navigate().to(datalayerurl);
        CommonUtility.checkPageIsReadyNew(driver);
        WebElement dataLayerHead = driver.findElement(By.xpath("//h1[contains(text(),'Data Layer Utility')]"));

        if (validateNew(dataLayerHead) && dataLayerHead.isDisplayed()) {
            Assertion.assertTrue(true);
            System.out.println("Data Layer Page opened successfully.\nurl:" + driver.getCurrentUrl());
        } else {
            Assertion.fail("Data Layer Page not open successfully");
        }

    }

    public void validateDataLayerStaticTab(String Url) {
        CommonUtility.checkPageIsReadyNew(driver);
        jsClickNew(tab_static);
        if (validateNew(tab_static) && validateNew(pathInputField) && validateNew(activeElementDropdown) &&
                validateNew(btnShowUsage)) {
            System.out.println("All elements are present in Static tab");
        } else {
            Assertion.fail("All elements not present in Static Tab");
        }
        //To Enter Page Path in Input Text Feild
        sleepBySec(2);
        pathInputField.sendKeys(Url);
        pathInputField.sendKeys(Keys.TAB);
        System.out.println("Url Enter: " + Url);
        //TO CHECK ELEMENTS PRESENT IN ACTIVE ELEMENT DROPDOWN
        if (!activeElementsOptions.isEmpty()) {
            activeElementDropdown.click();
            String elementsPresent = "";
            for (int i = 0; i < activeElementsOptions.size(); i++) {
                elementsPresent += activeElementsOptions.get(i).getText() + ";";
            }
            if (elementsPresent.contains("Page") && elementsPresent.contains("Button") &&
                    elementsPresent.contains("Hyperlink") && elementsPresent.contains("Form")) {
                System.out.println(" All Active Elements present in DropDown");
            } else {
                Assertion.fail(" All Active Elements are not present in DropDown");
            }
            activeElementDropdown.click();
        }
        //To Select Forms in Active Element List
		/*WebElement selectActiveElement=activeElementsOptions.get(3);
		selectActiveElement.click();*/

        //To Check for Show Usage Button functionality
		/*btnShowUsage.click();
		System.out.println("Show Usage Button Clicked");
		sleepBySec(4);
		checkResult();*/

        for (WebElement e : activeElementsOptions) {
            activeElementDropdown.click();
            System.out.println(e.getText() + " from Active Element dropdown is selected");
            e.click();
            btnShowUsage.click();
            System.out.println("Show Usage Button Clicked");
            sleepBySec(4);
            checkResult();
            validateEditAssetModalPopUp();

        }
    }

    public void sleepBySec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // method to check Dynamic Tab Elements
    public void validateDataLayerDynamicTab() {
        CommonUtility.checkPageIsReadyNew(driver);
        jsClickNew(tab_Dynamic);
        if (validateNew(selectAppDropdown) && selectAppDropdown.isDisplayed()) {
            System.out.println("Dynamic App Tab Opened Successfully");
        } else {
            Assertion.fail("Dynamic App Tab did not Opened Successfully");
        }
        selectAppDropdown.click();
        if (!selectAppOptions.isEmpty()) {
            String presentApp = "";
            for (int i = 0; i < selectAppOptions.size(); i++) {
                presentApp += selectAppOptions.get(i).getText() + ", ";
            }
            System.out.println("Element Present in Select App DropDown: " + presentApp);
        } else {
            Assertion.fail("Elemnents not present in Dropdown");
        }
        selectAppDropdown.click();

        for (WebElement e : selectAppOptions) {
            if (!e.getAttribute("class").contains("disabled")) {
                selectAppDropdown.click();
                System.out.println(e.getText() + " from Select Application dropdown is selected");
                e.click();
                sleepBySec(2);
                if (selectViewDropDown.isDisplayed()) {
                    sleepBySec(1);
                    System.out.println("Select View Dropdown is visible");
                    for (WebElement x : selectViewOptions) {
                        selectViewDropDown.click();
                        System.out.println(x.getText() + " from View dropdown is selected");
                        x.click();
                        sleepBySec(2);
                        if (selectSubViewDropDown.isDisplayed()) {
                            sleepBySec(1);
                            System.out.println("Select Sub View Dropdown is visible");
                            for (WebElement sub : selectSubViewOptions) {
                                selectSubViewDropDown.click();
                                System.out.println(sub.getText() + " from Sub View dropdown is selected");
                                sub.click();
                                sleepBySec(3);
                                checkResult();
                                validateEditAssetModalPopUp();
                            }
                        } else {
                            System.out.println("Select Sub View Dropdown is not visible");
                            sleepBySec(3);
                            checkResult();
                            validateEditAssetModalPopUp();
                        }
                    }
					/*selectViewDropDown.click();
					selectViewOptions.get(1).click();*/

                } else {
                    System.out.println("Select View Dropdown is not visible");
                    checkResult();
                    validateEditAssetModalPopUp();
                }
            }
        }
/*		selectAppOptions.get(4).click();
		sleepBySec(2);
		if(selectViewDropDown.isDisplayed()) {
			System.out.println("Select View Dropdown is visible");
			selectViewDropDown.click();
			selectViewOptions.get(1).click();
			sleepBySec(2);
		}
		checkResult();*/
    }

    //Method to check what result is displayed
    public void checkResult() {
        if (!resultList.isEmpty()) {
            System.out.println("Number of Active Assets in List : " + resultList.size());
        } else {
            System.out.println("RESULT: " + result.getText());
            if (result.getText().isEmpty()) {
                Assertion.fail("Error in Displaying Result");
            } else if (result != null) {
                System.out.println("Result Message: " + result.getText());
            } else {
                Assertion.fail("Error in Displaying Result");
            }
        }
    }


    public void validateEditAssetModalPopUp() {
        CommonUtility.checkPageIsReadyNew(driver);
        int i = 1;
        for (WebElement edit : editButtons) {
            jsClickNew(edit);
            sleepBySec(2);
            if (editAssetModalPopUp.isDisplayed()) {
                System.out.println("Edit Asset Visible: " + i);
                validateNew(modalHeader);
                validateNew(checkboxAnalytics);
                validate(assetName);
                validateNew(inputAssetName);
                validateNew(otherKeyValuePairs);
                validateNew(inputOtherKeyValuePairs);
                validateNew(btnClose);
                validateNew(btnSavePublish);
                sleepBySec(2);
                System.out.println("All Elements present in Edit Asset Pop-Up " + i);
                jsClickNew(btnClose);
                i++;
                sleepBySec(1);
            }
        }
    }

    @FindBy(xpath = "//coral-tab[contains(@value,'header&footer')]")
    private WebElement tab_HeaderFooter;

    @FindBy(xpath = "//coral-select[@id='selectHeaderFooter']")
    private WebElement selectSectionDropDown;

    @FindBy(xpath = "//coral-selectlist[@id='coral-id-17']//coral-selectlist-item[contains(@role,'option')]")
    private List<WebElement> selectSectionOptions;

    @FindBy(xpath = "//coral-select[@id='selectHFResource']")
    private WebElement selectResourceDropDown;

    @FindBy(xpath = "//coral-selectlist[@id='coral-id-21']//coral-selectlist-item[contains(@role,'option')]")
    private List<WebElement> selectResourceOptions;

    @FindBy(xpath = "//coral-select[@id='HFActiveElementType']")
    private WebElement selectActiveElementDropDown;

    @FindBy(xpath = "//coral-selectlist[@id='coral-id-25']//coral-selectlist-item[contains(@role,'option')]")
    private List<WebElement> selectActiveElementOptions;

    @FindBy(xpath = "//button[@id='getHFAssets']")
    WebElement btnGetAsset;


    public void validateHeaderandFooterTab() {
        CommonUtility.checkPageIsReadyNew(driver);
        jsClickNew(tab_HeaderFooter);

        if (validateNew(selectSectionDropDown) && validateNew(selectResourceDropDown) && validateNew(selectActiveElementDropDown) && validateNew(btnGetAsset)) {
            System.out.println("Header and Footer tab opened.\nAll Elements present");
        } else {
            Assert.fail("Header and Footer tab did not opened.\nAll Elements present are not");
        }

//        selectSectionDropDown.click();

        for (WebElement e : selectSectionOptions) {
            if (!e.getAttribute("class").contains("disabled")) {
                selectSectionDropDown.click();
                System.out.println(e.getText() + " from Select Section dropdown is selected");
                e.click();
                sleepBySec(2);
                for (WebElement x : selectResourceOptions) {
                    selectResourceDropDown.click();
                    System.out.println(x.getText() + " from Resource dropdown is selected");
                    x.click();
                    sleepBySec(2);
                    for (WebElement sub : selectActiveElementOptions) {
                        selectActiveElementDropDown.click();
                        System.out.println(sub.getText() + " from Active Element dropdown is selected");
                        sub.click();
                        btnGetAsset.click();
                        System.out.println("Get Asset Button Clicked");
                        sleepBySec(3);
                        checkResult();
                        validateEditAssetModalPopUp();
                    }
                }
            }
        }
    }
}
