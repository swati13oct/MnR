package pages.vbfacquisition_deprecated.bluelayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

public class VPPAarpNeedAStepBackWidget extends UhcDriver{
	
 	    @FindBy(xpath="//h4[contains(text(),'Need a Step Back')]/parent::div[@class='segment-title']/parent::div")
	    private WebElement needAStepBackWidget;
	    
 	    @FindBy(xpath="//h4[contains(text(),'Need a Step Back')]")
		private WebElement stepBackHeader;
 	    
 		@FindBy(id="selector")
		private WebElement planSelectorButton;
 		
		@FindBy(xpath="//h4[contains(text(),'Need a Step Back')]/parent::div[@class='segment-title']/following-sibling::div/div/p")
		private WebElement stepBackContent;

	public VPPAarpNeedAStepBackWidget(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		/*validate(stepBackHeader);
		validate(planSelectorButton);
		validate(needAStepBackWidget);*/
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
 						driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PLAN_SELECTOR);
 						planSelectorButton.click();
 						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
 						if(driver.getTitle().equals(PageTitleConstants.BLAYER_PLAN_SELECTOR))
						System.out.println("---------plan selector page displayed successfuly-------");
					}else{
					     Assert.fail("----------plan selector page not displayed-----------------");
					}
			}
		System.out.println("-----------Step Back Widget validation ends---------------------");
		
	}
	
}