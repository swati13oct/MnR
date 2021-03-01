/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

/**
 * @author saduri
 *
 */
public class DisclaimersPage extends UhcDriver{
	


	@FindBy(id = "logo")
	private WebElement unitedHealthCareLogo;
	
	@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	public static WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'meded-accordion')]/div[contains(@class,'meded-accordion__item')]//a")
	public static List<WebElement> mededAccordianList;

	public DisclaimersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(mededAccordianList.get(0));		
	}
	
	
	public AcquisitionHomePage unitedHealthCareLogoClick() {
		validate(unitedHealthCareLogo);
		unitedHealthCareLogo.click();
		validate(unitedHealthCareLogo);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)) {
			return new AcquisitionHomePage(driver);
		}
		return null;

	}

}
