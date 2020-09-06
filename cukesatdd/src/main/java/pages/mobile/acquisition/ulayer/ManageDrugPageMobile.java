/**
* 
 */
package pages.mobile.acquisition.ulayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.member_deprecated.bluelayer.SelectPharmacyPage;

/**
* @author pjaising
*
*/
public class ManageDrugPageMobile extends UhcDriver {

       @FindBy(xpath = "//div[@class='costSavingsDrawer cb']")
       private WebElement switchTogenericButton;

       /*@FindBy(css = "div > img[alt=\"Plus Image\"]")
       WebElement plusSign;*/

      

       @FindBy(linkText = "Reduce costs")
       WebElement reduceCostLink;
       
       @FindBy(linkText = "Switch to generic")
       WebElement switchToGenericLink;

       @FindBy(linkText = "View plan results")
       private WebElement viewPlansLink;

       @FindBy(className = "drugList")
       private List<WebElement> selectedDrug;

       @FindBy(xpath = "//div[@id='dcemodal']/div/div/div[8]/div[4]/a[2]")
       private WebElement pharmacySearchButton;
       
       @FindBy(xpath="//div[@class='delete']/a")
       WebElement drugDelete;
       
       @FindBy(linkText = "Close and apply changes")
       WebElement applyChangesButton;
       
       @FindBy(xpath = "//div[@class='addDrugBox']")
       WebElement adddrugdiv;
       
       @FindBy(xpath="//div[@class='tabsHead']/div[2]")
       WebElement selectPharmacyTab;
       
       @FindBy(linkText = "Close and apply changes")
       private WebElement closeAndApplyChangesLink;

       
       @FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/div/div/div/div/div[7]/form/div[2]/span[3]/p/span")
       private WebElement expectedTooltip;
       
       @FindBy(xpath = "//span[@class='tooltipalign']/p/span")
       private WebElement addtooltip;

       public JSONObject manageDrugJson;

       private PageData drugInfo;

       private PageData manageDrug;

