@unimplemented
Feature:To test EOB in UMS site
Scenario:To verify Medical EOB in UMS site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
 | MemberType     | <memberType>|
When the user clicks my menu
And the user selects My Medical Explanation of Benefits (EOB) in plan resources in UMS site
And the user selects date range for eob in UMS site
And the user search EOB history
Then the user validates EOB


Scenario:To verify Prescription Drug EOB in UMS site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
 | MemberType     | <memberType>|
When the user clicks my menu
And the user selects My Prescription Drug Explanation of Benefits (EOB) in plan resources in UMS site
And the user selects date range for eob in UMS site
And the user search EOB history
Then the user validates EOB




Scenario:To verify Medical EOB for forms and resoutces flow in UMS site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
 | MemberType     | <memberType>|
When the user user views forms and resources
And the user selects search Medical(EOB) history in plan resources in UMS site
And the user selects date range for eob in UMS site
And the user search EOB history
Then the user validates EOB



Scenario:To verify Prescription Drug EOB for forms and resoutces flow in UMS site
Given registered AMP with following details for EOB flow
 | Plan Type      | <plantype>  |
 | MemberType     | <memberType>|
When the user user views forms and resources
And the user selects search Prescription Drug EOB) history in plan resources in UMS site
And the user selects date range for eob in UMS site
And the user search EOB history
Then the user validates EOB
