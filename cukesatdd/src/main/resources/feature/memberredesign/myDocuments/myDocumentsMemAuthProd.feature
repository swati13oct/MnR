@myDocuments  @thePredators @E2E @feature-F368974 @F434260
Feature: 1.06.7 Member My Documents Page- Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPMyDocuments |

  @prod_myDocuments01
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the My Documents page E2E Scenario
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
    Then the user navigates to my Documents Page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
    And then the user validates the Documents Table if present in past twenty four months time frame
      | Documents Expected | <documentsExpectedInPast24Months> |
    #----------------- Test for Current Year----------
    And then the user searches documents for a valid Period on My documents page
      | Search Range | Current Year |
    Then I validate the Documents Table if present for Current Year
    #----------------- Test Custom calendar--------------------------
    And then the user searches documents for a valid Period on My documents page
      |  Search Range | Custom Search |
	Then I can validate the calendar will show up for custom search when user clicks on From and To calendars    
	Then I validate the Documents Table if present
    And I should be able to see the error messages when to and from dates are not entered
    And I custom search documents for the following invalid time interval on my Documents page
      | From Date | 12/12/2019 |
      | To Date   | 12/12/2018 |
    #----------------- Test Misc--------------------------
    And I validate the Note  text on my Documents Page
    And I validate the disclaimer on my Documents Page 
    #note: moved to footer feature
    #Then I validate Need Help section on my Documents Page
      
    #------------Pass documents expected flag as Y or N only--------------
    Examples: 
    | TID   | username  | password  | MemUserName      | planType | memberType            | documentsExpectedInPast24Months  |             
    | 10000 | ujethwa  | 221Umang  | TEAKSAMPPALA1    | MAPD     | Individual_MyDocuments|           Y                      |
    | 10001 | ujethwa  | 221Umang | WILLIAMGARRISON48 | MAPD     | Group_MyDocuments     |           Y                      |
    | 10002 | ujethwa  | 221Umang | rldf1942       | COMBO    | FedAndShip_MyDocuments|           Y                    |