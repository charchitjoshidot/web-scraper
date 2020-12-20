import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-dummy-event-card',
  templateUrl: './dummy-event-card.component.html',
  styleUrls: ['./dummy-event-card.component.css']
})
export class DummyEventCardComponent implements OnInit {

  @Input() eventName: any;
  @Input() websiteName: any;
  @Input() eventLocation: any;
  @Input() eventDate: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
