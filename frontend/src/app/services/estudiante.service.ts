import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {
  private http = inject(HttpClient);
  private url = 'http://localhost:8081/api/estudiantes';

  listarTodos(): Observable<Record<string, unknown>[]> {
    return this.http.get<Record<string, unknown>[]>(this.url);
  }

  // Nuevo: Obtener por ID para editar
  obtenerPorId(id: number | string): Observable<Record<string, unknown>> {
    return this.http.get<Record<string, unknown>>(`${this.url}/${id}`);
  }

  // Nuevo: Crear
  crear(estudiante: Record<string, unknown>): Observable<Record<string, unknown>> {
    return this.http.post<Record<string, unknown>>(this.url, estudiante);
  }

  // Nuevo: Actualizar
  actualizar(id: number | string, estudiante: Record<string, unknown>): Observable<Record<string, unknown>> {
    return this.http.put<Record<string, unknown>>(`${this.url}/${id}`, estudiante);
  }

  // Nuevo: Eliminar
  eliminar(id: number | string): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }

}