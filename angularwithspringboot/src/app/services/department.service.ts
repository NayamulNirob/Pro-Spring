import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DepartmentModel } from '../model/departmodel';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  baseUrl:string="http://localhost:8089/api/dep/";

  constructor(private http:HttpClient) { }

  loadAllDepartments():Observable<any>{
    return this.http.get<any>(this.baseUrl+"view");

  }

  saveDepartment(department:DepartmentModel):Observable<DepartmentModel>{
    return this.http.post<DepartmentModel>(this.baseUrl+"save",department);
  }
}
