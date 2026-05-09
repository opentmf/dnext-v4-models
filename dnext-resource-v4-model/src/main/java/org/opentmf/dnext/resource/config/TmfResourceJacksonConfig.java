package org.opentmf.dnext.resource.config;

import lombok.Generated;
import org.opentmf.dnext.common.config.TmfCommonJacksonConfig;
import org.opentmf.dnext.resource.model.LogicalResource;
import org.opentmf.dnext.resource.model.PhysicalResource;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class TmfResourceJacksonConfig {

  @Generated
  private TmfResourceJacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    builder.registerSubtypes(
      LogicalResource.class,
      PhysicalResource.class);
    TmfCommonJacksonConfig.registerExtensions(builder);
  }
}
