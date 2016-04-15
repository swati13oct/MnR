/**
 * 
 */
package acceptancetests.atdd.data;

import acceptancetests.atdd.data.ulayer.Page;

/**
 * @author pjaising
 *
 */
public class CommonConstants {

	public static final String PROPERTY_FILE_LOCATION = "C:/portal/conf/mratdd/config.properties";

	public static final String UID = "uid";

	public static final String DB_URL = "DBUrl";

	public static final String DB_USERNAME = "DBUsername";

	public static final String DB_PASSWORD = "DBPassword";

	public static final String DB_SCHEMA = "DBSchema";

	public static final String LDAP_BASE = "ldapBase";

	public static final String LDAP_USER = "ldapBindUser";

	public static final String LDAP_PASSWORD = "ldapBindPassword";

	public static final String LDAP_URL = "ldapUrl";

	public static final String WEBDRIVER = "webDriver";

	public static final String DEVICE_NAME = "DeviceName";

	public static final String CHROME_DRIVER = "ChromeDriver";

	public static final String PLAN_BENEFITS_AND_COVERAGE = "planBenefitsAndCoverage";

	public static final String BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA = "planbenefitsandcoveragenonlisnotusother.json";

	public static final String BENEFITS_AND_COVERAGE_DIRECTORY = "/jsonresponse/member/ulayer/planbenefitsandcoverage/";

	public static final String ACCOUNT_HOME_PAGE_DATA = "myaccounthome.json"; // Group

	public static final String PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER = "/page-objects/member/ulayer/";

	public static final String PLAN_SUMMARY_PAGE_DATA = "plansummarypdp.json";
	
	

	public static final String PLAN_SUMMARY_DIRECTORY = "/jsonresponse/Member/ulayer/planSummary/";

	public static final String REGISTRATION_COMMON_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/registration/registrationcommon/";

	public static final String REGISTRATION_COMMON_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/registration/registrationcommon/";

	private static final String TERMINATED_ACCOUNT_DIRECTORY = "/jsonresponse/Member/ulayer/terminatedaccount/";

	private static final String MANAGE_DRUG_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/managedrug/";

	private static final String ADD_DRUG_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/adddrug/";

	private static final String DRUG_DOSAGE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/drugdosage/";

	private static final String LOW_COST_OPTIONS_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/lowcostoptions/";

	private static final String SELECT_PHARMACY_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/selectpharmacy/";

	public static final String CONTACT_US = "contactus";

	private static final String CONTACT_US_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/contactus/";

