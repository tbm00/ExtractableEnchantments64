package main.java.dev.rellox.spigot.extractableenchantments.dust;

import java.util.Set;

import main.java.dev.rellox.spigot.extractableenchantments.api.dust.IApplicable;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IExtractor;

public record Applicable(Set<IExtractor> extractors, boolean books) implements IApplicable {}