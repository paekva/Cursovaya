import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {MenuComponent} from './menu/menu.component';
import {NewsComponent} from './news/news.component';
import {FooterComponent} from './footer/footer.component';
import {AdminComponent} from './admin/admin.component';
import {UserComponent} from './user/user.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {AboutComponent} from './about/about.component';
import {ListComponent} from './list/list.component';
import {SearchComponent} from './search/search.component';
import {LogComponent} from './log/log.component';
import {HomeComponent} from './home/home.component';
import {NewConteinerComponent} from './new-conteiner/new-conteiner.component';
import {AdminAddDataComponent} from './admin-add-data/admin-add-data.component';
import {AdminAddNewsComponent} from './admin-add-news/admin-add-news.component';
import {AdminEditComponent} from './admin-edit/admin-edit.component';
import {AdminEmployeesComponent} from './admin-employees/admin-employees.component';
import {AdminTicketsComponent} from './admin-tickets/admin-tickets.component';
import {UserInfoComponent} from './user-info/user-info.component';
import {UserRentialComponent} from './user-rential/user-rential.component';
import {UserTicketsComponent} from './user-tickets/user-tickets.component';
import {ZoosComponent} from './zoos/zoos.component';
import {ZooService} from './services/services';
import {RegComponent} from './reg/reg.component';
import { OneAnimalComponent } from './one-animal/one-animal.component';
import { OneEventComponent } from './one-event/one-event.component';
import { OneMentionComponent } from './one-mention/one-mention.component';
import { AdminGuard } from './guards/admin-guard';
import { UserGuard } from './guards/user-guard';
import { AuthGuard } from './guards/auth-guard';
import { LogoutComponent } from './logout/logout.component';
import { LogoutGuard} from './guards/logout-guard';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'user', component: UserComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AdminGuard]},
  {path: 'search', component: SearchComponent},
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LogComponent, canActivate: [AuthGuard]},
  {path: 'registration', component: RegComponent, canActivate: [AuthGuard]},
  {path: 'news', component: NewsComponent},
  {path: 'userT', component: UserTicketsComponent, canActivate: [UserGuard]},
  {path: 'userR', component: UserRentialComponent, canActivate: [UserGuard]},
  {path: 'userI', component: UserInfoComponent, canActivate: [UserGuard]},
  {path: 'adminAN', component: AdminAddNewsComponent, canActivate: [AdminGuard]},
  {path: 'adminAD', component: AdminAddDataComponent, canActivate: [AdminGuard]},
  {path: 'adminE', component: AdminEditComponent, canActivate: [AdminGuard]},
  {path: 'adminT', component: AdminTicketsComponent, canActivate: [AdminGuard]},
  {path: 'adminEmp', component: AdminEmployeesComponent, canActivate: [AdminGuard]},
  {path: 'zoos', component: ZoosComponent},
  {path: 'news/:id', component: NewConteinerComponent},
  {path: 'oneEvent/:id', component: OneEventComponent},
  {path: 'oneAnimal/:id', component: OneAnimalComponent},
  {path: 'oneMention/:id', component: OneMentionComponent},
  {path: 'logout', component: LogoutComponent, canActivate: [LogoutGuard]},
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
    ListComponent,
    SearchComponent,
    LogComponent,
    HomeComponent,
    NewConteinerComponent,
    AdminAddDataComponent,
    AdminAddNewsComponent,
    AdminEditComponent,
    AdminEmployeesComponent,
    AdminTicketsComponent,
    UserInfoComponent,
    UserRentialComponent,
    UserTicketsComponent,
    ZoosComponent,
    RegComponent,
    OneAnimalComponent,
    OneEventComponent,
    OneMentionComponent,
    LogoutComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes, {enableTracing: true}),
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ZooService, AdminGuard, UserGuard, CookieService, AuthGuard, LogoutGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
