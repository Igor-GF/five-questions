import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseURL = 'http://localhost:8080/api/questions';

  constructor(private http: HttpClient) { }

  getQuestionList(): Observable<any[]> {
    return this.http.get<any[]>(this.baseURL);
  }
}
