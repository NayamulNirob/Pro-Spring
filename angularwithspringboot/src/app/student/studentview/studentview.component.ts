import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../services/student.service';


@Component({
  selector: 'app-studentview',
  templateUrl: './studentview.component.html',
  styleUrl: './studentview.component.css'
})
export class StudentviewComponent implements OnInit{

students:any;


constructor(
  private studentService:StudentService,

  
){}

  ngOnInit(): void {
    this.loadAllStudents();
  }

  loadAllStudents(){
    this.studentService.loadAllstudent().subscribe({
      next:res=>{
        this.students=res;
      },
      error: err=>{
        console.log(err);
      }
    });
  }

}
