package ee.ttu.geocollection.endpoint.web;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.webNews.service.WebNewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class WebNewsController {
    @Autowired
    private WebNewsApiService webNewsApiService;

    @GetMapping
    public ApiResponse getNews() {
        return webNewsApiService.getNews();
    }
}
