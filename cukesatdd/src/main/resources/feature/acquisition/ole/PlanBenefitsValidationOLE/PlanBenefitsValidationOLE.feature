@OLEBenefits
Feature: ACQ-Plan benefits validation

  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan OLE in Excel : <excelPath> and Sheet : <workSheet>
   # Given the user navigates to OLE plan summary page and compares benefits value from excel to UI and reports into excel

    Given the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>	    |

  @OLEplanBenefitsAARP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | AARP |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | AARP |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | AARP |

  @OLEplanBenefitsUHC01
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_1  | UHC |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_2  | UHC |
      | Plan Benefits_PDP_OLE_Data | OLEPDPSheet2021_3  | UHC |


  @OLEplanBenefitsMAAARP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_1  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_2  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_3  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_4  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_5  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_6  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_7  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_8  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_9  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_10  | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_11 | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_12 | AARP |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_13  | AARP |

  @OLEplanBenefitsMAUHC
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_1  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_2  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_3  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_4  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_5  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_6  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_7  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_8  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_9  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_10  | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_11 | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_12 | UHC |
      | Plan Benefits_MA_SNP_OLE | MASheet2021_13  | UHC |
  @OLEplanBenefitsSNPAARP
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_1  | AARP |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_2  | AARP |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_3  | AARP |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_4  | AARP |

  @OLEplanBenefitsSNPUHC
    Examples:
      | excelPath                | workSheet | site |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_1  | UHC |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_2  | UHC |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_3  | UHC |
      | Plan Benefits_MA_SNP_OLE | SNPSheet2021_4  | UHC |