import { Pipe, PipeTransform } from '@angular/core';
import { Project } from '../model/project';

@Pipe({
  name: 'teamSizeFilter',
})
export class TeamSizeFilterPipe implements PipeTransform {
  transform(projects: Project[], minSize: number, maxSize: number): Project[] {
    if (!projects) return [];
    if (!minSize && !maxSize) return projects;

    return projects.filter((project) => {
      return (
        (!minSize || project.teamSize >= minSize) &&
        (!maxSize || project.teamSize <= maxSize)
      );
    });
  }
}
