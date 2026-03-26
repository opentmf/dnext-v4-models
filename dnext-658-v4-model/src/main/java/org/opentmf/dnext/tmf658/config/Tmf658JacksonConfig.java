package org.opentmf.dnext.tmf658.config;

import lombok.Generated;
import org.opentmf.dnext.product.config.TmfProductJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf658JacksonConfig {

  @Generated
  private Tmf658JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfProductJacksonConfig.registerExtensions(builder);
  }
}
