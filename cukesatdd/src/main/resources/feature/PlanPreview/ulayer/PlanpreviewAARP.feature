@planpaarp
Feature: To test multi county modal pop up on Plan Preview Page in AARP site

Scenario Outline: Verify multi county modal pop up on Plan Preview Page in AARP site

Given the user is on the Plan Preview Page of AARP medicare site landing page
When the user validates the multicounty popup on ulayer
| Zip Code    | <zipcode> |
| County Name | <county>  |

Examples:
| zipcode | county             |
#| 90210   | Los Angeles County |
| 80002   | Jefferson County   |
#| 80001   | Jefferson County   |
#| 78006   | Comal County       |
#| 78006   | Bexar County       |

