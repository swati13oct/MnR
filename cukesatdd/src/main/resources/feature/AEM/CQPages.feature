@CQPages
Feature:To validate pages on AEM

@CQAcqPages
Scenario Outline:To validate Acquisition pages on AEM are loading
	Given the user is on the AEM login page and logs in
		|Username|<username>|
		|Password|<password>|
	And the user navigates to acquisition pages on AEM and validates
	
	Examples:
		|username  | password |
		|admin|admin |
		
@CQMemberPages
Scenario Outline:To validate Member pages on AEM are loading
	Given the user is on the AEM login page and logs in
		|Username|<username>|
		|Password|<password>|
	And the user navigates to member pages on AEM and validates
	
	Examples:
		|username  | password |
		|admin|admin |

Scenario Outline:To validate AEM OLE pages are loading
	Given the user is on the AEM login page and logs in
		|Username|<username>|
		|Password|<password>|
	And the user navigates to ole pages on AEM and validates
	
	Examples:
		|username  | password |
		|admin|admin |

Scenario Outline:To validate AEM VPP pages are loading 
	Given the user is on the AEM login page and logs in
		|Username|<username>|
		|Password|<password>|
	And the user navigates to vpp pages on AEM and validates
	
	Examples:
		|username  | password |
		|admin|admin |
	