import { Component, Input, Output, EventEmitter } from '@angular/core';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon'; // Necesario para iconos
import { MatButtonModule } from '@angular/material/button'; // Necesario para botones

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [MatTableModule, MatIconModule, MatButtonModule],
  templateUrl: './app-table.component.html'
})
export class AppTableComponent {
  @Input({ required: true }) dataSource!: MatTableDataSource<Record<string, unknown>>;
  @Input({ required: true }) displayedColumns: string[] = [];
  @Input() headerLabels: Record<string, string> = {};

  // Nuevos eventos para el padre
  @Output() edit = new EventEmitter<any>();
  @Output() delete = new EventEmitter<any>();
}

