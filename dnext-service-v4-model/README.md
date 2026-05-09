# dnext-service-v4-model

Shared **model** types for the **Service** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-633: Service Catalog Management API, version: 2.12.1
- TMF-638: Service Inventory Management API, version: 2.12.1
- TMF-641: Service Ordering Management API, version: 2.12.1

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-service-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

For JSON polymorphism, register `TmfServiceJacksonConfig` on your `JsonMapper` (see root README).
