import { Component, OnInit, inject } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { CarreraService } from '../../services/carrera.service';
import { AppTableComponent } from '../app-table.component/app-table.component';

@Component({
  selector: 'app-carreras',
  standalone: true,
  imports: [AppTableComponent], // Importamos el componente aquí
  templateUrl: './carreras.component.html'
})
export class CarrerasComponent implements OnInit {
  dataSource = new MatTableDataSource<Record<string, unknown>>();
  
  // Configuración fija
  displayedColumns = ['id', 'nombre', 'duracion'];
  headerLabels = {
    id: 'ID',
    nombre: 'Nombre',
    duracion: 'Duración'
  };

  private readonly service = inject(CarreraService);

  ngOnInit() {
    this.service.listarTodas().subscribe(data => {
      this.dataSource.data = data;
    });
  }
}