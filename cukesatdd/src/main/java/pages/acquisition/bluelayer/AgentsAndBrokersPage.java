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

import pages.acquisition.bluelayer.GlobalFooterWebElements;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

/**
 * @author saduri
 *
 */
public class AgentsAndBrokersPage extends GlobalFooterWebElements{
	
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
		validate(agentsAndBrokersTable);
		validate(agentsAndBrokersTitle);
		
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
		if(validate(element)){
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
	footerHomeLink.click();
	if (driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare�")) {
	return new AcquisitionHomePage(driver);
	}
	return null;
	}

}
