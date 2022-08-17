package com.jjvconsultores.issueregistry.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateStateIssueDto {
    private Boolean solved;
    private Integer status;
}
