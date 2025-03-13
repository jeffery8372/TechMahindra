import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { BuyComponent } from './pages/buy/buy.component';
import { ServiceComponent } from './pages/service/service.component';
import { CartComponent } from './pages/cart/cart.component';
import { LoginComponent } from './common/login/login.component';
import { OrdersComponent } from './pages/orders/orders.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'buy', component: BuyComponent },
  { path: 'service', component: ServiceComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'buy', component: BuyComponent },
  { path: 'cart', component: CartComponent },
  {path:'orders',component:OrdersComponent},
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: 'buy' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
