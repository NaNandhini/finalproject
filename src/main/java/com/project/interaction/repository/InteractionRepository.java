package com.project.interaction.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.interaction.entity.InteractionEntity;




@Repository
public interface InteractionRepository extends JpaRepository<InteractionEntity, String> {
    List<InteractionEntity> findByChannel(String channel);

   
}
