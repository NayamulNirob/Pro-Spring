import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudentModel } from '../model/studentmodel';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  baseUrl:string="http://localhost:8089/api/student/";
  
  constructor(private http:HttpClient) { }


  loadAllstudent():Observable<any>{
    return this.http.get<any>(this.baseUrl+"view")

  }

  savestudent(student:StudentModel):Observable<StudentModel>{
    return this.http.post<StudentModel>(this.baseUrl+"save",student);
  }

  
}



  