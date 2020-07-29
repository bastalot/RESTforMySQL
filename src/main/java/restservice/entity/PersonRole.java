package restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "personrole")
public class PersonRole {

    @Id
    Integer id_personrole;

    @ManyToOne
    @JoinColumn(name = "id_person", foreignKey = @ForeignKey(name = "fk_persontorole"), nullable = false)
    Person id_person;

    @ManyToOne
    @JoinColumn(name = "id_role", foreignKey = @ForeignKey(name = "fk_roletoperson"), nullable = false)
    Role id_role;

    public PersonRole() {
    }

    public Integer getId_personrole() {
        return id_personrole;
    }

    public void setId_personrole(Integer id_personrole) {
        this.id_personrole = id_personrole;
    }

    public Person getId_person() {
        return id_person;
    }

    public void setId_person(Person id_person) {
        this.id_person = id_person;
    }

    public Role getId_role() {
        return id_role;
    }

    public void setId_role(Role id_role) {
        this.id_role = id_role;
    }

    @Override
    public String toString() {
        return "personrole{" +
                "id_personrole='" + id_personrole + '\'' + ", " +
                "id_person='" + id_person + '\'' + ", " +
                "id_role='" + id_role + '\'' +
                '}';
    }

}
