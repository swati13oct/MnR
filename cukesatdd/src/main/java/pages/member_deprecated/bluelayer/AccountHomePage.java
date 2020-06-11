/**
 * 
 */
package pages.member_deprecated.bluelayer;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;


/**
 * @author pagarwa5
 
 */
public class AccountHomePage extends UhcDriver {

        @FindBy(css = "a.fd_myPersonalHealthRecord")
        private WebElement phrTab;

        @FindBy(id = "plan_box")
        private WebElement planBox;


        @FindBy(linkText = "estimate costs")
        private WebElement estimateCostLink;
        
        @FindBy(linkText = "Contact Us")
        private WebElement contactUsLink;
        
        @FindBy(linkText = "Plan Benefits")
        private WebElement benefitsLink;

        @FindBy(id = "disclosure_link")
        private WebElement logOut;

        @FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_panelnav-planresources-main_links_jcr_content_par_teaser']/div/li/a")
        private WebElement formsAndResourcesLink;

        @FindBy(xpath = "//*[@id='myshipplans']/a")
        private WebElement myPlansTab;

        @FindBy(linkText = "locate a pharmacy")
        private WebElement pharmacyLocator;
        
        @FindBy(linkText = "medical providers")
        private WebElement medicalProviders ;

        @FindBy(xpath = "//li[@id='fd_myMenu']/a")
        private WebElement myMenuNavigator;

        @FindBy(linkText = "Search drug claims")
        private WebElement searchDrugClaims;

        @FindBy(linkText = "Search medical claims")
        //@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_chunkyfooter-activitylinks-main_activitylinks-main_jcr_content_par_teaser']/div/li/a")//(linkText = "Search medical claims")
        private WebElement searchMedicalClaims;
        
        @FindBy(xpath = "//div[@id='medicareTitle']/h1")
        private WebElement pharmacyLocatorHeading;

        @FindBy(xpath = "//span[contains(.,'Print temporary ID card')]")
        private WebElement viewIDCard;
        
        @FindBy(id = "pcpLogoPrint1left")
        private WebElement validateLogo;
        
        @FindBy(xpath = "//a[contains(text(),'UnitedHealthcare MedicareComplete Choice (PPO)')]")
        private WebElement uhcMedicareCompleteChoicePPO;
        
        @FindBy(xpath ="//*[@id='healthwellness']/a")
        private WebElement healthAndWellnessTab;
        
        @FindBy(xpath = "html/body/div[3]/div/div[1]/header/div/div/div/div/div/div/p/a[2]")	
    	private WebElement backToPreviousPage;
                
        @FindBy(xpath ="//*[@id='gogreenmeter']/a")
        private WebElement goGreenLink;
        
        @FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div/a")
        private WebElement gogreenPopupClose;
        

        @FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div")
        private WebElement gogreenPopup;
        
        @FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[2]/td[2]")
        private WebElement memberId;
        
        @FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[1]/td[2]")
        private WebElement groupId;
 
        @FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/p/a")
        private WebElement planNameLink;
        
        @FindBy(xpath = ".//*[@id='contentRow']")
        private WebElement homePageContent;
        
        @FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]")
        private WebElement drugLookupBox;
        
        @FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]/a/span")
        private WebElement estimateCostsBtn;
        
        @FindBy(xpath = ".//*[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[3]/div[2]")
        private WebElement myResourcesContent;
        
        @FindBy(xpath="html/body/div[2]/div/div[4]/div[2]/div/table/tbody/tr[4]/td[2]/a")
        private WebElement benfitscoveragelink;
        
@FindBy(xpath="//a[contains(text(),'Provider search')]")
private WebElement providerSearchinPanelNavigation;

@FindBy(id="btn_searchforaprovider")
private WebElement medicalEOBproviderlink;

@FindBy(linkText="Medical Explanation of Benefits (EOB)")
private WebElement medicalEOBlink;

@FindBy(id="fd_myMenu")
private WebElement myMenu;

@FindBy(linkText = "Benefits and Coverage")
private WebElement benefitsAndCoveragelink;

@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
private WebElement accountToggleDropdown;

@FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
private WebElement accountSettingOption;

@FindBy(xpath = "//header//h1")
private WebElement heading;


