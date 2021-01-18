Feature: Refill - Change Payment Method
  Ability for a member to change their payment method while in a refill flow. 

  @RefillChangePaymentMethod @F482463 @US2929696 @US2929697 @US2929698 @US2929699 @US2944205 @US2777905 @US2777900 @US2777899 @US2777898 @US2777897
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify the ability to add, edit, change, make preferred payment, so user can ensure that the medication is charged to the correct card.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    When user view the Payment section
    #AddPayment_FromCheckoutSummaryPage
    When user select Add Payment
    Then user will view Add Payment in a full page modal
    Then user will be able to type cardHolderName
      | cardHolderName |
      | Kiran Jadhav   |
    Then user will be able to type cardNumber
      | cardNumber      |
      | 378282246310005 |
    Then user will be able to type monthExp
    Then user will be able to type yearExp
    Then user will be able to type billingAddressOne
      | billingAddressOne    |
      | 4500 East 9th Avenue |
    Then user will be able to type billingAddressTwo
      | billingAddressTwo |
      | Suite 320         |
    Then user will be able to type city
      | city   |
      | Denver |
    Then user will be able to type state
      | state    |
      | Colorado |
    Then user will be able to type zipCode
      | zipCode |
      |   80220 |
    When user select the X in the corner of the Add Payment page
    Then user will see "Complete Your Refill" Page
    And user will not see the card added to Payment section on checkout summary page
    When user select Add Payment
    Then user will view Add Payment in a full page modal
    Then user will be able to type cardHolderName
      | cardHolderName |
      | Kiran Jadhav   |
    Then user will be able to type cardNumber
      | cardNumber      |
      | 378282246310005 |
    Then user will be able to type monthExp
    Then user will be able to type yearExp
    Then user will be able to type billingAddressOne
      | billingAddressOne    |
      | 4500 East 9th Avenue |
    Then user will be able to type billingAddressTwo
      | billingAddressTwo |
      | Suite 320         |
    Then user will be able to type city
      | city   |
      | Denver |
    Then user will be able to type state
      | state    |
      | Colorado |
    Then user will be able to type zipCode
      | zipCode |
      |   80220 |
    When user select the Cancel button of the Add Payment page
    Then user will see "Complete Your Refill" Page
    And user will not see the card added to Payment section on checkout summary page
    When user select Add Payment
    Then user will view Add Payment in a full page modal
    Then user will be able to type cardHolderName
      | cardHolderName |
      | Kiran Jadhav   |
    Then user will be able to type cardNumber
      | cardNumber      |
      | 378282246310005 |
    Then user will be able to type monthExp
    Then user will be able to type yearExp
    Then user will be able to type billingAddressOne
      | billingAddressOne    |
      | 4500 East 9th Avenue |
    Then user will be able to type billingAddressTwo
      | billingAddressTwo |
      | Suite 320         |
    Then user will be able to type city
      | city   |
      | Denver |
    Then user will be able to type state
      | state    |
      | Colorado |
    Then user will be able to type zipCode
      | zipCode |
      |   80220 |
    When user select Save Payment Method on Add Payment Page
    Then user will view the Change Payment page
    And user will view a success message for new credit card added
    And user will see the first card added in the list of payment methods
    When user navigate back to Checkout Summary page
    Then user will see the card added to Payment section on checkout summary page
    #PrefferedPaymentMethod_ByDefault
    And user will see the card as Preffered card
    #AddPayment_FromChangePaymentPage
    When user select Change Payment
    #Then user will view the Change Payment page
    Then user will view Change Payment in a full page modal
    When user select Add Card on Change Payment Page
    Then user will view Add Payment in a full page modal
    Then user will be able to type cardHolderName
      | cardHolderName |
      | Kiran Jadhav   |
    Then user will be able to type cardNumber
      | cardNumber       |
      | 5555555555554444 |
    Then user will be able to type monthExp
    Then user will be able to type yearExp
    Then user will be able to type billingAddressOne
      | billingAddressOne    |
      | 4500 East 9th Avenue |
    Then user will be able to type billingAddressTwo
      | billingAddressTwo |
      | Suite 320         |
    Then user will be able to type city
      | city   |
      | Denver |
    Then user will be able to type state
      | state    |
      | Colorado |
    Then user will be able to type zipCode
      | zipCode |
      |   80220 |
    When user select the X in the corner of the Add Payment page
    Then user will view the Change Payment page
    And user will not see the new card added in list on Change Payment page
    When user select Add Card on Change Payment Page
    Then user will view Add Payment in a full page modal
    Then user will be able to type cardHolderName
      | cardHolderName |
      | Kiran Jadhav   |
    Then user will be able to type cardNumber
      | cardNumber       |
      | 5555555555554444 |
    Then user will be able to type monthExp
    Then user will be able to type yearExp
    Then user will be able to type billingAddressOne
      | billingAddressOne    |
      | 4500 East 9th Avenue |
    Then user will be able to type billingAddressTwo
      | billingAddressTwo |
      | Suite 320         |
    Then user will be able to type city
      | city   |
      | Denver |
    Then user will be able to type state
      | state    |
      | Colorado |
    Then user will be able to type zipCode
      | zipCode |
      |   80220 |
    When user select the Cancel button of the Add Payment page
    Then user will view the Change Payment page
    And user will not see the new card added in list on Change Payment page
    When user select Add Card on Change Payment Page
    Then user will view Add Payment in a full page modal
    Then user will be able to type cardHolderName
      | cardHolderName |
      | Kiran Jadhav   |
    Then user will be able to type cardNumber
      | cardNumber       |
      | 5555555555554444 |
    Then user will be able to type monthExp
    Then user will be able to type yearExp
    Then user will be able to type billingAddressOne
      | billingAddressOne    |
      | 4500 East 9th Avenue |
    Then user will be able to type billingAddressTwo
      | billingAddressTwo |
      | Suite 320         |
    Then user will be able to type city
      | city   |
      | Denver |
    Then user will be able to type state
      | state    |
      | Colorado |
    Then user will be able to type zipCode
      | zipCode |
      |   80220 |
    When user select Save Payment Method on Add Payment Page
    Then user will view the Change Payment page
    And user will view a success message for new credit card added
    #EditPayment-FromChangePaymentPage
    And user have selected a card
    When user select the edit link
    Then user will view Edit Payment in a full-page modal
    Then user view name field is not editable
    Then user view card number field is not editable
    When user select the X in the corner of the Edit Payment page
    Then user will view Change Payment in a full page modal
    And user have selected a card
    When user select the edit link
    Then user will view Edit Payment in a full-page modal
    When user select the Cancel button of the Edit Payment page
    Then user will view Change Payment in a full page modal
    And user have selected a card
    When user select the edit link
    Then user will view Edit Payment in a full-page modal
    #When user type in the expiration date field
    When user type in the Billing Address fields
      | billingAddressOne    |
      | 4500 East 9th Avenue |
    When user select the link to add an additional address line on Edit Payment Page
    Then user will see a second address line box appear on the page on Edit Payment Page
    And user will be able to enter text into additional address line field on Edit Payment Page
      | billingAddressTwo |
      | Suite 320         |
    And user will not be able to view the add an additional address line link on Edit Payment Page
    When user select Save and continue on Edit Payment Page
    Then user will view Change Payment in a full page modal
    #And user will view a success message for credit card updated
    #Success! You've updated a credit card.
    Examples: 
      | FID     | planType | memberType                    |
      | F481927 | PDP      | Rx_Refill_ChangePaymentMethod |
