package restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "tvseriesgenres")
public class TVSeriesGenres {

    @Id
    Integer id_tvseriesgenres;

    @ManyToOne
    @JoinColumn(name = "id_tvseries", foreignKey = @ForeignKey(name = "fk_tvseriestogenres"), nullable = false)
    TVSeries id_tvseries;

    @ManyToOne
    @JoinColumn(name = "id_genre", foreignKey = @ForeignKey(name = "fk_genrestoseries"), nullable = false)
    Genre id_genre;

    public TVSeriesGenres() {
    }

    public Integer getId_tvseriesgenres() {
        return id_tvseriesgenres;
    }

    public void setId_tvseriesgenres(Integer id_tvseriesgenres) {
        this.id_tvseriesgenres = id_tvseriesgenres;
    }

    public TVSeries getId_tvseries() {
        return id_tvseries;
    }

    public void setId_tvseries(TVSeries id_tvseries) {
        this.id_tvseries = id_tvseries;
    }

    public Genre getId_genre() {
        return id_genre;
    }

    public void setId_genre(Genre id_genre) {
        this.id_genre = id_genre;
    }

    @Override
    public String toString() {
        return "tvseriesgenres{" +
                "id_tvseriesgenres='" + '\'' + ", " +
                "id_tvseries='" + id_tvseries.getId_tvseries() + '\'' + ", " +
                "id_genre='" + id_genre.getId_genre() + '\'' +
                '}';
    }
}
