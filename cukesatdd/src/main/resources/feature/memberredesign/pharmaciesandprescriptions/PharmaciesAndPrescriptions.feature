@pharmaciesandprescriptions
Feature: To test Pharamcies And Prescriptions on Member site

### TODO: last 3 tiles - link validation to sso
### TODO: drug lookup tile for group - link validation to sso
### TODO: combo MAPD and ship tab behavior validation

  @pharmaciesandprescriptions01 @regressionMember
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   |	<planType>   |
	  | Member Type |	<memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
 	  | Plan Type   |	<planType>   |
	  | Member Type |	<memberType> |
    Then user validates header section content
    Then user validates pharmacies text content
    Then user validates pharmacies tiles section content
    Then user validates pharmacies tile Compare drug pricing page
    Then user validates pharmacies tile Find a network pharmacy page
    Then user validates pharmacies tile Order prescription refills page
    Then user validates pharmacies tile Check home delivery order status page
    Then user validates pharmacies tile Prescription Benefits Information page
    Then user validates Plan Materials link
    Then user validates Need Help section content

    Examples: 
	  | FID    | planType | memberType          |
	  | 313410 | MAPD     | AARP_Individual_PnP |
	  | 313410 | MAPD     | UHC_Individual_PnP  |
	  | 313410 | PDP      | Individual_PnP	    |
	  | 313410 | MEDICA   | Individual_PnP	    |
	  | 313410 | PCP      | Individual_PnP	    |
	  | 313410 | MAPD     | GROUP_PEEHIP_PnP    |
	  | 313410 | MAPD     | COMBO_PnP	        |
	  | 313410 | PDP      | COMBO_PnP	        |


  #####################################################
  # note: For terminated user, the PnP link on dashboard body and top menu will not be visible
  # note: This test is applicable to test via rally login only, validation will be skipped if access through testharness
  # note:
  @pharmaciesandprescriptions02 @NegativeScenario @regressionMember @regressionMember_Testharness
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - Verify member will not have access to Pharmacies and Prescriptions Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    ### note: rally data not sync up yet, won't be seeing link on dashboard until then 
    #Then user should not see Pharmacies and Prescription link on dashboard
    #  | Plan Type   | <planType>   |
    #  | Member Type | <memberType> |
    Then user should not see Pharmacies and Prescription link on secondary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |

    Examples: 
      | FID    | planType | memberType     |
      | 313410 | MAPD     | Terminated_PnP |
      | 313410 | MAPD     | PreEff_PnP     |
      | 313410 | MA       | Individual_PnP |
      | 313410 | SHIP     | Individual_PnP |


 