package br.edu.cruzeirodosul.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "FAQ_DUVIDAS",
        schema = "ACD",
                uniqueConstraints = {@UniqueConstraint(columnNames = {"COD_EMPR", "ID_SETOR", "ID_USUARIO"})})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FaqDuvidas{
   
	@Id
    @Column(name = "ID_FAQ_DUVIDAS")
    @SequenceGenerator(name = "ACD.SEQ_FAQ_DUVIDAS", sequenceName = "ACD.SEQ_FAQ_DUVIDAS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACD.SEQ_FAQ_DUVIDAS")
	private long idFaqDuvidas;
	
    @Column(name = "RESUMO")
    private String resumo;    

    @Column(name = "COD_EMPR")
    private Integer codEmpr;    
     
    @Column(name = "ID_SETOR")
    private Integer idSetor;    
    
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;   
    
    @Column(name = "PERGUNTA")
    private String pergunta;    
    
    @Column(name = "RESPOSTA")
    private String resposta;
    
    @Column(name = "FREQUENCIA")
    private Integer frequencia;    

}
