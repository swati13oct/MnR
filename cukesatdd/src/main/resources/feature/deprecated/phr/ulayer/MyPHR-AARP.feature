@phr
Feature:To test personal health record in AARP site
Scenario Outline:Verify personal health record in AARP site for member enrolled in federal and ship plans
Given registered AMP with following details for phr flow in AARP site
		| <planType> |	
When the user navigates to the personal health record in AARP site
Then the user validates the personal health records details in AARP site
 
Examples:
    | planType           | 
    | MA                 | 
    | MAPD               | 
    | PDP                | 
    | MS                 | 
    | HIP                |
    

     
     
    