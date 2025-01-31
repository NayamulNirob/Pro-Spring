package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.dio.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired
    JournalRepository journalRepository;

    public List<JournalEntry> getAllEntries() {
        return journalRepository.findAll();
    }

    public JournalEntry addEntry(JournalEntry journalEntry) {
      return   journalRepository.save(journalEntry);
    }

    public JournalEntry updateEntry(JournalEntry journalEntry) {
      return  journalRepository.save(journalEntry);
    }

    public void deleteEntry(Long id) {
        journalRepository.deleteById(id);
    }
    public JournalEntry getEntry(Long id) {
        return journalRepository.findById(id).orElse(null);
    }


}
