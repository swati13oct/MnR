@planpums
Feature: To test Plan Preview Page in UMS site

#Scenario Outline: Verify multi county modal pop up on Plan Preview Page in UMS site

#Given the user is on the Plan Preview Page of UMS medicare site landing page
#When the user validates the multicounty popup on bluelayer
##| Zip Code    | <zipcode> |
##| County Name | <county>  |

#Examples:
#| zipcode | county             |
#| 90210   | Los Angeles County |
##| 80002   | Jefferson County   |
#| 80001   | Jefferson County   |
#| 78006   | Comal County       |
#| 78006   | Bexar County       |


#Scenario Outline: Verify select plan drop down on Plan Preview Page in UMS site
#Given the user is on the Plan Preview Page of UMS medicare site landing page
#When the user validates the multicounty popup on bluelayer
#| Zip Code    | <zipcode> |
#| County Name | <county>  |
#And  user select the below  plan 
#|PlanName| <planName>|
##|PlanType|  <plantype>|


#Examples:
#| zipcode | county             | planName|                                          plantype |
#| 90210   | Los Angeles County | AARP MedicareRx Preferred (PDP)| 						PDP  |
#| 80002   | Jefferson County   |AARP MedicareComplete SecureHorizons Plan 2 (HMO)| 	MAPD  |
#|90002|                        |AARP MedicareRx Walgreens (PDP)|			PDP		|
#|90210|                        |AARP MedicareComplete SecureHorizons Plan 2 (HMO)| MAPD|

#Scenario Outline: Verify Look up zipcode flow from home page in AARP site
#Given the user is on the Plan Preview Page of AARP medicare site landing page
#When the user clicks on lookup zipcode link in Planpreview  page
#And the user searches for zipcodes by entering the following Address and city and State details for AARP site
   ## | Address    | <Address>   |
    #| City       | <city>      |
  #  | State      | <state>     |
    
  ##  Examples:
  #| Address | city          |  state     | 
  #| 1234    | california    | California |
 #| 1267    | Aspen     | Colorado   |
 #| 1423    | Boise     | Idaho      |
 #| 1923    | Honolulu     |  HAWAII    |
 
 
## Scenario Outline: Verify provider search and pharmacy locatorlink on Plan Preview Page in UMS site
##Given the user is on the Plan Preview Page of UMS medicare site landing page
##When the user validates the multicounty popup on bluelayer
#| Zip Code    | <zipcode> |
#| County Name | <county>  |
#And  user select the below  plan 
#|PlanName| <planName>|
#|PlanType|  <plantype>|
#Then user validates the provider search and locate pharmacy link
# And user clicks on locate pharmacy
#Then user validates the plan year dropdown

#Examples:
#| zipcode | county             | planName|                                        plantype |
#| 90210   | Los Angeles County | AARP MedicareRx Preferred (PDP)| 						         PDP  |
#| 80002   | Jefferson County   |AARP MedicareComplete SecureHorizons Plan 1 (HMO)| 	MAPD  |
#|90002|                        |AARP MedicareRx Walgreens (PDP)|			PDP		|
#|90210|                        |AARP MedicareComplete SecureHorizons Plan 2 (HMO)| MAPD| 

##Scenario Outline: Verify Rally connect  on Plan Preview Page in UMS site
##Given the user is on the Plan Preview Page of UMS medicare site landing page
##When the user validates the multicounty popup on bluelayer
##| Zip Code    | <zipcode> |
##| County Name | <county>  |
##And  user select the below  plan 
#|PlanName| <planName>|
#|PlanType|  <plantype>|
#Then user validates the provider search and locate pharmacy link
#And user click on provider link


#Examples:
#| zipcode | county             | planName|                                          plantype |

#| 80002   | Jefferson County   |AARP MedicareComplete SecureHorizons Plan 1 (HMO)| 	MAPD  |

#|90210|                        |AARP MedicareRx Preferred (PDP)| 						         PDP | 
 
Scenario Outline: Verify PDFs on Plan Preview Page in AARP site
Given the user is on the Plan Preview Page of UMS medicare site landing page
When the user validates the multicounty popup on bluelayer
| Zip Code    | <zipcode> |
| County Name | <county>  |
And  user select the below  plan 
|PlanName| <planName>|
|PlanType|  <plantype>|
And the user validate pdf links

Examples:
| zipcode | county             | planName|                                          plantype |

| 80002   | Adams County   |AARP MedicareComplete SecureHorizons Plan 1 (HMO)| 	MAPD  |

#|90210|                        |AARP MedicareComplete SecureHorizons Plan 2 (HMO)| MAPD| 


