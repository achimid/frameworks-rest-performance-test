package app.user

import io.javalin.http.Context
import io.javalin.http.HttpCode
import org.koin.core.component.KoinComponent

val users = ArrayList<User>()

class UserController : KoinComponent {

    fun create(ctx: Context) {
        users.add(ctx.bodyAsClass<User>())
        ctx.status(HttpCode.CREATED)
    }

    fun retrieve(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        ctx.json(users[id])
    }

    fun listAll(ctx: Context) {
        ctx.json(users)
    }

    fun update(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        users[id] = ctx.bodyAsClass<User>()
        ctx.status(HttpCode.OK)
    }

    fun remove(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        users.removeAt(id)
        ctx.status(HttpCode.NOT_FOUND)
    }

}