package pages.acquisition.uhcretiree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;

/**
 * @author eb
 *
 */

public class UhcRetireePharmacyLocatorPage extends UhcDriver {

	@FindBy(css="h1.titleLeft")
	private WebElement pharmacyLocatorHeading;
	
	@FindBy(id="zipCode")
	private WebElement txtZipcode;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(id="planyear")
	private WebElement planYear;
	
	public UhcRetireePharmacyLocatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validate(txtZipcode);
		validate(btnContinue);
	}
	
	public PharmacyResultsPage searchPharmacy(String year,String zipcode){
		try {
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			Select drpPlanYear = new Select(driver.findElement(By.name("year")));
			drpPlanYear.selectByVisibleText(year);
			Thread.sleep(6000);
			txtZipcode.sendKeys(zipcode);
			Thread.sleep(6000);
			btnContinue.click();
			Thread.sleep(6000);
			driver.switchTo().defaultContent();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PharmacyResultsPage(driver);
	}
}