package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest;
import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.administration.interfaces.acl.ComponentContextFacade;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByNameQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByRequirementQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.valueobject.Requirement;
import com.techshop.nanonerdsbackend.administration.domain.services.ComponentQueryService;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.ComponentResource;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.transform.ComponentResourceFromEntityAssembler;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/components", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchComponentController {

    private final ComponentContextFacade componentContextFacade;

    //GET
    @GetMapping("/{componentId}")
    public ResponseEntity<ComponentResource> getComponentById(@PathVariable Long componentId){
        var component = componentContextFacade.getComponentById(componentId);
        if (component.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var componentResource = ComponentResourceFromEntityAssembler.toResourceFromEntity(component.get());
        return ResponseEntity.ok(componentResource);
    }

    @GetMapping("/{componentName}")
    public ResponseEntity<List<ComponentResource>> getComponentsByName(@PathVariable String SearchedName){
        var getComponentsByName = new GetComponentsByNameQuery(SearchedName);
        List<Component> components = componentContextFacade.getComponentQueryService().execute(getComponentsByName);

        if (components.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var componentsResource = components.stream()
                .map(ComponentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(componentsResource);

    }

    @GetMapping("/requirement")
    public ResponseEntity<List<ComponentResource>> getComponentsByRequirement(@RequestBody Requirement requirement){
        var getComponentByRequirement = new GetComponentsByRequirementQuery(requirement);
        List<Component> components = componentContextFacade.getComponentQueryService().execute(getComponentByRequirement);
        if (components.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var componentsResource = components.stream()
                .map(ComponentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(componentsResource);
    }

}
   //GET http://localhost:puerto/api/v1/components?name=TU_NOMBRE_DE_COMPONENTE
