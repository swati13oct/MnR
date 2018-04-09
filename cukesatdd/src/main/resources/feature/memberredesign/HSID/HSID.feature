

Feature:To test HSID functionality on Medicare site

 
   
   
   @US968323
    Scenario Outline:Verify HSID registration.
    Given the user connect to DB
    And the user select record from database
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from extreme scale
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from mbr_portal
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from mbr
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user deregister from M&R LDAP
      | Username  | <username>  |
    And the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
And enter first name, last name, date of birth, zip code, member id and click continue
| firstName   | <firstName>   |
| lastName    | <lastName>   |
| dob    | <dob>   |
| memberid   | <memberid>   |
|zipcode 	| <zipcode>  |
And user is navigated to step two:create account page
And enter username, password, re-enter password, email, re-enter email
| userName   | <userName>   |
| password   | <password>   |
| email      | <email>   	|
And select the security type as "Security questions"
And select security question1 as "What was your first phone number?"
And select security answer1 as "number1"
And select security question2 as "What is your best friend's name?"
And select security answer2 as "name1"
And select security question3 as "What is your favorite color?"
And select security answer3 as "color1"
And check the terms and click on create my ID button
And user is navigated to Confirm email page
And user should see a latest unread mail recieved in provided email address
Then user should copy the confirm email url to browser
And user should be at Sign In page
And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
Then user should see a latest unread mail recieved from "myUHCMedicare.com - your HealthSafe ID registration is complete" in mail server
    #And I should see a Username or email address label with textbox in Sign In page
    
   Examples:
 
   | planType|  memberType  | copayCategory | firstName | lastName        |   dob 	            | memberid 	  | zipcode| userName 	         | password   |   email	  			          | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS      | BBABFAD   | BEDD            | 09/17/1946          | 002238311-1 | 92024	 |AUTO_q2_apr_uhc100   | Password@1 | codetransformers@gmail.com | number1   | name1     | color1    |
   
   @Assistive
   Scenario Outline:Verify HSID assistive registration.
   Given the user connect to DB
    And the user select record from database
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from extreme scale
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from mbr_portal
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from mbr
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
   And login with following details logins in the member portal and validate elements and route to assistive flow 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
   When the user validate username autofill
   And enter first name, last name, date of birth, zip code, member id and click continue
     | firstName   | <firstName>   |
     | lastName    | <lastName>    |
     | dob         | <dob>         |
     | memberid    | <memberid>   |
     |zipcode 	   | <zipcode>  |
  And user is navigated to step two:create account page
  And enter username, password, re-enter password, email, re-enter email
     | userName   | <userName>   |
     | password   | <password>   |
     | email      | <email>   	|
  And select the security type as "Security questions"
  And select security question1 as "What was your first phone number?"
  And select security answer1 as "number1"
  And select security question2 as "What is your best friend's name?"
  And select security answer2 as "name1"
  And select security question3 as "What is your favorite color?"
  And select security answer3 as "color1"
  And check the terms and click on create my ID button
  And user is navigated to Confirm email page
  And user should see a latest unread mail recieved in provided email address
  Then user should copy the confirm email url to browser
  And user should be at Sign In page
  And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
  Then user should see a latest unread mail recieved from "myUHCMedicare.com - your HealthSafe ID registration is complete" in mail server
   #And I should see a Username or email address label with textbox in Sign In page
    
   Examples:
 
   | planType|  memberType  | copayCategory | firstName | lastName        |   dob 	            | memberid 	  | zipcode| userName 	         | password   |   email	  			           | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS      | BBABFAD   | BEDD            | 09/17/1946          | 002238311-1 | 92024	 |AUTO_q2_apr_uhc100   | Password@1 | codetransformers@gmail.com | number1   | name1     | color1    |