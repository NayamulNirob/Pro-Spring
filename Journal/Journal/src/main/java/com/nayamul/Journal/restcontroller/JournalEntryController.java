package com.nayamul.Journal.restcontroller;

import com.nayamul.Journal.dio.JournalEntry;
import com.nayamul.Journal.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/journal")
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
    @PutMapping ("/update/{id}")
    public ResponseEntity<JournalEntry> updateEntry(@RequestBody JournalEntry journalEntry,@PathVariable ObjectId id) {
        return ResponseEntity.ok(journalService.updateEntry(journalEntry,journalEntry.getId()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable ObjectId id) {
        journalService.deleteJournalById(id);
        return  new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }


//    @GetMapping("/get/{author}")
//    public ResponseEntity<List<JournalEntry>> getEntryByAuthor(@PathVariable String author) {
//        return ResponseEntity.ok(journalService.getAllEntries().stream().filter(e-> Objects.equals(e.getAuthor(),author)).toList());
//    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId id) {
        return ResponseEntity.ok(journalService.getJournalById(id));
    }
}
