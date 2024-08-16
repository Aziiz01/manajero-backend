package tn.esprit.manajero.Services;

import tn.esprit.manajero.Entities.Process;

import java.util.List;

public interface IProcessService {
    Process createProcess(Process process);

    Process getProcessById(String id);

    List<Process> getAllProcesses();

    Process updateProcess(String id, Process process);

    void deleteProcess(String id);
    double calculateTaskCompletionRate(String processId);
    double calculateFeatureImplementationProgress(String processId);
    double calculateDesignReviewEffectiveness(String processId);
    public double calculateDailyAdvancementRate(String processId);
    }