	public static final Page[] PAGES = {
			new Page(CommonConstants.GLOBAL, CommonConstants.GLOBAL_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME,
					CommonConstants.MY_ACCOUNT_HOME_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME_COMBO,
					CommonConstants.MY_ACCOUNT_HOME_COMBO_DIRECTORY),
			new Page(CommonConstants.PHR, CommonConstants.PHR_DIRECTORY),
			new Page(CommonConstants.COMMON, CommonConstants.COMMON_DIRECTORY),
			new Page(CommonConstants.PLAN_SUMMARY,
					CommonConstants.PLAN_SUMMARY_DIRECTORY),
			new Page(CommonConstants.PAYMENT_HISTORY,
					CommonConstants.PAYMENT_HISTORY_DIRECTORY),
			new Page(CommonConstants.ONE_TIME_PAYMENT_SUCCESS,
					CommonConstants.ONE_TIME_PAYMENT_DIRECTORY),
			new Page(CommonConstants.SET_UP_PAYMENT_SUCCESS,
					CommonConstants.SET_UP_PAYMENT_DIRECTORY),
			new Page(CommonConstants.FORMS_AND_RESOURCES,
					CommonConstants.FORMS_AND_RESOURCES_DIRECTORY),
			new Page(CommonConstants.ORDER_PLAN_MATERIALS,
					CommonConstants.ORDER_PLAN_MATERIALS_DIRECTORY),
			new Page(CommonConstants.PLAN_CONFIRMATION,
					CommonConstants.PLAN_CONFIRMATION_DIRECTORY),
			new Page(CommonConstants.REGISTRATION,
					CommonConstants.REGISTRATION_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN,
					CommonConstants.ADD_PLAN_DIRECTORY),
			new Page(CommonConstants.PHARMACY_RESULT,
					CommonConstants.PHARMACY_RESULT_DIRECTORY),
			new Page(CommonConstants.DRUG_COST_BENEFIT_SUMMARY,
					CommonConstants.DRUG_COST_BENEFIT_SUMMARY_DIRECTORY),
			new Page(
					CommonConstants.BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA,
					CommonConstants.BENEFITS_AND_COVERAGE_DIRECTORY),
			new Page(CommonConstants.DRUG_CLAIMS_SUMMARY,
					CommonConstants.DRUG_CLAIMS_SUMMARY_DIRECTORY),
			new Page(CommonConstants.DRUG_CLAIMS_DETAILS,
					CommonConstants.DRUG_CLAIMS_DETAILS_DIRECTORY),
			new Page(CommonConstants.MEDICAL_CLAIMS_SUMMARY,
					CommonConstants.MEDICAL_CLAIMS_SUMMARY_DIRECTORY),
			new Page(CommonConstants.MEDICAL_CLAIMS_DETAILS,
					CommonConstants.MEDICAL_CLAIMS_DETAILS_DIRECTORY),

			new Page(CommonConstants.MY_PROFILES,
					CommonConstants.MY_PROFILES_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES,
					CommonConstants.MY_PREFERENCES_DIRECTORY),
			new Page(CommonConstants.VIEW_DRUG_COST,
					CommonConstants.VIEW_DRUG_COST_ULAYER_DIRECTORY),
			new Page(CommonConstants.MEDICAL_EOB,
					CommonConstants.MEDICAL_EOB_DIRECTORY),
			new Page(CommonConstants.PRESCRIPTION_DRUG_EOB,
					CommonConstants.PRESCRIPTION_DRUG_EOB_DIRECTORY),
			new Page(CommonConstants.MANAGE_DRUG,
					CommonConstants.MANAGE_DRUG_ULAYER_DIRECTORY),
			new Page(CommonConstants.ADD_DRUG,
					CommonConstants.ADD_DRUG_ULAYER_DIRECTORY),
			new Page(CommonConstants.DRUG_DOSAGE,
					CommonConstants.DRUG_DOSAGE_ULAYER_DIRECTORY),
			new Page(CommonConstants.LOW_COST_OPTIONS,
					CommonConstants.LOW_COST_OPTIONS_ULAYER_DIRECTORY),
			new Page(CommonConstants.SELECT_PHARMACY,
					CommonConstants.SELECT_PHARMACY_ULAYER_DIRECTORY),
			new Page(CommonConstants.TERMINATED_ACCOUNT,
					CommonConstants.TERMINATED_ACCOUNT_DIRECTORY),
			new Page(CommonConstants.REGISTRATION_SUCCESS,
					CommonConstants.REGISTRATION_SUCCESS_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_BEFORE_UPDATE,
					CommonConstants.MY_PREF_BEFORE_UPDATE_ULAYER_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_AFTER_UPDATE,
					CommonConstants.MY_PREF_AFTER_UPDATE_ULAYER_DIRECTORY),
			new Page(CommonConstants.CONTACT_US,
					CommonConstants.CONTACT_US_ULAYER_DIRECTORY),
			new Page(CommonConstants.BENEFITS_SUMMARY,
					CommonConstants.BENEFITS_SUMMARY_DIRECTORY),
			new Page(CommonConstants.PLAN_COMPARE,
					CommonConstants.PLAN_COMPARE_ULAYER_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN_CONFIRMATION,
					CommonConstants.ADD_PLAN_CONFIRMATION_ULAYER_DIRECTORY)
					

	};

	public static final String BENEFITS_SUMMARY_DIRECTORY = "/jsonresponse/mobile/member/ulayer/benefits-summary/";

	public static final String BENEFITS_SUMMARY = "benefitssummary";

	public static final String GLOBAL_DIRECTORY = "/jsonresponse/member/ulayer/global/";

	public static final String GLOBAL = "global";

	public static final String DIRECTORY = "/src/main/resources/";

	public static final String MY_ACCOUNT_HOME_DIRECTORY = "/jsonresponse/member/ulayer/myaccounthome/";

	public static final String MY_ACCOUNT_HOME = "myaccounthome";

