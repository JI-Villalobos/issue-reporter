package com.jjvconsultores.issueregistry.repository;

import com.jjvconsultores.issueregistry.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
    List<Issue> findBySolvedFalse();
}
