Feature:To verify New Payment History page
Scenario Outline:To Verify Payment History section including the header and payment date range dropdown so that I can view and search for the history of my payments without having to call customer service.
Given I am an AARP Individual member on the Dashboard site
       | Plan Type   | <planType>   |
When the above plantype user logs in AARP Site
Then I navigate to the Payment History page in AARP Site
And I can view a Payment History header_text in AARP Site
And I can view a View Payments For dropdown menu and first selected option is Last 90 days in AARP Site
And I can view all the expected options in the dropdown of view payment dropdown menu in AARP Site
And I can view a View Payments For Custom Search when I have selected Custom Search and options are coming in AARP Site
        | Start Date   | <startDate>  |
        | End Date     | <endDate>    |     
And I can view a Payment table header in AARP Site
And I can view a Payment table columns in AARP Site
And I can view a Making your payments header and text in AARP Site
And I can view a LEARN MORE ABOUT WAYS TO PAY text that can expand in AARP Site

Examples:

 | planType  |  startDate  |  endDate   |
 | PDP   	 |  01/01/2016 | 12/30/2016 |
#| MAPD      |  01/01/2016 | 12/30/2016 |
#| MA        |  01/01/2016 | 12/30/2016 |
 
 
Scenario Outline:To verify New Payment History page
Given I am an AARP Individual member on the Dashboard site

    | Plan Type | <plantype> |
	| Member Type  | <memberType> |

When the above plantype user logs in AARP Site
Then I navigate to the new Payment History page
Then validate Payment Method value

Examples:

| plantype   | memberType   |
|  MAPD | Individual |
|  MA | Individual |
|  PDP | Individual |


 
@SetUpAutomaticPaymentButtonTest
Scenario Outline: To verify Premium Payments Overview section and Set Up Automatic Payments button
Given I am an AARP  Individual member on the Dashboard site who has NOT previously setup automatic payments
  | Plan Type | <plantype> |
	| Member Type  | <memberType> |
When the above plantype user logs in AARP Site
And I navigate to the Payment History page
Then I can view a button Make a One-Time Payment
And a button Set Up Automatic Payments

Examples:

| plantype   | memberType   |
#|  MAPD | Individual |
#|  MA | Individual |
|  PDP | Individual |




 
 @EditAutomaticPaymentButtonTest 
Scenario Outline: To verify Premium Payments Overview section and Set Up Automatic Payments button
Given I am an AARP  Individual member on the Dashboard site who has NOT previously setup automatic payments
   | Plan Type | <plantype> |
	| Member Type  | <memberType> |
When the above plantype user logs in AARP Site
And I navigate to the Payment History page
Then I can view a button Make a One-Time Payment
And a button Edit Automatic Payments

Examples:

| plantype   | memberType   |
|  MAPD | Individual |
|  MA | Individual |
|  PDP | Individual |

Scenario Outline: To verify New Payment History page and validate for Dtm values for makeonepayment and setup automatic payments
Given I am an AARP Individual member on the Dashboard site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in AARP Site
Then I navigate to the Payment History page in AARP Site
Then navigate to the new Payment History page and validate DTM values for Make A One Time Payment
Then navigate to the new Payment History page and validate DTM values for Set Up Automatic Payments

Examples:
         | planType | membertype  |
         | MAPD     | Individual  | 
        

Scenario Outline: To verify New Payment History page and validate for member who has Non setup automatic payment
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site
When navigate to the new Payment History page
Then validate Non setup automatic payment

Examples:
         | planType | membertype |  
         | MA       | Group      | 
       # | MA       | Group      | 
       # | MA       | Individual |


Scenario Outline: To verify New Payment History page and validate for member who setup automatic payment
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site
When navigate to the new Payment History page in mobile site
Then validate setup automatic payment

Examples:
         | planType | membertype  |
         | MA       | Group       |       
 
Scenario Outline: To verify New Payment History page and validate Credit Balance when the balance is greater than zero
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site 
When navigate to the new Payment History page in mobile site
Then validate Credit Balance when the balance is greater than zero

Examples:
         | planType | membertype  |
         | MA       | Group       | 

Scenario Outline: To verify New Payment History page and validate for Dtm values for makeonepayment and setup automatic payments
Given I am an AARP Individual member on the Dashboard site in mobile site
    | Plan Type   |  <planType>    |
    | Member Type |  <membertype>  |
