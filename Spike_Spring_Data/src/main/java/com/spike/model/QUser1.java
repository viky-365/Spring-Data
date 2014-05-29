package com.spike.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import java.util.*;


/**
 * QUser1 is a Querydsl query type for QUser1
 */
public class QUser1 extends com.mysema.query.sql.RelationalPathBase<QUser1> {

    private static final long serialVersionUID = 1492446415;

    public static final QUser1 User1 = new QUser1("User1");

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("first_name");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastName = createString("last_name");

    public final StringPath score = createString("score");

    public final com.mysema.query.sql.PrimaryKey<QUser1> primary = createPrimaryKey(id);

    public QUser1(String variable) {
        super(QUser1.class, forVariable(variable), "null", "User1");
    }

    public QUser1(Path<? extends QUser1> entity) {
        super(entity.getType(), entity.getMetadata(), "null", "User1");
    }

    public QUser1(PathMetadata<?> metadata) {
        super(QUser1.class, metadata, "null", "User1");
    }

}

