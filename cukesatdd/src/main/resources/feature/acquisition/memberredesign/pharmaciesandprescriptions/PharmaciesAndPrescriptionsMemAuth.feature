@pharmaciesandprescriptions @Predators
Feature: 1.18 Member Pharamcies And Prescriptions page

#----- being non regression section --------------------
  @memAuth_pharmaciesandprescriptions01 @E2E @feature-F313410 @hasPnpLink
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
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
    Then user should see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
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

    @memAuth_pharmaciesandprescriptions01a
    Examples: 
	  | FID    | username  | password  | MemUserName     | planType | memberType          | expectLink |
	  | 313410 | qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | AARP_Individual_PnP | yes        |
	  | 313410 | qavgogine | qavgogine | q2_jun_uhc0009    | MAPD     | UHC_Individual_PnP  | yes        |

    @memAuth_pharmaciesandprescriptions01b
    Examples: 
	  | FID    | username  | password  | MemUserName     | planType | memberType          | expectLink |
	  | 313410 | qavgogine | qavgogine | q2_jun_aarp0076    | PDP      | Individual_PnP	    | yes        |

    #note: PEEHIP terminated plan with UHC on 12/31/2019, not valida case anymore
    #note: moving it to terminated case
    #@pharmaciesandprescriptions01b
    #Examples: 
	#  | FID    | username  | password  | MemUserName     | planType | memberType          | expectLink |
	#  | 313410 | qavgogine | qavgogine | testusername    | MAPD     | GROUP_PEEHIP_PnP    | yes        |

    @memAuth_pharmaciesandprescriptions01c
    Examples: 
	  | FID    | username  | password  | MemUserName     | planType | memberType          | expectLink |
	  | 313410 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020    | MEDICA   | Individual_PnP	    | yes        |
	  | 313410 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl022    | PCP      | Individual_PnP	    | yes        |

    @memAuth_pharmaciesandprescriptions01d
    Examples: 
	  | FID   | username  | password  | MemUserName      | planType | memberType          | expectLink |
	  | 313410 | qavgogine | qavgogine | q2_may_combo006    | MAPD     | COMBO_PnP	        | yes        |
	 #| 313410 | qavgogine | qavgogine | testusername    | PDP      | COMBO_PnP	        | yes        |

    @memAuth_pharmaciesandprescriptions01d
    Examples: 
	  | FID    | username  | password  | MemUserName     | planType | memberType          | expectLink |
	  | 313410 | qavgogine | qavgogine | q3_sep_UAT4_UHC116    | PDP      | COMBO_GROUP_PnP	    | yes        |


  #####################################################
  # note: For terminated user, the PnP link on dashboard body and top menu will not be visible
  # note: This test is applicable to test via rally login only, validation will be skipped if access through testharness
  # note:
  @memAuth_pharmaciesandprescriptions02 @feature-F313410 @noPnpLink @NegativeScenario
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - Verify member will not have access to Pharmacies and Prescriptions Page
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
    Then user should not see Pharmacies and Prescription link on dashboard
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link

   Examples: 
      | FID    | username  | password  | MemUserName     | planType | memberType     | expectLink | 
      | 313410 | qavgogine | qavgogine | q1_grp_apr031    | MAPD     | Terminated_PnP | no         |
      | 313410 | qavgogine | qavgogine | q3_sep_UAT4_AARP010    | PDP      | PreEff_PnP     | no         |
      | 313410 | qavgogine | qavgogine | q2_may_rally017    | MA       | Individual_PnP | no         |
      | 313410 | qavgogine | qavgogine | q1_feb_ship_20_001    | SHIP     | Individual_PnP | no         |


 