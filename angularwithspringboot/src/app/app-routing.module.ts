import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewComponent } from './faculty/view/view.component';
import { SaveComponent } from './faculty/save/save.component';
import { DepviewComponent } from './department/depview/depview.component';
import { DepsaveComponent } from './department/depsave/depsave.component';
import { StudentviewComponent } from './student/studentview/studentview.component';
import { StudentcreateComponent } from './student/studentcreate/studentcreate.component';


const routes: Routes = [
  {path:'facview',component:ViewComponent},
  {path:"facsave",component:SaveComponent},
  {path:"depview",component:DepviewComponent},
  {path:"depsave",component:DepsaveComponent},
  {path:"studentview",component:StudentviewComponent},
  {path:"studentsave",component:StudentcreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
