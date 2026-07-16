import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'; 

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {
  private http = inject(HttpClient);
  private url = environment.urlApiProfesores;

  listarTodos(): Observable<Record<string, unknown>[]> {
    return this.http.get<Record<string, unknown>[]>(this.url);
  }

  // Obtener por ID para editar
  obtenerPorId(id: number | string): Observable<Record<string, unknown>> {
    return this.http.get<Record<string, unknown>>(`${this.url}/${id}`);
  }

  // Crear
  crear(profesor: Record<string, unknown>): Observable<Record<string, unknown>> {
    return this.http.post<Record<string, unknown>>(this.url, profesor);
  }

  // Actualizar
  actualizar(id: number | string, profesor: Record<string, unknown>): Observable<Record<string, unknown>> {
    return this.http.put<Record<string, unknown>>(`${this.url}/${id}`, profesor);
  }

  // Eliminar
  eliminar(id: number | string): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }

}