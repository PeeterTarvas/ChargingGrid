import {Component, OnInit, ViewChild} from '@angular/core';
import {Laadimispunkt} from "../../model/laadimispunkt";
import {Router} from "@angular/router";
import {LaadimispunktServiceService} from "../../service/laadimispunkt-service.service";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-laadimispunkt-list',
  templateUrl: './laadimispunkt-list.component.html',
  styleUrls: ['./laadimispunkt-list.component.css']
})
export class LaadimispunktListComponent implements OnInit {


  displayedColumns: string[] = ['laadimispunkti_kood', 'nimetus', 'pikkuskraad', 'laiuskraad', 'laadimispunkti_seisundi_nimetus']
  dataSource!: Laadimispunkt[];

  constructor(private router: Router, public laadimispunktService: LaadimispunktServiceService) {}

  @ViewChild(MatSort) sort!: MatSort;

  ngOnInit() {
    this.laadimispunktService.getAll().subscribe(data => this.dataSource = data);
  }

  navigateToLaadimispunktById(id: bigint) {
    this.router.navigate(['/laadimispunkt',id]).then(r => r);
  }

}
