package com.example.artistapi.dao;

import com.example.artistapi.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ArtistDataAccessService implements ArtistDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArtistDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertArtist(UUID id, Artist artist) {
        final String sql = "INSERT INTO artist (id, name) VALUES (?,?)";
        return jdbcTemplate.update(sql,new Object[]{id,artist.getName()});
    }

    @Override
    public List<Artist> selectAllArtists() {
        final String sql = "SELECT id, name FROM artist";
        return jdbcTemplate.query(sql, (resultSet, i)-> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Artist(id,name);
        });
    }

    @Override
    public Optional<Artist> selectArtistById(UUID id) {
        final String sql = "SELECT id, name FROM artist WHERE id = ?";
        Artist artist = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i)-> {
            UUID artistId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Artist(artistId,name);
        });
        return Optional.ofNullable(artist);
    }

    @Override
    public int deleteArtistById(UUID Id) {
        final String sql = "DELETE FROM artist WHERE id = ?";
        return jdbcTemplate.update(sql,new Object[]{Id});
    }

    @Override
    public int updateArtistById(UUID Id, Artist artist) {
        final String sql = "UPDATE artist set name = ? where id = ?";
        return jdbcTemplate.update(sql,new Object[]{Id,artist.getName()});
    }
}
