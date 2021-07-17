package com.example.object.Service;

import com.example.object.Entity.Issue;
import com.example.object.Entity.Projects;
import com.example.object.Repository.IssueRepository;
import com.example.object.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository ;
    public List<Issue> getAll(){
        return  issueRepository.findAll();
    }
}
