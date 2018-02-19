@tfn
Feature: To test TFN in Home Page footer for  AARP site
Scenario Outline: Verify TFN in Home page footer
Given the user navigates to the AARP Home page from any search engine
	| Search Engine | <searchEngine> |
When the user views the AARP Home page
Then user validates the below data in Aarp Home page footer
	|  MA_PDP_TFN     |
	|  MED_SUPP_TFN	  |
	| OPERATION HOURS |

Examples:
	| searchEngine   |
#	| notApplicable  |
#	| google         |
#	| yahoo          |
	| bing           |