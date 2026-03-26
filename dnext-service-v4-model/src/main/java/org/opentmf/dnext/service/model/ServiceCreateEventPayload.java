package org.opentmf.dnext.service.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.Service;
import org.opentmf.service.model.IServiceCreateEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceCreateEventPayload implements IServiceCreateEventPayload {

  /**
   * Service is a base class for defining the Service hierarchy. All Services are
   * characterized as either being possibly visible and usable by a Customer or
   * not. This gives rise to the two subclasses of Service: CustomerFacingService
   * and ResourceFacingService.
   */
  private @Valid Service service;
}