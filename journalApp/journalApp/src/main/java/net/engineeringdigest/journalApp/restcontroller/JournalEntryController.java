package net.engineeringdigest.journalApp.restcontroller;

import net.engineeringdigest.journalApp.dio.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "api")
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

    @PutMapping("update/{id}")
    public ResponseEntity<JournalEntry>updateEntry(@RequestBody JournalEntry journalEntry, @PathVariable long id ) {
        return ResponseEntity.ok(journalService.updateEntry(journalEntry,id));
    }
}
