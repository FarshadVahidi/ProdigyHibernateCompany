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
        
        Department dep = new Department();
        dep.setDname("Administration");
        dep.setDnumber(4);
        dep.setMgrSsn(888665555);
        dep.setUtilCalendar(new GregorianCalendar(1981, 6, 19));
        
        Transaction tx = session.beginTransaction();
        session.save(dep);
        tx.commit();
        
      /*  Name name = new Name();
        name.setFname("Ramesh");
        name.setMname("K");
        name.setLname("Narayan");
        
        Employee eToAdd = new Employee();
        eToAdd.setName(name);
        eToAdd.setSsn(666884444);
        eToAdd.setAddress("975 Fire Oak, Humble, TX");
        eToAdd.setSex('M');
        eToAdd.setSalary(38000);
        eToAdd.setDep(dep);
        
        
        
        tx = session.beginTransaction();
        session.save(eToAdd);
        fetch = (Department)session.get(Department.class, 5);
        fetchE = (Employee)session.get(Employee.class, 888665555);
        tx.commit();*/
        
        System.out.println(fetch);
        System.out.println(fetchE);
    }
}
