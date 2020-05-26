package pages.regression.planDocumentsAndResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import atdd.framework.MRScenario;

public class PlanDocApiResponse {

	protected boolean success;
	protected String errorCode;
	protected boolean anocCurrentYearFlag;
	protected boolean anocNextYearFlag;

	protected List<List<HashMap<String, Document>>> planMatlSecList; 
	protected List<List<HashMap<String, Document>>> memMatlSecList; 
	protected List<List<HashMap<String, Document>>> annNotChgDocSecList; 
	protected List<List<HashMap<String, Document>>> proPhmDirSecList; 

	protected List<HashMap<String, Document>> planMatl_en_curYr_docList;
	protected List<HashMap<String, Document>> planMatl_en_nxtYr_docList;

	protected List<HashMap<String, Document>> planMatl_es_curYr_docList;
	protected List<HashMap<String, Document>> planMatl_es_nxtYr_docList;

	protected List<HashMap<String, Document>> planMatl_zh_curYr_docList;
	protected List<HashMap<String, Document>> planMatl_zh_nxtYr_docList;

	protected List<HashMap<String, Document>> memMatl_en_curYr_docList;
	protected List<HashMap<String, Document>> memMatl_en_nxtYr_docList;

	protected List<HashMap<String, Document>> memMatl_es_curYr_docList;
	protected List<HashMap<String, Document>> memMatl_es_nxtYr_docList;

	protected List<HashMap<String, Document>> memMatl_zh_curYr_docList;
	protected List<HashMap<String, Document>> memMatl_zh_nxtYr_docList;

	protected List<HashMap<String, Document>> annNotChgDoc_en_curYr_docList;
	protected List<HashMap<String, Document>> annNotChgDoc_en_nxtYr_docList;

	protected List<HashMap<String, Document>> annNotChgDoc_es_curYr_docList;
	protected List<HashMap<String, Document>> annNotChgDoc_es_nxtYr_docList;

	protected List<HashMap<String, Document>> annNotChgDoc_zh_curYr_docList;
	protected List<HashMap<String, Document>> annNotChgDoc_zh_nxtYr_docList;

	protected List<HashMap<String, Document>> proPhmDir_en_curYr_docList;
	protected List<HashMap<String, Document>> proPhmDir_en_nxtYr_docList;

	protected List<HashMap<String, Document>> proPhmDir_es_curYr_docList;
	protected List<HashMap<String, Document>> proPhmDir_es_nxtYr_docList;

	protected List<HashMap<String, Document>> proPhmDir_zh_curYr_docList;
	protected List<HashMap<String, Document>> proPhmDir_zh_nxtYr_docList;

	String currentYear;
	String nextYear;


	public PlanDocApiResponse(String currentYear, String nextYear) {
		success=false;
		errorCode="";
		anocCurrentYearFlag=false;
		anocNextYearFlag=false;

		//note: each of these list will be a list of Hashmap for a language type doc section 
		//note: example:
		//note: For planMatl_en_curYr_docList
		//note:   It's a list of hashmap for plan material section for english docs for current year
		//note:   The detail of the doc (i.e. type, name, link, etc) will be stored as a document object
		//note:   <Benefit Highlights, docObj>
		//note:   <Comprehensive Formulary, docObj>
		this.planMatl_en_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.planMatl_en_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.planMatl_es_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.planMatl_es_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.planMatl_zh_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.planMatl_zh_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.memMatl_en_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.memMatl_en_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.memMatl_es_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.memMatl_es_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.memMatl_zh_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.memMatl_zh_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.annNotChgDoc_en_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.annNotChgDoc_en_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.annNotChgDoc_es_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.annNotChgDoc_es_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.annNotChgDoc_zh_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.annNotChgDoc_zh_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.proPhmDir_en_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.proPhmDir_en_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.proPhmDir_es_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.proPhmDir_es_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.proPhmDir_zh_curYr_docList=new ArrayList<HashMap<String, Document>>();
		this.proPhmDir_zh_nxtYr_docList=new ArrayList<HashMap<String, Document>>();

		this.planMatlSecList = new ArrayList<List<HashMap<String, Document>>>();
		this.memMatlSecList  = new ArrayList<List<HashMap<String, Document>>>();
		this.annNotChgDocSecList  = new ArrayList<List<HashMap<String, Document>>>();
		this.proPhmDirSecList = new ArrayList<List<HashMap<String, Document>>>();

		this.currentYear=currentYear;
		this.nextYear=nextYear;

	}

