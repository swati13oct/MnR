
package pages.member_deprecated.bluelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.UhcDriver;



public class ConfirmSecurityQuestion extends UhcDriver {
                
                @FindBy(how = How.CLASS_NAME, using = "rememberThisDevice")
                private WebElement rememberThisDeviceSection;
                
                

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
                wait.until(ExpectedConditions.visibilityOf(rememberThisDeviceSection));
    }

    

                public void enterValidSecurityAnswer() throws Exception {
                                Thread.sleep(2000);
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
                                } else {
                                                throw new Exception("unknown challenge " + SecurityQtn);
                                }
                                //formContent.click();
                                JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,50)", "");
                                
                                WebElement submitbutton = driver.findElement(By.id("continueSubmitButton"));
                                submitbutton.click();
                                
                }

}
