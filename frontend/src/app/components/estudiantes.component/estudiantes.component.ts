import { Component, OnInit, inject } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { EstudianteService } from '../../services/estudiante.service';
import { AppTableComponent } from '../app-table.component/app-table.component';

@Component({
  selector: 'app-estudiantes',
  standalone: true,
  imports: [AppTableComponent], // Importamos nuestro componente reutilizable
  templateUrl: './estudiantes.component.html'
})
export class EstudiantesComponent implements OnInit {
  dataSource = new MatTableDataSource<Record<string, unknown>>();
  
  // Definimos configuración de columnas
  displayedColumns: string[] = ['id', 'nombreCompleto', 'legajo'];
  headerLabels: Record<string, string> = {
    id: 'ID',
    nombreCompleto: 'Nombre Completo',
    legajo: 'Legajo'
  };

  private readonly service = inject(EstudianteService);

  ngOnInit() {
    this.service.listarTodos().subscribe(data => {
      this.dataSource.data = data;
    });
  }
}