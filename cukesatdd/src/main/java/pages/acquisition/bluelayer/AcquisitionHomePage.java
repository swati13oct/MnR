package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.member.bluelayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import pages.acquisition.bluelayer.ZipcodeLookupHomePage;

public class AcquisitionHomePage extends GlobalWebElements {

       @FindBy(id = "lookzip")
       private WebElement lookupZipcode;

       @FindBy(id = "cta-zipcode")
       private WebElement zipCodeField;

       @FindBy(id = "zipcodebtn")
       private WebElement viewPlansButton;

       @FindBy(id = "vpp_selectcounty_box")
       private WebElement countyModal;

       @FindBy(linkText = "Enter your drug list")
       private WebElement prescriptionsLink;

		@FindBys(value = {@FindBy(xpath = "//table[@id='colhowdoesthiswork']/tbody/tr/td/span/span/a") })
		private List<WebElement> howdoesthiswork;
      
       @FindBy(id = "learn-zipcode")
	   private WebElement learnzipCodeField;

		@FindBy(id = "learnfindplanBtn")
	    private WebElement learnfindPlansButton;       

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
       
       @FindBy(className = "fd_myPlans")
   		private WebElement myPlansTab;

		@FindBy(linkText = "pharmacy")
		private WebElement pharmacyLink;
       
       private PageData homePageDisclaimer;
       public JSONObject homePageDisclaimerJson;
       
       private PageData homePageDisclaimerHide;
       public JSONObject homePageDisclaimerHideJson;
       
       private PageData globalFooter;

       public JSONObject globalFooterJson;
       
       private PageData globalHeader;
       public JSONObject globalHeaderJson;
       
       private PageData alreadyPlanMember;
   	   public JSONObject alreadyPlanMemberJson;
   	   
	   	private PageData medicareEducationDropDown;
		public JSONObject medicareEducationDropDownJson;
		
		private PageData ourPlansNav;
		public JSONObject ourPlansNavJson;
       
       
       private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;

       public AcquisitionHomePage(WebDriver driver) {
              super(driver);
              PageFactory.initElements(driver, this);
              openAndValidate();
       }
       

       public EstimateDrugCostPage switchToPrescriptionDrug() {
                for (WebElement element : howdoesthiswork) {
				   			if(element.getText().equalsIgnoreCase("Enter your drug list")){
				   				element.click();
				   				break;
				   			}
				    	   }
              driver.getTitle();
              if (driver.getTitle().equalsIgnoreCase(
                           "Our Medicare Plan Types | UnitedHealthcare®")) {
                     return new EstimateDrugCostPage(driver);
              } else {
                     return null;
              }

       }

