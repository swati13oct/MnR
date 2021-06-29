/**
 * 
 */
package pages.mobile.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sai
 *
 */
public class SaveandReturnOLEModalMobile extends UhcDriver{

	@FindBy(id = "enroll-save-popup")
	private WebElement SaveandReturnModal;
	
	
	@FindBy(id = "backBtn")
	private WebElement BackBtn;

	public SaveandReturnOLEModalMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(SaveandReturnModal);
		
	}

	public Object returntoOLE() {
		validate(BackBtn);
		scrollToView(BackBtn);
		jsClickNew(BackBtn);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("welcome")){
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		else if(driver.getCurrentUrl().contains("medicare-information")){
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPageMobile(driver);
		}
		else if(driver.getCurrentUrl().contains("preliminary-questions")){
			System.out.println("OLE Preliminary Questions Page is Displayed");
			return new PrelimineryQuestionsPageMobile(driver);
		}
		else if(driver.getCurrentUrl().contains("personal-information")){
			System.out.println("OLE Personal Information Page is Displayed");
			return new PersonalInformationPageMobile(driver);
		}
		else if(driver.getCurrentUrl().contains("special-election-period")){
			System.out.println("OLE Special Election Period Page is Displayed");
			return new SpecialElectionPeriodPageMobile(driver);
		}
		return null;	
	}
}