       public ManageDrugPageMobile(WebDriver driver) {
              super(driver);
              PageFactory.initElements(driver, this);
              String manageDrugFile = CommonConstants.MANAGE_DRUG_PAGE_DATA;
              manageDrug = CommonUtility.readPageData(manageDrugFile,
                           CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
              if (!selectedDrug.isEmpty()) {
                     String drugInfoFile = CommonConstants.SELECTED_DRUG_INFORMATION_PAGE_DATA;
                     drugInfo = CommonUtility.readPageData(drugInfoFile,
                                  CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
              }
              openAndValidate();

       }


       public SelectPharmacyPage navigateToPharmacyPage() {
              pharmacySearchButton.click();
              try {
                     if (pharmacySearchButton.isDisplayed()) {
                           CommonUtility.waitForElementToDisappear(driver,
                                         pharmacySearchButton, CommonConstants.TIMEOUT_30);
                     }
              } catch (NoSuchElementException e) {
                     System.out.println("pharmacySearchButton not found");
              } catch (TimeoutException ex) {
                     System.out.println("pharmacySearchButton not found");
              } catch (Exception e) {
                     System.out.println("pharmacySearchButton not found");
              }

              if (currentUrl().contains("selectPharmacy")) {
                     return new SelectPharmacyPage(driver);
              } else {
                     return null;
              }

       }

       public VPPPlanSummaryPageMobile navigateToPlanSummaryPage() {

              viewPlansLink.click();
              try {
                     if (viewPlansLink.isDisplayed()) {
                           CommonUtility.waitForElementToDisappear(driver, viewPlansLink,
                                         CommonConstants.TIMEOUT_30);
                     }
              } catch (NoSuchElementException e) {
                     System.out.println("viewPlansLink not found");
              } catch (TimeoutException ex) {
                     System.out.println("viewPlansLink not found");
              } catch (Exception e) {
                     System.out.println("viewPlansLink not found");
              }
              if (currentUrl().contains("health-plans.html")) {
                     return new VPPPlanSummaryPageMobile(driver);
              } else {
                     return null;
              }

       }

       public ManageDrugPageMobile reduceSelectedDrugCost() {
              reduceCostLink.click();

              try {
                     if (reduceCostLink.isDisplayed()) {
                           CommonUtility.waitForElementToDisappear(driver, reduceCostLink,
                                         CommonConstants.TIMEOUT_30);

                     }
              } catch (NoSuchElementException e) {
                     System.out.println("reduceCostLink not found");
              } catch (TimeoutException ex) {
                     System.out.println("reduceCostLink not found");
              } catch (Exception e) {
                     System.out.println("reduceCostLink not found");
              }
              if (currentUrl().contains("manageDrugList")) {
                     return new ManageDrugPageMobile(driver);
              } else {
                     return null;
              }
       }

       public ManageDrugPageMobile reduceCostForADrug(String drugName, String quantity, String frequency) {
              String selectedDrugName = drugName+"\n"+"Qty "+quantity+" "+frequency;
              ElementData elementData = new ElementData("id","branded");
              for(WebElement drug: selectedDrug)
              {
                     WebElement selectedDrug = findChildElement(elementData, drug);
                     if(selectedDrugName.equalsIgnoreCase(selectedDrug.getText()))
                     {
                           ElementData reduceCostElementData = new ElementData("linkText","Reduce Costs");
                           WebElement reduceCostLink = findChildElement(reduceCostElementData, drug);
                           reduceCostLink.click();
                     }
              }
              try {
                     if (reduceCostLink.isDisplayed()) {
                           CommonUtility.waitForElementToDisappear(driver, reduceCostLink,
                                         CommonConstants.TIMEOUT_30);

                     }
              } catch (NoSuchElementException e) {
                     System.out.println("reduceCostLink not found");
              } catch (TimeoutException ex) {
                     System.out.println("reduceCostLink not found");
              } catch (Exception e) {
                     System.out.println("reduceCostLink not found");
              }
              if (currentUrl().contains("manageDrugList")) {
                     return new ManageDrugPageMobile(driver);
              } else {
                     return null;
              }

       }

       public void switchToGeneric() {
              switchTogenericButton.findElement(By.linkText("Switch to generic"))
                           .click();
              System.out.println();
       }

       public Object applieschanges(String planType) {
              applyChangesButton.click();
              try {
                     if (applyChangesButton.isDisplayed()) {
                           CommonUtility.waitForElementToDisappear(driver, applyChangesButton,
                                         CommonConstants.TIMEOUT_30);
                     }
              } catch (NoSuchElementException e) {
                     System.out.println("applyChangesButton not found");
              } catch (TimeoutException ex) {
                     System.out.println("applyChangesButton not found");
              } catch (Exception e) {
                     System.out.println("applyChangesButton not found");
              }
              if (currentUrl().contains("health-plans.html")) {
                     return new VPPPlanSummaryPageMobile(driver);
              }
              /*if (currentUrl().contains("plan-detail.html")) {
                     return new PlanDetailsPage(driver,planType);
              }*/
              
              
              return null;

       
       }
	   
	   public VPPPlanSummaryPageMobile closeAndApplychanges() {
    applyChangesButton.click();
    try {
        if (applyChangesButton.isDisplayed()) {
            CommonUtility.waitForElementToDisappear(driver, applyChangesButton,
                    CommonConstants.TIMEOUT_30);
        }
    } catch (NoSuchElementException e) {
        System.out.println("applyChangesButton not found");
    } catch (TimeoutException ex) {
        System.out.println("applyChangesButton not found");
    } catch (Exception e) {
        System.out.println("applyChangesButton not found");
    }
    if (driver.getTitle().contains("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
        return new VPPPlanSummaryPageMobile(driver);
    }
        
        return null;
    }

       public JSONObject getExpectedData(String fileName, String directory) {
              JSONObject drugsAddedExpectedJson = MRScenario.readExpectedJson(
                           fileName, directory);
              return drugsAddedExpectedJson;

       }

       @Override
       public void openAndValidate() {
              //validate(plusSign);

              if (!selectedDrug.isEmpty()) {
                     JSONObject jsonObject = new JSONObject();
                     for (String key : manageDrug.getExpectedData().keySet()) {
                           List<WebElement> elements = findElements(manageDrug
                                         .getExpectedData().get(key));
                           if (elements.equals(selectedDrug)) {
                                  JSONArray drugInforJsonArray = new JSONArray();
                                  if (elements.size() == 1) {
                                         if (validate(elements.get(0))) {
                                                JSONObject drugInforObject = new JSONObject();
                                                for (String drugInfoKey : drugInfo
                                                              .getExpectedData().keySet()) {
                                                       WebElement drugInforElement = findChildElement(
                                                                     drugInfo.getExpectedData().get(
                                                                                  drugInfoKey), elements.get(0));
                                                       if (validate(drugInforElement)) {
                                                              try {
                                                                     drugInforObject.put(drugInfoKey,
                                                                                  drugInforElement.getText());
                                                              } catch (JSONException e) {
                                                                     // TODO Auto-generated catch block
                                                                     e.printStackTrace();
                                                              }
                                                       }
                                                }
                                                drugInforJsonArray.put(drugInforObject);
                                                try {
                                                       jsonObject.put(key, drugInforJsonArray);
                                                } catch (JSONException e) {
                                                       // TODO Auto-generated catch block
                                                       e.printStackTrace();
                                                }
                                         }
                                  } else if (elements.size() > 1) {
                                         for (WebElement element : elements) {
                                                if (validate(element)) {
                                                       JSONObject drugInforObject = new JSONObject();
                                                       for (String drugInfoKey : drugInfo
                                                                     .getExpectedData().keySet()) {
                                                              WebElement drugInforElement = findChildElement(
                                                                           drugInfo.getExpectedData().get(
                                                                                         drugInfoKey), element);
                                                              if (validate(drugInforElement)) {
                                                                     try {
                                                                            drugInforObject.put(drugInfoKey,
                                                                                         drugInforElement.getText());
                                                                     } catch (JSONException e) {
                                                                           // TODO Auto-generated catch block
                                                                           e.printStackTrace();
                                                                     }
                                                              }
                                                       }
                                                       drugInforJsonArray.put(drugInforObject);
                                                }
                                         }
                                         try {
                                                jsonObject.put(key, drugInforJsonArray);
                                         } catch (JSONException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                         }
                                  }
                           } else {
                                  if (elements.size() == 1) {
                                         if (validate(elements.get(0))) {
                                                try {
                                                       jsonObject.put(key, elements.get(0).getText());
                                                } catch (JSONException e) {
                                                       // TODO Auto-generated catch block
                                                       e.printStackTrace();
                                                }
                                         }
                                  } else if (elements.size() > 1) {
                                         JSONArray jsonArray = new JSONArray();
                                         for (WebElement element : elements) {

                                                if (validate(element)) {
                                                       try {
                                                              JSONObject jsonObjectForArray = new JSONObject();
                                                              jsonObjectForArray.put(manageDrug
                                                                           .getExpectedData().get(key)
                                                                           .getElementName(),
                                                                           element.getText());
                                                              jsonArray.put(jsonObjectForArray);
                                                       } catch (JSONException e) {
                                                              // TODO Auto-generated catch block
                                                              e.printStackTrace();
                                                       }
                                                }
                                         }
                                         try {
                                                jsonObject.put(key, jsonArray);
                                         } catch (JSONException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                         }

                                  }

                           }

                     }
                     manageDrugJson = jsonObject;
                     System.out.println("manageDrugJson with selected drug info----->"
                                  + manageDrugJson);
              }

       }

       public ManageDrugPageMobile switchToGeneric(String drugDosage, String quantity,
                     String drugFrequency) {
              String selectedDrugName = drugDosage+"\n"+"Qty "+quantity+" "+drugFrequency;
              ElementData elementData = new ElementData("id","branded");
              for(WebElement drug: selectedDrug)
              {
                     WebElement selectedDrug = findChildElement(elementData, drug);
                     if(selectedDrugName.equalsIgnoreCase(selectedDrug.getText()))
                     {
                           ElementData switchToGenericElementData = new ElementData("linkText","Switch to generic");
                           WebElement switchToGenericLink = findChildElement(switchToGenericElementData, drug);
                           switchToGenericLink.click();
                     }
              }
              
              try {
                     if (switchToGenericLink.isDisplayed()) {
                           CommonUtility.waitForElementToDisappear(driver, switchToGenericLink,
                                         CommonConstants.TIMEOUT_30);

                     }
              } catch (NoSuchElementException e) {
                     System.out.println("switchToGenericLink not found");
              } catch (TimeoutException ex) {
                     System.out.println("switchToGenericLink not found");
              } catch (Exception e) {
                     System.out.println("switchToGenericLink not found");
              }
              if (currentUrl().contains("manageDrugList")) {
                     return new ManageDrugPageMobile(driver);
              } else {
                     return null;
              }
       }
       
       public AddDrugPageMobile addDrugFlowCheck() {         
              drugDelete.click();
              if(currentUrl().contains("drugSearch"))
              {
                     return new AddDrugPageMobile(driver);
              }             
              
              return null;
       }
       
       public void clickAddImage() {       
        validate(adddrugdiv);
        adddrugdiv.click();
       }
       
       
       /*
       * TODO: CodeMonkeys Team: The below two methods can be combined and such that clicking on the pharmacy tab and returning 
        * 
        * 
        * select pharmacy page/screen can be done in a single method, which will make it similar to other methods written 
        * 
        * in the framework for navigation
       * 
        * */
       public void swithedToSelectPharmacyTab(){
              selectPharmacyTab.click();
       }
       
       public SelectPharmacyPage navigateToUpdatedPharmacyPage() {
              if (currentUrl().contains("selectPharmacy")) {
                     return new SelectPharmacyPage(driver);
              } else {
                     return null;
              }

       }

       /*End of TODO: CodeMonkeys Team*/
       
       public void toolTipValidation() {
              try {
                     Thread.sleep(5000);
              } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
              validate(expectedTooltip);
              validate(addtooltip);
              System.out.println("Tool tips validated");
       }


       public VPPPlanSummaryPageMobile applieschanges() {
              closeAndApplyChangesLink.click();
              try {
                     if (closeAndApplyChangesLink.isDisplayed()) {
                           CommonUtility.waitForElementToDisappear(driver, closeAndApplyChangesLink,
                                         CommonConstants.TIMEOUT_30);
                     }
              } catch (NoSuchElementException e) {
                     System.out.println("closeAndApplyChangesLink not found");
              } catch (TimeoutException ex) {
                     System.out.println("closeAndApplyChangesLink not found");
              } catch (Exception e) {
                     System.out.println("closeAndApplyChangesLink not found");
              }
              if (currentUrl().contains("health-plans.html")) {
                     return new VPPPlanSummaryPageMobile(driver);
              }             
              return null;

       }




}
