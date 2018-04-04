import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-add-data',
  templateUrl: './admin-add-data.component.html',
  styleUrls: ['./admin-add-data.component.css']
})
export class AdminAddDataComponent implements OnInit {

  public tables = [
    {value: '1', display: 'Зоопарки'},
    {value: '2', display: 'Животные'},
    {value: '3', display: 'Сотрудники'},
  ]
  constructor() { }

  ngOnInit() {
  }

}