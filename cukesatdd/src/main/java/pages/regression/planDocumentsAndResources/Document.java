package pages.regression.planDocumentsAndResources;

import java.util.List;

/**
 *   Example of a Document Object content
 *     name=2019 English MAPD Individual Web FM Pharmacy Directory_UHC_DSNP
 *     link=/alphadog/UHEX19DU4325027_000
 *     type=1028
 *     language=en_us
 *     year=2019
 *     compCode=UHEX19DU4325027_000
 *     segmentId=MAPD_govt_false_69697588_2019
 *     checkDestUrl=true
 *     switchTab=true;
 *
 */
public class Document {
	
	protected String name;
	protected String link;
	protected String type;
	protected String language;
	protected String year; 
	protected String compCode; 
	protected String segmentId; 
	protected boolean checkDestUrl;
	protected boolean switchTab;

	public Document() {
		this.name="";
		this.link="";
		this.type="";
		this.language="";
		this.year="";
		this.compCode="";
		this.segmentId="";
		this.checkDestUrl=false;
		this.switchTab=true;
	}

	public boolean isCheckDestUrl() {
		return checkDestUrl;
	}

	public void setCheckDestUrl(boolean checkDestUrl) {
		this.checkDestUrl = checkDestUrl;
	}

	public boolean isSwitchTab() {
		return switchTab;
	}

	public void setSwitchTab(boolean switchTab) {
		this.switchTab = switchTab;
	}

	public Document(String name, String link, String type, String language, String year, 
			String compCode, String segmentId, boolean checkDestUrl, boolean switchTab) {
		this.name=name;
		this.link=link;
		this.type=type;
		this.language=language;
		this.year=year;
		this.compCode=compCode;
		this.segmentId=segmentId;
		this.checkDestUrl=false;
		this.switchTab=true;
	}
	
	public void printDetail() {
		System.out.println("Document detail");
		System.out.print("  name="+name);
		System.out.print("|  link="+link);
		System.out.print("|  type="+type);
		System.out.print("|  language="+language);
		System.out.print("|  year="+year);
		System.out.print("|  compCode="+compCode);
		System.out.print("|  segmentId="+segmentId);
		System.out.print("|  checkDestUrl="+checkDestUrl);
		System.out.print("|  switchTab="+switchTab);
		System.out.println("\n");
	}

