import { Component, OnInit } from '@angular/core';
import {Laadimispunkt} from "../../model/laadimispunkt";
import {Router} from "@angular/router";
import {LaadimispunktServiceService} from "../../model/laadimispunkt-service.service";

@Component({
  selector: 'app-laadimispunkt-list',
  templateUrl: './laadimispunkt-list.component.html',
  styleUrls: ['./laadimispunkt-list.component.css']
})
export class LaadimispunktListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'address', 'sectorCode', 'actions'];
  dataSource: Laadimispunkt[] = [];

  constructor(private router: Router, private laadimispunktService: LaadimispunktServiceService) {}

  ngOnInit() {
    this.laadimispunktService.getAll().subscribe(buildings => this.dataSource = buildings);
  }

  navigateToBuildingById(id: bigint) {
    this.router.navigate(['/building/', id]).then(r => r);
  }

  navigateToBuildingNew() {
    this.router.navigate(['/building/new']);
  }

}
