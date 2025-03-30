package net.engineeringdigest.journalApp.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
//import java.util.Date;

@Document(collection = "journal_entries")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Builder
//@Slf4j
@Data
public class JournalEntry {  // POJO - plain old java object
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

}
