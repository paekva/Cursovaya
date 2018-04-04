import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRentialComponent } from './user-rential.component';

describe('UserRentialComponent', () => {
  let component: UserRentialComponent;
  let fixture: ComponentFixture<UserRentialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserRentialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRentialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
