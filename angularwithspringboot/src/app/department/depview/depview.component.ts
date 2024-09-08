import { Component, OnInit } from '@angular/core';
import { DepartmentService } from '../../services/department.service';
import { FacultyService } from '../../services/faculty.service';

@Component({
  selector: 'app-depview',
  templateUrl: './depview.component.html',
  styleUrl: './depview.component.css'
})
export class DepviewComponent implements OnInit{
  faculty: any;
  department: any;

  constructor(
    private departmentService: DepartmentService,
    private facultyService: FacultyService,
  ) { }

  ngOnInit(): void {
    this.loadDepartment
  }

  loadDepartment() {

     this.department=this.departmentService.loadAllDepartments();
  
  }
}
