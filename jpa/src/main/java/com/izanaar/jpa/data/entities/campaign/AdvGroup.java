package com.izanaar.jpa.data.entities.campaign;

import com.izanaar.jpa.data.entities.Restaurant;

import javax.jws.Oneway;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "adv_groups")
public class AdvGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long groupId;

    private String groupName;

    @OneToMany
    private List<Advertisement> advertisements;

    @OneToOne
    private Campaign campaign;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvGroup advGroup = (AdvGroup) o;

        if (id != null ? !id.equals(advGroup.id) : advGroup.id != null) return false;
        if (groupId != null ? !groupId.equals(advGroup.groupId) : advGroup.groupId != null) return false;
        if (groupName != null ? !groupName.equals(advGroup.groupName) : advGroup.groupName != null) return false;
        if (advertisements != null ? !advertisements.equals(advGroup.advertisements) : advGroup.advertisements != null)
            return false;
        if (campaign != null ? !campaign.equals(advGroup.campaign) : advGroup.campaign != null) return false;
        return restaurant != null ? restaurant.equals(advGroup.restaurant) : advGroup.restaurant == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (advertisements != null ? advertisements.hashCode() : 0);
        result = 31 * result + (campaign != null ? campaign.hashCode() : 0);
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdvGroup{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", advertisements=" + advertisements +
                ", campaign=" + campaign +
                ", restaurant=" + restaurant +
                '}';
    }

    public AdvGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
