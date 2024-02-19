package com.harish;

import ca.uhn.fhir.context.FhirContext;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.serde.annotation.SerdeImport;
import org.hl7.fhir.r4.model.AllergyIntolerance;

@Controller("/fhir/AllergyIntolerance")
@Introspected(classes = {AllergyIntolerance.class})
@SerdeImport(AllergyIntolerance.class)
//@Consumes({"*"})
//@Produces({"*"})
@Consumes({"application/fhir+json", "application/json", "application/xml", "application/fhir+xml;q=1.0", "application/fhir+json;q=1.0", "application/xml+fhir;q=0.9", "application/json+fhir;q=0.9"})
@Produces({"application/fhir+json", "application/json", "application/xml", "application/fhir+xml;q=1.0", "application/fhir+json;q=1.0", "application/xml+fhir;q=0.9", "application/json+fhir;q=0.9"})
public class AllergyController {

    private final ApplicationContext applicationContext;
    private FhirContext fhirContext  = FhirContext.forR4();

    public AllergyController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Get("{id}")
    public String getAllergyIntolerances(String id) {
        System.out.println("Inside getAllergyIntolerances");
        System.out.println("id: " + id);
        AllergyIntolerance allergyIntolerance = new AllergyIntolerance();
        allergyIntolerance.setId(String.format("%s-%s",AllergyIntolerance.class.getSimpleName(),id));
        return fhirContext.newJsonParser().encodeResourceToString(allergyIntolerance);
//        return allergyIntolerance;
    }
}
