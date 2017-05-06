package ee.ttu.geocollection.endpoint.web;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.webPages.service.WebPagesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webpages")
public class WebPagesController {
	@Autowired
	private WebPagesApiService webPagesApiService;

	@GetMapping(value = "/{id}")
	public ApiResponse getWebPages(@PathVariable int id)  {
		return webPagesApiService.getWebPages(id);
	}
}
