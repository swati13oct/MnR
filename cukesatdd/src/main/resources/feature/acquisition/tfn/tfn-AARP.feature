@tfnulayer
Feature: To test TFN in all flows on AARP site

	@Scenario_1  @tfn_Direct_Traffic @tfn_aarp
Scenario Outline: 1.0 Verify TFN in VPP Tabs and PDP OLE
Given the user is on AARP medicare acquisition site page
					|  URL   			 | <url>  |
					|TFN Number MA |<tfnNumberMA>|
Then click to view MA plans in VPP to varify the TFN
	|TFN Number MA |<tfnNumberMA>|
Then Navigate to Medicare Education to varify TFN for AMP version
Then Navigate back to VPP and select MEdSup tab to varify TFN in right rail Display
Then Navigate back to VPP and select PDP tab to varify TFN 
Then click plan and drug coverage button for any PDP plan to varify TFN 
Then varify the right rail Display of TFN on PDP OLE

Examples: 
     | tfnNumberMA 	  | url                               |
     | 1-877-699-5710 | http://www.aarpmedicareplans.com/ |


@Scenario5  @Campaign_url @campaign
Scenario Outline: - 5.0 Visit Med Ed on AMP using campaign URL id 8001277
Given user is on campaign url and varify TFN
    		|  URL   | <url>  |
Then click eligibility to check TFN on eligibility page
    	|Eligiblity TFN	|<eligibilityTFN>|
Then enter zipcode to check TFn on ma vpp page
    	| MA VPP TFN |<maVppTfn>|
    	| Zip Code	 |<zipcode> |
    	Examples: 
    	    | zipcode | campaignTFN 	| maVppTfn  	  | eligibilityTFN |  url   |
    	    | 90210   | 1-877-495-2415	| 1-877-495-2415  | 1-877-495-2415 | https://www.aarpmedicareplans.com/medicare-education.html?WT.mc_id=8001277 |
	    
@Scenario6A  @Campaign_Precedence_Logic  @campaign 
Scenario Outline: -6.1 validating TFN from Home Page
Given user visits AMP using Direct URL and varify TFN
	|  URL   	| <url>  |
	| AMPTFN	|<ampTFN>|
Then coming from dircet url and navigate to medsup to varify TFN
	|MedSup TFN	|<medSupTFN>|
	Examples: 
	    	| ampTFN  	  	  | medSupTFN 		| url 								|
	    	| 1-877-699-5710  | 1-877-699-5710  | http://www.aarpmedicareplans.com/ |

@Scenario6B  @Campaign_Precedence_Logic  @tfn_aarp 
Scenario Outline: - 6.2 Google and search AARP Medicare Advantage Plan 
Given user is on Google and search AARP Medicare Advantage Plan to navigate to AMP page and varify TFN
	 |  URL     | <url>  |
	 | AMPTFN	|<ampTFN>|
Then navigate to MedSup to varify TFN from Google
	 |MedSup TFN	|<medSupTFN>|
	   Examples: 
	    	| ampTFN  	  	  | medSupTFN 		| url 					 |
	    	| 1-800-850-6807  | 1-866-327-1593  |https://www.google.com/ |

@Scenario6C  @Campaign_Precedence_Logic  @No_Longer_in_Excel_SOT
Scenario Outline: -6.3 Visit AMP using  amp url id 860002
Given user visits AMP using Direct URL and varify TFN
	   |  URL   | <url>  |
	   | AMPTFN	|<ampTFN>|
Then navigate to MedSup to varify TFN from specific url
	   |MedSup TFN	|<medSupTFN>|
	  Examples: 
	   	| ampTFN  	  	  | medSupTFN 		|  url |
	    | 1-877-610-2672  | 1-888-708-8922  |  http://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans?WT.mc_id=860002&zipcode=90210 |
	 
@Scenario6D  @Campaign_Precedence_Logic  @tfn_aarp
Scenario Outline: -6.4 Visit AMP using  amp url id 8001533
Given user visits AMP using Direct URL and varify TFN
		|  URL   | <url>  |
	    |AMPTFN	|<ampTFN>|
Then navigate to MedSup to varify TFN from specific url
	    |MedSup TFN	|<medSupTFN>| 
Then user is on Google and search AARP Medicare Advantage Plan to navigate to AMP page to view the same TFN  and varify 
		 |AMPTFN	|<ampTFN>|
