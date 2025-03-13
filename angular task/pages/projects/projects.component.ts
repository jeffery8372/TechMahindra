import { Component } from '@angular/core';
import { Project } from '../../model/project';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css',
})
export class ProjectsComponent {
  projectsList: Project[] = [];
  minTeamSize: number = 0;
  maxTeamSize: number = 100;
  selectedStatus: string = '';

  projectStatuses: string[] = [
    'Planned',
    'In Progress',
    'Completed',
    'On Hold',
  ]; // Example statuses

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getProjects().subscribe({
      next: (result: Project[]) => {
        this.projectsList = result.map((project) => ({
          ...project,
          startDate: new Date(project.startDate),
          endDate: new Date(project.endDate),
        }));
      },
      error: (error) => console.log('Error fetching projects:', error),
    });
  }
}
