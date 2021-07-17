package com.example.object.Service;

import com.example.object.Entity.Projects;
import com.example.object.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository ;
    public List<Projects> getAll(){
        return  projectRepository.findAll();
    }
}
