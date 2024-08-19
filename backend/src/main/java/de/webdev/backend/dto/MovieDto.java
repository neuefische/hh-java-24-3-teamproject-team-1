package de.webdev.backend.dto;

import java.time.LocalDateTime;

public record MovieDto(
        String title,
        String author,
        String genre,
        LocalDateTime publicationDate
) {
}
