package tn.esprit.manajero.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.manajero.Entities.Process;
import tn.esprit.manajero.Repositories.ProcessRepostiory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProcessService implements IProcessService{
    ProcessRepostiory processRepository;

    @Override
    public double calculateTaskCompletionRate(String processId) {
        Optional<Process> processOpt = processRepository.findById(processId);
        if (processOpt.isPresent()) {
            Process process = processOpt.get();
            int totalTasks = process.getToDo().size() + process.getInProgress().size() + process.getDone().size();
            int completedTasks = process.getDone().size();
            return totalTasks > 0 ? (completedTasks / (double) totalTasks) * 100 : 0;
        }
        return 0;
    }

    @Override
    public double calculateFeatureImplementationProgress(String processId) {
        Optional<Process> processOpt = processRepository.findById(processId);
        if (processOpt.isPresent()) {
            Process process = processOpt.get();
            int totalFeatures = process.getFeatureBreakdown().split(",").length;
            // Assuming each feature is marked as "done" in the feature description or another related field.
            int implementedFeatures = (int) process.getFeatureDescription().lines().filter(line -> line.contains("done")).count();
            return totalFeatures > 0 ? (implementedFeatures / (double) totalFeatures) * 100 : 0;
        }
        return 0;
    }

    @Override
    public double calculateDesignReviewEffectiveness(String processId) {
        Optional<Process> processOpt = processRepository.findById(processId);
        if (processOpt.isPresent()) {
            Process process = processOpt.get();
            int totalIssues = process.getDesignReviewNotes().split(",").length;
            int resolvedIssues = (int) process.getDesignReviewNotes().lines().filter(line -> line.contains("resolved")).count();
            return totalIssues > 0 ? (resolvedIssues / (double) totalIssues) * 100 : 0;
        }
        return 0;
    }

    @Override
    public double calculateDailyAdvancementRate(String processId) {
        Optional<Process> processOpt = processRepository.findById(processId);
        if (processOpt.isPresent()) {
            Process process = processOpt.get();
            LocalDate startDate = process.getStartDate();
            long daysSinceStart = java.time.temporal.ChronoUnit.DAYS.between(startDate, LocalDate.now());
            int completedTasks = process.getDone().size();
            return daysSinceStart > 0 ? (completedTasks / (double) daysSinceStart) : 0;
        }
        return 0;
    }


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
