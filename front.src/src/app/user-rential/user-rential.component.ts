import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { RentialModel } from './rential.model';

@Component({
  selector: 'app-user-rential',
  templateUrl: './user-rential.component.html',
  styleUrls: ['./user-rential.component.css']
})
export class UserRentialComponent implements OnInit {

  private rentialForm;

  public zoos = [
    { value: '1801', display: 'Омский национальнй зоопарк' },
    { value: '200', display: 'Московский зоопарк' }
  ];

  public animals;
  request = new RentialModel('','','','','',null,null);
  

  constructor(private fb: FormBuilder) {
    this.rentialForm = this.fb.group({
      zoo: '',
      animal: '',
      dateTake: null,
      dateReturn: null,
      name: '',
      purpose: '',
      email: ''
    });
  }

  onZooChange(zoo)
  {
   if (zoo==1801) {
    this.animals = [
      { value: '1', display: 'Млекопитающие' },
      { value: '2', display: 'Земноводные' },
      { value: '3', display: 'Присмыкающиеся' }
    ];
   } else{
    this.animals = [
      { value: '1', display: 'Ночь в зоопарке' },
      { value: '2', display: 'Бесплатная экскурсия' },
      { value: '3', display: 'Открытый вольер' }
    ];
   }
    this.request.zoo = zoo;    
  }

  onAnimalChange(animal) { this.request.animal = animal; }
  onNameChange(animal) { this.request.name = animal; }
  onPurposeChange(animal) { this.request.purpose = animal; }
  onEmailChange(animal) { this.request.email = animal; }
  onDateTakeChange(animal) { this.request.dateTake = animal; }
  onDateReturnChange(animal) { this.request.dateReturn = animal; }

  sendRequest()
  {
    //send
  }

  ngOnInit() {
  }

}
