package com.example.demo.controller;

import com.example.demo.model.Destination;
import com.example.demo.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    // Obtenir toutes les destinations
    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    // Obtenir une destination par ID
    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Long id) {
        Optional<Destination> destination = destinationService.getDestinationById(id);
        return destination.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Créer une nouvelle destination
    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        Destination newDestination = destinationService.createDestination(destination);
        return new ResponseEntity<>(newDestination, HttpStatus.CREATED);
    }

    // Mettre à jour une destination existante
    @PutMapping("/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable Long id, @RequestBody Destination destination) {
        Destination updatedDestination = destinationService.updateDestination(id, destination);
        if (updatedDestination != null) {
            return new ResponseEntity<>(updatedDestination, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une destination
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        boolean deleted = destinationService.deleteDestination(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Rechercher des destinations par pays
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Destination>> getDestinationsByCountry(@PathVariable String country) {
        List<Destination> destinations = destinationService.getDestinationsByCountry(country);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    // Rechercher des destinations par note minimale
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Destination>> getDestinationsByRating(@PathVariable Double rating) {
        List<Destination> destinations = destinationService.getDestinationsByMinimumRating(rating);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    // Rechercher des destinations dans une fourchette de prix
    @GetMapping("/price")
    public ResponseEntity<List<Destination>> getDestinationsByPriceRange(
            @RequestParam Double min, @RequestParam Double max) {
        List<Destination> destinations = destinationService.getDestinationsByPriceRange(min, max);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    // Rechercher des destinations par mot-clé (nom ou description)
    @GetMapping("/search")
    public ResponseEntity<List<Destination>> searchDestinations(@RequestParam String query) {
        List<Destination> destinations = destinationService.searchDestinations(query);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }
}
