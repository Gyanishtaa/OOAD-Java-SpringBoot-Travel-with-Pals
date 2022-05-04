package form.form.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@Entity
@Table(name="posts_table")
public class AddPostModel {
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    Integer uid;
    String photos;
    String caption;
    String locatn;
  //  String friends;

   /* public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }*/

    public Integer getId(){
        return id;
    }
    public void setId(Integer id)
    {
        this.id=id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLocatn() {
        return locatn;
    }

    public void setLocatn(String locatn) {
        this.locatn = locatn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddPostModel that = (AddPostModel) o;
        return Objects.equals(id, that.id) && Objects.equals(uid, that.uid) && Objects.equals(photos, that.photos) && Objects.equals(caption, that.caption) && Objects.equals(locatn, that.locatn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, photos, caption, locatn);
    }

    @Override
    public String toString() {
        return "AddPostModel{" +
                "id=" + id +
                ", uid=" + uid +
                ", photos='" + photos + '\'' +
                ", caption='" + caption + '\'' +
                ", locatn='" + locatn + '\'' + '}';
    }
}
