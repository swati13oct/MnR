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
 * @author saduri
 *
 */
public class AboutUsPage extends UhcDriver{
	
	
	private PageData aboutUs;

	public JSONObject aboutUsJson;
	
	@FindBy(id = "medicareTitle")
	private WebElement aboutUsTitle;
	
	@FindBy(className = "med_cont")
	private WebElement aboutUsTable;
	
	@FindBy(id = "gf_lnk_3")
	private WebElement contactUsLink;

	public AboutUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
public JSONObject aboutUs() {
		
		String fileName = CommonConstants.ABOUT_US_PAGE_DATA;
		aboutUs = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : aboutUs.getExpectedData().keySet()) {
		WebElement element = findElement(aboutUs.getExpectedData()
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
		aboutUsJson = jsonObject;
		
		
		return aboutUsJson;
		
	}

public ContactUsUmsPage contactUsClick() {
	validateNew(contactUsLink);
	contactUsLink.click();
	validateNew(contactUsLink);
	if(driver.getTitle().equalsIgnoreCase("Contact UnitedHealthcare® | UnitedHealthcare")){
		return new ContactUsUmsPage(driver);
	}
	return null;
		
	}
	

	@Override
	public void openAndValidate() {
		validateNew(aboutUsTitle);
		validateNew(aboutUsTable);
		validateNew(contactUsLink);
		
		
	}

}
