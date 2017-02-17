@claimspage
Feature: To validate the new changes related to claims page for MA/MAPD on the member redesigned site
Scenario Outline: To Verify Claims Page Header for
Given I am an AMS member on the redesigned member site
| Plan Type   | <planType>   |
When i navigate to the Claims Summary page in AMS site
Then i can view a Page Header in Claims Sumamry page in AMS site
And a View Claims for dropdown menu that defaults to last 90 days in Claims Sumamry page in AMS site
And a Claim type dropdown in Claims Sumamry page in AMS site
And all Body Copy on the page in Claims Sumamry page in AMS site
 Examples:
 | planType  | 
 | MAPD      |  
 |   MA      | 
 
 
#US492608 
@cliamstable 
 Scenario Outline: To verify Claims Table for MA/MAPD member on new UHC Claims Sumamry Page
 Given I am an AMS member on the redesigned member site
| Plan Type   | <planType>   |
When i navigate to the Claims Summary page in AMS site
Then I can view all Body Copy on the page in AMS site
And dynamic text with the number of claims and search criteria, or date range for custom search
And a Claims Table with pagination in AMS site
#And all Text on the page in the AMS site

Examples:

 | planType  | 
 | MA        |
 | MAPD      |
 
#US494688 
@claimsEob
Scenario Outline: To verify EOB for MA/MAPD member on new UHC Claims Summary Page
Given I am an AMS member on the redesigned member site
| Plan Type   | <planType>   |
When i navigate to the Claims Summary page in AMS site
Then I can view an Explanation of Benefits component with the Medical and/or Prescription Drug EOB search buttons based on my plan type
| Domain | <domain>  |

Examples:

 | planType  |  domain |
 | MA        |  COSMOS |
 | MAPD      |  COSMOS |
 
 
 
 