package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ImageUploadTest {

  private static final String JEEP_IMAGE = "Jeep Wrangler Rubicon.jpg";
  
  @Autowired
  private MockMvc mockMvc;

  // Let's check if it actually wrote to the database
  @Autowired
  private JdbcTemplate jdbcTemplate; 
  
  @Test
  void testThatTheServerCorrectlyReceivesAnImageAndReturnsAnOKResponse() throws Exception {
    
    

    Resource image = new ClassPathResource(JEEP_IMAGE);

    if (!image.exists()) {
      fail("Could not find resource %s", JEEP_IMAGE);
    }

    // Next, we want to get an input stream from the image
    // We need a multi-part file since this is what Spring Boot uses to send multi-part images
    try (InputStream inputStream = image.getInputStream()) {
      MockMultipartFile file =
          new MockMultipartFile("image", JEEP_IMAGE, MediaType.TEXT_PLAIN_VALUE, inputStream);
      
      // formatter: off
      MvcResult result = mockMvc
          .perform(MockMvcRequestBuilders
              .multipart("/jeeps/1/image")
              .file(file))
          .andDo(print())
          .andExpect(status().is(201))
          .andReturn();
      // formatter: on
 
      String content = result.getResponse().getContentAsString();
      assertThat(content).isNotEmpty();
    }
 
  }
}
