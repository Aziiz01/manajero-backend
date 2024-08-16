package tn.esprit.manajero.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.manajero.Entities.Archive;
import tn.esprit.manajero.Services.ArchiveService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/archive")
public class ArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @PostMapping("/addProcessToArchive/{processId}")
    public Archive addProcessToArchive(@PathVariable String processId) {
        return archiveService.addProcessToArchive(processId);
    }

    @PostMapping("/addMethodeToArchive/{methodeId}")
    public Archive addMethodeToArchive(@PathVariable String methodeId) {
        return archiveService.addMethodeToArchive(methodeId);
    }

    @DeleteMapping("/deleteFromArchive/{idArchive}")
    public void deleteFromArchive(@PathVariable String idArchive) {
        archiveService.deleteFromArchive(idArchive);
    }
    @PostMapping("/restoreProcessFromArchive/{idArchive}")
    public void restoreProcessFromArchive(@PathVariable String idArchive) {
        archiveService.restoreProcessFromArchive(idArchive);
    }

    @PostMapping("/restoreMethodeFromArchive/{idArchive}")
    public void restoreMethodeFromArchive(@PathVariable String idArchive) {
        archiveService.restoreMethodeFromArchive(idArchive);
    }
    @GetMapping("/getAllArchives")
    public List<Archive> getAllArchives() {
        return archiveService.getAllArchives();
    }
}
