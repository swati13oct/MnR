/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class SiteMapUMSPage extends UhcDriver{
	
	@FindBy(className = "med_cont")
	private WebElement siteMapTable;
	
	@FindBy(id = "medicareTitle")
	private WebElement medicareTitle;
	
	@FindBy(id = "gf_lnk_4")
	private WebElement privacyPolicyLink;
	
	@FindBy(id = "gf_lnk_2") 
	private WebElement aboutUsLink;
	
	
	private PageData siteMap;

	public JSONObject siteMapJson;
	
	
	
	public SiteMapUMSPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	

	@Override
	public void openAndValidate() {
		
		validate(siteMapTable);
		validate(medicareTitle);
		
		
		
	}
	
public JSONObject siteMap() {
		
		String fileName = CommonConstants.SITE_MAP_PAGE_DATA;
		siteMap = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : siteMap.getExpectedData().keySet()) {
		WebElement element = findElement(siteMap.getExpectedData()
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
		siteMapJson = jsonObject;
		
		
		return siteMapJson;
		
	}

public AboutUsPage aboutUsClick() {
	aboutUsLink.click();
	if(driver.getTitle().equalsIgnoreCase("About UnitedHealthcare® | UnitedHealthcare")){
		return new AboutUsPage(driver);
	}
	return null;
		
	}



}
