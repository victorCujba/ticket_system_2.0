package in.webformat.ticketsystem.data.models;

import in.webformat.ticketsystem.data.archetypes.Dto;
import in.webformat.ticketsystem.data.archetypes.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class Tasks implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_project")
    private Project project;

    @Column(name = "description")
    private String desc;

    @Column(name = "dead_line")
    private LocalDateTime deadline;

    @Builder.Default
    @ManyToMany(mappedBy = "tasksList")
    private List<Developer> developers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "tasks")
    private List<Commit> commits = new ArrayList<>();

    @Override
    public Dto toDto() {
        return null;
    }
}
