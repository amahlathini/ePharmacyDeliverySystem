package com.digital.epharmacy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager injectedEntityManager){
        entityManager = injectedEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        // Expose ID in JSON
        exposeIds(config);

        // Disable CORS
        /*config.getCorsRegistry()
                .addMapping("/api")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("application/json")
                .allowedOrigins("http://localhost:4200",
                        "http://localhost:3000",
                        "https://epharmacy-online.herokuapp.com",
                        "https://amahlathini.github.io/admin-dashboard",
                        "https://vibekonnect.tech/admin-dashboard/",
                        "https://vibekonnect.tech"
                );*/


        /*HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        // Disable HTTTP methods for Product: PUT, POST amd DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
        // Disable HTTTP methods for ProductCategory: PUT, POST amd DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));*/
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for(EntityType temEntityType : entities) {
            entityClasses.add(temEntityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
