package ee.ttu.geodeesia.core.controller;

import ee.ttu.geodeesia.core.domain.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ResourceBundle;

/**
 * Created by 48707222248 on 18.02.2017.
 */
@Controller
@RequestMapping("/config")
public class ConfigurationController {
    @Autowired
    private AppConfig appConfig;

    @RequestMapping(value = "/")
    @ResponseBody
    public AppConfig getConfig(){
        return appConfig;
    }
}
