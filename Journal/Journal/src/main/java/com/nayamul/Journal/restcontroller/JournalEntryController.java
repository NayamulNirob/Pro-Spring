package com.nayamul.Journal.restcontroller;

import com.nayamul.Journal.dio.JournalEntry;
import com.nayamul.Journal.dio.User;
import com.nayamul.Journal.service.JournalService;
import com.nayamul.Journal.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/journal")
public class JournalEntryController {

    @Autowired
    JournalService journalService;

    @Autowired
    UserService userService;

    @RequestMapping("{userName}")
    public ResponseEntity<?> getAllEntries(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<JournalEntry> all= user.getJournalEntries();
        if(all!=null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
       return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/get")
    public ResponseEntity<List<JournalEntry>> getAllEntries() {
        return ResponseEntity.ok(journalService.getAllEntries());
    }

    @PostMapping("{userName}")
    public ResponseEntity addEntry(@RequestBody JournalEntry journalEntry, @PathVariable String userName) {
        return ResponseEntity.ok(journalService.addEntry(journalEntry,userName));
    }
    @PutMapping ("/update/{userName}/{id}")
    public ResponseEntity<JournalEntry> updateEntry(@RequestBody JournalEntry journalEntry,@PathVariable ObjectId id,@PathVariable String userName) {
        JournalEntry journalEntry1 = journalService.updateEntry(journalEntry,userName);
        return new  ResponseEntity<>(journalEntry1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userName}/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable ObjectId id,@PathVariable String userName) {
        journalService.deleteJournalById(id,userName);
        return  new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId id) {
        return ResponseEntity.ok(journalService.getJournalById(id));
    }
}
