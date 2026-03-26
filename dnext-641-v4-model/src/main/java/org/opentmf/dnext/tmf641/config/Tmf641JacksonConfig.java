package org.opentmf.dnext.tmf641.config;

import lombok.Generated;
import org.opentmf.dnext.service.config.TmfServiceJacksonConfig;
import org.opentmf.dnext.tmf641.model.ServiceOrderErrorMessage;
import org.opentmf.dnext.tmf641.model.ServiceOrderItemErrorMessage;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf641JacksonConfig {

  @Generated
  private Tmf641JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    builder.registerSubtypes(
      ServiceOrderErrorMessage.class,
      ServiceOrderItemErrorMessage.class);
    TmfServiceJacksonConfig.registerExtensions(builder);
  }
}
