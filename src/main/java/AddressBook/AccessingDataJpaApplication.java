package AddressBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

//@SpringBootApplication
public class AccessingDataJpaApplication {
/**
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository bookRepo, BuddyInfoRepository buddyRepo) {
        return (args) -> {
            // Save a few BuddyInfo objects
            buddyRepo.save(new BuddyInfo("Mark", "Vancouver"));
            buddyRepo.save(new BuddyInfo("Bob", "Ottawa"));
            buddyRepo.save(new BuddyInfo("Joe", "Toronto"));
            // Create an AddressBook db entry
            bookRepo.save(new AddressBook());
            AddressBook test = bookRepo.findByID(1L);
            test.addBuddy(buddyRepo.findByName("Mark"));
            test.addBuddy((buddyRepo.findByName("Bob")));
            test.addBuddy(buddyRepo.findByName("Joe"));
            // Update db entry
            bookRepo.save(test);
            // Return all BuddyInfos
            log.info("BuddyInfos found with findAll()");
            log.info("--------------------------------");
            for(BuddyInfo b : buddyRepo.findAll()){
                log.info(b.toString());
            }
            log.info("");

            // Return BuddyInfo by name
            BuddyInfo b = buddyRepo.findByName("Mark");
            log.info("BuddyInfo found with findByName('Mark')");
            log.info("--------------------------------");
            log.info(b.toString());
            log.info("");

            // Return all AddressBooks
            log.info("AddressBooks found with findAll()");
            log.info("--------------------------------");
            for(AddressBook a : bookRepo.findAll()){
                log.info(Long.toString(a.getID()));
            }
            log.info("");
            // Return AddressBook by ID
            AddressBook a = bookRepo.findByID(1L);
            log.info("AddressBook found with findByID(1L)");
            log.info("--------------------------------");
            log.info(Long.toString(a.getID()));
            log.info("");
            log.info("AddressBook found with findByID(1L) having toString() ran");
            log.info("--------------------------------");
            log.info(bookRepo.findByID(1L).toString());
            log.info("");
            System.exit(0);
        };
    }
    */
}
