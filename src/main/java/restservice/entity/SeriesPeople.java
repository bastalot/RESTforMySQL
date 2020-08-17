package restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "seriespeople")
public class SeriesPeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_seriespeople;

    @ManyToOne
    @JoinColumn(name = "id_tvseries", foreignKey = @ForeignKey(name = "fk_tvseriestoseriespeople"), nullable = false)
    TVSeries id_tvseries;

    @ManyToOne
    @JoinColumn(name = "id_person", foreignKey = @ForeignKey(name = "fk_persontoseries"), nullable = false)
    Person id_person;

    @Column(name = "character_name", length = 45)
    String character_name;

    public SeriesPeople() {
    }

    public Integer getId_seriespeople() {
        return id_seriespeople;
    }

    public void setId_seriespeople(Integer id_seriespeople) {
        this.id_seriespeople = id_seriespeople;
    }

    public TVSeries getId_tvseries() {
        return id_tvseries;
    }

    public void setId_tvseries(TVSeries id_tvseries) {
        this.id_tvseries = id_tvseries;
    }

    public Person getId_person() {
        return id_person;
    }

    public void setId_person(Person id_person) {
        this.id_person = id_person;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    @Override
    public String toString() {
        return "seriespeople{" +
                "id_seriespeople='" + id_seriespeople + '\'' + ", " +
                "id_tvseries='" + id_tvseries.toString() + '\'' + ", " +
                "id_person='" + id_person.toString() + '\'' + ", " +
                "character_name='" + character_name + '\'' +
                '}';
    }
}
