# dnext-general-v4-model

Shared **model** types for the **General** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-667: Document Management API, version: 2.12.1
- TMF-673: Geographic Address Management API, version: 2.12.1
- TMF-681: Communication Management API, version: 2.12.1

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-general-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

For JSON polymorphism, register `TmfGeneralJacksonConfig` on your `JsonMapper` (see root README).