	public static final String MY_ACCOUNT_HOME_COMBO_DIRECTORY = "/jsonresponse/member/ulayer/myaccounthomecombo/";

	public static final String MY_ACCOUNT_HOME_COMBO = "myaccounthomecombo";

	public static final String PHR_FEDERAL_PAGE_DATA = "phrfederal.json";

	public static final String PHR_DIRECTORY = "/jsonresponse/member/ulayer/phr/";

	public static final String PHR = "phr";

	public static final String COMMON = "common";

	public static final String COMMON_DIRECTORY = "/jsonresponse/member/ulayer/common/";

	public static final String EXPECTED_DATA_MAP = "expectedDataMap";

	private static final String GLOBAL_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/global/";

	private static final String MY_ACCOUNT_HOME_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/myaccounthome/";

	private static final String COMMON_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/common/";

	private static final String PHR_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/phr/";

	private static final String PLAN_SUMMARY_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/plansummary/";

	public static final String PLAN_SUMMARY = "plansummary";

	private static final String FORMS_AND_RESOURCES_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/formsandresources/";

	private static final String BENEFITS_AND_COVERAGE_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/benefitsandcoverage/";

	private static final String PLAN_CONFIRMATION_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/registration/planconfirmation/";

	private static final String REGISTRATION_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/registration/registrationsuccess/";

	private static final String ADD_PLAN_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/addplan/";

	private static final String MY_ACCOUNT_HOME_COMBO_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/myaccounthomecombo/";

	private static final String PAYMENT_HISTORY_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/payment/paymenthistory/";

	private static final String ONE_TIME_PAYMENT_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/payment/onetimepaymentsuccess/";

	private static final String SET_UP_PAYMENT_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/payment/setuppaymentsuccess/";

	private static final String CLAIM_SUMMARY_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/claims/claimsummary/";

	private static final String CLAIM_DETAILS_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/claims/claimdetails/";

	private static final String MY_PROFILES_BEFORE_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/myprofiles/beforeupdate/";

	private static final String MY_PROFILES_AFTER_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/myprofiles/afterupdate/";

	private static final String MY_PREF_BEFORE_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/mypreferences/beforeupdate/";

	private static final String MY_PREF_AFTER_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/mypreferences/afterupdate/";

	private static final String MY_PREF_BEFORE_UPDATE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/profilesandpref/mypreferences/beforeupdate/";

	private static final String MY_PREF_AFTER_UPDATE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/profilesandpref/mypreferences/afterupdate/";

	private static final String DRUG_COST_BENEFIT_SUMMARY_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/drugcostbenefitsummary/";

	private static final String ORDER_PLAN_MATERIALS_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/orderplanmaterials/";

	private static final String PREFERENCES_COMMON_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/profilesandpref/mypreferences/preferencescommon/";

	private static final String PRESCRIPTION_DRUG_EOB_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/prescriptiondrugeob/";

	public static final String MY_PROFILES_BEFORE_UPDATE = "myprofilebeforeupdate";

	public static final String MY_PROFILES_AFTER_UPDATE = "myprofileafterupdate";

	public static final String MY_PREFERENCES_BEFORE_UPDATE = "mypreferencesbeforeupdate";

	public static final String MY_PREFERENCES_AFTER_UPDATE = "mypreferencesafterupdate";

	public static final String PREFERENCES_COMMON = "preferenceColumn";

