package pages.mobile.acquisition.commonpages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

@SuppressWarnings({ "deprecation" })
public class KeywordSearchAARPMobile extends GlobalWebElements {

	public KeywordSearchAARPMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}	
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
	}
	
	@FindBy(id = "search-field")
	private WebElement search;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[contains(text(),'AARP� Medicare Plans - What does Medicare cover? |')]")
	private WebElement textonpage;
	
	
	
	public void url(){
		System.out.println("PageTitle " + driver.getTitle());
		threadsleep(8);
		System.out.println("after wait");
		Assert.assertTrue(driver.getTitle().contains("edicare"));
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
		 
		if(driver.getTitle().contains("Medicare")) {
		validateNew(searchButton);
		searchButton.getText();	
		}else if(driver.getTitle().contains("medicare")) {
			validateNew(textonpage);
			textonpage.getText();	
		}
			
	}
	
}