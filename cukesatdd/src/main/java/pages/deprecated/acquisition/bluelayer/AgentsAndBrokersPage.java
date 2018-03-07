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
import pages.deprecated.acquisition.bluelayer.GlobalWebElements;

/**
 * @author saduri
 *
 */
public class AgentsAndBrokersPage extends GlobalWebElements{

	@FindBy(className = "med_cont")
	private WebElement agentsAndBrokersTable;

	@FindBy(id = "medicareTitle")
	private WebElement agentsAndBrokersTitle;

	private PageData agentsAndBrokers;

	public JSONObject agentsAndBrokersJson;



	public AgentsAndBrokersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(agentsAndBrokersTable);
		validateNew(agentsAndBrokersTitle);

	}

	public JSONObject agentsAndBrokers() {

		String fileName = CommonConstants.AGENTS_AND_BROKERS_PAGE_DATA;
		agentsAndBrokers = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : agentsAndBrokers.getExpectedData().keySet()) {
			WebElement element = findElement(agentsAndBrokers.getExpectedData()
					.get(key));
			if (element != null) {
				if(validateNew(element)){
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		agentsAndBrokersJson = jsonObject;


		return agentsAndBrokersJson;

	}
	public AcquisitionHomePage homeFooterClick() {
		validateNew(footerHomeLink);
		footerHomeLink.click();
		validateNew(footerHomeLink);
		if (driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}
	
	public boolean validatHomeLink(){
		boolean flag = true;
		
		if(!footerHomeLink.isDisplayed())
			flag = false;
		
		return flag;
	}

}
