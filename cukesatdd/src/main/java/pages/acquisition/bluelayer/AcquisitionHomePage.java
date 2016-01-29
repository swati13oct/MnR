package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalFooterWebElements;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

public class AcquisitionHomePage extends GlobalFooterWebElements {

       @FindBy(linkText = "Look up ZIP code")
       private WebElement lookupZipcode;

       @FindBy(id = "zipcodevalue")
       private WebElement zipCodeField;

       @FindBy(className = "viewplansbtn")
       private WebElement viewPlansButton;

       @FindBy(id = "vpp_selectcounty_box")
       private WebElement countyModal;

       @FindBy(linkText = "prescriptions")
       private WebElement prescriptionsLink;

       @FindBy(id = "homefooter")
       private WebElement homefooter;

       @FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
       List<WebElement> countyRows;
       
       @FindBy(linkText = "View all disclaimer information")
       private WebElement disclaimerViewLink;
       
       @FindBy(className = "disclaimer hideLink")
       private WebElement disclaimerHideLink;
       
       private PageData homePageDisclaimer;
       public JSONObject homePageDisclaimerJson;
       
       private PageData homePageDisclaimerHide;
       public JSONObject homePageDisclaimerHideJson;
       
       

       
       private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;

       public AcquisitionHomePage(WebDriver driver) {
              super(driver);
              PageFactory.initElements(driver, this);
              openAndValidate();
       }
       
       private PageData globalFooter;

       public JSONObject globalFooterJson;
       
       

       public EstimateDrugCostPage switchToPrescriptionDrug() {
              prescriptionsLink.click();
              driver.getTitle();
              if (driver.getTitle().equalsIgnoreCase(
                           "Our Medicare Plan Types | UnitedHealthcare®")) {
                     return new EstimateDrugCostPage(driver);
              } else {
                     return null;
              }

       }

       public ZipcodeLookupPage looksupforZipcodes() {
              
              lookupZipcode.click();

              if (driver.getTitle().equalsIgnoreCase(
                           "Forbidden Page | UnitedHealthcare®")
                           || driver.getTitle().equalsIgnoreCase(
                                         "Our Medicare Plan Types | UnitedHealthcare®")) {
                     return new ZipcodeLookupPage(driver);
              }
              return null;

       }

       public JSONObject accessingGlobalFooter() {
              
              String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
              globalFooter = CommonUtility.readPageData(fileName,
                           CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
              
              JSONObject jsonObject = new JSONObject();
              for (String key : globalFooter.getExpectedData().keySet()) {
              WebElement element = findElement(globalFooter.getExpectedData()
              .get(key));
              if (element != null) {
              if(validate(element)){
              try {
              jsonObject.put(key, element.getText());
              } catch (JSONException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              }
              }
              }
              }
              globalFooterJson = jsonObject;
              
              
              return globalFooterJson;
              
       }
       
       public JSONObject accessViewAllDisclaimerInformation() {
              disclaimerViewLink.click();
              String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
              homePageDisclaimer = CommonUtility.readPageData(fileName,
                     CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
        
        JSONObject jsonObject = new JSONObject();
        for (String key : homePageDisclaimer.getExpectedData().keySet()) {
        WebElement element = findElement(homePageDisclaimer.getExpectedData()
        .get(key));
        if (element != null) {
        if(validate(element)){
        try {
        jsonObject.put(key, element.getText());
        } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        }
        }
        }
        homePageDisclaimerJson = jsonObject;
        
        
        return homePageDisclaimerJson;
       }
       
       public JSONObject accessViewAllDisclaimerHideInformation() {
              disclaimerHideLink.click();
              String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
              homePageDisclaimerHide = CommonUtility.readPageData(fileName,
                     CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
        
        JSONObject jsonObject = new JSONObject();
        for (String key : homePageDisclaimerHide.getExpectedData().keySet()) {
        WebElement element = findElement(homePageDisclaimerHide.getExpectedData()
        .get(key));
        if (element != null) {
        if(validate(element)){
        try {
        jsonObject.put(key, element.getText());
        } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        }
        }
        }
        homePageDisclaimerHideJson = jsonObject;
        
        
        return homePageDisclaimerHideJson;
       }
       
public SiteMapUMSPage siteMapFooterClick() {
       footerSiteMapLink.click();
       if(driver.getTitle().equalsIgnoreCase("Site Map | UnitedHealthcare®")){
              return new SiteMapUMSPage(driver);
       }
       return null;
              
       }
       
       

       @Override
       public void openAndValidate() {
              start(UMS_ACQISITION_PAGE_URL);
              validate(prescriptionsLink);
              validate(zipCodeField);
              validate(viewPlansButton);
              validate(footerHomeLink);
              
              //validate(footerHealthAndWellnessLink);
              validate(footerAboutUsLink);
              validate(footerContactUsLink);
              validate(footerSiteMapLink);
              validate(footerPrivacyPolicyLink);
              validate(footerTermsAndConditionsLink); 
              validate(footerDisclaimersLink);
              validate(footerAgentsAndBrokersLink);
              
       }

       public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
              sendkeys(zipCodeField, zipcode);
              viewPlansButton.click();
              try {
                     if (countyModal.isDisplayed()) {
                           for (WebElement county : countyRows) {
                                  if (county.getText().equalsIgnoreCase(countyName)) {
                                         county.click();
                                         break;
                                  }

                           }
                     }
              } catch (Exception e) {
                     System.out.println("county box not found");
              }
              if (driver
                           .getTitle()
                           .equalsIgnoreCase(
                                         "Our Medicare Plan Types | UnitedHealthcare®")) {
                     return new VPPPlanSummaryPage(driver);
              }
              return null;
       }

       public String selectsHomeFooter() {
              // TODO Auto-generated method stub
              return null;
       }
       
       public MedicareAdvantagePlansuhcPage medicareAdvantagePlansClick() {
              medicareAdvantagePlansLink.click();
              if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Plans | UnitedHealthcare®")){
              return new MedicareAdvantagePlansuhcPage(driver);
              }

              return null;
              }
       
       
       
       
       

}

