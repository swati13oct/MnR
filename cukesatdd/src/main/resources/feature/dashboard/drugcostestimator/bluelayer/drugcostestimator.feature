@drug_cost_estimator
Feature:Drug Cost Estimator- Pharmacy 
Scenario Outline: To Verify MR portal members using DCE-Pharmacy on a desktop device 
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
Then the user should be able to validate the pharmacy information
Examples:

 | planType  | memberType  | zipcode| radius|
 | MA       |Individual | | 90002 | 25miles |

	