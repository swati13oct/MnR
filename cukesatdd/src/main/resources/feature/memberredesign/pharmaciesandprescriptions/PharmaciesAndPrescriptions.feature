@pharmaciesandprescriptions @Predators
Feature: To test Pharamcies And Prescriptions on Member site

#----- beginning of VBF scenarios section ------------------   
  @F313410 @vbfGate
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
 	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user validates header section content
    Then user validates pharmacies text content
    Then user validates pharmacies tiles section content
    
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MAPD     | AARP_Individual_PnP | yes        |
    
#----- end of VBF scenarios section ------------------   

#----- being regression section --------------------
  @pharmaciesandprescriptions01 @E2E @feature-F313410 @hasPnpLink @regressionMember
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    Then user should see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the claims page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link
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

    @pharmaciesandprescriptions01a
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MAPD     | AARP_Individual_PnP | yes        |
	  | 313410 | MAPD     | UHC_Individual_PnP  | yes        |

    @pharmaciesandprescriptions01b
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | PDP      | Individual_PnP	    | yes        |
	  | 313410 | MAPD     | GROUP_PEEHIP_PnP    | yes        |

    @pharmaciesandprescriptions01c
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MEDICA   | Individual_PnP	    | yes        |
	  | 313410 | PCP      | Individual_PnP	    | yes        |

    @pharmaciesandprescriptions01d
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MAPD     | COMBO_PnP	        | yes        |
	  | 313410 | PDP      | COMBO_PnP	        | yes        |


  #####################################################
  # note: For terminated user, the PnP link on dashboard body and top menu will not be visible
  # note: This test is applicable to test via rally login only, validation will be skipped if access through testharness
  # note:
  @pharmaciesandprescriptions02 @feature-F313410 @noPnpLink @NegativeScenario @regressionMember @regressionMember_Testharness
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - Verify member will not have access to Pharmacies and Prescriptions Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user should not see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the claims page to validate no Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate no Pharamcies and Prescriptions link
    Then user navigates to the payment page to validate no Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate no Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate no Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate no Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate no Pharamcies and Prescriptions link
 
   Examples: 
      | FID    | planType | memberType     | expectLink | 
      | 313410 | MAPD     | Terminated_PnP | no         |
      | 313410 | MAPD     | PreEff_PnP     | no         |
      | 313410 | MA       | Individual_PnP | no         |
      | 313410 | SHIP     | Individual_PnP | no         |


 