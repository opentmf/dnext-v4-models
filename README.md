# dnext-v4-models

Concrete **TM Forum data model** classes (Lombok, Jackson, validation) generated from the official OpenAPI specs. Each class implements the matching getter-only interface from **opentmf-v4-api**.

Multi-module layout: shared types live in common-group modules; TMF-specific types live in per-TMF modules. **Common-group boundaries** follow the official portfolio grouping published by TM Forum — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

Modules covered:

- [TMF-620](dnext-620-v4-model/README.md) Product Catalog Management API
- [TMF-622](dnext-622-v4-model/README.md) Product Ordering Management API
- [TMF-629](dnext-629-v4-model/README.md) Customer Management API
- [TMF-632](dnext-632-v4-model/README.md) Party Management API
- [TMF-633](dnext-633-v4-model/README.md) Service Catalog Management API
- [TMF-634](dnext-634-v4-model/README.md) Resource Catalog Management API
- [TMF-637](dnext-637-v4-model/README.md) Product Inventory Management API
- [TMF-638](dnext-638-v4-model/README.md) Service Inventory Management API
- [TMF-639](dnext-639-v4-model/README.md) Resource Inventory Management API
- [TMF-641](dnext-641-v4-model/README.md) Service Ordering Management API
- [TMF-648](dnext-648-v4-model/README.md) Quote Management API
- [TMF-651](dnext-651-v4-model/README.md) Agreement Management API
- [TMF-652](dnext-652-v4-model/README.md) Resource Order Management API
- [TMF-658](dnext-658-v4-model/README.md) Loyalty
- [TMF-663](dnext-663-v4-model/README.md) Shopping Cart Management API
- [TMF-666](dnext-666-v4-model/README.md) Account Management API
- [TMF-667](dnext-667-v4-model/README.md) Document Management API
- [TMF-668](dnext-668-v4-model/README.md) Partnership Type
- [TMF-669](dnext-669-v4-model/README.md) Party Role Management API
- [TMF-670](dnext-670-v4-model/README.md) Payment Method Management API
- [TMF-671](dnext-671-v4-model/README.md) Promotion Management API
- [TMF-673](dnext-673-v4-model/README.md) Geographic Address Management API
- [TMF-676](dnext-676-v4-model/README.md) Payment Management API
- [TMF-681](dnext-681-v4-model/README.md) Communication Management API
- [TMF-683](dnext-683-v4-model/README.md) Party Interaction Management API

## Diagram

[PlantUML](dnext-v4-models.puml) in the project root.

## Depends on

- **opentmf-v4-api** — `I*` interfaces (and enums when generated there).
- **opentmf-commons** — validation annotations, `JacksonUtil`, helpers.

## OpenTMF version alignment (BOM)

Import **`opentmf-versions`** in `<dependencyManagement>` so OpenTMF artifacts (models, APIs, commons, etc.) stay on aligned versions:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.opentmf</groupId>
      <artifactId>opentmf-versions</artifactId>
      <version>LATEST</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

**Replace `LATEST` with a fixed `opentmf-versions` release** (e.g. the current line you standardize on). Maven still resolves `LATEST` / `RELEASE` in some setups, but those keywords are **deprecated for reproducible builds** and are effectively **EOL** as a practice — **use a static version for build consistency** (CI, audits, and local builds should all see the same bill of materials).

## Jackson

Register polymorphic subtypes once per TMF module you use directly; each `Tmf*JacksonConfig.registerExtensions`
chains parent commons.

This below prototype can be used in a microservice. We are creating an immutable jsonMapper, and then
exposing it as the primary JsonMapper bean for Spring Boot, also using it in the static JacksonUtil
methods.

```java
@Bean @Primary
public JsonMapper jsonMapper() {
  var builder = JacksonUtil.defaultMapperBuilder();
  Tmf622JacksonConfig.registerExtensions(builder);
  ...
  var jsonMapper = builder.build();
  JacksonUtil.setDefaultJsonMapper(jsonMapper);
  return jsonMapper;
}
```

## Requirements

Java 17+.
