import {Component, OnInit, ViewChild} from '@angular/core';
import {Laadimispunkt} from "../../model/laadimispunkt";
import {Router} from "@angular/router";
import {LaadimispunktServiceService} from "../../service/laadimispunkt-service.service";
import {MatSort} from "@angular/material/sort";
import {Koondaruanne} from "../../model/koondaruanne";

@Component({
  selector: 'app-koodaruanne-nimekiri',
  templateUrl: './koodaruanne-nimekiri.component.html',
  styleUrls: ['./koodaruanne-nimekiri.component.css']
})
export class KoodaruanneNimekiriComponent implements OnInit {

  displayedColumns: string[] = ['seisundi_kood', 'nimetus', 'laadimispunktide_arv']
  dataSource!: Koondaruanne[];

  constructor(private router: Router, public laadimispunktService: LaadimispunktServiceService) {}

  @ViewChild(MatSort) sort!: MatSort;

  ngOnInit() {
    this.laadimispunktService.getAllKoodaruanne().subscribe(data => this.dataSource = data);
  }




}
