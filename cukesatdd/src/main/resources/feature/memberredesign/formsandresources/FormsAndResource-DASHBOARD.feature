@dashBoardFormsAndResources @gladiators 
Feature: G1.1 To validate forms and resources page in dashboard site


@F&RJMPLinks @Feb_release_2019 @gladiators
Scenario Outline: To verify quicklinks for a MAPD member
   	Given login with following details logins in the member portal and validate elements
   	  | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
	#And user naviagtes to Forms and Resources page
	
	And user clicks on the view document and resources link and navigate to forms and resource page
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
      | planType | memberType |Identifier| language |count|rider|
      | MAPD     | Individual |IndEffectiveAARP| ENGLISH  | 7   |NoRider|
      | MAPD     | Individual |IndEffectiveAARP| ENGLISH  | 7   |Rider|
      | MAPD     | Group |GrpEffectiveUHC| ENGLISH  | 7   |NoRider|
      | MAPD     | Individual |IndEffectiveUHC| ENGLISH  | 6   |NoRider|
	  | MAPD     | Individual |IndEffectiveUHC| ENGLISH  | 6   |Rider|
	  | PCP     | Individual |IndEffectivePCP| ENGLISH  | 6   |NoRider|
	  | MEDICA     | Individual |IndEffectiveMedica| ENGLISH  | 6   |NoRider|
	  
	  
@F&RJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for individual MA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
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
      | planType | memberType |Identifier| language |count|rider|
      | MA       | Group	  |GrpEffectiveUHC| ENGLISH   | 6   |NoRider|
      | MA       | Individual |IndEffectiveUHC | ENGLISH  | 6   |Rider|
      | MA       | Individual |IndEffectiveAARP| ENGLISH  | 7   |Rider|
      | MA       | Individual |IndEffectiveAARP| ENGLISH  | 7   |NoRider|
	   
@F&RJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for a MedSupp member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
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
      | planType | memberType |Identifier| language |count|rider|
      | MedSupp  | Individual |EffectiveShipMedSupp| ENGLISH  | 3   |NoRider|

 @F&RJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for individual PDP member
        Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
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
      | planType | memberType |Identifier| language |count|rider|
   	  | PDP | Individual |EffectivePDPAARP| ENGLISH  | 8   |NoRider|
   #  | PDP | Individual |EffectivePDPUHC| ENGLISH  | 8   |NoRider|
      | PDP | Group |EffectivePDPUHC| ENGLISH  | 7   |NoRider|
      
      
@F&RJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for a SSUP member
      Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    And user clicks on the view document and resources link and navigate to forms and resource page
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
      | planType | memberType |Identifier| language |count|rider|
      | SSUP | Group |GrpEffectiveSSUP| ENGLISH  | 4   |NoRider|


# Pre-Effective Federal Cases
@pre-effectivefnrmapdaarpindividualvalidation @regressionMember
Scenario Outline: To validate the forms and resources page MAPD AARP Individual Pre-Effective
   	Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	And user clicks on the view document and resources link and navigate to forms and resource page
	And validates that PEEHIP logo is not displayed   
	And validates that plan material section is not displayed
	And validate that english is default language in the dro//*[@id="forms-and-resources-quickLinksParsys"]/div[1]/div[1]/div[2]/div/div[5]/div/div/div/div/ul/lipdown
	| Language | <language>     |
	Then the member validate the correct Membership Materials section is coming
     | GETTING STARTED GUIDE    | <gettingstartedguide>     |
     | BENEFIT-HIGHLIGHT        | <benefithighlight>        |
     | COMPREHENSIVE FORMULARY  | <comprehensiveformulary>  |
     | Alternative Drug List 	| <alternativedruglist>     |
     | EVIDENCE OF COVERAGEMEM  | <evidenceofcoverage>      |
     | PASSPORT					| <passport>    			|
    #| OVER THE COUNTER			| <overthecounter>    		|  # it is a link
   	Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    Then validate pdf's in annual directory section
     | ProviderDirectory     		  | <providerdirectory>    |
     | Vendor Information Sheet       | <vendorInformationsheet> |
     |Pharmacy Directory Information  |<pharmacydirectoryinformation>|
   	Then validate that My Document section is displayed
    And both Pharmacy and provider search links are displayed
    | PlanType |<planType>|
    Examples: 
      
    
     | planType | memberType           			  | language | gettingstartedguide   | benefithighlight   |  comprehensiveformulary|alternativedruglist   | evidenceofcoverage   |passport                             | overthecounter  			   | comprehensiveformularymem  | providerdirectory   | vendorInformationsheet    |pharmacydirectoryinformation  |
     | MAPD     | IndAARPPre-EffectiveFnR 		  | ENGLISH  | Getting Started Guide | Benefit Highlights | Comprehensive Formulary|Alternative Drug List | Evidence of Coverage |UnitedHealth Passport Program| OVER THE COUNTER ESSENTIALS   | Comprehensive Formulary    | Provider Directory  | Vendor Information Sheet          |Pharmacy Directory Information|

