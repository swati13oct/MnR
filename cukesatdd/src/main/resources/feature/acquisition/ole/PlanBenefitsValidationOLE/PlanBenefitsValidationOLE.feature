Feature: ACQ-OLE Welcome Page Plan benefits validation

  Scenario Outline: Verify plan benefits on the Welcome OLE Page for <site> provided OLE plans in Excel : <excelPath> and Sheet : <workSheet>
   
    Given the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>	    |

  @OLEplanBenefitsPDPAARP1 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | AARP |
   
   @OLEplanBenefitsPDPAARP2 @OLEBenefits
    Examples:
      | excelPath                	 | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | AARP |
    
    @OLEplanBenefitsPDPAARP3 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
  
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | AARP |

  @OLEplanBenefitsPDPUHC01 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | UHC |
  @OLEplanBenefitsUHCPDP02 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | UHC |
   
   @OLEplanBenefitsPDPUHC03 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | UHC |


  @OLEplanBenefitsMAAARP1 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_1  | AARP |
     
     @OLEplanBenefitsMAAARP2 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_2  | AARP |
   
    @OLEplanBenefitsMAAARP3 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_3  | AARP |
  
  @OLEplanBenefitsMAAARP4 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_4  | AARP |
    
    @OLEplanBenefitsMAAARP5 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_5  | AARP |
    
    @OLEplanBenefitsMAAARP6 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_6  | AARP |
   
   @OLEplanBenefitsMAAARP7 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_7  | AARP |
       
        @OLEplanBenefitsMAAARP8 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_8  | AARP |
    
    @OLEplanBenefitsMAAARP9 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_9  | AARP |
   
   @OLEplanBenefitsMAAARP10 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_10  | AARP |
    
    @OLEplanBenefitsMAAARP11 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_11 | AARP |
    
    @OLEplanBenefitsMAAARP12 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_12 | AARP |
     
     @OLEplanBenefitsMAAARP13 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_13  | AARP |

  	@OLEplanBenefitsMAUHC1 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_1  | UHC |
     
  	@OLEplanBenefitsMAUHC2 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_2  | UHC |
      
        	@OLEplanBenefitsMAUHC3 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_3  | UHC |
    
    @OLEplanBenefitsMAUHC4 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_4  | UHC |
    
    @OLEplanBenefitsMAUHC5 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_5  | UHC |
     
     @OLEplanBenefitsMAUHC6 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_6  | UHC |
     
     @OLEplanBenefitsMAUHC7 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_7  | UHC |
      
      @OLEplanBenefitsMAUHC8 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_8  | UHC |
        
        @OLEplanBenefitsMAUHC9 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_9  | UHC |
   
    @OLEplanBenefitsMAUHC10 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_10  | UHC |
        	
        	@OLEplanBenefitsMAUHC11 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_11 | UHC |
        	@OLEplanBenefitsMAUHC12 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_12 | UHC |
     
     @OLEplanBenefitsMAUHC13 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_13  | UHC |
 
  @OLEplanBenefitsSNPAARP1 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_1  | AARP |
   
   @OLEplanBenefitsSNPAARP2 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_2  | AARP |
  
   @OLEplanBenefitsSNPAARP3 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_3  | AARP |
   
    @OLEplanBenefitsSNPAARP4 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_4  | AARP |
      

  @OLEplanBenefitsSNPUHC1 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_1  | UHC |
   
   @OLEplanBenefitsSNPUHC2 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_2  | UHC |
    
    @OLEplanBenefitsSNPUHC3 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_3  | UHC |
      
     @OLEplanBenefitsSNPUHC4 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_4  | UHC |