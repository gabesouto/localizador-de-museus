package com.betrybe.museumfinder.solution;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class MuseumControllerTest {

  @MockBean
  MuseumService service;
  @Autowired
  MockMvc mockMvc;

  @AfterEach
  public void clearMock() {
    Mockito.reset(service);
  }

  private Museum createTestMuseum(long id) {
    Coordinate coordinate = new Coordinate(90, 100);

    Museum museumInDb = new Museum();
    museumInDb.setId(id);
    museumInDb.setName("test name");
    museumInDb.setCoordinate(coordinate);
    museumInDb.setAddress("address test");
    museumInDb.setDescription("description test");
    museumInDb.setCollectionType("collection test");
    museumInDb.setSubject("subject test");
    museumInDb.setUrl("url test");
    return museumInDb;
  }

  private MuseumCreationDto createTestMuseumDto() {
    Coordinate coordinate = new Coordinate(90, 100);

    return new MuseumCreationDto(
        "test name",
        "description test",
        "address test",
        "collection test",
        "subject test",
        "url test",
        coordinate);
  }

  @Test
  @DisplayName("Testa a situação de Success post da rota /museums")
  public void testCreateMuseum() throws Exception {
    Mockito.when(service.createMuseum(any())).thenReturn(createTestMuseum(1L));
    ObjectMapper objectMapper = new ObjectMapper();
    String requestBody = objectMapper.writeValueAsString(createTestMuseumDto());

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/museums")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1));

    Mockito.verify(service).createMuseum(any());
  }

  @Test
  @DisplayName("Testa situação de Success get na rota /museums/closest")
  public void testClosestMuseum() throws Exception {
    Museum museum = createTestMuseum(2L);
    Mockito.when(service.getClosestMuseum(any(), any())).thenReturn(museum);

    mockMvc
        .perform(
            get("/museums/closest?lat=12.34&lng=23.45&max_dist_km=10")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value(museum.getName()))
        .andExpect(jsonPath("$.coordinate.latitude").value(museum.getCoordinate().latitude()))
        .andExpect(jsonPath("$.coordinate.longitude").value(museum.getCoordinate().longitude()));

    Mockito.verify(service).getClosestMuseum(any(), any());
  }

  @Test
  @DisplayName("Testa situação de Success get na rota /museums/{id}")
  public void testGetMuseumById() throws Exception {
    Museum museum = createTestMuseum(2L);
    Mockito.when(service.getMuseum(2L)).thenReturn(museum);

    mockMvc
        .perform(get("/museums/2").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value(museum.getName()))
        .andExpect(jsonPath("$.coordinate.latitude").value(museum.getCoordinate().latitude()))
        .andExpect(jsonPath("$.coordinate.longitude").value(museum.getCoordinate().longitude()));

    Mockito.verify(service).getMuseum(2L);
  }
}