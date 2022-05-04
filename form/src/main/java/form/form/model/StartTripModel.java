package form.form.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import form.form.
@Entity
@Table(name="trips_table")
public class StartTripModel {
    //City[] locations;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    Integer uid;
    String locations;
    String start1_date;
    String end1_date;
    String hotelname;
    String travelmode;
    String friends;

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }



    public String getStart1_date() {
        return start1_date;
    }

    public void setStart1_date(String start1_date) {
        this.start1_date = start1_date;
    }

    public String getEnd1_date() {
        return end1_date;
    }

    public void setEnd1_date(String end1_date) {
        this.end1_date = end1_date;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getTravelmode() {
        return travelmode;
    }

    public void setTravelmode(String travelmode) {
        this.travelmode = travelmode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartTripModel that = (StartTripModel) o;
        return Objects.equals(id, that.id) && Objects.equals(uid, that.uid) && Objects.equals(locations, that.locations) && Objects.equals(start1_date, that.start1_date) && Objects.equals(end1_date, that.end1_date) && Objects.equals(hotelname, that.hotelname) && Objects.equals(travelmode, that.travelmode) && Objects.equals(friends, that.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, locations, start1_date, end1_date, hotelname, travelmode, friends);
    }

    @Override
    public String toString() {
        return "StartTripModel{" +
                "id=" + id +
                ", uid=" + uid +
                ", locations='" + locations + '\'' +
                ", start1_date='" + start1_date + '\'' +
                ", end1_date='" + end1_date + '\'' +
                ", hotelname='" + hotelname + '\'' +
                ", travelmode='" + travelmode + '\'' +
                ", friends='" + friends + '\'' +
                '}';
    }
}
