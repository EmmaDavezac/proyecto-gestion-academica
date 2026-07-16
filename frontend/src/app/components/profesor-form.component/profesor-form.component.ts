import { Component, Inject, inject, OnInit } from '@angular/core'; 
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select'; 
import { CarreraService } from '../../services/carrera.service'; 
import { ChangeDetectorRef } from '@angular/core'; 

@Component({
  selector: 'app-profesor-form',
  standalone: true,
  imports: [ReactiveFormsModule, MatDialogModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatSelectModule],
  templateUrl: './profesor-form.component.html',
  styleUrls: ['./profesor-form.component.css']
})
export class ProfesorFormComponent implements OnInit {
  form: FormGroup;
  isEditMode: boolean;
  carreras: any[] = []; 

  private fb = inject(FormBuilder);
  private carreraService = inject(CarreraService); 
  
  constructor(
    public dialogRef: MatDialogRef<ProfesorFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.isEditMode = !!data;

    this.form = this.fb.group({
      nombre: [data?.nombre || '', Validators.required],
      apellido: [data?.apellido || '', Validators.required],
      email: [data?.email || '', [Validators.required, Validators.email]], 
      titulo: [data?.titulo || '', Validators.required],
      sueldo: [data?.sueldo || '', Validators.required] 
    });
  }

  private cdr = inject(ChangeDetectorRef); 

  ngOnInit() {
    this.carreraService.listarTodas().subscribe(data => {
      this.carreras = data;
      this.cdr.detectChanges(); 
    });
  }

  guardar() {
    if (this.form.valid) {
      this.dialogRef.close(this.form.value);
    }
  }
}

