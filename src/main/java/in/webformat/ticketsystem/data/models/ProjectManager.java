package in.webformat.ticketsystem.data.models;

import in.webformat.ticketsystem.data.archetypes.Dto;
import in.webformat.ticketsystem.data.archetypes.Model;
import in.webformat.ticketsystem.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProjectManager extends Employee implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "projectManager")
    private List<Team> teams;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private final EmployeeRole employeeRole = EmployeeRole.PROJECT_MANAGER;

    @Builder.Default
    @OneToMany(mappedBy = "projectManager")
    private List<Project> projectList = new ArrayList<>();

    @Override
    public Dto toDto() {
        return null;
    }
}
