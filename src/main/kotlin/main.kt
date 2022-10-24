import java.time.LocalDateTime

data class Post(
    val id: Int,
    val content: String?,
    val authorName: String? = null,
    val authorid: Int? = null,
    val likes: Int? = null,
    val comment: Comment? = null,
    val isPinned: Boolean? = false,


    val date : Int? = null,
    val fromId : Int? = null,
    val createdBy : Int? = null,
    val replyOwnerId : Int? = null,
    val replyPostId : Int? = null,
    val friendsOnly : Boolean? = false,
    val postType : String? = null,
    val signerId : Int? = null,
    val canPin : Boolean? = false,
    val canDelete : Boolean? = false,
    val canEdit : Boolean? = false,
    val markedAsAds : Boolean? = false,
    val isFavorite : Boolean? = false,
    val postponedId : Int? = null,

    val copyright : Copyright? = null,
    val reposts : Reposts? = null,
    val views : Views? = null,
    val postSource : PostSource? = null,
    val geo : Geo? = null,
    val donut : Donut? = null,
    val attachments : Array<Attachment>? = emptyArray(),

)

data class Comment(
    var commentID: Int,
    var commentAuthorName: String,
    var commentContent: String,
)

data class Copyright(
    val id : Long,
    val link : String,
    val name : String,
    val type : String
)

data class Reposts(
    val count : Long,
    val userReposted : Boolean
)

data class Views(
    val count : Long
)

data class PostSource(
    val type : String,

    val platgorm : String,


    val data : String,

    val url : String
)

data class Geo(
    val type : String,
    val coordinates : String,
    val place : Place? = null
)

data class Donut(
    val isDonut : Boolean,
    val paidDuration : Int,
    val placeholder : String,
    val canPublishFreeCopy : Boolean,
    val editMode : String
)

data class Place(
    val id : Int, // идентификатор места
    val title : String, // название места
    val latitude : Int, // географическая широта, заданная в градусах (от -90 до 90)
    val longitude : Int, // integer	географическая широта, заданная в градусах (от -90 до 90)
    val created : Int, // дата создания места в Unixtime
    val icon : String, // иконка места, URL изображения
    val checkins : Int, // число отметок в этом месте
    val updated : Int, // дата обновления места в Unixtime
    val type : Int, // тип места
    val country : Int, // идентификатор страны
    val city : Int, // идентификатор города
    val address : String // адрес места
)

interface Attachment {
    val type: String
}

