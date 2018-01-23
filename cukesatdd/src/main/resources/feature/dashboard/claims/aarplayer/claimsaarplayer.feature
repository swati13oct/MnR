@claimspage @theTransformers
Feature: To validate the new changes related to claims page on the member redesigned site

 #US495101
  @claimDetailsHeader
  Scenario Outline: To Verify Claim Details Page Header for
    Given I am an AARP member on the redesigned site
      | Plan Type | <planType> |
    When I navigate to the Claim Details page in AARP site
    Then I can view a claim search back button in Claims Details page in AARP site
    And A Page Header in Claims Details page in AARP site
    And A Date range in Claims Details page in AARP site
    And A Provider name in Claims Details page in AARP site
    And A Claim number label in Claims Details page in AARP site
    And A Claim number with dynamic value in Claims Details page in AARP site
    And A Claim type label with dynamic value in Claims Details page in AARP site
    And A Claim type with dynamic value in Claims Details page in AARP site
    And A Claim status label with dynamic value in Claims Details page in AARP site
    And A Claim status with dynamic value in Claims Details page in AARP site
    And A Medical EOB for MAPD Cosmos type in Claims Details page in AARP site
      | Domain | <domain> |

    Examples: 
      | planType | domain |
      | MA       | COSMOS |
      | MAPD     | COSMOS |

  

  @claimsSummaryFED @theTransformers
  Scenario Outline: To validate the claims present for the Federal member on claims sumamry page for AARP site
    Given I am an AARP member on the redesigned site
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    #And the user search claims for the following time interval in redesigned site
    #| Claims To Date   | <claimToDate>   |
    #| Claims From Date | <claimFromDate>  |
    Then user validates the claims displayed based on the selection in redesigned site
    And the user validates the EOB section based on domain in redesigned site
      | Domain | <domain> |
    And the user validates the DownloadMyData section in redesigned site

    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | MAPD     | Last 24 Months | COSMOS | COSMOSCLAIMS |
      #| MA       | Last 24 Months | NICE   | NICECLAIMS   |

  @claimsSummarySHIP @theTransformers
  Scenario Outline: To validate the claims present for the SHIP member on claims sumamry page for AARP site
    Given I am an AARP member on the redesigned site
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Claim Period | <claimPeriod> |
      | Plan Type    | <planType>    |
    Then user validates the claims displayed based on the selection in redesigned site
    And the user validates the EOB section based on domain in redesigned site
      | Domain | <domain> |

    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | SHIP     | Last 24 Months | NA     | SHIPCALIMS   |

  @claimsDetailsTableFED @theTransformers
  Scenario Outline: To Verify Claim Table on Claims Details Page
    Given I am an AARP member on the redesigned site
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then user validates the claims displayed based on the selection in redesigned site
    And I navigate to the Claim Details page in AARP site
    Then I validate the Claims Table in claims details page in AARP site
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | planType | claimPeriod    | claimssystem |
      | MA       | Last 24 Months | NICECLAIMS   |
      | MAPD     | Last 24 Months | COSMOSCLAIMS |

  #| SHIP     |Last 24 Months |
  @ClaimsDetailsSHIP @theTransformers
  Scenario Outline: To Verify Learn more section on Claims Details Page
    Given I am an AARP member on the redesigned site
      | Plan Type | <planType> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Claim Period | <claimPeriod> |
    Then user validates the claims displayed based on the selection in redesigned site
    And I navigate to the Claim Details page in AARP site
    Then I validate the Claims Table in claims details page in AARP site
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | planType | claimPeriod    |
      | SHIP     | Last 24 Months |

  @MaxClaimsResultsError
  Scenario Outline: To Verify the Drug Claims History: Reached Maximum Claim Results Error
    # This Scenario can only execute when max claims indicator as true
    Given I am an AARP member on the redesigned site
      | Plan Type | <planType> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Claim Period | <claimPeriod> |
    Then The User can able to see Drug Claims History: Reached Maximum Claim Results Error

    Examples: 
      | planType | claimPeriod    | domain |
      | PDP      | Last 24 Months | NA     |

  @shipDateRangeGreaterThan24MonthsErrmsg
  Scenario Outline: To Verify the SHIP Date Range Greater Than 24-Months Error
    Given I am an AARP member on the redesigned site
      | Plan Type | <planType> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Claim Period | <claimPeriod> |
    And the user search claims for the following time interval in redesigned site
      | Claims To Date   | <claimToDate>   |
      | Claims From Date | <claimFromDate> |
    Then the user should be able to see the SHIP Date Range Greater Than 24-Months Error

    Examples: 
      | planType | claimPeriod   | domain | claimToDate | claimFromDate |
      | SHIP     | Custom Search | NA     | 10/10/2017  | 06/14/2012    |

  @govtDateRangeGreaterThan24MonthsErrmsg
  Scenario Outline: To Verify the FED Date Range Greater Than 24-Months Error
    Given I am an AARP member on the redesigned site
      | Plan Type | <planType> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Claim Period | <claimPeriod> |
    And the user search claims for the following time interval in redesigned site
      | Claims To Date   | <claimToDate>   |
      | Claims From Date | <claimFromDate> |
    Then the user should be able to see the FED Date Range Greater Than 24-Months Error

    Examples: 
      | planType | claimPeriod   | claimToDate | claimFromDate |
      | MAPD     | Custom Search | 10/10/2017  | 06/14/2012    |

  @fromdatGreaterThanToDate
  Scenario Outline: To Verify the SHIP Date Range Greater Than 24-Months Error
    Given I am an AARP member on the redesigned site
      | Plan Type | <planType> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Claim Period | <claimPeriod> |
    And the user search claims for the following time interval in redesigned site
      | Claims To Date   | <claimToDate>   |
      | Claims From Date | <claimFromDate> |
    Then the user should be able to see the from date is greater than to date error message

    Examples: 
      | planType | claimPeriod   | claimToDate | claimFromDate |
      | MAPD     | Custom Search | 10/10/2017  | 10/11/2017    |
