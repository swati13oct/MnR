/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sai
 *
 */
public class SaveandReturnOLEModal extends UhcDriver{

	@FindBy(id = "enroll-save-popup")
	private WebElement SaveandReturnModal;
	
	
	@FindBy(id = "backBtn")
	private WebElement BackBtn;

	public SaveandReturnOLEModal(WebDriver driver) {
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
		BackBtn.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("welcome")){
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		else if(driver.getCurrentUrl().contains("medicare-information")){
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPage(driver);
		}
		else if(driver.getCurrentUrl().contains("preliminary-questions")){
			System.out.println("OLE Preliminary Questions Page is Displayed");
			return new PrelimineryQuestionsPage(driver);
		}
		else if(driver.getCurrentUrl().contains("personal-information")){
			System.out.println("OLE Personal Information Page is Displayed");
			return new PersonalInformationPage(driver);
		}
		else if(driver.getCurrentUrl().contains("special-election-period")){
			System.out.println("OLE Special Election Period Page is Displayed");
			return new SpecialElectionPeriodPage(driver);
		}
		return null;	
	}
}