	/**
	 * Turn the API response into a hash map
	 * @param apiResponse
	 */
	public boolean buildDocListMap(HashMap<String, String> testInputInfoMap, String apiResponse) {
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		JSONParser parser = new JSONParser();
		JSONObject apiResponseJsobObj=null;
		try {
			apiResponseJsobObj = (JSONObject) parser.parse(apiResponse);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert target string into json object", false);
		}
		Assert.assertTrue("PROBLEM - apiResponseJsobObj should not be null", apiResponseJsobObj!=null);
		success = (Boolean) apiResponseJsobObj.get("success");
		errorCode = (String) apiResponseJsobObj.get("errorCode");
		anocCurrentYearFlag = (Boolean) apiResponseJsobObj.get("anocCurrentYearFlag");
		anocNextYearFlag = (Boolean) apiResponseJsobObj.get("anocNextYearFlag");

		if (!success) {
			System.out.println("Unable to get a successful API response");
			return success;
		}

		JSONArray docListArrayObj = (JSONArray) apiResponseJsobObj.get("docList");
		//Assert.assertTrue("PROBLEM - docListArrayObj is null", docListArrayObj!=null);
		if (docListArrayObj==null) {
			System.out.println("TEST - API docListArrayObj is null");
			return success;
		} 
		Assert.assertTrue("PROBLEM - docListArrayObj should not be null, may have trouble getting API response in this test run", docListArrayObj!=null);
		for (int i=0; i<docListArrayObj.size(); i++) {
			JSONObject eachObjDocListArray = (JSONObject) docListArrayObj.get(i);
			Document docObj=buildDocumentObj(eachObjDocListArray);

			HashMap<String, Document> docObjMap=new HashMap<String, Document>(); //Example: <Benefit Highlights, docObj>
			System.out.println("----------------");
			System.out.println("Figure out where to store this doc:");
			docObj.printDetail();
			//note: for current year
			System.out.println("****************    This doc is for year: "+docObj.getYear()+" | currentYear="+currentYear+" | nextYear="+nextYear+" | type="+docObj.getType());
			if (docObj.getYear().equals(currentYear)) {
				if (docObj.getType().equals("6002")) {
					String docCategory="Benefit Highlights";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("3")) {
					//tbd if (!memberType.contains("PREEFF")) {
						String docCategory="Summary of Benefits";
						//note: Conversation with Keri where Feb copy deck is not available yet
						//note: since PDP GROUP is showing the doc in Membership Materials, then use it as expected behavior
						docObjMap.put(docCategory, docObj);
						if (docObj.getLanguage().equals("en_us")) {
							planMatl_en_curYr_docList.add(docObjMap);
							if ((planType.equals("PDP") || planType.equals("MA") || planType.equals("MAPD"))&& memberType.contains("GROUP"))
								memMatl_en_curYr_docList.add(docObjMap);
						} else if (docObj.getLanguage().equals("es")) {
							planMatl_es_curYr_docList.add(docObjMap);
							if ((planType.equals("PDP") || planType.equals("MA") || planType.equals("MAPD"))&& memberType.contains("GROUP"))
								memMatl_es_curYr_docList.add(docObjMap);
						} else if (docObj.getLanguage().equals("zh")) {
							planMatl_zh_curYr_docList.add(docObjMap);
							if ((planType.equals("PDP") || planType.equals("MA") || planType.equals("MAPD"))&& memberType.contains("GROUP"))
								memMatl_zh_curYr_docList.add(docObjMap);
						}
					//tbd }
				} else if (docObj.getType().equals("2")) {
					String docCategory="Evidence of Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
						annNotChgDoc_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
						annNotChgDoc_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
						annNotChgDoc_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("8003")) {
					String docCategory="Certificate of Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
						annNotChgDoc_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
						annNotChgDoc_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
						annNotChgDoc_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1022") || docObj.getType().equals("4") || docObj.getType().equals("8002")) {
					String docCategory="Comprehensive Formulary";
					//tbd if (planType.equals("MAPD") && memberType.contains("GROUP") && section.equals("Plan Materials"))
					//tbd 	docCategory="Formulary/Drug List - Comprehensive";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
						annNotChgDoc_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
						annNotChgDoc_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
						annNotChgDoc_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("7022")) {
					String docCategory="Alternative Drug List";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2019")) {
					String docCategory="Prior Authorization Criteria";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2020")) {
					String docCategory="Step Therapy Criteria";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2021")) {
					String docCategory="Formulary Additions";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2022")) {
					String docCategory="Formulary Deletions";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("8006")) { 
					String docCategory="Getting Started Guide";
					if (docObj.getName().contains("Quick Start Guide")) 
						docCategory="Quick Start Guide";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6014")) {
					String docCategory="Annual Notice of Changes";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						annNotChgDoc_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						annNotChgDoc_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						annNotChgDoc_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1027")) {
					String docCategory="Provider Directory";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						proPhmDir_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						proPhmDir_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						proPhmDir_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("7025")) {
					String docCategory="Vendor Information Sheet";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						proPhmDir_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						proPhmDir_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						proPhmDir_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1028") || docObj.getType().equals("1026")) {
					String docCategory="Pharmacy Directory";
					//String docCategory="Pharmacy Directory Information";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						proPhmDir_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						proPhmDir_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						proPhmDir_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("7001")) {
					String docCategory="UnitedHealth Passport Program";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("5002")) {
					String docCategory="Plan Benefits Table";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("5006")) {
					String docCategory="A Guide to Health Insurance for People with Medicare";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("4005")) {
					String docCategory="Additional Drug Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
						annNotChgDoc_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
						annNotChgDoc_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
						annNotChgDoc_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("5009")) {
					String docCategory="CDI Long Notice (CA Only)";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage"))
							memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage"))
							memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage"))
							memMatl_zh_curYr_docList.add(docObjMap);
					}
					HashMap<String, Document> docObjMap2=new HashMap<String, Document>(); 
					String docCategory2="Privacy Notice";
					docObjMap2.put(docCategory2, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap2);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap2);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap2);
					}
				} else if (docObj.getType().equals("1021")) {
					String docCategory="Schedule of benefits";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6011")) {
					String docCategory="Certificate of Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("7010")) {
					String docCategory="Your Plan Getting Started";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1042")) {
					String docCategory="Plan Guide";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6016")) {
					String docCategory="Plan Summary";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6017")) {
					String docCategory="Plan Information";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_curYr_docList.add(docObjMap);
						memMatl_en_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_curYr_docList.add(docObjMap);
						memMatl_es_curYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_curYr_docList.add(docObjMap);
						memMatl_zh_curYr_docList.add(docObjMap);
					}
				}					
				//--------------	
		    //note: for next year section
			} else if (docObj.getYear().equals(nextYear)) {
				if (docObj.getType().equals("6002")) {
					String docCategory="Benefit Highlights";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("3")) {
					String docCategory="Summary of Benefits";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						if ((planType.equals("PDP") || planType.equals("MA") || planType.equals("MAPD"))&& memberType.contains("GROUP"))
							memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						if ((planType.equals("PDP") || planType.equals("MA") || planType.equals("MAPD"))&& memberType.contains("GROUP"))
							memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						if ((planType.equals("PDP") || planType.equals("MA") || planType.equals("MAPD"))&& memberType.contains("GROUP"))
							memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2")) {
					String docCategory="Evidence of Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
						annNotChgDoc_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
						annNotChgDoc_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
						annNotChgDoc_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("8003")) {
					String docCategory="Certificate of Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
						annNotChgDoc_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
						annNotChgDoc_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
						annNotChgDoc_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1022") || docObj.getType().equals("4") || docObj.getType().equals("8002")) {
					String docCategory="Comprehensive Formulary";
					//tbd if (planType.equals("MAPD") && memberType.contains("GROUP") && section.equals("Plan Materials"))
					//tbd 	docCategory="Formulary/Drug List - Comprehensive";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
						annNotChgDoc_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
						annNotChgDoc_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
						annNotChgDoc_zh_nxtYr_docList.add(docObjMap);

					}
				} else if (docObj.getType().equals("7022")) {
					String docCategory="Alternative Drug List";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2019")) {
					String docCategory="Prior Authorization Criteria";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2020")) {
					String docCategory="Step Therapy Criteria";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2021")) {
					String docCategory="Formulary Additions";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("2022")) {
					String docCategory="Formulary Deletions";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("8006")) {
					String docCategory="Getting Started Guide";
					if (docObj.getName().contains("Quick Start Guide")) 
						docCategory="Quick Start Guide";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6014")) {
					String docCategory="Annual Notice of Changes";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						annNotChgDoc_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						annNotChgDoc_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						annNotChgDoc_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1027")) {
					String docCategory="Provider Directory";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						proPhmDir_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						proPhmDir_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						proPhmDir_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1042")) {
					String docCategory="Plan Guide";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("7025")) {
					String docCategory="Vendor Information Sheet";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						proPhmDir_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						proPhmDir_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						proPhmDir_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("1028") || docObj.getType().equals("1026")) {
					String docCategory="Pharmacy Directory";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						proPhmDir_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						proPhmDir_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						proPhmDir_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("4005")) {
					String docCategory="Additional Drug Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
						annNotChgDoc_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
						annNotChgDoc_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
						annNotChgDoc_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("5009")) {
					String docCategory="CDI Long Notice (CA Only)";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage"))
							memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage"))
							memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage"))
							memMatl_zh_nxtYr_docList.add(docObjMap);
					}
					HashMap<String, Document> docObjMap2=new HashMap<String, Document>(); 
					String docCategory2="Privacy Notice";
					docObjMap2.put(docCategory2, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap2);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap2);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap2);
					}
				} else if (docObj.getType().equals("1021")) {
					String docCategory="Schedule of benefits";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6011")) {
					String docCategory="Certificate of Coverage";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("7010")) {
					String docCategory="Your Plan Getting Started";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6016")) {
					String docCategory="Plan Summary";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				} else if (docObj.getType().equals("6017")) {
					String docCategory="Plan Information";
					docObjMap.put(docCategory, docObj);
					if (docObj.getLanguage().equals("en_us")) {
						planMatl_en_nxtYr_docList.add(docObjMap);
						memMatl_en_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("es")) {
						planMatl_es_nxtYr_docList.add(docObjMap);
						memMatl_es_nxtYr_docList.add(docObjMap);
					} else if (docObj.getLanguage().equals("zh")) {
						planMatl_zh_nxtYr_docList.add(docObjMap);
						memMatl_zh_nxtYr_docList.add(docObjMap);
					}
				}
			}
		}
		planMatlSecList.add(planMatl_en_curYr_docList);
		planMatlSecList.add(planMatl_es_curYr_docList);
		planMatlSecList.add(planMatl_zh_curYr_docList);
		planMatlSecList.add(planMatl_en_nxtYr_docList);
		planMatlSecList.add(planMatl_es_nxtYr_docList);
		planMatlSecList.add(planMatl_zh_nxtYr_docList);

		memMatlSecList.add(memMatl_en_curYr_docList);
		memMatlSecList.add(memMatl_es_curYr_docList);
		memMatlSecList.add(memMatl_zh_curYr_docList);
		memMatlSecList.add(memMatl_en_nxtYr_docList);
		memMatlSecList.add(memMatl_es_nxtYr_docList);
		memMatlSecList.add(memMatl_zh_nxtYr_docList);

		annNotChgDocSecList.add(annNotChgDoc_en_curYr_docList);
		annNotChgDocSecList.add(annNotChgDoc_es_curYr_docList);
		annNotChgDocSecList.add(annNotChgDoc_zh_curYr_docList);
		annNotChgDocSecList.add(annNotChgDoc_en_nxtYr_docList);
		annNotChgDocSecList.add(annNotChgDoc_es_nxtYr_docList);
		annNotChgDocSecList.add(annNotChgDoc_zh_nxtYr_docList);

		proPhmDirSecList.add(proPhmDir_en_curYr_docList);
		proPhmDirSecList.add(proPhmDir_es_curYr_docList);
		proPhmDirSecList.add(proPhmDir_zh_curYr_docList);
		proPhmDirSecList.add(proPhmDir_en_nxtYr_docList);
		proPhmDirSecList.add(proPhmDir_es_nxtYr_docList);
		proPhmDirSecList.add(proPhmDir_zh_nxtYr_docList);
		return success;
	}

	/**
	 * Turn info of each document into document object
	 * @param docJsonObj
	 * @return
	 */
	public Document buildDocumentObj(JSONObject docJsonObj) {
		Assert.assertTrue("PROBLEM - docJsonObj should not be null", docJsonObj!=null);


		String name = (String) docJsonObj.get("name");
		String link = (String) docJsonObj.get("link");
		String type = (String) docJsonObj.get("type");
		String language = (String) docJsonObj.get("language");
		String year = (String) docJsonObj.get("year");
		String compCode = (String) docJsonObj.get("compCode");
		String segmentId = (String) docJsonObj.get("segmentId");
		Boolean checkDestUrl=true;  // default to true if not available
		if (docJsonObj.get("checkDestUrl")!=null)
			checkDestUrl = (Boolean) docJsonObj.get("checkDestUrl");
		Boolean switchTab=true;  // default to true if not available
		if (docJsonObj.get("switchTab")!=null)
			switchTab  = (Boolean) docJsonObj.get("switchTab");

		return new Document(name, link, type, language, year, 
				compCode, segmentId, checkDestUrl, switchTab);
	}

	List<String> noteList;

	/** 
	 * helper - for test note
	 */
	public void doNoteAndText(String text) {
		noteList.add(text);
		System.out.println(text);
	}

	/**
	 * helper for test note
	 * @param inputList
	 */
	public void doNoteAndText(List<HashMap<String, Document>> inputList) {
		String docs="";
		for (HashMap<String, Document> item: inputList) {
			docs=docs+" "+item.keySet();
		}
		doNoteAndText("    "+docs);
	}

	/**
	 * print out the list of doc in detail
	 * @return
	 */
	public List<String> printPlanDocDetail() {
		noteList=new ArrayList<String>();
		doNoteAndText("==========================================================================================");
		doNoteAndText("According to API response...");
		doNoteAndText("===============");
		if (!isSuccess()) {
			doNoteAndText("Not able to get successful API response");
			return noteList;
		}
		doNoteAndText("Plan Materials section has the following:");
		doNoteAndText("  Has "+planMatl_en_curYr_docList.size()+" number of English doc for year="+this.currentYear);
		doNoteAndText(planMatl_en_curYr_docList);
		doNoteAndText("  Has "+planMatl_es_curYr_docList.size()+" number of Spanish doc for year="+this.currentYear);
		doNoteAndText(planMatl_es_curYr_docList);
		doNoteAndText("  Has "+planMatl_zh_curYr_docList.size()+" number of Chinese doc for year="+this.currentYear);
		doNoteAndText(planMatl_zh_curYr_docList);
		doNoteAndText("  Has "+planMatl_en_nxtYr_docList.size()+" number of English doc for year="+this.nextYear);
		doNoteAndText(planMatl_en_nxtYr_docList);
		doNoteAndText("  Has "+planMatl_es_nxtYr_docList.size()+" number of Spanish doc for year="+this.nextYear);
		doNoteAndText(planMatl_es_nxtYr_docList);
		doNoteAndText("  Has "+planMatl_zh_nxtYr_docList.size()+" number of Chinese doc for year="+this.nextYear);
		doNoteAndText(planMatl_zh_nxtYr_docList);
		doNoteAndText("===============");
		doNoteAndText("Membership Materials section has the following:");
		doNoteAndText("  Has "+memMatl_en_curYr_docList.size()+" number of English doc for year="+this.currentYear);
		doNoteAndText(memMatl_en_curYr_docList);
		doNoteAndText("  Has "+memMatl_es_curYr_docList.size()+" number of Spanish doc for year="+this.currentYear);
		doNoteAndText(memMatl_es_curYr_docList);
		doNoteAndText("  Has "+memMatl_zh_curYr_docList.size()+" number of Chinese doc for year="+this.currentYear);
		doNoteAndText(memMatl_zh_curYr_docList);
		doNoteAndText("  Has "+memMatl_en_nxtYr_docList.size()+" number of English doc for year="+this.nextYear);
		doNoteAndText(memMatl_en_nxtYr_docList);
		doNoteAndText("  Has "+memMatl_es_nxtYr_docList.size()+" number of Spanish doc for year="+this.nextYear);
		doNoteAndText(memMatl_es_nxtYr_docList);
		doNoteAndText("  Has "+memMatl_zh_nxtYr_docList.size()+" number of Chinese doc for year="+this.nextYear);
		doNoteAndText(memMatl_zh_nxtYr_docList);
		doNoteAndText("===============");
		doNoteAndText("Annual Notice of Changes Document section has the following:");
		if (anocCurrentYearFlag) {
			doNoteAndText("  anocCurrentYearFlag=true, expect these to show up on UI ---");
		} else {
			doNoteAndText("  anocCurrentYearFlag=false, expect these NOT to show up on UI ---");
		}
		doNoteAndText("  Has "+annNotChgDoc_en_curYr_docList.size()+" number of English doc for year="+this.currentYear);
		doNoteAndText(annNotChgDoc_en_curYr_docList);
		doNoteAndText("  Has "+annNotChgDoc_es_curYr_docList.size()+" number of Spanish doc for year="+this.currentYear);
		doNoteAndText(annNotChgDoc_es_curYr_docList);
		doNoteAndText("  Has "+annNotChgDoc_zh_curYr_docList.size()+" number of Chinese doc for year="+this.currentYear);
		doNoteAndText(annNotChgDoc_zh_curYr_docList);
		if (anocNextYearFlag) {
			doNoteAndText("  anocNextYearFlag=true, expect these to show up on UI ---");
		} else {
			doNoteAndText("  anocNextYearFlag=false, expect these NOT to show up on UI ---");
		}
		doNoteAndText("  Has "+annNotChgDoc_en_nxtYr_docList.size()+" number of English doc for year="+this.nextYear);
		doNoteAndText(annNotChgDoc_en_nxtYr_docList);
		doNoteAndText("  Has "+annNotChgDoc_es_nxtYr_docList.size()+" number of Spanish doc for year="+this.nextYear);
		doNoteAndText(annNotChgDoc_es_nxtYr_docList);
		doNoteAndText("  Has "+annNotChgDoc_zh_nxtYr_docList.size()+" number of Chinese doc for year="+this.nextYear);
		doNoteAndText(annNotChgDoc_zh_nxtYr_docList);
		doNoteAndText("===============");
		doNoteAndText("Provider and Pharmacy Directories section has the following:");
		doNoteAndText("  Has "+proPhmDir_en_curYr_docList.size()+" number of English doc for year="+this.currentYear);
		doNoteAndText(proPhmDir_en_curYr_docList);
		doNoteAndText("  Has "+proPhmDir_es_curYr_docList.size()+" number of Spanish doc for year="+this.currentYear);
		doNoteAndText(proPhmDir_es_curYr_docList);
		doNoteAndText("  Has "+proPhmDir_zh_curYr_docList.size()+" number of Chinese doc for year="+this.currentYear);
		doNoteAndText(proPhmDir_zh_curYr_docList);
		doNoteAndText("  Has "+proPhmDir_en_nxtYr_docList.size()+" number of English doc for year="+this.nextYear);
		doNoteAndText(proPhmDir_en_nxtYr_docList);
		doNoteAndText("  Has "+proPhmDir_es_nxtYr_docList.size()+" number of Spanish doc for year="+this.nextYear);
		doNoteAndText(proPhmDir_es_nxtYr_docList);
		doNoteAndText("  Has "+proPhmDir_zh_nxtYr_docList.size()+" number of Chinese doc for year="+this.nextYear);
		doNoteAndText(proPhmDir_zh_nxtYr_docList);
		doNoteAndText("==========================================================================================");
		return noteList;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isAnocCurrentYearFlag() {
		return anocCurrentYearFlag;
	}

	public void setAnocCurrentYearFlag(boolean anocCurrentYearFlag) {
		this.anocCurrentYearFlag = anocCurrentYearFlag;
	}

	public boolean isAnocNextYearFlag() {
		return anocNextYearFlag;
	}

	public void setAnocNextYearFlag(boolean anocNextYearFlag) {
		this.anocNextYearFlag = anocNextYearFlag;
	}

	public List<List<HashMap<String, Document>>> getPlanMatlSecList() {
		return planMatlSecList;
	}

	public void setPlanMatlSecList(List<List<HashMap<String, Document>>> planMatlSecList) {
		this.planMatlSecList = planMatlSecList;
	}

	public List<List<HashMap<String, Document>>> getMemMatlSecList() {
		return memMatlSecList;
	}

	public void setMemMatlSecList(List<List<HashMap<String, Document>>> memMatlSecList) {
		this.memMatlSecList = memMatlSecList;
	}

	public List<List<HashMap<String, Document>>> getAnnNotChgDocSecList() {
		return annNotChgDocSecList;
	}

	public void setAnnNotChgDocSecList(List<List<HashMap<String, Document>>> annNotChgDocSecList) {
		this.annNotChgDocSecList = annNotChgDocSecList;
	}

	public List<List<HashMap<String, Document>>> getProPhmDirSecList() {
		return proPhmDirSecList;
	}

	public void setProPhmDirSecList(List<List<HashMap<String, Document>>> proPhmDirSecList) {
		this.proPhmDirSecList = proPhmDirSecList;
	}

	public List<HashMap<String, Document>> getPlanMatl_en_curYr_docList() {
		return planMatl_en_curYr_docList;
	}

	public void setPlanMatl_en_curYr_docList(List<HashMap<String, Document>> planMatl_en_curYr_docList) {
		this.planMatl_en_curYr_docList = planMatl_en_curYr_docList;
	}

	public List<HashMap<String, Document>> getPlanMatl_en_nxtYr_docList() {
		return planMatl_en_nxtYr_docList;
	}

	public void setPlanMatl_en_nxtYr_docList(List<HashMap<String, Document>> planMatl_en_nxtYr_docList) {
		this.planMatl_en_nxtYr_docList = planMatl_en_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getPlanMatl_es_curYr_docList() {
		return planMatl_es_curYr_docList;
	}

	public void setPlanMatl_es_curYr_docList(List<HashMap<String, Document>> planMatl_es_curYr_docList) {
		this.planMatl_es_curYr_docList = planMatl_es_curYr_docList;
	}

	public List<HashMap<String, Document>> getPlanMatl_es_nxtYr_docList() {
		return planMatl_es_nxtYr_docList;
	}

	public void setPlanMatl_es_nxtYr_docList(List<HashMap<String, Document>> planMatl_es_nxtYr_docList) {
		this.planMatl_es_nxtYr_docList = planMatl_es_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getPlanMatl_zh_curYr_docList() {
		return planMatl_zh_curYr_docList;
	}

	public void setPlanMatl_zh_curYr_docList(List<HashMap<String, Document>> planMatl_zh_curYr_docList) {
		this.planMatl_zh_curYr_docList = planMatl_zh_curYr_docList;
	}

	public List<HashMap<String, Document>> getPlanMatl_zh_nxtYr_docList() {
		return planMatl_zh_nxtYr_docList;
	}

	public void setPlanMatl_zh_nxtYr_docList(List<HashMap<String, Document>> planMatl_zh_nxtYr_docList) {
		this.planMatl_zh_nxtYr_docList = planMatl_zh_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getMemMatl_en_curYr_docList() {
		return memMatl_en_curYr_docList;
	}

	public void setMemMatl_en_curYr_docList(List<HashMap<String, Document>> memMatl_en_curYr_docList) {
		this.memMatl_en_curYr_docList = memMatl_en_curYr_docList;
	}

	public List<HashMap<String, Document>> getMemMatl_en_nxtYr_docList() {
		return memMatl_en_nxtYr_docList;
	}

	public void setMemMatl_en_nxtYr_docList(List<HashMap<String, Document>> memMatl_en_nxtYr_docList) {
		this.memMatl_en_nxtYr_docList = memMatl_en_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getMemMatl_es_curYr_docList() {
		return memMatl_es_curYr_docList;
	}

	public void setMemMatl_es_curYr_docList(List<HashMap<String, Document>> memMatl_es_curYr_docList) {
		this.memMatl_es_curYr_docList = memMatl_es_curYr_docList;
	}

	public List<HashMap<String, Document>> getMemMatl_es_nxtYr_docList() {
		return memMatl_es_nxtYr_docList;
	}

	public void setMemMatl_es_nxtYr_docList(List<HashMap<String, Document>> memMatl_es_nxtYr_docList) {
		this.memMatl_es_nxtYr_docList = memMatl_es_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getMemMatl_zh_curYr_docList() {
		return memMatl_zh_curYr_docList;
	}

	public void setMemMatl_zh_curYr_docList(List<HashMap<String, Document>> memMatl_zh_curYr_docList) {
		this.memMatl_zh_curYr_docList = memMatl_zh_curYr_docList;
	}

	public List<HashMap<String, Document>> getMemMatl_zh_nxtYr_docList() {
		return memMatl_zh_nxtYr_docList;
	}

	public void setMemMatl_zh_nxtYr_docList(List<HashMap<String, Document>> memMatl_zh_nxtYr_docList) {
		this.memMatl_zh_nxtYr_docList = memMatl_zh_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getAnnNotChgDoc_en_curYr_docList() {
		return annNotChgDoc_en_curYr_docList;
	}

	public void setAnnNotChgDoc_en_curYr_docList(List<HashMap<String, Document>> annNotChgDoc_en_curYr_docList) {
		this.annNotChgDoc_en_curYr_docList = annNotChgDoc_en_curYr_docList;
	}

	public List<HashMap<String, Document>> getAnnNotChgDoc_en_nxtYr_docList() {
		return annNotChgDoc_en_nxtYr_docList;
	}

	public void setAnnNotChgDoc_en_nxtYr_docList(List<HashMap<String, Document>> annNotChgDoc_en_nxtYr_docList) {
		this.annNotChgDoc_en_nxtYr_docList = annNotChgDoc_en_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getAnnNotChgDoc_es_curYr_docList() {
		return annNotChgDoc_es_curYr_docList;
	}

	public void setAnnNotChgDoc_es_curYr_docList(List<HashMap<String, Document>> annNotChgDoc_es_curYr_docList) {
		this.annNotChgDoc_es_curYr_docList = annNotChgDoc_es_curYr_docList;
	}

	public List<HashMap<String, Document>> getAnnNotChgDoc_es_nxtYr_docList() {
		return annNotChgDoc_es_nxtYr_docList;
	}

	public void setAnnNotChgDoc_es_nxtYr_docList(List<HashMap<String, Document>> annNotChgDoc_es_nxtYr_docList) {
		this.annNotChgDoc_es_nxtYr_docList = annNotChgDoc_es_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getAnnNotChgDoc_zh_curYr_docList() {
		return annNotChgDoc_zh_curYr_docList;
	}

	public void setAnnNotChgDoc_zh_curYr_docList(List<HashMap<String, Document>> annNotChgDoc_zh_curYr_docList) {
		this.annNotChgDoc_zh_curYr_docList = annNotChgDoc_zh_curYr_docList;
	}

	public List<HashMap<String, Document>> getAnnNotChgDoc_zh_nxtYr_docList() {
		return annNotChgDoc_zh_nxtYr_docList;
	}

	public void setAnnNotChgDoc_zh_nxtYr_docList(List<HashMap<String, Document>> annNotChgDoc_zh_nxtYr_docList) {
		this.annNotChgDoc_zh_nxtYr_docList = annNotChgDoc_zh_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getProPhmDir_en_curYr_docList() {
		return proPhmDir_en_curYr_docList;
	}

	public void setProPhmDir_en_curYr_docList(List<HashMap<String, Document>> proPhmDir_en_curYr_docList) {
		this.proPhmDir_en_curYr_docList = proPhmDir_en_curYr_docList;
	}

	public List<HashMap<String, Document>> getProPhmDir_en_nxtYr_docList() {
		return proPhmDir_en_nxtYr_docList;
	}

	public void setProPhmDir_en_nxtYr_docList(List<HashMap<String, Document>> proPhmDir_en_nxtYr_docList) {
		this.proPhmDir_en_nxtYr_docList = proPhmDir_en_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getProPhmDir_es_curYr_docList() {
		return proPhmDir_es_curYr_docList;
	}

	public void setProPhmDir_es_curYr_docList(List<HashMap<String, Document>> proPhmDir_es_curYr_docList) {
		this.proPhmDir_es_curYr_docList = proPhmDir_es_curYr_docList;
	}

	public List<HashMap<String, Document>> getProPhmDir_es_nxtYr_docList() {
		return proPhmDir_es_nxtYr_docList;
	}

	public void setProPhmDir_es_nxtYr_docList(List<HashMap<String, Document>> proPhmDir_es_nxtYr_docList) {
		this.proPhmDir_es_nxtYr_docList = proPhmDir_es_nxtYr_docList;
	}

	public List<HashMap<String, Document>> getProPhmDir_zh_curYr_docList() {
		return proPhmDir_zh_curYr_docList;
	}

	public void setProPhmDir_zh_curYr_docList(List<HashMap<String, Document>> proPhmDir_zh_curYr_docList) {
		this.proPhmDir_zh_curYr_docList = proPhmDir_zh_curYr_docList;
	}

	public List<HashMap<String, Document>> getProPhmDir_zh_nxtYr_docList() {
		return proPhmDir_zh_nxtYr_docList;
	}

	public void setProPhmDir_zh_nxtYr_docList(List<HashMap<String, Document>> proPhmDir_zh_nxtYr_docList) {
		this.proPhmDir_zh_nxtYr_docList = proPhmDir_zh_nxtYr_docList;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getNextYear() {
		return nextYear;
	}

	public void setNextYear(String nextYear) {
		this.nextYear = nextYear;
	}

	public List<String> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<String> noteList) {
		this.noteList = noteList;
	}


}
