package br.data.entity;

import br.data.entity.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-23T09:59:28")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile SingularAttribute<Fornecedor, Integer> idfornecedor;
    public static volatile SingularAttribute<Fornecedor, String> nome;
    public static volatile CollectionAttribute<Fornecedor, Produto> produtoCollection;

}