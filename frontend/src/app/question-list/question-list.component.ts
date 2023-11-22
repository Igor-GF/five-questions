import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Question } from '../question';

@Component({
  selector: 'app-question-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './question-list.component.html',
  styleUrl: './question-list.component.css'
})
export class QuestionListComponent implements OnInit {

  questions: Question[] | undefined;

  constructor() {}

  ngOnInit(): void {
    this.questions = [{
      "id": 1,
      "type": "type 1",
      "difficulty": "easy",
      "category": "books",
      "question": "Is Gaiman Coraline;s author?",
      "correctAnswer": "yes",
      "incorrectAnswer": ["no", "don't know"]
    }, {
      "id": 2,
      "type": "type 2",
      "difficulty": "hard",
      "category": "books",
      "question": "Does LOR have more than 2000 pages?",
      "correctAnswer": "no",
      "incorrectAnswer": ["yes", "don't know"]
    }]
  }

}