When the above plantype user logs in mobile in AARP Site  
When navigate to the new Payment History page in mobile site
Then validate DTM values for Make A One Time Payment
Then validate DTM values for Set Up Automatic Payments

Examples:
         | planType | membertype  |
         | MA       | Group       | 

 
#Moved from MakeOneTimePayment-AARP.feature to here for archive
  Scenario Outline: Verify one time payment for total ammount due in AARP site
    Given registered AARP with a planType member for AARP site
      | <planType> |
    When the user views payment history
    And the user makes one time payment in AARP site
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the payment in AARP site
    Then the user validates the payment successful page

    Examples: 
      | planType | routingNo | confirmRoutingNo | accountNo  | confirmAccountNo | firstName | middleName | lastName | Amount |
      #        |  MA     | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
      #        |  MAPD   | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
      | PDP      | 123000000 |        123000000 | 1234567890 |       1234567890 | first     | second     | third    |   2.00 |

  #        |  MS     | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
  #        |  HIP    | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
  #	|  RIDER  | 123000000 |  123000000       | 1234567890  | 1234567890       | first     | second     | third    | 2.00   |
  Scenario Outline: Verify the One Time Payments Tool for Dashboard
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to One Time Payments page

    Examples: 
      | planType |
      | MAPD     |

  #	| MA       |
  #	| PDP      |
  #	| MS       |
  #	| HIP      |
  Scenario Outline: Verify the Payment amount and Routing Number on One Time Payments Tool for Dashboard
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for  Dashboard
    Then user lands on Review One time Payments Page and validates the amount and routing number values

    Examples: 
      | planType |
      | MAPD     |

  #	| MA       |
  #	| PDP      |
  #	| MS       |
  #	| HIP      |
  @US455296
  Scenario Outline: Verify the edit payment information on One Time Payments Tool for Dashboard
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for Dashboard
    Then user lands on Review One time Payments Page and validates the one time payment page
    And the user clicks on edit payment information button on Review Payments Page

    Examples: 
      | planType |
      | MAPD     |

  @US454601
  Scenario Outline: Verify that payment history page is navigated when cancel button is clicked in Review One Time Payment Page
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for Dashboard
    And the user clicks on cancel button on Review Payments Page and validates payments history page

    Examples: 
      | planType |
      | MAPD     |

  @US497862
  Scenario Outline: Verify the Error Message when user clicks on continue button on OTP Page without clicking checkbox
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to One Time Payments page
    And the user enters details without clicking checkbox and clicks on continue button on OTP Page for Dashboard

    Examples: 
      | planType |
      | MAPD     |

  @US497834
  Scenario Outline: Verify the User is taken to Payment History page when he clicks cancel button on OTP page
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to One Time Payments page
    And the user clicks on cancel button on OTP Page and validates title
    Then user validates the Payment History Page

    Examples: 
      | planType |
      | MAPD     |

  @US604912
  Scenario Outline: Verify the User is displayed error message if he tries to submit more than one payment per day.
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for  Dashboard
    And the user confirms the payment in AARP site
    And user reaches to One Time Payment submitted page and navigates again to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for  Dashboard
    Then user validates the error

    Examples: 
      | planType |
      | MAPD     |

  @US454623
  Scenario Outline: Verify the User is able to validate values on One-Time Payment Submitted page
    Given registered AARP with a planType member for AARP site
      | <planType> |
    When the user navigates to One Time Payments page
    And the user makes one time payment in AARP site by entering required details
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the values in AARP site
    Then the user validates the One Time Payment Submitted successfull page

    Examples: 
      | planType | routingNo | confirmRoutingNo | accountNo  | confirmAccountNo | firstName | middleName | lastName | Amount |
      | MA       | 123000000 |        123000000 | 1234567890 |       1234567890 | first     | second     | third    |   2.00 |

  @US454631
  Scenario Outline: Verify the PDF link on OneTime Payment Submitted page
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to TestHarness Page
    And the user navigates to PaymentOverview Page
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for Dashboard
    And user lands on Review One time Payments Page and navigates to OTP Submitted Page
    Then the user lands on OneTime Payment Submitted Page and validates PDF link

    Examples: 
      | planType |
      | MA       |

  #US454627 also covered
  @US454620
  Scenario Outline: Verify the Payment Amount and Member Name on OneTime Payment Submitted page
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to TestHarness Page
    And the user navigates to PaymentOverview Page
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for Dashboard
    And user lands on Review One time Payments Page and navigates to OTP Submitted Page
    Then the user lands on OneTime Payment Submitted Page and validates Payment Amount and Member Name

    Examples: 
      | planType |
      | PDP      |

  @US628468
  Scenario Outline: Verify the Timestamp on OneTime Payment Submitted page
    Given the user is on the AARP medicare site login page
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to TestHarness Page
    And the user navigates to PaymentOverview Page
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for Dashboard
    And user lands on Review One time Payments Page and navigates to OTP Submitted Page
    Then the user lands on OneTime Payment Submitted Page and validates Timestamp

    Examples: 
      | planType |
      | MA       |

  @US645003
  Scenario Outline: Verify the error message for More that 1 payment 1 Business day
    Given the user is on the AARP medicare site login page and has already done one time payment for the day
    When the user logs in with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to TestHarness Page
    And the user navigates to PaymentOverview Page
    And the user navigates to One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for Dashboard
    Then user lands on Review One time Payments Page and validates one payment per day error message

    Examples: 
      | planType |
      | MA       |

  @TeamH
  Scenario Outline: Verify the Timestamp on OneTime Payment Submitted page
    Given the user is on the Team-H AARP medicare site login page
    When the user logs in TeamH with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And the user navigates to Team-h TestHarness Page
    And the user navigates to TeamHPaymentOverview Page
    And the user navigates to Team H One Time Payments page
    And the user enters details and click on continue button on One Time Payments Page for Dashboard
    And user lands on Review One time Payments Page and navigates to OTP Submitted Page
    Then the user lands on OneTime Payment Submitted Page and validates Timestamp

    Examples: 
      | planType |
      | SHIP     |

  @TeamHActual
  Scenario Outline: Verify the Timestamp on OneTime Payment Submitted page
    Given TimeStampTheSpartans the user is on the Team-H AARP medicare site login page
    When TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And TimeStampTheSpartans the user navigates to Stage PaymentOverview Page
    And TimeStampTheSpartans the user navigates to Team H One Time Payments page
    And TimeStampTheSpartans the user enters details and click on continue button on One Time Payments Page for Dashboard
    And TimeStampTheSpartans user lands on Review One time Payments Page and navigates to OTP Submitted Page
    Then TimeStampTheSpartans the user lands on OneTime Payment Submitted Page and validates Timestamp

    Examples: 
      | planType |
      | FED      |

  @TeamHAuto
  Scenario Outline: Verify the Timestamp on Automatic Payment Submitted page
    Given TimeStampTheSpartans the user is on the Team-H AARP medicare site login page
    When TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And TimeStampTheSpartans the user navigates to Stage PaymentOverview Page
    And TimeStampTheSpartans the user navigates to Team H Automatic Payments page
    And TimeStampTheSpartans the user enters details and click on continue button on Automatic Payments Page for Dashboard
    And TimeStampTheSpartans user lands on Review One time Payments Page and navigates to Review Submitted Page
    Then TimeStampTheSpartans the user lands on OneTime Payment Submitted Page and validates Timestamp

    Examples: 
      | planType |
      | UHCFED   |

  @TeamHError
  Scenario Outline: Verify the Timestamp on OneTime Payment Submitted page
    Given TimeStampTheSpartans the user is on the Team-H AARP medicare site login page
    When TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And TimeStampTheSpartans the user navigates to Stage PaymentOverview Page
    And TimeStampTheSpartans the user navigates to Team H One Time Payments page
    And TimeStampTheSpartans the user enters details and click on continue button on One Time Payments Page for Dashboard
    Then TimeStampTheSpartans user lands on Review One time Payments Page and validates one payment per day error message

    Examples: 
      | planType |
      | FED      |

  @US764275
  Scenario Outline: Verify the Timestamp on OneTime Payment Submitted page
    Given TimeStampTheSpartans the user is on the Team-H AARP medicare site login page
    When TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And TimeStampTheSpartans the user navigates to Stage PaymentOverview Page
    Then TimeStampTheSpartans user lands on payment overview page validates the tabs for combo members

    Examples: 
      | planType |
      | COMBO    |

  @US735645
  Scenario Outline: Verify the Timestamp on OneTime Payment Submitted page
    Given TimeStampTheSpartans the user is on the Team-H AARP medicare site login page
    When TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site
      | Plan Type | <planType> |
    And TimeStampTheSpartans the user navigates to Stage PaymentOverview Page
    Then TimeStampTheSpartans user unchecks paid and unpaid checkbox and validates the result

    Examples: 
      | planType |
      | SHIP     |

 
 
