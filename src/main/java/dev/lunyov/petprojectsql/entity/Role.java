package dev.lunyov.petprojectsql.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<RolePermission> rolePermissions;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles;
}