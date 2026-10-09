# no-firework-in-combat
Server side mod to disable firework rocket interactions whilst in combat.

## Dependencies
The mod uses `isInCombat` method from
`com.example.combatlogmod.cooldown.CooldownManager`

From [combat-log-mod](https://modrinth.com/mod/combat-log-mod) (MIT).

## Bridge
The mod gets `isInCombat` by reflection instead of a compile dependency, 
this means you still need to manually add `combat-log-mod` to the server mods.

It passes a `IPlayer` proxy, carrying the player's UUID.