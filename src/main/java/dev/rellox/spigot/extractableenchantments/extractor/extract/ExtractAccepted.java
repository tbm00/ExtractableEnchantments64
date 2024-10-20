package main.java.dev.rellox.spigot.extractableenchantments.extractor.extract;

import java.util.Set;

import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract.IAccepted;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract.IIgnoredEnchantment;

public record ExtractAccepted(Set<IIgnoredEnchantment> ignored, boolean invert) implements IAccepted {}