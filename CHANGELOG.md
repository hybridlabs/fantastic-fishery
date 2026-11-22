# Changelog for [Fantastic Fishery](https://github.com/hybridlabs/fantastic-fishery)

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

- Removed dependency on Biolith; biome placement and surface rules now go through Lithostitched

<details>
<summary>Developer notes</summary>

- Replaced Biolith with Lithostitched: biome placements are `lithostitched:replace_partially` biome
  injectors and the mycelial sand surface is a `lithostitched:add_surface_rule` worldgen modifier.
  Fungal Sea's "adjacent to Mushroom Fields" placement (a Biolith neighbour criterion) has no Lithostitched
  equivalent, so it is approximated by the deep-ocean continentalness band just off the Mushroom Fields band.

</details>

## [1.1.1] 2026-09-13

- Fixed NeoForge clients loading without Biolith, which is now required on both sides
- Fantastic Fishery is now also released on Modrinth
