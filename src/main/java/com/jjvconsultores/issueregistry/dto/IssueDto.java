package com.jjvconsultores.issueregistry.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IssueDto {
    private String user;
    private String issue;
    private Boolean solved;
    private Integer status;
}
