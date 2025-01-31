package net.engineeringdigest.journalApp.dio;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntry {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
   private String author;
   private String journal;
   private Date date;


}
