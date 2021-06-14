/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
//import pages.mobile.acquisition.commonpages.PageTitleConstants;
import pages.acquisition.commonpages.PageTitleConstants;


/**
 * @author saduri
 *
 */
public class DisclaimersPageMobile extends UhcDriver{
	


	@FindBy(id = "logo")
	private WebElement unitedHealthCareLogo;
	
	@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	public WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'meded-accordion')]/div[contains(@class,'meded-accordion__item')]//a")
	public List<WebElement> mededAccordianList;

	public DisclaimersPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(mededAccordianList.get(0));		
	}
	
	
	public AcquisitionHomePageMobile unitedHealthCareLogoClick() {
		validate(unitedHealthCareLogo);
		unitedHealthCareLogo.click();
		validate(unitedHealthCareLogo);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)) {
			return new AcquisitionHomePageMobile(driver);
		}
		return null;

	}

}
