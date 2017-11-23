package br.data.entity;

import br.data.entity.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-23T09:59:28")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Integer> idcategoria;
    public static volatile CollectionAttribute<Categoria, Produto> produtoCollection;
    public static volatile SingularAttribute<Categoria, String> descricao;

}