package pages.vbfacquisition.ulayer;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.PageData;
import atdd.framework.UhcDriver;
public class SavingsOppurtunity extends UhcDriver{
	
	private PageData switchgeneric;

	public JSONObject switchgenericJson;
	

	@FindBy(id="drug-alt-search-button")
	public WebElement continueButton;
	
	@FindBy(id="save-drug-button")
	public WebElement savedrugbutton;
	
	@FindBy(xpath=".//*[@id='popup4']/header/span[contains(text(),' SAVINGS OPPORTUNITY')]")
	public WebElement SwitchGenericPage;
	
	
	public SavingsOppurtunity(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
		//openAndValidate();
	}
	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : switchgeneric.getExpectedData().keySet()) {
			WebElement element = findElement(switchgeneric.getExpectedData()
					.get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		switchgenericJson = jsonObject;

		System.out.println("addnewdrugJson----->" + switchgenericJson);
	}
	
	public void savedrugbutton() throws InterruptedException {
		Thread.sleep(10000);
		waitforElement(savedrugbutton);
		savedrugbutton.click();
		Thread.sleep(15000);
		// TODO Auto-generated method stub
		
	}
	
	public void switchToGeneric() throws InterruptedException {

		List<WebElement> generic = driver.findElements(By.xpath(".//*[@id='generic-check']/div[1]"));
		generic.get(0).click();
		Thread.sleep(3000);
	}
}
