package com.valtek.backend_database.persistence.component;

import com.valtek.backend_database.persistence.component.caseuse.ComponentDependency;
import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {

    @Override
    public void saludar() {
        System.out.println("hola mundo desde mi componente");
    }
}
