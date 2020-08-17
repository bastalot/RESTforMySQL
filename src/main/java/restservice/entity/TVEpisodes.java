package restservice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tvepisodes")
public class TVEpisodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tvepisodes;
    @Column(name = "title", length = 45)
    private String title;


    @ManyToOne
    @JoinColumn(name = "id_tvseassons", foreignKey = @ForeignKey(name = "fk_tvseassonstotvepisodes"), nullable = false)
    TVSeassons id_tvseassons;

    @Column(name = "episode_number", nullable = false)
    private Integer episode_number;

    //@OneToMany(mappedBy = "id_tvepisodes", cascade = CascadeType.REMOVE)
    //Set<SeriesPeople> seriesPeopleSet;

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

    public TVSeassons getId_tvseassons() {
        return id_tvseassons;
    }

    public void setId_tvseassons(TVSeassons id_tvseassons) {
        this.id_tvseassons = id_tvseassons;
    }

    public Integer getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(Integer episode_number) {
        this.episode_number = episode_number;
    }

    @Override
    public String toString() {
        return "tvepisodes{" +
                "id_tvepisodes='" + id_tvepisodes + '\'' + ", " +
                "title='" + title + '\'' + ", " +
                "id_tvseassons='" + id_tvseassons.getId_tvseassons() + '\'' + ", " +
                "episode_number='" + episode_number + '\'' +
                '}';
    }
}
