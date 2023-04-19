package org.training360.musicians;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bands")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "band_name")
    private String bandName;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ElementCollection(targetClass = Album.class)
    private List<Album> discography = new ArrayList<>();

    @OneToMany(mappedBy = "band", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Musician> musicians = new HashSet<>();

    public Band() {
    }

    public Band(String bandName, Genre genre) {
        this.bandName = bandName;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String name) {
        this.bandName = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Album> getDiscography() {
        return discography;
    }

    public void setDiscography(List<Album> albums) {
        this.discography = albums;
    }

    public void addAlbum(Album album) {
        discography.add(album);
    }

    public Set<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(Set<Musician> musicians) {
        this.musicians = musicians;
    }

    public void addMusician(Musician musician) {
        musicians.add(musician);
        musician.setBand(this);
    }
}
