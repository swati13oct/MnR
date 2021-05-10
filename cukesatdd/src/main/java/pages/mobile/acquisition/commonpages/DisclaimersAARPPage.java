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

/**
 * @author rkodumur
 *
 */
public class DisclaimersAARPPage extends GlobalWebElementsMobile{
	
	@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	public WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'meded-accordion')]/div[contains(@class,'meded-accordion__item')]//a")
	public List<WebElement> mededAccordianList;

	
	@FindBy(xpath = "//*[@id='site-wrapper']/div[3]/div[1]/header/div[2]/h1/a/p/img")
	private WebElement aarpunitedHealthCareLogo;
	 
	public DisclaimersAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(mededAccordianList.get(0));
	}

	@FindBy(id = "logo")
	public WebElement logoLink;
	
	public AcquisitionHomePageMobile logoClick() {
		validate(logoLink);
		logoLink.click();
		validate(logoLink);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePageMobile(driver);
		}
		
		return null;
	}

	public AcquisitionHomePageMobile unitedHealthCareLogoClick() {
		validate(aarpunitedHealthCareLogo);
		aarpunitedHealthCareLogo.click();
		validate(aarpunitedHealthCareLogo);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	
	}
}
