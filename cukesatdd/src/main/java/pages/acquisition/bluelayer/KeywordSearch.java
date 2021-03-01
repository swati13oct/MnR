package pages.acquisition.bluelayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({ "deprecation" })
public class KeywordSearch extends GlobalWebElements {

	public KeywordSearch(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@FindBy(id = "search-field")
	private WebElement search;
	
	@FindBy(xpath="//a[contains(text(),'Visit a UHC Store')]")
	private WebElement textonpage ;
	
	public void url(){
		System.out.println("PageTitle " + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("q=medicare"));
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
