@homeTestUMS
Feature: To test acquisition home page in UMS site
Scenario Outline: To Verify the acquisition home page for UMS site
Given the user is on the UMS medicare site landing page
When the user clicks on lookup zipcode link from UMS home page
And the user searches for zipcodes by entering the following Address and city and State details for UMS site
    | Address    | <Address>   |
    | City       | <city>      |
    | State      | <state>     |              
Then the user validates the list of zip codes in UMS site
Examples:
  | Address | city          |  state     | 
  | 1234    | california    | California | 
  
Scenario Outline: To Verify the find plans functionality for UMS site
Given the user is on the UMS medicare site landing page
When the user enters a zipcode in findplans textfield in UMS site
    | zipcode      | <zipcode>     |              
Then the user validates the findplans new page is opened with specific title in UMS site
Examples:
  | zipcode  |
  | 90210	| 
  | 90002	|
  | 07054   |
  
Scenario Outline: To Verify the learn find plans functionality for UMS site
Given the user is on the UMS medicare site landing page
When the user enters a zipcode in learnfindplans textfield in UMS site
    | zipcode      | <zipcode>     |              
Then the user validates the findplans new page is opened with specific title in UMS site
Examples:
  | zipcode  |
  | 90210	| 
  | 90002	|
  | 07054   |
  
  
Scenario Outline: To Verify the learn more widget for UMS site
Given the user is on the UMS medicare site landing page
When the user picks a topic in learn more widget in UMS site
    | Pickatopic      | <picktopic>     |              
Then the user validates the new page is opened with specific title in UMS site
Examples:
  | picktopic  |
  | Discover More Resources	| 


Scenario Outline: To Verify the takeaquiz widget for UMS site
Given the user is on the UMS medicare site landing page
When the user clicks on takeaquiz in UMS site
Then the user validates the takeaquiz page is opened with specific title in UMS site