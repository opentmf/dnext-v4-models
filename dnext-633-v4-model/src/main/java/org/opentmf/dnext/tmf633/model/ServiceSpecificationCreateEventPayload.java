package org.opentmf.dnext.tmf633.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.ServiceSpecification;
import org.opentmf.tmf633.model.IServiceSpecificationCreateEventPayload;

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
public class ServiceSpecificationCreateEventPayload implements IServiceSpecificationCreateEventPayload {

  /**
   * ServiceSpecification is a class that offers characteristics to describe a
   * type of service. Functionally, it acts as a template by which Services may be
   * instantiated. By sharing the same specification, these services would
   * therefore share the same set of characteristics.
   */
  private @Valid ServiceSpecification serviceSpecification;
}