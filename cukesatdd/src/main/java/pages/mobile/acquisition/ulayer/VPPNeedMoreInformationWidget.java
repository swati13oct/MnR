package pages.mobile.acquisition.ulayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class VPPNeedMoreInformationWidget extends UhcDriver{
	
	//Need more information widget(US447570)
		//@FindBy(xpath="//*[contains(text(),'Need More Information')]")
	    @FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[3]/div[1]/div[1]/h2")
		private WebElement moreInformatonHeader;
		//@FindBy(xpath="//*[contains(text(),'Choose a video')]")
	    @FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[3]/div[1]/div[2]/ul/div/div[2]/div/a")
		private WebElement chooseAVideoLink;
		//@FindBy(xpath="//div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/p")
	    @FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[3]/div[1]/div[2]/ul/div/div[1]/p")
		private WebElement moreInformationDynamicContent;

	public VPPNeedMoreInformationWidget(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
 	}

	@Override
	public void openAndValidate() {
 		validate(moreInformatonHeader);
		validate(chooseAVideoLink);
		validate(moreInformationDynamicContent);
	}
	
	public void moreInformationWidget(){
		System.out.println("------------more information widget validation starts-------------");
		if(moreInformatonHeader.getText().equalsIgnoreCase("Need More Information?")){
			
			if(moreInformationDynamicContent.isDisplayed()){
				System.out.println("---------content is displayed on widget--------");
				if(moreInformationDynamicContent.getText()!=null){
					System.out.println("-----------context displayed in content box-----------");
				}else{
					Assert.fail("------------context not displayed in content box----------");
				}
			}
			else{
				Assert.fail("---------------content missing on UI-----------------");
			}
			if(chooseAVideoLink.isDisplayed()){
				System.out.println("choose a videos link displayed");
				chooseAVideoLink.click();
				//validate that page name in new tab
				switchToNewTab();
				if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Plans Video Guide")){
  					Assert.assertTrue("---------------video page displayed successfully---------",true);
				}else{
				    Assert.fail("----------------video page not displayed correctly------------");
				}
			}
			
		}
		System.out.println("-------------more information widget validation ends-----------------");
	}

}
