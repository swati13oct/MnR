@smokeTest
Feature: 1.15-VBF-MemRedesign-To test HSID registration flow

@smokeTest_HSIDregistration @rallyDashboard @testharness
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
    And the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And enter first name, last name, date of birth, zip code, member id and click continue
      | firstName   | <firstname>|
      | lastName    | <lastname> |
      | dob         | <dob>      |
      | memberid    | <memberid> |
      |zipcode 	    | <zipcode>  |
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
  #And user should be at Sign In page
    #   | userName   | <userName>   |  
     #  | password   | <password>   |  
  And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
   When the above plantype user logs in member redesign for Direct Login
    | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
  Then user should see a latest unread mail recieved  in mail server
   
   Examples:
 
   | planType|  memberType  | copayCategory | firstname | lastname        |   dob 	            | memberid 	  | zipcode  | userName 	       | password   |   email	  			          | question1 | question2 | question3 |friendname | favcolor | phonenumber |
   | MAPD    |  Individual  |  NON LIS      | AFAFBBF   | AECFEC          | 05/15/1950          | 954668573-1 | 78501	 |q1_feb_uhc042        | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |name1      | color1   | number1     |
   
   