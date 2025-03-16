package com.vishnu.udemy.models;

import com.vishnu.udemy.service.Store;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ClothStore implements Store {
    @Override
    public String getStoreDetails() {
        return "This is a Cloth Store";
    }
}
