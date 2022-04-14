import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Laadimispunkt} from "../../model/laadimispunkt";
import {LaadimispunktServiceService} from "../../service/laadimispunkt-service.service";

@Component({
  selector: 'app-laadimispunkt',
  templateUrl: './laadimispunkt.component.html',
  styleUrls: ['./laadimispunkt.component.css']
})
export class LaadimispunktComponent implements OnInit {

  laadimispunkt: Laadimispunkt | undefined = undefined;
  form: FormGroup = this.initForm();
  id: string | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private laadimispunkt_service: LaadimispunktServiceService,
    private formBuilder: FormBuilder
  ) {
  }
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');

    if (this.id !== null && this.id !== 'new') {
      this.laadimispunkt_service.get(BigInt(this.id)).subscribe((data) => {
        this.form = this.initForm(data);
        this.laadimispunkt = data;

      });

    }
  }

  lopetaLaadimispunkt() {

  }

  hasError(path: string, errorCode: string) {
    return this.form && this.form.hasError(errorCode, path);
  }

  navigateToLaadimispunktList() {
    this.router.navigate(['list']).then();
  }

  initForm(laadimispunkt?: Laadimispunkt) {
    return this.formBuilder.group({
      laadimispunkti_kood: new FormControl(
        {
         value: laadimispunkt?.laadimispunkti_kood || '',
          disabled: true,
        }
  ),
      nimetus: new FormControl(
        {
          value: laadimispunkt?.nimetus || '',
          disabled: true,

        }
      ),
      laiuskraad: new FormControl(
        {
          value: laadimispunkt?.laiuskraad || '',
         disabled: true,

  }

      ),
      pikkuskraad: new FormControl(
        {
          value: laadimispunkt?.pikkuskraad || '',
          disabled: true,
        },
      ),
      reg_aeg: new FormControl(
        {
          value: laadimispunkt?.reg_aeg || '',
          disabled: true,

        },
      ),
      registreerija_id: new FormControl(
        {
          value: laadimispunkt?.registreerija_id || '',
          disabled: true,
      }
      ),
      laadimispunkti_seisundi_liik_kood: new FormControl(
        {
          value: laadimispunkt?.laadimispunkti_seisundi_liik_kood || '',
          disabeld: true,
      }
      ),
      laadimispunkti_tyyp_id: new FormControl(
        {
          value: laadimispunkt?.laadimispunkti_tyyp_id || '',
          disabled: true,
      }

      )
    });
  }




}
