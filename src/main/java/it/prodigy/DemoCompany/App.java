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
        
        Department fetch = null;
        Employee fetchE = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
       
        
        
        
        
        Transaction tx = session.beginTransaction();
        fetch = (Department)session.get(Department.class, 5);
        fetchE = (Employee)session.get(Employee.class, 888665555);
        tx.commit();
        
        System.out.println(fetch);
        System.out.println(fetchE);
    }
}
