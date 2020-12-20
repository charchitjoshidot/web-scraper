import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DummyEventCardComponent } from './dummy-event-card/dummy-event-card.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { AppService } from './app.service';

@NgModule({
  declarations: [
    AppComponent,
    DummyEventCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
