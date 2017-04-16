package ee.ttu.geocollection.endpoint.web;

import ee.ttu.geocollection.domain.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import ee.ttu.geocollection.interop.api.webPages.service.WebPagesApiService;

@Controller
@RequestMapping("/webpages")
public class WebPagesController {
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);

	@Autowired
	private WebPagesApiService webPagesApiService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ApiResponse getWebPages(@PathVariable int id) throws AppException {
		return webPagesApiService.getWebPages(id);
	}
}
