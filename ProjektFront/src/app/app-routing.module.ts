import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LaadimispunktListComponent} from "./components/laadimispunkt-list/laadimispunkt-list.component";
import {LaadimispunktComponent} from "./components/laadimispunkt/laadimispunkt.component";


const routes: Routes = [
  { path: 'list', component: LaadimispunktListComponent},
  { path: 'laadimispunkt/:id', component: LaadimispunktComponent},
  { path: '',   redirectTo: '/list', pathMatch: 'full'  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
