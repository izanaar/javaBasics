package com.izanaar.jpa.data.entities.campaign;

import com.izanaar.jpa.data.entities.User;
import com.izanaar.jpa.data.entities.enums.CampaignType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CampaignType campaignType;

    @OneToOne(optional = false)
    private User owner;

    @OneToMany
    private List<AdvGroup> groups;

    private String campaignId;

    public Campaign() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CampaignType getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(CampaignType campaignType) {
        this.campaignType = campaignType;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public List<AdvGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<AdvGroup> groups) {
        this.groups = groups;
    }
}
