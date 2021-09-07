package oracle.java.erpsol.com.kube.directory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import oracle.java.erpsol.com.kube.directory.model.Addressbook;


@Repository
public interface AddressbookRepository  extends MongoRepository<Addressbook, String> {

}


