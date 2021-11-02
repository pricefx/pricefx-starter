# Pricefx Starter

This is a very basic Pricefx configuration project that will help you to get started with development for the Pricefx Platform. Use it to initialize a new Pricefx project!

## Pricefx Stream Maven Plugin

The Pricefx Stream plugin allows you to fetch/deploy/delete data from/to/on your Pricefx partition.

**NOTE**: Do not use the Pricefx Stream Plugin in your CI/CD pipelines on your QA or production environments. Instead, use the pricefx packaging tool. The Pricefx Stream Maven Plugin allows you to fetch/deploy/delete some data that you otherwise cannot do with the Pricefx Packaging Tool (or Pricefx Studio).

If you don't already have a maven settings file, create one under `~/.m2/settings.xml` with the following content:

````xml
<settings
        xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd"
        xmlns="http://maven.apache.org/SETTINGS/1.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>
    <profiles>
        <profile>
            <id>pricefx-starter</id>
            <activation>
                <activeByDefault>false</activeByDefault>
            </activation>
            <properties>
                <pricefx-stream.url></pricefx-stream.url>
                <pricefx-stream.partition></pricefx-stream.partition>
                <pricefx-stream.username></pricefx-stream.username>
                <pricefx-stream.password></pricefx-stream.password>
            </properties>
        </profile>
    </profiles>
</settings>
````

If you already have a profile, add a profile to your existing `setting.xml`.