       public ZipcodeLookupHomePage looksupforZipcodes() {
              
              lookupZipcode.click();

              if (driver.getTitle().equalsIgnoreCase(
                           "Forbidden Page | UnitedHealthcare®")
                           || driver.getTitle().equalsIgnoreCase(
                                         "Our Medicare Plan Types | UnitedHealthcare®")) {
                     return new ZipcodeLookupHomePage(driver);
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
       
       public VPPPlanSummaryPage searchPlansForLearnFindPlans(String zipcode, String countyName) {
           sendkeys(learnzipCodeField, zipcode);
           learnfindPlansButton.click();
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
           if (getTitle()
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
		validate(GlobalWebElements.viewAllDisclaimerInformationLink);
		GlobalWebElements.viewAllDisclaimerInformationLink.click();
		
		validate(GlobalWebElements.disclaimerBackToTopLink);
		GlobalWebElements.disclaimerBackToTopLink.click();
		
		validate(GlobalWebElements.viewAllDisclaimerInformationLink);
		GlobalWebElements.viewAllDisclaimerInformationLink.click();
		
		validate(GlobalWebElements.hideDiscliamerInformation);
		GlobalWebElements.hideDiscliamerInformation.click();
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
	    /*validate(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();*/
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
      
	public JSONObject accessingOurPlansNav() {
		ourPlansHover();
		return getOurPlanDropDownJson();
	}
	
	public JSONObject getOurPlanDropDownJson(){
		String fileName = CommonConstants.OUR_PLANS_NAV_PAGE_DATA;
        ourPlansNav = CommonUtility.readPageData(fileName,
                     CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
        
        JSONObject jsonObject = new JSONObject();
        for (String key : ourPlansNav.getExpectedData().keySet()) {
        WebElement element = findElement(ourPlansNav.getExpectedData()
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
        ourPlansNavJson = jsonObject;
        
        
        return ourPlansNavJson;
	}
	
	


	public JSONObject accessMedicareEducationDropDown() {
		
		validate(navigationSectionMedicareEducationLink);
		
		Actions actions = new Actions(driver);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(learnAboutMedicareMedicareEducationLink);
        actions.perform();
		String fileName = CommonConstants.MEDICARE_EDUCATION_SECTION_DATA;
		medicareEducationDropDown = CommonUtility.readPageData(fileName,
			CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

	JSONObject jsonObject = new JSONObject();
	for (String key : medicareEducationDropDown.getExpectedData().keySet()) {
		WebElement element = findElement(medicareEducationDropDown.getExpectedData()
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
	medicareEducationDropDownJson = jsonObject;

	return medicareEducationDropDownJson;
	}

	
	
	public JSONObject enterZipCode(String zipCode) {
		ourPlansHover();
		validate(zipcodeField);
		zipcodeField.sendKeys(zipCode);
		findPlansButton.click();		
		return getOurPlanDropDownJson();
		
	}


	


	public LearnAboutMedicareuhcPage learnAboutMedicareClick() {
		validate(navigationSectionMedicareEducationLink);
		Actions actions = new Actions(driver);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(learnAboutMedicareMedicareEducationLink);
        actions.click().build().perform();
        if(driver.getTitle().equalsIgnoreCase("Learn About Medicare | UnitedHealthcare®")){
            return new LearnAboutMedicareuhcPage(driver);
            }

		return null;
	}	
	public MedicareAdvantagePlansuhcPage headerMedicareAdvantageClick() {
		ourPlansHover();
		validate(headerMedicareAdvantagePlansLink);
		headerMedicareAdvantagePlansLink.click();
        validate(headerMedicareAdvantagePlansLink);
        if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Plans | UnitedHealthcare®")){
        return new MedicareAdvantagePlansuhcPage(driver);
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
	public MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedPlansLinkClick() {
		ourPlansHover();
		validate(headerMedicareSpecialNeedPlansLink);
		headerMedicareSpecialNeedPlansLink.click();
		validate(headerMedicareSpecialNeedPlansLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans | UnitedHealthcare®")){
			return new MedicareSpecialNeedsPlansuhcPage(driver);
		}
		return null;
	}


	public OurPlansPage findPlanButtonClick(String zipCode) {
		ourPlansHover();
		validate(zipcodeField);
		zipcodeField.sendKeys(zipCode);
		findPlansButton.click();
		if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®")){
			return new OurPlansPage(driver);
		}
		return null;
	}


	public Boolean enterInvalidUserNamePassword() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("");
		//usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("pas");
		//passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if(user.equalsIgnoreCase("") && pass.equalsIgnoreCase("pas")){
			return true;
		}
		return false;
		
	}


	public Boolean checkErrorMessage() {
		validate(signInButton);
		signInButton.click();
		validate(signInButton);
		return validate(alreadyMemberInvalidCredsErrorMessage);
	}


	public Boolean enterValidUserNamePassword() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1blayer_001");
		//usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password@1");
		//passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if(user.equalsIgnoreCase("q1blayer_001") && pass.equalsIgnoreCase("Password@1")){
			return true;
		}
		return false;
	}


	public AccountHomePage signInValid() {
		validate(signInButton);
		signInButton.click();
		//validate(signInButton);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | My Account Home")){
            return new AccountHomePage(driver);
            }

		return null;
	}
	
	public Boolean cookieValid() {
		validate(signInButton);
		signInButton.click();
		//validate(signInButton);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		validate(myPlansTab);
		if (getCookieName("membervisited") != null) {
			driver.switchTo().window(tabs.get(0));
			if (getCookieName("membervisited") != null) {
				return true;
			}
		}

		return false;
	}


	public Boolean alreadyMemberActiveValid() {
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if(timerId.contains("cookie")){
			if(cookieValid()){
			driver.navigate().refresh();
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if(timer > 0){
			return validate(signInButton);
			}
			}
		}else if(timerId.contains("visitor")){
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if(timer > 0){
			return validate(signInButton);
			}

		}
		return false;
	
	}


	public Boolean cookieTimerValid() {
		driver.navigate().refresh();
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if(timerId.contains("cookie") || timerId.contains("visitor")){
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			timer = timer*1000;
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return validate(signInButton);
	}


	public Boolean stopTimerValid() {
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if(timerId.contains("cookie")){
			if(cookieValid()){
			driver.navigate().refresh();
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			timer = timer*1000;
			usernameField.click();
			try {
				Thread.sleep(timer);
				return validate(signInButton);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			}
		}else if(timerId.contains("visitor")){
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			try {
				Thread.sleep(timer);
				return validate(signInButton);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
		return null;
	}
}

