import { Component, OnInit } from '@angular/core';
import { DepartmentService } from '../../services/department.service';
import { FacultyService } from '../../services/faculty.service';
import { FacaltyModel } from '../../model/faculty';
import { DepartmentModel } from '../../model/departmodel';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-depview',
  templateUrl: './depview.component.html',
  styleUrl: './depview.component.css'
})
export class DepviewComponent implements OnInit {
  faculty: FacaltyModel[] = [];
  departments: DepartmentModel[] = [];

  // departments: any;

  constructor(
    private departmentService: DepartmentService,
    private facultyService: FacultyService,
  ) { }

  ngOnInit(): void {
    this.loadDepartment();
  }

  loadDepartment() {
    // departments:this.departmentService.loadAllDepartments(),
    
    const combainedObservables = forkJoin({
     departments:this.departmentService.loadAllDepartments(),
     facultys:this.facultyService.loadAllfaculties()
    });

    combainedObservables.subscribe({
      next:(data)=>{
        this.departments=data.departments;
        this.faculty=data.facultys;
      },
      error:(error)=>console.error('Error loading data:',error)
    });

  }
}
