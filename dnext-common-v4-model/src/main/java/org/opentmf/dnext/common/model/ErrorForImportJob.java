package org.opentmf.dnext.common.model;

import java.net.URI;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents error information.
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
public class ErrorForImportJob extends ErrorForExportJob {

  /**
   * error response url.
   */
  private URI errorResponseFileUrl;
}