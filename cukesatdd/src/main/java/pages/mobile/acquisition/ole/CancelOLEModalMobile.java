/**
 * 
 */
package pages.mobile.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;

/**
 * @author sdwaraka
 *
 */
public class CancelOLEModalMobile extends UhcDriver {

	@FindBy(css = "#ole-cancel-confirm")
	private WebElement CancellationModal;

	@FindBy(css = "#backBtn")
	private WebElement BackBtn;
	
	@FindBy(css = "[aria-labelledby^='enroll-cancel-popup'] a[class^='leaveApp']")
	private WebElement leaveAppBtn;

	public CancelOLEModalMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(CancellationModal);

	}

	public AcquisitionHomePageMobile leaveApplication() {

		validateNew(leaveAppBtn);
		jsClickNew(leaveAppBtn);
		return new AcquisitionHomePageMobile(driver);

	}

	public Object returntoOLE() {
		validate(BackBtn);
		// BackBtn.click();

		jsClickNew(BackBtn);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		/*
		 * else if(driver.getCurrentUrl().contains("medicare-information")){
		 * System.out.println("OLE Medicare Information Page is Displayed"); return new
		 * MedicareInformationPage(driver); } else
		 * if(driver.getCurrentUrl().contains("preliminary-questions")){
		 * System.out.println("OLE Preliminary Questions Page is Displayed"); return new
		 * PrelimineryQuestionsPage(driver); } else
		 * if(driver.getCurrentUrl().contains("personal-information")){
		 * System.out.println("OLE Personal Information Page is Displayed"); return new
		 * PersonalInformationPageMobile(driver); } else
		 * if(driver.getCurrentUrl().contains("special-election-period")){
		 * System.out.println("OLE Special Election Period Page is Displayed"); return
		 * new SpecialElectionPeriodPage(driver); }
		 */
		return null;
	}
}