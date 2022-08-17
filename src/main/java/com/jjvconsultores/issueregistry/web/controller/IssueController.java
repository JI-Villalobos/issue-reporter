package com.jjvconsultores.issueregistry.web.controller;

import com.jjvconsultores.issueregistry.dto.IssueDto;
import com.jjvconsultores.issueregistry.dto.UpdateStateIssueDto;
import com.jjvconsultores.issueregistry.entities.Issue;
import com.jjvconsultores.issueregistry.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService service;

    @PostMapping("/create")
    public ResponseEntity<Issue> saveIssue(@RequestBody IssueDto issueDto){
        return new ResponseEntity<>(service.createIssue(issueDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getAllIssues(){
        return new ResponseEntity<>(service.getIssues(), HttpStatus.OK);
    }

    @GetMapping("/unsolved")
    public ResponseEntity<List<Issue>> getUnsolved(){
        return new ResponseEntity<>(service.getUnsolvedIssues(), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Issue> updateIssue(@RequestBody UpdateStateIssueDto issueDto, @PathVariable int id){
        return new ResponseEntity<>(service.updateIssue(issueDto, id), HttpStatus.CREATED);
    }
}
