@prepareForNextYear
Feature: 1.21 Member Prepare For Next Year - With system time change test step

  #------------------------------------------------------------------------------------------	    
  # caution: aggressive scenario
  # caution: will change system date throughout the test
  # caution: should run it on team env only not as to impact other teams	
  # caution: examples in this scenario must be run sequential, no parallel    
  #------------------------------------------------------------------------------------------	    
  @prepareForNextYear03 @withSystemTimeChange
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page display behavior throughout different milestones
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
	Then test setup stores original system date for roll back later
      | EndOfTestRollBackTime  | true           |
	Then test setup stores AEM and timeline milestones info
      | AEM Show Tab StartDate | 06/01/2020     |
      | AEM Show Tab EndDate   | 01/02/2021     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    #----- case - system date < AEM start date
	Then test setup changes system date to before AEM start date
	  | Test System Date | 05/15/2020 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
    #----- case - AEM start date <= system date < milestone 1
	Then test setup changes system date to after AEM start date before milestone1 date
	  | Test System Date | 09/05/2020 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
    #----- case - milestone 1 <= system date < milestone 2
	Then test setup changes system date to after or equal milestone1 date and before milestone2
	  | Test System Date | 09/20/2020 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
    #----- case - milestone 2 <= system date < milestone 3
	Then test setup changes system date to after or equal milestone2 date and before milestone3
	  | Test System Date | 10/10/2020 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
    #----- case - milestone 3 <= system date < milestone 4
	Then test setup changes system date to after or equal milestone3 date and before milestone4
	  | Test System Date | 11/10/2020 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
    #----- case - milestone 4 <= system date < milestone 5
	Then test setup changes system date to after or equal milestone4 date and before milestone5
	  | Test System Date | 12/15/2020 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
    #----- case - milestone 5 <= system date < AEM end date
	Then test setup changes system date to after or equal milestone5 and before AEM end date
	  | Test System Date | 01/02/2021 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
    #----- case - AEM end date <= system date
	Then test setup changes system date to after or equal AEM end date
	  | Test System Date | 01/07/2021 |
	When login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
    Then the user validates Prepare For Next Year tab display behavior on Benefits page
	Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	Then the user validates Prepare For Next Year page content
	Then test setup rolls back system date to current date for clean up after test

    Examples: 
	    | index | FID     | planType | memberType         |
	    | 12    | F437767 | MAPD	 | IND_PFNY           |
	    | 13    | F437767 | MAPD	 | GRP_PFNY           |

