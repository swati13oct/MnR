package pages.acquisition.uhcretiree;

/*@author eb*/

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;


public class SelectFormularyPage extends UhcDriver {
	
	private PageData formularyList;

	public JSONObject formularyListJson;
	

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
	
	

}
