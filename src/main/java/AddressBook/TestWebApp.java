package AddressBook;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import AddressBook.AddressBookController;
import AddressBook.AddressBookRepository;
import AddressBook.BuddyInfo;
import AddressBook.BuddyInfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.Assert;

@WebMvcTest(AddressBookController.class)
public class TestWebApp {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    AddressBookRepository bookRepo;
    @MockBean
    BuddyInfoRepository buddyRepo;

    @Test
    public void newBookTest() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/newJSONBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ }")).andExpect(status().isCreated()).andReturn();
        String returnResult = result.getResponse().getContentAsString();
        System.out.println(returnResult);
    }

    @Test
    public void addBuddyTest() throws Exception {
        BuddyInfo b = new BuddyInfo("Max", "Ottawa");
        AddressBook a = new AddressBook();
        AddressBook a2 = a;
        a2.addBuddy(b);
        Mockito.when(buddyRepo.save(b)).thenReturn(b);
        Mockito.when(bookRepo.findByID(1L)).thenReturn(a);
        Mockito.when(bookRepo.save(a2)).thenReturn(a2);
        MvcResult result = this.mockMvc.perform(post("/addJSONBuddy")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Max\", \"address\": \"Ottawa\"}"))
                .andExpect(status().isCreated()).andReturn();
        String returnResult = result.getResponse().getContentAsString();
        System.out.println(returnResult);
    }

    @Test
    public void removeBuddyTest() throws Exception {
        BuddyInfo b = new BuddyInfo("Joe", "Ottawa");
        AddressBook a = new AddressBook();
        AddressBook a2 = a;
        a.addBuddy(b);
        Mockito.when(bookRepo.save(a)).thenReturn(a2);
        Mockito.when(bookRepo.findByID(1L)).thenReturn(a);
        MvcResult result = this.mockMvc.perform(post("/removeJSONBuddy")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Joe\", \"address\": \"Ottawa\"}"))
                .andExpect(status().isCreated()).andReturn();
        String returnResult = result.getResponse().getContentAsString();
        System.out.println(returnResult);
    }

}