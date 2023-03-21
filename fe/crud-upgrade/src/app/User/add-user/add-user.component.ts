import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceUserService } from 'src/app/Service/service-user.service';

interface Product_material {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})



export class AddUserComponent implements OnInit {
  product: Product = new Product();
  showAlert = false;
  product_material: Product_material[] = [
    { value: 'steak-0', viewValue: 'Steak' },
    { value: 'pizza-1', viewValue: 'Pizza' },
    { value: 'tacos-2', viewValue: 'Tacos' },
  ];

  constructor(private fb: FormBuilder, private router: Router, private service: ServiceUserService) {
    this.formInit();
  }
  public form: any = FormGroup;

  ngOnInit(): void { }

  private formInit() {
    this.form = this.fb.group({
      maSp: ['', [Validators.required]],
      name: ['', [Validators.required]],
      date: ['', [Validators.required]],
      product_width: ['', [Validators.required]],
      product_height: ['', [Validators.required]],
      color: ['', [Validators.required]],
      quantity: ['', [Validators.required]],
      brand: ['', [Validators.required]],
      // material: ['', [Validators.required]],
      sectors: ['', [Validators.required]],
    });
  }

  // get name() { return this.myForm.get('name'); }
  // get email() { return this.myForm.get('email'); }
  // get pasword() { return this.myForm.get('pasword'); }
  savePersonal() {
    this.service.CreateUser(this.product).subscribe(data => {
      console.log(data);
      this.goToUserList();
    },
      error => console.log(error));
  }


  goToUserList() {
    this.router.navigate(['/list-user']);
  }

  onSubmit() {
    console.log(this.product);
    this.savePersonal();
  }

  closeAlert() {
    this.showAlert = false;
  }



}
