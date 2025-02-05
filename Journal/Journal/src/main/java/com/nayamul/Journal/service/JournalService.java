package com.nayamul.Journal.service;

import com.nayamul.Journal.dio.JournalEntry;
import com.nayamul.Journal.dio.User;
import com.nayamul.Journal.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private UserService userService;


    public List<JournalEntry> getAllEntries() {
        return journalRepository.findAll();
    }

    @Transactional
    public JournalEntry addEntry(JournalEntry journalEntry, String userName) {
        User user = userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        User user1 = userService.addUser(user);
        return user1.getJournalEntries().get(0);
    }

    public JournalEntry updateEntry(JournalEntry journalEntry, String userName) {
        if(journalEntry.getUpdatedDate()==null || journalEntry.getUpdatedDate().isBefore(LocalDateTime.now())){
            journalEntry.setUpdatedDate(LocalDateTime.now());
        }
        return journalRepository.save(journalEntry);
    }

    public JournalEntry getJournalById(ObjectId id) {
        return journalRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO Journal Found with this id"+id)
        );
    }

    public void deleteJournalById(ObjectId id, String userName) {
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
        userService.addUser(user);
        journalRepository.findById(id).orElseThrow(
                () -> new RuntimeException("NO Journal Found with this id" + id)
        );
        journalRepository.deleteById(id);

    }


}
