package com.techshop.nanonerdsbackend.administration.interfaces.acl;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.administration.domain.model.queries.GetComponentByIdQuery;
import com.techshop.nanonerdsbackend.administration.domain.services.ComponentQueryService;
import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetUserByIdQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ComponentContextFacade {
    @Getter
    private final ComponentQueryService componentQueryService;

    public Optional<Component> getComponentById(Long id){
        var getComponentByIdQuery = new GetComponentByIdQuery(id);
        return componentQueryService.execute(getComponentByIdQuery);
    }



}
