package com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources;

public class AddToFavoritesRequest {
    // Agrega los campos necesarios según los requisitos del endpoint
    private Long userId;
    private Long componentId;

    // Agrega los métodos getter y setter necesarios
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }
}
