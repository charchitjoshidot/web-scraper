package com.galen.webscrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galen.webscrapper.entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

}
