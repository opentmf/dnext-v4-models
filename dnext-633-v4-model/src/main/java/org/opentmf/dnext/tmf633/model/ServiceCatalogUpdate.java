package org.opentmf.dnext.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.service.model.ServiceBase;
import org.opentmf.dnext.service.model.ServiceCategoryRef;
import org.opentmf.tmf633.model.IServiceCatalogUpdate;

/**
 * The ServiceCatalog to be updated.
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
    defaultImpl = ServiceCatalogUpdate.class
)
public class ServiceCatalogUpdate extends ServiceBase implements IServiceCatalogUpdate {

  /**
   * Identifier of the type of catalog.
   */
  private @SafeText String catalogType;

  /**
   * List of service categories associated with this catalog.
   */
  @JsonProperty("category")
  private List<@Valid ServiceCategoryRef> categories;

  /**
   * List of parties or party roles related to this category.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}