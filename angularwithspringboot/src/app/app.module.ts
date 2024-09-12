import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ViewComponent } from './faculty/view/view.component';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { SaveComponent } from './faculty/save/save.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DepviewComponent } from './department/depview/depview.component';
import { DepsaveComponent } from './department/depsave/depsave.component';
import { StudentcreateComponent } from './student/studentcreate/studentcreate.component';
import { StudentviewComponent } from './student/studentview/studentview.component';
import { AdduserComponent } from './user/adduser/adduser.component';
import { ViewuserComponent } from './user/viewuser/viewuser.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    SaveComponent,
    DepviewComponent,
    DepsaveComponent,
    StudentcreateComponent,
    StudentviewComponent,
    AdduserComponent,
    ViewuserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule


  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
