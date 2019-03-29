package pages.vbfacquisition_deprecated.uhcretiree;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

public class WellsFargohomepage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		start(WELLSFARGO_HOME_PAGE_URL);
	}
	
	private static String WELLSFARGO_HOME_PAGE_URL = MRConstants.WELLSFARGO_HOME_PAGE_URL;
	
	@FindBy(xpath="//*[@id='main']/div/div[1]/div/div[3]/div[2]/div[8]/div/div/div[1]/a/span")
    private WebElement getstartedbutton;
	
	public WellsFargohomepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public SalesforceSitePage clickgetstarted() {
		// TODO Auto-generated method stub
		
		validate(getstartedbutton);
		getstartedbutton.click();
		
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PROBLEM_LOADING_PAGE))
		{
			return new SalesforceSitePage(driver);
		}
		
		return null;
	}
	
}