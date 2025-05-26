package com.example.demo.repository;

import com.example.demo.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    
    // Trouver les destinations par pays
    List<Destination> findByCountry(String country);
    
    // Trouver les destinations par note minimale
    List<Destination> findByRatingGreaterThanEqual(Double rating);
    
    // Trouver les destinations dans une fourchette de prix
    List<Destination> findByCostEstimateBetween(Double min, Double max);
    
    // Recherche personnalisée par nom ou description
    List<Destination> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
}
