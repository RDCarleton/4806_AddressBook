package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    @Autowired
    AddressBookRepository bookRepo;
    @Autowired
    BuddyInfoRepository buddyRepo;
    AddressBook test;

    @PostMapping("/newJSONBook")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressBook bookJSON(){
        test = new AddressBook();
        bookRepo.save(test);
        return test;
    }

    @PostMapping("/addJSONBuddy")
    @ResponseStatus(HttpStatus.CREATED)
    public BuddyInfo addJSONBuddy(@RequestBody BuddyInfo buddy){
        BuddyInfo b = new BuddyInfo(buddy.getName(), buddy.getAddress());
        buddyRepo.save(b);
        AddressBook test = bookRepo.findByID(1L);
        test.addBuddy(b);
        bookRepo.save(test);
        return b;
    }

    @PostMapping("/removeJSONBuddy")
    @ResponseStatus(HttpStatus.CREATED)
    public BuddyInfo removeJSONBuddy(@RequestBody BuddyInfo buddy) {
        BuddyInfo b = new BuddyInfo(buddy.getName(), buddy.getAddress());
        AddressBook test = bookRepo.findByID(1L);
        test.removeByName(b.getName());
        bookRepo.save(test);
        return b;
    }
    /**
    @GetMapping("/newBook")
    public String newBook(){
        bookRepo.save(new AddressBook());
        return "table";
    }

    @GetMapping("/addBuddy")
    public String buddyAdd(@RequestParam(value="name", required=true) String name,
                           @RequestParam(value="id", required = true) int bookID){
        if(bookID > 0) {
            addToBook(name, bookID);
        }
        return "table";
    }

    @GetMapping("/removeBuddy")
    public String buddyRemove(@RequestParam(value="id", required=true) int id,
                              @RequestParam(value="bookID", required = true) int bookID){
        if(id >0 && bookID > 0){
            removeFromBook(id, bookID);
        }
        return "table";
    }

    public void addToBook(String name, int bookID){
        test = bookRepo.findByID((long) bookID);
        test.addBuddy(buddyRepo.findByName(name));
        bookRepo.save(test);
    }

    public void removeFromBook(int id, int bookID){
        test = bookRepo.findByID((long) bookID);
        test.removeBuddy(id);
        bookRepo.save(test);
    }

    @GetMapping("/index")
    public String showAddressBook(Model model){
        model.addAttribute("addressBooks", bookRepo.findAll());
        return "table";
    }
    */
}