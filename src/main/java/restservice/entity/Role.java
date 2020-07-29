package restservice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_role;
    @Column(name = "role_type", length = 45, nullable = false)
    private String role_type;

    @OneToMany(mappedBy = "id_role")
    Set<PersonRole> personRoleSet;

    public Role() {
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    @Override
    public String toString() {
        return "role{" +
                "id_role='" + id_role + '\'' + ", " +
                "role_type='" + role_type + '\'' +
                '}';
    }
}
