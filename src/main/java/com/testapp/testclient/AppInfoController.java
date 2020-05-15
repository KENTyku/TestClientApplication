package com.testapp.testclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/info")
public class AppInfoController {

    @RequestMapping(method = RequestMethod.GET)
    public ServiceResponse<Cat> getInfo() {
        Cat cat=new Cat();
        cat.setName("Boris");
        return ServiceResponse.success(cat);
    }


}
