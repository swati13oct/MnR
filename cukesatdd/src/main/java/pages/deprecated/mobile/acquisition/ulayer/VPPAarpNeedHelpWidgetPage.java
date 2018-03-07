package pages.deprecated.mobile.acquisition.ulayer;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class VPPAarpNeedHelpWidgetPage extends UhcDriver{
	
	//Need Help?(US447564) widget 
	@FindBy(xpath="//div[3]/div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]")
	private WebElement needHelpWidget;
	@FindBy(className="segment-title")
	private WebElement needHelpWidgetTitle;
	
  	@FindBy(xpath="//h5[contains(text(),'Chat')]/parent::div/parent::div")
    private WebElement chatWithUsWidget;
  	
 	@FindBy(xpath="//h5[contains(text(),'Chat')]")
    private WebElement chatNowHeader;
 
 	@FindBy(xpath="//*[contains(text(),'Chat now')]")
	private WebElement chatNowButton;
 	
 	@FindBy(id="_pac_logo")
 	private WebElement chatClosedButton;
 	
	@FindBy(className="close")
	private WebElement closeButtonOnNewTab;
	
	@FindBy(xpath="//*[@class='message'][2]")
	private WebElement messageText;
	
	@FindBy(xpath="//h5[contains(text(),'Meet with an Agent')]/parent::div/parent::div")
	private WebElement meetAnAgentWidget;
	
 	@FindBy(xpath="//h5[contains(text(),'Meet with an Agent')]/parent::div")
	private WebElement meetAnAgentHeader;
 
 	@FindBy(xpath="//h5[contains(text(),'Meet with an Agent')]/parent::div/following-sibling::p[1]")
	private WebElement makeAnAppointmentLink;
 	
	@FindBy(xpath="//h5[contains(text(),'Meet with an Agent')]/parent::div/following-sibling::p[2]/a")
	private WebElement findUsInYourNeighborhood;
	
	@FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]/div[4]/div[2]/div[2]/div/p[1]")
	private WebElement contentText;
	
	@FindBy(xpath="//tr[2]/td/div/div/h1")
	private WebElement appointmentTable;

	public VPPAarpNeedHelpWidgetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		validateNew(needHelpWidgetTitle);
		validateNew(makeAnAppointmentLink);
		validateNew(findUsInYourNeighborhood);	
		validateNew(chatNowButton);
		validateNew(chatNowHeader);
	}
   
	public void needHelpWidget(){
		//if
	}
	
	public void chatWithUsWidget(){
		System.out.println("-------------chat with us widget validation starts-----------------------");
		if(chatWithUsWidget.isDisplayed()){
			System.out.println("--------Chat with us widget displayed-----------");
			validateNew(chatNowHeader);
			/*if(chatNowButton.isDisplayed() && chatNowButton.isEnabled()){
				System.out.println("---------chat now button displayed and enabled-----");
				chatNowButton.click();
				switchToNewTab();
				if(closeButtonOnNewTab.isDisplayed()){
					System.out.println("------new window displayed-------");
					System.out.println(messageText.getText());
					closeButtonOnNewTab.click();						
					}else{
						Assert.fail("-----issue with chat now ne window------");
					}
				}else{
					Assert.fail("-------New Window not displayed-----");
				}*/
			}else{
				Assert.fail("-----------chat button not displayed or not enabled-------------");
			}
		System.out.println("------------chat with us widget validation ends---------------");
	}

	
	
	public void meetWithAnAgent(){
		System.out.println("-----------------meet with an agent validation started---------------");
		if(meetAnAgentWidget.isDisplayed()==true){
			System.out.println("-----------meet an agent widget displayed successfully----------");
			validateNew(makeAnAppointmentLink);
 			if(findUsInYourNeighborhood.getText()!=null){
				System.out.println("-------content text is displayed in content---------");
			}else{
				Assert.fail("--------------failed as nothing displayed in UI for content-------");
			}
				makeAnAppointmentLink.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                System.out.println(driver.getTitle());
				if(driver.getTitle().equals(
						"Health Insurance Agent Appointment Request | AARP�� Medicare Plans from UnitedHealthcare��")){
					System.out.println("---Page Displayed correctly------");
				}			 		 
			}else{
				Assert.fail("------------meet an agent widget not displayed");
			}
			System.out.println("----------meet with an agent validation ends---------------");
	}
}
