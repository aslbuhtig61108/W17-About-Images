package com.promineotech.jeep.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {

  @Autowired
  @Getter // Not in the W14 coding instructions. Rewatching the videos helped me understand Lombok
          // annotations
  private TestRestTemplate restTemplate;

  @LocalServerPort
  private int serverPort;

  /**
   * 
   * @return
   */
  protected String getBaseUriForJeeps() {
    return String.format("http://localhost:%d/jeeps", serverPort);
  }

  /**
   * 
   * @return
   */
  protected String getBaseUriForOrders() {
    return String.format("http://localhost:%d/orders", serverPort);
  }
}
