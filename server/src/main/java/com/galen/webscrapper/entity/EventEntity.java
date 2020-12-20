package com.galen.webscrapper.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="events")


public class EventEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String eventName;
	
	private LocalDate eventDate;
	
	private String eventLocation;
	
	private String sourceName;
	
}
