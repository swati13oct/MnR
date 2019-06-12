@claims @thePredetors
Feature: T1.1To validate the claims Summary page and claims Details page on the member site

  #----- beginning of VBF claims scenarios section ------------------
  @smokeTest @MemberVBF @rallyDashboard @testharness
  Scenario Outline: To validate that claims are present on claims summary page and claims details page for <claimssystem>
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Claim System | <claimSystem> |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
      | Member Type  | <memberType>  |
    Then I validate the claims displayed based on the selection on claims summary page
    And I validate the EOB section based on claims system on claims summary page
    And I validate the DownloadMyData section on claims summary page
    And I can navigate to the Claim Details page from claims summary page
    And I can validate the Claims Table on claims details page
    And I can validate the Claims Total on claims details page

    @smokeTest_Claims
    Examples: 
      | memberType | planType | claimPeriod    | claimSystem  |
      | ShipInd    | SHIP     | Last 24 months | SHIPCLAIMS   |
      | ULayerInd  | MAPD     | Last 24 months | COSMOSCLAIMS |
      | ULayerInd  | MAPD     | Last 24 months | NICECLAIMS   |
      | ULayerInd  | MAPD     | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | BlueLayerInd | MAPD     | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | GroupRetiree | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | RxCLAIMS     |

    @gatingTest_Claims
    Examples: 
      | memberType | planType | claimPeriod    | claimSystem  |
      | ShipInd    | SHIP     | Last 24 months | SHIPCLAIMS   |
      | ULayerInd  | MAPD     | Last 24 months | COSMOSCLAIMS |

    #  | ULayerInd	  | MAPD     | Last 24 months | NICECLAIMS   |
    #  | ULayerInd    | MAPD     | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | BlueLayerInd | MAPD     | Last 24 months | RxCLAIMS     |
    #  | BlueLayerInd | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | COSMOSCLAIMS |
    #  | GroupRetiree | MAPD     | Last 24 months | NICECLAIMS   |
    #  | GroupRetiree | MAPD     | Last 24 months | RxCLAIMS     |
    
  @smokeTest @MemberVBF @claims_Performance
  Scenario Outline: To validate that claims are present on claims summary page for performance ATDD
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Claim System | <claimSystem> |
      | Member Type  | <memberType>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I validate the claims displayed based on the selection on claims summary page

    Examples: 
      | memberType | planType | claimPeriod    | claimSystem |
      | grpPerf    | PDP      | Last 24 months | NICECLAIMS  |
  #----- end of VBF claims scenarios section ------------------------

  #----- beginning of claims00 ---------------------------------------------------------
  # DO NOT REMOVE this scenario
  # This scenario is not part of the regular regression run BUT is a daily run being monitored by the team
  # note: bypassIssue-1 - YourShare value mismatch between summary and detail - INC10332773
  # note: bypassIssue-2 - MA NICE missing Search EOB History on both summary and detail page - INC11365785
  # note: bypassIssue-2 - MAPD NICE missing Search EOB History on detail page - INC11365785
  # note: bypassIssue-3 - MA and MAPD NICE missing This page contains PDF doc text on detail page - INC11365785
  # note: any additional Example will need to tag with either one of these
  # note:   @claims00_COSMOS_MEDICAL, @claims00_COSMOS_DRUG,
  # note:   @claims00_NICE_MEDICAL, @claims00_NICE_DRUG or @claims00_NOT_NICE_OR_COSMOS
  # note:
  #----------------------------------------------------------------------------------
  @claims00 @def1041 @thePredators
  Scenario Outline: DID: <DID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -claimType: <claimType> - <index> - Perform detail validation for claims on both summary and detail page for each search range options
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When if I access via dashboard I can navigate to claims summary page from View Your Claims
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #----------------- Test Custom search error cases --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Custom search |
    And I should be able to see the error message when no to and from dates being entered
    And I custom search claims for the following invalid time interval on claims summary page
      | Claims From Date | 01/02/2019 |
      | Claims To Date   | 01/02/2018 |
    Then I should be able to see the from date is greater than the to date error message being displayed
    And I custom search claims for over two years time interval from current date on claims summary page
    Then I should be able to see the search range is greater than two years error
    #----------------- Test for Custom search --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Custom search |
    And I custom search claims for the specific time interval on claims summary page
    Then I can see the number of claims
    Then I perform extensive validation for values between claims summary and claim details page
    #----------------- Test for- Last 30 days --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Last 30 days  |
    Then I can see the number of claims
    Then I perform extensive validation for values between claims summary and claim details page
    #----------------- Test for Last 90 days --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Last 90 days  |
    Then I can see the number of claims
    Then I perform extensive validation for values between claims summary and claim details page
    #----------------- Test for Last 6 months --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Last 6 months |
    Then I can see the number of claims
    Then I perform extensive validation for values between claims summary and claim details page
    #----------------- Test for Last 12 months --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>     |
      | Member Type  | <memberType>   |
      | Claim Type   | <claimType>    |
      | Claim System | <claimSystem>  |
      | Claim Period | Last 12 months |
    Then I can see the number of claims
    Then I perform extensive validation for values between claims summary and claim details page
    #----------------- Test for Last 24 months --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>     |
      | Member Type  | <memberType>   |
      | Claim Type   | <claimType>    |
      | Claim System | <claimSystem>  |
      | Claim Period | Last 24 months |
    Then I can see the number of claims
    And I validate the pagination on the claims summary page for given range
    Then I can validate the learn more and print and download option and DownloadMyData section on claims summary page
    Then I can validate claims table displayed based on the selection on claims summary page
    And I can validate the EOB section based on claims system on claims summary page
    And I validate the Need Help section content on claims summary page
    Then I validate Claim Details page content value and Learn More and EOB and tooltips
    Then I perform extensive validation for values between claims summary and claim details page
    #----------------- Final Test claims number makes sense from search periods --------------
    And I can validate the numbers of claims from all search periods
      | Flag Zero Claims User | <flagZeroClaimsUser> |

    @claims00_01 @claims00_MAPD @claims00_COSMOS_MEDICAL @diffGrpsDiffYrs
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 01    | 1041 | MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS   | Medical           | Yes                |

    @claims00_02 @claims00_MAPD @claims00_COSMOS_DRUG @diffGrpsDiffYrs
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 02    | 1041 | MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS   | Prescription drug | No                 |

    @claims00_03 @claims00_MA @claims00_COSMOS_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 03_1  | 1041 | MA       | AARP_Individual            | COSMOS_CLAIMS   | Medical           | Yes                |
      | 03_2  | 1041 | MA       | UHC_Individual             | COSMOS_CLAIMS   | Medical           | Yes                |

    @claims00_04 @claims00_MA @claims00_NICE_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 04    | 1041 | MA       | AARP_Individual            | NICE_CLAIMS     | Medical           | Yes                |

    @claims00_05 @claims00_MAPD @claims00_NICE_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 05    | 1041 | MAPD     | AARP_Individual            | M_NICE_CLAIMS   | Medical           | Yes                |

    @claims00_06 @claims00_MAPD @claims00_NICE_DRUG
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 06    | 1041 | MAPD     | AARP_Individual            | D_NICE_CLAIMS   | Prescription drug | Yes                |

    @claims00_07 @claims00_MAPD @claims00_COSMOS_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 07_1  | 1041 | MAPD     | AARP_Individual            | M_COSMOS_CLAIMS | Medical           | Yes                |
      | 07_2  | 1041 | MAPD     | UHC_Individual             | M_COSMOS_CLAIMS | Medical           | Yes                |

    @claims00_08 @claims00_MAPD @claims00_COSMOS_DRUG
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 08_1  | 1041 | MAPD     | AARP_Individual            | D_COSMOS_CLAIMS | Prescription drug | No                 |
      | 08_2  | 1041 | MAPD     | UHC_Individual             | D_COSMOS_CLAIMS | Prescription drug | No                 |

    @claims00_09 @claims00_PCP @claims00_COSMOS_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 09    | 1041 | PCP      | Individual                 | COSMOS_CLAIMS   | Medical           | Yes                |

    @claims00_10 @claims00_PCP @claims00_COSMOS_DRUG
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 10    | 1041 | PCP      | Individual                 | COSMOS_CLAIMS   | Prescription drug | No                 |

    @claims00_11 @claims00_MEDICA @claims00_COSMOS_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 11    | 1041 | MEDICA   | Individual                 | COSMOS_CLAIMS   | Medical           | No                 |

    @claims00_12 @claims00_MEDICA @claims00_COSMOS_DRUG
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 12    | 1041 | MEDICA   | Individual                 | COSMOS_CLAIMS   | Prescription drug | No                 |

    # note: if memberType contains SSO then will perform additional validation for the optumrx.com link in claim table section
    # note: user needs to have valid entry in optum rx site and should be eligible in HSID site to pass the optumrx related valiation
    @claims00_13 @claims00_PDP @claims00_RX @claims00_NOT_NICE_OR_COSMOS
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 13    | 1041 | PDP      | SSO_Individual             | RX_CLAIMS       | Prescription drug | Yes                |

    @claims00_14 @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 14    | 1041 | SHIP     | Individual                 | COMPASS_CLAIMS  | NA                | Yes                |

    @claims00_15 @claims00_COMBO @claims00_GROUP @claims00_PDP @claims00_NOT_NICE_OR_COSMOS
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 15    | 1041 | PDP      | COMBO_GROUP                | RX_CLAIMS       | Prescription drug | No                 |

    @claims00_16 @claims00_COMBO @claims00_GROUP @claims00_SSUP @claims00_COSMOS @claims00_COSMOS_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 16    | 1041 | SSUP     | COMBO_GROUP                | COSMOS_CLAIMS   | Medical           | Yes                |

    @claims00_17 @claims00_COMBO @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 17    | 1041 | SHIP     | COMBO                      | COMPASS_CLAIMS  | NA                | Yes                |

    @claims00_18 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 18    | 1041 | MAPD     | GROUP                      | COSMOS_CLAIMS   | Medical           | Yes                |

    @claims00_19 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_DRUG
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 19    | 1041 | MAPD     | GROUP                      | COSMOS_CLAIMS   | Prescription drug | No                 |

    @claims00_20 @claims00_GROUP @claims00_MA @claims00_COSMOS_MEDICAL
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 20    | 1041 | MA       | GROUP                      | COSMOS_CLAIMS   | Medical           | No                 |

    @claims00_21 @claims00_GROUP @claims00_PDP @claims00_RX @claims00_NOT_NICE_OR_COSMOS
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 21    | 1041 | PDP      | GROUP                      | RX_CLAIMS       | Prescription drug | No                 |
      
    #note: these will be in team-a env only
	#  |xx     | 1041 | MAPD     | t_diffGrpsDiffYrs_Individual | COSMOS_CLAIMS  | Medical           | No                |
	#  |xx     | 1041 | MAPD     | t_diffGrpsDiffYrs_Individual | COSMOS_CLAIMS  | Prescription drug | No                |
	#----- end of claims00 ---------------------------------------------------------------

  #----- beginning of claims test for offline prod - local run only ------------------
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
  # note:   claimSystem = e.g. COSMOS / NICE / RX / COMPASS
  # note:   claimType = e.g. Prescription drug / Medical / NA (for ship)
  # note:   flagZeroClaimsUser = Yes / No (do you want to fail the test if user has 0 claims)
  @forLocalTestOnly
  Scenario Outline: To validate via member authorization access
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #----------------- Test for Last 24 months --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>     |
      | Member Type  | <memberType>   |
      | Claim Type   | <claimType>    |
      | Claim System | <claimSystem>  |
      | Claim Period | Last 24 months |
    Then I can see the number of claims
    And I validate the pagination on the claims summary page for given range
    Then I can validate the learn more and print and download option and DownloadMyData section on claims summary page
    Then I can validate claims table displayed based on the selection on claims summary page
    And I can validate the EOB section based on claims system on claims summary page
    And I validate the Need Help section content on claims summary page
    Then I validate Claim Details page content value and Learn More and EOB and tooltips
    Then I perform extensive validation for values between claims summary and claim details page

    Examples: 
      | index | TID | username   | password   | MemUserName  | planType | memberType | claimSystem    | claimType | flagZeroClaimsUser |
      |    01 | 000 | myUsername | myPassword | testUsername | SHIP     | COMBO      | COMPASS_CLAIMS | NA        | Yes                |

	
