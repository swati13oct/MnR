@smokeTest
Feature: 1.15-VBF-MemRedesign-To test HSID registration flow

@smokeTest_HSIDregistration @rallyDashboard @testharness
   Scenario Outline:Verify HSID registration for <membertype>
     And the user select record from database
       | Firstname  | <firstname>  |
       | Lastname   | <lastname>   |
     And the user delete record from extreme scale
     And the user delete record from mbr_portal
     And the user delete record from mbr
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
   When registered user logs in post registration
    | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
  Then member should navigate to Home page
  Then user should see a latest unread mail recieved  in mail server
   
   Examples:
 
 | membertype | firstname  | lastname |    dob 	    | memberid 	    | zipcode | password   |   				email	  			    | friendname | favcolor | phonenumber |
 | federal    | FABCAEAD   | EFCEAA   | 09/22/1949   | 961861481-1   | 34748	  | Password@1 | codetransformers@gmail.com | name1      | color1   | number1     |
 | Ship 		  | SGFXTEFI   | NHKBOHYG | 12/01/1941   | 375989563-11  | 46221   | Password@1 | codetransformers@gmail.com | name1      | color1   | number1     |
#| Federal    | FABCAEAD   | EFCEAA   | 09/22/1949   | 961861481-1   | 34748  	| Password@1 | codetransformers@gmail.com | name1      | color1   | number1     |    