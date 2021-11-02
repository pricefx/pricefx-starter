<div align="center">
    <h1>Pricefx Starter Project</h1>
</div>

<div align="center">

[![https://pricefx.vercel.app](https://pricefx.vercel.app/badges/developer-portal-badge.svg)]()
[![https://pricefx.atlassian.net/wiki/spaces/KB/overview](https://pricefx.vercel.app/badges/knowledge-base-badge.svg)]()
[![Test & Deploy](https://github.com/pricefx/pricefx-starter/actions/workflows/main.yml/badge.svg?branch=develop)](https://github.com/pricefx/pricefx-starter/actions/workflows/main.yml)
[![issues - pricefx-starter](https://img.shields.io/github/issues/pricefx/pricefx-starter)](https://github.com/pricefx/pricefx-starter/issues)

</div>

Use this repository to initialize new Pricefx projects. The `pricefxSrc/` module contains source code for a very basic Pricefx configuration project that will help you to get started with development for the Pricefx Platform.

## How to use

Simply download a copy of the project and remove the files that you deem unnecessary. 

### CI/CD

To set up your CI/CD pipelines and integrate with an existing partition, you will have to configure some environment variables:

* `PRICEFX_URL`
* `PRICEFX_PARTITION`
* `PRICEFX_USERNAME`
* `PRICEFX_PASSWORD`

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


<div align="center">
    <img src="https://pricefx.vercel.app/pricefx-logo.svg" height="64"/>
</div