	public static final Page[] PAGES_BLUELAYER = {
			new Page(CommonConstants.GLOBAL,
					CommonConstants.GLOBAL_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME,
					CommonConstants.MY_ACCOUNT_HOME_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.COMMON,
					CommonConstants.COMMON_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PHR,
					CommonConstants.PHR_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PLAN_SUMMARY,
					CommonConstants.PLAN_SUMMARY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.FORMS_AND_RESOURCES,
					CommonConstants.FORMS_AND_RESOURCES_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PLAN_BENEFITS_AND_COVERAGE,
					CommonConstants.BENEFITS_AND_COVERAGE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PHARMACY_RESULT,
					CommonConstants.PHARMACY_RESULT_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN,
					CommonConstants.ADD_PLAN_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME_COMBO,
					CommonConstants.MY_ACCOUNT_HOME_COMBO_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PAYMENT_HISTORY,
					CommonConstants.PAYMENT_HISTORY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ONE_TIME_PAYMENT_SUCCESS,
					CommonConstants.ONE_TIME_PAYMENT_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.SET_UP_PAYMENT_SUCCESS,
					CommonConstants.SET_UP_PAYMENT_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.CLAIM_SUMMARY,
					CommonConstants.CLAIM_SUMMARY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.CLAIM_DETAILS,
					CommonConstants.CLAIM_DETAILS_BLUELAYER_DIRECTORY),
			new Page(
					CommonConstants.MY_PROFILES_BEFORE_UPDATE,
					CommonConstants.MY_PROFILES_BEFORE_UPDATE_BLUELAYER_DIRECTORY),
			new Page(
					CommonConstants.MY_PROFILES_AFTER_UPDATE,
					CommonConstants.MY_PROFILES_AFTER_UPDATE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_BEFORE_UPDATE,
					CommonConstants.MY_PREF_BEFORE_UPDATE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_AFTER_UPDATE,
					CommonConstants.MY_PREF_AFTER_UPDATE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PREFERENCES_COMMON,
					CommonConstants.PREFERENCES_COMMON_BLUELAYER_DIRECTORY),
			new Page(
					CommonConstants.DRUG_COST_BENEFIT_SUMMARY,
					CommonConstants.DRUG_COST_BENEFIT_SUMMARY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ORDER_PLAN_MATERIALS,
					CommonConstants.ORDER_PLAN_MATERIALS_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.VIEW_DRUG_COST,
					CommonConstants.VIEW_DRUG_COST_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PRESCRIPTION_DRUG_EOB,
					CommonConstants.PRESCRIPTION_DRUG_EOB_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MANAGE_DRUG,
					CommonConstants.MANAGE_DRUG_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.ADD_DRUG,
					CommonConstants.ADD_DRUG_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.DRUG_DOSAGE,
					CommonConstants.DRUG_DOSAGE_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.LOW_COST_OPTIONS,
					CommonConstants.LOW_COST_OPTIONS_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.SELECT_PHARMACY,
					CommonConstants.SELECT_PHARMACY_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.REGISTRATION_SUCCESS,
					CommonConstants.REGISTRATION_SUCCESS_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN_CONFIRMATION,
					CommonConstants.ADD_PLAN_CONFIRMATION_BLUELAYER_DIRECTORY)
			};

	public static final String PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER = "/page-objects/member/bluelayer/";

	public static final String RETIREE_PAGE_OBJECT_DIRECTORY = "/page-objects/uhcretiree/acquisition/";

	public static final String REGISTRATION = "registrationsuccess";

	public static final String REGISTRATION_SUCCESS = "registrationsuccess";

	public static final String REGISTRATION_SUCCESS_DIRECTORY = "/jsonresponse/member/ulayer/registration/registrationsuccess/";

	public static final String REGISTRATION_DIRECTORY = "/jsonresponse/member/ulayer/registration/registrationsuccess/";

	public static final String REGISTRATION_SUCCESS_PAGE_DATA = "registrationsuccess.json";

	public static final String PLAN_CONFIRMATION = "planconfirmation";

	public static final String PLAN_CONFIRMATION_DIRECTORY = "/jsonresponse/member/ulayer/registration/planconfirmation/";

	public static final String PLAN_CONFIRMATION_PAGE_DATA = "planconfirmation.json";

	public static final String PAYMENT_HISTORY = "paymentHistory";

	public static final String PAYMENT_HISTORY_PAGE_DATA = "paymenthistory.json";

	public static final String PAYMENT_HISTORY_DIRECTORY = "/jsonresponse/Member/ulayer/payment/paymenthistory/";

	public static final String ONE_TIME_PAYMENT_SUCCESS = "onetimepaymentsuccess";

	public static final String ONE_TIME_PAYMENT_DIRECTORY = "/jsonresponse/Member/ulayer/payment/onetimepaymentsuccess/";

	public static final String ONE_PAYMENT_SUCCESS_PAGE_DATA = "onetimepaymentsuccess.json";

	public static final String FORMS_AND_RESOURCES = "formsandresources";

	public static final String FORMS_AND_RESOURCES_DIRECTORY = "/jsonresponse/Member/ulayer/formsandresources/";

