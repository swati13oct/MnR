package pages.dashboard.formsandresources;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

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

                /** Medical button in EOB section - Forms And Resources page */
                @FindBy(id = "medicalEOB")
                private WebElement eobMedicalButton;

                /** Drug button in EOB section */
                @FindBy(id = "drugEOB")
                private WebElement eobDrugButton;
                
                /** Renew Magazine Section - Forms And Resources page */
                @FindBy(id = "renew-magazine-callout")
                private WebElement renewMagazineSection;
                
                /** My DocumentSection - Forms And Resources page */
                @FindBy(id = "my-document-callout")
                private WebElement myDocumentSection;
                
                /** Plan Material Section**/
                
                @FindBy(xpath = "//*[contains(text(),'Plan Materials')]")
                private WebElement PlanMaterialSection;

                @FindBy(xpath = " //*[contains(text(),'VIEW MEMBER ID CARD')]")
                private WebElement MemberIdCardlink;
                
                @FindBy(xpath = " //*[contains(text(),'ORDER PLAN MATERIALS')]")
                private WebElement OrderPlanMaterialLink;
                       
                WebElement languagedropdown = driver.findElement(By.id("lang-select-2"));
                Select oselect = new Select(languagedropdown);

            /**Anoc Section**/
                @FindBy(xpath ="//*[contains(text(),'Annual Notice of Changes Documents')]")
                private WebElement AnocSection; 
                
            /** Annual Directories Section**/
                @FindBy(xpath ="(//*[contains(text(),'Annual Directories')])[2]")
                private WebElement AnnualDirectorySection;
                
                /*Provider Search Link*/
                @FindBy(xpath ="(//*[contains(text(),'Provider Search')])[1]")
                private WebElement ProviderSearchLink;
                
                /*Pharmacy Locator Link*/
                @FindBy(xpath ="(//*[contains(text(),'Pharmacy Locator')])[2]")
                private WebElement PharmacyLocatorLink;
                
            
                /**Forms and Resources section**/    
                @FindBy(xpath = "(//*[contains(text(),'Forms and Resources')])[4]")
                private WebElement FormsnResources;
                
                
                
                public FormsAndResourcesPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                                openAndValidate();
                }

                @Override
                public void openAndValidate() {
                                start(MRConstants.UHCM_MEMBER_URL);

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
                     String expectedURL ="https://stage-medicare.uhc.com/content/medicare/member/order-materials/overview.html";
                     String actualURL=driver.getCurrentUrl();
                    Assert.assertEquals(expectedURL, actualURL);
                     driver.navigate().back();
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
                     String expectedURL ="https://member.int.uhc.com/aarp/dashboard/modal/id-cards";
                     String actualURL=driver.getCurrentUrl();
                    Assert.assertEquals(expectedURL, actualURL);
                     driver.navigate().back();
                }   
                /**
                 * @toDo : to verify english as a default language 
                 */
                public void validateEngDefault()
                {
                     if(oselect.getFirstSelectedOption().getText()=="ENGLISH")
                     {
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
                     oselect.selectByValue("SPANISH");
                     Thread.sleep(3000);
                  System.out.println(oselect.getFirstSelectedOption().getText());
                     
                }
                
                
                
}

