package pages.dashboard_deprecated.formsandresources;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FormsAndResourcesPage extends UhcDriver {

                /** The member signin link. */
                @FindBy(id = "fd_memberSignInButton")
                private WebElement memberSignInButton;

                /** userId */
                @FindBy(id = "loginPOPUPuser")
                private WebElement loginuserId;

                /** Password */
                @FindBy(id = "loginPOPUPpass")
                private WebElement loginpassword;

                /** Sign in button in login pop screen */
                @FindBy(className = "memSignPopup")
                private WebElement memberSignInPopup;

                /** Link to Form And resources page in Test Harness Page */
                @FindBy(linkText = "Go to Forms And Resources page")
                private WebElement linkToFormsAndResources;
                
            	
            	/**Link for perception popup**/
            	@FindBy(xpath="html/body/div[3]/div[2]/map/area[1]")
                private WebElement perceptionpopup;	


                /** Medical button in EOB section - Forms And Resources page */
                @FindBy(xpath = "html/body/div[2]/div/div[4]/div[2]/div[8]/div/div/div/section/div/div[2]/div/div/section/a")
                private WebElement eobMedicalButton;

                /** Drug button in EOB section */
                @FindBy(xpath = "(//*[contains(text(),'Drug EOB')])[4]")
                private WebElement eobDrugButton;
                
                /** Renew Magazine Section - Forms And Resources page */
                @FindBy(xpath = "(//*[contains(text(),'Renew Magazine')])[3]")
                private WebElement renewMagazineSection;
                
                /** My DocumentSection - Forms And Resources page */
                @FindBy(id = "myDocHeader")
                private WebElement myDocumentSection;

                
                /** Plan Material Section**/
                
                @FindBy(xpath = "(//h2[contains(text(),'Plan Materials')])[1]")
                private WebElement PlanMaterialSection;
      
                /*for active uhc member */
                @FindBy(xpath = "(//a[contains(text(),'VIEW MEMBER ID CARD')])[1]")
                private WebElement MemberIdCardlink;
              //*[contains(text(),'VIEW MEMBER ID CARD')]
                
                @FindBy(xpath = " //*[contains(text(),'ORDER PLAN MATERIALS')]")
                private WebElement OrderPlanMaterialLink;
                       
                WebElement languagedropdown = driver.findElement(By.id("lang-select-2"));
                Select oselect = new Select(languagedropdown);

            /**Anoc Section**/
                @FindBy(xpath ="//*[contains(text(),'Annual Notice of Changes Documents')]")
                private WebElement AnocSection; 
                
            /** Annual Directories Section**/
                @FindBy(xpath ="(//*[contains(text(),'Annual Directories')])[3]")
                private WebElement AnnualDirectorySection;
                
                /*Provider Search Link*/
                @FindBy(xpath ="(//*[contains(text(),'Provider Search')])[1]")
                private WebElement ProviderSearchLink;
                
                /*Pharmacy Locator Link*/
                @FindBy(xpath ="(//*[contains(text(),'Pharmacy Locator')])[2]")
                private WebElement PharmacyLocatorLink;
                
            
                /**Forms and Resources section**/    
                @FindBy(xpath = "//h2[@id='formsAndResHeader']")
                private WebElement FormsnResources;
                
                
                
                public FormsAndResourcesPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                              //  openAndValidate();
                }
                
             /*   public void navigatetoFormsnResources() throws InterruptedException
                {
                              //  DOCUMENTSRESOURCES.click();
                               if (MRScenario.environment.equalsIgnoreCase("team-ci1") || MRScenario.environment.equalsIgnoreCase("team-g") ||MRScenario.environment.equalsIgnoreCase("test-a") ) {
                             	  Thread.sleep(40000);
                        			System.out.println("Go to forms and resources link is present "+driver.findElement(By.xpath("//*[contains(text(),'Go to Forms and Resource page')]")).isDisplayed());
                        			driver.findElement(By.xpath("//*[contains(text(),'Go to Forms and Resource page')]")).click();
                        			
                        		}

                        		else if (MRScenario.environment.equalsIgnoreCase("stage")) {
                        			System.out.println("user is on Stage login page");			
                        						
                        			if(driver.getCurrentUrl().contains("/dashboard"));
                        			{
                        				System.out.println("User is on dashboard page and URL is ====>"+driver.getCurrentUrl());
                        				Thread.sleep(20000);
                        				DOCUMENTSRESOURCES.click();
                        				
                        				
                        			}
                        				
                        		}
                        		else 
                        		{
                        			System.out.println("This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");	
                        		}
                        		
                               System.out.println(driver.getTitle());

                        		
                             //   return new FormsAndResourcesPage(super.driver);
                                
                }*/

                @Override
                public void openAndValidate() {
                            //   start(MRConstants.UHCM_MEMBER_URL);

                }

                public void clickMemberSignIn() {
                                memberSignInButton.click();

                }

                public void enterUserid(String userId) {
                                sendkeys(loginuserId, userId);

                }

                public void enterPassword(String password) {
                                sendkeys(loginpassword, password);

                }

                public void clickMemberSignInButton() {
                                memberSignInPopup.click();

                }

                public void openTestHarnessPage() {
                                ArrayList<String> tabs = new ArrayList<String>(
                                                                driver.getWindowHandles());
                                driver.switchTo().window(tabs.get(0));
                    driver.get(MRConstants.BLUE_LAYER_TEST_HARNESS_LINK);
                }

                public void clickonFormsAndResourcesLinkOnTestHarness() {
                                linkToFormsAndResources.click();

                }
                /**
                 * @toDo : EOB medical button
                 */
                public WebElement getEOBMedicaButton() {
                                return eobMedicalButton;
                }
                /**
                 * @toDo : EOB drug button
                 */
                public WebElement getEOBDrugButton() {
                                return eobDrugButton;
                }
                /**
                 * @toDo : renew magazine section
                 */
                public WebElement getRenewMagazineSection() {
                                return renewMagazineSection;
                }
                /**
                 * @toDo : my document section
                 */
                public WebElement getMyDocumentSection() {
                                return myDocumentSection;
                }
                /**
                 * @toDo : anoc section
                 */
                public WebElement getANOCSection()
                {
                                return AnocSection;
                }
                /**
                 * @toDo : forms and resources section
                 */
                public WebElement getFormsandResourcesSection()
                {
                                return FormsnResources ;
                }
                /**
                 * @toDo : annual directory section
                 */
                public WebElement getAnnualDirectorySection()
                {
                                return AnnualDirectorySection;
                }
                /**
                 * @toDo : provider search link
                 */
                public WebElement getprovisesearchlink()
                {
                           return  ProviderSearchLink;    
                }
                /**
                 * @toDo : pharmacy search link
                 */
                public WebElement getpharmacysearchlink()
                {
                             return PharmacyLocatorLink;  
                }
                
                /**
                 * @toDo : clicking on perception
                 */
         	   public void clickonperceptionpopup()
        	   {
        		   perceptionpopup.click();
        		   perceptionpopup.click();
        		   
        	   }
         
                
                /**
                 * @toDo : plan materials section
                 */
                public WebElement getplanmaterialsection()
                {
                              return PlanMaterialSection;
                }
                /**
                 * @toDo : order plan material link
                 */
                public WebElement getOrderPlanMaterialLink()
                {
                            return OrderPlanMaterialLink;   
                }
                /**
                 * @toDo : to click order plan material link
                 */
                public void validatenclickOrderPlanMaterial() throws InterruptedException
                {
                     getOrderPlanMaterialLink().click();
                     Thread.sleep(5000);
                   /*  String expectedURL ="https://stage-medicare.uhc.com/medicare/member/order-materials/overview.html";
                     String actualURL=driver.getCurrentUrl();
                     System.out.println(actualURL);
                    Assert.assertEquals(expectedURL, actualURL);*/
                     driver.navigate().back();
                     Thread.sleep(5000);
                     String s=driver.getCurrentUrl();
                     System.out.println(s);
                     if(s.contains("overview"))
                     {
                    	 System.out.println("passed");
                     }
                     else 
                     {
                    	 System.out.println("failed");
                     }
                }
                /**
                 * @toDo : temporary id card link
                 */
                public WebElement getTemporaryIdcardlink()
                {
                        return  MemberIdCardlink;      
                }
                /**
                 * @toDo : to click temporary id card link
                 */
                public void validatenclickIDCard() throws InterruptedException
                {
                     getTemporaryIdcardlink().click();
                     
                     Thread.sleep(5000);
                     
                   /*  String expectedURL ="https://member.int.uhc.com/medicare/dashboard/modal/id-cards";
                     String actualURL=driver.getCurrentUrl();
                     System.out.println(actualURL);
                     Thread.sleep(5000);
                   Assert.assertEquals(expectedURL, actualURL);
                     driver.findElement(By.cssSelector(".modal-close-btn")).click();
					
                     
                     Thread.sleep(5000);
                    String s=driver.getCurrentUrl();
                    System.out.println(s);
                     if(s.contains("/dashboard"))
                     {
                     System.out.println("passed");
                     }
                     else 
                     {
                    	 System.out.println("failed"); 
                     }*/
                     }

                /**
                 * @toDo : to verify english as a default language 
                 */
                public void validateEngDefault()
                {
                	System.out.println(oselect.getFirstSelectedOption().getText());
                     if(oselect.getFirstSelectedOption().getText().equals("ENGLISH"))
                     {
                    	 System.out.println(oselect.getFirstSelectedOption().getText());
                    	 System.out.println("true");
                     }
                     
                     else 
                     {
                           System.out.println("false");
                     }
                }
                /**
                 * @toDo : switch language
                 */
                public void changelanguage() throws InterruptedException
                {
                     oselect.selectByVisibleText("SPANISH");
                     Thread.sleep(3000);
                  System.out.println(oselect.getFirstSelectedOption().getText());
                     
                }

				
		 public void scroll() {
				    	JavascriptExecutor jse = (JavascriptExecutor)driver;
				    	jse.executeScript("window.scrollBy(0,150)", "");
				    	
		    }
			public void checkOrderPlanMaterialLinkforterminated(){
				Assert.assertTrue(!(validate(OrderPlanMaterialLink)));
				
				
			}
			
			public void validateshipeob()
			{
				WebElement shipeob= driver.findElement(By.xpath("(//*[contains(text(),'Medical EOB')])[7]"));
                validate(shipeob);
			}
                
                
}

