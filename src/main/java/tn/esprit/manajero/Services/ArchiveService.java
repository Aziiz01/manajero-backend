package tn.esprit.manajero.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.manajero.Entities.Archive;
import tn.esprit.manajero.Entities.Process;
import tn.esprit.manajero.Entities.Methode;
import tn.esprit.manajero.Repositories.ArchiveRepository;
import tn.esprit.manajero.Repositories.MethodeRepository;
import tn.esprit.manajero.Repositories.ProcessRepostiory;

import java.util.List;

@Service
public class ArchiveService implements IArchiveService {

    @Autowired
    private ArchiveRepository archiveRepository;

    @Autowired
    private ProcessRepostiory processRepository;

    @Autowired
    private MethodeRepository methodeRepository;

    @Override
    public Archive addProcessToArchive(String processId) {
        Process process = processRepository.findById(processId).orElseThrow(() -> new RuntimeException("Process not found"));

        Archive archive = new Archive();
        archive.setContent(process);
        Archive savedArchive = archiveRepository.save(archive);

        processRepository.delete(process);

        return savedArchive;
    }

    @Override
    public Archive addMethodeToArchive(String methodeId) {
        Methode methode = methodeRepository.findById(methodeId).orElseThrow(() -> new RuntimeException("Methode not found"));

        Archive archive = new Archive();
        archive.setContent(methode);
        Archive savedArchive = archiveRepository.save(archive);

        methodeRepository.delete(methode);

        return savedArchive;
    }

    @Override
    public void deleteFromArchive(String idArchive) {
        Archive archive = archiveRepository.findById(idArchive).orElseThrow(() -> new RuntimeException("Archive not found"));
        archiveRepository.delete(archive);
    }
    @Override
    public void restoreProcessFromArchive(String idArchive) {
        Archive archive = archiveRepository.findById(idArchive).orElseThrow(() -> new RuntimeException("Archive not found"));
        if (archive.getContent() instanceof Process) {
            Process process = (Process) archive.getContent();
            processRepository.save(process);  // Restore process to the Process collection
            archiveRepository.delete(archive);  // Remove the archived entry
        } else {
            throw new RuntimeException("Archived content is not a Process");
        }
    }
    @Override
    public List<Archive> getAllArchives() {
        return archiveRepository.findAll();  // Fetch all archives
    }
    @Override
    public void restoreMethodeFromArchive(String idArchive) {
        Archive archive = archiveRepository.findById(idArchive).orElseThrow(() -> new RuntimeException("Archive not found"));
        if (archive.getContent() instanceof Methode) {
            Methode methode = (Methode) archive.getContent();
            methodeRepository.save(methode);  // Restore methode to the Methode collection
            archiveRepository.delete(archive);  // Remove the archived entry
        } else {
            throw new RuntimeException("Archived content is not a Methode");
        }
    }
}
