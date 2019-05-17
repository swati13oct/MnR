@smokeTest @MemberVBF
Feature: 1.11-VBF-MemRedesign-To test the payment history (GATED)
			
 @smokeMakOneTimeCCOther @rallyDashboard @testharness
  Scenario Outline: Verify MakeOne time Payment submission for Credit card Other amount
    Given I am a authenticated member on the member redesign site for Direct Login
     | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates Premium Payment from Rally Dashboard Page
    And User validates Premium Payment table
    And the user navigates to One Time Payments page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to payment overview screen and selects agreements and click on Make one time payemnt
    Then User navigates to payment confirmation page for CC flow

    Examples: 
      | TID       | memberType                       | Name | CreditCardNumber | validMonth | validYear |friendname | favcolor | phonenumber |
      | F243897   | MakeOneTimeCCOther_Payments      | Test | 4111111111111111 |         04 |      2020 |name1      | color1   | number1     |