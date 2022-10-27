import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallserviceTest {
    @Before
    fun clear() {
        WallService.dropPost()
    }

    @Test
    fun add() {
        //1. Arrange — подготовка данных (задание переменных).
        val id = 1
        val content = "asdsad"
        val authorName = "almaz"
        val authorid = 1
        val likes = 1
        val comment = null
        val isPinned = false
        val post =
            Post(
                id = id,
                content = content,
                authorName = authorName,
                authorid = authorid,
                likes = likes,
                comment = comment,
                isPinned = isPinned
            )

        //2.Act — выполнение целевого действия (вызов функции).
        val createdPost = WallService.add(post)

        //3.Assert — сравнение ожидаемого результата с фактическим.
        assertNotEquals(0, createdPost.id)
    }

    @Test
    fun update_existingPost() {
        //1. Arrange — подготовка данных (задание переменных).
        val id = 1
        val content = "asdsad"
        val authorName = "almaz"
        val authorid = 1
        val likes = 1
        val comment = null

        val isPinned = false
        val post =
            Post(
                id = id,
                content = content,
                authorName = authorName,
                authorid = authorid,
                likes = likes,
                comment = comment,
                isPinned = isPinned
            )

        val updId = 1
        val updContent = "asdsad"
        val updAuthorName = "almazzzup"
        val updAuthorid = 1
        val updLikes = 1
        val updComment = null

        val updIsPinned = false
        val updatingPost =
            Post(
                id = updId,
                content = updContent,
                authorName = updAuthorName,
                authorid = updAuthorid,
                likes = updLikes,
                comment = updComment,
                isPinned = updIsPinned
            )

        WallService.add(post)
        val result = WallService.update(updatingPost)

        assertEquals(true, result)
    }

    @Test
    fun updateNotExistingPost() {
        //1. Arrange — подготовка данных (задание переменных).
        val id = 1
        val content = "asdsad"
        val authorName = "almaz"
        val authorid = 1
        val likes = 1
        val comment = null

        val isPinned = false
        val post =
            Post(
                id = id,
                content = content,
                authorName = authorName,
                authorid = authorid,
                likes = likes,
                comment = comment,

                isPinned = isPinned
            )

        val updId = 111
        val updContent = "asdsad"
        val updAuthorName = "almazzzup"
        val updAuthorid = 1
        val updLikes = 1
        val updComment = null

        val updIsPinned = false
        val updatingPost =
            Post(
                id = updId,
                content = updContent,
                authorName = updAuthorName,
                authorid = updAuthorid,
                likes = updLikes,
                comment = updComment,
                isPinned = updIsPinned
            )

        WallService.add(post)
        val result = WallService.update(updatingPost)

        assertEquals(false, result)
    }

    @Test
    fun createCommentExistsPost() {
        WallService.add(Post(1, "Test content"))

        val comment1 = Comment(
            1,
            1,
            666,
            3666,
            "text comment 1dddddd"

        )

        WallService.createComment(comment1)
        val results = WallService.createComment(comment1)
        assertEquals(true, results)
    }
    @Test
        (expected = PostIdNotFoundException::class)
    fun createCommentNotExistsPost() {
        WallService.add(Post(1, "Test content"))

        val comment1 = Comment(
            1,
            888,
            666,
            3666,
            "text comment 1dddddd"

        )

        WallService.createComment(comment1)
    }
}



