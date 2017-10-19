@fixedTestCaseTest
@eob
Feature:1.21-VBF-Member-To test EOB flows under forms and resources in AARP site
@medEOBUlayer
Scenario Outline:To verify Medical EOB in forms and resoutces flow in AARP site
Given registered AMP with following details for EOB flow
	| Plan Type      | <plantype>  |
	| Member Type	| <memberType> |
When the user views forms and resources in AARP site
And the user clicks My Medical Explanation of Benefits link in forms and resources page in AARP site
Then the user searches EOB history for the date range in AARP site and validates
	| Date Range | <dateRange> |
Examples:
	| plantype |memberType | dateRange      |
	| MA     | cosmos_eob | Last 18 Months |

@rxEOBUlayer
Scenario Outline:To verify Prescription Drug EOB in forms and resources flow in AARP site
Given registered AMP with following details for EOB flow
	 | Plan Type      | <plantype>  |
	 | Member Type	| <memberType> |
When the user views forms and resources in AARP site
And the user clicks My Prescription Drug Explanation of Benefits link in forms and resources page in AARP site
	| Plan Type      | <plantype>  |
And the user searches prescription drug EOB history for the date range in AARP site and validates
	| From Date | <fromDate> |
	| To Date   | <toDate> |
Examples:
	| plantype | memberType | fromDate   | toDate     |
	| PDP   | rx_eob | 01-01-2017 | 09-06-2017 |
