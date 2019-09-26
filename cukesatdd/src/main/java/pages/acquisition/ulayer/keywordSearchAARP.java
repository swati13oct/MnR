package pages.acquisition.ulayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({ "deprecation" })
public class keywordSearchAARP extends GlobalWebElements {

	public keywordSearchAARP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}	
	
	@FindBy(id = "search-field")
	private WebElement search;
	
	@FindBy(xpath="//a[contains(text(),'AARP® Medicare Plans - What does Medicare cover? |')]")
	private WebElement textonpage;
	
	public void url(){
		System.out.println("PageTitle " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("medicare"));
		/*String expectedTitle = "medicare";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);*/
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(search);
		validateNew(textonpage);
		textonpage.getText();		
	}
	
}
