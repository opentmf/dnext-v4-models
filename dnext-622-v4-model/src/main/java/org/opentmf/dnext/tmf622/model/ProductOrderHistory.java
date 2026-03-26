package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Note that this is the returned object in case of GET operations.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrderItem<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"productOrderItem"})
public class ProductOrderHistory extends ChangedProductOrder {

  /**
   * When subclassing, this defines the super-class.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * When subclassing, this defines the subclass entity name.
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  /**
   * UUID of the archive entry.
   */
  @SafeId
  @Size(max = 100)
  private String archiveId;

  /**
   * The date on which the entity has been archived.
   */
  private OffsetDateTime archivedAt;

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  private Integer revision;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}