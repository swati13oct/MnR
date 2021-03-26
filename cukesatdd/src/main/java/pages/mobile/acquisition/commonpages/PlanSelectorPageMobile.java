/**
 * 
 */
package pages.mobile.acquisition.ulayer;


import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;

/**
 * @author rkodumur
 *
 */
public class PlanSelectorPageMobile extends GlobalWebElements{
	
	
	@FindBy(xpath = "//article[@id='criteria']/header/div[1]/h2")
	private WebElement planselectorpage;

	public  JSONObject planselectorJson;

	private PageData planselector;

	public PlanSelectorPageMobile(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	try {
	Thread.sleep(8000);
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	switchToNewIframe("baseFrame");
	String fileName = CommonConstants.PLAN_SELECTOR_PAGE_DATA;
	planselector = CommonUtility.readPageData(fileName,
	CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
	openAndValidate();
	}
	public Boolean validate_textField() {
		ourPlansHover();
		validate(zipcodeField);
		zipcodeField.click();
		zipcodeField.sendKeys("90210");
		String zip = zipcodeField.getAttribute("value");
		if(zip.equalsIgnoreCase("90210")){
			return true;
		}
		return false;
		
	}
    @Override
    public void openAndValidate() {
           validate(planselectorpage);
           JSONObject jsonObject = new JSONObject();
           for (String key : planselector.getExpectedData().keySet()) {
                  WebElement element = findElement(planselector.getExpectedData().get(key));
                  if (null != element) {
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
           planselectorJson = jsonObject;
    }

		
}
