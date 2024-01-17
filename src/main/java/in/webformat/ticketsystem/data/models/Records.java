package in.webformat.ticketsystem.data.models;

import in.webformat.ticketsystem.data.archetypes.Dto;
import in.webformat.ticketsystem.data.archetypes.Model;
import in.webformat.ticketsystem.enums.RecordsType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "records")
public class Records implements Model {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_record")
    private RecordsType type;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTimeOfRecord;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_badge")
    private Badge badge;

    @Override
    public Dto toDto() {
        return null;
    }
}
