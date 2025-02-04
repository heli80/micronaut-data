/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.r2dbc.oraclexe;

import io.micronaut.data.annotation.Expandable;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.tck.entities.Book;
import io.micronaut.data.tck.repositories.BookRepository;

import io.micronaut.core.annotation.Nullable;
import java.util.Collection;
import java.util.List;

@R2dbcRepository(dialect = Dialect.ORACLE)
public abstract class OracleXEBookRepository extends BookRepository {
    public OracleXEBookRepository(OracleXEAuthorRepository authorRepository) {
        super(authorRepository);
    }

    @Query(value = "select * from book b where b.title = any (:arg0)", nativeQuery = true)
    public abstract List<Book> listNativeBooksWithTitleAnyCollection(@Nullable Collection<String> arg0);

    @Query(value = "select * from book b where b.title = ANY (:arg0)", nativeQuery = true)
    public abstract List<Book> listNativeBooksWithTitleAnyArray(@Expandable @TypeDef(type = DataType.STRING) @Nullable String[] arg0);

}