Then navigate from google search to MedSup to varify TFN 
		 |MedSup TFN	|<medSupTFN>|
Then user visits AMP using  amp url and varify TFN without clearing cache
			|  URL   | <url1>  |
		    | AMPTFN	|<ampTFN>|
Then without clear cache navigate to MedSup  to varify TFN
		    |MedSup TFN	|<medSupTFN>|
Then user is on Google and search AARP Medicare Advantage Plan to navigate to AMP page to view the same TFN  and varify 
		   | AMPTFN	|<ampTFN>|
Then without clear cache navigate from google to MedSup  to varify TFN
		   |MedSup TFN	|<medSupTFN>|
Examples: 
 | ampTFN  	  	 | medSupTFN 	     | medSupTFN1 		| url                                                                                          |   url1                            |
 | 1-877-656-8358| 1-844-891-4867  | 1-877-656-8358 |http://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans?WT.mc_id=8001533 | http://www.aarpmedicareplans.com/ |


	 @Scenario6E  @Campaign_Precedence_Logic  @tfn_aarp
	 Scenario Outline: - 6.5  Google and search AARP Medicare Advantage Plan 
	 Given user is on Google and search AARP Medicare Advantage Plan to navigate to AMP page and varify TFN
	 	 |  URL     | <url>  |
	 	 | AMPTFN	|<ampTFN>|
	 Then navigate to MedSup to varify TFN from Google
	 	 |MedSup TFN	|<medSupTFN>|
	 	   Examples: 
	 	    	| ampTFN  	  	  | medSupTFN 		| url 					 |
	 	    	| 1-800-850-6807  | 1-866-327-1593  |https://www.google.com/ |
	   
@Scenario6F  @Campaign_Precedence_Logic  @tfn_aarp
Scenario Outline: - 6.6 Visit AMP using Direct URL after clearing cache and visit from google
Given user visits AMP using Direct URL and varify TFN
	  |  URL   | <url>  |
	  |AMPTFN	|<ampTFN>|
Then navigate to MedSup to varify TFN from direct url
	  |MedSup TFN	|<medSupTFN>|
Then user is on Google and navigate to  AMP page to view the same TFN  and varify
	  	   |AMPTFN Google	|<ampTFNGoogle>|
Then navigate to MedSup to varify TFN
	  	   |MedSup TFN	|<medSupTFNGoogle>|
	Examples: 
	   	    	| ampTFN  	  	  | medSupTFN 		  | url                               | ampTFNGoogle  	  	  | medSupTFNGoogle    | url1                   |
	   	    	| 1-877-699-5710  | 1-877-699-5710  | http://www.aarpmedicareplans.com/ | 1-800-850-6807        | 1-866-327-1593 	   |https://www.google.com/ |

	   	    	
@Scenario6G  @Campaign_Precedence_Logic  @campaign 
Scenario Outline: - 6.7 Yahoo and search AARP Medicare Advantage Plan 
Given user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AMP page and varify TFN
	   	     |  URL     | <url>  	 |
	   	     |AMPTFN	|<ampTFN>|
Then navigate to MedSup to varify TFN from Yahoo
	   	    |MedSup TFN	|<medSupTFN>|
	   	   Examples: 
	   	    	| ampTFN  	  	  | medSupTFN 		| url |
	   	    	| 1-800-850-8230  | 1-866-327-1593  |https://www.Yahoo.com/ |
	   	    		
@Scenario6H  @campaign
Scenario Outline: -6.8 Visit AMP using  amp url id 8001533
Given user visits AMP using  specific URL and varify TFN
	   	   |  URL   | <url1>  |
	   	   |AMPTFN	|<ampTFN>|
Then user will go to MedSup page to varify TFN
	   	   |MedSup TFN	|<medSupTFN>|
#Then close and reopen browser
Then visit amp using direct url
		|  URL   | <url2>  |
Then navigate to MedSup via direct url towards med sup to varify TFN
	   	|MedSup TFN	|<medSupTFN>|
Examples: 
	  | ampTFN  		| medSupTFN 		| url1 |    url2|
	  | 1-877-656-8358  | 1-844-891-4867  | http://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans?WT.mc_id=8001533 |  http://www.aarpmedicareplans.com/|


