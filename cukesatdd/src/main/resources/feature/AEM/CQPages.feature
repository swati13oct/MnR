@CQPages
Feature:To validate pages on AEM

Scenario Outline:To validate AEM pages are loading 
Given the user is on the AEM login page and logs in
	|Username|<username>|
	|Password|<password>|
And the user navigates to ole pages on AEM and validates

Examples:
|username  | password |
|automation|automation!23 |