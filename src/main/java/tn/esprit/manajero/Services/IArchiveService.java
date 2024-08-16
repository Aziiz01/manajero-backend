package tn.esprit.manajero.Services;

import tn.esprit.manajero.Entities.Archive;

import java.util.List;

public interface IArchiveService {
    Archive addProcessToArchive(String processId);
    Archive addMethodeToArchive(String methodeId);
    void deleteFromArchive(String idArchive);
    void restoreProcessFromArchive(String idArchive);
    void restoreMethodeFromArchive(String idArchive);
    List<Archive> getAllArchives();  // New method to get all archives

}
