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
Scenario Outline: Verify Send us a question Widget section in contact us redesign page which covers 1,3,4
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user validates Group secure email widget  in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |

Scenario Outline: Verify Send us a question Widget section in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user validates cancel click on Group secure email widget  in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |

Scenario Outline: Verify Send us a question Widget section in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |
	
#US634977
Scenario Outline: Verify Send us a question Widget section in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |

Scenario Outline:routing to appropriate department after clicking submit question button by  selecting Physician option  in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user clicks on submit question by selecting Finding a Physician option in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |

	
Scenario Outline:routing to appropriate department after clicking submit question button by  selecting Billing Information option  in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user clicks on submit question by selecting Billing Information option in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |
Scenario Outline:validating emailIds in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user enters invalidate alternative email ID in sendUS A question widget

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |
	
Scenario Outline:validating emailIds in contact us redesign page 
Given registered UMS member with following attributes
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Then user enters invalidate Confirm email ID in sendUS A question widget

Examples:
	| planType | |  memberType   |
	| MAPD      | |  Group   |
	