package dev.lunyov.petprojectsql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_time", nullable = false, updatable = false)
    private LocalDateTime creationTime;

    @Column(name = "modification_time", nullable = false)
    private LocalDateTime modificationTime;

    @OneToMany(mappedBy = "role")
    private Set<RolePermission> rolePermissions;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        id = UUID.randomUUID();
        creationTime = now;
        modificationTime = now;
    }

    @PreUpdate
    protected void onUpdate() {
        modificationTime = LocalDateTime.now();
    }
}