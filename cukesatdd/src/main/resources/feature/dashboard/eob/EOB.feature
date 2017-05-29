 @eob
 Feature:To test EOB on Dashboard page
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
	| MAPD      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 Months   |
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
 	| PDP      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 Months   |	
 
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
 	| Combo      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 Months   |
 	
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
 	| Ship      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 3-6 Months   |	
 	
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
 	| MA  | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 Months   |
 	
@F85974	
Scenario Outline: To verify How to read a medical EOB PDF
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page
And the user validates how to read medical eob PDF
 	Examples:
	| planType  | memberType   |
	| MAPD      | withEOB      |
	| MA        | withEOB      |	

@F85974
Scenario Outline: To verify mobile responsive for all plans on EOB page
Given registered AMP with for EOB flow
       | Plan Type      |<planType>  |
       | Member Type    |<memberType>|
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange1>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange2>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange3>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange4>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Examples:
       | planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange1       |dateRange2 |dateRange3 |dateRange4 |
      |Ship      | withEOB      | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 3-6 Months |Last 6-12 Months|Last 12-18 Months| 
      | MA      |  withEOB     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |
      | MAPD      |  withEOB     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |  
      | PDP      |  withEOB     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |   

@eobStatments 	
Scenario Outline: To verify EOB result list
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
And the user validates EOB statments displayed
	Examples:
	| planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange       |
 	| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 Months   |
 	| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 9 Months   |
 	| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 12 Months   |
 	| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 18 Months   | 	
 	| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 6 Months |
 	| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 12 Months |
 	| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 18 Months |
 	| Ship    | withEOB      | Medical           |12/12/2007 | 12/12/2008 | Last 12-18 Months |
 
@F85974	
Scenario Outline: To validate EOB Type Drop-Down (UI) - MAPD
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
And the user validates EOB type and Date Range for MAPD
| Plan Type      |<planType>  |
|Date Range| <dateRange>|
Examples:
| planType  | memberType   | eobTypeData      |  
| MAPD     | withEOB      | Medical           |