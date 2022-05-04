package com.amdocs.ensemble.entity;

import com.amdocs.ensemble.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CommentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq2")
    @GenericGenerator(
            name = "project_seq2",
            strategy = "com.amdocs.ensemble.generator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CMT-"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    private String userName;
    private String commentDate;
    private String comment;
}
