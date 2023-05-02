package com.example.belorz.controller;
import com.example.belorz.model.Album;
import com.example.belorz.service.AlbumService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService as;

    @PostMapping("/addAlbum")
    public ResponseEntity addAlbum(@RequestBody final @NotNull Album a){
        return as.addAlbum(a);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateAlbum(@PathVariable final @NotNull Integer id, @RequestBody final  @NotNull Album a){
        return as.updateAlbum(id,a);
    }
    @PostMapping("/{id}/delete")
    public ResponseEntity deleteAlbum(@PathVariable final @NotNull Integer id) {
        return as.deleteAlbum(id);
    }
    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable final @NotNull Integer id){return as.getAlbum(id);}

    @GetMapping("/getAll")
    public List<Album> getAll(){
        return as.getAll();
    }

}
