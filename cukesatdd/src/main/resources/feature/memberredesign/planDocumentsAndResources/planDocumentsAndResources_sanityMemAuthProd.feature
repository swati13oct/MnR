@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.7.1 Member Plans and Documents - Sanity - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @prod_planAndDocuments07
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content - Part 1 of 2 
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
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	Then user validates header section content for Plan Documents and Resources page
	Then user sanity validates section Plan Materials
	  | Section Display                    | <pm_sd> | 
	Then user sanity validates section Membership Materials or Welcome Guide
	  | Section Display                    | <mm_sd> | 
	Then user sanity validates section Annual Notice of Changes Documents
	  | Section Display                    | <an_sd> | 
	Then user sanity validates section Provider Directory or Pharmacy Directory or Provider and Pharmacy Directories
	  | Section Display                    | <pd_sd> | 

	@prod_active_mapd_1of2 @sanity
	Examples: 
      | index | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | mm_sd | an_sd | pd_sd |
      | S-01  | 15108       | kkumard   | mnrs786@  | BILL.ROSNER123# | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true  |	

	@prod_active_ship_1of2 @sanity
	Examples: 
      | index | TID         | username  | password  | MemUserName     | planType | memberType            | pm_sd | mm_sd | an_sd | pd_sd |
      | S-02  | 15119,15304 | kkumard   | mnrs786@  | Pramila1946     | SHIP     | IND_EFF_PDnR          | true  | false | false | false |
      
  #------------------------------------------
  @prod_planAndDocuments08
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To validate the plan documents and resources page content - Part 2 of 2 
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
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	Then user validates header section content for Plan Documents and Resources page
	Then user sanity validate Forms and Resources section
	  | Section Display                    | <fnr_sd>| 
	Then user sanity validate My Documents section
	  | Section Display                    | <md_sd> | 
	Then user sanity validate Explanation of Benefits section
	  | Section Display                    | <eob_sd>| 
	Then user sanity validate Renew Magazine section
	  | Section Display                    | <rm_sd> | 

	@prod_active_mapd_2of2 @sanity
	Examples: 
      | index | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | md_sd | eob_sd | rm_sd |
      | S-01  | 15108       | kkumard   | mnrs786@  | BILL.ROSNER123# | MAPD     | AARP_IND_EFF_PDnR     | true   | true  | true   | true  |	

	@prod_active_ship_2of2 @sanity
	Examples: 
      | index | TID         | username  | password  | MemUserName     | planType | memberType            | fnr_sd | md_sd | eob_sd | rm_sd |
      | S-02  | 15119,15304 | kkumard   | mnrs786@  | Pramila1946     | SHIP     | IND_EFF_PDnR          | true   | false | true   | false |
      
      