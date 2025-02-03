package com.nayamul.Journal.dio;

import com.mongodb.client.model.Collation;
import com.mongodb.lang.NonNull;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection="users")

public class User {

    @Id
    private ObjectId id;
    @NonNull
    @Indexed(unique = true)
    private String userName;
    private String userPassword;
    @Indexed(unique = true)
    @NonNull
    private String email;

    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();

}
