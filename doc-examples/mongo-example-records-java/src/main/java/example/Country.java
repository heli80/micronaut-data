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
package example;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import org.bson.types.ObjectId;

import java.util.Set;

// tag::country[]
@MappedEntity // <1>
public record Country(
    @Id
    ObjectId id, // <2>
    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "country")
    Set<CountryRegion> regions, // <3>
    String name // <4>
) {}
// end::country[]