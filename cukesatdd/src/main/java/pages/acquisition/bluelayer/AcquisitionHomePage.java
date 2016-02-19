package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.ArrayList;
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
       
       @FindBy(id = "medicareTitle")
   	   private WebElement medicareTitleText;

		@FindBy(linkText = "pharmacy")
		private WebElement pharmacyLink;
       
       private PageData homePageDisclaimer;
       public JSONObject homePageDisclaimerJson;
       
       private PageData homePageDisclaimerHide;
       public JSONObject homePageDisclaimerHideJson;
       

       public JSONObject globalFooterJson;
       
       private PageData globalHeader;
       
       private PageData globalFooter;

       public JSONObject globalHeaderJson;
       
       private PageData alreadyPlanMember;
   	   public JSONObject alreadyPlanMemberJson;
       
       
       private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;

       public AcquisitionHomePage(WebDriver driver) {
              super(driver);
              PageFactory.initElements(driver, this);
              openAndValidate();
       }
       

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
       
       public JSONObject accessingGlobalHeader() {
           
           String fileName = CommonConstants.GLOBAL_HEADER_PAGE_DATA;
           globalHeader = CommonUtility.readPageData(fileName,
                        CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
           
           JSONObject jsonObject = new JSONObject();
           for (String key : globalHeader.getExpectedData().keySet()) {
           WebElement element = findElement(globalHeader.getExpectedData()
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
           globalHeaderJson = jsonObject;
           
           
           return globalHeaderJson;
           
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
		validate(footerSiteMapLink);
       footerSiteMapLink.click();
       validate(footerSiteMapLink);
       if(driver.getTitle().equalsIgnoreCase("Site Map | UnitedHealthcare®")){
              return new SiteMapUMSPage(driver);
       }
       return null;
              
       }
       
       

       @Override
       public void openAndValidate() {
              start(UMS_ACQISITION_PAGE_URL);
              validate(navigationSectionHomeLink);
              validate(navigationSectionOurPlansLink);
              validate(navigationSectionmedicareEducationLink);
              validate(navigationSectionEnterSearch);
              
              validate(prescriptionsLink);
              validate(zipCodeField);
              validate(viewPlansButton);
              validate(footerHomeLink);
              validate(footnotesContent);
              
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
    	    validate(medicareAdvantagePlansLink);
              medicareAdvantagePlansLink.click();
              validate(medicareAdvantagePlansLink);
              if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Plans | UnitedHealthcare®")){
              return new MedicareAdvantagePlansuhcPage(driver);
              }

              return null;
              }

	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validate(GlobalFooterWebElements.viewAllDisclaimerInformationLink);
		GlobalFooterWebElements.viewAllDisclaimerInformationLink.click();
		
		validate(GlobalFooterWebElements.disclaimerBackToTopLink);
		GlobalFooterWebElements.disclaimerBackToTopLink.click();
		
		validate(GlobalFooterWebElements.hideDiscliamerInformation);
		GlobalFooterWebElements.hideDiscliamerInformation.click();
		if(driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®")){
			return new AcquisitionHomePage(driver);
		}
		return null;
	}
	public DisclaimersPage importantDisclaimersClick() {
	    validate(importantDisclosuresLink);
	    importantDisclosuresLink.click();
          validate(importantDisclosuresLink);
          if(driver.getTitle().equalsIgnoreCase("Disclaimers | UnitedHealthcare®")){
          return new DisclaimersPage(driver);
          }
          return null;
          }
	
	public AcquisitionHomePage navigationSectionHomeLinkClick() {
	    validate(navigationSectionHomeLink);
	    navigationSectionHomeLink.click();
          validate(navigationSectionHomeLink);
          if(driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®")){
          return new AcquisitionHomePage(driver);
          }

          return null;
          }
	
	
	
	public Boolean navigationSectionEnterSearchClick() {
	    validate(navigationSectionEnterSearch);
	    navigationSectionEnterSearch.click();
	    navigationSectionEnterSearch.sendKeys("home");
	    String search = navigationSectionEnterSearch.getAttribute("value");
          if(search.equalsIgnoreCase("home")){
        	  return true;
          }

          return false;
          }
       
	public Boolean validate_alreadyPlanMemberButton_inactive() {

		return validate(alreadyPlanMemberButtonInactive);
	}

	public Boolean validate_alreadyPlanMemberButton_active() {
		validate(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();
		return validate(alreadyPlanMemberButtonActive);
		}
	
	public JSONObject getAlreadyPlanMemberJSON() {
		String fileName = CommonConstants.ALREADY_PLAN_MEMBER_PAGE_DATA;
		alreadyPlanMember = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : alreadyPlanMember.getExpectedData().keySet()) {
			WebElement element = findElement(alreadyPlanMember.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		alreadyPlanMemberJson = jsonObject;

		return alreadyPlanMemberJson;
	}

	public Boolean validate_textField() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1blayer");
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password");
		String pass = passwordField.getAttribute("value");
		if(user.equalsIgnoreCase("q1blayer") && pass.equalsIgnoreCase("Password")){
			return true;
		}
		return false;
	}

	public LoginAssistancePage forgotUsernamePasswordClick() {
		validate(forgotUsernameLink);
		forgotUsernameLink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    validate(medicareTitleText);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}
		return null;
	
	}
	
	public VPPPlanSummaryPage enterZipcode(String zipCode, String county, String planYear){
		sendkeys(zipCodeField, zipCode);		
		viewPlansButton.click();
		return new VPPPlanSummaryPage(driver);	
	}

	public RegistrationHomePage registerHereLinkClick() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	    validate(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();
	    validate(registerHereLink);
		registerHereLink.click();
		ArrayList<String> tabs1= new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs1.get(2));
	    validate(medicareTitleText);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Registration"))
		{
			return new RegistrationHomePage(driver);
		}
		return null;
	}     

	public PharmacySearchPage navigateToPharmacyLocator() {
		pharmacyLink.click();
		if(driver.getTitle().equalsIgnoreCase("Locate a Pharmacy | UnitedHealthcare®"))
		{
			return new PharmacySearchPage(driver); 
		}
		return null;
		
	} 

}

