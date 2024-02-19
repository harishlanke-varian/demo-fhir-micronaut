package com.harish;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;
import jakarta.inject.Singleton;
import jakarta.servlet.http.HttpServletRequest;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.AllergyIntolerance;
import org.hl7.fhir.r4.model.IdType;

@Singleton
public class AllergyResource implements IResourceProvider {
    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return AllergyIntolerance.class;
    }

    @Read
    public AllergyIntolerance get(HttpServletRequest request, @IdParam IdType allergyKey) throws Exception {
        System.out.println(allergyKey);
        AllergyIntolerance allergyIntolerance = new AllergyIntolerance();
        allergyIntolerance.setId(allergyKey);
        return allergyIntolerance;
    }
}
