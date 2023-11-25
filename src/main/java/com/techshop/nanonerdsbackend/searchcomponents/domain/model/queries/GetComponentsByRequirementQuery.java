package com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.valueobject.Requirement;

public record GetComponentsByRequirementQuery(Requirement requirement) {
}
