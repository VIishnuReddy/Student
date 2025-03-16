package com.vishnu.udemy.controller;

import com.vishnu.udemy.service.Store;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    private Store store;
    private Store branch;

    public StoreController(@Qualifier("petStore") Store store) {

        this.store = store;
        this.branch = branch;
    }

    @GetMapping("/store")
    public String getStore() {
        return store.getStoreDetails();
    }


}
