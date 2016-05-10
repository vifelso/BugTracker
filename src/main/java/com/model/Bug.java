package com.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "bugs")
public class Bug implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBug;
    @Column(name = "autor")
    private String autor;
    @Column(name = "date")
    private Date date;
    @Column(name = "description")
    private String desc;
    @Column(name = "priority")
    private String prior;
    @Column(name = "status")
    private String status;
    @Column(name = "title")
    private String title;


    @OneToOne
    @JoinTable(name = "user_bugs",
            joinColumns = {@JoinColumn(name = "bugid", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "userid", nullable = false, referencedColumnName = "id")}
    )

    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdBug() {
        return idBug;
    }

    public void setIdBug(int idBug) {
        this.idBug = idBug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBug);
    }

    @Override
    public String toString() {
        return "Bug [idBug=" + idBug + ", title=" + title + ", status=" + status
                + ", priority=" + prior + ", description=" + desc
                + ", autor=" + autor + ", date= " + date + ", user= " + user + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return Objects.equals(idBug, bug.idBug) &&
                Objects.equals(title, bug.title) &&
                Objects.equals(status, bug.status) &&
                Objects.equals(prior, bug.prior) &&
                Objects.equals(desc, bug.desc) &&
                Objects.equals(autor, bug.autor) &&
                Objects.equals(date, bug.date) &&
                Objects.equals(user, bug.user);

    }
}

