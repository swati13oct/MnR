

Feature:To test HSID functionality on Medicare site

    @US968324
    Scenario Outline: Verify HSID login page
   
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
    And register with following details logins in the member portal and validate elements 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    And user deregisters from M&R
    When the user validate username autofill
    And the user enters password and confirm password field
    And the user enters email and confirm email field
    And the user clicks submit button
    When the user validate all fields on this page
    And  the user validate security questions option and user answer all security questions
      | Option  | <option>  |
      | Option1 | <option1> |
      | Option2 | <option2> |
      | Option3 | <option3> |
    And the user check checkboxes
    And the user clicks submit button
    
    
      Examples:
      
       | planType|  memberType  | copayCategory | option              | option1                          | option2                      | option3                          |firstname  | lastname  | username      |
       | MAPD    |  Individual  |  NON LIS      | Security questions  | What was your first phone number?| What is your favorite color? | What is your best friend's name? |EDEEB      | EAAFEF    | q1_feb_sfl035 |
       
       
   
   @US968323
    Scenario Outline:Verify HSID registration.
    Given the user is on medicare sign in page
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