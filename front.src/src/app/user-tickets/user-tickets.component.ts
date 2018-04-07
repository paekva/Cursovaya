import { Component, OnInit } from '@angular/core';
import { ZooService } from '../services/services';

@Component({
  selector: 'app-user-tickets',
  templateUrl: './user-tickets.component.html',
  styleUrls: ['./user-tickets.component.css']
})
export class UserTicketsComponent implements OnInit {

  constructor(public _zooService:ZooService) { }

  tickets = [];
  errorMsg: string;
  ngOnInit() {
    this._zooService.getTicketByUser(1)
      .subscribe(data => this.tickets = data,
                error => this.errorMsg = error);
}

}
