package com.jjvconsultores.issueregistry.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "issues")
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;
    @Column(name = "username", nullable = false)
    private String user;
    @Column(name = "issue", nullable = false)
    private String issue;
    @Column(name = "solved", nullable = false)
    private Boolean solved;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "registry", nullable = false)
    private String registry;
}
