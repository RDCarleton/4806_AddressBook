package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {
    @Autowired
    AddressBookRepository bookRepo;

    @RequestMapping("/result")
    public String showAddressBook(Model model){
        model.addAttribute("addressBooks", bookRepo.findByID(1L));
        return "table";
    }
}
