package com.galen.webscrapper.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galen.webscrapper.entity.EventEntity;
import com.galen.webscrapper.service.ScraperService;

@RestController
@CrossOrigin
public class ApplicationController {

	@Autowired
	ScraperService scraperService;
	
	@GetMapping("/fetch-events")
	public ResponseEntity<List<EventEntity>> fetchEventData(){
		List<EventEntity> eventData = new ArrayList<>();
		try {
			scraperService.refreshAllEvents();
			CompletableFuture<List<EventEntity>> list1 = scraperService.fetchEventService1();
			CompletableFuture<List<EventEntity>> list2 = scraperService.fetchEventService2();
			CompletableFuture.allOf(list1, list2).join();
			eventData = scraperService.fetchAllEvents();
			return new ResponseEntity<List<EventEntity>>(eventData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<EventEntity>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
