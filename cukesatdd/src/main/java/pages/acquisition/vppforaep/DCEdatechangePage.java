/**
 * 
 */
package pages.acquisition.vppforaep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class DCEdatechangePage extends UhcDriver{

	private static String TEAMF_DCE_DATECHANGE_PAGE_URL = "http://apsrt0197.uhc.com:9083/DCERestWAR/dcerest/timeAdmin";

	@FindBy(id = "systemTime")
	private WebElement currentTime;
	
	@FindBy(id = "datetimepicker")
	private WebElement setDateTxtBx;

	@FindBy(id = "setTimeButton")
	private WebElement setTimeBtn;

	@FindBy(id = "resetTimeButton")
	private WebElement ResetBtn;
	
	@FindBy(id = "isSystemTime")
	private WebElement IsSystemTime;


	public DCEdatechangePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(TEAMF_DCE_DATECHANGE_PAGE_URL);
		validate(currentTime);
		validate(setDateTxtBx);
		System.out.println("The DCE date is currently set to : "+currentTime.getText());
	}

	public boolean setAndValidate_DCEserverDate(String dCEdate) {
		String SetDate = dCEdate.concat(" 08:00");
		String currentDCEdate = currentTime.getText();
		if(dCEdate.contains("reset")){
			ResetBtn.click();
			driver.navigate().refresh();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(IsSystemTime.getText().contentEquals("true")){
				currentDCEdate = currentTime.getText();
				System.out.println("Current date changed to : "+currentDCEdate);
				System.out.println("DCE date changed successfully");
				return true;
			}
		}
		setDateTxtBx.sendKeys(SetDate);
		setTimeBtn.click();
		driver.navigate().refresh();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentDCEdate = currentTime.getText();
		System.out.println("Current date changed to : "+currentDCEdate);

		if(currentDCEdate.contentEquals(SetDate)){
			System.out.println("DCE date changed successfully");
			return true;
		}

		return false;
	}
	
}