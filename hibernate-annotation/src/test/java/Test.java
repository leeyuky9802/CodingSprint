import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import site.yangxiao.coding.Employee;

import java.util.Date;
import java.util.List;

public class Test extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    public void setUp(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }


    @SuppressWarnings("unchecked")
    public void testBasicUsage() {
        // create a couple of events...
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist( new Employee("Xiao", "Yang", "leeyuky9802@gmail.com", new Date() ) );
        session.persist(new Employee("Xiuqi", "Lee", "sdfsd@hsldf.com", new Date()));
        session.persist(new Employee("Hongtai", "Zou", "hzou8@hsldf.com", new Date()));
        session.getTransaction().commit();
        session.close();

        // now lets pull events from the database and list them
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Employee" ).list();
        for ( Employee employee : (List<Employee>) result ) {
            System.out.println( "Employee (" + employee.getDateJoined() + ") : " + employee.getLastName() );
        }
        session.getTransaction().commit();
        session.close();
    }
}
