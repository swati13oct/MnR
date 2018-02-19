@testonly-seirra003
Feature: Sierra HP (Utah) Migration  	
Scenario Outline: 	As an authenticated Sierra Spectrum Plan member who has registered on UHCMedicareSolutions.com I am able to view and interact with the My Health And Wellness  the same as any other MAPD authenticated member 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the My Health & Wellness page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Then I should see the Sierra plan on the page
Examples:
	| planType | memberType |
	| MAPD_TestOnly     | Individual |

 
Scenario Outline: 	As an authenticated Sierra Spectrum Plan member who has registered on UHCMedicareSolutions.com I am able to view and interact with the Go Green Page the same as any other MAPD authenticated member 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the Go Green page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Then I should see the Sierra plan on the Page
Examples:
	|planType|memberType|
	|MAPD_TestOnly|Individual|
	 	