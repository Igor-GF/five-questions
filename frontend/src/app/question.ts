export class Question {
    id: number | undefined;
    type: string | undefined;
    difficulty: string | undefined;
    category: string | undefined;
    question: string | undefined;
    correctAnswer: string | undefined;
    incorrectAnswer: string[] | undefined;
}
