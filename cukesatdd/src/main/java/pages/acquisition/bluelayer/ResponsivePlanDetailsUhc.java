package pages.acquisition.bluelayer;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.member.ulayer.Rallytool_Page;

public class ResponsivePlanDetailsUhc extends UhcDriver {

	@FindBy(xpath="html/body/div[6]/div[4]/div/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div[1]/table/tbody/tr[4]/td[2]/a")
	private WebElement providerLink;
	
	@FindBy(xpath="//*[text()='Optional Services']")
	private WebElement optionalServiceTab;
	
	@FindBy(xpath="//*[@id='optionalRiders']/h3")
	private WebElement optionalServiceHeaderText;
	
	@FindBy(xpath="//div[1][@class='riders-box']")
	private WebElement optionalDentalBox;
	
	@FindBy(xpath="//div[1][@class='riders-box']/h3")
	private WebElement optionalDentalBoxHeader;
	
	
	@FindBy(xpath="//div[1][@class='riders-box']/p[3]/b")
	private WebElement optionalDentalDollarValue;
	
	@FindBy(xpath="//div[1][@class='riders-box']/label")
	private WebElement optionalDentalCheckBox;
	
	@FindBy(xpath="//div[2][@class='riders-box']")
	private WebElement highOptionalDentalBox;
	
	@FindBy(xpath="//div[2][@class='riders-box']/label")
	private WebElement highOptionalDentalCheckBox;
	
	@FindBy(xpath="	//div[2][@class='riders-box']/p[3]/b")
	private WebElement highOptionalDentalDollarValue;
		
	@FindBy(xpath="//span[@class='title' and text()='Plan Costs']")
	private WebElement planCostsTab;
	
	@FindBy(xpath="//tr[@class='optionalServicesPlanCosts']/td[3]/strong[1]")
	private WebElement optionalDentalPlanCostValue;
	
	public ResponsivePlanDetailsUhc(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	
	public Rallytool_Page validateRallyPage(){
		providerLink.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
         try {
                Thread.sleep(6000);
         } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
         }             
         driver.switchTo().window(tabs.get(1));
         System.out.println(driver.getTitle());
         if (driver.getTitle().equalsIgnoreCase("Welcome")) {
         return new Rallytool_Page(driver);
         }
         else{

         }
		return null;
	}
	
	public ResponsivePlanDetailsUhc valiadateOptionalServices(String optionalDental, String highOptionalDental){
		String highOptionalDollarValue = null;
		String optionalDentalDolarValue = null;
		//waitforElement(optionalServiceTab);
		optionalServiceTab.click();
		if(optionalServiceHeaderText.getText().contains("Optional Services to Customize Your Plan")){
			System.out.println(optionalServiceHeaderText.getText()+"======= Displayed correctly");
			if(optionalDental.equals(true)){
				validate(optionalDentalBox);
				optionalDentalDolarValue = optionalDentalDollarValue.getText();
			}if(highOptionalDental.equals(true)){
				validate(highOptionalDentalBox);
				highOptionalDollarValue = highOptionalDentalDollarValue.getText();
			}if(optionalDental.equals(true) && highOptionalDental.equals(true)){
				optionalDentalCheckBox.click();
				if(!highOptionalDentalCheckBox.isEnabled()){
					System.out.println("===========High optional checkox is disabled=======");
					planCostsTab.click();
					waitforElement(optionalDentalPlanCostValue);
					if(optionalDentalPlanCostValue.getText().contains(optionalDentalDolarValue)){
						System.out.println("Optional Dental value displayed correctly on plan cossts page");
					}else{
						System.out.println("Optional Dental value not displayed correctly on plan cossts page");
						Assert.fail();
					}
					}else{
						System.out.println("=========High Dental Check box bot disabled===========");
						Assert.fail();
					}
			}
		}else{
			System.out.println("=============Optional Service Header not displayed===============");
			Assert.fail();
		}
		return null;
	}
}
