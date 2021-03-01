#Author:shiva
#created Date:2/12/2019
@fixedTestCaseTest @testcase
Feature: 1.06-VBF-Acq-To test request an appointment with an agent flow in AARP site (GATED)

  @requestmailedinformation
  Scenario Outline: Verify request for mailed information in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to request more help and information in AARP site
    When the user navigates to the request mailed information in AARP site and validates page is loaded
    Then the user fills the Enrollment guide plan form and validate the order confirmation page
      | First Name     | <firstName> |
      | Last Name      | <lastName>  |
      | Date of Birth  | <DOB>       |
      | Address        | <address>   |
      | City           | <city>      |
      | Phone          | <phone>     |
      | State          | <state>     |
      | Zipcode        | <zipcode>   |
      | Medicarenumber | <Medicare>  |
      | Relationship   | <Relation>  |

    Examples: 
      | firstName | lastName | DOB        | city | address      | state      | zipcode | phone        | Relation                                   | Medicare    |
      | John      | Doe      | 11/05/1992 | Test | 100 Test way | NEW JERSEY |   08854 | 732-456-7890 | Self - I do not yet have a Medicare number | 2R36JQ1FU76 |
