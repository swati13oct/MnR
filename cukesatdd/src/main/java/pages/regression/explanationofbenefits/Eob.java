package pages.regression.explanationofbenefits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Eob implements Comparable<Eob>{
	
	protected Date eobDate;
	protected String esp;
	protected String eobType;
	protected String compoundDoc;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	public Eob() {
		this.eobDate=new Date();
		this.esp="";
		this.eobType="";
		this.compoundDoc="";
	}

	public Eob(Date eobDate, String esp, String compoundDoc) {
		this.eobDate=eobDate;
		this.esp=esp;
		this.eobType="";
		this.compoundDoc="";
	}
	
	public Eob(Date eobDate, String esp, String eobType, String compoundDoc) {
		this.eobDate=eobDate;
		this.esp=esp;
		this.eobType=eobType;
		this.compoundDoc=compoundDoc;
	}
	
	public void printDetail() {
		//tbd SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String eobDateStr= sdf.format(eobDate);

		System.out.print("EOB API detail");
		System.out.print(":  eobDate="+eobDateStr);
		System.out.print(" |  esp="+esp);
		System.out.print(" |  compoundDoc="+compoundDoc);
		if (!eobType.equals(""))
			System.out.print("|  eobType="+eobType);
		System.out.println("\n");
	}

	public void printDetail(Eob inputEob) {
		//tbd sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String eobDateStr= sdf.format(eobDate);

		System.out.print("EOB API detail");
		System.out.print(":  eobDate="+eobDateStr);
		System.out.print(" |  esp="+inputEob.getEsp());
		System.out.print(" |  compoundDoc="+inputEob.getCompoundDoc());
		if (!inputEob.getEobType().equals(""))
			System.out.print(" |  eobType="+inputEob.getEobType());
		System.out.println("\n");
	}

	public Date getEobDate() {
		return eobDate;
	}
	
	public String getEobDateStr() {
		return eobDate.toString();
	}
	
	public String getCompoundDoc() {
		return compoundDoc;
	}

	public void setCompoundDoc(String compoundDoc) {
		this.compoundDoc = compoundDoc;
	}

	public void setEobDate(Date eobDate) {
		this.eobDate = eobDate;
	}
	
	public void setEobDate(String eobDate) {
		try {
			//tbd SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			//tbd sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			this.eobDate  = sdf.parse(eobDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}
	
	public String getEobType() {
		return eobType;
	}

	public void setEobType(String eobType) {
		this.eobType = eobType;
	}

	@Override
	public int compareTo(Eob e) {
		if (this.getEobDate()==null || e.getEobDate()==null) 
			return 0;
		return e.getEobDate().compareTo(this.getEobDate());
	}


	
}
