package pages.acquisition.uhcretiree;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class GroupHomePage extends UhcDriver { 
	
	//@FindBy(id = "cq-imagebutton-jsp-/content/gr/en/asrs/right_column/jcr:content/parsys/titledtext_0/parsys/events/parsys/imagebutton")
	//private WebElement signInOrRegisterbtn;
	
	private String groupName;


	@Override
	public void openAndValidate() {

	//	start(UHCRETIREE_ACQISITION_PAGE_URL);

	}


	public JSONObject browserCheckJson;
	private PageData browserCheckData;


	public GroupHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
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
	
	public void validateSignInOrRegisterbtn(){
		//Assert.assertTrue("signInOrRegisterbtn is not displayed in group page",signInOrRegisterbtn.isDisplayed());
	}
	
	public void clickSignInOrRegisterbtn(){
		String groupname = getGroupName().toLowerCase();
		WebElement signInOrRegisterbtn = driver.findElement(By.id("cq-imagebutton-jsp-/content/gr/en/"+groupname+"/right_column/jcr:content/parsys/titledtext_0/parsys/events/parsys/imagebutton"));
		signInOrRegisterbtn.click();
		if(driver.getCurrentUrl().contains("medicare.uhc.com")){
			Assert.assertTrue(true);
		}else{
			Assert.assertFalse("Signin Or Registration button is not redirected to HSID",true);
		}
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	



}