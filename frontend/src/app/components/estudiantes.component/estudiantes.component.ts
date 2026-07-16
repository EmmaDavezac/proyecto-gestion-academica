import { Component, OnInit, inject } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog'; 
import { EstudianteService } from '../../services/estudiante.service';
import { AppTableComponent } from '../app-table.component/app-table.component';
import { EstudianteFormComponent } from '../estudiante-form.component/estudiante-form.component';
import { MatIconModule } from '@angular/material/icon';     
import { MatButtonModule } from '@angular/material/button';  

@Component({
  selector: 'app-estudiantes',
  standalone: true,
  imports: [AppTableComponent, MatIconModule, MatButtonModule],
  templateUrl: './estudiantes.component.html'
})
export class EstudiantesComponent implements OnInit {
  dataSource = new MatTableDataSource<Record<string, unknown>>();
  
  displayedColumns: string[] = ['id', 'nombre', 'apellido', 'legajo'];
  headerLabels: Record<string, string> = {
    id: 'ID',
    nombre: 'Nombre',
    apellido: 'Apellido',
    legajo: 'Legajo'
  };

  private readonly service = inject(EstudianteService);
  private dialog = inject(MatDialog); 

  ngOnInit() {
    this.cargarDatos(); 
  }

  cargarDatos() {
    this.service.listarTodos().subscribe(data => {
      this.dataSource.data = data;
    });
  }

  abrirFormulario(estudiante?: any) {
    const dialogRef = this.dialog.open(EstudianteFormComponent, {
      data: estudiante
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        if (estudiante) {
          this.service.actualizar(estudiante['id'], result).subscribe(() => this.cargarDatos());
        } else {
          this.service.crear(result).subscribe(() => this.cargarDatos());
        }
      }
    });
  }

  eliminarEstudiante(estudiante: any) {
    if (confirm('¿Estás seguro de que deseas eliminar a ' + estudiante['nombre'] + '?')) {
      this.service.eliminar(estudiante['id']).subscribe(() => this.cargarDatos());
    }
  }
}

