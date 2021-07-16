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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.exceptions.InternalServerErrorException;
import com.raquelheredia.api.netflix.exceptions.NotFoundException;
import com.raquelheredia.api.netflix.model.Chapters;
import com.raquelheredia.api.netflix.services.CategoriesService;
import com.raquelheredia.api.netflix.services.ChaptersService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ChaptersControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ChaptersService chaptersService;
	
	@Test
	public void retrieveUpdateChapter() throws Exception {
		
		
		ChaptersRest updateCh = new ChaptersRest (1L, "NOMBRE PROVISIONAL", 50);
		when(chaptersService.updateChapter(1L, "NOMBRE PROVISIONAL")).thenReturn(updateCh);

		RequestBuilder request = MockMvcRequestBuilders.patch("/api/netflix/v1/chapters/1/chapters/NOMBRE PROVISIONAL");

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\r\n"
						+ "  \"status\": \"Success\",\r\n"
						+ "  \"code\": \"200 OK\",\r\n"
						+ "  \"message\": \"OK\",\r\n"
						+ "  \"data\": {\r\n"
						+ "    \"name\": \"NOMBRE PROVISIONAL\",\r\n"
						+ "    \"duration\": 50,\r\n"
						+ "    \"ID\": 1\r\n"
						+ "  }\r\n"
						+ "}"))
				.andReturn();
	}
	
	@Test
	public void retrieveChapterAndShowId () throws Exception {

		ChaptersRest chapId = new ChaptersRest(1L, "SUZIE ¿ME RECIBES?", 50);

		when(chaptersService.findSeasonOfSeasonAndShowNumber(1L, 1L, 1L)).thenReturn(chapId);

		RequestBuilder request = MockMvcRequestBuilders.get("/api/netflix/v1/chapters/shows/1/seasons/1/chapters/1?chapterId=1&seasonId=1&showId=1");

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\r\n"
						+ "  \"status\": \"Success\",\r\n"
						+ "  \"code\": \"200 OK\",\r\n"
						+ "  \"message\": \"OK\",\r\n"
						+ "  \"data\": {\r\n"
						+ "    \"name\": \"SUZIE ¿ME RECIBES?\",\r\n"
						+ "    \"duration\": 50,\r\n"
						+ "    \"ID\": 1\r\n"
						+ "  }\r\n"
						+ "}"))
				.andReturn();
	} 
	
	@Test
	public void retrieveListChapterAndShowId() throws Exception {

		List<ChaptersRest> chapterList = new ArrayList<>();
		chapterList.add(new ChaptersRest(1L, "SUZIE ¿ME RECIBES?", 50));

		when(chaptersService.findChaptersOfSpecificSeasonAndShow(1L, 1L)).thenReturn(chapterList);

		RequestBuilder request = MockMvcRequestBuilders.get("/api/netflix/v1/chapters/seasons/1/seasons/1/chapters");

		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content()
				.json("{\r\n"
						+ "  \"status\": \"Success\",\r\n"
						+ "  \"code\": \"200 OK\",\r\n"
						+ "  \"message\": \"OK\",\r\n"
						+ "  \"data\": [\r\n"
						+ "    {\r\n"
						+ "      \"name\": \"SUZIE ¿ME RECIBES?\",\r\n"
						+ "      \"duration\": 50,\r\n"
						+ "      \"ID\": 1\r\n"
						+ "    }\r\n"
						+ "  ]\r\n"
						+ "}"))
				.andReturn();

	}
	
	@Test
	public void retrieveNotFoundListChapterAndShowId() throws Exception {
		
		List<ChaptersRest> chapterList = new ArrayList<>();
		chapterList.add(new ChaptersRest(1L, "SUZIE ¿ME RECIBES?", 50));

		when(chaptersService.findChaptersOfSpecificSeasonAndShow(2L, 1L))
				.thenThrow(new NotFoundException ("CAPITULOS Y/O TEMPORADAS NO ENCONTRADAS"));

		RequestBuilder request = MockMvcRequestBuilders.get("/api/netflix/v1/chapters/seasons/1/seasons/2/chapters");

		mockMvc.perform(request).andExpect(status().isNotFound()).andExpect(content()
				.json("{\r\n"
						+ "  \"status\": \"ERROR\",\r\n"
						+ "  \"code\": \"404\",\r\n"
						+ "  \"message\": \"CAPITULOS Y/O TEMPORADAS NO ENCONTRADAS\",\r\n"
						+ "  \"data\": []\r\n"
						+ "}"))
				.andReturn();
	}
}
