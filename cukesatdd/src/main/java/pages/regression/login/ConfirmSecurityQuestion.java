package pages.regression.login;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;



public class ConfirmSecurityQuestion extends UhcDriver {
	
	@FindBy(how = How.CLASS_NAME, using = "rememberThisDevice")
	private WebElement rememberThisDeviceSection;
	
	@FindBy(id = "new-email")
    private WebElement NewEmailTxtBox;

    @FindBy(id = "new-email-confirm")
    private WebElement ConfirmNewEmailTxtBox;
    
    @FindBy(xpath = "//*[@id='email-modal-form']//button")
    private WebElement NewEmailContinueBtn;

	
	@FindBy(id="continueSubmitButton")
	private WebElement continueSubmitButton;
	

	@FindBy(xpath = "//*[@id='authQuestionContent']")
	private WebElement AuthQuestion;
	
    public ConfirmSecurityQuestion(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	openAndValidate();
    }

    /**
     * Open and validate screen is shown.
     *
     * @return true, if successful
     * @see atdd.framework.UHCDriver#openAndValidate()
     */
    @Override
    public void openAndValidate() {
	
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.visibilityOf(AuthQuestion));
    }

    

	public void enterValidSecurityAnswer() throws Exception {
		//tbd Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		WebDriverWait wait = new WebDriverWait(driver,40);
		String SecurityQtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authQuestiontextLabelId"))).getText();
		WebElement answerField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("challengeQuestionList[0].userAnswer")));
		answerField.clear();
	  //formContent.click();
        System.out.println(SecurityQtn);
		if (SecurityQtn.contains("number")) {
			answerField.sendKeys("number1");
		} else if (SecurityQtn.contains("name")) {
			answerField.sendKeys("name1");
		} else if (SecurityQtn.contains("team")) {
			answerField.sendKeys("team1");
		} else if (SecurityQtn.contains("color")) {
			answerField.sendKeys("color1");
		} else if (SecurityQtn.contains("team")) {
			answerField.sendKeys("team1");
		} else {
			throw new Exception("unknown challenge " + SecurityQtn);
		}
		//formContent.click();
		/*WebElement submitbutton = driver.findElement(By.id("continueSubmitButton"));
		submitbutton.click();
		Thread.sleep(5000);*/
		System.out.println("question answered");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", continueSubmitButton);
	}
	
	{
	try{
        if(validate(NewEmailTxtBox)){
        NewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
        ConfirmNewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
        System.out.println("@@@@@@@@@@@@ Enter New Email Page Displayed for ULayer Member@@@@@@@@@@@@");
        NewEmailContinueBtn.click();
        Thread.sleep(3000);
        CommonUtility.checkPageIsReady(driver);
        }
 }
 catch (Exception e) {
        System.out.println("New Email Page NOT Present");
 }


}
}