	public static final String FORMS_AND_RESOURCES_PAGE_DATA = "formsandresources.json";

	public static final String ORDER_PLAN_MATERIALS = "orderplanmaterials";

	public static final String ORDER_PLAN_MATERIALS_DIRECTORY = "/jsonresponse/Member/ulayer/orderplanmaterials/";

	public static final String ORDER_PLAN_MATERIALS_PAGE_DATA = "orderplanmaterials.json";

	public static final String SET_UP_PAYMENT_SUCCESS = "setuppaymentsuccess";

	public static final String SET_UP_PAYMENT_DIRECTORY = "/jsonresponse/Member/ulayer/payment/setuppaymentsuccess/";

	public static final String SET_UP_PAYMENT_SUCCESS_PAGE_DATA = "setuppaymentsuccess.json";

	public static final String PHARMACY_RESULT = "pharmacyresult";

	public static final String PHARMACY_RESULT_PAGE_DATA = "pharmacyresult.json";

	public static final String PHARMACY_RESULT_DIRECTORY = "/jsonresponse/member/ulayer/locatepharmacy/";

	public static final String PHARMACY_RESULT_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/locatepharmacy/";

	public static final String REGISTRATION_COMMON = "registrationCommon";

	public static final String ADD_PLAN = "addplan";

	public static final String ADD_PLAN_DIRECTORY = "/jsonresponse/member/ulayer/addplan/";

	public static final String DRUG_COST_BENEFIT_SUMMARY = "drugcostbenefitsummary";

	public static final String DRUG_COST_BENEFIT_SUMMARY_SUCCESS = "drugcostbenefitsummary";

	public static final String DRUG_COST_BENEFIT_SUMMARY_DIRECTORY = "/jsonresponse/Member/ulayer/drugcostbenefitsummary/";

	public static final String DRUG_COST_BENEFIT_SUMMARY_PAGE_DATA = "drugcostbenefitsummary.json";

	public static final String ACCOUNT_HOME_PAGE_INDIVIDUAL_DATA = "myaccounthomeindividual.json";

	public static final String CLAIM_SUMMARY_PAGE_DATA = "claimsummary.json";

	public static final String CLAIM_SUMMARY = "claimsummary";

	public static final String MEDICAL_CLAIM_DETAILS_PAGE_DATA = "medicalclaimdetails.json";

	public static final String CLAIM_DETAILS = "claimdetails";

	public static final String VPP_PLAN_SUMMARY_PAGE_DATA = "vppplansummary.json";

	public static final String PAGE_OBJECT_DIRECTORY_ULAYER_ACQ = "/page-objects/acquisition/ulayer/";

	public static final String SITE_ULAYER = "ulayer";

	public static final String SITE_BLUELAYER = "bluelayer";

	public static final String SITE_UHCRETIREE = "uhcretiree";

	public static final String ACQUISITION_EXPECTED_DIRECTORY = "/jsonresponse/acquisition";
	
	public static final String DRX_EXPECTED_DIRECTORY = "/jsonresponse/drx";

	public static final String DRUG_CLAIMS_SUMMARY = "drugclaimsummary";

	public static final String DRUG_CLAIMS_SUMMARY_DIRECTORY = "/jsonresponse/member/ulayer/claims/drugclaimsummary/";

	public static final String DRUG_CLAIMS_SUMMARY_PAGE_DATA = "drugclaimsummary.json";

	public static final String DRUG_CLAIMS_DETAILS = "drugclaimdetails";

	public static final String DRUG_CLAIMS_DETAILS_DIRECTORY = "/jsonresponse/Member/ulayer/claims/drugclaimdetails/";

	public static final String DRUG_CLAIMS_DETAILS_PAGE_DATA = "drugclaimdetails.json";

	public static final String MEDICAL_CLAIMS_SUMMARY = "medicalclaimsummary";

	public static final String MEDICAL_CLAIMS_SUMMARY_DIRECTORY = "/jsonresponse/member/ulayer/claims/medicalclaimsummary/";

	public static final String MEDICAL_CLAIMS_SUMMARY_PAGE_DATA = "medicalclaimsummary.json";

	public static final String MEDICAL_CLAIMS_DETAILS = "medicalclaimdetails";

