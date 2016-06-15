package com.izanaar.jpa.data.entities;


import javax.persistence.*;


@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(name = "router_radius_id")
    private Long routerRadiusId;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "counter_id")
    private Long counterId;

    @Column(name = "firewall_config_id")
    private long firewallConfigId;

    @Transient
    private String redirectUrl;

    public Restaurant(String name, String address, Long routerRadiusId) {
        this.name = name;
        this.address = address;
        this.routerRadiusId = routerRadiusId;
    }

    public Restaurant(Long id, String name, String address, Long ownerId, String redirectUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.ownerId = ownerId;
        this.redirectUrl = redirectUrl;
    }

    public Restaurant(Long id, String name, String address, Long routerRadiusId, Long ownerId, Long counterId, String redirectUrl) {
        this(id,name,address,ownerId,redirectUrl);
        this.counterId = counterId;
        this.routerRadiusId = routerRadiusId;
    }


    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getRouterRadiusId() {
        return routerRadiusId;
    }

    public void setRouterRadiusId(Long routerRadiusId) {
        this.routerRadiusId = routerRadiusId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Long getCounterId() {
        return counterId;
    }

    public void setCounterId(Long counterId) {
        this.counterId = counterId;
    }

    public long getFirewallConfigId() {
        return firewallConfigId;
    }

    public void setFirewallConfigId(long firewallConfigId) {
        this.firewallConfigId = firewallConfigId;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Restaurant)){
            return false;
        }

        Restaurant comp = (Restaurant) obj;

        return (this.id.equals(comp.id)) && (this.name.equals(comp.name)) &&
                (this.routerRadiusId.equals(comp.routerRadiusId)) && (this.address.equals(comp.address))&&
                (this.ownerId.equals(comp.ownerId)) && (this.redirectUrl.equals(comp.redirectUrl));
    }
}
