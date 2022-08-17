package com.jjvconsultores.issueregistry.service;

import com.jjvconsultores.issueregistry.dto.IssueDto;
import com.jjvconsultores.issueregistry.dto.UpdateStateIssueDto;
import com.jjvconsultores.issueregistry.entities.Issue;
import com.jjvconsultores.issueregistry.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IssueServiceImplementation implements IssueService{
    private final IssueRepository repository;

    @Override
    public Issue createIssue(IssueDto issueDto) {
        Issue issue = new Issue();
        issue.setUser(issueDto.getUser());
        issue.setIssue(issueDto.getIssue());
        issue.setSolved(issueDto.getSolved());
        issue.setStatus(issueDto.getStatus());
        issue.setRegistry(String.valueOf(UUID.randomUUID()));

        return repository.save(issue);
    }

    @Override
    public List<Issue> getIssues() {
        return repository.findAll();
    }

    @Override
    public List<Issue> getUnsolvedIssues() {
        return repository.findBySolvedFalse();
    }

    @Override
    public Optional<Issue> getIssuesById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Issue updateIssue(UpdateStateIssueDto issue, Integer id) {
        return repository.findById(id).map(i -> {
            i.setSolved(issue.getSolved());
            i.setStatus(issue.getStatus());

            return repository.save(i);
        }).get();
    }
}
