package pages.regression.explanationofbenefits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Eob implements Comparable<Eob>{
	
	protected Date eobDate;
	protected String esp;
	protected String eobType;

	public Eob() {
		this.eobDate=new Date();
		this.esp="";
		this.eobType="";
	}

	public Eob(Date eobDate, String esp) {
		this.eobDate=eobDate;
		this.esp=esp;
		this.eobType="";
	}
	
	public Eob(Date eobDate, String esp, String eobType) {
		this.eobDate=eobDate;
		this.esp=esp;
		this.eobType=eobType;
	}
	
	public void printDetail() {
		System.out.print("EOB detail");
		System.out.print(":  eobDate="+eobDate.toString());
		System.out.print("|  esp="+esp);
		if (!eobType.equals(""))
			System.out.print("|  eobType="+eobType);
		System.out.println("\n");
	}

	public void printDetail(Eob inputEob) {
		System.out.print("EOB detail");
		System.out.print(":  eobDate="+inputEob.getEobDate());
		System.out.print("|  esp="+inputEob.getEsp());
		if (!inputEob.getEobType().equals(""))
			System.out.print("|  eobType="+inputEob.getEobType());
		System.out.println("\n");
	}

	public Date getEobDate() {
		return eobDate;
	}
	
	public String getEobDateStr() {
		return eobDate.toString();
	}

	public void setEobDate(Date eobDate) {
		this.eobDate = eobDate;
	}
	
	public void setEobDate(String eobDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
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
		this.getEobDate().compareTo(e.getEobDate());
		return 0;
	}


	
}
