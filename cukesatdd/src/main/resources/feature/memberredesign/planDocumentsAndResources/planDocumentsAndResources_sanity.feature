@planAndDocuments @thePredators @regressionMember @E2E @feature-F368974
Feature: 1.06.7 Member Plans and Documents - Sanity

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPPlanDocuments |

  #------------------------------------------
  @planAndDocuments07 @vbfGate
  Scenario Outline: index: <index> -TID: <TID> -planType <planType> -memberType <memberType> - To sanity validate the plan documents and resources page 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
	Then user sanity validate Forms and Resources section
	  | Section Display                    | <fnr_sd>| 
	Then user sanity validate My Documents section
	  | Section Display                    | <md_sd> | 
	Then user sanity validate Explanation of Benefits section
	  | Section Display                    | <eob_sd>| 
	Then user sanity validate Renew Magazine section
	  | Section Display                    | <rm_sd> | 
	Then user sanity validate My Documents section
	  | Section Display                    | <md_sd> | 
	Then user sanity validate Explanation of Benefits section
	  | Section Display                    | <eob_sd>| 
	Then user sanity validate Renew Magazine section
	  | Section Display                    | <rm_sd> | 

	@active_mapd @sanity @devRegression
	Examples: 
      | index | TID         | planType | memberType            | pm_sd | mm_sd | an_sd | pd_sd | fnr_sd | md_sd | eob_sd | rm_sd |
      | S-01  | 15108       | MAPD     | AARP_IND_EFF_PDnR     | true  | true  | true  | true  | true  | true  | true   | true  |	

	@active_ship @sanity @devRegression
	Examples: 
      | index | TID         | planType | memberType            | pm_sd | mm_sd | an_sd | pd_sd | fnr_sd | md_sd | eob_sd | rm_sd |
      | S-02  | 15119,15304 | SHIP     | IND_EFF_PDnR          | true  | false | false | false | true   | false | true   | false |



    