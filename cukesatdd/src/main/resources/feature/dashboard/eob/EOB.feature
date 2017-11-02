@eob
Feature:To test EOB on Dashboard page

@fixed @demo
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
	| planType    | memberType           | eobTypeData       | fromDate   | toDate     |dateRange       |
	| MAPD-COSMOS | q4_dec_aarp018       | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
 #	| MAPD-NICE   | q3_sep_ulayer028     | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
#	| MA-NICE     | q3_sep_ulayer193     | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
@F85974
@fixed
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
	| planType     | memberType            | eobTypeData       | fromDate   | toDate     |dateRange       |
	| MAPD-COSMO   | q4_dec_aarp018      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
 	| PDP          | q4_dec_aarp288      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
 	#| Combo      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |	
 	#| Ship       | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 3-6 Months   |	
 
#@workingOn
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
 	#| Combo     | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
 	| MA  			| withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
 	
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
 	
 	
Scenario Outline: To verify How to read a medical EOB PDF
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page
And the user validates how to read medical eob PDF
 	Examples:
	| planType  | memberType   |
	| MAPD      | q3_sep_ulayer561      |
	 

@notWorking
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
      #|Ship      | withEOB      | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 3-6 Months |Last 6-12 Months|Last 12-18 Months| 
      #| MA        |  withEOB     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |
      | MAPD      |  q3_sep_ulayer561     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 days  |  Last 6 months  | Last 12 months  | Last 18 months |  
      | PDP       |  q3_sep_ulayer293     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 days  |  Last 6 months  | Last 12 months  | Last 18 months |  

@F85974passed 	
Scenario Outline: To verify EOB result list
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
And the user validates EOB statments displayed
	Examples:
	| planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange       |
 	| MAPD      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 Months   |
 	| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 9 Months   |
 	#| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 12 Months   |
 	#| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 18 Months   | 	
 	#| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 6 Months |
 	#| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 12 Months |
 	#| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 18 Months |
 	#| Ship    | withEOB      | Medical           |12/12/2007 | 12/12/2008 | Last 12-18 Months |
 
@notWorking	
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
| MAPD     | q3_sep_ulayer561      | Medical           |

@F85974passed	
Scenario Outline: To verify How to read a medical EOB PDF
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page
And the user validates how to read medical eob PDF
 	Examples:
	| planType  | memberType   |
	| MAPD      | GroupwithEOB      |
	| MA        | GroupwithEOB      |	

@F85974passed
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
      #|Ship      | withEOB      | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 3-6 Months |Last 6-12 Months|Last 12-18 Months| 
      | MA      |  GroupwithEOB     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |
      | MAPD      |  GroupwithEOB     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |  
      #| PDP      |  withEOB     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |   

@F85974passed 	
Scenario Outline: To verify EOB result list
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
And the user validates EOB statments displayed
	Examples:
	| planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange       |
 	| MAPD      | GroupwithEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 6 Months   |
 	| MA      | GroupwithEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 9 Months   |
 	#| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 12 Months   |
 	#| MA      | withEOB      | Medical           | 12/12/2007 | 12/12/2008 |Last 18 Months   | 	
 	#| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 6 Months |
 	#| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 12 Months |
 	#| PDP     | withEOB      | Prescription      |12/12/2007 | 12/12/2008 | Last 18 Months |
 	#| Ship    | withEOB      | Medical           |12/12/2007 | 12/12/2008 | Last 12-18 Months |
 
@F85974passed	@workingOn
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
| MAPD     | GroupwithEOB      | Medical           |

@F101852 @EOBVideos @needMemberWithEOB
Scenario Outline: To verify How to read a medical EOB Videos
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page
Then the user validates How to read your Medical EOB video
 	Examples:
	| planType  | memberType   |
	| MAPD      | rx_eob_001      |
	#| MA        | withEOBVideo      |
	
@EOBSepsprint1 @fixed
Scenario Outline: To validate EOB Type Drop-Down
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
       | planType  | memberType   | eobTypeData        | fromDate   | toDate     |   dateRange    | 
       | MAPD       | q4_dec_aarp018      | Medical           | 2016/01/01 | 2017/04/01 | Custom Search  |
 			 #| MA         | withEOB      | Medical           | 2016/01/01 | 2017/04/01 | Custom Search  |
       #| PDP       | withEOB      | Medical           | 2016/01/01 | 2017/04/01 | Custom Search  |
      # | Ship      | withEOB      | Medical           | 2016/01/01 | 2017/04/01 | Custom Search  |
 @EOBSepsprint1 @fixed
Scenario Outline: To validate EOB PAgination
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page
And the user validates pagination functionality
|Date Range|<dateRange>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |      

Examples:
       | planType  | memberType   				| eobTypeData        | fromDate   | toDate     |   dateRange    | 
       | MAPD      | q4_dec_aarp018     | Medical           | 2016/01/01 | 2017/04/01 | Custom Search  |   
       
@fixed
Scenario Outline: Allowed Domains � Authors need ability to define messages and domains for leaving member sites (ATDD)
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page 
Then the user validates site leaving pop up         
Examples:
       | planType  | memberType        |  
    #   | MA-NICE   | q3_sep_ulayer193  | 
       | MAPD  | q4_dec_aarp018  |    
       	