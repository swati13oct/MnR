package pages.acquisition.commonpages;

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

public class ConfirmationPage extends UhcDriver{

	@FindBy(xpath = "//*[@id='confirmationView']/div/div[2]/div/div[2]/a")
	private WebElement printThisPage;

	@FindBy(xpath = "html/body/div[1]/div[2]/a[1]")
	private WebElement print;

	public JSONObject confirmationJson;

	private PageData confirmation;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.CONFIRMATION_PAGE_DATA;
		confirmation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		//PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		validate(printThisPage);


		JSONObject jsonObject = new JSONObject();
		for (String key : confirmation.getExpectedData().keySet()) {
			WebElement element = findElement(confirmation.getExpectedData()
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
		confirmationJson = jsonObject;

	}

	public void clickOnPrintThisPage() {
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		

		// Perform the click operation that opens new window
		printThisPage.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			if(winHandle.equalsIgnoreCase(winHandleBefore))
				continue;
			else
			{
				driver.switchTo().window(winHandle);
				break;
			}
		}
		
		// Perform the actions on new window
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_PLANS_PRINT))
		{
			
			print.isEnabled();
		
		}

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

	}
	
	@FindBy(xpath =".//*[@id='confirmationView']/div/div[1]")
	private WebElement confirmationViewBox;
	
	@FindBy(xpath =".//*[@id='confirmationView']/div/div[2]/div/div[2]/a")
	private WebElement confPrintBtn;
	
	public boolean validateConfirmationPage(){
		boolean flag = false;
		if(validate(confirmationViewBox)&&validate(confPrintBtn)
		&&confirmationViewBox.getText().contains("You have successfully submitted")&&
		confirmationViewBox.getText().contains("Your confirmation number is:"))
			flag = true;
		return flag;
	}

}


