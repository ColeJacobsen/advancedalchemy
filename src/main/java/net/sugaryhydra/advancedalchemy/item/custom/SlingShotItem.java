package net.sugaryhydra.advancedalchemy.item.custom;

import net.minecraft.server.level.ServerLevel;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Projectile;

import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownLingeringPotion;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;


import java.util.function.Predicate;

public class SlingShotItem extends BowItem {
    public SlingShotItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles()
    {
        Predicate<ItemStack> SPLASH_POTIONS = (itemStack) -> itemStack.is(Items.SPLASH_POTION);
        Predicate<ItemStack> THROWABLE_POTIONS = SPLASH_POTIONS.or((itemStack) -> itemStack.is(Items.LINGERING_POTION));
        return THROWABLE_POTIONS;
    }

    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack projectile, boolean isCrit) {
        if (level instanceof ServerLevel serverLevel)
        {
            if (projectile.is(Items.SPLASH_POTION))
            {
                Projectile ammo = Projectile.spawnProjectileFromRotation(ThrownSplashPotion::new, serverLevel, projectile, shooter, -20.0F, 0.5F, 1.0F);
                projectile.consume(1, shooter);
                return ammo;
            }
            else
            {
                Projectile ammo = Projectile.spawnProjectileFromRotation(ThrownLingeringPotion::new, serverLevel, projectile, shooter, -20.0F, 0.5F, 1.0F);
                projectile.consume(1, shooter);
                return ammo;
            }

        }

        return null;
    }
}
