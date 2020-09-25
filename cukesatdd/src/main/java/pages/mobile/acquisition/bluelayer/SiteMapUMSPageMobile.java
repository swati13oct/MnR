/**
 * 
 */
package pages.mobile.acquisition.bluelayer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.Rallytool_Page;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class SiteMapUMSPageMobile extends UhcDriver{
	
	@FindBy(className = "med_cont")
	private WebElement siteMapTable;
	
	@FindBy(id = "medicareTitle")
	private WebElement medicareTitle;

	@FindBy(id="PO7link")
	private WebElement SearchforaProviderFacility ;
	
	
	private PageData siteMap;

	public JSONObject siteMapJson;
	
	 
	@FindBy(xpath = "//div[@id='medicareTitle']/*")
	public static WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'med_cont')]/ul[contains(@class,'bullet_list')]/li")
	public static List<WebElement> siteMapList;
	
	public SiteMapUMSPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(siteMapList.get(0));	
		
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



public Rallytool_Page lookupproviderclick() {
	validate(SearchforaProviderFacility);
	SearchforaProviderFacility.click();
	ArrayList<String> tabs = new ArrayList<String>(
			driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
	if (getTitle().equalsIgnoreCase(
					"Enter Zip")) {
		return new Rallytool_Page(driver);
	}
	
	// TODO Auto-generated method stub
	return null;
} 

}


