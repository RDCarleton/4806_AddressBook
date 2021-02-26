package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DefaultController {
    @Autowired
    AddressBookRepository bookRepo;
    @Autowired
    BuddyInfoRepository buddyRepo;
    AddressBook test;
    AddressBookController controller;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/newBook")
    @ResponseStatus(HttpStatus.CREATED)
    public String bookJSON() {
        test = new AddressBook();
        bookRepo.save(test);
        return "newBook";
    }

    @PostMapping("/addBuddy")
    @ResponseStatus(HttpStatus.CREATED)
    public String addJSONBuddy(@RequestBody String name, @RequestBody String address) {
        BuddyInfo b = new BuddyInfo(name, address);
        buddyRepo.save(b);
        AddressBook test = bookRepo.findByID(1L);
        test.addBuddy(b);
        bookRepo.save(test);
        return "newBuddy";
    }

    @RequestMapping("/addMoreBuddies")
    public String addMoreBuddies() {
        return "newBook";
    }
}