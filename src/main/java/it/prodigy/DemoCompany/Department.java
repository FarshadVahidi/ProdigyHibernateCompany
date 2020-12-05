package it.prodigy.DemoCompany;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="department")
public class Department {
	
	
	private String Dname;
	@Id
	private int Dnumber;
	@Column(name="Mgr_ssn")
	private int MgrSsn;
	@Column(name="Mgr_start_date")
	@Temporal(TemporalType.DATE)
	private  Calendar utilCalendar;
	@OneToMany(mappedBy="dep")
	private List<Employee> employees = new ArrayList<Employee>();
	
	
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
	@Override
	public String toString() {
		return "Department [Dname=" + Dname + ", Dnumber=" + Dnumber + ", MgrSsn=" + MgrSsn + ", utilCalendar="
				+ utilCalendar.getTime() + "]";
	}
	
	
	
}
