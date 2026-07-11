import { Component, Input } from '@angular/core';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [MatTableModule],
  templateUrl: './app-table.component.html'
})
export class AppTableComponent {
  // Recibimos los datos y configuración desde el componente padre
  @Input({ required: true }) dataSource!: MatTableDataSource<Record<string, unknown>>;
  @Input({ required: true }) displayedColumns: string[] = [];
  @Input() headerLabels: Record<string, string> = {};
}