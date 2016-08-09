package pages.setSystemTime;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PartDPortalWeb extends UhcDriver{
	

	@FindBy(id="month")
	private WebElement mmInputBox;
	
	@FindBy(id="day")
	private WebElement ddInputBox;
	
	@FindBy(id="year")
	private WebElement yyyyInputBox;
	
	@FindBy(id="hour")
	private WebElement hhInputBox;
	
	@FindBy(id="min")
	private WebElement minInputBox;
	
	@FindBy(id="sec")
	private WebElement secInputBox;
	
	@FindBy(xpath=".//*[@id='timeform']/table/tbody/tr[1]/th")
	private WebElement timeForm;
	
	@FindBy(xpath=".//*[@id='timeform']/table/tbody/tr[4]/td/input")
	private WebElement updateSystemTime;
	
	@FindBy(xpath="html/body")
	private WebElement confirmationPage;
	
	private PageData partDPortalWeb;
	
	private static String PAGE_URL = MRConstants.SERVER_DATE_PARTD_PORTAL_WEB;
	
	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(timeForm);
		
	}
	public PartDPortalWeb(WebDriver driver, String month, String date, String year, String hours,String min, String seconds) {
		super(driver);
		PageFactory.initElements(driver, this);	
		openAndValidate();
		setSystemTime(month, date, year, hours, min, seconds);
	}

	public void setSystemTime(String month, String date, String year, String hours,String min, String seconds){
		mmInputBox.sendKeys(month);
		ddInputBox.sendKeys(date);
		yyyyInputBox.sendKeys(year);
		hhInputBox.sendKeys(hours);
		minInputBox.sendKeys(min);
		secInputBox.sendKeys(seconds);
		updateSystemTime.click();
		if(confirmationPage.getText().contains("timedelegate is joda frozen")){
			System.out.println("Successfully changed PartD Time");
		}else{
			Assert.fail();
		}
	
	}

}
