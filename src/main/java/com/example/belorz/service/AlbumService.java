package com.example.belorz.service;
import com.example.belorz.model.Album;
import com.example.belorz.repository.AlbumRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class AlbumService {
    private final AlbumRepository ar;
    @Autowired
    public AlbumService(AlbumRepository ar){
        this.ar = ar;
    }


    public ResponseEntity addAlbum (Album album){
        try{
            ar.save(album);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public Album getAlbum(int id){
        return ar.findById(id).orElseThrow(() -> new HttpClientErrorException(BAD_REQUEST, "Album not found"));
    }


    public ArrayList<Album> getAll() { // Enviar a la base de datos
        return (ArrayList<Album>) ar.findAll();
    }


    public ResponseEntity deleteAlbum(int id) {
        try {
            ar.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updateAlbum(@NotNull Integer id, Album album){
        try {
            Album a = ar.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST, "Album not found"));
            a.setId(album.getId());
            a.setAlbumName(album.getAlbumName());
            a.setTotalTracks(album.getTotalTracks());
            a.setReleaseYear(album.getReleaseYear());
            a.setPopularity(album.getPopularity());
            a.setGenres(album.getGenres());
            a.setArtist(album.getArtist());
            ar.save(a);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

}
