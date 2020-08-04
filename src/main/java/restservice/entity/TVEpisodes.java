package restservice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tvepisodes")
public class TVEpisodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tvepisodes;
    @Column(name = "title", length = 45, nullable = false)
    private String title;
    @Lob
    @Column(name = "sumary")
    private String summary;
    @Column(name = "airdate", length = 10)
    private String airdate;

    @ManyToOne
    @JoinColumn(name = "id_tvseassons", foreignKey = @ForeignKey(name = "fk_tvseassonstotvepisodes"), nullable = false)
    TVSeassons id_tvseassons;

    @OneToMany(mappedBy = "id_tvepisodes", cascade = CascadeType.REMOVE)
    Set<SeriesPeople> seriesPeopleSet;

    public TVEpisodes() {
    }

    public Integer getId_tvepisodes() {
        return id_tvepisodes;
    }

    public void setId_tvepisodes(Integer id_tvepisodes) {
        this.id_tvepisodes = id_tvepisodes;
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

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public TVSeassons getId_tvseassons() {
        return id_tvseassons;
    }

    public void setId_tvseassons(TVSeassons id_tvseassons) {
        this.id_tvseassons = id_tvseassons;
    }

    @Override
    public String toString() {
        return "tvepisodes{" +
                "id_tvepisodes='" + id_tvepisodes + '\'' + ", " +
                "title='" + title + '\'' + ", " +
                "summary='" + summary + '\'' + ", " +
                "airdate='" + airdate + '\'' + ", " +
                "id_tvseassons='" + id_tvseassons.getId_tvseassons() + '\'' +
                '}';
    }
}
