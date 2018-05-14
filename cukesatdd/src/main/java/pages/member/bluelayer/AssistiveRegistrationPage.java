/**
 * 
 */
package pages.member.bluelayer;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;

/**
 * @author njain112
 *
 */
public class AssistiveRegistrationPage extends UhcDriver {

    @FindBy(id="username")
	private WebElement usernameField;
    
    @FindBy(id="password")
	private WebElement passwordField;
    
    @FindBy(id="confirmPassword")
	private WebElement confirmpasswordField;
    
    @FindBy(id="email")
  	private WebElement emailField;
    
    @FindBy(id="confirmEmail")
  	private WebElement confirmemailField;
    
    @FindBy(id="secOption")
  	private WebElement securityquesdropdown;
    
    @FindBy(id="q0")
  	private WebElement securityques1;
    
    @FindBy(id="q1")
  	private WebElement securityques2;
    
    @FindBy(id="q2")
  	private WebElement securityques3;
    
    @FindBy(id="remember")
  	private WebElement checkbox1;
    
    @FindBy(id="terms")
  	private WebElement checkbox2;
    
    @FindBy(xpath="html/body/div[1]/div/div[2]/flex[2]/flex-content[1]/div/div/form[3]/div[2]/p/button")
  	private WebElement submitbutton;
    
    @FindBy(id="a1")
  	private WebElement securityans1;
    
    @FindBy(id="a2")
  	private WebElement securityans2;
    
    @FindBy(id="a3")
  	private WebElement securityans3;
    
    
    

	public AssistiveRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	

	
	@Override
	public void openAndValidate() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(usernameField);
	}
	
	public void usernameautofill(String username)
	{
		System.out.println(usernameField.getAttribute("value"));
		if (usernameField.getAttribute("value").equalsIgnoreCase(username))
				{
			Assert.assertTrue(true);
				}
		else
		{
			Assert.fail("usernameField.getText() >>"+ usernameField.getText());	
					}
	}
	
	public void validate_allfields()
	{
		validate(passwordField);
	    
		validate(confirmpasswordField);
	    
	    validate(emailField);
	    
	    validate(confirmemailField);
	    
	    validate(securityquesdropdown);
	    
	    validate(checkbox1);
	    
	    validate(checkbox2);
	    
	    validate(submitbutton);
	}
	
	public void validate_security1_select(String option) {
		Select langdropdwn = new Select(securityquesdropdown);
		System.out.println(option);
		langdropdwn.selectByVisibleText(option);
	
		
	}
	
	public void validate_security2_select(String option1) {
		validate(securityques1);
		Select langdropdwn = new Select(securityques1);
		langdropdwn.selectByVisibleText(option1);
	}
	
	public void validate_security3_select(String option2) {
		validate(securityques2);
		Select langdropdwn = new Select(securityques2);
		langdropdwn.selectByVisibleText(option2);
	}
	
	public void validate_security4_select(String option3) {
		validate(securityques3);
		Select langdropdwn = new Select(securityques3);
		langdropdwn.selectByVisibleText(option3);
	}

	public void validate_checkboxes()
	{
		validate(checkbox1);
		validate(checkbox2);
		checkbox1.click();
		checkbox2.click();
	}
	
	public void validate_submitbutton()
	{
		validate(submitbutton);

		submitbutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void validate_passwordfields()
	{
	 validate(passwordField);
	 passwordField.sendKeys("Test2day");
	 validate(confirmpasswordField);
	 confirmpasswordField.sendKeys("Test2day");
	 }
	
	public void validate_emailfields()
	{
	 validate(emailField);
	 emailField.sendKeys("nikita_jain@optum.com");
	 validate(confirmemailField);
	 confirmemailField.sendKeys("nikita_jain@optum.com");
	 }
	
	public void validate_security2_ans()
	{
		securityans1.sendKeys("number1");
	 
	 }
	

	public void validate_security3_ans()
	{
		securityans2.sendKeys("color1");
	 
	 }
	

	public void validate_security4_ans()
	{
		securityans1.sendKeys("name1");
	 
	 }
	
	
}
