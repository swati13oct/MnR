package pages.vbfacquisition.applitools.Ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ApplitoolsAcquisitionPage extends UhcDriver{
	
	@FindBy(id = "_pac_maincontainer")
	public WebElement chatBox;
	
	@FindBy(id = "_pac_allowPrompts")
	private WebElement chatCheckBox;
	
	@FindBy(id = "_pac_cancelbutton")
	private WebElement chatBoxExitBtn;

	public ApplitoolsAcquisitionPage(WebDriver driver) {
		super(driver);
		CommonUtility.waitForPageLoad(driver, chatBox, 10);
		closeChatBoxPopup();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}
	
	public void closeChatBoxPopup(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(chatBox)){
			chatCheckBox.click();
			chatBoxExitBtn.click();
		}
	}

}
