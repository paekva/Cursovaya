import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {MenuComponent} from './menu/menu.component';
import {FooterComponent} from './footer/footer.component';
import {GuardsGuard} from './guards.guard';
import {AdminComponent} from './admin/admin.component';
import {UserComponent} from './user/user.component';
import { HomeComponent } from './home/home.component';
// import { NewConteinerComponent } from './new-conteiner/new-conteiner.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { SearchComponent } from './search/search.component';
import { AboutComponent } from './about/about.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { NewsComponent } from './news/news.component';
import { LoginComponent } from './login/login.component';
import { UserTicketsComponent } from './user-tickets/user-tickets.component';
import { UserRentialComponent } from './user-rential/user-rential.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { AdminAddNewsComponent } from './admin-add-news/admin-add-news.component';
import { AdminAddDataComponent } from './admin-add-data/admin-add-data.component';
import { AdminEditComponent } from './admin-edit/admin-edit.component';
import { AdminTicketsComponent } from './admin-tickets/admin-tickets.component';
import { AdminEmployeesComponent } from './admin-employees/admin-employees.component';
import { ZoosComponent } from './zoos/zoos.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'user', component: UserComponent, canActivate: [GuardsGuard]},
  {path: 'admin', component: AdminComponent, canActivate: [GuardsGuard]},
  {path: 'search', component: SearchComponent},
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LoginComponent},
  {path: 'news', component: NewsComponent},
  {path: 'userT', component: UserTicketsComponent},
  {path: 'userR', component: UserRentialComponent},
  {path: 'userI', component: UserInfoComponent},
  {path: 'adminAN', component: AdminAddNewsComponent},
  {path: 'adminAD', component: AdminAddDataComponent},
  {path: 'adminE', component: AdminEditComponent},
  {path: 'adminT', component: AdminTicketsComponent},
  {path: 'adminEmp', component: AdminEmployeesComponent},
  {path: 'zoos', component: ZoosComponent},
  //{path: 'news/:id', component: NewConteinerComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    NewsComponent,
    FooterComponent,
    AdminComponent,
    UserComponent,
    NotFoundComponent,
    AboutComponent,
    SearchComponent,
    LoginComponent,
    HomeComponent,
    UserComponent,
    UserTicketsComponent,
    UserRentialComponent,
    UserInfoComponent,
    AdminAddNewsComponent,
    AdminAddDataComponent,
    AdminEditComponent,
    AdminTicketsComponent,
    AdminEmployeesComponent,
    ZoosComponent,
    //NewConteinerComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes, {enableTracing: true}),
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [GuardsGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
