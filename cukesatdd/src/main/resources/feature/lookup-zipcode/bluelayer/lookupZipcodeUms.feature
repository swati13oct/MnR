@lookupZipcode
Feature: To look up a zipcode in UMS site
Scenario Outline: Verify Look up zipcode flow from home page in UMS site
When the user clicks on lookup zipcode link from UMS home page
And the user searches for zipcodes by entering the following Address and city and State details for UMS site
    | Address    | <Address>   |
    | City       | <city>      |
    | State      | <state>     |              
Then the user validates list of ZIP codes in UMS site

Examples:
  | Address | city          |  state     | 
  | 1234    | california    | California |   

Scenario Outline: Verify Look up zipcode flow from our plans page in UMS site
When the user clicks on lookup zipcode link in our plans page in UMS
And the user searches for zipcodes by entering the following Address and city and State details through our plans page for UMS site
    | Address    | <Address>   |
    | City       | <city>      |
    | State      | <state>     |              
Then the user validates list of ZIP codes in UMS site

Examples:
  | Address | city          |  state     | 
  | 1234    | california    | California |
  | 1267    | Aspen	    | Colorado   |
  | 1423    | Boise	    | Idaho      |
  | 1923    | Honolulu	    |  HAWAII    |
