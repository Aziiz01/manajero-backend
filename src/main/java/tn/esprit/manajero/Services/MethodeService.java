package tn.esprit.manajero.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.manajero.Entities.Methode;
import tn.esprit.manajero.Repositories.MethodeRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MethodeService implements IMethodeService {
    MethodeRepository methodeRepository;
    @Override
    public Methode addMethode(Methode methode) {
        return methodeRepository.save(methode);


    }
    @Override
    public List<Methode> getAllMethods() {
        return (List<Methode>) methodeRepository.findAll();
    }
    @Override
    public Methode getMethodeById(String idMethode) {
        return methodeRepository.findById(idMethode).get();
    }
    @Override
    public void deleteMethode(String idMethode) {
        methodeRepository.deleteById(idMethode);
    }

    @Override
    public Methode updateMethode(String id, Methode newMethode) {
        return methodeRepository.findById(id).map(existingMethode -> {
            if (newMethode.getIntroduction() != null) {
                existingMethode.setIntroduction(newMethode.getIntroduction());
            }
            if (newMethode.getWhy() != null) {
                existingMethode.setWhy(newMethode.getWhy());
            }
            if (newMethode.getWhat() != null) {
                existingMethode.setWhat(newMethode.getWhat());
            }
            if (newMethode.getHow() != null) {
                existingMethode.setHow(newMethode.getHow());
            }
            if (newMethode.getWhatif() != null) {
                existingMethode.setWhatif(newMethode.getWhatif());
            }
            if (newMethode.getConclusion() != null) {
                existingMethode.setConclusion(newMethode.getConclusion());
            }
            return methodeRepository.save(existingMethode);
        }).orElse(null);
    }


}
