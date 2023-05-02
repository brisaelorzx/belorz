package com.example.belorz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artist {
    @Id
    @NotNull
    private Integer id;
    @NotNull
    private String nameArtist;
    private Integer age;
    // the ranking goes from 0 to 100
    private Integer popularity;

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private List<Album> albums;

}
