import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { District } from 'src/app/Model/District';
import { Product } from 'src/app/Model/Product';
import { Province } from 'src/app/Model/Province';
import { Ward } from 'src/app/Model/Ward';
import { ServiceUserService } from 'src/app/Service/service-user.service';
// import { ProvincesService } from 'src/app/Service/service-user.service';
// import { DistrictsService } from 'src/app/Service/service-user.service';
// import { WardsService } from 'src/app/Service/service-user.service';


@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})

export class EditUserComponent implements OnInit {
  product: any = new Product();
  showAlert = false;
  submitted = false;
  // provinces: any = {};
  // districts: any = {};
  // wards: any = {};
  Provinces?: Province[];
  selectedProvince?: any;
  Districts?: District[];
  selectedDistrict?: any;
  Wards?: Ward[];
  selectedWard?: any;
  id?: any;
  constructor(private route: ActivatedRoute, private fb: FormBuilder, private router: Router, private service: ServiceUserService) { }
  public form: any = FormGroup;
  ngOnInit(): void {
    this.editUser(); this.formInit();
    // this.service.getProvinces().subscribe(
    //   data => this.provinces = data
    // );

    // this.service.getProvince().subscribe(data => {
    //   this.Provinces = data
    // });
    // this.service.getDistrict().subscribe(data => {
    //   this.Districts = data
    // });
    // this.service.getWard().subscribe(data => {
    //   this.Wards = data;

    // });
    this.getProvince();
    this.getDistricts();
    this.getAllWards();


  }

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
      ward: ['', [Validators.required]],

    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }


  editUser() {
    let id = String(localStorage.getItem("id") || "");
    this.service.getUserId(id)
      .subscribe(data => {
        this.product = Object.values(data);
        this.product = this.product[0];
      })
  }

  onSubmit() {
    // this.service.getProvinceById(this.product.province).subscribe(data => {
    //   this.Provinces = data.id;
    // });
    // this.service.getDistrictById(this.product.district).subscribe(data => {
    //   this.Districts = data.id;
    // });
    // this.service.getWardById(this.product.ward).subscribe(data => {
    //   this.Wards = data.id;
    // });

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


  // public cities = [
  //   {
  //     city: 'Chọn thành phố!',
  //     district: [],
  //     // village: [],
  //   },
  //   {
  //     city: 'Hn',
  //     district: [
  //       'HN',
  //       'HN',
  //       'HN',
  //       'HN',
  //       'HN',
  //       'HN',
  //       'HN',
  //     ],

  //   },
  //   {
  //     city: 'HP',
  //     district: [
  //       'HP',
  //       'HP',
  //       'HP',
  //       'HP',
  //       'HP',
  //       'HP',
  //       'HP',
  //     ],

  //   },
  //   {
  //     city: 'DN',
  //     district: [
  //       'DN',
  //       'DN',
  //       'DN',
  //       'DN',
  //       'DN',
  //       'DN',
  //       'DN',
  //     ],
  //   },
  // ];
  // public districts: string[] = ['quan/huyen'];

  // public villages: string[] = ['lang/xa'];

  // public changeCity(event: any) {
  //   const city = event.target.value;

  //   if (!city) {
  //     return;
  //   }
  //   //cach 1
  //   // const search = this.cities.filter(data => data.city === city)
  //   // console.log('event', search);
  //   // if (search && search.length > 0) {
  //   //   this.districts = search[0].district;
  //   // }

  //   // const search2 = this.cities.filter(data => data.district === this.districts)
  //   // console.log('event', search2);
  //   // if (search2 && search2.length > 0) {
  //   //   this.districts = search2[0].village;
  //   // }

  //   //cach 2 
  //   this.districts = this.cities.find(data => data.city === city)?.district || [];

  // }

  // public changeDistrict(event: any) {
  //   const district = event.target.value;
  //   const village = event.target.value;
  //   console.log(village);
  //   if (!district) {
  //     return;
  //   }

  //   // this.villages = this.cities.find(data => data.district === district)?.village || [];
  //   // console.log(this.villages);
  // }


  /////

  // onChangeCountry(provinceId: any) {
  //   if (provinceId) {
  //     this.service.getProvinceId(provinceId).subscribe(
  //       data => {
  //         this.districts = data;
  //         this.wards = null;
  //       }
  //     );
  //   } else {
  //     this.districts = null;
  //     this.wards = null;
  //   }
  // }

  // onChangeState(stateId: number) {
  //   if (stateId) {
  //     this.service.getDistrictId(stateId).subscribe(
  //       data => this.wards = data
  //     );
  //   } else {
  //     this.wards = null;
  //   }
  // }


  getProvince() {
    this.service.getProvince().subscribe(data => {
      console.log("thành công", data);
      this.Provinces = data;
    }, error => {
      console.log("lỗi", error);
    });
  }
  getDistricts() {
    this.service.getDistrict().subscribe(data => {
      console.log("thành công", data);
      this.Districts = data;
    }, error => {
      console.log("lỗi", error);
    });
  }
  private getAllWards() {
    this.service.getWard().subscribe(data => {
      console.log("thành công", data);
      this.Wards = data;
    }, error => {
      console.log("lỗi", error);
    });
  }


}
