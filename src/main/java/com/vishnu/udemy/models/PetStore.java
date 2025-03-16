package com.vishnu.udemy.models;

import com.vishnu.udemy.service.Store;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component

public class PetStore implements Store {
    @Override
    public String getStoreDetails() {
        return "This is a pet store";
    }
}
