# mizuho 水穂 — Maturity

**Stage: R0** (scaffold) — ADR-2605263100. Community-scale water + sanitation substrate
(≠ mitsuho 瑞穂 food). No bottled water, no mandatory fluoridation, waqf-inalienable sources.

| Dimension | State |
|---|---|
| Lexicons | ✅ 5 canonical EDN under `data/lex`; JSON snapshots isolated under `wire/lex` |
| Manifest | ✅ canonical `manifest.edn`, gates G1–G12 |
| Runtime | ✅ standalone CLJC under `src/mizuho`; Python/Go/TinyGo pruned |
| Tests | ✅ `kbb -M:test` — **39 tests / 181 assertions / 0 failures** (2026-07-18) |
| Audit | ✅ EDN parse + wire boundary + deprecated-artifact audit |

## Gates pinned
- G5 const bottledWaterUnitsDistributed=0 · G6 const fluoridationAdditionAttested=false.
- G11 source const waqfInalienabilityAttested=true (silen 100%).
- G12 operatorVocationFlow=100% · G4 commercialUtilitySoftware=0.
- G3 waterQuality requires whoLimit + overallComplianceStatus (non-compliant-critical-halt).
- wastewater under jurisdictionalPermitCid + permitCompliant; contamination notifiedAtUtc + severity.

> **2026-07-18 standalone migration:** the actor-owned implementation and contracts were
> removed from monorepo path assumptions. Lexicons are now EDN canonical, wire JSON is
> isolated, and Python subprocess parity was replaced by deterministic CLJC invariant tests.
