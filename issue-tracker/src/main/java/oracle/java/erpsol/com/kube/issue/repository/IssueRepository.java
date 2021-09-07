package oracle.java.erpsol.com.kube.issue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import oracle.java.erpsol.com.kube.issue.model.Issue;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {

}