	public void printDetail(Document inputDoc) {
		System.out.print("Document detail");
		System.out.print(":  name="+inputDoc.getName());
		System.out.print("|  link="+inputDoc.getLink());
		System.out.print("|  type="+inputDoc.getType());
		System.out.print("|  language="+inputDoc.getLanguage());
		System.out.print("|  year="+inputDoc.getYear());
		System.out.print("|  compCode="+inputDoc.getCompCode());
		System.out.print("|  segmentId="+inputDoc.getSegmentId());
		System.out.print("|  checkDestUrl="+inputDoc.isCheckDestUrl());
		System.out.print("|  switchTab="+inputDoc.isSwitchTab());
		System.out.println("\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}
	
	public boolean compareTwoDocuments(Document doc1, Document doc2) {
		if (doc1.getName().equals(doc2.getName())
		&& doc1.getLink().equals(doc2.getLink())
		&& doc1.getType().equals(doc2.getType())
		&& doc1.getLanguage().equals(doc2.getLanguage())
		&& doc1.getYear().equals(doc2.getYear())
		&& doc1.getCompCode().equals(doc2.getCompCode())
		&& doc1.isCheckDestUrl()==doc2.isCheckDestUrl()
		&& doc1.isSwitchTab()==doc2.isSwitchTab()) {
			return true;
		}
		return false;
	}
	
	public boolean hasDuplicateInDocList(List<Document> docList, Document doc) {
		boolean check=false;
		for(Document d: docList) {
			if (compareTwoDocuments(d, doc))
				check=true;
		}
		return check;
	}
	
	/**
	 * helper - get the type for the given doc
	 * @param docName
	 * @return
	 */
	public String getDocType(String docName) {
		if (docName.toLowerCase().equalsIgnoreCase("Benefit Highlights".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Beneficios Importantes".toLowerCase())) 
			return "6002";
		if (docName.toLowerCase().equalsIgnoreCase("Summary of Benefits".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Resumen de Beneficios".toLowerCase())) 
			return "3";
		if (docName.toLowerCase().equalsIgnoreCase("Evidence of Coverage".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Comprobante de Cobertura".toLowerCase())) 
			return "2";
		if (docName.toLowerCase().equalsIgnoreCase("Comprehensive Formulary-Spanish".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Formulario Completo-Spanish".toLowerCase())) 
		 	return "1022";
		if (docName.toLowerCase().equalsIgnoreCase("Comprehensive Formulary".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Formulario completo".toLowerCase())|| docName.toLowerCase().equalsIgnoreCase("Formulary Comprehensive".toLowerCase())) 
		 	return "4";
		if (docName.toLowerCase().equalsIgnoreCase("Alternative Drug List".toLowerCase()) ||  docName.toLowerCase().equalsIgnoreCase("Lista de Medicamentos".toLowerCase())||  docName.toLowerCase().equalsIgnoreCase("Lista de Medicamentos Alternativos".toLowerCase())) 
			return "7022";
		if (docName.toLowerCase().equalsIgnoreCase("UnitedHealth Passport Program".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Programa UnitedHealth Passport".toLowerCase())) 
			return "7001";
		if (docName.toLowerCase().equalsIgnoreCase("Prior Authorization Criteria".toLowerCase())) 
			return "2019";
		if (docName.toLowerCase().equalsIgnoreCase("Step Therapy Criteria".toLowerCase())) 
			return "2020";
		if (docName.toLowerCase().equalsIgnoreCase("Formulary Additions".toLowerCase())) 
			return "2021";
		if (docName.toLowerCase().equalsIgnoreCase("Formulary Deletions".toLowerCase())) 
			return "2022";
		if (docName.toLowerCase().equalsIgnoreCase("Getting Started Guide".toLowerCase()) || docName.toLowerCase().contains("para Comenzar".toLowerCase())) 
			return "8006";
		if (docName.toLowerCase().equalsIgnoreCase("Quick Start Guide".toLowerCase()))
			return "8006";
		if (docName.toLowerCase().equalsIgnoreCase("Annual Notice of Changes".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Aviso Annual de Cambios".toLowerCase())) 
			return "6014";
		if (docName.toLowerCase().equalsIgnoreCase("Provider Directory".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Directorio de Proveedores".toLowerCase())) 
			return "1027";
		if (docName.toLowerCase().equalsIgnoreCase("Vendor Information Sheet".toLowerCase()) || docName.toLowerCase().contains("sobre proveedores".toLowerCase())) 
			return "7025";
		if (docName.toLowerCase().equalsIgnoreCase("Pharmacy Directory".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Pharmacy Directory Information".toLowerCase()) || docName.toLowerCase().contains("del Directorio de Farmacia".toLowerCase())) { 
			if (docName.contains("PDP")) 
				return "1026";
			else
				return "1028";
		}
		if (docName.toLowerCase().equalsIgnoreCase("Certificate of Coverage".toLowerCase()))
			return "8003";
		if (docName.toLowerCase().equalsIgnoreCase("Plan Benefits Table".toLowerCase())) 
			return "5002"; //note: SHIP
		if (docName.toLowerCase().equalsIgnoreCase("A Guide to Health Insurance for People with Medicare".toLowerCase())) 
			return "5006"; //note: SHIP
		if (docName.toLowerCase().equalsIgnoreCase("Formulary/Drug List - Comprehensive".toLowerCase())) 
			return "8002";
		if (docName.toLowerCase().equalsIgnoreCase("Additional Drug Coverage".toLowerCase())) 
			return "4005";
		System.out.println("TEST - unable to find a type match for docName="+docName);
		return "-1";
	}
	
}