data class Audio(
    val id : Int? = null, // Идентификатор аудиозаписи.
    val owner_id : Int? = null, // Идентификатор владельца аудиозаписи.
    val artist : String? = null, // Исполнитель
    val title : String? = null, // Название композиции
    val duration : Int? = null, // Длительность аудиозаписи в секундах
    val url : String? = null, // Ссылка на mp3.
    val lyrics_id : Int? = null, // Идентификатор текста аудиозаписи (если доступно).
    val album_id : Int? = null, // Идентификатор альбома, в котором находится аудиозапись (если присвоен).
    val genre_id : Int? = null,// Идентификатор жанра из списка аудио жанров.
    val date : Int? = null, // Дата добавления.
    val no_search : Int? = null, // 1, если включена опция «Не выводить при поиске». Если опция отключена, поле не возвращается.
    val is_hq : Int? = null, // 1, если аудио в высоком качестве.
)
data class Image(
    val height : Int, //Высота изображения.
    val url : String, // Ссылка на изображение
    val width : Int, // Ширина изображения
    val withPadding : Int = 1 // Поле возвращается, если изображение с отбивкой, всегда содержит 1.
)
data class Video(
    val id : Int? = null, //	Идентификатор видеозаписи
    val owneId : Int? = null, // Идентификатор владельца видеозаписи
    val title : String? = null, // Название видеозаписи
    val description : String? = null, // Текст описания видеозаписи
    val duration : Int? = null, // Длительность ролика в секундах
    val image : Array<Image>? = emptyArray<Image>(), // Изображение обложки
    val firstFrame : Array<Image>? = emptyArray<Image>(), // Изображение первого кадра
    val date : Int? = null, // Дата создания видеозаписи в формате Unixtime
    val adding_date : Int? = null, // Дата добавления видеозаписи пользователем или группой в формате Unixtime.
    val views : Int? = null, //	Количество просмотров видеозаписи
    val localViews : Int? = null, // Если видео внешнее, количество просмотров в ВК
    val comments : Int? = null, // Количество комментариев к видеозаписи
    val player : String? = null, // URL страницы с плеером, который можно использовать для воспроизведения ролика в браузере. Поддерживается flash и html5, плеер всегда масштабируется по размеру окна.
    val platform : String? = null, // Название платформы (для видеозаписей, добавленных с внешних сайтов)
    val canAdd : Boolean? = false, // Может ли пользователь добавить видеозапись к себе, true может
    val isPrivate : Boolean ? = false, // Поле возвращается, если видеозапись приватная (например, была загружена в личное сообщение), всегда содержит 1.
    val accessKey : String? = null, // Ключ доступа к объекту. Подробнее см. Ключ доступа к данным access_key.
    val processing : Boolean? = false, // Поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1.
    val isFavorite : Boolean? = false, // true, если объект добавлен в закладки у текущего пользователя.
    val canComment : Boolean? = false, // Может ли пользователь комментировать видео. true может
    val canEdit : Boolean? = false, // Может ли пользователь редактировать видео, true может
    val canLike : Boolean? = false, // Может ли пользователь добавить видео в список <<Мне нравится>>, true может
    val canRepost : Boolean? = false, // Может ли пользователь сделать репост видео, true может
    val canSubscribe : Boolean? = false, // Может ли пользователь подписаться на автора видео, true может
    val canAddToFaves : Boolean? = false, // Может ли пользователь добавить видео в избранное. true может
    val canAttachLink : Boolean? = false, // Может ли пользователь прикрепить кнопку действия к видео.  true может
    val width : Int? = null, // Ширина видео
    val height : Int? = null, // Высота видео
    val userId : Int? = null, // Идентификатор пользователя, загрузившего видео, если оно было загружено в группу одним из участников
    val converting : Boolean? = false, // Конвертируется ли видео, true - да
    val added : Boolean? = false, // Добавлено ли видео в альбомы пользователя, true - да
    val isSubscribed : Boolean? = false, // Подписан ли пользователь на автора видео.true - да
    val repeat : Int? = null, // Поле возвращается в том случае, если видео зациклено, всегда содержит 1
    val type : String? = null, // Тип видеозаписи. Может принимать значения: "video", "music_video", "movie".
    val balance : Int? = null, // Баланс донатов в прямой трансляции.
    val live_status : String? = null, // Статус прямой трансляции. Может принимать значения: "waiting", "started", "finished", "failed", "upcoming".
    val live : Boolean? = false, // Поле возвращается в том случае, если видеозапись является прямой трансляцией, всегда содержит 1. Обратите внимание, в этом случае в поле duration содержится значение 0.
    val upcoming : Boolean? = false, // Поле свидетельствует о том, что трансляция скоро начнётся
    val spectators : Int? = null, // Количество зрителей прямой трансляции


)

