import { Component, OnInit } from '@angular/core';
import { SearchRequest } from './search.model';
import { FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit {

  public d =[
    {value: '1', display: 'answer 1'},
    {value: '2', display: 'answer 2'},
    {value: '3', display: 'answer 3'}
  ];

  public zoos = [
    { value: '1801', display: 'Омский национальнй зоопарк' },
    { value: '200', display: 'Московский зоопарк' }
  ];

  public subjects = [
    { value: '1', display: 'Животные' },
    { value: '2', display: 'Мероприятия' },
    { value: '3', display: 'Упоминания о зоопарке' }
  ];
  public types = [
    {value: '0', display: 'Выберите предмет поиска'}
  ];

  private searchForm;

  constructor(private fb: FormBuilder) {
    this.searchForm = this.fb.group({
      subject: '',
      type: '',
      zoo: '',
      before: false,
      date: 0,
      data: []
    });
  }


  model = new SearchRequest(' ', '', '');
  
  onSubjectChange(subject)
  {
   if (subject==1) {
    this.types = [
      { value: '1', display: 'Млекопитающие' },
      { value: '2', display: 'Земноводные' },
      { value: '3', display: 'Присмыкающиеся' }
    ];
   } else if(subject==2){
    this.types = [
      { value: '1', display: 'Ночь в зоопарке' },
      { value: '2', display: 'Бесплатная экскурсия' },
      { value: '3', display: 'Открытый вольер' }
    ];
   }else{
    this.types = [
      { value: '1', display: 'Книга' },
      { value: '2', display: 'Статья' },
      { value: '3', display: 'Интернет-блог' }
    ];
   }
    this.model.subject = subject;    
  }
  

  onTypeChange(type)
  {
    this.model.type = type;
  }

  onZooChange(zoo)
  {
    this.model.zoo = zoo;
  }

  onSubmit()
  {
  }

  ngOnInit() {
    
  }

  get currentSearchRequest() { return JSON.stringify(this.model); }

}
