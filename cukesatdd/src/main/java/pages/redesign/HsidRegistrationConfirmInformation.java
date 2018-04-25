package pages.redesign;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Folder;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.SearchTerm;

import org.jsoup.Jsoup;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class HsidRegistrationConfirmInformation extends UhcDriver {
	
	@FindBy(className = "form__content")
	public WebElement confirmEmailSection;
	
	
	public String confirmationUrl;

	public String getConfirmationUrl() {
		return confirmationUrl;
	}

	public void setConfirmationUrl(String confirmationUrl) {
		this.confirmationUrl = confirmationUrl;
	}

	public HsidRegistrationConfirmInformation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate()  {

		
	}
	
	public void verifyConfirmInformationPage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue("Registration Confirmation page is not loaded", confirmEmailSection.isDisplayed());
	}
	
	public  String[] getConfirmRegistrationURLWithSubjectandEmailContent()
			throws MessagingException, IOException, InterruptedException {

		String username = "codetransformers@gmail.com";
        String pwd = "CodeTransformers@1";
        
        Thread.sleep(44000);
	
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", username, pwd);
		Folder inbox = store.getFolder("Inbox");

		inbox.open(Folder.READ_WRITE);
		//inbox.open(Folder.READ_ONLY);

		// Filter inbox messages by "UNSEEN" and "TO={username}"
		FlagTerm ft_unseen = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		RecipientStringTerm ft_toEmail = new RecipientStringTerm(RecipientType.TO, username);
		
		SearchTerm st = new AndTerm(ft_unseen, ft_toEmail);
		
		Message msg[] = inbox.search(st);
		String mail = "";
		String sub= "";
		MimeMultipart body;
		String bodyText = "";
		System.out.println("getConfirmRegistrationURLWithSubjectandEmailContent::MAILS for [" + username + "]: " + msg.length);
		//for(Message message:msg) {
	        //mail = message.getFrom()[0].toString();
	        //sub = message.getSubject();
	         //body = (MimeMultipart) message.getContent();
	        //bodyText = getTextFromMimeMultipart(body);
	         
	         //System.out.println("mail:" +mail +"sub: " +sub + "body: "+ bodyText);
	    //}
		
		Object emailcontent = msg[msg.length - 1].getContent();
		
		System.out.println(emailcontent);
		
		
		String toberemoved = "This e-mail, including attachments, may include confidential and/or proprietary information, and may be used only by the person or entity to which it is addressed. If the reader of this e-mail is not the intended recipient or his or her authorized agent, the reader is hereby notified that any dissemination, distribution or copying of this e-mail is prohibited. If you have received this e-mail in error, please notify the sender by replying to this message and delete this e-mail immediately.";

		String linkurl;
		try {
			String[] tmparr_2;
			
			
			String[] tmparray = ((String) emailcontent).split("href=\"");
			
			String portalName = "mnr";
			if (portalName.contains("my")) {

				tmparr_2 = tmparray[1].split("\""); 
			} else {
				if (tmparray[0].contains("Confirm your email address")) {

					tmparr_2 = tmparray[0].split("Simply click the link below");
					tmparr_2 = tmparr_2[1].split(">");
				}

				else {
	
					tmparr_2 = tmparray[1].split("\"");
				}
			}

			linkurl = tmparr_2[0];
		} catch (Exception e) {
			linkurl = " ";
		}

		String[] rtrnrarr = new String[] { linkurl, msg[msg.length - 1].getSubject().toString(),
				Jsoup.parse(emailcontent.toString()).text().replace(toberemoved, "") };
		System.out.println(rtrnrarr);
		store.close();
		session = null;
		return rtrnrarr;
	}
	
	private  String getTextFromMimeMultipart(
	        MimeMultipart mimeMultipart)  throws MessagingException, IOException{
	    String result = "";
	    int count = mimeMultipart.getCount();
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        if (bodyPart.isMimeType("text/plain")) {
	            result = result + "\n" + bodyPart.getContent();
	            break; // without break same text appears twice in my tests
	        } else if (bodyPart.isMimeType("text/html")) {
	            String html = (String) bodyPart.getContent();
	            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
	        } else if (bodyPart.getContent() instanceof MimeMultipart){
	            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	        }
	    }
	    return result;
	} 
	
	public void confirmEmail(){
		driver.get(getConfirmationUrl());
		
	}
	
	public  void getregistrationflowcompleteemail()
			throws MessagingException, IOException, InterruptedException {

		String username = "codetransformers@gmail.com";
        String pwd = "CodeTransformers@1";
        
        Thread.sleep(44000);
	
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", username, pwd);
		Folder inbox = store.getFolder("Inbox");

		inbox.open(Folder.READ_WRITE);
		//inbox.open(Folder.READ_ONLY);

		// Filter inbox messages by "UNSEEN" and "TO={username}"
		FlagTerm ft_unseen = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		RecipientStringTerm ft_toEmail = new RecipientStringTerm(RecipientType.TO, username);
		
		SearchTerm st = new AndTerm(ft_unseen, ft_toEmail);
		
		Message msg[] = inbox.search(st);
		String mail = "";
		String sub= "";
		MimeMultipart body;
		String bodyText = "";
		System.out.println("getCompleteRegistrationURLWithSubjectandEmailContent::MAILS for [" + username + "]: " + msg.length);
		for(Message message:msg) {
	        //mail = message.getFrom()[0].toString();
	        sub = message.getSubject();
	         //body = (MimeMultipart) message.getContent();
	        //bodyText = getTextFromMimeMultipart(body);
	         
	         System.out.println("sub: " +sub );
	    }
	         
        Object emailcontent = msg[msg.length - 1].getContent();
		
		System.out.println(emailcontent);
	        if(sub.contains("myUHCMedicare.com - your HealthSafe ID registration is complete"))
	        {
	        	Assert.assertTrue(true);
	        }
	        else
	        {
	        	Assert.fail("Email didn't come");
	        }
	         
		}
	



}
