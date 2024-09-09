import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../services/student.service';
import { StudentModel } from '../../model/studentmodel';
import { DepartmentModel } from '../../model/departmodel';
import { DepartmentService } from '../../services/department.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-studentcreate',
  templateUrl: './studentcreate.component.html',
  styleUrl: './studentcreate.component.css'
})
export class StudentcreateComponent implements OnInit{

  students:StudentModel=new StudentModel();
  departments:DepartmentModel[]=[];


  constructor(
    private studentService:StudentService,
    private departmentService:DepartmentService,
    private router:Router
  ){}
  
  ngOnInit(): void {
    this.loadDepartments();
  }

  loadDepartments(){
    this.departmentService.loadAllDepartments().subscribe({
      next:res=>{
        this.departments=res;
      },
      error: err=>{
        console.log(err);
      }
    });
  }

  createStudent(){
   
    this.studentService.savestudent(this.students).subscribe({
      next:res=>{
        console.log(res);
        this.loadDepartments();
        this.students=new StudentModel();
        this.router.navigate(['/studentview'])
      },
      error: err => {
        console.log("Student not created")
        console.log(err);
      }
    });
  }



}