	public static final String MEDICAL_CLAIMS_DETAILS_DIRECTORY = "/jsonresponse/Member/ulayer/claims/medicalclaimdetails/";

	public static final String MEDICAL_CLAIMS_DETAILS_PAGE_DATA = "medicalclaimdetails.json";

	public static final String PLAN_CATEGORY = "planCategory";

	public static final String CLAIM_SUMMARY_INDIVIDUAL_PAGE_DATA = "claimsummaryindividual.json";

	public static final String DRUG_CLAIM_DETAILS_INDIVIDUAL_PAGE_DATA = "drugclaimdetailsindividual.json";

	public static final String DRUG_CLAIM_DETAILS_PAGE_DATA = "drugClaimDetails.json";

	public static final String PLAN_TYPE = "planType";

	public static final String MY_PROFILES = "myprofiles";

	public static final String MY_PROFILES_DIRECTORY = "/jsonresponse/Member/ulayer/profilesandprefereneces/myprofiles/";

	public static final String MY_PROFILES_PAGE_DATA = "myprofiles.json";

	public static final String MY_PREFERENCES = "mypreferences";

	public static final String MY_PREFERENCES_DIRECTORY = "/jsonresponse/Member/ulayer/profilesandprefereneces/mypreferences/";

	public static final String MY_PREFERENCES_PAGE_DATA = "mypreferences.json";

	public static final String VIEW_DRUG_COST_ULAYER_DIRECTORY = "/jsonresponse/Member/ulayer/druglookup/viewdrugcost/";

	public static final String VIEW_DRUG_COST_PDP_PAGE_DATA = "viewdrugcostpdp.json";

	public static final String VIEW_DRUG_COST_MAPD_PAGE_DATA = "viewdrugcostmapd.json";

	public static final String VIEW_DRUG_COST_PAGE_DATA = "viewdrugcost.json";

	public static final String MEDICAL_EOB = "medicaleob";

	public static final String MEDICAL_EOB_DIRECTORY = "/jsonresponse/Member/ulayer/eob/medical/";

	public static final String MEDICAL_EOB_PAGE_DATA = "medicaleob.json";

	public static final String PRESCRIPTION_DRUG_EOB_DIRECTORY = "/jsonresponse/Member/ulayer/eob/drug/";

	public static final String DRUG_LOOK_UP = "druglookup";

	public static final String DRUG_LOOK_UP_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/druglookup/";

	public static final String DRUG_LOOK_UP_PAGE_DATA = "druglookup.json";

	public static final String DRUG_LIST = "druglist";

	public static final String DRUG_LIST_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/druglist/";

	public static final String SELECT_GENERIC_PAGE_DATA = "selectgeneric.json";

	public static final String DRUG_DOSAGE = "drugdosage";

	public static final String DRUG_DOSAGE_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/drugdosage/";

	public static final String DRUG_DOSAGE_PAGE_DATA = "drugdosage.json";

	public static final String ADD_DRUG = "adddrug";

	public static final String ADD_DRUG_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/adddrug/";

	public static final String ADD_DRUG_PAGE_DATA = "adddrug.json";
	
	public static final String DRUG_SEARCH_PAGE_DATA = "searchdrug.json";

	public static final String LOW_COST_OPTIONS = "lowcostoptions";

	public static final String LOW_COST_OPTIONS_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/lowcostoptions/";

	public static final String LOW_COST_OPTIONS_PAGE_DATA = "lowcostoptions.json";

	public static final Page[] PAGES_REGISTRATION_BLUELAYER = {
		new Page(CommonConstants.PLAN_CONFIRMATION,
				CommonConstants.PLAN_CONFIRMATION_BLUELAYER_DIRECTORY),
		new Page(CommonConstants.REGISTRATION_COMMON,
				CommonConstants.REGISTRATION_COMMON_BLUELAYER_DIRECTORY) };

	public static final Page[] PAGES_REGISTRATION_ULAYER = {
			new Page(CommonConstants.PLAN_CONFIRMATION,
					CommonConstants.PLAN_CONFIRMATION_DIRECTORY),
			new Page(CommonConstants.REGISTRATION_COMMON,
					CommonConstants.REGISTRATION_COMMON_ULAYER_DIRECTORY) };

