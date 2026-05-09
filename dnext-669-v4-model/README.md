# dnext-669-v4-model

**TMF-669 Party Role Management API** — concrete model classes implementing the `I*` API from **dnext-669-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>dnext-669-v4-model</artifactId>
    <version>2.12.1</version>
</dependency>
```

Call `Tmf669JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
