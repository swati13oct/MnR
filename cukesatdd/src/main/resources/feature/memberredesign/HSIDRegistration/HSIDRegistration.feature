@hsid 
Feature: To test HSID registration flow

Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature | UCPUserManagement |
###############################Regression Scenarios Begin Here ########################################

   @hsid1 @US968241 @hsidregistration @regressionMember
   Scenario Outline:Plan Type: <planType>-Verify HSID registration.
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
    #And the user deregister from M&R LDAP
       #| Username  | <userName>  |
   And the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And enter first name, last name, date of birth, zip code, member id and click continue
      | firstName   | <firstname>|
      | lastName    | <lastname> |
      | dob         | <dob>      |
      | memberid    | <memberid> |
      |zipcode 	    | <zipcode>  |
   #And user is navigated to step two:create account page
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
  Then user should copy the email url to browser
  And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
  And Validate registered user login from email link
       | userName | <userName> |
       | password | <password> |
   Examples:
   | planType|  memberType  | copayCategory | firstname | lastname   |   dob 	  | memberid 	 | zipcode | password   |   email	  			      | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS      | KIL   	| GONZALIS   | 08/31/1950 | 016792516-1  | 11420   | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |
   | PDP     |  Individual  |  NON LIS      | LAT   	| HENKE      | 08/22/1992 | 018229742-1  | 51047   | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |
   | SHIP    |  Individual  |  NON LIS      | MARDI  	| MICHALS    | 10/25/1923 | 099469108-11 | 93160   | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |
   | Combo   |  Individual  |  NON LIS      | NELA      | MACLACHLAN | 12/07/1937 | 012806140-1  | 00801   | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |

 @hsid1 @US968241 @hsidregistration @regressionMember
  Scenario Outline:Plan Type: <planType>-Verify HSID registration and login from confirm registration mail.
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
   And the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And enter first name, last name, date of birth, zip code, member id and click continue
      | firstName   | <firstname>|
      | lastName    | <lastname> |
      | dob         | <dob>      |
      | memberid    | <memberid> |
      |zipcode 	    | <zipcode>  |
   And enter username, password, re-enter password, email, re-enter email
      | password   | <password> |
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
  Then user should copy the email url to browser
  And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
  And user should see registration completed unread mail received in provided email address
  And user should copy the email url to browser
  And Validate registered user login from email link
       | userName | <userName> |
       | password | <password> |
	Examples:
   | planType  |  memberType | copayCategory | firstname | lastname  |   dob 	  | memberid 	| zipcode | password   | email	  			         | question1 | question2 | question3 |
   | MA        |  Individual |  NON LIS      | SHER    	 | SHUTTERS  | 06/24/1939 | 810387190-1 | 84310	  | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |
   | Medica    |  Individual |  NON LIS      | THEADORE  | NIKOCEVIC | 01/03/1942 | 912020922-1 | 33190	  | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |
   | PCP       |  Individual |  NON LIS      | SIDNEY    | HULME     | 06/28/1952 | 971404385-1 | 33189	  | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |
   | Termed<12 |  Individual |  NON LIS      | NICOLETTE | HINT      | 08/19/1950 | 019743661-1 | 60454	  | Password@1 | codetranformer004@gmail.com | number1   | name1     | color1    |
   
    	@hsid3 @validateStep1 @US968241 @hsidregistrationErrorMsg @hsidregistration @regressionMember
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
   
   	 @hsidregistrationErrorMsgForTerminatedMember @hsidregistration @regressionMember
    Scenario Outline:Verify Error messages in HSID registration page for terminated member
 	And the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And enter members first name, last name, date of birth, zip code, member id and click on continue
      | firstName   | <firstname>|
      | lastName    | <lastname> |
      | dob         | <dob>      |
      | memberid    | <memberid> |
      |zipcode 	    | <zipcode>  |
   And I should see error message "We're having trouble finding you in our records. Please check that your entries match the information on your health insurance ID card." for terminated member
   Examples:
    | planType|  memberType  | copayCategory | firstname | lastname        |   dob 	            | memberid 	  | zipcode  | userName 	        | password   |   email	  			          | question1 | question2 | question3 |
    | MAPD    |  Individual  |  NON LIS      | MAHMUDE   | GIALLORENZO     | 01/03/1974         | 000026695-1 | 84408	 |q2_jun_aarp0074       | Password@1 | codetransformertesting@gmail.com     | number1   | name1     | color1    |
   
    @hsid2 @AssistiveRegistration @US968323 
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
  And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
  And user should be at Sign In page
  Then user should see a latest unread mail recieved  in mail server
   
    
   Examples:
 
   | planType|  memberType  | copayCategory  | userName 	         | password   |   email	  			           | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS       |AUTO_q2_apr_uhc100   | Password@1 | codetransformers@gmail.com | number1   | name1     | color1    |
   
   
   
      
      
      