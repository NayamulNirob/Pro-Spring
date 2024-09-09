import { Component } from '@angular/core';
import { DepartmentModel } from '../../model/departmodel';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DepartmentService } from '../../services/department.service';
import { Router } from '@angular/router';
import { FacultyService } from '../../services/faculty.service';
import { FacaltyModel } from '../../model/faculty';

@Component({
  selector: 'app-depsave',
  templateUrl: './depsave.component.html',
  styleUrl: './depsave.component.css'
})
export class DepsaveComponent {
  department: DepartmentModel = new DepartmentModel();
  faculties: FacaltyModel[]=[];


  constructor(
    private departmentService: DepartmentService,
    private facultyService: FacultyService,
    private router: Router

  ) { }

  ngOnInit(): void {
    this.loadFaculties();
  }

  loadFaculties() {
    this.facultyService.loadAllfaculties().subscribe({
      next: res => {
        this.faculties = res;
      },
      error: err => {
        console.log(err);
      }
    })
  }

  createDepartment() {
    this.departmentService.saveDepartment(this.department).subscribe({
      next: res => {
        console.log(res);
        this.loadFaculties();
        this.department = new DepartmentModel();
        this.router.navigate(['/depview']);
      },
      error: err => {
        console.log("department not created")
        console.log(err);
      }
    });
  }
}
