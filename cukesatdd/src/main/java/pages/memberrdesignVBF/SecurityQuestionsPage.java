package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class SecurityQuestionsPage extends UhcDriver {

	@FindBy(id = "authQuestiontextLabelId")
	private static WebElement questionid;

	@FindBy(id = "challengeQuestionList[0].userAnswer")
	private static WebElement securityAnswer;

	@FindBy(id = "continueSubmitButton")
	private static WebElement continueButton;

	public SecurityQuestionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(continueButton);

	}

	public void validateTheSecurityQues(String friendname, String favouritecolor, String phoneNumber) {
		String Question = questionid.getText();
		System.out.println("question is" + Question);
		if (Question.equalsIgnoreCase("What is your best friend's name?")) {
			System.out.println("Question is related to friendname");
			securityAnswer.sendKeys(friendname);
		}

		else if (Question.equalsIgnoreCase("What is your favorite color?")) {
			System.out.println("Question is related to color");
			securityAnswer.sendKeys(favouritecolor);
		} else {
			System.out.println("Question is related to phone");
			securityAnswer.sendKeys(phoneNumber);

		}
		validateNew(continueButton);
		continueButton.click();
	}

}
