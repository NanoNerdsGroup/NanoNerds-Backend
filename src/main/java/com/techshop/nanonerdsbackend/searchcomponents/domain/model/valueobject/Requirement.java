package com.techshop.nanonerdsbackend.searchcomponents.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Requirement {

    private  String software;
    private  double budget;
    private  String type;

}
