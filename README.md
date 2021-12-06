<div align="center">
    <div align="center">
        <img src="https://pricefx.vercel.app/pricefx-logo.svg" height="64"/>
    </div>
    <h1>Pricefx Starter Project</h1>
</div>

<div align="center">

[![Pricefx Developer Portal](https://pricefx.vercel.app/badges/developer-portal.svg)](https://pricefx.vercel.app)
[![Pricefx Documentation](https://pricefx.vercel.app/badges/documentation.svg)](https://pricefx.atlassian.net/wiki/spaces/KB/overview)
[![Test & Deploy](https://github.com/pricefx/pricefx-starter/actions/workflows/main.yml/badge.svg?branch=develop)](https://github.com/pricefx/pricefx-starter/actions/workflows/main.yml)
[![issues - pricefx-starter](https://img.shields.io/github/issues/pricefx/pricefx-starter)](https://github.com/pricefx/pricefx-starter/issues)

</div>

Use this project as a template to initialize new Pricefx projects. The `pricefxSrc/` module contains source code for a very basic Pricefx configuration project that will help you to get started with development for the Pricefx Platform.

## How to use

Simply download a copy of the project and remove the files that you deem unnecessary. 

### CI/CD

To set up your CI/CD pipelines and integrate with an existing partition, you will have to configure some environment variables:

* `PRICEFX_URL`
* `PRICEFX_PARTITION`
* `PRICEFX_USERNAME`
* `PRICEFX_PASSWORD`

## Pricefx Stream Maven Plugin

The Pricefx Stream plugin allows you to fetch/deploy/delete data from/to/on your Pricefx partition. Learn how to set up a maven profile [here](https://pricefx.atlassian.net/wiki/spaces/KB/pages/3808002411/Add+to+Project).
