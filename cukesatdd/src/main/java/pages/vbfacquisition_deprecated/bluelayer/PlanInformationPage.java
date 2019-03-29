/**
 * 
 */
package pages.vbfacquisition_deprecated.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PlanInformationPage extends UhcDriver {
                
        @FindBy(id = "enrollment.medicareBeneficiary.hasEndStateRenalDisease2")
        private WebElement noRadioButton;
        
        @FindBy(id = "enrollment.medicareBeneficiary.hasEndStateRenalDisease1")
        private WebElement yesRadioButton;
        
        @FindBy(id = "enrollmentNext")
        private WebElement enrollmentNext;
        
        @FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h3")
        private WebElement pageHeading;
        
        private PageData planInformation;

        public JSONObject planInformationJson;

        public PlanInformationPage(WebDriver driver,String planName) {
                super(driver);
                PageFactory.initElements(driver, this);
                if(planName.contains("HMO"))
                {
                        String fileName = CommonConstants.MA_PLAN_INFORMATION_PAGE_DATA;
                        planInformation = CommonUtility.readPageData(fileName,
                                        CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
                }
                if(planName.contains("PDP"))
                {
                        String fileName = CommonConstants.PDP_PLAN_INFORMATION_PAGE_DATA;
                        planInformation = CommonUtility.readPageData(fileName,
                                        CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
                }
                openAndValidate();
        }

        @Override
        public void openAndValidate() {

                validate(enrollmentNext);
                
                JSONObject jsonObject = new JSONObject();
                for (String key : planInformation.getExpectedData().keySet()) {
                        WebElement element = findElement(planInformation.getExpectedData()
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
                planInformationJson = jsonObject;
                
        }

        public void asnwersESRDQuestion(String answer) {
                if(answer.equalsIgnoreCase("No"))
                {
                        noRadioButton.click();
                }
                else{
                        yesRadioButton.click();
                }
                
        }

        public BeneficiaryInformationPage navigateToNextStep() {
                enrollmentNext.click();

                try {
        			Thread.sleep(30000);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}

                if(pageHeading.getText().contains("Beneficiary Information"))
                {	
                	
                        return new BeneficiaryInformationPage(driver);
                }
                System.out.println("Beneficiary INFO Page not Displayed");
                return null;
                
        }
        
}