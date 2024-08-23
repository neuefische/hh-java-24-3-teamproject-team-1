package de.webdev.backend.model;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@With
public record Movie(
        @MongoId
        String id,
        String title,
        String author,
        String genre,
        LocalDateTime publicationDate
) {
}