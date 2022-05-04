package com.amdocs.ensemble.entity;

import com.amdocs.ensemble.generator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teamMemberInfo")
public class TeamMemberInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq3")
    @GenericGenerator(
            name = "project_seq3",
            strategy = "com.amdocs.ensemble.generator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TEM-"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    private String teamMemberName;
}
