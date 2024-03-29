package in.webformat.ticketsystem.data.models;

import in.webformat.ticketsystem.data.archetypes.Model;
import in.webformat.ticketsystem.data.dto.ItCompanyDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "it_company")
public class ItCompany implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "itCompany")
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public ItCompanyDto toDto() {
        return null;
    }


}