@IndAARPMAPre-EffectiveFnR @regressionMember
Scenario Outline: To validate the forms and resources page MA AARP Individual Pre-Effective
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	And user clicks on the view document and resources link and navigate to forms and resource page
	And validates that PEEHIP logo is not displayed   
	And validates that plan material section is not displayed
	Then the member validate the correct Membership Materials section is coming
     | GETTING STARTED GUIDE    | <gettingstartedguide>     |
     | BENEFIT-HIGHLIGHT        | <benefithighlight>        |
     | EVIDENCE OF COVERAGEMEM  | <evidenceofcoverage>      |
     | PASSPORT					| <passport>    			|
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
     Then validate pdf's in annual directory section
     | ProviderDirectory     		  | <providerdirectory>    |
     | Vendor Information Sheet       | <vendorInformationsheet> |
    Then validate that My Document section is displayed
    And the Pharmacy locator link is not displayed for MA
     And the Provider Search link is displayed for MA
   	| Member Type | <memberType> |
    Examples: 
      
     | planType | memberType           	    | language | gettingstartedguide   | benefithighlight   | evidenceofcoverage   |providerdirectory   | vendorInformationsheet    |passport      |
     | MA       | IndAARPMAPre-EffectiveFnR | ENGLISH  | Getting Started Guide | Benefit Highlights |Evidence of Coverage  |Provider Directory  | Vendor Information Sheet 	|UnitedHealth Passport Program|
     


@fnrpdpaarpindividualvalidationPre-Effective  @regressionMember
  Scenario Outline: To validate the forms and resources page PDP AARP Individual Pre-Effective
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And validates that PEEHIP logo is not displayed
    Then validate pdf's in the welcome guide section
     | GETTING STARTED GUIDE    | <gettingstartedguide>     |
     | BENEFIT-HIGHLIGHT        | <benefithighlight>        |
     | COMPREHENSIVE FORMULARY  | <comprehensiveformulary>  |
     | Alternative Drug List 	| <alternativedruglist>     |
     | EVIDENCE OF COVERAGEMEM  | <evidenceofcoverage>      |
    And validate that english is default language in the dropdown
    | Language | <language>     |
   	And the user validates the language dropdown and selects new value in dropdown successfully
   	 | Language | <language> |
    Then validate that annual directory section is displayed
     | MemberType | <memberType> |
    Then validate pdf's in annual directory section
	 |Pharmacy Directory Information|<pharmacydirectoryinformation>|
	Then validate that My Document section is displayed
    And the provider search link is not displayed for PDP
    And the Pharmacy locator link is displayed
       
    Examples: 
      | planType | memberType 				  | language | benefithighlight   | gettingstartedguide   | benefithighlight   |comprehensiveformulary  |alternativedruglist  |evidenceofcoverage   |pharmacydirectoryinformation  |
      | PDP      | IndAARPPre-EffectivePDPFnR | ENGLISH  | Benefit Highlights |Getting Started Guide  |Benefit Highlights  |Comprehensive Formulary |Alternative Drug List|Evidence Of Coverage |Pharmacy Directory Information|




