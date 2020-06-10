@eob @fastandfurious
Feature: 1.04.2 To Test EOB for Members - Spending Cost Summary Suppression Logic

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | UCPEob |

  # note: for SSUP case, there will be no EOB page
  @eob05 @speCosSumSup @regressionMember
  Scenario Outline: -index: <index> -UID: <UID> -plan: <planType> -memberType: <memberType> - To validate Spending Cost Summary tab suppression logic on EOB page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then the user navigates to EOB page
    Then the user validate Spending Cost Summary tab on top sub menu
      | From Page   | EOB          |
      | Expect Tab  | <expectTab>  |

    @speCosSumSuppressed	
    Examples: 
      | index | UID       | planType  | memberType         | expectTab | note                                      | 
      | 17    | US2382272 | SHIP_HIP_FED | COMBO_EOB       | false     | medicaidDualStatusCode either 01,02,04,08 |
      | 18    | US2382272 | SSUP      | SSUP_ONLY_EOB      | false     | planCode SSP                              |
      | 19    | US2382272 | SHIP      | MULTI_SHIP_EOB     | false     | ship user                                 |
      | 20    | US2382272 | MAPD      | TERM_EOB           | false     | suppress                                  |

    @speCosSumNotSuppressed
    Examples: 
      | index | UID       | planType  | memberType         | expectTab | note                                      | 
      | 21    | US2382272 | PDP       | LIS_EOB            | true      | PDP not blacklist LIS either 1,2,3,4      |
      | 22    | US2382272 | PDP_SSUP  | COMBO_EOB          | true      | Group MA/MAPD/SSUP and PDP                |
      | 23    | US2382272 | PDP_SHIP  | NON_LIS_COMBO_EOB  | true      | PDP is non list                           |
      | 24    | US2382272 | PDP_SSUP  | NON_LIS_COMBO_EOB  | true      | PDP LIS 0                                 |
      | 25    | US2382272 | MAPD      | COSMOS_EOB_R       | true      | medicaidDualStatusCode is not 01,02,04,08 |
      | 26    | US2382272 | MA        | COSMOS_EOB_R       | true      | medicaidDualStatusCode is not 01,02,04,08 |
      | 27    | US2382272 | SHIP_MA   | COMBO_EOB          | true      | medicaidDualStatusCode is not 01,02,04,08 |

  # note: MyClaims page validation will be skipped if running on team env
  @eob06 @speCosSumSup @regressionMember
  Scenario Outline: -index: <index> -UID: <UID> -plan: <planType> -memberType: <memberType> - To validate Spending Cost Summary tab suppression logic on RallyClaims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then the user navigates to EOB page
    Then the user validate MyClaims top menu sub option
    Then the user click MyClaims top menu sub option
    Then the user validate Spending Cost Summary tab on top sub menu
      | From Page   | Claims       |
      | Expect Tab  | <expectTab>  |

    @speCosSumSuppressed	
    Examples: 
      | index | UID       | planType  | memberType         | expectTab | note                                      | 
      | 17    | US2382272 | SHIP_HIP_FED | COMBO_EOB       | false     | medicaidDualStatusCode either 01,02,04,08 |
      | 18    | US2382272 | SSUP      | SSUP_ONLY_EOB      | false     | planCode SSP                              |
      | 19    | US2382272 | SHIP      | MULTI_SHIP_EOB     | false     | ship user                                 |
      | 20    | US2382272 | MAPD      | TERM_EOB           | false     | suppress                                  |

    @speCosSumNotSuppressed
    Examples: 
      | index | UID       | planType  | memberType         | expectTab | note                                      | 
      | 21    | US2382272 | PDP       | LIS_EOB            | true      | PDP not blacklist LIS either 1,2,3,4      |
      | 22    | US2382272 | PDP_SSUP  | LIS_COMBO_EOB      | true      | Group MA/MAPD/SSUP and PDP                |
      | 23    | US2382272 | PDP_SHIP  | NON_LIS_COMBO_EOB  | true      | PDP is non list                           |
      | 24    | US2382272 | PDP_SSUP  | NON_LIS_COMBO_EOB  | true      | PDP LIS 0                                 |
      | 25    | US2382272 | MAPD      | COSMOS_EOB_R       | true      | medicaidDualStatusCode is not 01,02,04,08 |
      | 26    | US2382272 | MA        | COSMOS_EOB_R       | true      | medicaidDualStatusCode is not 01,02,04,08 |
      | 27    | US2382272 | SHIP_MA   | COMBO_EOB          | true      | medicaidDualStatusCode is not 01,02,04,08 |
      