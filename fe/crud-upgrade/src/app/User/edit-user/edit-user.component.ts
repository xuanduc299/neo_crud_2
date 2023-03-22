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
      province: ['', [Validators.required]],
      district: ['', [Validators.required]],
      village: ['', [Validators.required]],

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


  public cities = [
    {
      city: 'Chọn thành phố!',
      district: [],
      village: [],
    },
    {
      city: 'Hn',
      district: [
        'HN',
        'HN',
        'HN',
        'HN',
        'HN',
        'HN',
        'HN',
      ],
      village: [
        'HN1',
        'HN1',
        'HN1',
        'HN1',
        'HN1',
        'HN1',
        'HN1',
      ],
    },
    {
      city: 'HP',
      district: [
        'HP',
        'HP',
        'HP',
        'HP',
        'HP',
        'HP',
        'HP',
      ],
      village: [
        'HP1',
        'HP1',
        'HP1',
        'HP1',
        'HP1',
        'HP1',
        'HP1',
      ],
    },
    {
      city: 'DN',
      district: [
        'DN',
        'DN',
        'DN',
        'DN',
        'DN',
        'DN',
        'DN',
      ],
      village: [
        'DN1',
        'DN1',
        'DN1',
        'DN1',
        'DN1',
        'DN1',
        'DN1',
      ],
    },
  ];
  public districts: string[] = ['quan/huyen'];

  public villages: string[] = ['lang/xa'];

  public changeCity(event: any) {
    const city = event.target.value;

    if (!city) {
      return;
    }
    //cach 1
    // const search = this.cities.filter(data => data.city === city)
    // console.log('event', search);
    // if (search && search.length > 0) {
    //   this.districts = search[0].district;
    // }

    // const search2 = this.cities.filter(data => data.district === this.districts)
    // console.log('event', search2);
    // if (search2 && search2.length > 0) {
    //   this.districts = search2[0].village;
    // }

    //cach 2 
    this.districts = this.cities.find(data => data.city === city)?.district || [];

  }

  public changeDistrict(event: any) {
    const district = event.target.value;
    const village = event.target.value;
    console.log(village);
    if (!district) {
      return;
    }

    this.villages = this.cities.find(data => data.district === district)?.village || [];
    console.log(this.villages);
  }
}
