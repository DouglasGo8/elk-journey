package com.udemy.elk.journey.pracitcal.sb3.elk8.mediation;

import com.udemy.elk.journey.pracitcal.sb3.elk8.service.CarRandomizeService;
import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.apache.camel.component.es.ElasticsearchConstants.PARAM_INDEX_ID;

@Component
@NoArgsConstructor
public class CarRandomizeRoute extends RouteBuilder {
  @Override
  public void configure() {

    final String elasticEndpoint = "elasticsearch://docker-cluster?" +
            "operation=Index&indexName=basic&certificatePath=ca.crt" +
            "&enableSSL=true";

    from("direct:greeting")
            .log(LoggingLevel.INFO, "Received Request with payload...")
            .transform(method(CarRandomizeService.class))
            .marshal().json(JsonLibrary.Jackson)
            .log("${body}")
            //.setHeader(PARAM_INDEX_ID, constant(1234))
            .to(elasticEndpoint)
            .convertBodyTo(String.class)
            .log("${body}")
            .end();

  }
}
