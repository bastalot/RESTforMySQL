package restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "moviegenres")
public class MovieGenres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_moviegenres;

    @ManyToOne
    @JoinColumn(name = "id_movie", foreignKey = @ForeignKey(name = "fk_movietogenre"), nullable = false)
    Movie id_movie;

    @ManyToOne
    @JoinColumn(name = "id_genre", foreignKey = @ForeignKey(name = "fk_genretomovie"), nullable = false)
    Genre id_genre;

    public MovieGenres() {
    }

    public Integer getId_moviegenres() {
        return id_moviegenres;
    }

    public void setId_moviegenres(Integer id_moviegenres) {
        this.id_moviegenres = id_moviegenres;
    }

    public Movie getId_movie() {
        return id_movie;
    }

    public void setId_movie(Movie id_movie) {
        this.id_movie = id_movie;
    }

    public Genre getId_genre() {
        return id_genre;
    }

    public void setId_genre(Genre id_genre) {
        this.id_genre = id_genre;
    }

    @Override
    public String toString() {
        return "moviegenres{" +
                "id_moviegenres='" + id_moviegenres + '\'' + ", " +
                "id_movie='" + id_movie.getId_movie() + '\'' + ", " +
                "id_genre='" + id_genre.getId_genre() + '\'' +
                "}";
    }
}
