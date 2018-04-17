import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewConteinerComponent } from './new-conteiner.component';

describe('NewConteinerComponent', () => {
  let component: NewConteinerComponent;
  let fixture: ComponentFixture<NewConteinerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewConteinerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewConteinerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
