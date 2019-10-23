@claimsMicroApp @thePredetors
Feature: T1.1To validate the claims Summary page and claims Details page on the member site

  @claimsMicroApp01
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -Segment ID: <segmentId> - UI ONLY - To validate the MEDICAL/SHIP claims Summary and details page UI elements only
    Given login with following details logins in the member portal and validate elements for microapp
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    When I navigate to the claims Summary page from dashboard or testharness page
    When I am validating UI only
    Then I can validate the claims summary header on claims summary page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I can validate the segment ID value in localStorage on claims summary page
      | Segment ID   | <segmentId>   |
    #----------------- Test Custom calendar and search error cases --------------------------
    And I can search claims for claim period and claim type on claim summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Type   | <claimType>   |
      | Claim System | <claimSystem> |
      | Claim Period | Custom search |
	Then I can validate the calendar will show up for custom search when click on From and To calendars    
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
    #----------------- Test for input specific claim period  --------------------------
    And I can search claims for the following claim period on claims summary page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim Period | <claimPeriod> |
      | Claim System | <claimSystem> |
    Then I can see the number of claims
    Then I can see the claims displayed based on the selection on claims summary page
    And I validate the pagination on the claims summary page
    And I can see the learn more and print and download option on claims summary table section
    And I validate the EOB section based on claims system on claims summary page
    And I validate the DownloadMyData section on claims summary page
    Then I navigate to the Claim Details page from claims summary page
    And I validate the Claims Total on claims details page
    And I validate the claims summary link on claims detail bottom page
    Then I navigate to the Claim Details page from claims summary page
    And I validate the claims summary link on claims detail top page
    Then I validate Claim Details page content with non zero claims value and Learn More and EOB and tooltips
   
    @mapd
    Examples: 
      | TID   | planType | memberType                 | claimPeriod    | claimSystem     | segmentId | claimType         |
      | xxxxx | MAPD     | MAPD-q3_sep_UAT4_Group029  | Last 24 months | COSMOS_CLAIMS   | 000       | Medical           |
      | xxxxx | MAPD     | GROUP-q3_sep_uat4_group029 | Last 24 months | COSMOS_CLAIMS   | 000       | Medical           |
      | xxxxx | MAPD     | MAPD-q3_sep_Rx_0006        | Last 24 months | COSMOS_CLAIMS   | 000       | Prescription drug |


    @pdp
    Examples: 
      | TID   | planType | memberType                 | claimPeriod    | claimSystem     | segmentId | claimType         |
      | xxxxx | PDP      | PDP                        | Last 24 months | COSMOS_CLAIMS   | 000       | Prescription drug |

    @ship
    Examples: 
      | TID   | planType | memberType                 | claimPeriod    | claimSystem     | segmentId | claimType         |
      | xxxxx | SHIP     | SHIP-q3_sep_ship_009       | Last 24 months | COMPASS_CLAIMS  | 000       | NA                |

    @ma
    Examples: 
      | TID   | planType | memberType                 | claimPeriod    | claimSystem     | segmentId | claimType         |
      | xxxxx | MA       | MA-q2_may_rally017         | Last 24 months | COSMOS_CLAIMS   | 000       | Medical           |


	