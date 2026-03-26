package org.opentmf.dnext.tmf633.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf633.model.IServiceCatalogBatchEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceCatalogBatchEventPayload implements IServiceCatalogBatchEventPayload {

  /**
   * The root entity for service catalog management. A service catalog is a group
   * of service specifications made available through service candidates that an
   * organization provides to the consumers (internal consumers like its employees
   * or B2B customers or B2C customers). A service catalog typically includes
   * name, description and time period that is valid for. It will have a list of
   * ServiceCandidate catalog items. A ServiceCandidate is an entity that makes a
   * ServiceSpecification available to a catalog. A ServiceCandidate and its
   * associated ServiceSpecification may be "published" - made visible -in any
   * number of ServiceCatalogs, or in none.
   */
  private @Valid ServiceCatalog serviceCatalog;
}