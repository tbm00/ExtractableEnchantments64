package main.java.dev.rellox.spigot.extractableenchantments.extractor.extract;

import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract.ExtractFilter;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract.ExtractType;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract.IAccepted;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract.IExtract;

public record Extract(boolean unsafe, ExtractType type, ExtractFilter filter,
		IAccepted accepted) implements IExtract {}