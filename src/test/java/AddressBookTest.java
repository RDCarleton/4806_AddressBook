import AddressBook.AddressBook;
import AddressBook.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    private AddressBook book;
    private BuddyInfo buddy1;
    private BuddyInfo buddy2;
    @Before
    public void setUp() throws Exception {
        book = new AddressBook();
        book.setID(1);
        buddy1 = new BuddyInfo("TestName1", "TestAddress1");
        book.addBuddy(buddy1);
    }

    @After
    public void tearDown() throws Exception {
        buddy1 = null;
        buddy2 = null;
        book = null;
        assertNull(buddy1);
        assertNull(buddy2);
        assertNull(book);
    }

    @Test
    public void getBuddy() {
        assertEquals(book.getBuddy(0), buddy1);
    }

    @Test
    public void addBuddy() {
        buddy2 = new BuddyInfo("TestName2", "TestAddress2");
        book.addBuddy(buddy2);
        assertEquals(book.getBuddy(1), buddy2);
    }
    /**
    @Test
    public void bookString() {
        List<String> s = new ArrayList<String>();
        s.add("TestName1#TestAddress1");
        assertEquals(book.bookString(), s);
    }

    @Test
    public void testJPA() {
        long id = 0;
        buddy2 = new BuddyInfo("TestName2", "TestAddress2");
        book.addBuddy(buddy2);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(buddy1);
        em.persist(buddy2);
        em.persist(book);
        tx.commit();
        Query q = em.createQuery("SELECT a FROM AddressBook a");
        List<AddressBook> results = q.getResultList();
        for (AddressBook a : results){
            id = a.getID();
        }
        em.close();
        emf.close();
        assertEquals(id, 1);
    }
    */
}