package compiler.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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

	public void iterate()
	{
		symbolsMap.keySet().forEach(x -> System.out.println(symbolsMap.get(x)));
	}

	public List<Variable> generateList()
	{
		return new ArrayList<>(symbolsMap.keySet().stream().map(x -> (Variable) this.symbolsMap.get(x)).toList());
	}

	public List<Variable> generateUninitializedList()
	{
		return this.generateList().stream().filter(x -> !x.isInitialized()).toList();
	}
	
	public boolean exists(String symbolName)
	{
		return this.symbolsMap.containsKey(symbolName);
	}


}
