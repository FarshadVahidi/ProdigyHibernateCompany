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
        Employee employee = new Employee();
        employee.setFname("John");
        employee.setMname("B");
        employee.setLname("Smith");
        employee.setSsn(123456789);
        employee.setAddress("731 Fondren, Houston, TX");
        employee.setSex('M');
        employee.setSalary(30000);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
    }
}
