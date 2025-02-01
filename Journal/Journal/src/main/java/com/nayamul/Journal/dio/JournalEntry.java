package com.nayamul.Journal.dio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JournalEntry {

    @Id
    private ObjectId id;
    private String title;
    private String author;
    private String journal;
    private LocalDateTime date;
}
