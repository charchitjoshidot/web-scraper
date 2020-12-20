import { Component, OnInit } from '@angular/core';
import {AppService} from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  events: eventData[] = [];
  dataSource: eventData[] = [];
  loading: boolean = true;

  constructor(private appService: AppService) {};

  ngOnInit() {
    this.loading = true;
    this.fetchEvents();
   }

  fetchEvents() {
    this.appService.fetchAllEvents().subscribe(
      (response: any) => {
        if (response.length) {
          this.dataSource = response;
          this.events = response;
          this.loading = false;
        }
      },
      (error) => {
        this.loading = false;
        alert("Error: " + error);
      });
  }

  onChangeSortType(e) {  
    if (e == 1) { // sort by date
      this.events = this.events.sort((a, b) => a.eventDate.localeCompare(b.eventDate));
    } else if (e == 2) { // sort by Event Name
      this.events.sort((a, b) => a.eventName.localeCompare(b.eventName));
    } else if (e == 3) { // sort by Location Name
      this.events.sort((a, b) => a.eventLocation.localeCompare(b.eventLocation));
    }
  }

  onChangeSearch(e) {
    this.events = this.dataSource.filter((event: eventData) => {
      return event.eventName.toLowerCase().includes(e.toLowerCase()) || event.eventLocation.toLowerCase().includes(e.toLowerCase());
    });
  }

}
export interface eventData {
  id: number
  eventDate: string
  eventLocation: string
  eventName: string
  sourceName: string
}
