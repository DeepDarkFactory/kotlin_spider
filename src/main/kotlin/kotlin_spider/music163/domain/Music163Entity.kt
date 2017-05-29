package kotlin_spider.music163.domain

import javax.persistence.*

@Entity
@Table(name = "music163")
class Music163Entity(
        val word: String,
        val count: Long,
        val singer: Long,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0)