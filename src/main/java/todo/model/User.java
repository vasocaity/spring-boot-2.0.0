package todo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userId;
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Note> note;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }
}
