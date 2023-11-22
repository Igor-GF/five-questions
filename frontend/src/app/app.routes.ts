import { Routes } from '@angular/router';

export const routes: Routes = [
    {path: 'api/questions', pathMatch: 'full', redirectTo: 'questionlist'}
];
