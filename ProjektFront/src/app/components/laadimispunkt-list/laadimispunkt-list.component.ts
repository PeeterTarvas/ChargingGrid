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

  displayedColumns: string[] = ['laadimispunkti_kood', 'laiuskraad', 'nimetus', 'pikkuskraad' ]
  dataSource: Laadimispunkt[] = [];

  constructor(private router: Router, public laadimispunktService: LaadimispunktServiceService) {}

  ngOnInit() {
    this.laadimispunktService.getAll().subscribe(data => this.dataSource);
  }

  navigateToLaadimispunktById(id: bigint) {
    this.router.navigate(['/laadimispunkt/', id]).then(r => r);
  }

}
