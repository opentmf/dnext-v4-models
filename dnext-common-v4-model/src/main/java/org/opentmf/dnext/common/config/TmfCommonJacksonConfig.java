package org.opentmf.dnext.common.config;

import lombok.Generated;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class TmfCommonJacksonConfig {

  @Generated
  private TmfCommonJacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    builder.registerSubtypes(
      AttachmentRefOrValue.class);
  }
}
