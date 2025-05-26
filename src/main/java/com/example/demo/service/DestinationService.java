package com.example.demo.service;

import com.example.demo.model.Destination;
import com.example.demo.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    // Récupérer toutes les destinations
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    // Récupérer une destination par ID
    public Optional<Destination> getDestinationById(Long id) {
        return destinationRepository.findById(id);
    }

    // Créer une nouvelle destination
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    // Mettre à jour une destination existante
    public Destination updateDestination(Long id, Destination destinationDetails) {
        Optional<Destination> destination = destinationRepository.findById(id);
        if (destination.isPresent()) {
            Destination existingDestination = destination.get();
            existingDestination.setName(destinationDetails.getName());
            existingDestination.setCountry(destinationDetails.getCountry());
            existingDestination.setDescription(destinationDetails.getDescription());
            existingDestination.setImageUrl(destinationDetails.getImageUrl());
            existingDestination.setRating(destinationDetails.getRating());
            existingDestination.setCostEstimate(destinationDetails.getCostEstimate());
            return destinationRepository.save(existingDestination);
        }
        return null;
    }

    // Supprimer une destination
    public boolean deleteDestination(Long id) {
        if (destinationRepository.existsById(id)) {
            destinationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Rechercher des destinations par pays
    public List<Destination> getDestinationsByCountry(String country) {
        return destinationRepository.findByCountry(country);
    }

    // Rechercher des destinations par note minimale
    public List<Destination> getDestinationsByMinimumRating(Double rating) {
        return destinationRepository.findByRatingGreaterThanEqual(rating);
    }

    // Rechercher des destinations dans une fourchette de prix
    public List<Destination> getDestinationsByPriceRange(Double min, Double max) {
        return destinationRepository.findByCostEstimateBetween(min, max);
    }

    // Rechercher des destinations par nom ou description
    public List<Destination> searchDestinations(String query) {
        return destinationRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }
}
