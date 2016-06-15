package com.izanaar.jpa.data.entities.campaign;

import com.izanaar.jpa.data.entities.Restaurant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advertisements")
public class Advertisement {

    @Id
    private Long id;

    @ManyToOne
    private AdvGroup advertisementGroup;

    private Long advertisementId;

    private String advertisementName;

    public Advertisement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdvGroup getAdvertisementGroup() {
        return advertisementGroup;
    }

    public void setAdvertisementGroup(AdvGroup advertisementGroup) {
        this.advertisementGroup = advertisementGroup;
    }

    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertisementName() {
        return advertisementName;
    }

    public void setAdvertisementName(String advertisementName) {
        this.advertisementName = advertisementName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertisement that = (Advertisement) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (advertisementGroup != null ? !advertisementGroup.equals(that.advertisementGroup) : that.advertisementGroup != null)
            return false;
        if (advertisementId != null ? !advertisementId.equals(that.advertisementId) : that.advertisementId != null)
            return false;
        return advertisementName != null ? advertisementName.equals(that.advertisementName) : that.advertisementName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (advertisementGroup != null ? advertisementGroup.hashCode() : 0);
        result = 31 * result + (advertisementId != null ? advertisementId.hashCode() : 0);
        result = 31 * result + (advertisementName != null ? advertisementName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", advertisementGroup=" + advertisementGroup +
                ", advertisementId=" + advertisementId +
                ", advertisementName='" + advertisementName + '\'' +
                '}';
    }
}
