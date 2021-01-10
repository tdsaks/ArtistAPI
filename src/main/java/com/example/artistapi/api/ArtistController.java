package com.example.artistapi.api;

import com.example.artistapi.model.Artist;
import com.example.artistapi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/artist")
@RestController
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public void addArtist(@RequestBody Artist artist){
        artistService.addArtist(artist);
    }

    @GetMapping
    public List<Artist> getAllArtists(){
        return artistService.getAllArtists();
    }

    @GetMapping(path = "{id}") //pass the /id in the url as a path variable to UUID and call the method
    public Artist getArtistById(@PathVariable("id") UUID id){
        return artistService.getArtistById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deleteArtistById(@PathVariable("id") UUID id){
        artistService.deleteArtist(id);
    }

    @PutMapping(path = "{id}")
    public void updateArtistById(@PathVariable("id") UUID id, @RequestBody Artist artistToUpdate){
        artistService.updateArtist(id,artistToUpdate);
    }
}
