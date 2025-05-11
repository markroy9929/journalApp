package net.engineeringdigest.journalApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotEmpty
    @Schema(description = "The user's username")
    private String userName;
    @NotEmpty
    @Schema(description = "The user's password")
    private String password;
}
