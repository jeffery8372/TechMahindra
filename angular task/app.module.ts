import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
  HttpClientModule,
  provideHttpClient,
  withFetch,
} from '@angular/common/http';
import { HomeComponent } from './pages/home/home.component';
import { CommonComponent } from './common/common.component';
import { BuyComponent } from './pages/buy/buy.component';
import { ServiceComponent } from './pages/service/service.component';
import { CartComponent } from './pages/cart/cart.component';
import { PriceFilterPipe } from './pipes/price-filter.pipe';
import { CompanyFilterPipe } from './pipes/company-filter.pipe';
import { LoginComponent } from './common/login/login.component';
import { OrdersComponent } from './pages/orders/orders.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CommonComponent,
    BuyComponent,
    ServiceComponent,
    CartComponent,
    PriceFilterPipe,
    CompanyFilterPipe,
    LoginComponent,
    OrdersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  bootstrap: [AppComponent],
  providers: [
    provideHttpClient(withFetch()), // Fix fetch API warning
  ],
})
export class AppModule {}
