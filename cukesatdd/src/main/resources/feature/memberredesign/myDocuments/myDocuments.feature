@myDocuments  @thePredators @regressionMember @E2E @feature-F368974
Feature: Member My Documents Page

Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the My Documents page E2E Scenario
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
   And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then validate that My Document section is displayed
    Then the user navigates to my Documents Page
    Then user validates header section content on My Documents Page
	#----------------- Test for 90 days----------
    And then the user searches documents for a valid Period on My documents page
    | Search Range | Last 90 days |
   Then I validate the Documents Table if present 
   #----------------- Test for 6 months----------
    And then the user searches documents for a valid Period on My documents page
    | Search Range | Last 6 months |
   Then I validate the Documents Table if present 
      #----------------- Test for 12 months----------
    And then the user searches documents for a valid Period on My documents page
    | Search Range | Last 12 months |
   Then I validate the Documents Table if present 
       #----------------- Test for 24 months----------
    And then the user searches documents for a valid Period on My documents page
    | Search Range | Last 24 months |
   Then I validate the Documents Table if present 
        #----------------- Test for Current Year----------
    And then the user searches documents for a valid Period on My documents page
    | Search Range | Current Year |
    Then I validate the Documents Table if present 
        #----------------- Test Custom calendar--------------------------
 And then the user searches documents for a valid Period on My documents page
     |  Search Range | Custom Search |
	Then I can validate the calendar will show up for custom search when user clicks on From and To calendars    
	Then I validate the Documents Table if present
  And I should be able to see the error messages when to and from dates are not entered
  And I custom search documents for the following invalid time interval on my Documents page
      | From Date | 12/12/2019 |
      | To Date   | 12/12/2018 |
  And I validate the Note  text on my Documents Page
  And I validate the disclaimer on my Documents Page 
 Then I validate Need Help section on my Documents Page
    

    Examples: 
      | TID   | planType | memberType          |                
      | 10000 | MAPD       | Individual_MyDocuments|

    