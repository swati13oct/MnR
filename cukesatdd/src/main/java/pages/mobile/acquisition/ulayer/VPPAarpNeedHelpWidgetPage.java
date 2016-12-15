package pages.mobile.acquisition.ulayer;

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
	
	//Chat widget US447565
	//@FindBy(className="icon-col no-mobile no-med-supp")
	@FindBy(xpath="//div[3]/div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]/div[4]/div[1]/div")
    private WebElement chatWithUsWidget;
    //@FindBy(xpath="//img[@alt='Chat']")
	@FindBy(xpath="//div[3]/div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]/div[4]/div[1]/div/div/h3")
    private WebElement chatNowHeader;
	//@FindBy(xpath="//*[contains(text(),'Chat now')]")
	@FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]/div[4]/div[1]/div/div/p[2]/span/span[1]/img")
	private WebElement chatNowButton;
	@FindBy(className="close")
	private WebElement closeButtonOnNewTab;
	@FindBy(xpath="//*[@class='message'][2]")
	private WebElement messageText;
	
	// meet an agent(US447566)
	//@FindBy(xpath="//div[2]/div/div[1]/div[1]/div/div/div[2]/div[3]")
	@FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]/div[4]/div[2]/div[2]")
	private WebElement meetAnAgentWidget;
	//@FindBy(xpath="//h5[contains(text(),'Meet with an Agent')]")
	@FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]/div[4]/div[2]/div[2]/h3")
	private WebElement meetAnAgentHeader;
	//@FindBy(xpath="//a[contains(text(),'Make an appointment')]")
	@FindBy(xpath="//div[3]/div/div[3]/div[2]/div/div/div/div[1]/div[1]/div[4]/div[2]/div[2]/div/p[2]/a")
	private WebElement makeAnAppointmentLink;
	@FindBy(xpath="//*[contains(text(),'Find us in your neighborhood')]")
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
		validate(needHelpWidgetTitle);
		validate(makeAnAppointmentLink);
		validate(findUsInYourNeighborhood);	
		validate(chatNowButton);
		validate(chatNowHeader);
	}
   
	public void needHelpWidget(){
		//if
	}
	
	public void chatWithUsWidget(){
		System.out.println("-------------chat with us widget validation starts-----------------------");
		if(chatWithUsWidget.isDisplayed()){
			System.out.println("--------Chat with us widget displayed-----------");
			validate(chatNowHeader);
			if(chatNowButton.isDisplayed() && chatNowButton.isEnabled()){
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
				}
			}else{
				Assert.fail("-----------chat button not displayed or not enabled-------------");
			}
		System.out.println("------------chat with us widget validation ends---------------");
	}

	
	
	public void meetWithAnAgent(){
		System.out.println("-----------------meet with an agent validation started---------------");
		if(meetAnAgentWidget.isDisplayed()==true){
			System.out.println("-----------meet an agent widget displayed successfully----------");
			validate(makeAnAppointmentLink);
			//validate(findUsInYourNeighborhood);
			if(contentText.getText()!=null){
				System.out.println("-------content text is displayed in content---------");
			}else{
				Assert.fail("--------------failed as nothing displayed in UI for content-------");
			}
			/*if(makeAnAppointmentLink.isDisplayed()==false){
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				System.out.println("---------make an appointment diiplayed--------");*/
				makeAnAppointmentLink.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				/*if(driver.getTitle().equalsIgnoreCase(
						"Health Insurance Agent Appointment Request | AARP�� Medicare Plans from UnitedHealthcare��")
						)*/
				if(appointmentTable.getText().equalsIgnoreCase(
						"Request an Appointment with a Health Insurance Agent")){
					System.out.println("-------request an appointment page validated successfully----------");
				}else{
					Assert.fail("-------------request an appointment page not displayed------------");
				}
				/*}else{
				Assert.fail("---------make an appointment not displayed-----------");
			}*/
			/*if(findUsInYourNeighborhood.isDisplayed()==true){
				System.out.println("-----To Be validated on Mobile responsibe screen---------");
				//TODO implement after the link is actually available
			}else{
				Assert.fail("---------------find us page not displayed-------------");
			}*/
		}else{
			Assert.fail("------------meet an agent widget not displayed");
		}
		System.out.println("----------meet with an agent validation ends---------------");
	}
}
