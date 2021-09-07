package oracle.java.erpsol.com.kube.issue.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.erpsol.com.kube.issue.model.Issue;
import oracle.java.erpsol.com.kube.issue.repository.IssueRepository;

@Controller
public class IssueController {

	private IssueRepository repository;

    public IssueController(IssueRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/issues")
    public String getAllIssues(Model model) {
        model.addAttribute("issues", repository.findAll());
        return "list-issues";
    }
    @RequestMapping("/AddIssue")
	public String saveUser(@ModelAttribute("issue") Issue issue, Model model) throws IOException {
		repository.save(issue);
		model.addAttribute("msg", "Record Saved successfully..");
		model.addAttribute("issues", repository.findAll());
	
        return "redirect:issues";
		
	}
}
