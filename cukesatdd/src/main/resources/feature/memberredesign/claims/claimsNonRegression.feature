@claims @thePredetors
Feature: T1.1To validate the claims Summary page and claims Details page on the member site

  #----- beginning of claims00 ---------------------------------------------------------
  # DO NOT REMOVE this scenario
  # This scenario is not part of the regular regression run 
  # BUT is a daily run being monitored by the team
  # note: bypassIssue-1 - YourShare value mismatch between summary and detail - INC10332773
  # note: bypassIssue-2 - MA NICE missing Search EOB History on both summary and detail page - INC11365785
  # note: bypassIssue-2 - MAPD NICE missing Search EOB History on detail page - INC11365785
  # note: bypassIssue-3 - MA and MAPD NICE missing This page contains PDF doc text on detail page - INC11365785
  # note: C=COSMOS, N=NICE, R=Rx, S=Ship, M=Medical, D=Drug 
  # note: Each of these tags has a jenkins job of its own.  
  # note: Each tag should consists of about 4 examples to keep run time within an hour
  # note:   For COSMOS and Medical - @claims00_C_M_p1 | @claims00_C_M_p2 | @claims00_C_M_p3
  # note:   For COSMOS and Drug    - @claims00_C_D_p1 | @claims00_C_D_p2
  # note:   For NICE and Medical   - @claims00_N_M_p1  
  # note:   For NICE and Drug      - @claims00_N_D_p1 
  # note:   For PDP                - @claims00_R_p1 
  # note:   For SHIP               - @claims00_S_p1 
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

    @claims00_01 @claims00_C_M_p1
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 01_1  | 1041 | MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS   | Medical           | Yes                |
      | 01_2  | 1041 | MAPD     | AARP_Individual            | M_COSMOS_CLAIMS | Medical           | Yes                |
      | 01_3  | 1041 | MAPD     | UHC_Individual             | M_COSMOS_CLAIMS | Medical           | Yes                |
      | 01_4  | 1041 | MAPD     | GROUP                      | COSMOS_CLAIMS   | Medical           | Yes                |

    @claims00_02 @claims00_C_M_p2
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 02_1  | 1041 | MA       | AARP_Individual            | COSMOS_CLAIMS   | Medical           | Yes                |
      | 02_2  | 1041 | MA       | UHC_Individual             | COSMOS_CLAIMS   | Medical           | Yes                |
      | 02_3  | 1041 | MA       | GROUP                      | COSMOS_CLAIMS   | Medical           | No                 |

    @claims00_03 @claims00_C_M_p3
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 03_1  | 1041 | PCP      | Individual                 | COSMOS_CLAIMS   | Medical           | Yes                |
      | 03_2  | 1041 | MEDICA   | Individual                 | COSMOS_CLAIMS   | Medical           | No                 |
      | 03_3  | 1041 | SSUP     | COMBO_GROUP                | COSMOS_CLAIMS   | Medical           | Yes                |

    @claims00_04 @claims00_C_D_p1 
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 04_1  | 1041 | MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS   | Prescription drug | No                 |
      | 04_2  | 1041 | MAPD     | AARP_Individual            | D_COSMOS_CLAIMS | Prescription drug | No                 |
      | 04_3  | 1041 | MAPD     | UHC_Individual             | D_COSMOS_CLAIMS | Prescription drug | No                 |
      | 04_4  | 1041 | MAPD     | GROUP                      | COSMOS_CLAIMS   | Prescription drug | No                 |

    @claims00_05 @claims00_C_D_p2
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 05_1  | 1041 | PCP      | Individual                 | COSMOS_CLAIMS   | Prescription drug | No                 |
      | 05_2  | 1041 | MEDICA   | Individual                 | COSMOS_CLAIMS   | Prescription drug | Yes                |

    @claims00_06 @claims00_N_M_p1
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 06_1  | 1041 | MA       | AARP_Individual            | NICE_CLAIMS     | Medical           | Yes                |
      | 06_2  | 1041 | MAPD     | AARP_Individual            | M_NICE_CLAIMS   | Medical           | Yes                |
      | 06_3  | 1041 | MAPD     | GROUP_UHC                  | NICE_CLAIMS     | Medical           | Yes                |

    @claims00_07 @claims00_N_D_p1
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 07_1  | 1041 | MAPD     | AARP_Individual            | D_NICE_CLAIMS   | Prescription drug | Yes                |
      | 07_2  | 1041 | MAPD     | GROUP_UHC                  | NICE_CLAIMS     | Prescription drug | Yes                |

    # note: if memberType contains SSO then will perform additional validation for the optumrx.com link in claim table section
    # note: user needs to have valid entry in optumrx site and should be eligible in HSID site to pass the optumrx related validation
    @claims00_08 @claims00_R_p1
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 08_01 | 1041 | PDP      | SSO_Individual             | RX_CLAIMS       | Prescription drug | Yes                |
      | 08_02 | 1041 | PDP      | COMBO_GROUP                | RX_CLAIMS       | Prescription drug | No                 |
      | 08_03 | 1041 | PDP      | GROUP                      | RX_CLAIMS       | Prescription drug | No                 |

    @claims00_09 @claims00_S_p1
    Examples: 
      | index | DID  | planType | memberType                 | claimSystem     | claimType         | flagZeroClaimsUser |
      | 09_01 | 1041 | SHIP     | Individual                 | COMPASS_CLAIMS  | NA                | Yes                |
      | 09_02 | 1041 | SHIP     | COMBO                      | COMPASS_CLAIMS  | NA                | Yes                |

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

	
