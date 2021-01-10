package com.example.artistapi.dao;

import com.example.artistapi.model.Artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArtistDao {

    int insertArtist(UUID id, Artist artist); //add artist given ID

    default int insertArtist(Artist artist){ //add artist with randomly generated ID -- POST
        UUID id = UUID.randomUUID();
        return insertArtist(id,artist);
    }
    List<Artist> selectAllArtists(); //GET

    Optional<Artist> selectArtistById(UUID id);

    int deleteArtistById(UUID Id); //DELETE

    int updateArtistById(UUID Id,Artist artist); //PUT
}