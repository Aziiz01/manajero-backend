package tn.esprit.manajero.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.manajero.Entities.Archive;

@Repository

public interface ArchiveRepository extends MongoRepository<Archive,String> {
}
