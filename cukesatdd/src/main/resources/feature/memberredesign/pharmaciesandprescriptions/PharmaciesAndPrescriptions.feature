Feature: To test Pharamcies And Prescriptions on Member site

  @pnp01 @regressionMember
  Scenario Outline: FID: <TID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
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
    #Then user validates pharmacies tile Order prescription refills page
    #Then user validates pharmacies tile Check home delivery order status page
    #Then user validates pharmacies tile Prescription Benefits Information page
    Then user validates Plan Materials link
    Then user validates Need Help section content
    
   
    Examples: 
	  | FID    | planType | memberType          |
	  | 313410 | MAPD     | AARP_Individual_PnP |
	  | 313410 | MAPD     | UHC_Individual_PnP  |
	  | 313410 | PDP      | Individual_PnP	    |
	  | 313410 | SSUP     | UHC_Retire_PnP	    |
	  | 313410 | MEDICA   | Individual_PnP	    |
	  | 313410 | PCP      | Individual_PnP	    |
	  | 313410 | MAPD     | COMBO_PnP	        |

  @pnp02 @regressionMember
  Scenario Outline: FID: <TID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   |	<planType>   |
	  | Member Type |	<memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
 	  | Plan Type   |	<planType>   |
	  | Member Type |	<memberType> |
    
    Then user validates header section content
    Then user validates pharmacies text content
    Then user validates limited pharmacies tiles section content
    Then user validates pharmacies tile Compare drug pricing page
    Then user validates pharmacies tile Find a network pharmacy page
    Then user validates pharmacies tile Prescription Benefits Information page
    Then user validates Plan Materials link
    Then user validates Need Help section content
   
    Examples: 
	  | FID    | planType | memberType |
	  | 313410 | SHIP     | PEEHIP_PnP |

  #####################################################
  # note: For terminated user, the PnP link on dashboard body and top menu will not be visible
  # note: This test is applicable to test via rally login only, validation will be skipped if access through testharness
  # note:
  @pnp03 @NegativeScenario @regressionMember @regressionMember_Testharness
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify member will not have access to Pharmacies and Prescriptions Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user should not see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user should not see Pharmacies and Prescription link on secondary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |

    Examples: 
      | TID    | planType | memberType     |
      | 313410 | MAPD     | Terminated_PnP |
      | 313410 | MAPD     | PreEff_PnP     |
      | 313410 | MA       | Individual_PnP |
      | 313410 | SHIP     | Individual_PnP |


 