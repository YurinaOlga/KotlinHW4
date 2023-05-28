import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addIdNotNull() {
         val post = WallService.add(Post(0,2,3,"la la la", 6,7,"open",true, true, true, Likes(10,true,true, false)))

         assertTrue(post.id !=0)
    }


   @Test
   fun updateTrueId() {
       val post = WallService.add(Post(1,2,3,"la la la", 6,7,"open",true, true, true, Likes(10,true,true, false)))
       val yesUpdate =  WallService.update(Post(1,2,3,"la la bla", 6,7,"open",true, true, true, Likes(10,true,true, false)))
       assertTrue (yesUpdate)
   }

    @Test
    fun updateFalseId() {
        val post = WallService.add(Post(1,2,3,"la la la", 6,7,"open",true, true, true, Likes(10,true,true, false)))
        val yesUpdate =  WallService.update(Post(2,2,3,"la la bla", 6,7,"open",true, true, true, Likes(10,true,true, false)))
        assertFalse (yesUpdate)
    }
}