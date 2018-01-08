@ssllabs
@fixedTestCaseTest
Feature:0.01-looking for A- response on ssllabs 
Scenario Outline:To verify AARP site getting A- response on ssllabs
Given the user is on the ssllabs site home page
When the user enters AARP site URL into text box
Then the user sees response for AARP site 
	| URL				| <www.ssllabs.com/ssltest> |
	| HOSTNAME			| <www.aarpmedicareplans.com> |

Examples:
	|URL                     				  | 	   HOSTNAME				|
	|https://www.ssllabs.com/ssltest		  |	www.aarpmedicareplans.com	|
	
Scenario Outline:To verify UHC site getting A- response on ssllabs
Given the user is on the ssllabs site home page for UHC
When the user enters UHC site URL into text box
Then the user sees response for UHC site 
	| URL				| <www.ssllabs.com/ssltest> |
	| HOSTNAME			| <www.uhcmedicaresolutions.com> |

Examples:
	|URL                     				  | 	   HOSTNAME			    	|
	|https://www.ssllabs.com/ssltest		  |	www.uhcmedicaresolutions.com	|