	public static final String PRESCRIPTION_DRUG_EOB_PAGE_DATA = "prescriptiondrugeob.json";

	public static final String PRESCRIPTION_DRUG_EOB = "prescriptionDrugEob";

	public static final String TERMINATED_ACCOUNT_PAGE_DATA = "terminatedaccount.json";

	public static final String TERMINATED_ACCOUNT = "terminatedAccount";

	public static final String PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ = "/page-objects/acquisition/bluelayer/";
	
	public static final String PAGE_OBJECT_DIRECTORY_DRX = "/page-objects/drx/";

	public static final String PHR_SHIP_PAGE_DATA = "phrship.json";

	public static final String PHR_PAGE_DATA = "phr.json";

	public static final String MANAGE_DRUG = "manageDrug";

	public static final String MANAGE_DRUG_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/managedrug/";

	public static final String MANAGE_DRUG_BLUE_LAYER_PAGE_DATA = "managedrug.json";

	public static final String MANAGE_DRUG_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "managedrugindividual.json";

	public static final String ADD_DRUG_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/adddrug/";

	public static final String ADD_DRUG_BLUE_LAYER_PAGE_DATA = "adddrug.json";

	public static final String ADD_DRUG_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "adddrugindividual.json";

	public static final String DRUG_DOSAGE_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/drugdosage/";

	public static final String DRUG_DOSAGE_BLUE_LAYER_PAGE_DATA = "drugdosage.json";

	public static final String DRUG_DOSAGE_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "drugdosageindividual.json";

	public static final String LOW_COST_OPTIONS_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/lowcostoptions/";

	public static final String LOW_COST_OPTIONS_BLUE_LAYER_PAGE_DATA = "lowcostoptions.json";

	public static final String LOW_COST_OPTIONS_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "lowcostoptionsindividual.json";

	public static final String SELECT_PHARMACY = "selectpharmacy";

	public static final String SELECT_PHARMACY_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/selectpharmacy/";

	public static final String SELECT_PHARMACY_BLUE_LAYER_PAGE_DATA = "selectpharmacy.json";

	public static final String SELECT_PHARMACY_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "selectpharmacyindividual.json";

	public static final String VIEW_DRUG_COST = "viewdrugCost";

	private static final String VIEW_DRUG_COST_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/viewdrugcost/";

	public static final String VIEW_DRUG_COST_BLUE_LAYER_PAGE_DATA = "viewdrugcost.json";
	
	public static final String PLAN_SELECTOR_PAGE_DATA = "planselector.json";

	public static final String VIEW_DRUG_COST_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "viewdrugcostindividual.json";

	public static final String GROUP = "Group";

	public static final String LEARN_ABOUT_PLAN_PAGE_DATA = "learnaboutmedicare.json";

	public static final String INITIAL_ENROLL_PAGE_DATA = "initialenroll.json";
	
	public static final String MANAGE_DRUG_ULAYER_PAGE_DATA = "manageDrug.json";

	public static final String ADD_DRUG_ULAYER_PAGE_DATA = "adddrug.json";

	public static final String SELECT_PHARMACY_ULAYER_PAGE_DATA = "selectpharmacy.json";

	public static final String CATEGORY = "category";

	public static final String INDIVIDUAL = "Individual";

	public static final String ADD_PLAN_CONFIRMATION = "addplanconfirmation";

	private static final String ADD_PLAN_CONFIRMATION_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/registration/addplanconfirmation/";

	public static final String ADD_PLAN_CONFIRMATION_PAGE_DATA = "addplanconfirmation.json";

	public static final String ZIPCODE_SELECTION_PAGE_DATA = "zipselection.json";

	public static final String ZIPCODE_SELECTION_HOME_PAGE_DATA = "zipselectionhome.json";
	
	public static final long TIMEOUT_30 = 30;

	public static final long TIMEOUT_40 = 40;

	public static final String SELECTED_DRUG_INFORMATION_PAGE_DATA = "selectedDrugInformation.json";

	public static final String MANAGE_DRUG_PAGE_DATA = "managedrug.json";

	public static final String DRUG_LIST_PAGE_DATA = "druglist.json";

	public static final String SELECT_PHARMACIES_PAGE_DATA = "selectpharmacy.json";

