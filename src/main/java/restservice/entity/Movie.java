package restservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_movie;
    @Column(name = "title", length = 45, nullable = false)
    private String title;
    @Lob
    @Column(name = "summary")
    private String summary;
    @Column(name = "release_date", length = 4)
    private String release_date;
    @Column(name = "runtime", length = 10)
    private String runtime;
    @Lob
    @Column(name = "poster")
    private byte[] poster;

    @OneToMany(mappedBy = "id_movie", cascade = CascadeType.REMOVE)
    Set<MoviePeople> moviePeopleSet;

    @OneToMany(mappedBy = "id_movie", cascade = CascadeType.REMOVE)
    Set<MovieGenres> movieGenresSet;



    public Movie() {

    }

    public Integer getId_movie() {
        return id_movie;
    }

    public void setId_movie(Integer idMovie) {
        this.id_movie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    /*
    public Set<MoviePeople> getMoviePeopleSet() {
        return moviePeopleSet;
    }

    public void setMoviePeopleSet(Set<MoviePeople> moviePeopleSet) {
        this.moviePeopleSet = moviePeopleSet;
    }

    public Set<MovieGenres> getMovieGenresSet() {
        return movieGenresSet;
    }

    public void setMovieGenresSet(Set<MovieGenres> movieGenresSet) {
        this.movieGenresSet = movieGenresSet;
    } */

    @Override
    public String toString() {
        return "movie{" +
                "id_movie='" + id_movie + '\'' +  ", " +
                "title='" + title + '\'' + ", " +
                "summary='" + summary + '\'' + ", " +
                "release_date='" + release_date + '\'' + ", " +
                "runtime='" + runtime + '\'' + ", " +
                "poster='" + poster + '\'' +
                '}';
    }
}

