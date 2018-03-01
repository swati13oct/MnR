package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class UawProviderPage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
	}
	
	//@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[5]/a")
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[2]/a")
	//@FindBy(linkText="Find a Physician, Medical Group, Clinic or Facility")
	
	public WebElement uawfindaphysicianlink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
	
	public WebElement uawsitemaplink;
	
	
	public UawProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page uawfindaphysicianclick() {
		
	
		validate(uawfindaphysicianlink);
		
		uawfindaphysicianlink.click();
		
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		
	
	
		// TODO Auto-generated method stub
		return null;
	}

	public UawSiteMapPage uawsitemaplinkclick() {
		
		validate(uawsitemaplink);
		
		uawsitemaplink.click();
		
		if (getTitle().equalsIgnoreCase(
				"UAW Trust Group Retiree – Site map")) {
	return new UawSiteMapPage(driver);
	}
		
		// TODO Auto-generated method stub
		return null;
	}
}
