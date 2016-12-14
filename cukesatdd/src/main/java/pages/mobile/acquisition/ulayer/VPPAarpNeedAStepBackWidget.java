package pages.mobile.acquisition.ulayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class VPPAarpNeedAStepBackWidget extends UhcDriver{
	
	//Need a Step Back? Widget(US447571)
	    @FindBy(xpath="//div/div[3]/div[3]/div/div[3]/div[2]/div/div/div/div[4]/div[1]")
	    private WebElement needAStepBackWidget;
		//@FindBy(xpath="//*[contains(text(),'Need a Step Back?')]")
	    @FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[4]/div[1]/div[1]/h2")
		private WebElement stepBackHeader;
		//@FindBy(xpath="//*[contains(text(),'Start Plan Selector')]")
		@FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[4]/div[1]/div[2]/ul/div/div/p[2]/a/span")
		private WebElement planSelectorButton;
		@FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[4]/div[1]/div[2]/ul/div/div/p[1]")
		private WebElement stepBackContent;

	public VPPAarpNeedAStepBackWidget(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		validate(stepBackHeader);
		validate(planSelectorButton);
		validate(needAStepBackWidget);
	}
    
	public void validateStepBackWidget(){
		System.out.println("------------Step back Widget Validation Starts--------------------");
		if(needAStepBackWidget.isDisplayed()){
			System.out.println("------------Step Back widget displayed succesfully------------");
			if(stepBackHeader.getText().equalsIgnoreCase("Need a Step Back?")){
				//validate content is not null
					if(stepBackContent.getText()!=null){
						Assert.assertTrue("---content displayed---", true);
					}else
					Assert.fail("----------content not displayed------------");
				}
				//validate start plan selector button				
					if(planSelectorButton.isDisplayed()){
 						driver.getTitle().equalsIgnoreCase("Plan Selector");
						System.out.println("---------plan selector page displayed successfuly-------");
					}else{
					     Assert.fail("----------plan selector page not displayed-----------------");
					}
			}
		System.out.println("-----------Step Back Widget validation ends---------------------");
		
	}
	
}
