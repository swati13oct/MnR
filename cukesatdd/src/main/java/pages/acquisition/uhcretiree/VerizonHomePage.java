package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class VerizonHomePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		start(VERIZON_HOME_PAGE_URL);
	}
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/verizon/home/jcr:content/parsys/events']/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
	private WebElement findaproviderlink;
	
	private static String VERIZON_HOME_PAGE_URL = MRConstants.VERIZON_HOME_PAGE_URL;
	
	public VerizonHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page findaproviderverizonclick() {
		validate(findaproviderlink);
		
		findaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Find Care")) {
	return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}
	}

