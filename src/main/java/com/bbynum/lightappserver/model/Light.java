package com.bbynum.lightappserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "lights")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "datetime", allowGetters = true)
public class Light {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "datetime", nullable = false)
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date datetime;

    public Light() {
    }

    public Light(long id, String color, Date datetime) {
        this.id = id;
        this.color = color;
        this.datetime = datetime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Light that = (Light) o;
        return id == that.id &&
                Objects.equals(color, that.color) &&
                Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, datetime);
    }
}
