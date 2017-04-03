package ee.ttu.geocollection.core.controller;

import ee.ttu.geocollection.core.domain.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigurationController {
    @Autowired
    private AppConfig appConfig;

    @RequestMapping(value = "/")
    public AppConfig getConfig(){
        return appConfig;
    }
}
