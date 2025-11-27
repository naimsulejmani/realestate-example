package com.example.realestate.repositories;

import com.example.realestate.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.annotation.JsonAppend;

import java.util.List;
import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {

    public List<Property> findAllByBedrooms(int bedroom);
    //SELECT * FROM properties WHERE bedrooms = ?
    public List<Property> findAllByBedroomsOrderByPriceAsc(int bedroom);
    //SELECT * FROM properties WHERE bedrooms = ? ORDER BY price ASC

    public List<Property> findAllByPriceBetween
            (double minPrice, double maxPrice);
    public List<Property> findAllByTitleContainsOrLocationContains(
            //SELECT * FROM properties WHERE price BETWEEN ? AND ?

            String title, String location
    );
    //SELECT * FROM properties WHERE title LIKE ? OR location LIKE ?


//    @Query("SELECT p from properties where title = :title and location=:location ")
//    @Query(value = "SELECT * FROM properties where title = ? and location = ?",nativeQuery = true)
//    public List<Property> findSipasNaimit(String title, String location);


    public int countAllByLocationContains(String location);
    //SELECT COUNT(*) FROM properties WHERE location LIKE ?


    public List<Property> findAllByTypeAndBathroomsOrderByPriceDesc(String type, float bathroom);
    // SELECT * FROM properties WHERE type = ? AND bathrooms = ? ORDER BY price DESC


}










