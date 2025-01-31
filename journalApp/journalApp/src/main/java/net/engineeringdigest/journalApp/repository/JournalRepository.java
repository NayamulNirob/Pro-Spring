package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.dio.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntry, Long> {
}
