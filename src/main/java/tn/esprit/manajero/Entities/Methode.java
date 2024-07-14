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
@Document(collection ="Methode")
public class Methode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idMethode;
    String introduction;
    String why;
    String what;
    String how ;
    String whatif ;
    String conclusion;

}
