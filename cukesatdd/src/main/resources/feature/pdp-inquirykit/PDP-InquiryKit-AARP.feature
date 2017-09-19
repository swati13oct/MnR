@pdpInquiryKit
Feature: To test PDP inquiry flow in AARP site

  Scenario Outline: To verify PDP inquiry flow in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request More Help and Information page under pdp section in AARP Site
    And the user accesses the Request Plan Information and Enrollment Materials in AARP site
    And the user submits by entering following details in Order Enrollment Information page in AARP Site
      | Plan name             | <planName>            |
      | First name            | <firstName>           |
      | Last name             | <lastName>            |
      | Date of Birth         | <dob>                 |
      | Relationship          | <relationShip>        |
      | Email address         | <emailAddress>        |
      | Confirm email address | <confirmEmailAddress> |
      | Email updates         | <emailUpdates>        |
      | Gender                | <gender>              |
      | Medicare              | <medicare>            |
      | Address line 1        | <addressLine1>        |
      | Address line 2        | <addressLine2>        |
      | City                  | <city>                |
      | State                 | <state>               |
      | Zip Code              | <zipCode>             |
      | Daytime phone number  | <dayTimePhNumber>     |
    Then the user validates the inquiry kit confirmation page in AARP site

    Examples: 
      | planName                  | firstName | lastName | dob        | relationShip                    | emailAddress | confirmEmailAddress | emailUpdates | gender | medicare   | addressLine1 | addressLine2 | city       | state | zipCode | dayTimePhNumber |
      | Symphonix Value Rx (PDP)2 | FirstName | LastName | 01/01/1990 | Self - I have a Medicare number | test@uhc.com | test@uhc.com        | Yes          | Male   | 111111111A | California   | California   | California | TEXAS |   73301 | 111-111-1111    |
