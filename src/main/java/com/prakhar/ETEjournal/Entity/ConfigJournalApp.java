package com.prakhar.ETEjournal.Entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document (collection = "config")
public class ConfigJournalApp {
    private String key;
    private String value;

}
