# dnext-651-v4-model

**TMF-651 Agreement Management API** — concrete model classes implementing the `I*` API from **dnext-651-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-651-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

Call `Tmf651JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
