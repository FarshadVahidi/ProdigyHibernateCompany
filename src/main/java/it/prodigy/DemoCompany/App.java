package it.prodigy.DemoCompany;

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
        dep.setDname("research");
        dep.setDnumber(5);
        dep.setMgrSsn(333445555);
        dep.setUtilCalendar(new GregorianCalendar(1988, 5, 22));
        
        
      /*  Name name = new Name();
        name.setFname("James");
        name.setMname("E");
        name.setLname("Borg");
        
        Employee e = new Employee();
        e.setName(name);
        e.setSsn(888665555);
        e.setAddress("450 Stone, Houston, TX");
        e.setSex('M');
        e.setSalary(55000);
        e.setDep(dep1);
        
        Department dep1 = new Department();
        dep1.setDname("Headquarters");
        dep1.setDnumber(1);
        dep1.setMgrSsn(888665555);
        dep1.setUtilCalendar(new GregorianCalendar(1981, 6, 19));*/
        
        
        
        Department fetch = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(dep);
        fetch = (Department)session.get(Department.class, 5);
        tx.commit();
        
        System.out.println(fetch);
    }
}
