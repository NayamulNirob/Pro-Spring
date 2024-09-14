import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserModel } from '../model/usermodel';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl: string = "http://localhost:8090/api/user/"

  constructor(private http: HttpClient) { }

  getAllUser(): Observable<any> {
    return this.http.get(this.baseUrl + "view");
  }

  addUser(user:UserModel,image:File):Observable<any>{

    const fromData= new FormData(); 

    fromData.append('user',new Blob([JSON.stringify(user)],{type:'application/json'}));
    fromData.append('image',image);

    return this.http.post(this.baseUrl+"save",fromData);
  }
}
