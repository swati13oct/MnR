@eob
Feature:To test EOB in AARP site
Scenario Outline:To verify Medical EOB in AARP site
Given registered AMP with following details for EOB flow
        | Plan Type | <plantype>  |
When the user clicks My Medical Explanation of Benefits link in My menu in AARP site
And the user searches EOB history for the date range in AARP site
	| Date Range | <dateRange> |
Then the user validates medical explanation of benefits in AARP site
Examples:
	| plantype | dateRange      |
#	| MA       | Last 12 Months |
#	| MAPD     | Last 12 Months |


Scenario Outline:To verify Prescription Drug EOB in AARP site
Given registered AMP with following details for EOB flow
	| Plan Type      | <plantype>  |
When the user clicks My Prescription Drug Explanation of Benefits link in My menu in AARP site
And the user searches prescription drug EOB history for the date range in AARP site
	| From Date | <fromDate> |
	| To Date   | <toDate> |
Then the user validates prescription drug explanation of benefits in AARP site
Examples:
	| plantype | fromDate   | toDate     |
#	| PDP      | 01-01-2015 | 12-06-2015 |
#	| MAPD     | 01-01-2015 | 12-06-2015 |



Scenario Outline:To verify Supplemental Insurance EOB in AARP site
Given registered AMP with following details for EOB flow
	| Plan Type      | <plantype>  |
When the user clicks Supplemental Insurance Explanation of Benefits link in My menu in AARP site
And the user searches Supplemental Insurance EOB history for the date range in AARP site
	| Date Range | <dateRange> |
Then the user validates Supplemental Insurance Explanation of Benefits
Examples:
	| plantype | dateRange   |
#	| MS       | 6-12 Months |
#	| HIP      | 6-12 Months |


Scenario Outline:To verify Medical EOB in forms and resoutces flow in AARP site
Given registered AMP with following details for EOB flow
	| Plan Type      | <plantype>  |
When the user views forms and resources in AARP site
And the user clicks My Medical Explanation of Benefits link in forms and resources page in AARP site
And the user searches EOB history for the date range in AARP site
	| Date Range | <dateRange> |
Then the user validates medical explanation of benefits in AARP site
Examples:
	| plantype | dateRange      |
#	| MA       | Last 12 Months |
#	| MAPD     | Last 12 Months |

Scenario Outline:To verify Prescription Drug EOB in forms and resoutces flow in AARP site
Given registered AMP with following details for EOB flow
	 | Plan Type      | <plantype>  |
When the user views forms and resources in AARP site
And the user clicks My Prescription Drug Explanation of Benefits link in forms and resources page in AARP site
And the user searches prescription drug EOB history for the date range in AARP site
	| From Date | <fromDate> |
	| To Date   | <toDate> |
Then the user validates prescription drug explanation of benefits in AARP site
Examples:
	| plantype | fromDate   | toDate     |
	| PDP      | 01-01-2015 | 12-06-2015 |
#	| MAPD     | 01-01-2015 | 12-06-2015 |


Scenario Outline:To verify EOB for forms and resoutces flow in AARP site
Given registered AMP with following details for EOB flow
	| Plan Type      | <plantype>  |
When the user views forms and resources in AARP site
And the user clicks Supplemental Insurance Explanation of Benefits link in forms and resources page in AARP site
And the user searches Supplemental Insurance EOB history for the date range in AARP site
	| Date Range | <dateRange> |
Then the user validates Supplemental Insurance Explanation of Benefits
Examples:
	| plantype | dateRange   |
#	| MS       | 6-12 Months |
#	| HIP      | 6-12 Months |

@F85974
Scenario Outline: To verify mobile responsive for all plans on EOB page
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page and validates the page
 |Date Range|<dateRange>  |
 |Plan Type |<planType>   |
 |EOB Type  |<eobTypeData>|
 |From Date |<fromDate>   |
 |To Date   |<toDate>     |
Examples:
	| planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange       |
	| MAPD      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
	@F85974
Scenario Outline: To verify mobile responsive for all plans on EOB page
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page and validates the page
 |Date Range|<dateRange>  |
 |Plan Type |<planType>   |
 |EOB Type  |<eobTypeData>|
 |From Date |<fromDate>   |
 |To Date   |<toDate>     |
Examples:
	| planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange       |
 	| PDP      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |	
 	
 	@F85974
Scenario Outline: To verify mobile responsive for all plans on EOB page
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page and validates the page
 |Date Range|<dateRange>  |
 |Plan Type |<planType>   |
 |EOB Type  |<eobTypeData>|
 |From Date |<fromDate>   |
 |To Date   |<toDate>     |
Examples:
	| planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange       |
 	| Combo      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
 	
 	@F85974
Scenario Outline: To verify mobile responsive for all plans on EOB page
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page and validates the page
 |Date Range|<dateRange>  |
 |Plan Type |<planType>   |
 |EOB Type  |<eobTypeData>|
 |From Date |<fromDate>   |
 |To Date   |<toDate>     |
Examples:
	| planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange       |
 	| Ship      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |	