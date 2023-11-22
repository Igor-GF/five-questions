import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Question } from '../question';
import { QuestionService } from '../question.service';

@Component({
  selector: 'app-question-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './question-list.component.html',
  styleUrl: './question-list.component.css'
})
export class QuestionListComponent implements OnInit {

  questions: Question[] = [];

  constructor(private questionService: QuestionService) {}

  ngOnInit(): void {
    this.getQuestions();
  }

  private getQuestions() {
    this.questionService.getQuestionList().subscribe(data => {
      this.questions = data;
    })
  }

}
