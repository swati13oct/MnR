@homeTestAARP
Feature: To test acquisition home page in AARP site
Scenario Outline: To Verify the acquisition home page for AARP site
Given the user is on the AARP medicare site landing page
When the user clicks on lookup zipcode link from AARP home page
And the user searches for zipcodes by entering the following Address and city and State details for AARP site
    | Address    | <Address>   |
    | City       | <city>      |
    | State      | <state>     |              
Then the user validates the list of zip codes
Examples:
  | Address | city          |  state     | 
  | 1234    | california    | California | 
  
Scenario Outline: To Verify the learn find plans functionality for AARP site
Given the user is on the AARP medicare site landing page
When the user enters a zipcode in learnfindplans textfield
    | zipcode      | <zipcode>     |              
Then the user validates the findplans new page is opened with specific title
Examples:
  | zipcode  |
  | 90210	|  
  
Scenario Outline: To Verify the learn find plans functionality for AARP site
Given the user is on the AARP medicare site landing page
When the user enters a zipcode in learnfindplans textfield
    | zipcode      | <zipcode>     |              
Then the user validates the findplans new page is opened with specific title
Examples:
  | zipcode  |
  | 90210	| 

Scenario Outline: To Verify the acquisition home page for AARP site
Given the user is on the AARP medicare site landing page
When the user clicks on takeaquiz button
 | pageTitle      | <pageTitle>     | 
Then the user validates the takeaquiz page is opened with specific title
Examples:
  | pageTitle  |
  | Plan Selector	|
    
Scenario Outline: To Verify the acquisition home page for AARP site
Given the user is on the AARP medicare site landing page
When the user clicks on whychooseuhc button
 | whychooseuhcPageTitle      | <whychooseuhcPageTitle>     | 
Then the user validates the whychooseuhc page is opened with specific title
Examples:
  | whychooseuhcPageTitle  |
  | Our Medicare Plan Types |
  
Scenario Outline: To Verify the learn more widget for AARP site
Given the user is on the AARP medicare site landing page
When the user picks a topic in learn more widget
    | Pickatopic      | <picktopic>     |              
Then the user validates the new page is opened with specific title
Examples:
  | picktopic  |
  | Discover More Resources	| 