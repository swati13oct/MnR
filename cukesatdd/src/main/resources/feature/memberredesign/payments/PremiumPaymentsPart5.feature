Feature: 1.19 Verify the premium payment flows on member portal - Part 5 - Test case 33 to 33

Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature           | UCPPayments |
###############################Regression Scenarios Begin Here ########################################

  #Test Case 33 - Federal member - One time CC - Selects to Save Credit Card on File on Review Page
  @regressionMember
  Scenario Outline: TID: <memberType> - Test Case 33 - Verify MakeOne time Payment submission for Credit card Other amount , saving card on review page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then for saving card user navigates to payment overview screen and selects agreements and save card checkbox and click on Make one time payment
    Then User navigates to payment confirmation page for CC flow
    And the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID       | planType | memberType                       | Name | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897   | PDP      | MakeOneTimeCCOther_Payments      | Test | 4111111111111111 |         04 |      2028 | OneTime     |
      
      
      
  #Test Case 34 - Federal member - One time CC - Payment made with a existing Saved Card
  @regressionMember
  Scenario Outline: TID: <memberType> - Test Case 34 - Verify MakeOne time Payment submission for Credit card Other amount with an existing saved card
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then for saving card user navigates to payment overview screen and selects agreements and save card checkbox and click on Make one time payment
    Then User navigates to payment confirmation page for CC flow
    And the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID       | planType | memberType                       | Name | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897   | PDP      | MakeOneTimeCCOther_SavedCardPayments      | Test | 4111111111111111 |         04 |      2028 | OneTime     |