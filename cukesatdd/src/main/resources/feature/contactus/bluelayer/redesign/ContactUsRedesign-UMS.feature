@contactUsTestredesignBlue
Feature: To test Send us a question Widget and Click to call functionality in contact us redesign pages in UHCM site
#US634975
Scenario Outline: Verify Send us a question Widget section in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user validates secure email widget UI in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |
#US634972	
Scenario Outline: Verify Send us a question Widget section in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user validates Group secure email widget UI in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |
	