	public static final String PHARMACY_INFORMATION_PAGE_DATA = "pharmacyInformation.json";

	public static final String GLOBAL_FOOTER_PAGE_DATA = "globalfooteractual.json";

	public static final String SITE_MAP_PAGE_DATA = "sitemap.json";

	public static final String ABOUT_US_PAGE_DATA = "aboutus.json";

	public static final String CONTACT_US_PAGE_DATA = "contactus.json";

	public static final String AGENTS_AND_BROKERS_PAGE_DATA = "agentsandbrokers.json";

	public static final String HOME_PAGE_DISCLAIMER_DATA = "viewalldisclaimer.json";

	public static final String GLOBAL_HEADER_PAGE_DATA = "globalheaderactual.json";

	public static final String ALREADY_PLAN_MEMBER_PAGE_DATA = "alreadyPlanMemberActual.json";

	public static final String HEADER_PAGE_DATA = "headeractual.json";

	public static final String ENROLL_PLAN_INFO_PAGE_DATA = "enrollinplan.json";

	public static final String MA_PLAN_INFORMATION_PAGE_DATA = "maplaninformation.json";

	public static final String PDP_PLAN_INFORMATION_PAGE_DATA = "pdpplaninformation.json";

	public static final String BENEFICIARY_INFORMATION_PAGE_DATA = "beneficiaryinformation.json";

	public static final String MA_ADDITIONAL_INFORMATION_PAGE_DATA = "maadditionalinformation.json";

	public static final String PDP_ADDITIONAL_INFORMATION_PAGE_DATA = "pdpadditionalinformation.json";

	public static final String MA_REVIEW_APPLICATION_PAGE_DATA = "mareviewapplication.json";

	public static final String PDP_REVIEW_APPLICATION_PAGE_DATA = "pdpreviewapplication.json";

	public static final String SUBMIT_APPLICATION_PAGE_DATA = "submitapplication.json";

	public static final String ENROLLMENT_CONFIRMATION_PAGE_DATA = "enrollmentconfirmation.json";

	public static final String LOGIN_ASSISTANCE_MESSAGE_PAGE_DATA = "loginassistancemessage.json";

	public static final String AGENT_CONFIRMATION_PAGE_DATA = "agentappointmentconfirmation.json";

	public static final String MA_VPP_PAGE_DATA = "maVpp.json";

	public static final String ENQUIRY_KIT_CONFIRMATION_PAGE_DATA = "enquirykitconfirm.json";

	public static final String HEALTH_AND_WELLNESS_PAGE_DATA = "healthandwellness.json";

	public static final String HEALTH_AND_WELLNESS = "healthandwellness";

	public static final String MEDICARE_EDUCATION_SECTION_DATA = "medicareEducationSectionActual.json";

	public static final String OUR_PLANS_NAV_PAGE_DATA = "ourPlansDropdownActual.json";

	public static final String HEALTH_AND_WELLNESS_DROPDOWN_DATA= "healthandwellnessdropdownactual.json";
	
	public static final String OUR_PLANS_DROPDOWN_DATA = "ourplansdropdownactual.json";

	private static final String HEALTH_AND_WELLNESS_DIRECTORY = "/jsonresponse/member/ulayer/healthandwellness/";

	public static final String PLAN_COMPARE_PAGE_DATA = "plancompare.json";

	public static final String PLAN_COMPARE = "plancompare";

	private static final String PLAN_COMPARE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/plancompare/";

	public static final String PROVIDER_SEARCH_PAGE_DATA = "providersearch.json";
	

	public static final String SELECT_FORMULARY_PAGE_DATA = "selectformulary.json";
	
	public static final String ENTER_DRUG_PAGE_DATA = "enterdrug.json";

	public static final String RETIREE_EXPECTED_DIRECTORY = "/jsonresponse/uhcretiree/acquisition/";	
	
	public static final String AUTO_DRUG_SEARCH_PAGE_DATA = "autocompletedrugsearch.json";

	private static final String ADD_PLAN_CONFIRMATION_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/registration/addplanconfirmation/";
	
	private static final String REGISTRATION_SUCCESS_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/registration/registrationsuccess/";


	public static final String SECOND_PLAN_INFO_BLUELAYER_PAGE_DATA = "secondplaninfo.json";	
	
}
