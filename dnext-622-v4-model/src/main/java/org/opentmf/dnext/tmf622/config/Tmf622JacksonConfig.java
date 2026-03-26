package org.opentmf.dnext.tmf622.config;

import lombok.Generated;
import org.opentmf.dnext.customer.config.TmfCustomerJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf622JacksonConfig {

  @Generated
  private Tmf622JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfCustomerJacksonConfig.registerExtensions(builder);
  }
}
