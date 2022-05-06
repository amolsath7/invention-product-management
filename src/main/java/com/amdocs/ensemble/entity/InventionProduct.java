package com.amdocs.ensemble.entity;

import com.amdocs.ensemble.generator.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invention_product")
public class InventionProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @GenericGenerator(
            name = "project_seq",
            strategy = "com.amdocs.ensemble.generator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "MET-"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    @Column(unique = true)
    private String projectId;
    @Column(unique = true)
    private String projectTitle;
    private String projectDescription;
    private String status;
    private String complexity;
    private String usefulInfo;

   /*  @OneToMany(targetEntity = CommentInfo.class, cascade = CascadeType.ALL)
     @JoinColumn(name = "comments_fk", referencedColumnName = "projectId")
     private List<CommentInfo> comments;*/
    private String submittedBy;

    private String comments;

    @OneToMany(targetEntity = TeamMemberInfo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamMember_fk", referencedColumnName = "projectId")
    private List<TeamMemberInfo> teamMember;
    private String startDate;
    private String endDate;


    @Override
    public String toString() {
        return "InventionProduct{" +
                "projectId='" + projectId + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", status='" + status + '\'' +
                ", complexity='" + complexity + '\'' +
                ", usefulInfo='" + usefulInfo + '\'' +
                ", comments=" + comments +
                ", submittedBy='" + submittedBy + '\'' +
                ", teamMember='" + teamMember + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
