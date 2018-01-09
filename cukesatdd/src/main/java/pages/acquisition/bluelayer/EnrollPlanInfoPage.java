/**
 * 
 */
package pages.acquisition.bluelayer;

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
public class EnrollPlanInfoPage extends UhcDriver{
        
        @FindBy(xpath = "//div[@id='chooseplan']/div/div[3]/div/table/tbody/tr[1]/td[2]")
        private WebElement planName;
        
        @FindBy(xpath = "//div[@id='chooseplan']/div/div[3]/div/table/tbody/tr[2]/td[2]")
        private WebElement zipcode;
        
        @FindBy(xpath = "//div[@id='chooseplan']/div/div[3]/div/table/tbody/tr[3]/td[2]")
        private WebElement premium;
        
        @FindBy(id = "continueEnrollment")
        private WebElement continueEnrollmentButton;
        
        private PageData enrollPlanInfo;

        public JSONObject enrollPlanInfoJson;

        public EnrollPlanInfoPage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(driver, this);
                String fileName = CommonConstants.ENROLL_PLAN_INFO_PAGE_DATA;
                enrollPlanInfo = CommonUtility.readPageData(fileName,
                                CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
                openAndValidate();
        }

        @Override
        public void openAndValidate() {

                validate(continueEnrollmentButton);

                JSONObject jsonObject = new JSONObject();
                for (String key : enrollPlanInfo.getExpectedData().keySet()) {
                        WebElement element = findElement(enrollPlanInfo.getExpectedData()
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
                enrollPlanInfoJson = jsonObject;
                
        }

        public PlanInformationPage continuesEnrollment(String planName) {
                
                continueEnrollmentButton.click();
                if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Plan Enrollment Information | AARP® Medicare Plans from UnitedHealthcare®") || driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plan Enrollment | AARP® Medicare Plans from UnitedHealthcare®") || driver.getTitle().equalsIgnoreCase("Medicare Advantage Plan Enrollment Information | UnitedHealthcare®")){
                        return new PlanInformationPage(driver,planName);
                }
                return null;
                
        }

}