package pages.member.ulayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class TimeAdminPage extends UhcDriver{
	
	private static String TEAMB_TIME_ADMIN_PAGE_URL = MRConstants.TEAMB_TIME_ADMIN_PAGE_URL;
	
	public TimeAdminPage(WebDriver driver) {
		super(driver);
		start(TEAMB_TIME_ADMIN_PAGE_URL);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(id = "isTimeChangeAllowed")
	private WebElement isTimeChangeAllowed;
	
	@FindBy(id = "systemTime")
	private WebElement currentTime;
	
	@FindBy(id = "isSystemTime")
	private WebElement isSystemTime;
	
	@FindBy(id = "datetimepicker")
	private WebElement datetimepicker;
	
	@FindBy(id = "setTimeButton")
	private WebElement setTimeButton;
	
	@FindBy(id = "resetTimeButton")
	private WebElement resetTimeButton;
	
	public void navigateToTimeAdmin(){
		start(TEAMB_TIME_ADMIN_PAGE_URL);
	}

	public void changeDate(String date){
		String TimeChangeAllowed = isTimeChangeAllowed.getText();
		System.out.println("TimeChangeAllowed value"+TimeChangeAllowed);
		if(TimeChangeAllowed.equals("true")){
			sendkeys(datetimepicker, date);
			setTimeButton.click();
			driver.navigate().refresh();
			System.out.println("currentTime value "+currentTime.getText());
			if(!currentTime.getText().equals(date)){
				Assert.assertTrue("Team b date is not changed", false);
			}
		}else{
			Assert.assertTrue("Time change is not allowed", false);
		}
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		validate(isTimeChangeAllowed);
		validate(currentTime);
		validate(isSystemTime);
		validate(datetimepicker);
		validate(setTimeButton);
		validate(resetTimeButton);
	}

}
