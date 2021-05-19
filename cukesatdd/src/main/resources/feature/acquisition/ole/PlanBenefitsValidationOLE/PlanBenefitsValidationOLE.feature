Feature: ACQ-OLE Welcome Page Plan benefits validation

  Scenario Outline: Verify plan benefits on the Welcome OLE Page for <site> provided OLE plans in Excel : <excelPath> and Sheet : <workSheet>
   
    Given the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>	    |

  @OLEplanBenefitsAARP1 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | AARP |
   
   @OLEplanBenefitsAARP2 @OLEBenefits
    Examples:
      | excelPath                	 | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | AARP |
    
    @OLEplanBenefitsAARP3 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
  
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | AARP |

  @OLEplanBenefitsUHC01 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | UHC |
  @OLEplanBenefitsUHC02 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | UHC |
   
   @OLEplanBenefitsUHC03 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | UHC |


  @OLEplanBenefitsMAAARP4 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_1  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_2  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_3  | AARP |
  
  @OLEplanBenefitsMAAARP5 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_4  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_5  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_6  | AARP |
   
   @OLEplanBenefitsMAAARP6 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_7  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_8  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_9  | AARP |
   
   @OLEplanBenefitsMAAARP7 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_10  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_11 | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_12 | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_13  | AARP |

  	@OLEplanBenefitsMAUHC4 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_1  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_2  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_3  | UHC |
    
    @OLEplanBenefitsMAUHC5 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_4  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_5  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_6  | UHC |
     
     @OLEplanBenefitsMAUHC6 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_7  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_8  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_9  | UHC |
   
    @OLEplanBenefitsMAUHC7 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_10  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_11 | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_12 | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_13  | UHC |
 
  @OLEplanBenefitsSNPAARP8 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_1  | AARP |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_2  | AARP |
  
   @OLEplanBenefitsSNPAARP9 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_3  | AARP |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_4  | AARP |
      

  @OLEplanBenefitsSNPUHC8 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_1  | UHC |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_2  | UHC |
    
    @OLEplanBenefitsSNPUHC9 @OLEBenefits
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_3  | UHC |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_4  | UHC |