import { Component, OnInit } from '@angular/core';
import {Laadimispunkt} from "../../model/laadimispunkt";
import {Router} from "@angular/router";
import {LaadimispunktServiceService} from "../../service/laadimispunkt-service.service";

@Component({
  selector: 'app-laadimispunkt-list',
  templateUrl: './laadimispunkt-list.component.html',
  styleUrls: ['./laadimispunkt-list.component.css']
})
export class LaadimispunktListComponent implements OnInit {

  displayedColumns: string[] = ['laadimispunkti_kood', 'laiuskraad', 'nimetus', 'pikkuskraad', 'reg_aeg', 'registreerija_id', 'laadimispunkti_seisundi_liik_kood', 'laadimispunkti_tyyp_id: string;']
  dataSource: Laadimispunkt[] = [];

  constructor(private router: Router, private laadimispunktService: LaadimispunktServiceService) {}

  ngOnInit() {
    this.laadimispunktService.getAll();
  }

  navigateToLaadimispunktById(id: bigint) {
    this.router.navigate(['/laadimispunkt/', id]).then(r => r);
  }

}
