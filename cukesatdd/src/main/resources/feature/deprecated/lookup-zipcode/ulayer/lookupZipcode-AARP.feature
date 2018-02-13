@lookupZipcode
Feature: To look up a zipcode in AARP site
Scenario Outline: Verify Look up zipcode flow from home page in AARP site
Given the user is on the AARP medicare site landing page
When the user clicks on lookup zipcode link in AARP home page
And the user searches for zipcodes by entering the following Address and city and State details for AARP site
    | Address    | <Address>   |
    | City       | <city>      |
    | State      | <state>     |              
Then the user validates list of ZIP codes in AARP site

Examples:
  | Address | city          |  state     | 
  | 1234    | california    | California |   

Scenario Outline: Verify Look up zipcode flow from our plans page in AARP site
Given the user is on the AARP medicare site landing page
When the user clicks on lookup zipcode link by navigating to our plans page in AARP
And the user searches for zipcodes by entering the following Address and city and State details through our plans page for AARP site
    | Address    | <Address>   |
    | City       | <city>      |
    | State      | <state>     |              
Then the user validates list of ZIP codes in AARP site

Examples:
  | Address | city          |  state     | 
  | 1234    | california    | California |
  | 1267    | Aspen	    | Colorado   |
  | 1423    | Boise	    | Idaho      |
  | 1923    | Honolulu	    |  HAWAII    |
