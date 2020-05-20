package com.testapp.testclient;

import com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping("/info")
public class AppInfoController {
    @Autowired
    LiteratumPdfClient literatumPdfClient;

    @Autowired
    WebClient testClient;

    @RequestMapping(method = RequestMethod.GET)
    public ServiceResponse<InputStreamResource> getInfo() {
        InputStreamResource resource=literatumPdfClient.getPdf("10.1029/2018SW001921").block();
        return ServiceResponse.success(resource);
    }

    @GetMapping("/doc")
    public ServiceResponse<String> getInfoDoc() {
        String resource = testClient.get().retrieve().bodyToMono(String.class).block();
        return ServiceResponse.success(resource);
    }

}
