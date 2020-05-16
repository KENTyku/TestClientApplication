package com.testapp.testclient;

import com.wiley.authorservices.clients.ext.literatum.webflux.LiteratumPdfClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/info")
public class AppInfoController {
    @Autowired
    LiteratumPdfClient literatumPdfClient;

    @RequestMapping(method = RequestMethod.GET)
    public ServiceResponse<InputStreamResource> getInfo() {
        Cat cat=new Cat();
        cat.setName("Boris");
        InputStreamResource resource=literatumPdfClient.getPdf("doi").block();

        return ServiceResponse.success(resource);
    }


}
