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
public class CancelOLEModal extends UhcDriver{

	@FindBy(id = "ole-cancel-confirm")
	private WebElement CancellationModal;
	
	
	@FindBy(xpath = "//*[@class='cta-button close-modal secondary']")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@class='cta-button']")
	private WebElement CancelBtn;
	
	public CancelOLEModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(CancellationModal);
		
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
		return null;	
	}
}