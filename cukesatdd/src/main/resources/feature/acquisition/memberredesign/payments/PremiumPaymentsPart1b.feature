Feature: 1.19 Verify the premium payment flows on member portal - Part 1b - Test cases 7 to 12

Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature           | UCPPayments |
###############################Regression Scenarios Begin Here ########################################

  #Test Case 07
  @regressionMember
  Scenario Outline: TID: <planType> - Test Case 07 -Verify the overPayment credit flag and verbiage
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User validates the overPayment credit flag and verbiage

    Examples: 
      | TID    | planType | memberType                |
      | TC7    | MAPD     | OverpaymentCreditFlag     |
      | TC7-P2 | SHIP     | SHIPOverpaymentCreditFlag |

  #Test Case 08
  @regressionMember
  Scenario Outline: TID: <planType>- Test Case 08 -Verify the overdue flag and verbiage
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User validates the overdue and total amount due

    Examples: 
      | TID    | planType | memberType      |
      | TC8    | MAPD     | OverdueFlag     |
      | TC8-P2 | SHIP     | SHIPOverdueFlag |

  #Test Case 09
  @regressionMember
  Scenario Outline: TID: <planType> - Test Case 09 -Verify the Paid In Full flag and verbiage
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User validates the Paid in Full flag and its verbiage

    Examples: 
      | TID    | planType | memberType         |
      | TC9    | MAPD     | PaidInFullFlag     |
      | TC9-P2 | SHIP     | SHIPPaidInFullFlag |

  #Test Case 10
  @regressionMember
  Scenario Outline: TID: <planType> - Test Case 10 -Verify tool tips on overview section on the payments page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User validates tool tips on the payments overview page
      | userType | <userType> |
    Examples: 
      | TID     | planType | memberType      | userType |
      | TC10    | MAPD     | OverdueFlag     | Federal  |
      | TC10-P2 | SHIP     | SHIPOverdueFlag | Ship    |

  #Test Case 11
  @regressionMember
  Scenario Outline: TID: <planType> - Test Case 11 -Verify billing/Payment history table tool tips on the payments overview page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User validates billing and payment history table tool tips on the page
	  | userType | <userType> |
    Examples: 
      | TID     | planType | memberType      | userType |
     | TC11    | MAPD     | OverdueFlag     | Federal  |
     | TC11-P2 | SHIP     | SHIPOverdueFlag | Ship    |

  #Test Case 12
  @regressionMember
  Scenario Outline: TID: <planType> - Test Case 12 -Verify print billing/payment history and download payment history buttons
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then validate print billing payment and download buttons on the UI

    Examples: 
      | TID     | planType | memberType      |
      | TC12    | MAPD     | OverdueFlag     |
      | TC11-P2 | SHIP     | SHIPOverdueFlag |