package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterZipCodePage {
	
	@FindBy(name = "zipcode")
	WebElement zipCodeField;
	
	@FindBy(name = "fipsName")
	List<WebElement> counties;

	@FindBy(linkText = "Continue")
	WebElement continueButton;
	
	@FindBy(xpath = "//div[@id='counties']//span[.='Continue']")
	WebElement countyContinueButton;
	
	/*@FindBy(className = "//div[@class='marginTop5 ng-binding ng-scope']")
	List<WebElement> counties;*/
	
	
	
	private WebDriver driver;

	public EnterZipCodePage(WebDriver driver) {
		 this.driver=driver;
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	}

	public AddDrugPage getZipCodeCounty(String zipCode, String county, String planYear) {
		zipCodeField.click();
		zipCodeField.clear();
		zipCodeField.sendKeys(zipCode);
		if(null!=planYear)
		{
			String planYearXpath = "//div[@class='marginBottom25']//span[.='"+planYear+"']";
			driver.findElement(By.xpath(planYearXpath)).click();
			System.out.println("year");
		}
		continueButton.click();
	
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
			
			countyContinueButton.click();
			/*driver.findElement(By.xpath("//div[@id='counties']//span[.='Continue']")).click();*/
		}
		
		if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®"))
		{
			return new AddDrugPage(driver);
		}
		else
		{
			return null;
		}
		
	}

}
