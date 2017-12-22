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
public class PlanInformationPage extends UhcDriver {
                
        @FindBy(id = "enrollment.medicareBeneficiary.hasEndStateRenalDisease2")
        private WebElement noRadioButton;
        
        @FindBy(id = "enrollment.medicareBeneficiary.hasEndStateRenalDisease1")
        private WebElement yesRadioButton;
        
        @FindBy(id = "enrollmentNext")
        private WebElement enrollmentNext;
        
        @FindBy(xpath = ".//*[@id='enrollmentMAForm']/h3")
        private WebElement pageHeading;
        
        private PageData planInformation;

        public JSONObject planInformationJson;

        public PlanInformationPage(WebDriver driver,String planName) {
                super(driver);
                PageFactory.initElements(driver, this);
                if(planName.contains("HMO") || planName.contains("PPO") )
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
                //openAndValidate();
        }

        @Override
        public void openAndValidate() {

                validate(noRadioButton);
                validate(yesRadioButton);
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
                if(pageHeading.getText().equalsIgnoreCase("Step2: Beneficiary Information"))
                {
                        return new BeneficiaryInformationPage(driver);
                }
                return null;
                
        }
        
}