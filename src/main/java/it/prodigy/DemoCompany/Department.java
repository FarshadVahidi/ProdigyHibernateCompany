package it.prodigy.DemoCompany;

import java.util.Calendar;

public class Department {
	
	
	private String Dname;
	private int Dnumber;
	private int MgrSsn;
	private  Calendar utilCalendar;
	
	
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public int getDnumber() {
		return Dnumber;
	}
	public void setDnumber(int dnumber) {
		Dnumber = dnumber;
	}
	public int getMgrSsn() {
		return MgrSsn;
	}
	public void setMgrSsn(int mgrSsn) {
		MgrSsn = mgrSsn;
	}
	public Calendar getUtilCalendar() {
		return utilCalendar;
	}
	public void setUtilCalendar(Calendar utilCalendar) {
		this.utilCalendar = utilCalendar;
	}
	
	
	
}
