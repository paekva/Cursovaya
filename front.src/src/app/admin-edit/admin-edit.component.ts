import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { ZooService } from '../services/services';
import { IAnimal, IZoo } from '../services/entites';

@Component({
  selector: 'app-admin-edit',
  templateUrl: './admin-edit.component.html',
  styleUrls: ['./admin-edit.component.css']
})
export class AdminEditComponent implements OnInit {

  public tables = [
    {value: '0', display: ''},
    {value: '1', display: 'Зоопарки'},
    {value: '2', display: 'Животные'} ]
  public zoos=[];
  public animals = [];

  public zoo: IZoo;
  public animal: IAnimal;
  private zooForm;
  private animalForm;
  public errorMsg;

  constructor(private fb: FormBuilder,private _zooService: ZooService) {
    this.zooForm = this.fb.group({
      name: '',
      functionality: '',
      manager: ''
    });

    this.animalForm = this.fb.group({
      zoo: '',
      name: '',
      features: '',
      state: ''
    });
  }

  showZoo: boolean = false;
  showAnimal: boolean = false;

  formChange(val) /* Меняем форму на ёкране взависимости от выбранной категории */
  {
    if(val==0)
    {
      this.showAnimal = false;
      this.showZoo = false;
    }
    if(val==2)
    {
      this.showAnimal = true;
      this.showZoo = false;
      this.animals = [];
    }
    if(val==1)
    {
      this.showZoo = true;
      this.showAnimal = false;
    }
  }

  onZooChange(value) /* При выборе зоопарка подгружаем животных */
  {
    this._zooService.getAnimalsByZoo(value)
      .subscribe(data => this.animals = data,
                error => this.errorMsg = error);
    this.zoo.name = value;
  }

  ngOnInit() {
    this._zooService.getZoos()
      .subscribe(data => this.zoos = data,
                error => this.errorMsg = error);
}

  sendZoo()
  {
    this._zooService.postChangedZoo(this.zoo)
                .subscribe(
                    error => console.log(error)
                );
  }
}
