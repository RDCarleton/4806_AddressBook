package AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuddyInfoController {
    @Autowired
    BuddyInfoRepository buddyRepo;
    @Autowired
    AddressBookRepository bookRepo;
    /**
    @GetMapping("/newBuddy")
    public String buddyAdd(@RequestParam(value = "name", defaultValue = "empty") String name,
                               @RequestParam(value = "address", defaultValue = "empty") String address) {
        buddyRepo.save(new BuddyInfo(name, address));
        return "table";
    }
    */

}