data class Gift(
    val id : Int? = null, // Идентификатор подарка.
    val thumb_256 : String? = null, // URL изображения 256x256px.
    val thumb_96 : String? = null, // URL изображения 96x96px.
    val thumb_48 : String? = null // URL изображения 48x48px.
)
data class Sizes(
    val type : String? = null, // тип копии. См. Формат описания размеров фотографии.
    val url : String? = null, // URL копии.
    val width : Int? = null, // высота в px.
    val height : Int? = null // ширина в px.
)
data class Photo(
    val id : Int? = null, // Идентификатор фотографии.
    val albumId : Int? = null, // Идентификатор альбома, в котором находится фотография.
    val ownerId : Int? = null, // Идентификатор владельца фотографии.
    val userId : Int? = null, // Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе). Для фотографий, размещенных от имени сообщества, user_id = 100.
    val text : String? = null, // Текст описания фотографии.
    val date : Int? = null, // Дата добавления в формате Unixtime.
    val sizes : Array<Sizes> = emptyArray(),
    val width : Int? = null, // Ширина оригинала фотографии в пикселах.
    val height : Int? = null // Высота оригинала фотографии в пикселах.
)
class AudioAttachment(contentParam : Audio) : Attachment {
    override val type: String = "audio"
    val audio = contentParam
    override fun toString() : String{
        return "\n  $audio"
    }
}
class VideoAttachment(contentParam : Video) : Attachment {
    override val type: String = "video"
    val video = contentParam

    override fun toString() : String{
        return "\n  $video"
    }

}
class GiftAttachment(contentParam : Gift) : Attachment {
    override val type: String = "gift"
    val gift = contentParam

    override fun toString() : String{
        return "\n  $gift"
    }
}
class PhotoAttachment(contentParam : Photo) : Attachment {
    override val type: String = "photo"
    val photo = contentParam

    override fun toString() : String{
        return "\n  $photo"
    }
}
object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = getLastPostId() + 1)
        println("Post added: ${posts.last()}")
        return posts.last()
    }

    fun getLastPostId(): Int {
        return if (posts.isEmpty()) 0 else posts.last().id
    }

    fun printArray(i: Int) {
        println(posts.get(i))
    }

    fun dropPost() {
        posts = emptyArray<Post>()
    }



    fun update(post: Post): Boolean {
        var postUpdating = false
        for ((idx, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[idx] = currentPost.copy(
                    id = post.id,
                    content = post.content,
                    authorName = post.authorName,
                    authorid = post.authorid,
                    likes = post.likes,
                    comment = post.comment,
                    isPinned = post.isPinned,

                    date = post.date ,
                    fromId = post.fromId ,
                    createdBy = post.createdBy ,
                    replyOwnerId = post.replyOwnerId ,
                    replyPostId = post.replyPostId ,
                    friendsOnly = post.friendsOnly ,
                    postType = post.postType ,
                    signerId = post.signerId ,
                    canPin = post.canPin ,
                    canDelete = post.canDelete ,
                    canEdit = post.canEdit ,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite ,
                    postponedId = post.postponedId,

                    copyright = post.copyright,
                    reposts = post.reposts,
                    views = post.views,
                    postSource = post.postSource,
                    geo = post.geo,
                    donut = post.donut,
                    attachments=post.attachments
                )
                postUpdating = true
                println("Updating post with id ${post.id}: ${posts[idx]}")
            }
        }
        return postUpdating
    }
}

fun main() {
    WallService.add(Post(1, "Test content"))
    WallService.add(Post(2, "Test content1"))
    WallService.add(Post(3, "Test content2"))
    WallService.printArray(2)

    WallService.update(Post(2, "uzzzzzzzzzzz", "Vasiliy"))
}


//class WallService {
//
//    fun invoke(): Post {
//
//        var comment1 = Comment(1,"ZloyAlmaz","NONONO")
//        var post1 = Post(1,2,"Almaz","axaxa",89,comment1,false
//        ,LocalDateTime.now(),LocalDateTime.of(2022,12,10,14,5),false)
//        print(post1.toString())
//         return post1
//    }
//
//
//    private var posts = emptyArray<Post>()
//
//    fun add(post: Post): Post {
//        posts += post.copy(id = getLastPostId() + 1)
//        println("Post added: ${posts.last()}")
//        return posts.last()
//    }
//
//    }
//    fun printArray (i: Int) {
//        println(posts.get(i))
//    }
//    fun getLastPostId(): Int {
//        return if (posts.isEmpty()) 0 else posts.last().id
//    }
//
//}