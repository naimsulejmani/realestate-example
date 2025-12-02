package com.example.realestate.repositories;

import com.example.realestate.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {

    public List<Property> findAllByType(String type);
    // SELECT * FROM properties WHERE type = ?
    public List<Property> findAllByTitleContainsOrLocationContainsOrDescriptionContains(String title,
                                                                                    String location,
                                                                                    String description);
    // SELECT * FROM properties WHERE title LIKE ? OR location LIKE ? OR content LIKE ?

    public List<Property> findAllByTypeAndTitleContainsOrLocationContainsOrDescriptionContains(
            String type,
            String title,
            String location,
            String description
    );
    // SELECT * FROM properties WHERE type = ? AND title LIKE ? OR location LIKE ? OR description LIKE ?
}










