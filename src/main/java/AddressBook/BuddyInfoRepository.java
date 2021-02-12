package AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddyInfo", path = "buddyInfo")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, String>{
    BuddyInfo findByName(String name);
}
