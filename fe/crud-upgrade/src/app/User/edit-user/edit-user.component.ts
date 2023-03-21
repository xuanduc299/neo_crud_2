import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceUserService } from 'src/app/Service/service-user.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})

export class EditUserComponent implements OnInit {
  product: any = new Product();
  showAlert = false;

  constructor(private fb: FormBuilder, private router: Router, private service: ServiceUserService) { }
  public form: any = FormGroup;
  ngOnInit(): void { this.editUser(); this.formInit(); }

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
      material: ['', [Validators.required]],
      sectors: ['', [Validators.required]],
    });
  }


  editUser() {
    let id = String(localStorage.getItem("id") || "");
    this.service.getUserId(id)
      .subscribe(data => {
        this.product = Object.values(data);
        this.product = this.product[0];
        //   this.user = Object.values(data);
        // this.user = this.user[0]

      })
  }

  onSubmit() {
    this.service.updateUser(this.product.id, this.product).subscribe(data => {
      this.product = Object.values(data);
      // this.product = this.product[0];
      alert("eidt successfulll");
      this.router.navigate(["list-user"]);
    })
  }

  closeAlert() {
    this.showAlert = false;
  }
}
