@aprilRelease2018
Feature:To test HSID registration flow

 
   @US968241 @hsidregistration
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
   
   Examples:
 
   | planType|  memberType  | copayCategory | firstName | lastName        |   dob 	            | memberid 	  | zipcode| userName 	         | password   |   email	  			          | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS      | BBABFAD   | BEDD            | 09/17/1946          | 002238311-1 | 92024	 |AUTO_q2_apr_uhc100   | Password@1 | codetransformers@gmail.com | number1   | name1     | color1    |
   
   
   
   @AssistiveRegistration @US968323
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
   
    
   Examples:
 
   | planType|  memberType  | copayCategory | firstName | lastName        |   dob 	             | memberid 	  | zipcode  | userName 	         | password   |   email	  			           | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS       | BBABFAD   | BEDD            | 09/17/1946          | 002238311-1  | 92024	   |AUTO_q2_apr_uhc100   | Password@1 | codetransformers@gmail.com | number1   | name1     | color1    |
   
   
   @Login @US968315
   Scenario Outline:Verify HSID login functionality.
   Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
      
    Examples:
      
   | planType|  memberType  | copayCategory | 
   | MAPD    |  Individual  |  NON LIS      | 
   
   
@validateStep1 @US968241
    Scenario Outline:Verify feilds in HSID registration Step 1 page.
    Given the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And I click on Continue button
    And I should see error message "You have 5 field(s) that need to be corrected"
    And I should see error message "First name is required" for first name
    And I should see error message "Last name is required" for last name
    And I should see error message "Date of birth is required" for date of birth
    And I should see error message "Zip code is required" for zip code
    And I should see error message "Plan Member ID number is required" for member id



Examples:
   | planType|  memberType    | copayCategory  | firstName | lastName        |   dob 	             | memberid 	  | zipcode  | userName 	         | password   |   email	  			           | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS         | BBABFAD   | BEDD            | 09/17/1946            | 002238311-1    | 92024	 |AUTO_q2_apr_uhc100     | Password@1 | codetransformers@gmail.com     | number1   | name1     | color1    |