@formsAndResources
@dashBoardFormsAndResources @gladiators 
Feature: G1.1 To validate forms and resources page in dashboard site


@formsAndResources1 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
 Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To verify quicklinks for a MAPD member
   	Given login with following details logins in the member portal and validate elements
   	  | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
	#And user naviagtes to Forms and Resources page
	
	And user clicks on the view document and resources link and navigate to forms and resource page
	| Plan Type   | <planType>   |
	| Member Type    | <memberType>    |
	Then user verifies presence of jump links on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |Count|<count>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
     
	#Membership material comes dynamically based on the logic
		
	Examples: 
      | TID     | planType | memberType |Identifier        | language |count|rider  |
      | 15108   | MAPD     | Individual |IndEffectiveAARP  | ENGLISH  | 7   |NoRider|
      | 15108   | MAPD     | Individual |IndEffectiveAARP  | ENGLISH  | 7   |Rider  |
      | 15303   | MAPD     | Group      |GrpEffectiveUHC   | ENGLISH  | 7   |NoRider|
      | 15108   | MAPD     | Individual |IndEffectiveUHC   | ENGLISH  | 6   |NoRider|
	  | 15108   | MAPD     | Individual |IndEffectiveUHC   | ENGLISH  | 6   |Rider  |
	  | 00000   | PCP      | Individual |IndEffectivePCP   | ENGLISH  | 6   |NoRider|
	  | 15128   | MEDICA   | Individual |IndEffectiveMedica| ENGLISH  | 6   |NoRider|
	  
	  
@formsAndResources2 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - Verify jump links for individual MA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
    Then user verifies presence of jump links on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
               
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
      
     And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |Count|<count>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
    
      
   Examples: 
      | TID      | planType | memberType  |Identifier        | language  |count |rider  |
      | 15130    | MA       | Group	      |GrpEffectiveUHC   | ENGLISH   | 6    |NoRider|
      | 00000    | MA       | Individual  |IndEffectiveUHC   | ENGLISH   | 6    |Rider  |
      | 00000    | MA       | Individual  |IndEffectiveAARP  | ENGLISH   | 7    |Rider  |
      | 00000    | MA       | Individual  |IndEffectiveAARP  | ENGLISH   | 7    |NoRider|
	   
@formsAndResources3 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -Verify jump links for a MedSupp member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
    Then user verifies presence of jump links on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
               
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
      
     And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |Count|<count>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
      
   Examples: 
      | TID    | planType | memberType | Identifier         | language |count|rider  |
      | 15304  | MedSupp  | Individual |EffectiveShipMedSupp| ENGLISH  | 3   |NoRider|

 @formsAndResources4 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - Verify jump links for individual PDP member
        Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
    Then user verifies presence of jump links on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
               
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
      
     And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |Count|<count>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
      
   Examples: 
      | TID    | planType | memberType |Identifier       | language |count|rider  |
   	  | 15126  | PDP      | Individual |EffectivePDPAARP | ENGLISH  | 8   |NoRider|
     # | 15127  | PDP      | Individual |EffectivePDPUHC  | ENGLISH  | 8   |NoRider|  # it was already hashtagged by Kamal
      | 15131  | PDP      | Group      |EffectivePDPUHC  | ENGLISH  | 7   |NoRider|
      
      
@formsAndResources5 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - Verify jump links for a SSUP member
      Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
    Then user verifies presence of jump links on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
               
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
      
     And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |Count|<count>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
      
   Examples: 
     | TID   | planType | memberType |Identifier      | language |count|rider  |
     | 15304 | SSUP     | Group      |GrpEffectiveSSUP| ENGLISH  | 4   |NoRider|


