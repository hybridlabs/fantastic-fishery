# Changelog for [Fantastic Fishery](https://github.com/hybridlabs/fantastic-fishery)

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

- Updated to Minecraft 26.2

<details>
<summary>Developer notes</summary>

- Migrated to GeckoLib 5: models and renderers are driven by render states, and GeckoLib assets
  moved to `assets/<namespace>/geckolib/{models,animations}`
- Items set their registry id before construction, as required since 1.21.5
- Updated entity save data, damage handling and block state APIs to 1.21.11

</details>

## [1.1.1] 2026-09-13

- Fixed NeoForge clients loading without Biolith, which is now required on both sides
- Fantastic Fishery is now also released on Modrinth
