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

@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    SaveComponent,
    DepviewComponent,
    DepsaveComponent
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
