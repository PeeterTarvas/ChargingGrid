import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LaadimispunktListComponent} from "./components/laadimispunkt-list/laadimispunkt-list.component";


const routes: Routes = [
  { path: 'list', component: LaadimispunktListComponent},
  { path: 'laadimispunkt', component: LaadimispunktListComponent},
  { path: '',   redirectTo: '/list', pathMatch: 'full'  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
