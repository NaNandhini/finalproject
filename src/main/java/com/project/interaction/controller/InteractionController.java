package com.project.interaction.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.interaction.entity.InteractionEntity;
import com.project.interaction.service.InteractionService;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @GetMapping
    public List<InteractionEntity> getAllInteractions() {
        return interactionService.findAll();
    }

    @GetMapping("/{interactionId}")
    public ResponseEntity<InteractionEntity> getInteractionById(@PathVariable String interactionId) {
        Optional<InteractionEntity> interaction = interactionService.findById(interactionId);
        return interaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public InteractionEntity createInteraction(@RequestBody InteractionEntity interactionEntity) {
        return interactionService.save(interactionEntity);
    }

    @DeleteMapping("/{interactionId}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable String interactionId) {
        if (interactionService.findById(interactionId).isPresent()) {
            interactionService.deleteById(interactionId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
