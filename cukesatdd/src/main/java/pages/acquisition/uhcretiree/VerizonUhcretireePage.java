package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class VerizonUhcretireePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		start(VERIZON_PROVIDER_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[5]/a")
	
	private WebElement findaphysicianlink;
	
	private static String VERIZON_PROVIDER_PAGE_URL = MRConstants.VERIZON_PROVIDER_PAGE_URL;
	
		
		public VerizonUhcretireePage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
	}

		
		
		public Rallytool_Page findaphysicianverizonclick() {
			
			validate(findaphysicianlink);
		
		findaphysicianlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
		}
			// TODO Auto-generated method stub
			return null;
		}
	
}
