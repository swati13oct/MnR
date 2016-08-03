@planpaarp
Feature: To test Plan Preview Page in AARP site

Scenario Outline: Verify multi county modal pop up on Plan Preview Page in UMS site

Given the user is on the Plan Preview Page of UMS medicare site landing page
When the user validates the multicounty popup on bluelayer
 Zip Code    | <zipcode> |
| County Name | <county>  |

Examples:
| zipcode | county             |
| 90210   | Los Angeles County |
| 80002   | Jefferson County   |
#| 80001   | Jefferson County   |
#| 78006   | Comal County       |
#| 78006   | Bexar County       |