package pages.memberrdesignVBF;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class SavingsOppurtunity extends UhcDriver {

	private PageData switchgeneric;

	private JSONObject switchgenericJson;

	@FindBy(id = "drug-alt-search-button")
	public WebElement continueButton;

	@FindBy(id = "save-drug-button")
	public WebElement savedrugbutton;

	@FindBy(xpath = ".//*[@id='popup4']/header/span[contains(text(),'Save')]")
	public WebElement SwitchGenericPage;

	@FindBy(className = "loading-dialog")
	public List<WebElement> loadingImages;

	@FindBy(xpath = ".//*[@id='generic-check']/div[1]")
	public List<WebElement> generic;

	public SavingsOppurtunity(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoadNew(driver, SwitchGenericPage, 10);
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : switchgeneric.getExpectedData().keySet()) {
			WebElement element = findElement(switchgeneric.getExpectedData().get(key));
			validateNew(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		switchgenericJson = jsonObject;

		System.out.println("addnewdrugJson----->" + switchgenericJson);
	}

/***
 * 
 * @throws InterruptedException
 */
	public void savedrugbutton() throws InterruptedException {
		if (!(loadingImages.isEmpty())) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 15);
		}
		validateNew(savedrugbutton);
		savedrugbutton.click();
		if (!(loadingImages.isEmpty())) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 60);
		}
	}

}
