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
public class AdditionalInformationPage extends UhcDriver{
        
        @FindBy(id = "enrollmentNext")
        private WebElement enrollmentNext;

        @FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h2")
        private WebElement pageHeading;
        
        private PageData additionalInformation;

        public JSONObject additionalInformationJson;
        
        public AdditionalInformationPage(WebDriver driver, String planName) {
                super(driver);
                PageFactory.initElements(driver, this);
                if (planName.contains("HMO")) {
                        String fileName = CommonConstants.MA_ADDITIONAL_INFORMATION_PAGE_DATA;
                        additionalInformation = CommonUtility.readPageData(fileName,
                                        CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
                }
                if (planName.contains("PDP")) {
                        String fileName = CommonConstants.PDP_ADDITIONAL_INFORMATION_PAGE_DATA;
                        additionalInformation = CommonUtility.readPageData(fileName,
                                        CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
                }

                openAndValidate();
        }
                

        @Override
        public void openAndValidate() {
                
                validate(enrollmentNext);
                JSONObject jsonObject = new JSONObject();
                for (String key : additionalInformation.getExpectedData().keySet()) {
                        WebElement element = findElement(additionalInformation.getExpectedData()
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
                additionalInformationJson = jsonObject;
                
        }


        public ReviewApplicationPage navigatesToNextStep(String planName) {
                enrollmentNext.click();
                if (pageHeading.getText().equalsIgnoreCase(
                                "Step 4: Review Application")) {
                        return new ReviewApplicationPage(driver,planName);
                }
                return null;
                
        }

}