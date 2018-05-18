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
 *@author sdwaraka
 *
 */
public class LearnMoreModal extends UhcDriver{
	
	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;
	
	@FindBy(xpath = "//*[@id='view-learn-enrollment']//a")
	private WebElement BackBtn;
	

	public LearnMoreModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(LearnMore_Modal);
		
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
		if(driver.getCurrentUrl().contains("medicare-information")){
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPage(driver);
		}
		
		return null;	
	}

}