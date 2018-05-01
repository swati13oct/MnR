/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PrelimineryQuestionsPage extends UhcDriver{
	
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(xpath = "//*[@class = 'cta-button next-button']")
	private WebElement NextBtn;
	
	@FindBy(xpath = "//*[@class = 'cancel-butt on modal-link']")
	private WebElement CancelEnrollmentLink;

	public PrelimineryQuestionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}

public PersonalInformationPage navigate_to_Personal_Information_page() {
		
		validate(NextBtn);
		NextBtn.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("personal-information")){
			System.out.println("OLE Personal Information Page is Displayed");
			return new PersonalInformationPage(driver);
		}
		return null;
	}
	

}