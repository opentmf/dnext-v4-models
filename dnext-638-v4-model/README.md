# dnext-638-v4-model

**TMF-638 Service Inventory Management API** — concrete model classes implementing the `I*` API from **dnext-638-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-638-v4-model</artifactId>
    <version>2.11.2</version>
</dependency>
```

Call `Tmf638JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
