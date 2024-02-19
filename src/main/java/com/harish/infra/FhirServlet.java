package com.harish.infra;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import io.micronaut.context.ApplicationContext;
import jakarta.inject.Singleton;
import org.hl7.fhir.r4.model.Resource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class FhirServlet extends RestfulServer {

    private final ApplicationContext applicationContext;

    public FhirServlet(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public void initialize() {
        super.setFhirContext(FhirContext.forR4());
        Collection<IResourceProvider> providers = applicationContext.getBeansOfType(IResourceProvider.class);
        List<IResourceProvider> filteredProviders = providers.stream()
                .filter(provider -> Resource.class.isAssignableFrom(provider.getResourceType()))
                .collect(Collectors.toList());
        setResourceProviders(filteredProviders);
    }
}
