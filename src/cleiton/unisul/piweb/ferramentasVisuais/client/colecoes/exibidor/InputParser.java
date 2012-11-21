package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor;

public interface InputParser <Input extends Object, Output extends Object> {
	Output parse(Input input);
}
