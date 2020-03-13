package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class ULayerVASPage extends UhcDriver{
	
	//header elements
	@FindBy(id="ghn_lnk_1")
	private WebElement homeLink;
	
	@FindBy(id="ghn_lnk_2")
	private WebElement ourPlansLink;
	
	@FindBy(id="ghn_lnk_3")
	private WebElement medicareEducationLink;
	
	@FindBy(id="search-field")
	private WebElement searchTextBox;
	
	//footer elements
	@FindBy(id="gf_lnk_1")
	private WebElement homeFooterLink;
	
	@FindBy(xpath="//a[@class='back-to-top' and contains(text(),'Back to Top')]")
	private WebElement backToTopLink;
	
	

	public ULayerVASPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
 	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public ULayerVASPage validateHaderAndFooter(){
		validate(homeLink);
		validate(ourPlansLink);
		validate(medicareEducationLink);
		validate(searchTextBox);
		validate(backToTopLink);
		validate(homeFooterLink);
		return new ULayerVASPage(driver);
	}
}
