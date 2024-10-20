package main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract;

public interface IExtract {
	
	boolean unsafe();
	
	ExtractType type();
	
	ExtractFilter filter();
	
	IAccepted accepted();

}
