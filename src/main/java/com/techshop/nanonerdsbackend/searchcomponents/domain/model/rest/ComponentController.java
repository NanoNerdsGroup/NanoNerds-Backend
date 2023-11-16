package com.techshop.nanonerdsbackend.searchcomponents.domain.model.rest;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.rest.resources.ComponentResource;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.services.ComponentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/components")
public class ComponentController {

    private final ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping
    public ResponseEntity<List<ComponentResource>> getComponentsByName(@RequestParam String name) {
        List<Component> components = componentService.getComponentsByName(name);

        List<ComponentResource> resources = components
                .stream()
                .map(ComponentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }
}
   //GET http://localhost:puerto/api/v1/components?name=TU_NOMBRE_DE_COMPONENTE
