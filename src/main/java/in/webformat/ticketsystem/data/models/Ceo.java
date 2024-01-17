package in.webformat.ticketsystem.data.models;

import in.webformat.ticketsystem.data.archetypes.Dto;
import in.webformat.ticketsystem.data.archetypes.Model;
import in.webformat.ticketsystem.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Ceo extends Employee implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private final EmployeeRole employeeRole = EmployeeRole.CEO;

    @Override
    public Dto toDto() {
        return null;
    }
}
