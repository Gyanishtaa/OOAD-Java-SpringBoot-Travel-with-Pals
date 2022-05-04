package form.form.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="journal_table")
public class JournalModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    Integer uid;
    String jtitle;
    String text;
    String locatn;

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

    public String getJtitle() {
        return jtitle;
    }

    public void setJtitle(String jtitle) {
        this.jtitle = jtitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        JournalModel that = (JournalModel) o;
        return Objects.equals(id, that.id) && Objects.equals(uid, that.uid) && Objects.equals(jtitle, that.jtitle) && Objects.equals(text, that.text) && Objects.equals(locatn, that.locatn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, jtitle, text, locatn);
    }

    @Override
    public String toString() {
        return "JournalModel{" +
                ", uid=" + uid +
                ", title='" + jtitle + '\'' +
                ", text='" + text + '\'' +
                ", locatn='" + locatn + '\'' +
                '}';
    }
}
