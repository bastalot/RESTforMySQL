package restservice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tvseries")
public class TVSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tvseries;
    @Column(name = "title", length = 45, nullable = false)
    private String title;
    @Column(name = "start_year", length = 4)
    private String start_year;
    @Column(name = "end_year", length = 4)
    private String end_year;
    @Lob
    @Column(name = "poster")
    private byte[] poster;

    @OneToMany(mappedBy = "id_tvseries")
    Set<TVSeriesGenres> tvSeriesGenresSet;

    @OneToMany(mappedBy = "id_tvseries")
    Set<TVSeassons> tvSeassonsSet;


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

    @Override
    public String toString(){
        return "tvseries{" +
                "id_tvseries='" + id_tvseries + '\'' + ", " +
                "title='" + title + '\'' + ", " +
                "start_year='" + start_year + '\'' + ", " +
                "end_year='" + end_year + '\'' + ", " +
                "poster='" + poster + '\'' +
                '}';
    }
}
