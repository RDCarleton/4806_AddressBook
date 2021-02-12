package AddressBook;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @OneToMany(fetch=FetchType.EAGER)
    private List<BuddyInfo> buddyInfo;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    public AddressBook(){
        this.buddyInfo = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo aBuddyInfo) {
        if (aBuddyInfo != null) {
            this.buddyInfo.add(aBuddyInfo);
        }
    }

    public void removeBuddy(int id){
        buddyInfo.remove(id);
    }
    public void removeByName(String name){
        int i = -1;
        for (BuddyInfo b: buddyInfo) {
            if(b.getName().equals(name)){
                i = buddyInfo.indexOf(b);
            }
        }
        if (i > -1){
            buddyInfo.remove(i);
        }
    }
    public int getBuddyAmount(){
        return buddyInfo.size();
    }

    public BuddyInfo getBuddy(int index) {
        if (index >= 0 && index < this.buddyInfo.size()) {
            return buddyInfo.get(index);
        }
        return null;
    }

    public void setID(long ID){
        this.ID = ID;
    }

    public long getID(){
        return ID;
    }

    public String toString(){
        String s ="[\"ID\": " + this.getID() + ", \"BuddyInfo\": ";
        for (BuddyInfo b: buddyInfo) {
           s = s.concat(b.toString());
        }
        s = s.concat("]");
        return s.toString();
    }

    public static void main(String[] args){
        AddressBook addressBook = new AddressBook();
        addressBook.setID(1);
        BuddyInfo buddyInfo1 = new BuddyInfo("Mark", "Vancouver");
        BuddyInfo buddyInfo2 = new BuddyInfo("Bob", "Ottawa");
        BuddyInfo buddyInfo3 = new BuddyInfo("Joe", "Toronto");
        addressBook.addBuddy(buddyInfo1);
        addressBook.addBuddy(buddyInfo2);
        addressBook.addBuddy(buddyInfo3);
        System.out.println(addressBook.toString());
    }
}
