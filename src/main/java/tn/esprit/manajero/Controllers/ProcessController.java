package tn.esprit.manajero.Controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.manajero.Entities.Process;
import tn.esprit.manajero.Services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/processes")
public class ProcessController {

     ProcessService processService;

    @PostMapping
    public ResponseEntity<Process> createProcess(@RequestBody Process process) {
        Process createdProcess = processService.createProcess(process);
        return ResponseEntity.ok(createdProcess);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Process> getProcessById(@PathVariable String id) {
        Process process = processService.getProcessById(id);
        return process != null ? ResponseEntity.ok(process) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Process>> getAllProcesses() {
        List<Process> processes = processService.getAllProcesses();
        return ResponseEntity.ok(processes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Process> updateProcess(@PathVariable String id, @RequestBody Process process) {
        Process updatedProcess = processService.updateProcess(id, process);
        return updatedProcess != null ? ResponseEntity.ok(updatedProcess) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcess(@PathVariable String id) {
        processService.deleteProcess(id);
        return ResponseEntity.noContent().build();
    }
}
