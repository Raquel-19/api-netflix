package com.raquelheredia.api.netflix.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.exceptions.InternalServerErrorException;
import com.raquelheredia.api.netflix.services.CategoriesService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CategoriesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoriesService categoriesService;

	@Test
	public void retrieveAllCategories() throws Exception {

		List<CategoriesRest> categoryList = new ArrayList<>();
		// CategoriesRest categoriesId = new CategoriesRest(1L, "CIENCIA FICCION")
		categoryList.add(new CategoriesRest(1L, "CIENCIA FICCIÓN"));
		categoryList.add(new CategoriesRest(2L, "DRAMA"));
		categoryList.add(new CategoriesRest(3L, "ANIMACIÓN PARA ADULTOS"));
		categoryList.add(new CategoriesRest(4L, "SITCOMS"));
		categoryList.add(new CategoriesRest(5L, "POLICIACA"));

		when(categoriesService.findAllCategories()).thenReturn(categoryList); // categoriesId
		// thenThrow (new NotFoundException ("") -> NEGATIVO)

		RequestBuilder request = MockMvcRequestBuilders.get("/api/netflix/v1/categories");

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\r\n" + "  \"status\": \"Success\",\r\n" + "  \"code\": \"200 OK\",\r\n"
						+ "  \"message\": \"OK\",\r\n" + "  \"data\": [\r\n" + "    {\r\n"
						+ "      \"name\": \"CIENCIA FICCIÓN\",\r\n" + "      \"ID\": 1\r\n" + "    },\r\n"
						+ "    {\r\n" + "      \"name\": \"DRAMA\",\r\n" + "      \"ID\": 2\r\n" + "    },\r\n"
						+ "    {\r\n" + "      \"name\": \"ANIMACIÓN PARA ADULTOS\",\r\n" + "      \"ID\": 3\r\n"
						+ "    },\r\n" + "    {\r\n" + "      \"name\": \"SITCOMS\",\r\n" + "      \"ID\": 4\r\n"
						+ "    },\r\n" + "    {\r\n" + "      \"name\": \"POLICIACA\",\r\n" + "      \"ID\": 5\r\n"
						+ "    }\r\n" + "  ]\r\n" + "}"))
				.andReturn();

	}

	@Test
	public void retrieveAllInternalServerError() throws Exception {

		List<CategoriesRest> categoryList = new ArrayList<>();
		categoryList.add(new CategoriesRest(1L, "CIENCIA FICCIÓN"));
		categoryList.add(new CategoriesRest(2L, "DRAMA"));
		categoryList.add(new CategoriesRest(3L, "ANIMACIÓN PARA ADULTOS"));
		categoryList.add(new CategoriesRest(4L, "SITCOMS"));
		categoryList.add(new CategoriesRest(5L, "POLICIACA"));

		when(categoriesService.findAllCategories())
				.thenThrow(new InternalServerErrorException("ERROR INTERNO DEL SERVIDOR"));// categoriesId

		RequestBuilder request = MockMvcRequestBuilders.get("/api/netflix/v1/categories");

		mockMvc.perform(request).andExpect(status().isInternalServerError()).andExpect(content()
				.json("{\"status\":\"ERROR\",\"code\":\"500\",\"message\":\"ERROR INTERNO DEL SERVIDOR\",\"data\":[]}"))
				.andReturn();

	}

}
