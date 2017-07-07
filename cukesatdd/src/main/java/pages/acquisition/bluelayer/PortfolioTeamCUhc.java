package pages.acquisition.bluelayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class PortfolioTeamCUhc extends UhcDriver {
	
	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;
	
	
	private static String PAGE_URL = MRConstants.TeamC_VPP_PAGE_UHC_URL;

	public PortfolioTeamCUhc(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);		
	}

	
	public ResponsivePlanSummaryUhc searchPlans(String zipcode, String County) {
	    
	    sendkeys(zipCodeField, zipcode);
	    zipCodeField.sendKeys(Keys.ENTER);
	    //remove thread once page is stable
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    /*List<WebElement> countyActuals = driver.findElements(By.xpath("//a[@class='ng-binding ng-pristine ng-valid']"));
	    System.out.println(countyActuals.size());
	    
	    for(int i=0; i<=countyActuals.size()-1;i++){
	    	System.out.println(CountyName);
	    	if(countyActuals.get(i).getText().equals(CountyName)){
	    		System.out.println(CountyName);
	    		System.out.println(countyActuals.get(i).getText());
	    		countyActuals.get(i).click();
	    		break;
	    	}
	    }*/
		if (driver.getTitle().equalsIgnoreCase("plans")) {
			return new ResponsivePlanSummaryUhc(driver);
		} 
		return null;
	
}
	
	
}
