/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

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
public class SubmitApplicationPage extends UhcDriver{
        
        @FindBy(id = "medicareTitle")
        private WebElement pageHeading;
        
        @FindBy(id = "enrollmentNext")
        private WebElement submitApplicationButton;
        
        @FindBy(id = "enrollment.relationshipToEnrolleeInfo.self1")
        private WebElement applicantOption;
        
        @FindBy(id = "enrollment.souAccepted1")
        private WebElement agreeRadioButton;
        
        private PageData submitApplication;

        public JSONObject submitApplicationJson;


        public SubmitApplicationPage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(driver, this);
                String fileName = CommonConstants.SUBMIT_APPLICATION_PAGE_DATA;
                submitApplication = CommonUtility.readPageData(fileName,
                                CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
                
                openAndValidate();
                
        }        
        
        public boolean validateSubmitApplicationPage(JSONObject actualJson, String planName, String zipCountyInfo){
        	boolean flag = true;
        	
        	try {
				if(!actualJson.get("planName").toString().contains(planName))
					flag = false;
				if(!actualJson.get("zipCountyInfo").toString().contains(zipCountyInfo))
					flag = false;
				if(!actualJson.get("premium").toString().contains("$"))
					flag = false;
				if(!actualJson.get("authorizedRepresentativeHeader").toString().contains("Statement of Understanding"))
					flag = false;
				if(!actualJson.get("statementOfUnderstandingHeader").toString().contains("Submit Application"))
					flag = false;
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	return flag;
        }

        @Override
        public void openAndValidate() {

                validateNew(applicantOption);
                validateNew(agreeRadioButton);
                validateNew(submitApplicationButton);
                
                JSONObject jsonObject = new JSONObject();
                for (String key : submitApplication.getExpectedData().keySet()) {
                        WebElement element = findElement(submitApplication.getExpectedData()
                                        .get(key));
                        if (element != null) {
                                if (validateNew(element)) {
                                        try {
                                                jsonObject.put(key, element.getText());
                                        } catch (JSONException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                }
                        }

                }
                submitApplicationJson = jsonObject;
                
        }

        public void selectsAsApplicant() {
                applicantOption.click();
        }
        
        public EnrollmentConfirmationPage submitsApplication() {
                agreeRadioButton.click();
                submitApplicationButton.click();
                if (pageHeading.getText().equalsIgnoreCase(
                                "Enrollment Application Confirmation")) {
                        return new EnrollmentConfirmationPage(driver);
                }
                return null;
                
        }
        
}