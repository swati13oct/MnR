@regressionMemberPROD
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  #Test Case 15 - Verify MakeOne time Payment submission for Credit card with Replace card link
  @regressionMemberPROD
  Scenario Outline: <planType> -memberType: <memberType> - Test Case 15 -Verify MakeOne time Payment submission for Credit card with Replace card link
    Given First check if feature security flag is set to true
      | Feature | UCPPayments |
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects credit card and click on Replace Card link
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then for saved card user navigates to payment review page and selects agreements and save card checkbox and validate change card link

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange      | Name         | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897 | jkuma14  | Brock@05 | KarenBloch  | MAPD     | Last 24 months | Last 18 months | Pooja Minhas | 4121600170691201 |         01 |      2021 | OneTime     |
