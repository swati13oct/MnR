/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class CountySelectionPage extends UhcDriver{
	
	@FindBy(name = "fipsName")
	List<WebElement> counties;
	
	@FindBy(linkText = "Continue")
	WebElement continueButton;

	public CountySelectionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	    openAndValidate();
	}
	
	public ManageDrugPage selectCounty(String county)
	{
		if(counties.size()>1)
		{
			for(WebElement countyElement :counties)
			{
				String elementId = countyElement.getAttribute("id");
				if(elementId.contains(county))
				{
					countyElement.click();
					System.out.println("county clicked");
				}
				
				
			}	
			
			continueButton.click();
		}
		if(currentUrl().contains("manageDrugList"))
		{
			return new ManageDrugPage(driver);
		}
		return null;
	}
	

	@Override
	public void openAndValidate() {
		validate(continueButton);
		for(WebElement county : counties)
		{
			validate(county);
		}
		
	}
	
	public AddDrugPage chooseCounty(String county)
	{
		if(counties.size()>1)
		{
			for(WebElement countyElement :counties)
			{
				String elementId = countyElement.getAttribute("id");
				if(elementId.contains(county))
				{
					countyElement.click();
					System.out.println("county clicked");
				}
				
				
			}	
			
			continueButton.click();
		}
		if(currentUrl().contains("drugSearch"))
		{
			return new AddDrugPage(driver);
		}
		return null;
	}

}
