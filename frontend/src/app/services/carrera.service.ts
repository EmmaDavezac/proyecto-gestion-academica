import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// Importa el environment (Angular cambiará automáticamente el archivo según si compilas para dev o prod)
import { environment } from '../../environments/environment'; 

@Injectable({
  providedIn: 'root'
})
export class CarreraService {
  private http = inject(HttpClient);
  // Usamos la variable del environment directamente
  private url = environment.urlApiCarreras;

  listarTodas(): Observable<Record<string, unknown>[]> {
    return this.http.get<Record<string, unknown>[]>(this.url);
  }
}