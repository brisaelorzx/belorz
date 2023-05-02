package com.example.belorz.repository;

import com.example.belorz.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository <Artist, Integer> {
}
