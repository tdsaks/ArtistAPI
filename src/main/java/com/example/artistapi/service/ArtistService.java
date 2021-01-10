package com.example.artistapi.service;

import com.example.artistapi.dao.ArtistDao;
import com.example.artistapi.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArtistService {

    private final ArtistDao artistDao;

    @Autowired
    public ArtistService(@Qualifier("postgres") /*would say db name*/ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    public int addArtist(Artist artist){
        return artistDao.insertArtist(artist);
    }

    public List<Artist> getAllArtists(){
        return artistDao.selectAllArtists();
    }

    public Optional<Artist> getArtistById(UUID id){
        return artistDao.selectArtistById(id);
    }

    public int deleteArtist(UUID id){
        return artistDao.deleteArtistById(id);
    }

    public int updateArtist(UUID id, Artist newArtist){
        return artistDao.updateArtistById(id,newArtist);
    }
}
