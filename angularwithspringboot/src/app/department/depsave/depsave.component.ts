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
  formGroup!: FormGroup;
  // departmentsData: any;
  faculty: FacaltyModel[]=[];


  constructor(
    private departmentService: DepartmentService,
    private facultyService: FacultyService,
    private formbuilder: FormBuilder,
    private router: Router

  ) { }

  ngOnInit(): void {
    this.loadFaculties();
    this.formGroup = this.formbuilder.group({
      name: [''],

      faculty: [null, '']

    });
  }

  loadFaculties() {
    this.facultyService.loadAllfaculties().subscribe({
      next: res => {
        this.faculty = res;
      },
      error: err => {
        console.log(err);
      }
    })
  }



  createDepartment() {
    const departmentsData:DepartmentModel=this.formGroup.value;
    
    this.departmentService.saveDepartment(departmentsData).subscribe({
      next: res => {
        console.log(res);
        this.loadFaculties();
        this.formGroup.reset();
        this.router.navigate(['/depview']);
      },
      error: err => {
        console.log("department not created")
        console.log(err);
      }
    });
  }
}
