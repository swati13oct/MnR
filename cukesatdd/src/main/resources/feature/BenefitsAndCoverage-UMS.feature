@unimplemented
Feature: To test plan benefits and Coverage on UMS site
Scenario Outline: Verify benefits and coverage in UMS site
Given registered AMP with following details for benefits and coverage flow
 | Plan Type      | <plantype>  |
 | MemberType     | <memberType>|
When the user views benefits and Coverage
Then the user validates Consumer Information details in plan benefits and Coverage
 | Member Number         | 
  | Effective Date        |
  | Primary Care Provider |

Examples:
		| plantype | memberType |
		| MA       | INDIVIDUAL |
		| MAPD     | INDIVIDUAL |
		| MA       | Group      |   
		| MAPD     | Group      |
		| PDP      | Group      |
		| SSUP      | Group      |

