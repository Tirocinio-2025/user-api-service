package tech.aesys.finale.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user_role")
public
@Data
@AllArgsConstructor
@NoArgsConstructor
class UserRole {

    @EmbeddedId
    private UserRolePK id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @ManyToOne
    @MapsId("role_id")
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    
}
