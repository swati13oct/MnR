package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class MemberRedesignPage extends UhcDriver {

	@FindBy(xpath = ".//*[@id='hello-person']")
	private WebElement helloText;
	
	@FindBy(xpath = ".//*[@id='dropdown-toggle--1']")
	private WebElement dropdown;
	
	public MemberRedesignPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

	public boolean validateRallyPage() {
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		System.out.println("url: "+getTitle());
		if(validate(dropdown)&& helloText.getText().contains("Hello"))
			return true;
		return false;
	}
	
	

}
