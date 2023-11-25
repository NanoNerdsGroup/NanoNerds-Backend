package com.techshop.nanonerdsbackend.administration.interfaces;


import com.techshop.nanonerdsbackend.administration.domain.model.commands.CreateComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.DeleteComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.UpdateComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.queries.GetComponentByIdQuery;
import com.techshop.nanonerdsbackend.administration.domain.services.ComponentCommandService;
import com.techshop.nanonerdsbackend.administration.domain.services.ComponentQueryService;
import com.techshop.nanonerdsbackend.administration.infraestructure.persistence.repositories.ComponentRepository;
import com.techshop.nanonerdsbackend.administration.interfaces.acl.ComponentContextFacade;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.ComponentResource;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.CreateComponentCommandResource;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.UpdateComponentCommandResource;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.transform.ComponentResourceFromEntityAssembler;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.transform.CreateComponentCommandFromResourceAssembler;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.transform.DeleteComponentCommandFromResourceAssembler;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.transform.UpdateComponentCommandFromResourceAssembler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/administration/components", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdministrationController {

    private final ComponentCommandService componentCommandService;
    private final ComponentRepository componentRepository;
    private final ComponentQueryService componentQueryService;


    //POST
    @PostMapping("/create-component")
    public ResponseEntity<ComponentResource> createComponent(@RequestBody CreateComponentCommandResource resource) {
        var createComponent = CreateComponentCommandFromResourceAssembler.toCommandFromResource(resource);
        var newComponent = componentCommandService.execute(createComponent);

        if(!newComponent.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        var getComponentByIdQuery = new GetComponentByIdQuery(newComponent.get().getId());
        var component = componentQueryService.execute(getComponentByIdQuery);

        if (component.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var componentResource = ComponentResourceFromEntityAssembler.toResourceFromEntity(component.get());
        return new ResponseEntity<>(componentResource, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete-component/{id}")
    public ResponseEntity<Void> deleteComponent(@PathVariable Long id) {
        DeleteComponentCommand command = new DeleteComponentCommand(id);
        boolean componentDeleted = componentCommandService.execute(command);

        if (!componentDeleted) {
            // Si el componente no fue encontrado para eliminar
            return ResponseEntity.notFound().build();
        }
        // Si el componente fue encontrado y borrado
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-component")
    public ResponseEntity<ComponentResource> updateComponent(@RequestBody UpdateComponentCommandResource resource) {
        var updateComponent = UpdateComponentCommandFromResourceAssembler.toCommandFromResource(resource);
        var updatedComponent = componentCommandService.execute(updateComponent);

        if(!updatedComponent.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        var getComponentByIdQuery = new GetComponentByIdQuery(updatedComponent.get().getId());
        var component = componentQueryService.execute(getComponentByIdQuery);

        if (component.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var componentResource = ComponentResourceFromEntityAssembler.toResourceFromEntity(component.get());
        return new ResponseEntity<>(componentResource, HttpStatus.CREATED);
    }
}