@eob1
Feature:To test EOB in UMS site
Scenario Outline:To verify Medical EOB in UMS site
Given registered UHC with following details for EOB flow
	| Plan Type    | <plantype> |
	| Category     | <category> |
When the user clicks My Medical Explanation of Benefits link in My menu in UMS site
And the user searches EOB history for the following period in UMS site
	| Period  | <period> |
Then the user validates medical explanation of benefits in UMS site

Examples:
	| plantype | category   | period         |
#	| MA       | Individual | Last 12 Months |
#	| MAPD     | Individual | Last 12 Months |
#	| MA       | Group      | Last 12 Months |   
#	| MAPD     | Group      | Last 12 Months |
	

Scenario Outline:To verify Prescription Drug EOB in UMS site
Given registered UMS with following details for EOB flow
	| Plan Type | <plantype> |
	| Category  | <category> |
When the user clicks My Prescription Drug Explanation of Benefits link in My menu in UMS site
And the user searches prescription drug EOB history for the following interval in UMS site
	| From Date | <fromDate> |
	| To Date   | <toDate> |
Then the user validates prescription drug explanation of benefits in UMS site

Examples:
	| plantype | category  | fromDate   | toDate     |
#	| MAPD     |Individual | 01-01-2015 | 12-06-2015 |   
#	| MAPD     | Group     | 01-01-2015 | 12-06-2015 |
	| PDP      | Group     | 01-01-2015 | 12-06-2015 |
#	| SSP      | Group     | 01-01-2015 | 12-06-2015 |



Scenario Outline:To verify Medical EOB for forms and resources flow in UMS site
Given registered UMS with following details for EOB flow
	| Plan Type | <plantype>  |
	| Category  | <category> |
When the user views forms and resources in UMS site
And the user clicks My Medical Explanation of Benefits link in forms and resources page in UMS site
And the user searches EOB history for the date range in UMS site
	| Date Range  | <dateRange> |
Then the user validates medical explanation of benefits in UMS site

Examples:
	| plantype | category   | dateRange      |
#	| MA       |Individual  | Last 12 Months |
#	| MAPD     | Individual | Last 12 Months |
#	| MA       | Group      | Last 12 Months |   
#	| MAPD     | Group      | Last 12 Months |


Scenario Outline:To verify Prescription Drug EOB for forms and resources flow in UMS site
Given registered UMS with following details for EOB flow
	| Plan Type | <plantype>  |
	| Category  | <category> |
When the user views forms and resources in UMS site
And the user clicks My Prescription Drug Explanation of Benefits link in forms and resources page in UMS site
And the user searches EOB history for the following interval in UMS site
	| From Date | <fromDate> |
	| To Date   | <toDate> |
Then the user validates prescription drug explanation of benefits in UMS site

Examples:
	| plantype | category | fromDate   | toDate     |
#	| MAPD     |Individual | 01-01-2015 | 12-06-2015 |   
#	| MAPD     | Group    | 01-01-2015 | 12-06-2015 |
#	| PDP      | Group    | 01-01-2015 | 12-06-2015 |
#	| SSP      | Group    | 01-01-2015 | 12-06-2015 |
