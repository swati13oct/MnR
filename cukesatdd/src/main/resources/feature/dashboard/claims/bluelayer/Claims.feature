@redesignClaims
Feature: To validate the new changes related to claims page on the member redesigned site
@claimsHeader
Scenario Outline: To Verify Claims Page Header for new UHC Claims Sumamry Page
Given I am an UHC member on the redesigned member site
| Plan Type     | <planType>   |
| Member Type	  | <memberType> |
When I navigate to the Claims Summary page in UHC site
Then I can view a Page Header in Claims Sumamry page in UHC site
And View Claims for dropdown menu that defaults to last 90 days in Claims Sumamry page in UHC site
And Claim type dropdown in Claims Sumamry page in UHC site
And all Body Copy on the page in Claims Sumamry page in UHC site
 Examples:
 | planType  | memberType |
 #| MAPD      |  Group     |
 #|   MA      | Individual |
 | PDP       | Group      |
 
#US492608 
@cliamstable 
Scenario Outline: To verify Claims Table on new UHC Claims Sumamry Page
Given I am an UHC member on the redesigned member site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When I navigate to the Claims Summary page in UHC site
Then I can view all Body Copy on the page in UHC site
And dynamic text with the number of claims and search criteria, or date range for custom search in UHC site
And a Claims Table with pagination in UHC site
#And all Text on the page in the AMS site

Examples:
 | planType  | memberType |
 | MAPD      |  Group     |
 |   MA      | Individual |
 | PDP       | Group      |
 
#US494688 
@claimsEob
Scenario Outline: To verify EOB on new UHC Claims Summary Page
Given I am an UHC member on the redesigned member site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When I navigate to the Claims Summary page in UHC site
Then I can view an Explanation of Benefits component with the Medical and/or Prescription Drug EOB search buttons based on my plan type in UHC site
| Domain | <domain>  |

Examples:
 | planType  |  memberType |domain  |
 | MA        | Individual | COSMOS |
 | MAPD      |  Group     | COSMOS |
 |PDP        | Group      | COSMOS |
 
@claimsDownloadmydataButton
Scenario Outline: To Verify Downloadmydata button on new UHC Claims Summary Page 
Given I am an UHC member on the redesigned member site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When I navigate to the Claims Summary page in UHC site
Then I can view and validate the download my data button in UHC site
Examples:
| planType  | memberType |
 | MAPD      |  Group     |
 |   MA      | Individual |
 | PDP       | Group      |
 
@claimslearnmoresection 
Scenario Outline: To verify Learn More About Your Cost Breakdown on new UHC Claims Summary Page
Given I am an UHC member on the redesigned member site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When I navigate to the Claims Summary page in UHC site
Then I can view the Learn More About Your Cost Breakdown section in UHC site

Examples:
| planType  | memberType |
 | MAPD      |  Group     |
 |   MA      | Individual |
 | PDP       | Group      |