package com.hibernate.spring.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserService is a Querydsl query type for UserService
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserService extends EntityPathBase<UserService> {

    private static final long serialVersionUID = 856161207L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserService userService = new QUserService("userService");

    public final NumberPath<Long> service_id = createNumber("service_id", Long.class);

    public final StringPath service_name = createString("service_name");

    public final QTeam Team;

    public final QUser user;

    public QUserService(String variable) {
        this(UserService.class, forVariable(variable), INITS);
    }

    public QUserService(Path<? extends UserService> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserService(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserService(PathMetadata metadata, PathInits inits) {
        this(UserService.class, metadata, inits);
    }

    public QUserService(Class<? extends UserService> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.Team = inits.isInitialized("Team") ? new QTeam(forProperty("Team")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

