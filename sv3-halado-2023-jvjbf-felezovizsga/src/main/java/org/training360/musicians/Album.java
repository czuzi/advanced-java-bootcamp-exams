package org.training360.musicians;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class Album {

    private String title;
    private LocalDate releaseDate;

    public Album() {
    }

    public Album(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
