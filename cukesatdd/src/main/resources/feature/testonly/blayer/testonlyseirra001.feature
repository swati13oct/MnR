@testonly-seirra
Feature: Sierra HP (Utah) Migration  
Scenario Outline: 	As an authenticated Sierra Spectrum Plan member who has registered on UHCMedicareSolutions.com I am able to view and interact with the My 
Account Home Page the same as any other MAPD authenticated member 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the My Account Home page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Then I should see the Sierra plan in My Home Page
Examples:
	| planType | memberType |
	| MAPD_TestOnly     | Individual |

Scenario Outline: 	As an authenticated Sierra Spectrum Plan member who has registered on UHCMedicareSolutions.com I am able to view and interact with the My Profile Page the same as any other MAPD authenticated member 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the MyProfile page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Then I should see the Sierra plan in profile page
Examples:
	| planType | memberType |
	| MAPD_TestOnly     | Individual |


Scenario Outline: 	As an authenticated Sierra Spectrum Plan member who has registered on UHCMedicareSolutions.com I am able to view and interact with the My Forms and Resources Page the same as any other MAPD authenticated member 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the My Forms and Resource page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Then I should see the Sierra plan on the page
Examples:
	| planType | memberType |
	| MAPD_TestOnly     | Individual 

Scenario Outline: 	As an authenticated Sierra Spectrum Plan member who has registered on UHCMedicareSolutions.com I am able to view and interact with the MyOrder My Materials page the same as any other MAPD authenticated member 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the Order My Materials page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Then I should see the Sierra plan on the page
Examples:
	| planType | memberType |
	| MAPD_TestOnly     | Individual |
	
Scenario Outline: 	As an authenticated Sierra Spectrum Plan member who has registered on UHCMedicareSolutions.com I am able to view and interact with the My Summary page  the same as any other MAPD authenticated member 
Given I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com
When I am using the Pharmacy Locator page
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |

Then I should see the Sierra plan on the page
Examples:
	| planType | memberType |
	| MAPD_TestOnly     | Individual |
	
