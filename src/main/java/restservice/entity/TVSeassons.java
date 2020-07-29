package restservice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tvseassons")
public class TVSeassons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tvseassons;
    @Lob
    @Column(name = "summary")
    private String summary;
    @Column(name = "seasson_number", nullable = false)
    private Integer seasson_number;

    @ManyToOne
    @JoinColumn(name = "id_tvseries", foreignKey = @ForeignKey(name = "fk_tvseriestotvseassons"), nullable = false)
    TVSeries id_tvseries;

    @OneToMany(mappedBy = "id_tvseassons")
    Set<TVEpisodes> tvEpisodesSet;

    public TVSeassons() {
    }

    public Integer getId_tvseassons() {
        return id_tvseassons;
    }

    public void setId_tvseassons(Integer id_tvseassons) {
        this.id_tvseassons = id_tvseassons;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getSeasson_number() {
        return seasson_number;
    }

    public void setSeasson_number(Integer seasson_number) {
        this.seasson_number = seasson_number;
    }

    public TVSeries getId_tvseries() {
        return id_tvseries;
    }

    public void setId_tvseries(TVSeries id_tvseries) {
        this.id_tvseries = id_tvseries;
    }

    @Override
    public String toString() {
        return "tvseassons{" +
                "id_tvseassons='" + id_tvseassons + '\'' + ", " +
                "summary='" + summary + '\'' + ", " +
                "season_number='" + seasson_number + '\'' + ", " +
                "id_tvseries='" + id_tvseries.getId_tvseries() + '\'' +
                '}';
    }
}
