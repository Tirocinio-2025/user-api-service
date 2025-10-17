package tech.aesys.finale.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDetailResponseDTO {

    private String username;
    private List<RoleResponseDTO> roles;

}
