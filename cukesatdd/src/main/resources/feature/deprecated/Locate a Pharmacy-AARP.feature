@unimplemented
Feature:To test Locate a Pharmacy in AARP site
Scenario Outline:To verify available pharmacies displayed in Locate a Pharmacy in AARP site
When the user selects pharmacy link in AARP Site
And the user enters zipcode and distance details in AARP Site
	| Zip Code    | <zipcode>   |
	| Distance | <distance>    |
And the user selects county for AARP Site
	 | County Name | <county>    |
And the user chooses plan and select a pharmacy type in Locate a Pharmacy
     | Plan Name | <planName> |
And the user selects show pharmacy for all types in Locate a Pharmacy
Then the user validates the Pharmacies Available in Your Area

Examples:
	| zipCode     | distance  | countyName       |  planName 			               	  | 
	| 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | 
	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    | 
        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 
	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   | 


Scenario Outline:To verify pharmacies displayed in Locate a Pharmacy in AARP site
When the user selects pharmacy link in AARP Site
And the user enters zipcode and distance details in AARP Site
	| Zip Code    | <zipcode>   |
	| Distance | <distance>    |
And the user selects county for AARP Site
	 | County Name | <county>    |
And the user chooses plan and select a pharmacy type in Locate a Pharmacy
     | Plan Name | <planName> |
And the user selects Show pharmacies for these services in Locate a Pharmacy
     | Pharmacy Type | <pharmacytype> |
Then the user validates the Pharmacies Available in Your Area

Examples:
	| zipCode     | distance  | countyName       |  planName 			               	  | pharmacytype               |
	| 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy |
	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |  Open 24 hours             |
        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |  Pharmacy Saver™ Program   |
	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   |  Open 24 hours             |