package com.example.spaintask.Configration;

import com.example.spaintask.models.serviceModel.Service;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.core.mapping.event.ValidatingCouchbaseEventListener;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Collections;

@Configuration
public class Config extends AbstractCouchbaseConfiguration {

    @Autowired
    private ApplicationContext context;


    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "test";
    }

    @Override
    public String getPassword() {
        return "Marwan";
    }

    @Override
    public String getBucketName() {
        return "user";
    }

    @Override
    public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {

        mapping.mapEntity(Service.class,getCouchbaseTemplate("service"));
    }
    @SneakyThrows
    private CouchbaseTemplate getCouchbaseTemplate(String bucketName){
        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName),
                mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),
                        new CouchbaseCustomConversions(Collections.emptyList())));

        template.setApplicationContext(context);
        return template;
    }

    private CouchbaseClientFactory couchbaseClientFactory(String bucketName){

        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()),
                bucketName,this.getScopeName());
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
    @Bean
    public ValidatingCouchbaseEventListener validatingCouchbaseEventListener(){

        return new ValidatingCouchbaseEventListener(localValidatorFactoryBean());
    }


}
