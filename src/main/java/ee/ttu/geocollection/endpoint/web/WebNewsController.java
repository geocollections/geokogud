package ee.ttu.geocollection.endpoint.web;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.webNews.service.WebNewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/news")
public class WebNewsController {
    @Autowired
    private WebNewsApiService webNewsApiService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getNews() {
        return webNewsApiService.getNews();
    }
}
