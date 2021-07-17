package com.example.object.Controller;

import com.example.object.Entity.Issue;
import com.example.object.Service.IssueService;
import com.example.object.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/project")
public class Project {
    @Autowired
    private ProjectService projectService;


    @Autowired
    private IssueService issueService;
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PM') or hasRole('ROLE_MANAGER')")
    public ResponseEntity<List<Project>> All (){
        List list = projectService.getAll();
        return  new ResponseEntity<List<Project>>(list, HttpStatus.OK);
    }


    @GetMapping("/get")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PM') or hasRole('ROLE_MANAGER')")
    public ResponseEntity<List<Issue>> Get (){
        List list = issueService.getAll();
        return  new ResponseEntity<List<Issue>>(list, HttpStatus.OK);
    }
}
