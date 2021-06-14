package pages.mobile.acquisition.commonpages;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.LocationSearchPage;


public class GetStartedPage extends UhcDriver {
	
	@FindBy(linkText = "Get started")
	private WebElement getStartedLink;
	
	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[4]/div/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr/td[3]/div/div[2]/div/div/p/a")
	WebElement enterDrugLink;
	
	@FindBy(xpath="//iframe[@src='/health-plans/dce.html#/estimate-drug-costs']")
	WebElement dceToolFrame;

	public GetStartedPage(WebDriver driver) {
		 super(driver);
	       PageFactory.initElements(driver, this);
	       openAndValidate();
	}

	public LocationSearchPageMobile getStarted() {
		getStartedLink.click();
		if(currentUrl().contains("enterZipCode"))
		{
			return new LocationSearchPageMobile(driver);
		}
		else
			return null;
		
	}

	@Override
	public void openAndValidate() {
		validate(getStartedLink);
		
	}
	
	public AddDrugPageMobile navigateToDCE(){
		enterDrugLink.click();
		getStartedLink.click();
		return new AddDrugPageMobile(driver);
		
	}
		  
	public AddDrugPageMobile clicksOnGetStarted() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(dceToolFrame);
		try{
			getStartedLink.click();
		}catch(Exception e){
			System.out.println("phantomjs doesn't support the element on switched iframe");
		}
		return new AddDrugPageMobile(driver);
	}	 

}
