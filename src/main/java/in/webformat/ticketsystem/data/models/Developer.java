package in.webformat.ticketsystem.data.models;

import in.webformat.ticketsystem.data.archetypes.Dto;
import in.webformat.ticketsystem.data.archetypes.Model;
import in.webformat.ticketsystem.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Developer extends Employee implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "developer_tasks",
            joinColumns = @JoinColumn(name = "id_developer"),
            inverseJoinColumns = @JoinColumn(name = "id_task")
    )
    private List<Tasks> tasksList;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_team")
    private Team team;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private final EmployeeRole employeeRole = EmployeeRole.DEVELOPER;

    @Column(name = "referenced_project_manager")
    private String referencedPM;

    @Override
    public Dto toDto() {
        return null;
    }
}
