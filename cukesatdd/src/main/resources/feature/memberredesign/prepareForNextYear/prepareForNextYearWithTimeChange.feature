@prepareForNextYear
Feature: 1.21 Member Prepare For Next Year - With system time change test step

  #------------------------------------------------------------------------------------------	    
  # caution: aggressive scenario
  # caution: will change system date throughout the test
  # caution: should run it on team env only not as to impact other teams	
  # caution: examples in this scenario must be run sequential, no parallel    
  #------------------------------------------------------------------------------------------	    
  @prepareForNextYear03 @withSystemTimeChange @teamEnv
  Scenario Outline: -Index <index> -FID <FID> -Plan Type: <planType> -Member Type: <memberType> - To verify Prepare For Next Year tab and page display behavior throughout different milestones
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | Speed Up    | true               |
	Then test setup stores original system date for roll back later
	Then test setup stores AEM and timeline milestones info
      | EndOfTestRollBackTime  | true           |
      | AEM Show Tab StartDate | 06/16/2020     |
      | AEM Show Tab EndDate   | 01/02/2021     |
      | AEM Toggle             | ON             |
      | Milestone 1 Date       | 09/15/2020     |
      | Milestone 2 Date       | 10/01/2020     |
      | Milestone 3 Date       | 10/15/2020     |
      | Milestone 4 Date       | 12/07/2020     |
      | Milestone 5 Date       | 01/01/2021     |
    Then test setup stores documents expectation info  
      | Annual Notice of Changes English       | <an_us> | 
      | Annual Notice of Changes Spanish       | <an_es> |
      | Annual Notice of Changes Chinese       | <an_zh> |
      | Evidence of Coverage English           | <ev_us> |
      | Evidence of Coverage Spanish           | <ev_es> |
      | Evidence of Coverage Chinese           | <ev_zh> |
      | Provider Directory English             | <pr_us> |
      | Provider Directory Spanish             | <pr_es> |
      | Provider Directory Chinese             | <pr_zh> |
      | Vendor Information Sheet English       | <ve_us> |
      | Vendor Information Sheet Spanish       | <ve_es> |
      | Vendor Information Sheet Chinese       | <ve_zh> |
      | Pharmacy Directory Information English | <ph_us> |
      | Pharmacy Directory Information Spanish | <ph_es> |
      | Pharmacy Directory Information Chinese | <ph_zh> |
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
    #----- note: on page is to display from 9/1-12/31 and milestone 5 is 1/1 
    #----- note: with AEM end date set to 12/31 will not run into this case normally
	#Then test setup changes system date to after or equal milestone5 and before AEM end date
	#  | Test System Date | 01/02/2021 |
	#When login with following details logins in the member portal and validate elements
    #  | Plan Type   | <planType>         |
    #  | Member Type | <memberType>       |
    #  | Speed Up    | true               |
    #Then the user validates Prepare For Next Year tab display behavior on Benefits page
	#Then the user navigate to Prepare For Next Year page via Prepare For Next Year tab
	#Then the user validates Prepare For Next Year page content
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

    @prepareForNextYear03_ind
    Examples: 
	    | index | FID     | planType | memberType         | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh |
	    | 12    | F437767 | MAPD	 | IND_PFNY           | true  | true  | false | false | false | false | false | false | false | false | false | false | false | false | false |

    @prepareForNextYear03_grp
    Examples: 
	    | index | FID     | planType | memberType         | an_us | an_es | an_zh | ev_us | ev_es | ev_zh | pr_us | pr_es | pr_zh | ve_us | ve_es | ve_zh | ph_us | ph_es | ph_zh |
	    | 13    | F437767 | MAPD	 | GRP_PFNY           | true  | true  | false | false | false | false | false | false | false | false | false | false | false | false | false |

