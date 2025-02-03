package com.nayamul.Journal.service;

import com.nayamul.Journal.dio.JournalEntry;
import com.nayamul.Journal.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;


    public List<JournalEntry> getAllEntries() {
        return journalRepository.findAll();
    }

    public JournalEntry addEntry(JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        return   journalRepository.save(journalEntry);
    }

    public JournalEntry updateEntry(JournalEntry journalEntry,ObjectId id) {
        if(journalEntry.getUpdatedDate()==null){
            journalEntry.setUpdatedDate(LocalDateTime.now());
        }
        return journalRepository.save(journalEntry);
    }

    public JournalEntry getJournalById(ObjectId id) {
        return journalRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO Journal Found with this id"+id)
        );
    }

    public void deleteJournalById(ObjectId id) {
        journalRepository.findById(id).orElseThrow(
                () -> new RuntimeException("NO Journal Found with this id" + id)
        );
        journalRepository.deleteById(id);

    }


}
