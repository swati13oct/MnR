Feature: ACQ-OLE Welcome Page Plan benefits validation

  Scenario Outline: Verify plan benefits on the Welcome OLE Page for <site> provided OLE plans in Excel : <excelPath> and Sheet : <workSheet>
   
    Given the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>	    |


  @OLEplanBenefits_Failed_MA_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet2021_fail_TC  | AARP |

  @OLEplanBenefits_Failed_MA_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet2021_fail_TC  | UHC |


  @OLEplanBenefitsPDPAARP1 @OLEBenefits @OLEBenefits_PDP_1
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | AARP |
   
   @OLEplanBenefitsPDPAARP2 @OLEBenefits  @OLEBenefits_PDP
    Examples:
      | excelPath                	 | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | AARP |
    
    @OLEplanBenefitsPDPAARP3 @OLEBenefits @OLEBenefits_PDP
    Examples:
      | excelPath                | workSheet | site |
  
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | AARP |

  @OLEplanBenefitsPDPUHC01 @OLEBenefits @OLEBenefits_PDP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | UHC |
  @OLEplanBenefitsUHCPDP02 @OLEBenefits  @OLEBenefits_PDP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | UHC |
   
   @OLEplanBenefitsPDPUHC03 @OLEBenefits @OLEBenefits_PDP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | UHC |


  @OLEplanBenefitsMAAARP1 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_1  | AARP |
     
     @OLEplanBenefitsMAAARP2 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_2  | AARP |
   
    @OLEplanBenefitsMAAARP3 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_3  | AARP |
  
  @OLEplanBenefitsMAAARP4 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_4  | AARP |
    
    @OLEplanBenefitsMAAARP5 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_5  | AARP |
    
    @OLEplanBenefitsMAAARP6 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_6  | AARP |
   
   @OLEplanBenefitsMAAARP7 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_7  | AARP |
       
        @OLEplanBenefitsMAAARP8 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_8  | AARP |
    
    @OLEplanBenefitsMAAARP9 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_9  | AARP |
   
   @OLEplanBenefitsMAAARP10 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_10  | AARP |
    
    @OLEplanBenefitsMAAARP11 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_11 | AARP |
    
    @OLEplanBenefitsMAAARP12 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_12 | AARP |
     
     @OLEplanBenefitsMAAARP13 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_13  | AARP |

  	@OLEplanBenefitsMAUHC1 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_1  | UHC |
     
  	@OLEplanBenefitsMAUHC2 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_2  | UHC |
      
        	@OLEplanBenefitsMAUHC3 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_3  | UHC |
    
    @OLEplanBenefitsMAUHC4 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_4  | UHC |
    
    @OLEplanBenefitsMAUHC5 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_5  | UHC |
     
     @OLEplanBenefitsMAUHC6 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_6  | UHC |
     
     @OLEplanBenefitsMAUHC7 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_7  | UHC |
      
      @OLEplanBenefitsMAUHC8 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_8  | UHC |
        
        @OLEplanBenefitsMAUHC9 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_9  | UHC |
   
    @OLEplanBenefitsMAUHC10 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_10  | UHC |
        	
        	@OLEplanBenefitsMAUHC11 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_11 | UHC |
        	@OLEplanBenefitsMAUHC12 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_12 | UHC |
     
     @OLEplanBenefitsMAUHC13 @OLEBenefits @OLEBenefits_MA
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_13  | UHC |
 
  @OLEplanBenefitsSNPAARP1 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_14  | AARP |
   
   @OLEplanBenefitsSNPAARP2 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_15  | AARP |
  
   @OLEplanBenefitsSNPAARP3 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_16  | AARP |
   
    @OLEplanBenefitsSNPAARP4 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_17  | AARP |
      

  @OLEplanBenefitsSNPUHC1 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_14  | UHC |
   
   @OLEplanBenefitsSNPUHC2 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_15  | UHC |
    
    @OLEplanBenefitsSNPUHC3 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_16  | UHC |
      
     @OLEplanBenefitsSNPUHC4 @OLEBenefits @OLEBenefits_SNP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_17  | UHC |