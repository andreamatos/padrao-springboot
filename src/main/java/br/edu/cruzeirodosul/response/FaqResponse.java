package br.edu.cruzeirodosul.response;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class FaqResponse implements Serializable {
    private static final long serialVersionUID = -7915490910334683039L;

    private String resumo;
    private Integer codEmpr;
    private Integer idUsuario;
    private String pergunta;
    private String resposta;
    private Integer frequencia;
    
	public FaqResponse(String resumo, Integer codEmpr, Integer idUsuario, String pergunta, String resposta,
			Integer frequencia) {
		super();
		this.resumo = resumo;
		this.codEmpr = codEmpr;
		this.idUsuario = idUsuario;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.frequencia = frequencia;
	}
}
