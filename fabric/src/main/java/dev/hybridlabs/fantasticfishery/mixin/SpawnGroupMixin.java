package dev.hybridlabs.fantasticfishery.mixin;

import dev.hybridlabs.fantasticfishery.utils.FFSpawnGroup;
import net.minecraft.world.entity.MobCategory;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@SuppressWarnings("unused")
@Mixin(MobCategory.class)
public class SpawnGroupMixin {
    SpawnGroupMixin(String enumname, int ordinal, String name, int spawnCap, boolean peaceful, boolean rare, int immediateDespawnRange) {
        throw new AssertionError();
    }

    // Vanilla Spawn Groups array
    @Shadow
    @Mutable
    @Final
    private static MobCategory[] $VALUES;

    @Unique
    private static MobCategory createFantasticFisherySpawnGroup(String enumname, int ordinal, FFSpawnGroup spawnGroup) {
        SpawnGroupMixin groups = new SpawnGroupMixin(
                spawnGroup.name(), ordinal, spawnGroup.location.toString(),
                spawnGroup.spawnCap, spawnGroup.peaceful, spawnGroup.rare, spawnGroup.immediateDespawnRange
        );

        return (MobCategory) (Object) groups;
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/MobCategory;" +
            "$VALUES:[Lnet/minecraft/world/entity/MobCategory;", shift = At.Shift.AFTER, opcode = Opcodes.PUTSTATIC))
    private static void injectEnum(CallbackInfo ci) {
        int vanillaSpawnGroupsLength = $VALUES.length;
        
        FFSpawnGroup[] FFSpawnGroups = FFSpawnGroup.values();
        $VALUES = Arrays.copyOf($VALUES, vanillaSpawnGroupsLength + FFSpawnGroups.length);

        for (int i = 0; i < FFSpawnGroups.length; i++) {
            int pos = vanillaSpawnGroupsLength + i;
            FFSpawnGroup FFSpawnGroup = FFSpawnGroups[i];
            FFSpawnGroup.spawnGroup = $VALUES[pos] = createFantasticFisherySpawnGroup(FFSpawnGroup.name(), pos, FFSpawnGroup);
        }

        for (FFSpawnGroup value : FFSpawnGroups) {
            FFSpawnGroup.BY_NAME.put(value.location.toString(), value.spawnGroup);
        }
    }
}
