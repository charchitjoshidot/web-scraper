package com.galen.webscrapper.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.galen.webscrapper.entity.EventEntity;
import com.galen.webscrapper.repository.EventRepository;

@Service
public class ScraperService {
	
	@Autowired
	EventRepository eventRepository;
	
	@Async
	public CompletableFuture<List<EventEntity>> fetchEventService1() throws Exception {
		String webUrl = "https://www.computerworld.com/article/3313417/tech-event-calendar-shows-conferences-and-it-expos-updated.html";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<EventEntity> eventList = new ArrayList<EventEntity>();
		try {
			
			Document doc = Jsoup.connect(webUrl).get();
			Elements events = doc.select("#cwsearchabletable tbody > tr");
			
			for (Element event : events) {
				EventEntity eventObj = new EventEntity();
				
				String sourceUrl = event.selectFirst("th > a").attr("href");
				Document sourceDoc = Jsoup.connect(sourceUrl).get();
				String sourceTitle = sourceDoc.title();
				
				String eventName = event.selectFirst("th").text();
				LocalDate date = LocalDate.parse(event.select("td").get(1).text(), dtf);
				String eventLocation = event.select("td").get(3).text();
				
				eventObj.setEventName(eventName);
		        eventObj.setEventLocation(eventLocation);
		        eventObj.setEventDate(date);
		        eventObj.setSourceName(sourceTitle);
				
		        // set event location as "virtual, online" if location field is empty and event name contains virtual"
				if(eventLocation.isEmpty()) {
					if(eventName.toLowerCase().contains("virtual")) {
						eventObj.setEventLocation("Virtual, Online");
					}
				}
				eventList.add(eventObj);
		        eventRepository.save(eventObj);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(eventList);
	}
	
	@Async
	public CompletableFuture<List<EventEntity>> fetchEventService2() throws Exception {
		List<EventEntity> eventList = new ArrayList<EventEntity>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d yyyy");
		String webUrl = "https://www.techmeme.com/events";
		try {
			
			Document doc = Jsoup.connect(webUrl).get();
			Elements events = doc.select(".rhov > a");
			
			for (Element event : events) {
				EventEntity eventObj = new EventEntity();
		        Elements elements = event.select("div");

		        String dateText = elements.get(0).text().split("-")[0] + " 2020";
		        LocalDate date = LocalDate.parse(dateText, dtf);
		        String eventName = elements.get(1).text();
		        String eventLocation = elements.get(2).text();
		        
				if(date.getMonthValue() < Calendar.getInstance().get(Calendar.MONTH)) {
					date = date.plusYears(1);
				}

		        eventObj.setEventName(eventName);
		        eventObj.setEventLocation(eventLocation);
		        eventObj.setEventDate(date);
		        eventObj.setSourceName("Techmeme");

		        //set event location as "virtual, online" if location field is empty and event name contains virtual"
		        if(eventLocation.isEmpty()) {
					if(eventName.toLowerCase().contains("virtual")) {
						eventObj.setEventLocation("Virtual, Online");
					}
				}
		        eventRepository.save(eventObj);
		        eventList.add(eventObj);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(eventList);
	}
	
	public void refreshAllEvents() throws Exception {
		eventRepository.deleteAll();
	}
	
	public List<EventEntity> fetchAllEvents() throws Exception {
		return eventRepository.findAll();		
	}
	
}
