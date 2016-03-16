@TFNtest
Feature: To test TFN in Home Page footer for  AARP site
Scenario Outline: Verify TFN in Home page footer
Given the user navigates to the AARP Home page from any search engine
	| <searchEngine> |
When the user navigates to View Plans and Pricing for below plan type section in AARP site
	| <planType> |
Then user validates the TFN displayed

Examples:
	| searchEngine   |   planType	|
#	| notApplicable  |	MA	|
	| google         |	MA	|	
	| yahoo          |	MA	|
	| bing           |	MA	|