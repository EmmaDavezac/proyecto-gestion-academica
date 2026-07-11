import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarreraService {
  private http = inject(HttpClient);
  private url = 'http://localhost:8081/api/carreras';

  listarTodas(): Observable<Record<string, unknown>[]> {
    return this.http.get<Record<string, unknown>[]>(this.url);
  }
}