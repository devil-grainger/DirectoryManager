package oracle.java.erpsol.com.kube.issue.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "issues")
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
	
	@Id
	@Setter
	@Getter
    private String id;
	@Setter
	@Getter
    private  String description;
	@Setter
	@Getter
    private  int severity;
	@Setter
	@Getter
    private  String assignee;
    /*
	public Issue(String description, int severity, String assignee) {
        this.description = description;
        this.severity = severity;
        this.assignee = assignee;
    }*/

}
