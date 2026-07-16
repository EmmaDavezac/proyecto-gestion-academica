import { Component, OnInit, inject } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog'; 
import { ProfesorService } from '../../services/profesor.service';
import { AppTableComponent } from '../app-table.component/app-table.component';
import { ProfesorFormComponent } from '../profesor-form.component/profesor-form.component';
import { MatIconModule } from '@angular/material/icon';     
import { MatButtonModule } from '@angular/material/button';  

@Component({
  selector: 'app-profesores',
  standalone: true,
  imports: [AppTableComponent, MatIconModule, MatButtonModule],
  templateUrl: './profesores.component.html'
})
export class ProfesoresComponent implements OnInit {
  dataSource = new MatTableDataSource<Record<string, unknown>>();
  
  displayedColumns: string[] = ['id', 'nombre', 'apellido', 'titulo', 'sueldo'];
  headerLabels: Record<string, string> = {
    id: 'ID',
    nombre: 'Nombre',
    apellido: 'Apellido',
    titulo: 'Título',
    sueldo: 'Sueldo'
  };

  private readonly service = inject(ProfesorService);
  private dialog = inject(MatDialog); 

  ngOnInit() {
    this.cargarDatos(); 
  }

  cargarDatos() {
    this.service.listarTodos().subscribe(data => {
      this.dataSource.data = data;
    });
  }

  abrirFormulario(profesor?: any) {
    const dialogRef = this.dialog.open(ProfesorFormComponent, {
      data: profesor
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        if (profesor) {
          this.service.actualizar(profesor['id'], result).subscribe(() => this.cargarDatos());
        } else {
          this.service.crear(result).subscribe(() => this.cargarDatos());
        }
      }
    });
  }

  eliminarProfesor(profesor: any) {
    if (confirm('¿Estás seguro de que deseas eliminar a ' + profesor['nombre'] + '?')) {
      this.service.eliminar(profesor['id']).subscribe(() => this.cargarDatos());
    }
  }
}

