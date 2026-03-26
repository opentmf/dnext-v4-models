package org.opentmf.dnext.tmf633.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf633.model.IServiceCatalog;

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
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ServiceCatalog.class
)
@Required(fields = {"name"})
public class ServiceCatalog extends ServiceCatalogCreate implements IServiceCatalog {

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}