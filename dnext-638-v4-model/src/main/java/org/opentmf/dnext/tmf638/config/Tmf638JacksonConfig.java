package org.opentmf.dnext.tmf638.config;

import lombok.Generated;
import org.opentmf.dnext.service.config.TmfServiceJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf638JacksonConfig {

  @Generated
  private Tmf638JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfServiceJacksonConfig.registerExtensions(builder);
  }
}
