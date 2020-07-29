package restservice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_person;
    @Column(name = "person_name", length = 45, nullable = false)
    private String person_name;

    @OneToMany(mappedBy = "id_person")
    Set<MoviePeople> moviePeopleSet;

    @OneToMany(mappedBy = "id_person")
    Set<PersonRole> personRoleSet;

    @OneToMany(mappedBy = "id_person")
    Set<SeriesPeople> seriesPeopleSet;

    public Person() {
    }

    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    @Override
    public String toString() {
        return "person{" +
                "id_person='" + id_person + '\'' + ", " +
                "person_name='" + person_name + '\'' +
                '}';
    }
}