@FindBy(xpath="//a[contains(text(),'Search for a provider')]")
private WebElement providerlinkinPCPSection;

@FindBy(css="li#accountdetails>a")
private WebElement accountHome;

@FindBy(id = "widgetbuttoncontainer")
private WebElement searchLinkinClaimsPage;


@FindBy(id = "phr_widget_3")
private WebElement showLink;


@FindBy(xpath="//div[@class='phr_greybox_mid']/p[contains(text(),'Looking for a doctor')]/following-sibling::p/a")
private WebElement providerSearchinPHPage;

//@FindBy(xpath="//*[@id='phr_widget_3_box']/div[233]/p[2]/a")
//private WebElement providerSearchinPHPage1;


//@FindBy(xpath="div[@class='phr_greybox_mid']/p[contains(text(),'Need to find a facility?')]/following-sibling::p/a")
//private WebElement providerSearchinPHPage1;

                
@FindBy(xpath="(//a[@id='btn_searchforaprovider'])[1]")
private WebElement providerSearchinPHPage1;

@FindBy(linkText = "Claims")
private WebElement claimsLink;



@FindBy(xpath ="(//a[contains(@href,'my-plans/forms-and-resources')])[4]")
private WebElement FormsandResourcesLinkn;

  @FindBy(xpath="//*[@id='btn_searchforaprovider']")
  private WebElement providerLink;
        
        @FindBy(xpath="//span[text()='search providers']")
        private WebElement searchProviderLinkinFormsandResourcePage;
 
        
        @FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
        private List<WebElement> iPerceptionPopUp;
        
        @FindBy(xpath="html/body/div[2]/div/div[4]/div[2]/div/table/tbody/tr[6]/td[2]/a")
        private WebElement profilenpreferenceslink;
        
        @FindBy(id ="authQuestiontextLabelId")
        private WebElement questionid;
        @FindBy(id ="challengeQuestionList[0].userAnswer")
        private WebElement securityAnswer;
        
        @FindBy(id ="continueSubmitButton")
        private WebElement continueButton;
        
    	@FindBy(xpath="//*[@id='IPEinvL']/map/area[3]")
    	private WebElement iPerceptionAutoPopUp;
    	
    	@FindBy(xpath="//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[5]")
    	private WebElement PremiumPayment;
    	
    	@FindBy(id="payment-date")
    	private WebElement HistoryDropdown;	
    	
    	@FindBy(xpath="(//*[@id='paymentTable'])[1]")
    	private WebElement HistoryTable;	
        
    	@FindBy(xpath="//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h1")
    	private WebElement PaymentHeading;
    	
        private PageData myAccountHome;

        public JSONObject accountHomeJson;
        
        private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

        public AccountHomePage(WebDriver driver,String category) {
                super(driver);
                PageFactory.initElements(driver, this);
                if(category.equalsIgnoreCase("Individual"))
                {
                        String fileName = CommonConstants.ACCOUNT_HOME_PAGE_INDIVIDUAL_DATA;
                        myAccountHome = CommonUtility.readPageData(fileName,
                                        CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
                }
                else
                {
                        String fileName = CommonConstants.ACCOUNT_HOME_PAGE_DATA;
                        myAccountHome = CommonUtility.readPageData(fileName,
                                        CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
                }
              
                
                //openAndValidate();
        }

        public AccountHomePage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(driver, this);
//                openAndValidate();
        }
        
        public BenefitsAndCoveragePage navigateDirectToBnCPag() {
    		
        	if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) 
        	{
    			System.out.println("user is on Stage login page");			
    			//CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);			
    			if(driver.getCurrentUrl().contains("/dashboard"));
    			{
    				System.out.println("User is on dashboard page and URL is ==>"+driver.getCurrentUrl());
    				driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
    				System.out.println(driver.getCurrentUrl());
    				CommonUtility.waitForPageLoad(driver, heading, 30);
    				if(driver.getTitle().equalsIgnoreCase("Benefits Overview"))
    	    		{
    					System.out.println(driver.getTitle());
    	    			return new BenefitsAndCoveragePage(driver);
    	    		}
    				
        	}
        	}
        
    			else if ( MRScenario.environmentMedicare.equals("team-h") || MRScenario.environmentMedicare.equals("test-a") || MRScenario.environmentMedicare.equals("team-e")) {
    				
    				driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
    				System.out.println(driver.getCurrentUrl());
        		}
    			else
    			{
    				driver.navigate().to("https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");
    				
    				System.out.println(driver.getCurrentUrl());
        		}
        	
            
    		/*if (validate(iPerceptionPopUp)) {
                iPerceptionPopUp.click();
                System.out.println("iPerception Pop Up displayed");
    		}*/

    		CommonUtility.waitForPageLoad(driver, heading, 50);
    		if(driver.getTitle().equalsIgnoreCase("Benefits Overview"))
    		{
    			return new BenefitsAndCoveragePage(driver);
    		}
    			
    		return null;
    	}

        
        public ProfileandPreferencesPage navigateDirectToProfilePage() throws InterruptedException  {
    		
        	if (MRScenario.environment.equalsIgnoreCase("stage")) 
        	{
    			System.out.println("user is on Stage login page");			
    			//CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);			
    			if(driver.getCurrentUrl().contains("/dashboard"));
    			{
    				
    				/*accountToggleDropdown.click();
    				validate(accountSettingOption);
    				accountSettingOption.click();
    				try {
    					Thread.sleep(3000);
    				} catch (InterruptedException e) {
    					// TODO Auto generated catch block
    					e.printStackTrace();
    				}*/
    				driver.navigate().to(PAGE_URL+"medicare/member/account/profile.html");
    		
    				System.out.println("title is "+driver.getTitle());
    				System.out.println("Current Url is "+driver.getCurrentUrl());
    				CommonUtility.waitForPageLoad(driver, heading, 50);

    				if (driver.getTitle().equalsIgnoreCase("Profile")) {

    					return new ProfileandPreferencesPage(driver);
    				}
    			
        	}
        	}
        	
        	
    		if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h") || MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e")) 
    		{
    			
	            driver.navigate().to(PAGE_URL+"medicare/member/account/profile.html");
        		
				System.out.println("title is "+driver.getTitle());
				System.out.println("Current Url is "+driver.getCurrentUrl());
				
    		}
    		else
    		{
    			driver.navigate().to("https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/account/profile.html");
				System.out.println("title is "+driver.getTitle());
				System.out.println("Current Url is "+driver.getCurrentUrl());
			
    		}
    		CommonUtility.waitForPageLoad(driver, heading, 50);
    		if(driver.getTitle().equalsIgnoreCase("Profile"))
    		{
    			return new ProfileandPreferencesPage(driver);
    		}
    		
    		return null;
    	}

        public String getMyPlans() {
                return planBox.getText();
        }

        public BenefitsCoveragePage navigateToBnC() {

    		benefitsLink.click();
    		try {
    			Thread.sleep(90000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		String title = driver.getTitle().toString();
    		if (title.equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Plan Benefits and Coverage")) {
    			return new BenefitsCoveragePage(driver);
    		} else
    			return null;
    	}
    	

        public PhrPage navigateToPhr() {

                phrTab.click();
                if (getTitle().equalsIgnoreCase(
                                                "UnitedHealthcare Medicare Solutions | My Personal Health Record")) {
                        try {
                                Thread.sleep(10000);
                        } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        return new PhrPage(driver);
                }

                return null;

        }

        public void  rallytoolexist()
        {
                String mainwindow=driver.getWindowHandle();
                Set<String> allWindowHandles = driver.getWindowHandles();
                for (String currentWindowHandle : allWindowHandles) {
                        if (!currentWindowHandle.equals(mainwindow)) {
                        driver.switchTo().window(currentWindowHandle);
                        
                        }
                }
                CommonUtility.checkPageIsReady(driver);
                try {
                        Thread.sleep(10000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                String s=driver.getTitle();
                System.out.println(s);
                
                
                if(s.equalsIgnoreCase("Find Care"))
                {
                        System.out.println("Rally tool is opened Successfully");
                        driver.close();
                }
                else
                {
                        System.out.println("Rally tool is not opened ");
                        
                         Assert.assertFalse("Rally tool displayed", false);
                        
                        //Assert.fail("Error :Unable to Login");
                        driver.close();
                }
                
driver.switchTo().window(mainwindow);

}
        public void navigate_ProviderSearchBlayerUnderMyResourceSection()
        {
                CommonUtility.checkPageIsReady(driver);
    CommonUtility.waitForPageLoad(driver, medicalProviders, 10000L);
                
                medicalProviders.click();
                rallytoolexist();
System.out.println(" in navigate Provider Search under my Resource");


        }
        public void  waitt()
        {
                try {
                        Thread.sleep(8000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        
        public void panelNavigation()
        {
          
           
           waitforElement(myMenu);
           myMenu.click();
        
           waitforElement(providerSearchinPanelNavigation);
                providerSearchinPanelNavigation.click();
                rallytoolexist();
                
                System.out.println(" in panel Navigation method");
                
                
        }
        
        public void providerSearchLinkinClaimsPage()
        {
                
                myPlansTab.click();
                
                waitforElement(claimsLink);
                claimsLink.click();
                waitforElement(searchLinkinClaimsPage);
                
                searchLinkinClaimsPage.click();
                
                waitforElement(providerLink);
                
                providerLink.click();
                rallytoolexist();
                System.out.println(" in Claims method");
                
        }
        
        public void providerSearchLinkInClaimsPageEOB()
        {
                
                waitforElement(claimsLink);
                claimsLink.click();
                waitforElement(searchLinkinClaimsPage);
                
                searchLinkinClaimsPage.click();
                
                waitforElement(providerLink);
                
                providerLink.click();
                rallytoolexist();
                System.out.println(" in Claims EOB  method");
        }
        
        


        public void PHR()
        {
                phrTab.click();
                
                
                waitforElement(providerSearchinPHPage);
                providerSearchinPHPage.click();
                System.out.print("clicked the first provider search in Phr page");
                rallytoolexist();
                showLink.click();
                
                waitforElement(providerSearchinPHPage1);
                providerSearchinPHPage1.click();
                rallytoolexist();
                System.out.println(" in PHR");
                
        }

        
        public void BenefitsandCoverageProviderSearch()
        {
                
                accountHome.click();
                
                waitforElement(myPlansTab);
                myPlansTab.click();
                
        waitforElement(benefitsAndCoveragelink);
                benefitsAndCoveragelink.click();
                waitforElement(medicalEOBproviderlink);
                medicalEOBproviderlink.click();
                rallytoolexist();
                System.out.println(" in Benefit Coverage  method");
                
        }
        public void providerSearchRHandWidgetBlayer()
        {
                
        
                waitforElement(medicalEOBlink);
                medicalEOBlink.click();
                //medicalEOBproviderlink.click();
                rallytoolexist();
                System.out.println(" in Provider searh Rifht method");
                
        }
        public void providerSearchLinkinPCPSection()
        {
                
                waitforElement(providerlinkinPCPSection);
                providerlinkinPCPSection.click();
                rallytoolexist();
                System.out.println(" in PCP benefit  method");
        }

        
public void FormsandResourcesLinkinPlanSummaryPageBlayer()
        
        {
        
          myPlansTab.click();
          waitforElement(FormsandResourcesLinkn);
        
                FormsandResourcesLinkn.click();
                
                waitforElement(searchProviderLinkinFormsandResourcePage);
                
                searchProviderLinkinFormsandResourcePage.click();
                rallytoolexist();
                
                System.out.println(" in forms and Resources  method");
                
        }

        public ManageDrugPage navigateToEstimateCost(String category) {
                List<WebElement> estimateCost = driver.findElements(By.xpath(".//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]/a"));
                System.out.println("estimateCost size"+estimateCost.size());
                try {
                        Thread.sleep(4000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                estimateCost.get(0).click();
                if (getTitle().equalsIgnoreCase("Drug Cost Estimator") && category.equalsIgnoreCase(CommonConstants.GROUP)) {
                        return new ManageDrugPage(driver,category);
                }
                else if((getTitle().equalsIgnoreCase("Drug Cost Estimator"))){
                        return new ManageDrugPage(driver);
                }

                return null;
        }

        public PlanSummaryPage navigateToPlanSummary() {

        
                myPlansTab.click();

                CommonUtility.checkPageIsReady(driver);
                if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | Plan Summary")) {
                        return new PlanSummaryPage(driver);
                }

                return null;
        }


        public PharmacySearchPage navigateToPharmacyLocator() {

                pharmacyLocator.click();
                CommonUtility.waitForPageLoad(driver, pharmacyLocatorHeading, CommonConstants.TIMEOUT_30);
                try {
                        Thread.sleep(10000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
                        return new PharmacySearchPage(driver);
                }
                return null;
        }
        





        public ClaimSummaryPage navigateToMedicalClaimsSummary() {
                
                validate(searchMedicalClaims);
                searchMedicalClaims.click();
                try {
                        Thread.sleep(2000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | Claims")) {
                        return new ClaimSummaryPage(driver);
                }

                return null;
        }

        public ClaimSummaryPage navigateToDrugClaimsSummary(String planCategory) {

                searchDrugClaims.click();
                if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | Claims")) {
                        /*if (planCategory.equalsIgnoreCase("Individual")) {
                                return new ClaimSummaryPage(driver, planCategory);
                        } else { */
                                return new ClaimSummaryPage(driver);
                        /*}*/
                }

                return null;
        }


        public void logOut() {
                logOut.click();

        }

        @Override
        public void openAndValidate() {

                JSONObject jsonObject = new JSONObject();
                for (String key : myAccountHome.getExpectedData().keySet()) {
                        WebElement element = findElement(myAccountHome.getExpectedData()
                                        .get(key));
                        if (null != element) {
                                validate(element);
                                try {
                                        jsonObject.put(key, element.getText());
                                } catch (JSONException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                        }
                }
                accountHomeJson = jsonObject;
                System.out.println("accountHomeJson----->"+accountHomeJson);
        }

        public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

                JSONObject globalExpectedJson = expectedDataMap
                                .get(CommonConstants.GLOBAL);
                JSONObject accountHomeExpectedJson = expectedDataMap
                                .get(CommonConstants.MY_ACCOUNT_HOME);
                accountHomeExpectedJson = CommonUtility.mergeJson(
                                accountHomeExpectedJson, globalExpectedJson);
                return accountHomeExpectedJson;
        }

        public JSONObject getAdditionalPlanExpectedData(
                        Map<String, JSONObject> expectedDataMap) {

                JSONObject globalExpectedJson = expectedDataMap
                                .get(CommonConstants.GLOBAL);
                JSONObject addPlanExpectedJson = expectedDataMap
                                .get(CommonConstants.ADD_PLAN);
                JSONObject accountHomeExpectedJson = expectedDataMap
                                .get(CommonConstants.MY_ACCOUNT_HOME);
                JSONObject accountHomeComboExpectedJson = expectedDataMap
                                .get(CommonConstants.MY_ACCOUNT_HOME_COMBO);
                accountHomeExpectedJson = CommonUtility.mergeJson(
                                accountHomeExpectedJson, globalExpectedJson);
                accountHomeExpectedJson = CommonUtility.mergeJson(
                                accountHomeExpectedJson, addPlanExpectedJson);
                accountHomeExpectedJson = CommonUtility.mergeJson(
                                accountHomeExpectedJson, accountHomeComboExpectedJson);
                return accountHomeExpectedJson;
        }

        public PlanSummaryPage navigateToPlanSummary(String category) {
                myPlansTab.click();
                if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | Plan Summary")
                                && category.equalsIgnoreCase(CommonConstants.GROUP)) {
                        return new PlanSummaryPage(driver, category);
                } else if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | Plan Summary")) {
                        return new PlanSummaryPage(driver);
                }

                return null;
        }

        public Boolean tempIdValidation() {
                validate(viewIDCard);
                viewIDCard.click();
                if(validate(validateLogo)){
                        return true;
                }
                return false;
                
        }
        public void validatePlanName(){
                    String planName = LoginCommonConstants.PLAN_NAME;
                    System.out.println(planName);
                    List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
                    for(int i=0; i<planWebElement.size();i++){
                            if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
                                    System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
                                    Assert.fail();
                            }
                            else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
                                    System.out.println("----------Plan name displayed as expected="+planName);
                            } else{
                                    System.out.println("----------Failed because Plan NAme not present");
                                    Assert.fail();
                            }                  
                    }
         }

        
        /**
        * Below method will validate plan name: 'uhcMedicareCompleteChoicePPO'
        * Added as part of commandos team
        * @return
        */
        public boolean isUHCMedicareCompleteChoicePPOPresent(){
        try{
        if(uhcMedicareCompleteChoicePPO.getText() == CommonConstants.SIERRA_PLAN_NAME){
        System.out.println("uhcMedicareCompleteChoicePPO is displayed ");
        }else{
        System.out.println("uhcMedicareCompleteChoicePPO.getText() >>>>>>   "+uhcMedicareCompleteChoicePPO.getText());
        }
        }catch(Exception e){
        return false;
        }
        return true;
        }


        public HealthAndWellnessPage navigateToHealthAndWellnessPage() {

                healthAndWellnessTab.click();
                if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | My Health and Wellness")) {
                        return new HealthAndWellnessPage(driver);
                }

                return null;

        }
        

        public void navigate_ProviderSearch() {
                validate(medicalProviders);
                medicalProviders.click();
                String baseWindowHdl = driver.getWindowHandle();
                driver.getWindowHandles();
                
                for(String h:driver.getWindowHandles()){
                        driver.switchTo().window(h);
                        if(!h.equals(baseWindowHdl)){
                                driver.close();
                        }
                        
                }
                driver.switchTo().window(baseWindowHdl);                
        }
        
        public void navigateToHomePage() throws InterruptedException{
                Thread.sleep(10000);
                //driver.navigate().to("https://member.team-b-uhcmedicaresolutions.uhc.com/home/my-account-home.html");
                System.out.println("current url "+driver.getCurrentUrl());
                String homeUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/home/my-account-home.html";
                driver.get(homeUrl);
                //driver.close();
        }

        
        public boolean validateGogreenPopup(){
                boolean flag=false;
                try {
                        flag= validate(gogreenPopup);
                        return flag;
                } catch (Exception e) {
                        return flag;
                }                
        }
        
        public void closeGogreenPopup(){
                gogreenPopupClose.click();
        }

        public void validateTabs(){
                Assert.assertTrue("My Plans tab is not displayed",myPlansTab.isDisplayed());
                Assert.assertTrue("Health and Wellness Tab is not displayed",healthAndWellnessTab.isDisplayed());
                Assert.assertTrue("Personal Health Record Tab is not displayed",phrTab.isDisplayed());
                Assert.assertTrue("My Menu Navigatoris not displayed",myMenuNavigator.isDisplayed());
        }
        
        public void validatWidgetsndButtons(){
                Assert.assertTrue("My plans is not displayed",planBox.isDisplayed());
                //Assert.assertTrue("Status is not displayed",status.isDisplayed());
                Assert.assertTrue("Member Id is not displayed",memberId.isDisplayed());
                Assert.assertTrue("Group Id is not displayed",groupId.isDisplayed());
                if(!getPlanName().contains("PDP")){
                        Assert.assertTrue("Medical providers is not displayed",medicalProviders.isDisplayed());
                }
                Assert.assertTrue("Estimate Cost Link is not displayed",estimateCostLink.isDisplayed());
                Assert.assertTrue("Pharmacy locator is not displayed",pharmacyLocator.isDisplayed());
                
        }
        
        public String getPlanName(){
                return planNameLink.getText();
        }
        
        public void navigateBack(){
                driver.navigate().back();
        }
        
        public void validateHomePage() throws InterruptedException{
                Thread.sleep(10000);
                if (getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | My Account Home")){
                        Assert.assertTrue(true);
                }else{
                        Assert.assertTrue(false);
                }
                
        }
        
        public void validateHWTabsAndContent(){
                
                HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
                healthAndWellness.validateTabsAndContent();

        }
        
        public void validateHWLifeStyleTab(){
                HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
                healthAndWellness.validateLifeStyleTab();
        }
        
        public void validateHWLearningTab(){
                HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
                healthAndWellness.validateLearningTab();
        }
        
        public void validateHWRewardsTab(){
                HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
                healthAndWellness.validateRewardsTab();
        }
        
        
        public boolean validateAccountHome(){
                boolean flag = false;
                if(validate(homePageContent)&&validate(planBox)&&validate(logOut)&&validate(myResourcesContent)&&validate(drugLookupBox)&&validate(estimateCostsBtn))
                        flag = true;
                return flag;
        }
        
        public FormsandresourcesPage navigateToFormsandResourceUmsPage() {
                myMenu.click();
                formsAndResourcesLink.click();
                CommonUtility.checkPageIsReady(driver);
                if (driver.getTitle().equalsIgnoreCase(
                                "UnitedHealthcare Medicare Solutions | Forms and Resources")) {
                        return new FormsandresourcesPage(driver);
                } else

                        return null;

        }
        public ContactUsPage navigatesToContactUsPage() {
            // this.waitforElement(contactUsLink);
            contactUsLink.click();
            if (getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Contact Us")) {
                    return new ContactUsPage(driver);
            }
            return null;
        }
        
        public AccountHomePage navigateToTermsandConditions(){
    		
    			System.out.println("title  "+driver.getTitle());
    		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
    			return new AccountHomePage(driver);
    			}
    			return null;

    	}

        public BenefitsCoveragePage backToPreviousPage(){
    		backToPreviousPage.click();
    		String title = driver.getTitle().toString();
    		System.out.println(title);
    		if (title.equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Home")) {
    			return new BenefitsCoveragePage(driver);
    		}
    		else
    		return null;
    		
    	}
        public GoGreenPage navigateToGoGreenPage() {

            goGreenLink.click();
            if (getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Go Green")) {
                    return new GoGreenPage(driver);
            }

            return null;

    }
    	public void  validateTheSecurityQues(String friendname, String favouritecolor, String phoneNumber) {
    		String Question=questionid.getText();
    		System.out.println("question is"+ Question);
    		if (Question.equalsIgnoreCase("What is your best friend's name?" ))
    		         {
    			System.out.println("Question is related to friendname");
    			    securityAnswer.sendKeys(friendname);
    			    continueButton.click();
    		         }
    				
    				else if(Question.equalsIgnoreCase("What is your favorite color?" ))
    				{
    					System.out.println("Question is related to color");
    					 securityAnswer.sendKeys(favouritecolor);
    					 continueButton.click();
    				}
    				else
    				{
    					System.out.println("Question is related to phone");
    					 securityAnswer.sendKeys(phoneNumber);
    					 continueButton.click();
    				}


    		}

    				public ProfileandPreferencesPage navigateDirectToProfilePageHsid() throws InterruptedException {
    					// TODO Auto-generated method stub
    					if (MRScenario.environment.equalsIgnoreCase("stage")) 
    		        	{
    		    			System.out.println("user is on Stage login page");			
    		    			//CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);			
    		    			if(driver.getCurrentUrl().contains("/dashboard"));
    		    			{
    		    				
    		    				accountToggleDropdown.click();
    		    				validate(accountSettingOption);
    		    				accountSettingOption.click();
    		    				try {
    		    					Thread.sleep(3000);
    		    				} catch (InterruptedException e) {
    		    					// TODO Auto generated catch block
    		    					e.printStackTrace();
    		    				}
    		    				System.out.println("title is "+driver.getTitle());
    		    				System.out.println("Current Url is "+driver.getCurrentUrl());
    		    				CommonUtility.waitForPageLoad(driver, heading, 50);
    		    			

    		    				if (driver.getTitle().equalsIgnoreCase("Profile")) {

    		    					return new ProfileandPreferencesPage(driver);
    		    				}
    		    			
    		        	}
    		        	}
    		        	
    		        	
    					Thread.sleep(5000);
    		    		if (iPerceptionPopUp.size()>0) {
    		                iPerceptionPopUp.get(0).click();
    		                System.out.println("iPerception Pop Up displayed");
    		    		}

    					
    					if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h") || MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e")) {
    						Thread.sleep(10000);
    						WebElement element = driver.findElement(By.xpath("//a[contains(.,'profile page')]"));
    						validateNew(element);
    						element.click();
    						/*accountToggleDropdown1.click();
    						validate(accountSettingOption1);
    						accountSettingOption1.click();*/
    						try {
    							Thread.sleep(3000);
    						} catch (InterruptedException e) {
    							// TODO Auto generated catch block
    							e.printStackTrace();
    						}
    		    		}else{
    		    			profilenpreferenceslink.click();
    		    		}
    		    		CommonUtility.waitForPageLoad(driver, heading, 50);
    		    		if(driver.getTitle().equalsIgnoreCase("Profile"))
    		    		{
    		    			System.out.println("here");
    		    			return new ProfileandPreferencesPage(driver);
    		    		}
    		    
    					return null;
    				
    		}

     public void verifyPageTitle() throws InterruptedException {
     String title = driver.getTitle();
     //Assert.assertEquals(title, "Home | UnitedHealthcare");
     Assert.assertTrue(title.contains("UnitedHealthcare"));
    			     
   	}	
public AccountHomePage navigateToAutoPaymentHistoryPage() throws InterruptedException
	 {

	 	    	/*WebDriverWait wait = new WebDriverWait(driver, 30);
	 				wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
	 */
	 	    	if(	validate(iPerceptionAutoPopUp)) {
	 	    		iPerceptionAutoPopUp.click();
	 	    	}
	 	    	else  {
	 	    		System.out.println("iPerception Pop Up not displayed");
	 	    	}
	 	    	
	 	        //Thread.sleep(16000);

	 	       waitforElement(PremiumPayment);
	 	    		System.out.println("payment link is displayed on the header");
	 	    		PremiumPayment.click();
	 	    		Thread.sleep(10000);
	 	    		if(PaymentHeading.getText().contains("Premium Payments Overview"))
	 	    		{
	 	    			System.out.println("Payment Overview page displayed");
	 	    		return new AccountHomePage(driver);
	 	    		}
	 	    	else{
	 	    		System.out.println("payment overview page not displayed");
	 	    		return null;
	 	    	}	 	    	
	 	}
  
	 public PaymentHistoryPage scrollDownAndUp() throws InterruptedException
	 {
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			
			waitforElement(HistoryDropdown);
			
			Select dateRange = new Select(HistoryDropdown);
			dateRange.selectByVisibleText("Last 6 months");
			
			Thread.sleep(6000);
			
			if(HistoryTable.isDisplayed())
			{
				System.out.println("Payment History Exists");
				jse.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(3000);
				return new PaymentHistoryPage(driver);				
			}
			else
			{
			return null;
			}
	 }
     public BenefitsAndCoveragePage navigateDirectToBnC() throws InterruptedException {
			// TODO Auto-generated method stub
			if (MRScenario.environment.equalsIgnoreCase("stage")) 
     	{
 			System.out.println("user is on Stage login page");			
 			//CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);			
 			if(driver.getCurrentUrl().contains("/dashboard"));
 			{
 				
 				accountToggleDropdown.click();
 				validate(accountSettingOption);
 				accountSettingOption.click();
 				try {
 					Thread.sleep(3000);
 				} catch (InterruptedException e) {
 					// TODO Auto generated catch block
 					e.printStackTrace();
 				}
 				System.out.println("title is "+driver.getTitle());
 				System.out.println("Current Url is "+driver.getCurrentUrl());
 				CommonUtility.waitForPageLoad(driver, heading, 50);
 			

 				if (driver.getTitle().equalsIgnoreCase("Profile")) {

 					return new BenefitsAndCoveragePage(driver);
 				}
 				
 				
 			
     	}
     	}
     	
     	
			Thread.sleep(5000);
 		if (iPerceptionPopUp.size()>0) {
             iPerceptionPopUp.get(0).click();
             System.out.println("iPerception Pop Up displayed");
 		}

			
			if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h") || MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e")) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto generated catch block
					e.printStackTrace();
				}
				WebElement element = driver.findElement(By.xpath("//a[contains(.,'benefits and coverage page')]"));
				validateNew(element);
				element.click();
				
				//benfitscoveragelink.click();
				/*accountToggleDropdown1.click();
				validate(accountSettingOption1);
				accountSettingOption1.click();*/
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto generated catch block
					e.printStackTrace();
				}
 		}else{
 			benfitscoveragelink.click();
 		}
 		CommonUtility.waitForPageLoad(driver, heading, 50);
 		if(driver.getTitle().equalsIgnoreCase("Profile"))
 		{
 			System.out.println("here");
 			return new BenefitsAndCoveragePage(driver);
 		}
 
			return new BenefitsAndCoveragePage(driver);
		
}
    			    
}

