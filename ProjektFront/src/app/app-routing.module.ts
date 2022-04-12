import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LaadimispunktListComponent} from "./components/laadimispunkt-list/laadimispunkt-list.component";


const routes: Routes = [
  { path: 'laadimispunktid', component: LaadimispunktListComponent },
  { path: '**', redirectTo: '/laadimispunktid', pathMatch: 'full' },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
