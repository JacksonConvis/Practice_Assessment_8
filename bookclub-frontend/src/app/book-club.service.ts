import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { __param } from "tslib";
import { Member } from "./member";

@Injectable({
  providedIn: "root",
})
export class BookClubService {
  [x: string]: any;
  apiBaseUrl: string = "http://localhost:8080";
  // ^ this points to spring boot api backend
  baseURL: string = this.apiBaseUrl + "/club-members";


  constructor(private http: HttpClient) {}

  getAllMembers(): Observable<Member[]> {
    return this.http.get<Member[]>(`${this.baseURL}`);
  };

  
 addMember(newEvent: Member): Observable<Member> {
  return this.http.post<Member>(`${this.baseURL}`, newEvent);
};
 


  getMemberById(id: number): Observable<Member> {
    return this.http.get<Member>(`${this.baseURL}/${id}`);
  }
  
  updateMember(updatedMember: Member): Observable<Member> {
    return this.http.put<Member>(`${this.baseURL}/${updatedMember.id}`, updatedMember);
  };

  removeMember(M: Member): Observable<void> {
    return this.http.delete<void>(`${this.baseURL}/${M.id}`);
  };

  
}