# Pre-Effective Federal Cases
@formsAndResources6 @pre-effectivefnrmapdaarpindividualvalidation @regressionMember 
Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD AARP Individual Pre-Effective
   	Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	And user clicks on the view document and resources link and navigate to forms and resource page
	| Plan Type   | <planType>   |
	| Member Type    | <memberType>    |
	And validates that PEEHIP logo is not displayed   
	And validates that plan material section is not displayed
	And validate that english is default language in the dropdown
	| Member Type | <memberType> |
	Then the member validate the correct Membership Materials section is coming
     | GETTING STARTED GUIDE    | <gettingstartedguide>     |
     | BENEFIT-HIGHLIGHT        | <benefithighlight>        |
     | COMPREHENSIVE FORMULARY  | <comprehensiveformulary>  |
     | Alternative Drug List 	| <alternativedruglist>     |
     | EVIDENCE OF COVERAGEMEM  | <evidenceofcoverage>      |
     | PASSPORT					| <passport>    			|
     | OVER THE COUNTER			| <overthecounter>    		|  
   	Then validate that annual directory section is displayed
     | Member Type | <memberType> |
    Then validate pdf's in annual directory section
     |Member Type|<memberType>|
     | ProviderDirectory     		  | <providerdirectory>    |
     | Vendor Information Sheet       | <vendorInformationsheet> |
     |Pharmacy Directory Information  |<pharmacydirectoryinformation>|
   	Then validate that My Document section is displayed
    And both Pharmacy and provider search links are displayed
    | PlanType |<planType>|
    Examples: 
     | TID   | planType | memberType           	  | language | gettingstartedguide   | benefithighlight   |  comprehensiveformulary|alternativedruglist   | evidenceofcoverage   |passport                             | overthecounter  			   | comprehensiveformularymem  | providerdirectory   | vendorInformationsheet    |pharmacydirectoryinformation  |
     | 15108 | MAPD     | IndAARPPre-EffectiveFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Comprehensive Formulary|Alternative Drug List | Evidence of Coverage |UnitedHealth Passport Program| OVER THE COUNTER ESSENTIALS   | Comprehensive Formulary    | Provider Directory  | Vendor Information Sheet          |Pharmacy Directory Information|

@formsAndResources7 @IndAARPMAPre-EffectiveFnR @regressionMember
Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MA AARP Individual Pre-Effective
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	And user clicks on the view document and resources link and navigate to forms and resource page
	| Plan Type   | <planType>   |
	| Member Type    | <memberType>    |
	And validates that PEEHIP logo is not displayed   
	And validates that plan material section is not displayed
	Then the member validate the correct Membership Materials section is coming
     | GETTING STARTED GUIDE    | <gettingstartedguide>     |
     | BENEFIT-HIGHLIGHT        | <benefithighlight>        |
     | EVIDENCE OF COVERAGEMEM  | <evidenceofcoverage>      |
     | PASSPORT					| <passport>    			|
     |linkHEALTH PRODUCTS BENEFIT|<linkhealthproductsbenefit>|
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
     Then validate pdf's in annual directory section
     |Member Type|<memberType>|
     | ProviderDirectory     		  | <providerdirectory>    |
     | Vendor Information Sheet       | <vendorInformationsheet> |
    Then validate that My Document section is displayed
    And the Pharmacy locator link is not displayed for MA
    And the Provider Search link is displayed for MA
   	| Member Type | <memberType> |
    Examples: 
      
    | TID   | planType | memberType           	    | language | gettingstartedguide   | benefithighlight   | evidenceofcoverage   |providerdirectory   | vendorInformationsheet    |passport      |linkhealthproductsbenefit|
    | 00000 | MA       | IndAARPMAPre-EffectiveFnR  | ENGLISH  | Getting Started Guide | Benefit Highlights |Evidence of Coverage  |Provider Directory  | Vendor Information Sheet 	|UnitedHealth Passport Program|linkHEALTH PRODUCTS BENEFIT|
     


@formsAndResources8 @fnrpdpaarpindividualvalidationPre-Effective  @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP AARP Individual Pre-Effective
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
    And validates that PEEHIP logo is not displayed
    Then validate pdf's in the welcome guide section
     | GETTING STARTED GUIDE    | <gettingstartedguide>     |
     | BENEFIT-HIGHLIGHT        | <benefithighlight>        |
     | COMPREHENSIVE FORMULARY  | <comprehensiveformulary>  |
     | Alternative Drug List 	| <alternativedruglist>     |
     | EVIDENCE OF COVERAGEMEM  | <evidenceofcoverage>      |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
   	And the user validates the language dropdown and selects new value in dropdown successfully
   	 | Language | <language> |
    Then validate that annual directory section is displayed
     |Member Type|<memberType>|
    Then validate pdf's in annual directory section
    |MemberType|<memberType>|
	 |Pharmacy Directory Information|<pharmacydirectoryinformation>|
	Then validate that My Document section is displayed
    And the provider search link is not displayed for PDP
    And the Pharmacy locator link is displayed
    | Member Type | <memberType> |
       
    Examples: 
      | TID   | planType | memberType 				  | language | benefithighlight   | gettingstartedguide   | benefithighlight   |comprehensiveformulary  |alternativedruglist  |evidenceofcoverage   |pharmacydirectoryinformation  |
      | 15126 | PDP      | IndAARPPre-EffectivePDPFnR | ENGLISH  | Benefit Highlights |Getting Started Guide  |Benefit Highlights  |Comprehensive Formulary |Alternative Drug List|Evidence Of Coverage |Pharmacy Directory Information|
 



