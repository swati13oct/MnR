#Author: namita_meher@optum.com
Feature: Dual Landing Page

 # @uhccp
  Scenario Outline: Dual Landing Page - Request an Agent form validation
    Given User is on the UHCCP landing page
    Then User clicks on Medicare dual from Contact us hover over
    Then User clicks on form link to meet an Agent in Contact Us Page
    And user fills the Contact Request form in Dual Landing page
    	| First Name	| <fname>	|
    	| Last Name		| <lname>	|
    	| Address1		| <adr1>	|
    	| Address2		| <adr2>	|
    	| City				| <city>	|
    	| State				| <state>	|
    	| Zip Code		| <zip>		|
    	| Email				| <email>	|
    	| Phone No.		| <phnum>	|
    Then user clicks on Submit Request for Contact Request form in Dual Landing page
 
    Examples: 
      | fname           | lname           | adr1                 | adr2  | city    | state   | zip   | email                  	| phnum        |         
      | Test-Portals-FN | Test-Portals-LN | 12529 State Road 535 | Ste   | Orlando | Florida | 32836 | uhcmnrportals@gmail.com 	| 952-931-4701 |  
     