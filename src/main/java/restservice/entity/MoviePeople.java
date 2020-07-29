package restservice.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "moviepeople")
public class MoviePeople {

    @Id
    Integer id_moviepeople;

    @ManyToOne
    @JoinColumn(name = "id_movie", foreignKey = @ForeignKey(name = "fk_movietoperson"), nullable = false)
    Movie id_movie;

    @ManyToOne
    @JoinColumn(name = "id_person", foreignKey = @ForeignKey(name = "fk_persontomovie"), nullable = false)
    Person id_person;

    @Column(name = "character_name", length = 45)
    String character_name;

    public MoviePeople() {
    }

    public Integer getId_moviepeople() {
        return id_moviepeople;
    }

    public void setId_moviepeople(Integer id_moviepeople) {
        this.id_moviepeople = id_moviepeople;
    }

    public Movie getId_movie() {
        return id_movie;
    }

    public void setId_movie(Movie id_movie) {
        this.id_movie = id_movie;
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
        return "moviepeople{" +
                "id_moviepeople='" + id_moviepeople + '\'' + ", " +
                "id_movie='" + id_movie + '\'' + ", " +
                "id_person='" + id_person + '\'' + ", " +
                "character_name='" + character_name + '\'' +
                "}";
    }
}
