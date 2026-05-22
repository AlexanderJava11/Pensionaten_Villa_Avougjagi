package Pensionaten.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType roomType;

    @Min(0)
    @Max(2)
    private int extraBeds;

    @Min(0)
    @Builder.Default
    private int pricePerNight = 995;

    public int getCapacity() {
        return roomType.getBaseCapacity() + extraBeds;
    }
}
