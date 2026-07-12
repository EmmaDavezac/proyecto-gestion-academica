import { Routes } from '@angular/router';
import { LayoutComponent } from './components/layout.component/layout.component';

export const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', redirectTo: 'estudiantes', pathMatch: 'full' }, 
      { 
        path: 'estudiantes', 
        loadComponent: () => import('./components/estudiantes.component/estudiantes.component').then(m => m.EstudiantesComponent)
      },
      {
        path: 'carreras',
        loadComponent: () => import('./components/carreras.component/carreras.component').then(m => m.CarrerasComponent)
      }
    ]
  }
];