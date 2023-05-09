package com.example.belorz.controller;
import com.example.belorz.model.Artist;
import com.example.belorz.service.ArtistService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
@CrossOrigin(origins = "*")
public class ArtistController {

    @Autowired
    private ArtistService as;

    @PostMapping("/addArtist")
    public ResponseEntity addArtist(@RequestBody final @NotNull Artist a){
        return as.addArtist(a);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateArtist(@PathVariable final @NotNull Integer id, @RequestBody final  @NotNull Artist a){
        return as.updateArtist(id,a);
    }
    @PostMapping("/{id}/delete")
    public ResponseEntity deleteArtist(@PathVariable final @NotNull Integer id) {
        return as.deleteArtist(id);
    }
    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable final @NotNull Integer id){
        return as.getArtist(id);
    }


    @GetMapping("/getAll")
    public List<Artist> getAll(){
        return as.getAll();
    }

}
