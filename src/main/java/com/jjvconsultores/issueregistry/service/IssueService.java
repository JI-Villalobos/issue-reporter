package com.jjvconsultores.issueregistry.service;

import com.jjvconsultores.issueregistry.dto.IssueDto;
import com.jjvconsultores.issueregistry.dto.UpdateStateIssueDto;
import com.jjvconsultores.issueregistry.entities.Issue;

import java.util.List;
import java.util.Optional;

public interface IssueService {
    Issue createIssue(IssueDto issue);
    List<Issue> getIssues();
    List<Issue> getUnsolvedIssues();
    Optional<Issue> getIssuesById(Integer id);
    Issue updateIssue(UpdateStateIssueDto issue, Integer id);
}
