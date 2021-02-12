import AddressBook.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    private BuddyInfo buddy;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up AddressBook.BuddyInfo.");
        buddy = new BuddyInfo("TestName", "TestAddress");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing down AddressBook.BuddyInfo.");
        buddy = null;
        assertNull(buddy);
    }

    @Test
    public void getName(){
        assertEquals(buddy.getName(), "TestName");
    }

    @Test
    public void getAddress() {
        assertEquals(buddy.getAddress(), "TestAddress");
    }
    /**
    @Test
    public void toStringTest(){
        assertEquals(buddy.toString(), "TestName#TestAddress");
    }
    */
    @Test
    public void setName() {
        buddy.setName("ChangedName");
        assertEquals(buddy.getName(), "ChangedName");
    }

    @Test
    public void setAddress() {
        buddy.setAddress("ChangedAddress");
        assertEquals(buddy.getAddress(), "ChangedAddress");
    }

    /**
    @Test
    public void testJPA(){
        String t = "empty";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(buddy);
        tx.commit();
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
        List<BuddyInfo> results = q.getResultList();
        for (BuddyInfo b : results){
            t = b.getName();
        }
        em.close();
        emf.close();
        assertEquals(t, "TestName");

    }
    */
}