package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class NokiaHomePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		start(NOKIA_HOME_PAGE_URL);
	}
	
	private static String NOKIA_HOME_PAGE_URL = MRConstants.NOKIA_HOME_PAGE_URL;
	
	@FindBy(xpath="//*[@id='main']/div/div[1]/div/div[3]/div[2]/div[8]/div/div/div[1]/a/span")
    private WebElement getstartedbutton;
	
	public NokiaHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public SalesforceSitePage clickgetstarted() {
		// TODO Auto-generated method stub
		
		validate(getstartedbutton);
		getstartedbutton.click();
		
		if(driver.getTitle().equalsIgnoreCase("Problem loading page"))
		{
			return new SalesforceSitePage(driver);
		}
		
		return null;
	}
	
}