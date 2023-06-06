package com.example.belorz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @NotNull
    private Integer id;
    @NotNull
    private String albumName;
    private Integer totalTracks;
    private Integer releaseYear;
    // the ranking goes from 0 to 100
    private Integer popularity;
    private String genres;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;



}
