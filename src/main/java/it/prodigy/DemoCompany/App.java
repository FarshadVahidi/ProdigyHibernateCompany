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
        Employee e = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();
        
        e = (Employee) session1.get(Employee.class, 333445555);
        System.out.println(e);
        
        session1.getTransaction().commit();
        session1.close();
        
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        e = (Employee) session2.get(Employee.class, 333445555);
        System.out.println(e);
        
        session2.getTransaction().commit();
        session2.close();       
       
    }
}
