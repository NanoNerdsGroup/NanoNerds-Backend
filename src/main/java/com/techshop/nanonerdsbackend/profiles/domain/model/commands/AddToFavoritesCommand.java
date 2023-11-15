package com.techshop.nanonerdsbackend.profiles.domain.model.commands;

import lombok.Getter;

@Getter
public class AddToFavoritesCommand {
    private Long userId;
    private final Long componentId;

    public AddToFavoritesCommand(Long userId, Long componentId){
        this.userId = userId;
        this.componentId = componentId;
    }

}
