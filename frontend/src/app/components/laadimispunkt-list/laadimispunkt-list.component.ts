import {Component, OnInit, ViewChild} from '@angular/core';
import {Laadimispunkt} from "../../model/laadimispunkt";
import {Router} from "@angular/router";
import {LaadimispunktServiceService} from "../../service/laadimispunkt-service.service";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-laadimispunkt-list',
  templateUrl: './laadimispunkt-list.component.html',
  styleUrls: ['./laadimispunkt-list.component.css']
})
export class LaadimispunktListComponent implements OnInit {

  @ViewChild(MatSort) sortForDataSource!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sortForDataSource;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }

  displayedColumns: string[] = ['laadimispunkti_kood', 'nimetus', 'pikkuskraad', 'laiuskraad', 'laadimispunkti_seisundi_nimetus']
  dataSource = new MatTableDataSource<Laadimispunkt>();

  constructor(private router: Router, public laadimispunktService: LaadimispunktServiceService) {}

  ngOnInit() {
    this.laadimispunktService.getAll().subscribe(data => this.dataSource.data = data);
  }

  navigateToLaadimispunktById(id: bigint) {
    this.router.navigate(['/laadimispunkt',id]).then(r => r);
  }
}
