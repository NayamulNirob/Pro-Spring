package com.nayamul.Journal.restcontroller;

import com.nayamul.Journal.dio.JournalEntry;
import com.nayamul.Journal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class JournalEntryController {

    @Autowired
    JournalService journalService;

    @RequestMapping("/get")
    public ResponseEntity<List<JournalEntry>> getAllEntries() {
        return ResponseEntity.ok(journalService.getAllEntries());
    }

    @PostMapping("/add")
    public ResponseEntity<JournalEntry> addEntry(@RequestBody JournalEntry journalEntry) {
        return ResponseEntity.ok(journalService.addEntry(journalEntry));
    }
}
