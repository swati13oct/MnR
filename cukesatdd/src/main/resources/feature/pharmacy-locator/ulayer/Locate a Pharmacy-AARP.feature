@pharmacylocator1
Feature:To test Locate a Pharmacy in acqusition flow AARP site
Scenario Outline:To verify available pharmacies in AARP site
When the user selects pharmacy link in AARP Site
And the user enters zipcode ,distance and county details in AARP Site
	| Zip Code    | <zipcode>   |
	| Distance    | <distance>    |
	| County Name | <county>    |
And the user chooses plan in AARP Site
	| Plan Name | <planName> |
And the user selects "show pharmacy for all types" in AARP Site
And the user searches for pharmacy available in AARP Site
Then the user validates the Pharmacies Available in AARP Site

Examples:
	| zipcode     | distance  | county       |  planName 			               	  | 
	| 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 
	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    | 
        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 
	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   | 


Scenario Outline:To verify available pharmacies for particular pharmacy types in AARP site
When the user selects pharmacy link in AARP Site
And the user enters zipcode, distance and county details in AARP Site
	| Zip Code    | <zipcode>   |
	| Distance    | <distance>  |
	| County Name | <county>    |
And the user chooses plan in AARP Site
         | Plan Name | <planName> |
And the user selects "Show pharmacies for these services" in AARP Site
     | Pharmacy Type | <pharmacytype> |
And the user searches for pharmacy available in AARP Site
Then the user validates the Pharmacies Available in AARP Site

Examples:
	| zipcode     | distance | county       |  planName 			               	  |  pharmacytype			     |
	| 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy,Open 24 hours |
	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |  Open 24 hours			     |
        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |  Pharmacy Saver™ Program, Open 24 hours  |
	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   |  Open 24 hours                           |