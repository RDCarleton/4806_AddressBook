package AddressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class BuddyInfo {
    private String name;
    private String address;

    public BuddyInfo(){};
    public BuddyInfo(String name, String address) {
        setName(name);
        setAddress(address);
    }
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
        else {
            name = "Empty";
        }
    }
    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
        else {
            address = "Empty";
        }
    }
    @Id
    public String getName() {
        return this.name;
    }
    @GeneratedValue
    public String getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return "{\"name\" :" + " "+ name + ", \"address\" :" + " "+address +"}";
    }
}
