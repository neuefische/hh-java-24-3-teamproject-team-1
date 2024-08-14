package de.webdev.backend.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public record Movie(
        @MongoId
        String id,
        String title,
        String author
) {
}
