package Pensionaten.dto;

import jakarta.validation.constraints.*;
import lombok.*;

// DTO som används när kunder skapas, ändras och visas i webben.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Förnamn får inte vara tomt")
    @Size(max = 50, message = "Förnamn får max vara 50 tecken")
    private String firstName;

    @NotBlank(message = "Efternamn får inte vara tomt")
    @Size(max = 50, message = "Efternamn får max vara 50 tecken")
    private String lastName;

    @NotBlank(message = "E-post får inte vara tomt")
    @Email(message = "E-post måste vara giltig")
    private String email;

    // Enkel validering för svenska och internationella telefonnummer
    @Pattern(
            regexp = "^\\+?[0-9]{1,4}?[ .-]?[0-9]{6,12}$",
            message = "Telefonnummer är ogiltigt"
    )
    private String phone;
}