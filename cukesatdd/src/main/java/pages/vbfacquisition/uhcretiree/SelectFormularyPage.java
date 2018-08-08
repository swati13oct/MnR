package pages.vbfacquisition.uhcretiree;

/*@author eb*/

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;


public class SelectFormularyPage extends UhcDriver {
	
	private PageData formularyList;

	public JSONObject formularyListJson;
	
	public JSONObject browserCheckJson;
	private PageData browserCheckData;
	

	@FindBy(xpath = "//*[@id='main']/div/div[1]/div/div[3]/div[1]/div[1]/ul/li[1]/a")
	private WebElement specificDrugLink;

	public SelectFormularyPage(WebDriver driver) {
		 super(driver);
	       PageFactory.initElements(driver, this);
	       String fileName = CommonConstants.SELECT_FORMULARY_PAGE_DATA;
			formularyList = CommonUtility.readPageData(fileName,
					CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);
	       openAndValidate();
	}


	@Override
	public void openAndValidate() {
		validate(specificDrugLink);
		

		JSONObject jsonObject = new JSONObject();
		for (String key : formularyList.getExpectedData().keySet()) {
			WebElement element = findElement(formularyList.getExpectedData()
					.get(key));
			if (null != element) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		formularyListJson = jsonObject;
	}
	
	public EnterDrugPage specificDrugFLowLink(String drugName) {
		driver.findElement(By.linkText(drugName)).click();
		if (driver.findElement(By.className("newsearch_h2")).getText()
				.equalsIgnoreCase(
						"Enter drug name")) {
			return new EnterDrugPage(driver, false, drugName);
		}
		return null;
	}
	
	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.GR_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);
		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
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
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}

}
