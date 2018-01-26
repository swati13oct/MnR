@fixedTestCaseTest
@eob
Feature:1.22-VBF-Member-To test EOB flows under forms and resources in UMS site
@medEOBblayer
Scenario Outline:To verify Medical EOB for forms and resources flow in UMS site
Given registered UMS with following details for EOB flow
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
	| Eob Type     | <eobType>    |
When the user views forms and resources in UMS site
And the user clicks My Medical Explanation of Benefits link in forms and resources page in UMS site
Then the user searches EOB history for the date range in UMS site and validates
	| Date Range  | <dateRange> |
Examples:
	| plantype | memberType   | eobType | dateRange      |
	| MAPD       |Individual  | Med_EOB | Last 18 Months |


@rxEOB_blayer
Scenario Outline:To verify Prescription Drug EOB for forms and resources flow in UMS site
Given registered UMS with following details for EOB flow
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
	| Eob Type     | <eobType>    |
When the user views forms and resources in UMS site
And the user clicks My Prescription Drug Explanation of Benefits link in forms and resources page in UMS site
And the user searches prescription drug EOB history for the following interval in UMS site and validates
	| From Date | <fromDate> |
	| To Date   | <toDate> |
Examples:
	| plantype | memberType | eobType | fromDate   | toDate     |
	| MAPD     |Individual | rx_Eob | 12-03-2016 | 06-06-2017 |   
