package com.zhengchalei.graphql_jimmer

import org.babyfish.jimmer.sql.*

@Entity
@Table(name = "book")
interface Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long

    val name: String
}