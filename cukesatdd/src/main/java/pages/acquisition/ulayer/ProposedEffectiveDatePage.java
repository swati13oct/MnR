package pages.acquisition.ulayer;

import java.util.Map;

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

public class ProposedEffectiveDatePage extends UhcDriver{
	
	@FindBy(id = "proposedsavncnt")
	private WebElement saveAndContinue;
	
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-10']/div[1]/div/div[1]")
	private WebElement segmentHeading;
	
	
	private PageData ped;

	public JSONObject pedJson;

	public ProposedEffectiveDatePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PED_PAGE_DATA;
		ped = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		//PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		validate(saveAndContinue);
		
		
		JSONObject jsonObject = new JSONObject();
		for (String key : ped.getExpectedData().keySet()) {
			WebElement element = findElement(ped.getExpectedData()
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
		pedJson = jsonObject;
		
	}
	
	public void selectTheDate(Map<String, String> pedAttributesMap) {
		String Date = pedAttributesMap.get("EffectiveDate");
		String newDate = Date.replace("-","/");
		
		driver.findElement(By.xpath("//label[text() = '" + newDate + "']")).click();
	}
	
	public ReviewAndSubmitPage clickOnSaveAndContinue(String plantype){
		//if(segmentHeading.getText().contains("Proposed Effective Date")){
			saveAndContinue.click();
			try {
				  Thread.sleep(10000);
				} catch (InterruptedException ie) {
				    //Handle exception
				}
			
			return new ReviewAndSubmitPage(driver,plantype);	
		//}
		//return null;
	}
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-10']/div[1]/div/div[2]/fieldset/span/label")
	private WebElement dateRadioBtn;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-10']/div[2]/a[2]")
	private WebElement pedPrevBtn;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-10']/div[2]/a[3]")
	private WebElement pedCancelBtn;
	
	public boolean validateEffectiveDatePage(){
		boolean flag = false;
		if(validate(segmentHeading)&&validate(saveAndContinue)&&validate(dateRadioBtn)&&
		validate(pedPrevBtn)&&validate(pedCancelBtn))
			flag = true;
		return flag;
	}
	
}

