package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class DSTHomePage extends UhcDriver {

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlans; 
	
	@FindBy(xpath = "//*[@class='cta-button']")
	private WebElement QuizButton; 
	
	public DSTHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}	


	@Override
	public void openAndValidate() {
		
	}
	
	public DSTHomePage viewQuizButtonButton()
	{
		Actions action = new Actions(driver);		
		action.moveToElement(OurPlans).moveToElement(QuizButton).click().build().perform();
		
		return null;
		
	}

}
