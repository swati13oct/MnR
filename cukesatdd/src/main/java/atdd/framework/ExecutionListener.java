/**
 * 
 */
package atdd.framework;


import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import atdd.framework.UhcDriver;

public class ExecutionListener extends RunListener {


	public void testStarted(Description description) throws Exception {
		System.out.println("Execution of test in progress" + description.getClassName());
		

	

	}

	public void testFinished(Description description) throws Exception {
		System.out.println("Execution of test finished" + description.getClassName());

		WebDriver driver1 = new Augmenter().augment(UhcDriver.driver);
		File file  = (File) ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/"+GetDate()+"_Pass/"+GetTimeStampValue()+".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	public void testFailure(Failure failure) throws java.lang.Exception {
		System.out.println("Execution of test case failed : " + failure.getMessage());

		WebDriver driver1 = new Augmenter().augment(UhcDriver.driver);
		File file  = (File) ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/"+GetDate()+"_Fail/"+GetTimeStampValue()+".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private String GetTimeStampValue() {
		String timeStamp;
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String systime = time.toString();
		timeStamp = systime.replace(' ', '_');
		timeStamp = systime.replace(':', '_');

		System.out.println("Time stamp is " + timeStamp);

		return timeStamp;
	}

	private String GetDate() {
		Calendar cal = Calendar.getInstance();
		Date Fulldate = cal.getTime();
		String dateToString = Fulldate.toString();
		String date = dateToString.substring(4, 10);
		date.replace(':', '_');
		date.replace(' ', '_');

		return date;
	}

}