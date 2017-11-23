package br.data.entity;

import br.data.entity.Categoria;
import br.data.entity.Fornecedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-23T09:59:28")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Categoria> categoria;
    public static volatile CollectionAttribute<Produto, Fornecedor> fornecedorCollection;
    public static volatile SingularAttribute<Produto, Integer> idproduto;
    public static volatile SingularAttribute<Produto, String> descricao;

}