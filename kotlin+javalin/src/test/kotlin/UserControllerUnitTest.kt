import app.user.User
import app.user.UserController
import io.javalin.http.Context
import io.javalin.http.HttpCode.CREATED
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class UserControllerUnitTest {

    private val ctx = mockk<Context>(relaxed = true)

    @Test
    fun `POST to create a user and gives 201 with success`() {
        every { ctx.bodyAsClass<User>() } returns User("Lourran Teste", "teste@mail.com", 0)
        UserController().create(ctx)
        verify { ctx.status(CREATED)}
    }

}