package com.yourcompany.booking.service;

import com.yourcompany.booking.model.Provider;
import com.yourcompany.booking.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider addProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> searchProviders(String serviceType, String location) {
        return providerRepository.findByServiceTypeAndLocation(serviceType, location);
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }
}
