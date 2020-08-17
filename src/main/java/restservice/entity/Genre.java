package restservice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_genre;
    @Column(name = "genre_name", length = 45, unique = true)
    private String genre_name;

    @OneToMany(mappedBy = "id_genre", cascade = CascadeType.REMOVE)
    Set<MovieGenres> movieGenresSet;

    @OneToMany(mappedBy = "id_genre", cascade = CascadeType.REMOVE)
    Set<TVSeriesGenres> tvSeriesGenresSet;


    public Integer getId_genre() {
        return id_genre;
    }

    public void setId_genre(Integer id_genre) {
        this.id_genre = id_genre;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Set<MovieGenres> getMovieGenresSet() {
        return movieGenresSet;
    }

    public void setMovieGenresSet(Set<MovieGenres> movieGenresSet) {
        this.movieGenresSet = movieGenresSet;
    }

    public Set<TVSeriesGenres> getTvSeriesGenresSet() {
        return tvSeriesGenresSet;
    }

    public void setTvSeriesGenresSet(Set<TVSeriesGenres> tvSeriesGenresSet) {
        this.tvSeriesGenresSet = tvSeriesGenresSet;
    }

    @Override
    public String toString() {
        return "genre{" +
                "id_genre='" + id_genre + '\'' + ", " +
                "genre_name='" + genre_name + '\'' +
                "}";
    }
}
