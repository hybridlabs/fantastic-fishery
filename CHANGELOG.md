# Changelog for [Fantastic Fishery](https://github.com/hybridlabs/fantastic-fishery)

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.1.2] 2026-11-24

- Now available for Minecraft 26.1.2.
- Biolith is no longer required.
- The Fungal Sea now generates in the deep ocean just off Mushroom Fields.

### Developer notes

- Biome placements are generated as Lithostitched biome injectors.
- The mycelial sand surface is a Lithostitched worldgen modifier.
- Fungal Sea’s old “adjacent to Mushroom Fields” criterion has no Lithostitched equivalent, so it is approximated by the deep-ocean continentalness band just off the Mushroom Fields band.

## [1.1.1] 2026-09-13

- Fixed NeoForge clients loading without Biolith, which is now required on both sides
- Fantastic Fishery is now also released on Modrinth
