package main.java.dev.rellox.spigot.extractableenchantments.extractor;

import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IChanceOverride;

public record ChanceOverride(boolean enabled, int value) implements IChanceOverride {}
