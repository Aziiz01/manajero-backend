package tn.esprit.manajero.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.manajero.Entities.Process;
import tn.esprit.manajero.Repositories.ProcessRepostiory;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProcessService implements IProcessService{
    ProcessRepostiory processRepository;

    @Override
    public Process createProcess(Process process) {
    return  processRepository.save(process);
    }



    @Override
    public Process getProcessById(String id) {
        return processRepository.findById(id).orElse(null);
    }

    @Override
    public List<Process> getAllProcesses() {
        return processRepository.findAll();
    }


    @Override
    public Process updateProcess(String id, Process process) {
        if (processRepository.existsById(id)) {
            process.setIdProcess(id);
            return processRepository.save(process);
        }
        return null;
    }

    @Override
    public void deleteProcess(String id) {
        processRepository.deleteById(id);
    }
}
