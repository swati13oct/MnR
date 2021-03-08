@thePredetors
Feature: 1.12 To validate the claims Summary page and claims Details page on the member site - Extensive

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
  # note: Each tag should consists of about limited amount of examples to keep jenkins job run time reasonable
  # note:   For COSMOS and Medical  - @claims00_C_M_p1 | @claims00_C_M_p2 
  # note:   For COSMOS and Drug     - @claims00_C_D_p1 
  # note:   For NICE Medical & Drug - @claims00_N_M_p1 + @claims00_N_D_p1 
  # note:   For PDP & SHIP          - @claims00_R_p1 + @claims00_S_p1
  #----------------------------------------------------------------------------------
  @claimsMicroApp00
  Scenario Outline: -index: <index> -TID: <TID> -planType: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -claimType: <claimType> -Segment ID: <segmentId> - Perform detail validation for claims on both summary and detail page for each search range options
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Claim System   | <claimSystem>   |
      | User Selection | <userSelection> |
    #When if I access via dashboard I can navigate to claims summary page from View Your Claims
    When I navigate to the claims Summary page from dashboard or testharness page
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I can validate the segment ID value in localStorage on claims summary page
      | Segment ID   | <segmentId>   |
    #----------------- Test Custom calendar and search error cases --------------------------
    ## note: covered in E2E, keep in case want to test here also
    ##And I can search claims for claim period and claim type on claim summary page
    ##  | Plan Type    | <planType>    |
    ##  | Member Type  | <memberType>  |
    ##  | Claim Type   | <claimType>   |
    ##  | Claim System | <claimSystem> |
    ##  | Claim Period | Custom search |
	##Then I can validate the calendar will show up for custom search when click on From and To calendars    
    ##And I should be able to see the error message when no to and from dates being entered
    ##And I custom search claims for the following invalid time interval on claims summary page
    ##  | Claims From Date | 01/02/2019 |
    ##  | Claims To Date   | 01/02/2018 |
    ##Then I should be able to see the from date is greater than the to date error message being displayed
    ##And I custom search claims for over two years time interval from current date on claims summary page
    ##Then I should be able to see the search range is greater than two years error
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
    #note: covered by E2E also - skip on jenkins run to keep run time within 30 min
    ##And I validate the pagination on the claims summary page for given range
    ##Then I can validate the learn more and print and download option and DownloadMyData section on claims summary page
    Then I can validate claims table displayed based on the selection on claims summary page
    And I can validate the EOB section based on claims system on claims summary page
    And I validate the Need Help section content on claims summary page
    #----------
    # note: These two steps below only applicable to SHIP and MEDICAL claims, NOTHING will be done for DRUG case
    ##note: covered by E2E also - skip on jenkins run to keep run time within 30 min
    Then I validate Claim Details page content value and Learn More and EOB and tooltips
    Then I perform extensive validation for values between claims summary and claim details page
    #----------
    #----------------- Final Test claims number makes sense from search periods --------------
    And I can validate the numbers of claims from all search periods
      | Flag Zero Claims User | <flagZeroClaimsUser> |
    
    @mapd_medical_cosmos1
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | flagZeroClaimsUser | 
      | 01_1  | xxxxx | MAPD-q3_sep_UAT4_Group029         | MAPD     | UHC_GROUP       | COSMOS_CLAIMS   | Medical           | 000       | Yes                | 
      | 01_2  | 15230 | MAPD-COS-q3_sep_uat4_cosmos_008   | MAPD     | AARP_Individual | COSMOS_CLAIMS   | Medical           | 000       | Yes                | 
      | 01_3  | 15235 | MAPD-UHC-COSMOS-q2_jun_uhc0009    | MAPD     | UHC_Individual  | COSMOS_CLAIMS   | Medical           | 000       | Yes                | 

    @mapd_medical_cosmos2
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | flagZeroClaimsUser | 
      | 01_4  | xxxxx | SSP_CLAIMS_q1_feb_ssp_001         | SSUP     | UHC_GROUP       | COSMOS_CLAIMS   | Medical           | 000       | Yes                | 
      | 01_5  | 15268 | MEDICA-COSMOS-q2_jun_sofl0013     | MEDICA   | Individual      | COSMOS_CLAIMS   | Medical           | 000       | Yes                |
      | 01_6  | 15268 | PCP_CLAIMS_q3_sept_UAT4_AARP_032  | PCP      | Individual      | COSMOS_CLAIMS   | Medical           | 000       | Yes                |

	 # note: don't have a working user that is SSP COMBO
     #| 01_4  | xxxxx | SSP-UHC-GROUP-COSMOS-q2_dec_grp0288| SSUP    | UHC_COMBO_GROUP | COSMOS_CLAIMS   | Medical           | 000       | Yes                | 

    @ma_medical_cosmos
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | flagZeroClaimsUser |
      | 02_1  | 15234 | MA-q2_may_rally017                | MA       | UHC_Individual  | COSMOS_CLAIMS   | Medical           | 000       | Yes                |
      | 02_2  | xxxxx | MA-COS-q2_jun_grp0154             | MA       | UHC_GROUP       | COSMOS_CLAIMS   | Medical           | 000       | Yes                |

    @mapd_medical_nice
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | flagZeroClaimsUser | 
      | 03_1  | 15235 | NICE-q2_jun_aarp0028              | MAPD     | AARP_Individual | NICE_CLAIMS     | Medical           | 000       | Yes                | 

    @ship
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | flagZeroClaimsUser | 
      | 04_1  | 15236 | SHIP_CLAIMS_q1_feb_2020SHIP_034   | SHIP     | Individual      | COMPASS_CLAIMS  | NA                | 000       | Yes                |

    @mapd_drug
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | flagZeroClaimsUser |
      | 05_1  | 15230 | MAPD-RX-q2_jun_aarp0042           | MAPD     | AARP_Individual | RX_CLAIMS       | Prescription drug | 000       | Yes                | 
      | 05_2  | 15235 | MAPD-RX-q3_sep_Rx_0009            | MAPD     | UHC_Individual  | RX_CLAIMS       | Prescription drug | 000       | Yes                | 
      | 05_3  | xxxxx | MAPD-q3_sep_UAT4_Group029         | MAPD     | UHC_GROUP       | RX_CLAIMS       | Prescription drug | 000       | Yes                |

    @pdp_drug
    Examples: 
      | index | TID   | userSelection                     | planType | memberType      | claimSystem     | claimType         | segmentId | flagZeroClaimsUser |
      | 06_1  | 15299 | PDP-RX-q3_sep_UAT4_AARP315        | PDP      | Individual      | RX_CLAIMS       | Prescription drug | 000       | Yes                |
      | 06_2  | 15300 | PDP-RX-q3_sep_UAT4_Group217       | PDP      | GROUP           | RX_CLAIMS       | Prescription drug | 000       | Yes                |


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
  Scenario Outline: To validate via member authorization access for claims
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    When I navigate to the claims Summary page from dashboard or testharness page
    #When I am validating UI only
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I can validate the segment ID value in localStorage on claims summary page
      | Segment ID   | <segmentId>   |

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
    #----------
    # note: These two steps below only applicable to SHIP and MEDICAL claims, NOTHING will be done for DRUG case
    Then I validate Claim Details page content value and Learn More and EOB and tooltips
    Then I perform extensive validation for values between claims summary and claim details page
    #----------

    Examples: 
      | index | username   | password   | MemUserName  | planType | memberType | claimSystem    | claimType         | segmentId | flagZeroClaimsUser |
      |    01 | myUsername | myPassword | testUsername | PDP      | Individual | RX_CLAIMS      | Prescription drug | 000       | Yes                |
      |    02 | myUsername | myPassword | testUsername | MAPD     | Individual | NICE_CLAIMS    | Medical           | 000       | Yes                |
      |    03 | myUsername | myPassword | testUsername | SHIP     | Individual | COMPASS_CLAIMS | NA                | 000       | Yes                |
      |    04 | myUsername | myPassword | testUsername | PCP      | Individual | COSMOS_CLAIMS  | Medical           | 000       | Yes                |


