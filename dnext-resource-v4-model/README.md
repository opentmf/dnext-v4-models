# dnext-resource-v4-model

Shared **model** types for the **Resource** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-634: Resource Catalog Management API, version: 2.12.1
- TMF-639: Resource Inventory Management API, version: 2.12.1
- TMF-652: Resource Order Management API, version: 2.12.1

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-resource-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

For JSON polymorphism, register `TmfResourceJacksonConfig` on your `JsonMapper` (see root README).
