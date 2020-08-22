package restservice.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tvseries")
public class TVSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tvseries;
    @Column(name = "title", length = 45, nullable = false)
    private String title;
    @Lob
    @Column(name = "summary")
    private String summary;
    @Column(name = "start_year", length = 4)
    private String start_year;
    @Column(name = "end_year", length = 4)
    private String end_year;
    @Lob
    @Column(name = "poster")
    private byte[] poster;

    @OneToMany(mappedBy = "id_tvseries", cascade = CascadeType.REMOVE)
    Set<TVSeriesGenres> tvSeriesGenresSet;

    @OneToMany(mappedBy = "id_tvseries", cascade = CascadeType.REMOVE)
    Set<TVSeassons> tvSeassonsSet;

    @OneToMany(mappedBy = "id_tvseries", cascade = CascadeType.REMOVE)
    Set<SeriesPeople> seriesPeopleSet;


    public TVSeries() {
    }

    public Integer getId_tvseries() {
        return id_tvseries;
    }

    public void setId_tvseries(Integer id_tvseries) {
        this.id_tvseries = id_tvseries;
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

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }

    public String getEnd_year() {
        return end_year;
    }

    public void setEnd_year(String end_year) {
        this.end_year = end_year;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    /*
    public List<Integer> getTvSeriesGenresSet() {
        List<Integer> set = new ArrayList<>();

        for (int i = 0; i < tvSeriesGenresSet.size(); i++) {
            set.add(tvSeriesGenresSet.iterator().next().getId_tvseriesgenres());
        }
        return set;
    }

    public List<Integer> getTvSeassonsSet() {
        List<Integer> set = new ArrayList<>();

        for (int i = 0; i < tvSeassonsSet.size(); i++) {
            set.add(tvSeassonsSet.iterator().next().getId_tvseassons());
        }
        return set;
    }

    public List<Integer> getSeriesPeopleSet() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < seriesPeopleSet.size(); i++) {
            list.add(seriesPeopleSet.iterator().next().getId_seriespeople());
        }
        return list;
    } */

    @Override
    public String toString(){
        return "tvseries{" +
                "id_tvseries='" + id_tvseries + '\'' + ", " +
                "title='" + title + '\'' + ", " +
                "summary='" + summary + '\'' + ", " +
                "start_year='" + start_year + '\'' + ", " +
                "end_year='" + end_year + '\'' + ", " +
                "poster='" + poster + '\'' +
                '}';
    }
}
