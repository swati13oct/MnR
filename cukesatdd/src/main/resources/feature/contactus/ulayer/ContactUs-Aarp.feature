@contactUsTestulayer
Feature: To test contact us flow in AARP site
Scenario Outline: Verify contact us page in AARP site 
Given registered AMP member with following attributes
   | <planType> |
When the user navigates to contact us page in AARP site
Then the user validates the contact us page in AARP site

##Examples:
##	| planType | 
	| PDP      |
	
	
	
## For secure email 

Scenario Outline: Verify contact us page in AARP site 
Given registered AMP member with following attributes
#    | <planType> |
When the user navigates to contact us page in AARP site
#c

#Examples:
#	| planType |
	| PDP    |	