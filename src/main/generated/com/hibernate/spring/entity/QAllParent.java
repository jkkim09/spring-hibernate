package com.hibernate.spring.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAllParent is a Querydsl query type for AllParent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAllParent extends EntityPathBase<AllParent> {

    private static final long serialVersionUID = -2046381000L;

    public static final QAllParent allParent = new QAllParent("allParent");

    public final NumberPath<Long> parent_id = createNumber("parent_id", Long.class);

    public final StringPath parent_name = createString("parent_name");

    public final ListPath<Team, QTeam> team = this.<Team, QTeam>createList("team", Team.class, QTeam.class, PathInits.DIRECT2);

    public final ListPath<User, QUser> user = this.<User, QUser>createList("user", User.class, QUser.class, PathInits.DIRECT2);

    public QAllParent(String variable) {
        super(AllParent.class, forVariable(variable));
    }

    public QAllParent(Path<? extends AllParent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAllParent(PathMetadata metadata) {
        super(AllParent.class, metadata);
    }

}

