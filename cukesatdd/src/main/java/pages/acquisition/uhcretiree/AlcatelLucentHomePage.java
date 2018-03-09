/**
 * 
 */
package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class AlcatelLucentHomePage extends UhcDriver{
	
	@FindBy(xpath= ".//*[@id='main']/div/div[1]/div/div[3]/div[1]/div[3]/div/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
	private WebElement findproviderLink;
	
	@FindBy(id= "cq-imagebutton-jsp-/content/gr/en/alcatel-lucent/header/jcr:content/parsys/textbgimage/parsys/imagebutton_0")
	private WebElement findproviderTab;
	
	@FindBy(xpath= ".//*[@id='mainContent']/div/div/div/header/div/div/h1/span")
	private WebElement rallyToolPageContent;

	public AlcatelLucentHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(findproviderLink);
		validate(findproviderTab);
		
	}

	public Rallytool_Page findProviderLinkClick() {
		validate(findproviderLink);
		findproviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
		validate(rallyToolPageContent);
		if(getTitle().equalsIgnoreCase("Find Care")){
			return new Rallytool_Page(driver);
		}

		return null;
	}

	public AlcatelLucentFindProviderPage findProviderTabClick() {
		validate(findproviderTab);
		findproviderTab.click();
		validate(findproviderTab);
		if(getTitle().equalsIgnoreCase("Alcatel-Lucent Group Retiree - Find a Provider")){
			return new AlcatelLucentFindProviderPage(driver);
		}

		return null;
	}

	

}
