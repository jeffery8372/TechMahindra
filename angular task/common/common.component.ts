import { Component, Inject, PLATFORM_ID } from '@angular/core';
import { Router } from '@angular/router';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-common',
  templateUrl: './common.component.html',
  styleUrls: ['./common.component.css'],
})
export class CommonComponent {
  loginmenu: string = 'Login'; // Default value
  status: boolean = false; // Status should be false by default

  constructor(
    @Inject(PLATFORM_ID) private platformId: object,
    private router: Router
  ) {
    if (isPlatformBrowser(this.platformId)) {
      this.updateLoginMenu();
    }
  }

  updateLoginMenu() {
    if (isPlatformBrowser(this.platformId)) {
      const user = localStorage.getItem('username');
      this.status = !!user; // Set status to true only if user exists
      this.loginmenu = user ? 'Logout' : 'Login';
    }
  }

  loginHandler() {
    if (isPlatformBrowser(this.platformId)) {
      if (this.status) {
        localStorage.removeItem('username');
        this.status = false;
        this.loginmenu = 'Login(admin)';
        this.router.navigate(['/login']);
      } else {
        this.router.navigate(['/login']);
      }
    }
  }
}
