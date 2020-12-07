package it.prodigy.DemoCompany;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {        
        
        Department dep = new Department();
        dep.setDnumber(4);
    	
        Employee e = new Employee();
        e.setSsn(999887777);
        e.setDep(dep);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
       
        
        
        
        
        Transaction tx = session.beginTransaction();
        session.update(e);
        tx.commit();
        
        
    }
}
