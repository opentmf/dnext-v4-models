package org.opentmf.dnext.common.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents a task used to import resources from a file Skipped properties:
 * id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-common: common</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class Requester {

  /**
   * requesting organization Id.
   */
  @SafeId
  @Size(max = 100)
  private String organizationId;

  /**
   * requesting user tenant Id.
   */
  @SafeId
  @Size(max = 100)
  private String tenantId;

  /**
   * requesting user name.
   */
  private @SafeText String userName;
}