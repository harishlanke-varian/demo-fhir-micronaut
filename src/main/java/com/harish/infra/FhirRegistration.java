package com.harish.infra;

import jakarta.inject.Singleton;
import jakarta.servlet.*;

import java.util.Set;

@Singleton
public class FhirRegistration implements ServletContainerInitializer {
    private final FhirServlet fhirServlet;

    public FhirRegistration(FhirServlet fhirServlet) {
        this.fhirServlet = fhirServlet;
    }

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        if(fhirServlet instanceof Servlet r4Servlet){
            ServletRegistration.Dynamic registration = servletContext.addServlet("/fhir/r4/*", r4Servlet);

        }
    }
}
