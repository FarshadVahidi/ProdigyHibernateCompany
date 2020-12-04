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
        employee.setSuperSsn(333445555);
        
        Employee employee1 = new Employee();
        employee1.setFname("Franklin");
        employee1.setMname("T");
        employee1.setLname("Wong");
        employee1.setSsn(333445555);
        employee1.setAddress("638 Voss, Houston, TX");
        employee1.setSex('M');
        employee1.setSalary(40000);
        
        Employee fetch = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee1);
        session.save(employee);
        fetch = (Employee)session.get(Employee.class, 333445555);
        tx.commit();
        
        System.out.println(fetch);
    }
}
