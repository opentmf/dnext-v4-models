package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IService;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Service is a base class for defining the Service hierarchy. All Services are
 * characterized as either being possibly visible and usable by a Customer or
 * not. This gives rise to the two subclasses of Service: CustomerFacingService
 * and ResourceFacingService.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Service.class
)
public class Service extends ServiceCreate implements IService {

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  private Integer revision;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}