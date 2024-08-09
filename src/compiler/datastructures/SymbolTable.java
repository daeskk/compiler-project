package compiler.datastructures;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SymbolTable
{
	private Map<String, Symbol> symbolsMap = new HashMap<>();

	public void add(Symbol symbol) 
	{
		this.symbolsMap.put(symbol.getName(), symbol);
	}

	public Symbol get(String symbolName)
	{
		return this.symbolsMap.get(symbolName);
	}

	public Variable getVariable(String symbolName)
	{
		return (Variable) this.symbolsMap.get(symbolName);
	}
	
	public boolean exists(String symbolName)
	{
		return this.symbolsMap.containsKey(symbolName);
	}


}
