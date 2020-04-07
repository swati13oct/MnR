@pharmaciesandprescriptions @Predators
Feature: 1.18 Member Pharamcies And Prescriptions page

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
   #note: uncomment payment page when one-time payment button is showing again
   # Then user navigates to the payment page to validate Pharamcies and Prescriptions link
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
    #note: moved to footer feature
    #Then user validates Need Help section content

@abc    @pharmaciesandprescriptions01a @devRegression
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MAPD     | AARP_Individual_PnP | yes        |

    @pharmaciesandprescriptions01a
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MAPD     | UHC_Individual_PnP  | yes        |

    @pharmaciesandprescriptions01b
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | PDP      | Individual_PnP	    | yes        |

    #note: PEEHIP terminated plan with UHC on 12/31/2019, not valida case anymore
    #note: moving it to terminated case
    #@pharmaciesandprescriptions01b
    #Examples: 
	#  | FID    | planType | memberType          | expectLink |
	#  | 313410 | MAPD     | GROUP_PEEHIP_PnP    | yes        |

    @pharmaciesandprescriptions01c
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MEDICA   | Individual_PnP	    | yes        |
	  | 313410 | PCP      | Individual_PnP	    | yes        |

    @pharmaciesandprescriptions01d
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | MAPD     | COMBO_PnP	        | yes        |
	 #| 313410 | PDP      | COMBO_PnP	        | yes        |

    @pharmaciesandprescriptions01d @devRegression
    Examples: 
	  | FID    | planType | memberType          | expectLink |
	  | 313410 | PDP      | COMBO_GROUP_PnP	    | yes        |


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
    Then user navigates to the eob page to validate Pharamcies and Prescriptions link
    Then user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link
    Then user navigates to the payment page to validate Pharamcies and Prescriptions link
    Then user navigates to the health and wellness page to validate Pharamcies and Prescriptions link
    Then user navigates to the contact us page to validate Pharamcies and Prescriptions link
    Then user navigates to the account setting to validate Pharamcies and Prescriptions link
    Then user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link

   Examples: 
      | FID    | planType | memberType     | expectLink | 
      | 313410 | MAPD     | Terminated_PnP | no         |
      | 313410 | PDP      | PreEff_PnP     | no         |
      | 313410 | MA       | Individual_PnP | no         |
      
   @ship @devRegression
   Examples: 
      | FID    | planType | memberType     | expectLink | 
      | 313410 | SHIP     | Individual_PnP | no         |

  #----- beginning of test for offline prod - local run only ------------------
  # DO NOT REMOVE this scenario
  # This scenario is not part of the regular regression run BUT is for aiding the team to do offline prod testing if needed
  # note: this setup is for the case when we need to validate on offline prod environment
  # note: this is intended for local run where you can put in your own member auth username/password and offline username
  # note: run with environment variable set to offline. -Denvironment="offline"
  # note: *** DO NOT save your login or test username to github ***
  # note: replace the following fields with valid value -
  # note:   username = your memAuth page login username
  # note:   password = your memAuth page login password
  # note:   MemUsername =  username of the user on offline prod that you want to test
  # note:   planType = the type of plan this test user has e.g. MAPD/MA/SHIP, etc
  # note:   memberType = e.g. Individual / GROUP/ COMBO, etc
  @forLocalTestOnly01
  Scenario Outline: To validate via member authorization access for claims
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    ### --- from this point onward will test same as on stage
    Then user should see Pharmacies and Prescription link on dashboard
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
    #note: moved to footer feature
    #Then user validates Need Help section content

    @forLocalTestOnly01_pharmaciesandprescriptions01a
    Examples: 
	  | FID    | planType | memberType          | expectLink | username   | password   | MemUserName  | 
	  | 313410 | MAPD     | AARP_Individual_PnP | yes        | myUsername | myPassword | testUsername |
	  | 313410 | MAPD     | UHC_Individual_PnP  | yes        | myUsername | myPassword | testUsername |

    @forLocalTestOnly01_pharmaciesandprescriptions01b
    Examples: 
	  | FID    | planType | memberType          | expectLink | username   | password   | MemUserName  | 
	  | 313410 | PDP      | Individual_PnP	    | yes        | myUsername | myPassword | testUsername |

    @forLocalTestOnly01_pharmaciesandprescriptions01c
    Examples: 
	  | FID    | planType | memberType          | expectLink | username   | password   | MemUserName  | 
	  | 313410 | MEDICA   | Individual_PnP	    | yes        | myUsername | myPassword | testUsername |
	  | 313410 | PCP      | Individual_PnP	    | yes        | myUsername | myPassword | testUsername |

    @forLocalTestOnly01_pharmaciesandprescriptions01d
    Examples: 
	  | FID    | planType | memberType          | expectLink | username   | password   | MemUserName  | 
	  | 313410 | MAPD     | COMBO_PnP	        | yes        | myUsername | myPassword | testUsername |
	  | 313410 | PDP      | COMBO_PnP	        | yes        | myUsername | myPassword | testUsername |


  @forLocalTestOnly02
  Scenario Outline: To validate via member authorization access for PnP
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    ### --- from this point onward will test same as on stage
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
      | FID    | planType | memberType     | expectLink | username   | password   | MemUserName  |  
      | 313410 | MAPD     | Terminated_PnP | no         | myUsername | myPassword | testUsername |
      | 313410 | MAPD     | PreEff_PnP     | no         | myUsername | myPassword | testUsername |
      | 313410 | MA       | Individual_PnP | no         | myUsername | myPassword | testUsername |
      | 313410 | SHIP     | Individual_PnP | no         | myUsername | myPassword | testUsername |
	  
  #----- end of claims test for offline prod - local run only ------------------
 