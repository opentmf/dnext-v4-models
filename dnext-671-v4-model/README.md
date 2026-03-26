# dnext-671-v4-model

**TMF-671 Promotion Management API** — concrete model classes implementing the `I*` API from **dnext-671-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-671-v4-model</artifactId>
    <version>2.11.2</version>
</dependency>
```

Call `Tmf671JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
