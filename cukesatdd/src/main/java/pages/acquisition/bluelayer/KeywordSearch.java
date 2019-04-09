package pages.acquisition.bluelayer;

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
	
	public void url(){
		validate (search);
	}
	
}
