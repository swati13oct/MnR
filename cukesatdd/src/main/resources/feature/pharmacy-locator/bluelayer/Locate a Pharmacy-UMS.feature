@pharmacylocator1
Feature:To test Locate a Pharmacy in acqusition flow UMS site
Scenario Outline:To verify available pharmacies in UMS site
When the user selects pharmacy link in UMS site
And the user enters zipcode ,distance and county details in UMS site
	| Zip Code    | <zipcode>   |
	| Distance | <distance>    |
	 | County Name | <county>    |
And the user chooses plan in Locate a Pharmacy in UMS site
     | Plan Name | <planName> |
And the user selects "show pharmacy for all types" in Locate a Pharmacy
Then the user validates the Pharmacies Available in Your Area

Examples:
	| zipcode     | distance  | county       |  planName 			               	  | 
	| 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 
	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    | 
        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 
	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   | 




Scenario Outline:To verify available pharmacies for particular pharmacy types in UMS site
When the user selects pharmacy link in UMS site
And the user enters zipcode ,distance and county details in UMS site
	| Zip Code    | <zipcode>   |
	| Distance | <distance>    |
	 | County Name | <county>    |
And the user chooses plan in Locate a Pharmacy in UMS site
     | Plan Name | <planName> |
And the user selects "Show pharmacies for these services" in Locate a Pharmacy
     | Pharmacy Type | <pharmacytype> |
Then the user validates the Pharmacies Available in Your Area

Examples:
	| zipcode     | distance  | county       |  planName 			                 	  | pharmacytype               |
	| 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy |
	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |  Open 24 hours             |
        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |  Pharmacy Saver™ Program   |
	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   |  Open 24 hours             |