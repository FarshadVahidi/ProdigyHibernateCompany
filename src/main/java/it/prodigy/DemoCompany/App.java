package it.prodigy.DemoCompany;

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
    	
        Name name = new Name();
        name.setFname("Alicia");
        name.setMname("J");
        name.setLname("Zelaya");
        
        Employee e = new Employee();
        e.setName(name);
        e.setSsn(999887777);
        e.setAddress("3321 Castle, Spring, TX");
        e.setSex('F');
        e.setSalary(25000);
        e.setSuperSsn(987654321);
        
        Employee fetch = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e);
        fetch = (Employee)session.get(Employee.class, 333445555);
        tx.commit();
        
        System.out.println(fetch);
    }
}
