@contactUsTest
Feature: To test contact us flow in UMS site
Scenario Outline: Verify contact us page in UMS site 
Given registered UMS member with following attributes
    | Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user navigates to contact us page in UHC site
Examples:
	  | planType   |  memberType   |
      | MAPD       |  Individual   | 