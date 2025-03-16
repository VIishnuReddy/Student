package com.vishnu.udemy.models;

import com.vishnu.udemy.service.Store;
import org.springframework.stereotype.Component;

@Component
public class ElectronicStore implements Store {
    @Override
    public String getStoreDetails() {
        return "This is Electronics Store";
    }
}