#Effective Users
  @fnrmapdaarpindividualvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page MAPD AARP Individual
   	Given login with following details in the member redesign portal
    	| Plan Type   | <planType>   |
     	| Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   # And validates that PEEHIP logo is not displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    Then validate that the plan material section is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
      		# No pdf's coming 
			#	    And then user verifies that the correct pdfs are coming in the plan material section
			#	      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
			#	      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
			#	      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
			#	      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
			#	      | PRIOR AUTHORIZATION     | <priorauth>              |
			#	      | STEP THERAPY            | <steptherapy>            |
			#	      | FORMULARY ADDITIONS     | <formularyadd>           |
			#	      | FORMULARY DELETIONS     | <formularydel>           |
    # Then the member validate the correct Membership Materials section is coming
    #  | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
    #  | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
    Then validate that the AnocSection is displayed
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    		# No pdf's coming 
			#    And the user verifies that the correct pdfs are coming in the anoc section
			#      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
			#      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
			#      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    And both Pharmacy and provider search links are displayed
    | PlanType |<planType>|
    Then validate that My Document section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for MAPD

    Examples: 
      | planType | memberType         | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |
      | MAPD     | IndAARPPharmacyFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |

  @fnrpdpuhcindividual  @regressionMember
  Scenario Outline: To validate the forms and resources page PDP UHC Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   # And validates that PEEHIP logo is not displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    Then validate that the plan material section is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
        #  PDf's aren't coming anymore
		#    And then user verifies that the correct pdfs are coming in the plan material section
		#      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
		#      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
		#      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
		#      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
		#      | PRIOR AUTHORIZATION     | <priorauth>              |
		#      | STEP THERAPY            | <steptherapy>            |
		#      | FORMULARY ADDITIONS     | <formularyadd>           |
		#      | FORMULARY DELETIONS     | <formularydel>           |
   # Then the member validate the correct Membership Materials section is coming
   #   | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
   #   | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
   #   | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
    Then validate that the anoc section is not displayed
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for PDP UHC

    Examples: 
      | planType | memberType          | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |
      | PDP      | PdpuhcindividualFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |

  @fnrmapdgroupvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page MAPD group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   # And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
      		#Pdf's aren't coming
			    And then user verifies that the correct pdfs are coming in the plan material section
			      | GETTING STARTED GUIDE             | <gettingstartedguide>    |
			      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
			      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
			      | CERTIFICATE OF COVERAGE           | <certificateofcoverage>  |
			      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
			      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
			      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
			      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
     # | PRIOR AUTHORIZATION               | <priorauth>              |
     # | STEP THERAPY                      | <steptherapy>            |
     # | FORMULARY ADDITIONS               | <formularyadd>           |
     # | FORMULARY DELETIONS               | <formularydel>           |
     		
			    Then the member validate the correct Membership Materials section is coming
			     | GETTING STARTED GUIDE    | <gettingstartedguide>    |
			     | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
			     | COMPREHENSIVE FORMULARY  | <comprehensiveformularymem> |
			     | ADDITIONAL DRUG COVERAGE | <additionaldrug> |
			     | EVIDENCE OF COVERAGEMEM     | <evidenceofcoveragemem>     |
			     | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
    Then validate that the anoc section is displayed for group
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    		
    Then validate that My Document section is displayed
    And the medical EOB link is displayed for MADP Group
    And the Drug EOB link is displayed for MAPD Group
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for uhc grp
    #    Pdf's aren't coming
			    And the user verifies that the correct pdfs are coming in the anoc section
			      | ANNUAL NOTICE OF CHANGES     | <anoc>                       |
			      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
			      |CERTIFICATE OF COVERAGE       |  <certificateofcoverage>     |
			      | COMPREHENSIVE FORMULARY  | <comprehensiveformularymem> |
			      | ADDITIONAL DRUG COVERAGEANOC | <additionaldruganoc>         |
    And the provider search link is displayed
    And the Pharmacy locator link is displayed
    

    Examples: 
      | planType | memberType           | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | certificateofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | certificateofcoverage   | anoc                     | evidenceofcoverageanoc | comprehensiveformularymem | additionaldruganoc       |   evidenceofcoveragemem   |
      | MAPD     | GroupMAPDPharmacyFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Certificate of Coverage | Annual Notice of Changes | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage | Evidence Of Coverage |

  # |MAPD     | GroupPharmacyFnR  | SPANISH           |Beneficios Importantes |Resumen de Beneficios |Comprobante de Cobertura |Comprehensive Formulary-Spanish |
  @fnrpdpaarpindividualvalidation @regressionMember
  Scenario Outline: To validate the forms and resources page AARP Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
        # Then the member validate the correct Welcome Guide section is coming
    # | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    # | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #  | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    Then validate that the AnocSection is displayed
    Then validate that annual directory section is displayed
    | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for PDP
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
	And the user verifies that the correct pdfs are coming in the anoc section
      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    Examples: 
      | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |
      | PDP      | IndAARPFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |

  @fnrpdptexasgroupvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page Texas group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   #And validates that PEEHIP logo is not displayed
    And validates the pdp texas logo
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
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
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed
    And the user verifies that the correct pdfs are coming in the anoc section
      #| ANNUAL NOTICE OF CHANGES     | <anoc>                      |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC  | <comprehensiveformularyanoc> |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldruganoc>         |
    And then user verifies that the correct pdfs are coming in the plan material section
      | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |  
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>     |
      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
     #| PRIOR AUTHORIZATION               | <priorauth>              |
     #| STEP THERAPY                      | <steptherapy>            |
     #| FORMULARY ADDITIONS               | <formularyadd>           |
     #| FORMULARY DELETIONS               | <formularydel>           |
 
      Examples:

      | planType | memberType         | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc | additionaldruganoc       |  |
      | PDP      | TexasRxPharmacyFnRPage | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage |  |

  @fnrpdpgroupvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page UHC group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
      | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       | 
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      |CERTIFICATE 0F COVERAGE            |  <certificateofcoverage>  |
      | SUMMARY-OF-BENEFIT               | <summaryofbenefits>      |
      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
     # | PRIOR AUTHORIZATION               | <priorauth>              |
     # | STEP THERAPY                      | <steptherapy>            |
     # | FORMULARY ADDITIONS               | <formularyadd>           |
     # | FORMULARY DELETIONS               | <formularydel>           |
   # Then the member validate the correct Membership Materials section is coming
   #   | GETTING STARTED GUIDE    | <gettingstartedguide>    |
    #  | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    #  | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #  | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    #  | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
    Then validate that the anoc section is displayed for group
    And the user verifies that the correct pdfs are coming in the anoc section
      | ANNUAL NOTICE OF CHANGES     | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
       |CERTIFICATE 0F COVERAGE      |  <certificateofcoverage>  |
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
    

    Examples: 
      | planType | memberType  | language| gettingstartedguide | benefithighlight   |   evidenceofcoverage| certificateofcoverage| summaryofbenefits                   |   abridgedformulary   | comprehensiveformulary              | additionaldrug           | anoc |    evidenceofcoverageanoc|comprehensiveformularyanoc|additionaldruganoc|
      | PDP      | UHCGroupFnR | ENGLISH |   Getting Started Guide   |Benefit Highlights |Evidence of Coverage |Certificate of Coverage | Summary of Benefits |Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage  | Annual Notice of Changes |Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage |  |

 
     
  @fnrmaindividualvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page  main Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   # And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
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
      | ANNUAL NOTICE OF CHANGES  | <anoc>                   |
      | EVIDENCE OF COVERAGE ANOC | <evidenceofcoverageanoc> |
    
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT              | <benefithighlight>            | 
      | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
      | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
      | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |

    Examples: 
      | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage         | unitedhealthpassportprogram   | anoc                     | evidenceofcoverageanoc |
      | MA       | AARPIndFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Annual Notice of Changes | Evidence Of Coverage   |

  @fnralpeehipgroupvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page alpeehip group 
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   # And the user verifies the alpeehip logo
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
      | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | CERTIFICATE OF COVERAGE           | <certificateofcoverage>  |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      |  DOCTOR FLYER                     | <doctorflyer>            |
      |PROVIDER DIRECTORY INSERT          | <providerdirectoryinsert>|
     # | PRIOR AUTHORIZATION               | <priorauth>              |
     # | STEP THERAPY                      | <steptherapy>            |
     # | FORMULARY ADDITIONS               | <formularyadd>           |
     # | FORMULARY DELETIONS               | <formularydel>           |
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
      #| ANNUAL NOTICE OF CHANGES     | <anoc>                       |
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
    And the Pharmacy locator link is displayed
    

    Examples: 
      | planType     | memberType       | language | gettingstartedguide       | benefithighlight   | summaryofbenefits   | evidenceofcoverage         | certificateofcoverage                        | abridgedformulary              | comprehensiveformulary              | additionaldrug           | doctorflyer  | providerdirectoryinsert   | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc |       anoc              | 
      | MAPDALPeehip | GroupAlPeehipFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Doctor Flyer | Provider Directory Insert | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary  | Additional Drug Coverage |Annual Notice of Changes|  

  @pcpfnrvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page for PCP
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
   # And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
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
    Then the member validate the correct Membership Materials section is coming
      #| BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      # | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      #| EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    

    Examples: 
      | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        |
      | MAPD     | PCPFnR     | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions |

  # | MAPD     | PCPFnR | SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
  @ssupfnrvalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page for ssupFnr 
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
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
    And then user verifies that the correct pdfs are coming in the plan material section
      | SCHEDULE_OF_BENEFITS      | <scheduleofbenefits>     |
      | CERTIFICATE_OF_COVERAGE   | <certificateofcoverage>  |
      | YOUR_PLAN_GETTING_STARTED | <yourplangettingstarted> |
      | PRIVACY_NOTICE            | <privacynotice>          |
      | CDI_NOTICE                | <cdinotice>              |

    Examples: 
      | planType | memberType | language | scheduleofbenefits   | certificateofcoverage   | yourplangettingstarted    | privacynotice  | cdinotice  |
      | UHC      | SSUPFnR    | ENGLISH  | Schedule of Benefits | Certificate of Coverage | Your Plan Getting Started | Privacy Notice | CDI Long Notice |

  #  | MAPD     | PCPFnR |  #SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
  @combovalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page for combo members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   #And validates that PEEHIP logo is not displayed
    And user is on the forms and resources page for first plan tab
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And the user scrolls till the end of the page to check the forms and resources section
    And the user changes the plan tab to view the forms and resources page for second plan
    Then validate that the plan material section is displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And the user scrolls till the end of the page to check the forms and resources section

    Examples: 
      | planType | memberType |
      | Combo    | ComboFnR   |

  @terminatedmembervalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page for Terminated Members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   # And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
    And for terminated member order plan materials link is not displayed
    Then validate that the anoc section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the renew magazine section is not displayed
    Then validate that the annual directories section is not displayed
    Then validate that the EOB Section is displayed
    
    

    Examples: 
      | planType | memberType      |
      # uhc
      | MA       | IndAARPMATerminatedFnR |

  @shipscenario  @regressionMember
  Scenario Outline: To validate the forms and resources page for SHIP members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
   # And validates that PEEHIP logo is not displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
    Then validate that the plan material section is displayed
    And validate that english is default language in the dropdown
    | Language | <language>     |
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed
    Then the user verifies the pdfs for ship if particular pdf is not present
    | BENEFIT HIGHLIGHTS  |<benefitstable>    |
    | PLAN OVERVIEW | <planoverview>  |
    | OUTLINE OF COVERAGE    |<outlineofcoverage>|

    Examples: 
      | planType | memberType     | benefitstable  |planoverview|outlineofcoverage |
      # uhc
      | SHIP   | IndPharmacyShipFnR | Benefits Table |Plan Overview |Outline of Coverage |

  @memberauthfnrpagevalidation  @regressionMember
  Scenario Outline: To validate the forms and resources page through Member auth.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And User Clicks on the Pop up displayed
    #And user clicks on the view document and resources link and navigate to forms and resource page from member auth page
    #And validates that PEEHIP logo is not displayed
    #And validate for active member Temporary Id Card and Plan Order Material links are displayed
    #And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    #And validate that the view temporary id card link is displayed
    #Then validate that the plan material section is displayed
   	#Then validate that the AnocSection is displayed
    #Then validate that annual directory section is displayed
        Examples: 
      | username  | password  | member           |
      | qavgogine | qavgogine | q2_jun_aarp0055   |   
      
     