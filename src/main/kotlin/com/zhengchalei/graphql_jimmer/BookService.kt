package com.zhengchalei.graphql_jimmer

import graphql.schema.DataFetchingEnvironment
import org.babyfish.jimmer.Page
import org.babyfish.jimmer.spring.graphql.toFetcher
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.babyfish.jimmer.sql.kt.ast.expression.eq
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller


@Controller
class BookService(private val sqlClient: KSqlClient) {

    @QueryMapping
    fun bookById(@Argument id: Long): Book {
        return this.sqlClient.createQuery(Book::class) {
            where(table.id eq id)
            select(table)
        }.fetchOne()
    }

    @QueryMapping
    fun books(env: DataFetchingEnvironment): Page<Book> {
        return this.sqlClient.createQuery(Book::class) {
            select(table.fetch(env.toFetcher()))
        }.fetchPage(0, 10)
    }
}