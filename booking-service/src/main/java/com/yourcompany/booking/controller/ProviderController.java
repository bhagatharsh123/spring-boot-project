package com.yourcompany.booking.controller;

import com.yourcompany.booking.model.Provider;
import com.yourcompany.booking.service.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    public Provider addProvider(@RequestBody Provider provider) {
        return providerService.addProvider(provider);
    }

    @GetMapping("/search")
    public List<Provider> searchProviders(@RequestParam String serviceType, @RequestParam String location) {
        return providerService.searchProviders(serviceType, location);
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }
}
