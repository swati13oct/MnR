

package pages.regression.formsandresources;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FormsAndResourcesPage extends UhcDriver {
                     @FindBy(linkText="")
                 private WebElement DocumentResourceslink;
                  
                 @FindBy(linkText="VIEW DOCUMENTS & RESOURCES")
                  private WebElement DOCUMENTSRESOURCES;

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
                @FindBy(xpath = "//*[@class='customsegments parbase section']//div[@class='otherPages']//*[@class='explanationbenefits parbase section']//*[@class='block-body']")
                private WebElement eobMedicalButton;

                /** Drug button in EOB section */
                @FindBy(xpath ="//*[@class='customsegments parbase section']//div[@class='otherPages']//*[@class='explanationbenefits parbase section']//*[@class='col-md-4 block border-left']")
                private WebElement eobDrugButton;
                
                /** Renew Magazine Section - Forms And Resources page */
                @FindBy(xpath = "//*[@class='customsegments parbase section']//div[@class='otherPages']//*[@href='/wellness/health/health-wellness-programs-pastissues-renew?type=lifestyle']")
                private WebElement renewMagazineSection;
                
                /** My DocumentSection - Forms And Resources page */
                @FindBy(id = "myDocHeader")
                private WebElement myDocumentSection;

                
                /** Plan Material Section**/
                
                @FindBy(id = "plan_material_fnr2018")
                private WebElement PlanMaterialSection;
      
                /*for active uhc member */
                @FindBy(xpath = "(//div[contains(@class,'planBenefitsHeaderParsys')]//*[@class='otherPages']//*[contains(text(),'VIEW MEMBER')])[1]")
                private WebElement MemberIdCardlink;
              //*[contains(text(),'VIEW MEMBER ID CARD')]
                
                /*for terminated*/
                @FindBy(xpath = "(//a[contains(text(),'VIEW MEMBER ID CARD')])[1]")
                private WebElement MemberIdCardlinkterminated;

                
                @FindBy(xpath = "(//div[contains(@class,'planBenefitsHeaderParsys')]//*[@class='otherPages']//*[contains(text(),'ORDER PLAN MATERIALS')])[1]")
                private WebElement OrderPlanMaterialLink;
                
                @FindBy(xpath="//*[@id='lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments2018_segmentContainer_planbenefitdocuments']")
                private WebElement languagedropdown;

            /**Anoc Section**/
                @FindBy(id ="anoc_headerfnr")
                private WebElement AnocSection; 
                
            /** Annual Directories Section**/
                @FindBy(id ="FnR_annualDirectory")
                private WebElement AnnualDirectorySection;
                
                /*Provider Search Link*/
                @FindBy(xpath ="//*[@class='customsegments parbase section']//div[@class='otherPages']//*[contains(@ng-show ,'mapdIndividual')]//*[contains(text(),'Provider Search')]")
                private WebElement ProviderSearchLink;
                
                /*Pharmacy Locator Link*/
                @FindBy(xpath ="//*[@class='customsegments parbase section']//div[@class='otherPages']//*[contains(@ng-show ,'mapdIndividual')]//*[contains(text(),'Pharmacy Locator')]")
                private WebElement PharmacyLocatorLink;
                
            
                /**Forms and Resources section**/    
                @FindBy(xpath = "//h2[@id='formsAndResHeader']")
                private WebElement FormsnResources;
                
                
              //*[@class='formsAndResourcesDocListContainer base_tools_component section']
                private WebElement FormsandResourcesSection;
                
                @FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
              private WebElement FeedbackModal;
                
                public FormsAndResourcesPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                                CommonUtility.checkPageIsReady(driver);
                                  //Thread.sleep(5000);
                                  CommonUtility.checkPageIsReady(driver);
                                  try{
                                  FeedbackModal.click();
                                  System.out.println("FeedBack Modal Present");
                                  if (validate(FeedbackModal)){
                                  System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
                                  }
                                  System.out.println("FeedBack Modal Closed");
                                  }
                                  catch (Exception e) {
                                  System.out.println("FeedBack Modal NOT Present");
                                  }
                               openAndValidate();
                }
                

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
                public void validateOrderPlanMaterial() throws InterruptedException
                {
                     
                     OrderPlanMaterialLink.click();
                     Thread.sleep(5000);
                     if(driver.getCurrentUrl().contains("order plan materials"))
                                  {
                                Assert.assertTrue(true);
                                  }
                     else{
                             Assert.fail("failed to loaf order materials page");
                          }
                     
                     driver.navigate().back();
                     Thread.sleep(20000);
                     if(driver.getCurrentUrl().contains("documents overview"))
                                  {
                                Assert.assertTrue(true);
                                  }
                     else{
                             Assert.fail("failed to loaf fnr page");
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
                public void validateIDCard() throws InterruptedException
                {

                     if (MRScenario.environmentMedicare.equalsIgnoreCase("team-g") || MRScenario.environmentMedicare.equalsIgnoreCase("test-a") || MRScenario.environment.equalsIgnoreCase("team-ci1")) {
                                         
                           
                                  String s=getTemporaryIdcardlink().getAttribute("href");
                                  if(s.contains("test-harness"))
                                  {
                                         Assert.assertTrue(true);
                                  }
                                  else 
                                  {
                                         Assert.fail("Some wrong link is coming for member id cards");
                                  }
                                  
                                  
                           }
                     else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) 
                                                              
                           {
                                  String s=getTemporaryIdcardlink().getAttribute("href");
                                  if(s.contains("int.uhc.com"))
                                  {
                                         Assert.assertTrue(true);
                                  }
                                  else 
                                  {
                                         Assert.fail("The member id cards link is wrong");
                                  }
                                  
                     
                          } 
                     }
                
                
                /**
                 * @toDo : to verify english as a default language 
                 */
                public void validateEngDefault()
                {	
                	 Select oselect = new Select(languagedropdown);
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
                      Thread.sleep(3000);
                      Select oselect = new Select(languagedropdown);
                      if(oselect.getOptions().contains("SPANISH"))
                      {
                    	  oselect.selectByVisibleText("SPANISH"); 
                          Thread.sleep(3000);
                          System.out.println(oselect.getFirstSelectedOption().getText());
                      }
                      else 
                      {
                    	  System.out.println("only english doc are there");
                      }
               
                     
                }

                           
              public void scroll() {
                                  JavascriptExecutor jse = (JavascriptExecutor)driver;
                                  jse.executeScript("window.scrollBy(0,150)", "");
                                  
                  }
                     public void checkOrderPlanMaterialLinkforterminated(){
                            Assert.assertTrue(!(validate(driver.findElement(By.xpath("(//div[contains(@class,'planBenefitsHeaderParsys')]/div/div[not(contains(@class,'ng-hide')]//*[contains(text(),'ORDER')])[1])")))));
                           
                           
                     }
                     
                     public void checkRenewsectionforterminated(){
                            Assert.assertTrue(!(validate(driver.findElement(By.xpath("//*[contains(text(),'Renew Magazine')]")))));
                     }
                     
                     public void validateshipeob()
                     {
                           WebElement shipeob= driver.findElement(By.xpath("(//*[contains(text(),'Medical EOB')])[7]"));
                validate(shipeob);
                     }
            
                     
                     public String[] verifypdfname()
                     {   
                           java.util.List<WebElement> pdfs = driver.findElements(By.xpath("//div[contains(@class,'plan-material')]//span//li/a"));
                           String[] pdfname=null;
                           for (int i=0;i<pdfs.size();i++)
                           {  
                                   pdfname[i]=pdfs.get(i).getText(); 
                                                
                           }
                           return pdfname;
                     }
                     
                     public void waitforFNRpage()
                     {
                WebDriverWait wait = new WebDriverWait(this.driver, 60);
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                                if (driver.getTitle().contains("Documents Overview"))
                                    return true;
                                else
                                    return false;
                    } }   );

}
                     
             		/**
             		 * @return the Order Plan Material Link
             		 */
             		public boolean checkPOrderPlanMaterialLinkNotAvailable() {
             			try {
             				if(driver.findElement(By.xpath("(*//[contains(text(),'ORDER')])[1])")).isDisplayed()) {
             				System.out.println("Order Plan Material Link link is present");
             				return false;
             				}
             				else {
             				
             			}
             			}
             			catch(Exception e) {
             				System.out.println("Order Plan Material Link link is not present");
             				return true;
             			}
             			return false;
             		}
                     
             		 public WebElement geteobmapdsection()
             		{	
             		
             			 return	driver.findElement(By.xpath("//*[@class='customsegments parbase section']//div[@class='otherPages']//*[@class='explanationbenefits parbase section']//*[contains(text(),'Explanation')]"));
             			
             		}
}