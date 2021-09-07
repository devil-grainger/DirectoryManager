package oracle.java.erpsol.com.kube.issue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import oracle.java.erpsol.com.kube.issue.repository.IssueRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = IssueRepository.class)
public class IssueTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackerApplication.class, args);
	}

}