#Effective Users
  @formsAndResources9 @fnrmapdaarpindividualvalidation  @regressionMember  
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD AARP Individual
   	Given login with following details in the member redesign portal
    	| Plan Type   | <planType>   |
     	| Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   # And validates that PEEHIP logo is not displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
     And then user verifies that the correct pdfs are coming in the plan material section
				      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
				      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
				      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
				      |UnitedHealth Passport Program|<unitedhealthpassportprogram>|
				      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
				      |Alternative Drug List    |<alternativedruglist>     |
				      | PRIOR AUTHORIZATION     | <priorauth>              |
				      | STEP THERAPY            | <steptherapy>            |
				      | FORMULARY ADDITIONS     | <formularyadd>           |
				      | FORMULARY DELETIONS     | <formularydel>           |
    # Then the member validate the correct Membership Materials section is coming
    #  | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
    #  | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
    Then validate that the AnocSection is displayed
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And both Pharmacy and provider search links are displayed
    | PlanType |<planType>|
    Then validate that My Document section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for MAPD
    Then validate pdf's in annual directory section
     |Member Type|<memberType>|
     | ProviderDirectory     		  | <providerdirectory>    |
     | Vendor Information Sheet       | <vendorInformationsheet> |
     |Pharmacy Directory Information  |<pharmacydirectoryinformation>|
     And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type|<memberType>|
      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |

    Examples: 
      | TID   | planType | memberType         | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |unitedhealthpassportprogram |alternativedruglist|providerdirectory   | vendorInformationsheet    |pharmacydirectoryinformation  |
      | 15108 | MAPD     | IndAARPPharmacyFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |UnitedHealth Passport Program |Alternative Drug List| Provider Directory  | Vendor Information Sheet          |Pharmacy Directory Information|

  @formsAndResources10 @fnrpdpuhcindividual  @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP UHC Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   # And validates that PEEHIP logo is not displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
   	And then user verifies that the correct pdfs are coming in the plan material section
	  | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
	  | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      |COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
      |Alternative Drug List    | <alternativedruglist>    |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
   Then the member validate the correct Membership Materials section is coming
      | GETTING STARTED GUIDE   | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      |Alternative Drug List    | <alternativedruglist>    |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
   Then validate that the anoc section is not displayed
   Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
    | Member Type | <memberType> |
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for PDP UHC
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type | <memberType> |
      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    Then validate pdf's in annual directory section
     |Member Type|<memberType>|
     |Pharmacy Directory Information  |<pharmacydirectoryinformation>|
     

    Examples: 
     | TID   | planType | memberType          | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |alternativedruglist|gettingstartedguide|pharmacydirectoryinformation|
     | 15127 | PDP      | PdpuhcindividualFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |Alternative Drug List|Getting Started Guide|Pharmacy Directory Information|

  @formsAndResources11 @fnrmapdgroupvalidation  @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   # And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
      		#Pdf's aren't coming
	And then user verifies that the correct pdfs are coming in the plan material section
      | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | CERTIFICATE OF COVERAGE           | <certificateofcoverage>  |
      #| FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
    # Membership Materials is based on continued plan flag & year logic. It appears when flage is true,displays only for a year from the day of enrollment.		
	#Then the member validate the correct Membership Materials section is coming
    # | GETTING STARTED GUIDE    | <gettingstartedguide>    |
    # | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    # | COMPREHENSIVE FORMULARY  | <comprehensiveformularymem> |
    # | ADDITIONAL DRUG COVERAGE | <additionaldrug> |
    # | EVIDENCE OF COVERAGEMEM     | <evidenceofcoveragemem>     |
    # | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
    Then validate that the anoc section is displayed for group
    Then validate that annual directory section is displayed
     | Member Type | <memberType> |
    Then validate that My Document section is displayed
    And the medical EOB link is displayed for MADP Group
    And the Drug EOB link is displayed for MAPD Group
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for uhc grp
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type | <memberType> |
      | ANNUAL NOTICE OF CHANGES     | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
      |CERTIFICATE OF COVERAGE       |  <certificateofcoverage>     |
      | COMPREHENSIVE FORMULARY  | <comprehensiveformularymem> |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldruganoc>         |
    And the provider search link is displayed
      | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
      | Member Type | <memberType> |

    Examples: 
      | TID   | planType | memberType           | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | certificateofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | certificateofcoverage   | anoc                     | evidenceofcoverageanoc | comprehensiveformularymem | additionaldruganoc       |   evidenceofcoveragemem   |
      | 15303 | MAPD     | GroupMAPDPharmacyFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Certificate of Coverage | Annual Notice of Changes | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage | Evidence Of Coverage |

  # |MAPD     | GroupPharmacyFnR  | SPANISH           |Beneficios Importantes |Resumen de Beneficios |Comprobante de Cobertura |Comprehensive Formulary-Spanish |
  
  
  @formsAndResources12 @fnrpdpaarpindividualvalidation @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP AARP Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
    #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language>     |
        # Then the member validate the correct Welcome Guide section is coming
    # | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    # | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #  | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    Then validate that the AnocSection is displayed
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
    | Member Type | <memberType> |
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for PDP
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | Alternative Drug List 	| <alternativedruglist>     |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
	And the user verifies that the correct pdfs are coming in the anoc section
	  |Member Type|<memberType>|
      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    Then validate pdf's in annual directory section
     |Member Type|<memberType>|
     |Pharmacy Directory Information  |<pharmacydirectoryinformation>|  
    Examples: 
      | TID   | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |alternativedruglist   |pharmacydirectoryinformation|
      | 15126 | PDP      | IndAARPFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |Alternative Drug List |Pharmacy Directory Information|

  @formsAndResources13 @fnrpdptexasgroupvalidation  @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP Texas group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   #And validates that PEEHIP logo is not displayed
    And validates the pdp texas logo
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
      #  Then the member validate the correct Membership Materials section is coming
  #    | GETTING STARTED GUIDE    | <gettingstartedguide>    |
  #    | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
   #   | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
   #   | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
   #   | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
   #   | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
    Then validate that the anoc section is displayed for group
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
    | Member Type | <memberType> |
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type | <memberType> |
      | ANNUAL NOTICE OF CHANGES     | <anoc>                      |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC  | <comprehensiveformularyanoc> |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldruganoc>         |
    And then user verifies that the correct pdfs are coming in the plan material section
     #| GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |  
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>     |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
     #| FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
 
      Examples:

      | TID   | planType | memberType             | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc | additionaldruganoc       |anoc        				   |
      | 15373 | PDP      | TexasRxPharmacyFnRPage | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage | Annual Notice of Changes |

  @formsAndResources14 @fnrpdpgroupvalidation  @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP UHC group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
    #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
     #| GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       | 
      | SUMMARY-OF-BENEFIT               | <summaryofbenefits>      |
      |CERTIFICATE 0F COVERAGE            |  <certificateofcoverage>  |
     #| EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
     #| FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
   # Then the member validate the correct Membership Materials section is coming
   #   | GETTING STARTED GUIDE    | <gettingstartedguide>    |
    #  | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    #  | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #  | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    #  | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
    Then validate that the anoc section is displayed for group
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type | <memberType> |
      | ANNUAL NOTICE OF CHANGES     | <anoc>                       |
      |CERTIFICATE 0F COVERAGE      |  <certificateofcoverage>  |
     #| EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC  | <comprehensiveformularyanoc> |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldruganoc>         |
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed
    And the provider search link is not displayed for PDP
    And the Pharmacy locator link is displayed
      | Member Type | <memberType> |
    

    Examples: 
     | TID   | planType | memberType  | language| gettingstartedguide | benefithighlight   |   evidenceofcoverage| certificateofcoverage| summaryofbenefits                   |   abridgedformulary   | comprehensiveformulary              | additionaldrug           | anoc |    evidenceofcoverageanoc|comprehensiveformularyanoc|additionaldruganoc|priorauth           | steptherapy  | formularyadd        | formularydel        |
     | 15131 | PDP      | UHCGroupFnR | ENGLISH |   Getting Started Guide   |Benefit Highlights |Evidence of Coverage |Certificate of Coverage | Summary of Benefits |Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage  | Annual Notice of Changes |Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage |Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions |

 
     
  @formsAndResources15 @fnrmaindividualvalidation  @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page  MA AARP Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   # And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
  #   Then the member validate the correct Membership Materials section is coming
  #    | GETTING STARTED GUIDE          | <gettingstartedguide>         |
  #    | BENEFIT-HIGHLIGHT              | <benefithighlight>            |
  #    | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
  #    | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
    Then validate that the AnocSection is displayed
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And the Provider Search link is displayed for MA
    | Member Type | <memberType> |
    Then validate that My Document section is displayed
    And the Drug EOB link is not displayed for MA
    And Medical EOB link is displayed for MA
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for MAPD
    And the Pharmacy locator link is not displayed for MA
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type | <memberType> |
      | ANNUAL NOTICE OF CHANGES  | <anoc>                   |
      | EVIDENCE OF COVERAGE ANOC | <evidenceofcoverageanoc> |
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT              | <benefithighlight>            | 
      | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
      | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
      | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
    Then validate pdf's in annual directory section
     |Member Type|<memberType>|
     | ProviderDirectory     		  | <providerdirectory>    |
     | Vendor Information Sheet       | <vendorInformationsheet> |

    Examples: 
    | TID   | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | unitedhealthpassportprogram   | anoc                     | evidenceofcoverageanoc |providerdirectory   | vendorInformationsheet    |
    | 15129 | MA       | AARPIndFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Annual Notice of Changes | Evidence Of Coverage   |Provider Directory  | Vendor Information Sheet        |

  @formsAndResources16 @fnralpeehipgroupvalidation  @regressionMember 
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page alpeehip group 
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   # And the user verifies the alpeehip logo
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
     # | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | CERTIFICATE OF COVERAGE           | <certificateofcoverage>  |
      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
    # |  DOCTOR FLYER                     | <doctorflyer>            |
    # |PROVIDER DIRECTORY INSERT          | <providerdirectoryinsert>|
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
    #Then the member validate the correct Membership Materials section is coming
    #  | GETTING STARTED GUIDE    | <gettingstartedguide>    |
    #  | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    #  | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #  | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    #  | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
    Then validate that the anoc section is displayed for group
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type | <memberType> |
      | ANNUAL NOTICE OF CHANGES     | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
      |CERTIFICATE OF COVERAGE       |  <certificateofcoverage>     |
      | COMPREHENSIVE FORMULARY      | <comprehensiveformularyanoc>  |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldrug>         |
    Then validate that My Document section is displayed
    And the medical EOB link is displayed for MADP Group
    And the Drug EOB link is displayed for MAPD Group
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for uhc grp
    And the provider search link is displayed
    | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
    | Member Type | <memberType> |
    

    Examples: 
      | TID   | planType     | memberType       | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | certificateofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | doctorflyer  | providerdirectoryinsert   | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc |additionaldrug            |anoc              | 
      | 15130 | MAPDALPeehip | GroupAlPeehipFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Doctor Flyer | Provider Directory Insert | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage |Annual Notice of Changes|  

  @formsAndResources17 @pcpfnrvalidation  @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for PCP
    Given login with following details in the member redesign portal
       | Plan Type   | <planType>   |
       | Member Type | <memberType> |
       |Type		 |<type>        |
       
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type | <memberType> |
   #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
   And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    Then validate that the anoc section is not displayed
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And both the Pharmacy locator & provider search links are displayed
    Then validate that My Document section is displayed
    Then validate that the EOB Section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed
    #Then the member validate the correct Membership Materials section is coming
      #| BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      # | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      #| EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | Alternative Drug List 	| <alternativedruglist>    |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    Then validate pdf's in annual directory section
     |Member Type|<memberType>|
     | ProviderDirectory     		  | <providerdirectory>    |
     | Vendor Information Sheet       | <vendorInformationsheet> |
     |Pharmacy Directory Information  |<pharmacydirectoryinformation>|  
    

    Examples: 
      | TID   | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        |type   |alternativedruglist   | providerdirectory   | vendorInformationsheet    |pharmacydirectoryinformation  |
      | 15128 | MAPD     | PCP        | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions |NON LIS|Alternative Drug List | Provider Directory  | Vendor Information Sheet          |Pharmacy Directory Information|

  # | MAPD     | PCPFnR | SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
 
 
 @formsAndResources18 @ssupfnrvalidation  @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for ssupFnr 
    Given login with following details in the member redesign portal
        |Type        |<type>        |
        | identifier | <Identifier> |
   And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
   # Then the member validate the correct Membership Materials section is coming
   #   | YOUR_PLAN_GETTING_STARTED | <yourplangettingstarted> |
   #   | SCHEDULE_OF_BENEFITS      | <scheduleofbenefits>     |
   ##   | CERTIFICATE_OF_COVERAGE   | <certificateofcoverage>  |
   #   | PRIVACY_NOTICE            | <privacynotice>          |
    Then validate that the anoc section is not displayed
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the EOB section and both the type of Eobs are not displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed
    #And then user verifies that the correct pdfs are coming in the plan material section
     # | SCHEDULE_OF_BENEFITS      | <scheduleofbenefits>     |
     # | CERTIFICATE_OF_COVERAGE   | <certificateofcoverage>  |
     # | YOUR_PLAN_GETTING_STARTED | <yourplangettingstarted> |
     # | PRIVACY_NOTICE            | <privacynotice>          |
     # | CDI_NOTICE                | <cdinotice>              |

    Examples: 
      | TID   | planType | memberType | language | scheduleofbenefits   | certificateofcoverage   | yourplangettingstarted    | privacynotice  | cdinotice       |Identifier|type|
      | 15304 | UHC      | SSUPFnR    | ENGLISH  | Schedule of Benefits | Certificate of Coverage | Your Plan Getting Started | Privacy Notice | CDI Long Notice |SSUP_DCE   |Group|

  #  | 00000   | MAPD     | PCPFnR |  #SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
  
  
  @formsAndResources19 @combovalidation  @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for combo members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   | 
    | Member Type    | <memberType>    |
   #And validates that PEEHIP logo is not displayed
    And user is on the forms and resources page for first plan tab
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And the user scrolls till the end of the page to check the forms and resources section
    And the user changes the plan tab to view the forms and resources page for second plan
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And the user scrolls till the end of the page to check the forms and resources section

    Examples: 
     | TID   | planType | memberType |
     | 15233 | Combo    | ComboFnR   |

  @formsAndResources20 @terminatedmembervalidation  @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for Terminated Members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   # And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And for terminated member order plan materials link is not displayed
    Then validate that the anoc section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the renew magazine section is not displayed
    Then validate that the annual directories section is not displayed
    Then validate that the EOB Section is displayed
   Examples: 
     | TID   | planType | memberType             |
      # uhc
     | 15129 | MA       | IndAARPMATerminatedFnR |

 
  @formsAndResources21 @shipscenario  @regressionMember
  Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details in the member redesign portal
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>   |
    | Member Type    | <memberType>    |
   # And validates that PEEHIP logo is not displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    | Member Type | <memberType> |
    Then validate that the plan material section is displayed
    | Member Type | <memberType> |
    And validate that english is default language in the dropdown
    | Member Type | <memberType> |
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed
   # Then the user verifies the pdfs for ship if particular pdf is not present
	#	| Member Type | <memberType> |
	#	| BENEFIT HIGHLIGHTS  |<benefitstable>    |
	#	| PLAN OVERVIEW | <planoverview>  |
	#	| OUTLINE OF COVERAGE    |<outlineofcoverage>|
	Examples: 
     | TID   | planType | memberType         | benefitstable  |planoverview  |outlineofcoverage   |
      # uhc
     | 15119 | SHIP     | IndPharmacyShipFnR | Benefits Table |Plan Overview |Outline of Coverage |

  
  @formsAndResources22 @memberauthfnrpagevalidation  @regressionMember 
  Scenario Outline:  TID: <TID> -Username: <username> - To validate the forms and resources page through Member auth.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user Clicks on the Pop up displayed and checks payment link
    #And user clicks on the view document and resources link and navigate to forms and resource page from member auth page
    #And validates that PEEHIP logo is not displayed
    #And validate for active member Temporary Id Card and Plan Order Material links are displayed
    #And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    #And validate that the view temporary id card link is displayed
    #Then validate that the plan material section is displayed
   	#Then validate that the AnocSection is displayed
    #Then validate that annual directory section is displayed
        Examples: 
     | TID   | username  | password  | member           |
     | 00000 | qavgogine | qavgogine | q2_jun_aarp0055  |
     
     
          
     @formsAndResources23 @pcpMedicaValidationOfProviderSearch  @regressionMember
  Scenario Outline: To validate the forms and resources page for PCP medica members Provider search link
    Given login with following details in the member redesign portal
       | Plan Type   | <planType>   |
       | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    | Plan Type   | <planType>|
     | Member Type | <memberType> |   
    And User clicks on Provider search link and checks if the find care page opens up
    
 
    Examples: 
       |planType | memberType | 
        |MAPD     | PCP        |
        #|MAPD     | MEDICA  |
        

 