package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Abstract base class for DNext event notifications. Contains both standard TMF
 * event fields and DNext-specific extensions.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-668: Partnership Type</li>
 *   <li>TMF-669: Party Role Management API</li>
 *   <li>TMF-670: Payment Method Management API</li>
 *   <li>TMF-671: Promotion Management API</li>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-676: Payment Management API</li>
 *   <li>TMF-681: Communication Management API</li>
 *   <li>TMF-683: Party Interaction Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DNextEventBase {

  /**
   * List of: Access policy constraint data.
   */
  @JsonProperty("accessPolicyConstraint")
  private List<@Valid AccessPolicyConstraintData> accessPolicyConstraints;

  /**
   * Authentication context of the event.
   */
  private @Valid Auth auth;

  /**
   * The correlation id for this event.
   */
  @SafeId
  @Size(max = 100)
  private String correlationId;

  /**
   * An explanatory text of the event.
   */
  private @SafeText String description;

  /**
   * The domain of the event.
   */
  private @SafeText String domain;

  /**
   * The identifier of the notification.
   */
  @SafeId
  @Size(max = 100)
  private String eventId;

  /**
   * Time of the event occurrence.
   */
  private OffsetDateTime eventTime;

  /**
   * The type of the notification.
   */
  private @SafeText String eventType;

  /**
   * The name of the object related to the event.
   */
  private @SafeText String objectName;

  /**
   * The IP address of the origin of the event.
   */
  private @SafeText String originIp;

  /**
   * A priority.
   */
  private @SafeText String priority;

  /**
   * The time the event occurred.
   */
  private OffsetDateTime timeOccurred;

  /**
   * The title of the event.
   */
  private @SafeText String title;

  /**
   * Trace context of the event.
   */
  private @Valid Trace trace;
}