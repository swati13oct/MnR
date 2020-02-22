@eob @fastandfurious
Feature: 1.04 To Test EOB for Members

  ######################   EOB Regression ###############################
  @eob6 @febRelease2018 @hsideob @regressionMember
  Scenario Outline: plan: <planType> -memberType: <memberType> EOB Type <eobType> -To verify NICE EOB and click on the pdf
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    #    Then the user validates site leaving pop up
    And the user slects the desired date range
      | Plan Type  | <planType>  |
      | Date Range | <dateRange> |
      | EOB Type   | <eobType>   |
    Then the user validates EOB count
      | EOB COUNT | <eobCount> |
    And the user clicks on first eob from the list

    #And the user validates how to read medical eob PDF
 @COSMOS_EOBs
    Examples: 
    |  planType     | memberType   | dateRange        | eobType           | eobCount |
     |  MAPD         | COSMOS_EOB_R | Last 18 months   | Medical           |       17 |
      | MA           | COSMOS_EOB_R | Last 12 months   | Medical           |       10 |
    | MAPD         | COSMOS_EOB_R | Last 6 months    | Prescription Drug |        4 |
  @NICE_EOBs
    Examples: 
       | planType     | memberType   | dateRange        | eobType           | eobCount |
     | MAPD         | NICE_EOB_R   | Last 18 months   | Prescription Drug |       12 |
       | MAPD         | NICE_EOB_R   | Last 6 months    | Medical           |        3 |
  @SHIP_EOBs
    Examples: 
     | planType     | memberType   | dateRange        | eobType           | eobCount |
      | SHIP_ACTIVE  | SHIP_EOB     | Last 6-12 months | Medical           |        1 |
     | SHIP_ACTIVE2 | SHIP_EOB2    | Last 6-12 months | Medical           |        1 |
   @Rx_EOBs
    Examples: 
       | planType     | memberType   | dateRange        | eobType           | eobCount |
       | PDP          | Rx_EOB       | Last 12 months   | Prescription Drug |        9 |
      | 15165 | PDP          | RxGrp_EOB    | Last 18 months   | Prescription Drug |       14 |

  #     |15167    | PDPI         | COSMOS_EOB_R     | Last 18 months |Medical  |     0     |
  #     |15166    | SHIP_Termnated| SHIP_EOB     | Last 12-18 months |Medical  |     1     |
  #      |15141   | MAPD          | NICETermin_EOB_R | Last 18 months |Medical  |     1     |
  ########################### END EOB  Regression #######################################
  @eob1 @Eobsiteleavingpopup
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType>- Allowed Domains – Authors need ability to define messages and domains for leaving member sites (ATDD)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    Then the user validates site leaving pop up

    Examples: 
      | TID   | planType | memberType          |
      | 15140 | MAPD     | IndividualAARPWOEOB |
      | 15120 | MA       | IndividualAARPWOEOB |

  @eob2 @eobCountdaterange
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -daterange: <dateRange> -To verify EOB result list
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    And the user slects the desired date range
      | Plan Type  | <planType>  |
      | Date Range | <dateRange> |
      | EOB Type   | <eobType>   |
    Then the user validates EOB count
      | EOB COUNT | <eobCount> |

    Examples: 
      | TID   | planType | memberType  | dateRange | eobType           | eobCount |
      | 15134 | PCP      | withEOB     | 18 Months | Medical           |        4 |
      | 15140 | MAPD     | aarpWithEOB | 90 Days   | Medical           |        4 |
      | 15140 | MAPD     | aarpWithEOB | 6 Months  | Medical           |        8 |
      | 15140 | MAPD     | aarpWithEOB | 12 Months | Medical           |        8 |
      | 15140 | MAPD     | aarpWithEOB | 18 Months | Medical           |        8 |
      | 15140 | MAPD     | aarpWithEOB | 6 Months  | Prescription Drug |        1 |
      | 15140 | MAPD     | aarpWithEOB | 12 Months | Prescription Drug |        1 |
      | 15140 | MAPD     | aarpWithEOB | 18 Months | Prescription Drug |        1 |

  @eob3 @planTypeValidation @hsideob2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -  To verify different plan types under combo tabs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And the user navigates to EOB page_hsid
    Then the user validates content displayed on EOB page without combo tabs
      | Plan Type | <planType> |

    Examples: 
      | TID   | planType | memberType |
      | 15140 | MAPD     | NICE_EOB   |

  # |15120 | MA          | IndividualAARPWOEOB						 |
  @eob4 @dropDownFuntion
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -daterange: <dateRange> - To validate page functionality with different dropdowns
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page and validates the page
      | Date Range | <dateRange>   |
      | Plan Type  | <planType>    |
      | EOB Type   | <eobTypeData> |
    Then the user validates content displayed on EOB page without combo tabs
      | Plan Type | <planType> |

    Examples: 
      | TID   | planType | memberType          | eobTypeData       | dateRange   |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 6 Months    |
      | 15140 | MAPD     | IndividualAARPWOEOB | Prescription Drug | 6 Months    |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 12 Months   |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 18 Months   |
      | 15140 | MAPD     | IndividualAARPWOEOB | Medical           | 90 Days     |
      | 15165 | SHIP     | Individual          | Medical           | 6-12 Months |
      | 15165 | SHIP     | Individual          | Medical           | 90 Days     |

  @eob5 @learnAboutMedicalEOB
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -daterange: <dateRange>- To verify How to read a medical EOB PDF
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page and validates the page
      | Date Range | <dateRange>   |
      | Plan Type  | <planType>    |
      | EOB Type   | <eobTypeData> |
    And the user validates how to read medical eob PDF

    Examples: 
      | TID   | planType | memberType  | dateRange | eobTypeData |
      | 15134 | PCP      | withEOB     | 18 Months | Medica      |
      | 15140 | MAPD     | aarpWithEOB | 90 Days   | Medical     |
      | 15140 | MAPD     | aarpWithEOB | 6 Months  | Medical     |
      | 15140 | MAPD     | aarpWithEOB | 12 Months | Medical     |
      | 15140 | MAPD     | aarpWithEOB | 18 Months | Medical     |

  @eob7 @regression_06_06_18FnF
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To verify EOB accessible for PDP + MEDSup Plan
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    Then the user validates content displayed on EOB page
      | Plan Tab | <planTab1> |
    Then the user validates content displayed on EOB page
      | Plan Tab | <planTab2> |

    Examples: 
      | TID   | planType | memberType     | dateRange      | eobType | eobCount | planTab1 | planTab2 |
      | 15167 | PDP      | comboEOBMedSup | Last 18 Months | Medical |        0 | PDP      | MedSup   |

  @eob11 @regression_06_06_18FnF
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - TC010_Check EOB displays error message_ PHIP- Active Plan member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page_hsid
    Then the user validates content displayed on EOB page
      | Plan Tab | <planTab1> |
    And the user gets the error message for PHIP member

    Examples: 
      | TID   | planType | memberType |
      | 15174 | PHIP     | SHIP       |
