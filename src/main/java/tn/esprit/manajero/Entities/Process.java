package tn.esprit.manajero.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection ="Process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idProcess;
    private String domainModelDiagram;
    private String modelingSessions;
    private String glossaryTerms;
    private String architecturalPatterns;
    private String featureIdentification;
    private String featureBreakdown;
    private String featurePrioritization;
    private String featureDescription;
    private String featureOwnership;
    private String developmentMilestones;
    private String resourceAllocation;
    private String riskManagement;
    private String classDiagrams;
    private String interactionDiagrams;
    private String designReviewNotes;
    private String designArtifacts;
    private String implementationTasks;
    private String codeRepositoryLinks;
    private String unitTests;
    private String codeReviewNotes;
    private String integrationTestingNotes;

}
