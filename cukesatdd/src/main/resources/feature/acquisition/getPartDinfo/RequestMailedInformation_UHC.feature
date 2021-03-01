#Author:shiva
#created Date:2/12/2019
@testcase
Feature: Acq-To test request Mailed information with an agent flow in UHC site (GATED)

  @requestmailedinformationUHC
  Scenario Outline: Verify request for mailed information in UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to request more help and information in UHC site
    When the user navigates to the request mailed information in UHC site and validates page is loaded
    And the user fills the Enrollment guide plan form and validate the order confirmation page in UHC site
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
