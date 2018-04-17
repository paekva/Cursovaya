import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { ZooService } from '../services/services';

@Component({
  selector: 'app-admin-add-data',
  templateUrl: './admin-add-data.component.html',
  styleUrls: ['./admin-add-data.component.css']
})
export class AdminAddDataComponent implements OnInit {

  public tables = [
    {value: '1', display: 'Зоопарки'},
    {value: '2', display: 'Площадки'},
    {value: '3', display: 'Мероприятия'},
  ]


  public zoos=[];
  public animals = [];
  public employees = [];
  public types = [];
  private zooForm;
  private placeForm;
  private eventForm;
  public errorMsg;

  constructor(private fb: FormBuilder,private _zooService: ZooService) {
    this.zooForm = this.fb.group({
      name: '',
      functional: '',
      manager: '',
      place: '',
      date: null,
      animals: 0,
      employees: 0
    });

    this.placeForm = this.fb.group({
      name: '',
      zoo: '',
      flora: '',
      animal: '',
      square: 0
    });

    this.eventForm = this.fb.group({
      name: '',
      zoo: '',
      employee: '',
      type: '',
      date: null,
      duration: 0,
      cost: 0
    });
  }

  showZoo: boolean = false;
  showPlace: boolean = false;
  showEvent: boolean = false;

  formChange(val)
  {
    if(val==2)
    {
      this.showPlace = true;
      this.showEvent = false;
      this.showZoo = false;
    }
    if(val==3)
    {
      this.showEvent = true;
      this.showZoo = false;
      this.showPlace = false;
    }
    if(val==1)
    {
      this.showZoo = true;
      this.showEvent = false;
      this.showPlace = false;
    }
  }

  onZooChange(value)
  {
    this._zooService.getAnimalsByZoo(value)
      .subscribe(data => this.animals = data,
                error => this.errorMsg = error);

    this._zooService.getEmployeesByZoo(value)
      .subscribe(data => this.employees = data,
                error => this.errorMsg = error);
  }

  ngOnInit() {
    this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);

    this._zooService.getEventTypes()
      .subscribe(data => this.types = data,
                error => this.errorMsg = error);
}

}
