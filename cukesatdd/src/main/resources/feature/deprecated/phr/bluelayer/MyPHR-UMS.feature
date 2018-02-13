@phr
Feature:To test personal health record in UHC site
Scenario Outline:Verify personal health record in UHC site for following type of plan member
Given registered UHC member with following attributes
    | Plan Type    | <plantype>   |
	| Member Type  | <memberType> |	    	    	    
When the user navigates to personal health record in UHC site
Then the user validates the personal health records details in UHC site
#Then the user validates care messages information in UHC site 
#And the user validates doctors information in UHC site     
#And the user validates my drugs information in UHC site       
#And the user validates health concerns information in UHC site      
#And the user validates facilities information in UHC site
#And the user validates pharmacies information in UHC site
#And the user validates products information in UHC site 
#And the user validates quizzes & assessments information in UHC site
 
Examples:
     | planType           | memberType         |
 #   | MA                 | Individual         |
 #   | MAPD               | Individual         |
 #   | MA                 | Group              |
 #   | MAPD               | Group              |
     | PDP                | Group              |
 #   | SSUP               | Group              |


Scenario Outline:Verify personal health record in UHC site for combo type of plan member
Given registered UHC member with following attributes
		| Plan Type 1  | <planType1>   |
		| Plan Type 2  | <planType2>   |
	    | Member Type  | <memberType> |	 
When the user navigates to personal health record in UHC site
Then the user validates care messages information    
And the user validates doctors information   
And the user validates my drugs information  
And the user validates health concerns information  
And the user validates facilities information
And the user validates pharmacies information
And the user validates products information
And the user validates quizzes & assessments information
 
Examples:
     | planType1          | planType2         | memberType |
 #    | PDP               | SSUP              | Group      |
 
Scenario Outline: Verify preferred pharmacies on my pharmacies widget
Given registered UHC member with following attributes
    | Plan Type    | <planType>   |
	  | Member Type  | <memberType> |	    	    	    
And user navigates to personal health record in UHC site
Then the user validates the my pharamcies on phr page
Examples:
     | planType           | memberType         |
     | MAPD               | Group              |
