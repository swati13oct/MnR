@tfn
Feature: To test TFN in Home Page footer for  UMS site
#Scenario Outline: Verify TFN in Home page footer
#Given the user navigates to the UMS Home page from any search engine
#	| Search Engine | <searchEngine> |
#When the user views the UMS Home page
#Then user validates the below data in UMS Home page footer
#	|  MA_PDP_TFN     |
#	|  MED_SUPP_TFN	  |
#	| OPERATION HOURS |

#Examples:
#	| searchEngine   |
#	| notApplicable  |
#	| google         |
#	| yahoo          |
#	| bing           |
	
Scenario Outline: Verify TFN on Medicare education page for UMS site
Given the user navigates to the UMS Home page from any search engine
	| Search Engine | <searchEngine> |
When the user views the UMS Home page
#Then user navigates to Medicare Advantage page on UMS site
Then the user navigates to View Plans and Pricing for below plan type section in UMS site
| <planType> |
Then user validates the TFN displayed in UMS site
Examples:
	| searchEngine   |   planType	|
#	| notApplicable  |	MA	|
#	| google         |	MA	|	
#	| yahoo          |	MA	|
	| bing           |	MA	|