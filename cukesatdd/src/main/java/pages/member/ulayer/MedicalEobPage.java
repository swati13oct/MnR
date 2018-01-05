/**
 * 
 */
package pages.member.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class MedicalEobPage extends UhcDriver{
        
        @FindBy(id = "eobMonthDateRange")
        private WebElement eobMonthDateRange;
        
        @FindBy(className = "shipbtnEobHistory")
        private WebElement shipbtnEobHistory;
        
        @FindBy(id = "eobtable")
        private WebElement eobtable;
                        
        private PageData medicalEob;

        public JSONObject medicalEobJson;

        public MedicalEobPage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(driver, this);
                String fileName = CommonConstants.MEDICAL_EOB_PAGE_DATA;
                medicalEob = CommonUtility.readPageData(fileName,
                                CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
                //openAndValidate();
        }

        public MedicalEobPage searchesMedicalEob(String dateRange) {
                
                eobMonthDateRange.click();
                eobMonthDateRange.sendKeys(dateRange);
                
                shipbtnEobHistory.click();
                try {
                        Thread.sleep(3000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                if (currentUrl().contains("medical-eob-search.html")) {
                        return new MedicalEobPage(driver);
                }
                return null;
                
        }

        public String getMedicalEobContent() {
                return eobtable.getText();
        }

        public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
                JSONObject globalExpectedJson = expectedDataMap
                                .get(CommonConstants.GLOBAL);
                JSONObject medicalEobExpectedJson = expectedDataMap
                                .get(CommonConstants.MEDICAL_EOB);
                medicalEobExpectedJson = CommonUtility.mergeJson(
                                medicalEobExpectedJson, globalExpectedJson);
                return medicalEobExpectedJson;
        }

        @Override
        public void openAndValidate() {
                JSONObject jsonObject = new JSONObject();
                for (String key : medicalEob.getExpectedData().keySet()) {
                        WebElement element = findElement(medicalEob.getExpectedData()
                                        .get(key));
                        if (element != null) {
                                validate(element);
                                try {
                                        jsonObject.put(key, element.getText());
                                } catch (JSONException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                        }
                }
                medicalEobJson = jsonObject;
                
                System.out.println("medicalEobJson----->"+medicalEobJson);
        }
        @FindBy(xpath = ".//*[@id='eobSearchForm']/div[2]/div/div[3]")
        private WebElement eobTable;
        
        public boolean validateEob(){
                if(eobTable.getText().contains("EOB Date")&&eobTable.getText().contains("My EOB Statements")&&
                                eobTable.getText().contains("Download EOB (PDF)"))
                        return true;
                else
                        return false;
        }
}
