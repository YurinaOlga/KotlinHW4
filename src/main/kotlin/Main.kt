
data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean)

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromID: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val postType: String,
    val friendsOnly: Boolean,
    val canPin: Boolean,
    val canDelete: Boolean,
    val likes: Likes
)


object WallService {
    private var posts = emptyArray<Post>()

    private var lastId = 0

    fun add (post: Post): Post {
        posts += post.copy(id=  ++lastId, likes = post.likes.copy() )
        return posts.last()
    }

    fun printPosts() {
        for (post in posts){
            println(post)
        }
        println()
    }

    fun update (newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(likes = post.likes.copy())
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }
}

fun main() {
    WallService.add(Post(1,2,3,"la la la", 6,7,"open",true, true, true, Likes(10,true,true, false)))
    WallService.add(Post(0,2,3,"bla la la", 6,7,"open",true, true, true ,  Likes(10,true,true, false)))
    WallService.printPosts()
    WallService.update(Post(1,2,3,"bla la bla !;-)", 6, 7, "close", true,true ,true, Likes(10,true,true, false)))
    WallService.printPosts()
    val upDate = WallService.update(Post(1150,2,3,"bla la bla !;-)", 6, 7, "close", true,true ,true, Likes(10,true,true, false)))
    println(upDate)
}