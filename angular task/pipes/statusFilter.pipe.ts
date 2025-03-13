import { Pipe, PipeTransform } from '@angular/core';
import { Project } from '../model/project';

@Pipe({
  name: 'statusFilter',
})
export class StatusFilterPipe implements PipeTransform {
  transform(projects: Project[], status: string): Project[] {
    if (!projects || !status || status === 'All') return projects;
    return projects.filter(
      (project) => project.status.toLowerCase() === status.toLowerCase()
    );
  }
}
