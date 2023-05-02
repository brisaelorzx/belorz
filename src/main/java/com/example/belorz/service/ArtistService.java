package com.example.belorz.service;

import com.example.belorz.model.Artist;
import com.example.belorz.repository.ArtistRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class ArtistService {
    private final ArtistRepository ar;
    @Autowired
    public ArtistService(ArtistRepository ar){
        this.ar = ar;
    }


    public ResponseEntity addArtist (Artist artist){
        try{
            ar.save(artist);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public Artist getArtist(int id){
        return ar.findById(id).orElseThrow(() -> new HttpClientErrorException(BAD_REQUEST, "Artist not found"));
    }


    public ArrayList<Artist> getAll() { // Enviar a la base de datos
        return (ArrayList<Artist>) ar.findAll();
    }


    public ResponseEntity deleteArtist(int id) {
        try {
            ar.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updateArtist(@NotNull Integer id, Artist artist){
        try {
            Artist a = ar.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST, "Artist not found"));
            a.setId(artist.getId());
            a.setNameArtist(artist.getNameArtist());
            a.setAge(artist.getAge());
            a.setPopularity(artist.getPopularity());
            ar.save(a);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
}
